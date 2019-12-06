<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="the.best.config.ParamAttrConfig"%>
<%@ page import="the.best.config.UrlConfig"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<nav>
    <div class="nav-wrapper teal darken-1">
        <a href="<%=UrlConfig.ORDER%>" class="brand-logo">TESLA</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
           <li>
                <a href="?<%=ParamAttrConfig.LOCALE%>=uk"><fmt:message key="navbar.uk"/></a>
           </li>
           <li>
                <a href="?<%=ParamAttrConfig.LOCALE%>=en"><fmt:message key="navbar.en"/></a>
           </li>
           <li>
                <c:choose>
                    <c:when test="${not empty user}">
                    <a href="<%=UrlConfig.LOGOUT%>"><fmt:message key="log_out"/></a>
                    </c:when>
                    <c:otherwise>
                        <a href="<%=UrlConfig.LOGIN%>"><fmt:message key="log_in"/></a>
                    </c:otherwise>
                </c:choose>
           </li>
        </ul>
     </div>
</nav>