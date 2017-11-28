function ajax() {

    var account = document.getElementById("account").value;
    var password = document.getElementById("password").value;

    //先声明一个异步请求对象
    var xmlHttpReg = null;
    if (window.ActiveXObject) {//如果是IE

        xmlHttpReg = new ActiveXObject("Microsoft.XMLHTTP");

    } else if (window.XMLHttpRequest) {

        xmlHttpReg = new XMLHttpRequest(); //实例化一个xmlHttpReg
    }

    //如果实例化成功,就调用open()方法,就开始准备向服务器发送请求
    if (xmlHttpReg != null) {
        xmlHttpReg.open("post", "/Verify/login", true);
        xmlHttpReg.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        xmlHttpReg.send("account="+account+"&password="+password);
        xmlHttpReg.onreadystatechange = doResult; //设置回调函数

    }

    //回调函数
    //一旦readyState的值改变,将会调用这个函数,readyState=4表示完成相应

    //设定函数doResult()
    function doResult() {

        if (xmlHttpReg.readyState == 4) {//4代表执行完成
            if (xmlHttpReg.status == 200) {//200代表执行成功
                //将xmlHttpReg.responseText的值赋给ID为resText的元素
                document.getElementById("resText").innerHTML = xmlHttpReg.responseText;
            }
        }
    }
}

function login() {
    var account = prompt("账号", "");
    var password = prompt("密码","");
    if(account!=""&&password!=""){
        alert(account+"  "+ password)
    }else {
        alert("请输入账号或密码");
    }
}

$(function ($) {
    $("#example").hover(function () {
        $(this).stop().animate({
            opacity: '1'
        }, 600);
    }, function () {
        $(this).stop().animate({
            opacity: '0.6'
        }, 1000);
    }).on('click', function () {
        $("body").append("<div id='mask'></div>");
        $("#mask").addClass("mask").fadeIn("slow");
        $("#LoginBox").fadeIn("slow");
    });

    $("#loginbtn").on('click', function () {
        var account = document.getElementById("account").value;
        var password = document.getElementById("password").value;

        if(account!=""&&password!=""){
            $("#LoginBox").fadeOut("fast");
            $("#mask").css({ display: 'none'
            });
        }else {
            alert("账号密码有空缺");
        }

    });
    $(".close_btn").hover(function () {
        $(this).css({ color: 'black' })
    }, function () {
        $(this).css({ color: '#999' })
    }).on('click', function () {
        $("#LoginBox").fadeOut("fast");
        $("#mask").css({ display: 'none'
        });
    });
});