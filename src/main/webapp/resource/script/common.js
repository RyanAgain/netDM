var common = {
    
    URL:{
        getnickName:function () {
            return "/dm/user/getnickname"
        }
    },

    getnickName:function () {
        $.get(common.URL.getnickName(),{},function (result) {
            if(result){
                console.log(result)
                $('#nickName').text(result)
            }
        })
    },

    logout:function () {
        $.cookie('userId',null,{expires:-1,path: '/'});
        window.location.reload();
    }
}