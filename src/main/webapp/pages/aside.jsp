<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<aside class="main-sidebar">

    <section class="sidebar">
        <!-- 侧边用户面版 -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user9.png"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>
                </p>
                <a href="#"><i class="fa fa-circle text-success"></i>
                    <%--显示用户名--%>
                    <security:authentication property="principal.username"/>
                    在线</a>
            </div>
        </div>

        <!-- 侧边菜单 -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index">
                <a href="${pageContext.request.contextPath}/index.jsp">
                    <i class="fa fa-dashboard"></i>
                    <span>首页</span>
                </a>
            </li>

            <%--系统管理--%>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-cogs"></i>
                    <span>系统管理</span> <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>

                <ul class="treeview-menu">
                    <li id="system-setting1">
                        <security:authorize access="hasRole('ADMIN')">
                            <a href="${pageContext.request.contextPath}/user/findAll.do?page=1&size=5">
                                <span class="glyphicon glyphicon-object-align-bottom"></span>  用户管理
                            </a>
                        </security:authorize>
                    </li>
                    <li id="system-setting2">
                        <security:authorize access="hasRole('ADMIN')">
                            <a href="${pageContext.request.contextPath}/role/findAll.do?page=1&size=5">
                                <span class="glyphicon glyphicon-object-align-bottom"></span> 角色管理
                            </a>
                        </security:authorize>
                    </li>
                    <li id="system-setting3">
                        <security:authorize access="hasRole('ADMIN')">
                            <a href="${pageContext.request.contextPath}/permission/findAll.do?page=1&size=5">
                                <span class="glyphicon glyphicon-object-align-bottom"></span>  资源权限管理
                            </a>
                        </security:authorize>
                    </li>
                    <li id="system-setting4">
                        <security:authorize access="hasRole('ADMIN')">
                            <a href="${pageContext.request.contextPath}/sysLog/findAll.do?page=1&size=5">
                                <span class="glyphicon glyphicon-object-align-bottom"></span>  访问日志
                            </a>
                        </security:authorize>
                    </li>
                </ul>
            </li>

            <%--基础数据--%>
            <li class="treeview">

                <a href="#">
                    <i class="fa fa-cube"></i>
                    <span>基础数据</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>

                <ul class="treeview-menu">
                    <li id="system-setting5">
                        <security:authorize access="hasRole('USER')">
                            <a href="${pageContext.request.contextPath}/product/findAll.do?page=1&size=5">
                              <span class="glyphicon glyphicon-object-align-bottom"></span>  产品管理
                            </a>
                        </security:authorize>
                    </li>
                    <li id="system-setting6">
                        <security:authorize access="hasRole('USER')">
                            <a href="${pageContext.request.contextPath}/order/findAll.do?page=1&size=5">
                                <span class="glyphicon glyphicon-object-align-bottom"></span> 订单管理
                            </a>
                        </security:authorize>
                    </li>
                </ul>
            </li>
        </ul>

    </section>

</aside>
