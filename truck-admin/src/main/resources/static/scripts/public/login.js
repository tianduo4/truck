$(function() {
    $(":text,:password").keyup(function(e){
        var keyCode= e.keyCode;
        if(keyCode!=13){
            return false;
        }
        var thisName=this.name;
        if(thisName=="username"){
            $("[name='password']").focus();
        }
        if(thisName=="pwd"){
            $("[name='checkCode']").focus();
        }
        if(thisName=="checkCode"){
            verSubmit();
        }
    });



    $('.close').click(function(){
        $(this).parent('li').find('input').val('').focus();
    });

    if ($("#errorMsg").val() != '') {
        layer.alert($("#errorMsg").val());
    }

    $(".username").focus();

});


function verSubmit()
{
    var uname = $.trim($("#username").val());
    var passwd = $.trim($("#password").val());
    if(uname == "" || uname == null || uname == "您的用户名")
    {

        layer.alert("用户名不能为空,请输入用户名!");
        document.getElementById("username").focus();
        return false;
    }
    if(passwd == "" || passwd == null || passwd == "登录密码")
    {
        layer.alert("密码不能为空,请输入密码!");
        $("#password").focus();
        return false;
    }

    var vilidcode = $.trim($("#checkCode").val());
    if(vilidcode == "" || vilidcode == null || vilidcode == "验证码")
    {
        layer.alert("验证码不能为空,请输入验证码!")
        $("#checkCode").focus();
        return false;
    }

    checkcode(vilidcode);

}

function reloadImg(){
    $("#validateImg").attr("src",$("#validateImg").attr("src").split("?")[0]+"?"+new Date().getTime())
}

function tologin(){
    window.location.href="/";
}

function checkcode(vilidcode){
    $.get("/checkcode?t="+new Date().getTime(),{checkCode:vilidcode},function(data) {
        if(data != 1){
            layer.alert(data);
        }else{
            $("#loginForm").submit();
        }
    });
}
