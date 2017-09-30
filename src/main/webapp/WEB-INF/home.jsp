<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/9/29
  Time: 上午10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    这是springMVC的首页!!!
<div id="div1">aaaaa</div>
</body>
<script src="/js/jquery-3.2.1.js">
</script>
<script>

    /*
    1.$的使用
     1).$()       : 选择标签/获取标签
     2).$.xxx     : 调用方法    ajax, get, post

    2.$()的使用
     1).$("") :使用选择器获取标签
     2).$(js对象): $(document)  将js对象转为jq对象

    3.$()的方法
     1).带参数  : 赋❤️值   $("#div1").html("ooooooo")
     2).不带参数 : 获取当前的值  console.log($("#div1").html())

    4.如果jq的方法没有明显的返回值,那么这个方法会返回对象本身
      链式编程风格


     */
//    function func1() {
//        $("#div1").html("ooooo").attr("id","div2").append("<a>123</a>")
//        $("#div1").attr("id","div2")
//        console.log($("#div1").attr("id")) //获取id属性
//    }
//    func1()

    function func2() {
        $.ajax({
            url:"/student",
            data:{
              username:$("#div1").html(),
                password:"2222",
                hobby:"篮球"
            },
            success:function (result) {
                console.log(result)
            }
        })
    }
    func2()
</script>
</html>
