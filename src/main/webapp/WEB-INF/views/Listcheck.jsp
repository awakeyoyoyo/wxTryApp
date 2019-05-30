<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/12
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" language="JavaScript">

    function submitUserList_3() {
        alert("ok");
        var orderitem = new Array();
       // orderitem.push({expressSize: "大件",  expressName: "李四",expressPwd: "1153"});
        orderitem.push({ productMxg:"一份双蛋"});
        orderitem.push({ productMxg:"一份蛋肉肠"});
        var orderVo = {};
        orderVo.orderItemList=orderitem;
        orderVo.shippingId=100;
        orderVo.price=3;
        orderVo.takeAddress="海三肠粉店";
        orderVo.orderType="美食";
        orderVo.overTime="2017-6-3 20:10:20"
        orderVo.orderMxg="请赶快兄弟"

        $.ajax({
            url: "/order/create.do",
            type: "POST",
            contentType : 'application/json;charset=utf-8', //设置请求头信息
            headers: {
                'token':'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3eGFwcCIsIm9wZW5faWQiOiJvSnIzUzVOYWMwYXc4dTBtWXQwaVh1QlZlYmhrIiwiZXhwIjoxNTU5MDM5ODkxLCJpYXQiOjE1NTg5NTM0OTF9.2FVrydIVh8s6y5sx_dknyKV10AAXIlLRGO1Utr6WW5g'
            },
            dataType:"json",
            data: JSON.stringify(orderVo),    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
            //data: $.toJSON(customerArray),
            // 将Json对象序列化成Json字符串，toJSON()需要引用jquery.json.min.j
            success: function(data){
                console.log(data);
                console.JSON.stringify(orderVo);
            },
            error: function(res){
                console.log(res.responseText);
            }
        });
        console.JSON.stringify(orderVo);
    }
</script>
<head>
    <h1>submitUserList_3</h1>
    <input id="submit" type="button" value="Submit" onclick="submitUserList_3();">
</head>
<body>

</body>
</html>
