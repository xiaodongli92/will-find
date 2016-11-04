<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="text-align: right">
    <div class="btn-group">
        <button type="button" class="btn btn-default disabled" id="showPage"></button>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-default pageBtn" p="0">首页</button>
        <button type="button" class="btn btn-default pageBtn" p="pre">上一页</button>
        <button type="button" class="btn btn-default pageBtn" p="next">下一页</button>
        <button type="button" class="btn btn-default pageBtn" p="max">尾页</button>
        <input type="text" class="form-control" style="width: 50px;float: left" id="pageNum">
        <button type="button" class="btn btn-default pageBtn" p="the">跳转</button>
    </div>
</div>
<script>
$(function(){
    $(".pageBtn").on('click',function(){
        var p = $(this).attr("p");
        if (!isNaN(p)){//是数字
            initPage(p);
        } else {
            if (p == 'pre') {
                initPage(pageNo-1);
            } else if (p == 'next') {
                initPage(pageNo+1);
            } else if (p == 'max') {
                initPage(totalPage-1);
            } else if (p == 'the') {
                var newPageNum = $("#pageNum").val();
                newPageNum = (newPageNum==''?0:(newPageNum-1));
                initPage(newPageNum);
            }
        }
    })
})
function showPageParam(){
    $("#showPage").html("第 " + (pageNo + 1) + " 页，共 " + totalPage + " 页( " + totalCount + " 条)");
    $("#pageNum").val("");
}
</script>