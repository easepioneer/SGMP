<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/layout/purejquery/include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/page/layout/purejquery/include/metas.jsp" %>
<title>终端任务设置</title>
<%@ include file="/page/layout/purejquery/include/links.jsp" %>
<%@ include file="/page/layout/purejquery/include/scripts.jsp" %>
<script type="text/javascript">
function send(p) {
    alert(p);
    var params = {
            type: 'terminal-parameter',
            action: 'write'
    };
    $.ajax({
        url: ctx_webapp + '/cm/tcts!send.do',
        type: 'POST',
        timeout: 30000,
        data: params,
        dataType: 'text',
        success: function(taskId) {
            alert(taskId);
            setTimeout("receive('" + p + "'," + taskId + ")", 3000);
        },
        error: function(XmlHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
            //setTimeout("readB66F()", 15000);
        }
    });
}

function receive(p, taskId) {
    alert(p + "," + taskId);
}

function changeP(pos) {
    $('#tt').datagrid('loadData',[]);
    $('#tt').datagrid({pagePosition:pos});
}

$(document).ready(function() {
    $('#pp').panel('resize',{
        width: $(document.body).width() - 20,
    });

    $('#tt').datagrid('resize', {
        width: $(document.body).width() - 20,
        height: $(document.body).height() - 100
    });

    $(window).resize(function() {
        $('#pp').panel('resize',{
            width: $(document.body).width() - 20,
        });

        $('#tt').datagrid('resize', {
            width: $(document.body).width() - 20,
            height: $(document.body).height() - 100
        });
    });
});
</script>
</head>
<body class="easyui-layout" style="text-align: left;">
  <div region="north" border="false" style="background: #FFFFFF; color: #E0ECFF; padding: 7px; height: 77px;">
    <div id="pp" class="easyui-panel" border="true" title="查询条件">
      <form id="ff" method="post">
        <table>
          <tr valign="baseline">
            <td width="60" height="30" align="right">单　位：</td>
            <td width="140"><select class="easyui-combobox" id="soOrgId" name="soOrgId" style="width: 135px;"><option value="">请选择</option></select></td>
            <td width="60" align="right">台　区：</td>
            <td width="140"><select class="easyui-combobox" id="soTgId" name="soTgId" style="width: 135px;"><option value="">请选择</option></select></td>
            <td width="60" align="right">终　端：</td>
            <td width="140"><select class="easyui-combobox" id="soTermId" name="soTermId" style="width: 135px;"><option value="">请选择</option></select></td>
            <td style="padding-left: 10px;"><a href="javascript:void(0)" class="easyui-linkbutton" onclick="send('putinto')">投入</a></td>
          </tr>
        </table>
      </form>
    </div>
  </div>
  <div region="center" border="false" style="background: #FFFFFF; color: #E0ECFF; padding: 2px 7px 7px 7px;">
    <table id="tt" class="easyui-datagrid" style="height: 400px;" url="datagrid2_getdata.php" title="Load Data" rownumbers="true" pagination="true"> 
      <thead>
        <tr>
          <th field="itemid" width="80">Item ID</th>
          <th field="productid" width="120">Product ID</th>
          <th field="listprice" width="80" align="right">List Price</th>
          <th field="unitcost" width="80" align="right">Unit Cost</th>
          <th field="attr1" width="200">Attribute</th>
          <th field="status" width="60" align="center">Stauts</th>
        </tr>
      </thead>
    </table>
  </div>
</body>
</html>