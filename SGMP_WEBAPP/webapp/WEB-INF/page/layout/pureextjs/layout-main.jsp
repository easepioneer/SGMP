<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/layout/pureextjs/include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/page/layout/pureextjs/include/metas.jsp" %>
<title>${title_system}</title>
<%@ include file="/WEB-INF/page/layout/pureextjs/include/links.jsp" %>
<style type="text/css">
* { 
    font-family: "宋体"; font-size: 12px!important;
}

h1 {
    float: left;
    margin: 7px;
    font-size: 36px!important;
    font-weight: bolder;
    font-family: "宋体";
}

h2 {
    float: left;
    margin: 16px 10px;
    font-size: 26px!important;
    font-weight: bold;
    font-family: "宋体";
}

p {
    margin: 5px;
}

.function {
    background-image: url(${ctx_webstatic}/style/default/img/icons/application_go.png);
}

.selection {
    background-image: url(${ctx_webstatic}/style/default/img/icons/application_view_list.png);
}

.setting {
    background-image: url(${ctx_webstatic}/style/default/img/icons/folder_wrench.png);
}

.reading {
    background-image: url(${ctx_webstatic}/style/default/img/icons/folder_go.png);
}
</style>
<%@ include file="/WEB-INF/page/layout/pureextjs/include/scripts.jsp" %>

</head>
<body>
Layout Main
</body>
</html>