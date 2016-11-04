<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/include/taglibs.jsp" %>
<script>
$(function(){

})
</script>

<!--left-->
<div class="col-sm-3">
    <div class="col-nav-list">
        <div class="menu-group">
            <h3 class="menu-title">数据展示</h3>
            <ul class="collapse-ul collapse-show">
                <li ${lastUri=="show/toDataPage.do"?'class="collapse-active"':''}>
                    <a href='${ctx}/show/toDataPage.do'>数据列表</a>
                </li>
                <li ${lastUri=="show/toUserPage.do"?'class="collapse-active"':''}>
                    <a href='${ctx}/show/toUserPage.do'>用户列表</a>
                </li>
            </ul>
        </div>
        <div class="btn-scroll-bar"></div>
    </div>
</div>
<!--left_end-->
