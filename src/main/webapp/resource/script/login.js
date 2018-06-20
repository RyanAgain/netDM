var login = {
    URL:{
        loginup:function (userName,userPw) {
            return '/dm/'+userName+'/'+ userPw+'/auth';
        },

        userinfo:function () {
          return '/dm/'
        }
    },


    checkinfo:function (userName,userPw) {
            if(userName&&userPw){
                return true;
            }else {
                return false;
            }

    },

    loginauth:function () {

       var userName = $('#username').val();
       var userPw = $('#passwd').val();
       if(login.checkinfo(userName,userPw)){
           $.post(login.URL.loginup(userName,userPw),{},function (result) {
               if(result && result['success']){
                   var logindata = result['data'];
                   var stateinfo = logindata['stateInfo'];
                   var userId = logindata['userId'];
                   $.cookie('userId',userId,{expires:7 ,path:'/'})
                   window.location.href = '/dm/message'
               }else{
                   var logindata = result['data'];
                   var stateinfo = logindata['stateInfo'];
                   $('#loginMessage').hide().html('<span class="label label-warning">'+stateinfo+'</span>').show(300);}

           });
       }else{
           $('#loginMessage').hide().html('<label class="label label-danger">请检查是否填写账号密码！</label>').show(300);
       }
    }
}