package cn.wj.ssm.controller;

import cn.wj.ssm.pojo.SysLog;
import cn.wj.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect     //表示这是一个增强类
public class LogAopAspect {
    //创建一个访问日志的切面类，交给spring管理

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private Date visitTime; //开始时间
    private Class clazz; //访问的类
    private Method method;//访问的方法

    //前置通知  主要是获取开始时间，执行的类是哪一个，执行的是哪一个方法  JoinPoint程序执行过程中明确的点
    @Before("execution(* cn.wj.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp){

        visitTime = new Date();//当前时间就是开始访问的时间

        clazz = jp.getTarget().getClass(); //具体要访问的类

        String methodName = jp.getSignature().getName(); //获取访问的方法的名称

        Object[] args = jp.getArgs();//获取访问的方法的参数

        //获取具体执行的方法的Method对象
        if (args == null || args.length == 0) {
            try {
                method = clazz.getMethod(methodName); //只能获取无参数的方法
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else {

            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();

                /*如果你是用Model写入的数据，需要手动判断*/
                if(args[i] instanceof Model){
                    classArgs[i] = Model.class;
                }else if(args[i] instanceof RedirectAttributes){
                    classArgs[i] = RedirectAttributes.class;
                }else{
                    classArgs[i] = args[i].getClass();
                }
            }

            //methodName方法名  classArgs参数名
            try {
                method = clazz.getMethod(methodName, classArgs);  //获取有参数的方法
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
    }

    //后置通知
    @After("execution(* cn.wj.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {

        long time = new Date().getTime() - visitTime.getTime(); //获取访问的时长

        String url = "";

        //获取url
        if (clazz != null && method != null && clazz != LogAopAspect.class) {
            //1.获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping("findAll")
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + "/" +methodValue[0];

                    //获取访问的ip
                    String ip = request.getRemoteAddr();
                    ip=ip.equals("0:0:0:0:0:0:0:1")  ?  "10.31.134.236" : ip;

                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获了当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time); //执行时长
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime); //访问时间

                    //调用Service完成操作
                    sysLogService.save(sysLog);
                }
            }
        }

    }
}