package cn.wj.ssm.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
public class Orders {
    private String id;
    private String orderNum;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;        //产品
    private List<Traveller> travellers;     //游客
    private Member member;          //会员
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;
    //用于添加订单时，添加产品，会员
    private Integer productId;
    private Integer memberId;


    public String getOrderTimeStr() {
       if(orderTime != null){
           // 对日期格式化
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
           orderTimeStr =  dateFormat.format(orderTime);
       }
           return orderTimeStr;
    }

    public String getPayTypeStr() {
        if (payType == 0){
            payTypeStr = "支付宝";
        } else if(payType == 1){
            payTypeStr = "微信";
        }else if(payType == 2){
            payTypeStr = "其他";
        }
        return payTypeStr;
    }


    public String getOrderStatusStr() {
        if (orderStatus == 0){
            orderStatusStr = "未支付";
        } else if(orderStatus == 1){
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }
}