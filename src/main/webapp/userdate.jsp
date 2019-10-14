<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<c:set var="app" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="${app}/boot/js/jquery-2.2.1.min.js"></script>
    <script src="${app}/echarts/echarts.min.js"></script>
    <script src="${app}/echarts/china.js"></script>
</head>
<body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '用户七天注册数量'
        },
        tooltip: {},
        legend: {
            data: ['数量']
        },
        xAxis: {
            data: ["第一天", "第二天", "第三天", "第四天", "第五天", "第六天", "第七天"]
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'line'
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    $.ajax({
        url: "${pageContext.request.contextPath}/user/findAll",
        datatype: "json",
        type: "POST",
        success: function (da) {
            myChart.setOption({
                series: [{data: da}]
            });
        }
    });


    // var goEasy = new GoEasy({
    //     appkey: "BC-41105467e17d4745869fc7051df656ee"
    // });
    // goEasy.subscribe({
    //     channel: "164channel",
    //     onMessage: function (message) {
    //         var data = JSON.parse(message.content);
    //         myChart.setOption({
    //             series:[{data:data}]
    //         });
    //     }
    // });


</script>

</body>
</html>