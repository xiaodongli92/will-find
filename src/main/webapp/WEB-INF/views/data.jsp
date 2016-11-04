<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/include/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/include/head.inc" %>
    <title>数据列表</title>
</head>

<body>
<!-- top -->
<jsp:include page="/WEB-INF/include/top.jsp"/>

<div class="container" style="position: relative;">
    <!--left-->
    <jsp:include page="/WEB-INF/include/left.jsp"/>
    <!-- right -->
    <div class="col-sm-9">

        <div class="panel panel-default">
            <div class="panel-heading" style="overflow:auto;">
                <h4 style="float:left">数据列表</h4>
            </div>
        </div>
        <div style="width:100%;overflow-x:scroll;">
            <div class="panel-heading search-content" id="panel-heading" style="height: 50px;">
                <span class="my-label">投注时间：</span>
                <input type="text" placeholder="开始时间" class="form-control my-date" id="startTime" style="width: 100px;float: left">
                <input type="text" placeholder="结束时间" class="form-control my-date" id="endTime" style="width: 100px;float: left">
                <input type="text" id="uid" class="form-control" style="width: 100px;float: left;margin-left: 15px;"
                       placeholder="用户ID">
                <button type="button" class="btn btn-danger" style="float: left;margin-left: 15px" id="_clear">清空
                </button>
                <button type="button" class="btn btn-primary" style="float: left;margin-left: 5px" id="_search">检索
                </button>
                <button type="button" class="btn btn-success" style="float: left;margin-left: 5px" id="_export">导出
                </button>
            </div>
            <table class="table table-striped" style="width: 1700px;font-size: 13px;" id="table">

            </table>
        </div>
        <jsp:include page="/WEB-INF/include/page.jsp"/>
    </div>
    <!--right-->
</div>
</body>
<script type="text/template" id="table-template">
    <tr>
        <th>序号</th>
        <th>id</th>
        <th>device</th>
        <th>num</th>
        <th>period</th>
        <th>regular_buy</th>
        <th>rid</th>
        <th>time</th>
        <th>uid</th>
    </tr>
    {{each datas as data i}}
    <tr class="normal-tr">
        <td class="seq">{{i+1}}</td>
        <td class="name">{{data.id}}</td>
        <td class="idCard">{{data.device}}</td>
        <td class="mobile">{{data.num}}</td>
        <td class="batchNo">{{data.period}}</td>
        <td class="comeFrom">{{data.regularBuy}}</td>
        <td class="type">{{data.rid}}</td>
        <td class="mobile2">{{data.time}}</td>
        <td class="errorCode">{{data.uid}}</td>
    </tr>
    {{/each}}
</script>
<script>
var pageNo = 0;
var totalPage = 0;
var totalCount = 0;
$(function(){
    initPage();
    $("#_search").click(function () {
        initPage();
    })
    $("#_clear").click(function () {
        $(".search-content input").val("");
        $(".search-content select").val("");
    });
})
function initPage(pageNoParam) {
    var startTime = $("#startTime").val();
    var endTime = $("#endTime").val();
    if (pageNoParam != null) {
        pageNo = pageNoParam;
    }
    $.ajax({
        url: "${ctx}/show/data.do",
        type: "post",
        dataType: "json",
        data: {
            t: Math.random()
        },
        success: function (data) {
            showData(data);
        }
    });
}
function showData(data) {
    $("#table").html(template("table-template", {datas: data}));
//    pageNo = data.pageNo;
//    totalCount = data.totalCount;
//    totalPage = data.totalPage;
    showPageParam();
    $(".detail").on('click', function () {
        var seq = $(this).parents("tr").children("td").eq(0).html();
        var credit = credits[seq-1];
        try {
            var result = $.parseJSON(credit.result);
            $("#resultText").val(JSON.stringify(result, null, 4));
        } catch (e) {
            console.log("解析JSON失败，直接显示非格式化的结果:" + e);
            $("#resultText").val(credit.result);
        }
    });
}
$(".my-date").datepicker({
    format: 'yyyy-mm-dd',
    weekStart: 1,
    autoclose: true,
    todayBtn: 'linked',
    language: 'zh-CN'
});
</script>
</html>