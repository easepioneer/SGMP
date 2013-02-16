<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/layout/purejquery/include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/page/layout/purejquery/include/metas.jsp" %>
<title>${title_system}</title>
<%@ include file="/WEB-INF/page/layout/purejquery/include/links.jsp" %>
<%@ include file="/WEB-INF/page/layout/purejquery/include/scripts.jsp" %>
<script type="text/javascript">

</script>
</head>
<body class="easyui-layout">
  <div id="topView" data-options="region:'north',border:true" style="height:60px;background:#B3DFDA;padding:10px;font-size:32px;">${title_system}</div>
  <div id="leftView" data-options="region:'west',border:true,split:true,title:'操作对象视图'" style="width:240px;padding:7px;">west content</div>
  <!-- <div data-options="region:'east',border:true,split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div> -->
  <!-- <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div> -->
  <div id="mainView" data-options="region:'center',border:true">Center</div>
</body>
</html>