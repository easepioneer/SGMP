<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/layout/purejquery/include/taglibs.jsp" %>
<html>
<head>
<%@ include file="/page/layout/purejquery/include/metas.jsp" %>
<title>${title_system}</title>
<%@ include file="/page/layout/purejquery/include/links.jsp" %>
<%@ include file="/page/layout/purejquery/include/scripts.jsp" %>
<script type="text/javascript">
function menuAction(menuTitle, menuAction, closable) {
    if($('#mainTabs').tabs('exists', menuTitle)){
        $('#mainTabs').tabs('select', menuTitle);
    }
    else {
        var p = menuAction.indexOf('?');
        if(p > 0) {
            menuAction += '&rand=' + Math.random();
        }
        else {
            menuAction += '?rand=' + Math.random();
        }
        //alert(menuAction);

        var content = '<iframe scrolling="auto" frameborder="0" src="' + menuAction + '" style="width: 100%; height: 100%;"></iframe>';
        $('#mainTabs').tabs('add', {
            title: menuTitle,
            content: content,
            closable: closable,
            _url: menuAction
        });
    }
    return false;
}

/**
 * 刷新
 */
function reload() {
    var stab = $('#mainTabs').tabs('getSelected');
    var url = stab.panel('options')._url;

    var p = url.indexOf('rand=');
    if(p > 0) {
        url = url.substring(0, p - 1);
    }

    p = url.indexOf('?');
    if(p > 0) {
        url += '&rand=' + Math.random();
    }
    else {
        url += '?rand=' + Math.random();
    }

    var content = '<iframe scrolling="auto" frameborder="0" src="' + url + '" width="100%" height="100%"></iframe>';
    $('#mainTabs').tabs('update', {
        tab: stab,
        options: {
            content: content
        }
    });
    return false;
}

$(document).ready(function() {
    if(isIE6_7()) {
        correctPNG_IE();
    }

    $('#mainTabs').tabs({
        onSelect: function(title, index) {
            //alert(title + "," + index);
        }, 
        onBeforeClose: function(title, index) {
            return confirm('确定要关闭“' + title + "”？");
        }
    });
    $('#mainTabs').tabs('resize');

    menuAction('首页', '${ctx_webapp}/home!init.do', false);

    $(window).resize(function() {
        $('#mainTabs').tabs('resize');
    });
});
</script>
</head>
<body class="easyui-layout" style="text-align: left;">
  <div id="topView" region="north" border="false" style="background: #E0ECFF; height: 96px; color: #E0ECFF; text-align: left;">
    <div style="background: #0D4D4D; margin: 0; padding: 7px 1px;"><img alt="${title_system}" src="${cxt_webstyle}/img/logo/system.png" align="middle" width="449" height="49" /></div>
    <div id="menu" style="background: #E0ECFF; padding: 3px;">
      <a href="#" class="easyui-linkbutton" data-options="plain: true,iconCls:'sgmp-icon-home'" onclick="return menuAction('首页', '${ctx_webapp}/home!init.do', false);">首页</a>
      <a href="#" class="easyui-menubutton" data-options="menu:'#mm1',iconCls:'sgmp-icon-tg'">台区管理</a>
      <a href="#" class="easyui-menubutton" data-options="menu:'#mm2',iconCls:'sgmp-icon-setup'">采集管理</a>
      <a href="#" class="easyui-menubutton" data-options="menu:'#mm3',iconCls:'sgmp-icon-setup'">终端管理</a>
      <a href="#" class="easyui-menubutton" data-options="menu:'#mm4',iconCls:'sgmp-icon-query'">数据查询</a>
      <a href="#" class="easyui-menubutton" data-options="menu:'#mm5',iconCls:'sgmp-icon-setup'">系统管理</a>
    </div>
    <div id="mm1" style="width: 100px;">
      <div onclick="menuAction('台区档案维护', '${ctx_webapp}/tm/tam!init.do', true);">台区档案维护</div>
      <div onclick="menuAction('台区综合查询', '${ctx_webapp}/tm/tiq!init.do', true);">台区综合查询</div>
      <div onclick="menuAction('台区综合监测', '${ctx_webapp}/tm/tim!init.do', true);">台区综合监测</div>
    </div>
    <div id="mm2" style="width: 100px;">
      <div onclick="menuAction('数据召测', '${ctx_webapp}/cm/dr!init.do', true);">数据召测</div>
      <div onclick="menuAction('终端任务设置', '${ctx_webapp}/cm/tcts!init.do', true);">终端任务设置</div>
      <div onclick="menuAction('主站任务配置', '${ctx_webapp}/cm/sctc!init.do', true);">主站任务配置</div>
    </div>
    <div id="mm3" style="width: 100px;">
      <div onclick="menuAction('终端参数设置', '${ctx_webapp}/term/tps!init.do', true);">终端参数设置</div>
      <div onclick="menuAction('终端对时', '${ctx_webapp}/term/tts!init.do', true);">终端对时</div>
      <div onclick="menuAction('终端复位', '${ctx_webapp}/term/trs!init.do', true);">终端复位</div>
    </div>
  </div>
  <div id="leftView" region="west" border="true" split="true" title="操作对象视图" style="width: 240px; padding: 7px;">
  </div>
  <div id="mainView" region="center" border="true">
    <div id="mainTabs" class="easyui-tabs" fit="true" border="false" plain="false" data-options="tools: '#tabs-tools'">
    </div>
    <div id="tabs-tools" border="false" style="border-top: 0; border-left: 0; border-right: 0;">
      <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'" onclick="reload()"></a>
      <!-- <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-help'" onclick="showhelp()"></a> -->
    </div>
  </div>
  <div id="bottomView" region="south" border="false" style="background: #E0ECFF; height: 30px; color: #E0ECFF; text-align: left;">
  </div>
</body>
</html>