<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jQuery library -->
<script type="text/javascript" src="${ctx_webstatic}/framework/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jQuery library -->
<script type="text/javascript" src="${ctx_webstatic}/framework/jquery-migrate-1.1.1/jquery-migrate-1.1.1.min.js"></script>
<!-- jQuery EasyUI -->
<script type="text/javascript" src="${ctx_webstatic}/framework/jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
<!-- jQuery EasyUI: zh_CN/lang -->
<script type="text/javascript" src="${ctx_webstatic}/framework/jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
var ctx_webstatic = "${ctx_webstatic}";
var cxt_webstyle = "${cxt_webstyle}";
var ctx_webapp = "${ctx_webapp}";

function isIE6_7() {
    if($.browser.msie && ($.browser.version == '6.0' || $.browser.version == '7.0')) { return true; }
    return false;
}

function correctPNG_IE() {
    for(var i = 0; i < document.images.length; i++) {
        var img = document.images[i];
        var w = img.width;
        var h = img.height;
        var imgName = img.src.toUpperCase();
        if(imgName.substring(imgName.length-3, imgName.length) == "PNG") { 
            img.style.filter += 'progid:DXImageTransform.Microsoft.AlphaImageLoader(src=' + img.src + ', sizingmethod=scale);';
            img.src = '${cxt_webstyle}/img/blank.gif';
            img.width = w;
            img.height = h;
        }
    }
}
</script>