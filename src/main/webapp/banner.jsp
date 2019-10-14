<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<c:set var="app" value="${pageContext.request.contextPath}"/>
<script>
    $(function () {
        $("#bannerList").jqGrid({
            url: "${app}/banner/findAll",
            editurl: "${app}/banner/edit",
            datatype: "json",
            colNames: ["id", "图片", "标题", "状态", "描述", "日期"],
            colModel: [
                {name: "id"},
                {
                    name: "imgpath", editable: true, edittype: "file",
                    formatter: function (a, b, c) {
                        return "<img style='width:100px;height:50px' src='${app}/img/" + a + "' />"
                    }
                },
                {name: "title", editable: true},
                {
                    name: "status", editable: true, edittype: 'select',
                    editoptions: {value: 'y:展示;n:不展示'}
                },
                {name: "desc", editable: true},
                {name: "create_date", editable: true}
            ],
            styleUI: "Bootstrap",
            autowidth: true,
            height: "60%",
            pager: "#bannerPager",
            page: 1,
            rowNum: 4,
            multiselect: true,
            rowList: [2, 4, 6],
            viewrecords: true,
        }).jqGrid("navGrid", "#bannerPager",
            {},
            {
                closeAfterEdit: true,
                beforeShowForm: function (obj) {
                    obj.find("#title").attr("readonly", true);
                    obj.find("#imgpath").attr("disabled", true);
                    obj.find("#desc").attr("readonly", true);
                    obj.find("#create_date").attr("readonly", true);
                }
            },
            {
                afterSubmit: function (response) {
                    var bannerId = response.responseText;
                    $.ajaxFileUpload({
                        url: "${app}/banner/upload",
                        fileElementId: "imgpath",
                        data: {bannerId: bannerId},
                        success: function (data) {
                            $("#albumList").trigger("reloadGrid");
                        }
                    });
                    return response
                }

            },
            {}
        )
    })

    function showModal() {
        location.href = "${app}/banner/easypoi"
    }

</script>
<div>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                  data-toggle="tab">轮播列表</a></li>
        <li role="presentation"><a href="#profile" onclick="showModal()" aria-controls="profile" role="tab"
                                   data-toggle="tab">轮播图</a></li>
    </ul>

</div>

<table id="bannerList"></table>
<div id="bannerPager"></div>