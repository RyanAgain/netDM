var cardrent = {
    URL:{

        exposer:function (cardId) {
            return '/dm/'+cardId+'/exposer';
        },

        exposereturn:function (cardId) {
            return '/dm/'+cardId+'/exposereturn';
        },

        successrentInfo:function (cardId,rentName,rentPhone,rentReason,roomNum,ydInterface) {
            return '/dm/'+ cardId + '/' + rentName + '/' + rentPhone + '/' + rentReason +'/' + roomNum +'/' + ydInterface +'/rentinfo';
        },

        successreturn:function (cardId) {
            return '/dm/'+ cardId + '/returninfo'
        }
    },

    showmodal:function (cardId) {
        $.post(cardrent.URL.exposer(cardId),{},function (result) {
            console.log(result);
            if(result && result['success']){
                var exposer = result['data'];
                if(exposer['exposed']){
                        var rentInfoModal = $('#nameAPhone');
                         $('#nameAPhone').modal({
                            //显示弹出层
                            show:true,
                            backdrop:'static', //禁止位置关闭
                        }),
                        $('#infoBtn').click(function () {
                        var rentName = $('#rentNameKey').val();
                        var rentPhone = $('#rentPhoneKey').val();
                        var rentReason = $('#rentReasonKey').val();
                        var roomNum = $('#roomNumKey').val();
                        var yd = $('#ydinterfaceKey').val();
                        if(cardrent.checkinfo(rentName,rentPhone,rentReason,roomNum,yd)){
                            var successRentUrl = cardrent.URL.successrentInfo(cardId,rentName,rentPhone,rentReason,roomNum,yd);
                            $.post(successRentUrl,{},function (result) {
                                if(result && result['success']){
                                    var rentresult = result['data'];
                                    var stateinfo = rentresult['stateInfo'];
                                    window.alert(stateinfo);
                                    window.location.reload();
                                }
                            })
                        }else {
                            $('#rentInfoMessage').hide().html('<label class="label label-danger">请检查填写信息或手机号码！</label>').show(300);
                        }
                    })
                    }
                }
            })
        },

    returncard:function (cardId) {
        $.post(cardrent.URL.exposereturn(cardId),{},function (result) {
            if (result && result['success']){
                var exposer = result['data'];
                if(exposer['exposed']){
                    var successReturnUrl = cardrent.URL.successreturn(cardId);
                    $.post(successReturnUrl,{},function (result) {
                        if(result && result['success']){
                            window.location.reload();
                    }
                })
            }
        }
    })
    },




    //验证手机号
    checkinfo:function (name,phone,reason,room,ydinterface) {
        if(name && phone && reason && room && ydinterface &&phone.length == 11 && !isNaN(phone)){
            return true;
        } else {
            return false;
        }

    },

    //详情页秒杀逻辑
    list:{
        init:function () {
            for(var i=1 ; i<4 ; i++) {
                $.post(cardrent.URL.exposer(i),{},function (result) {
                    if(result && !result['success']){
                        var exposer = result['data'];
                        var cardId = exposer['cardId'];
                        $("#endRentBtn"+cardId).addClass('disabled');
                    }
                })
            };
        }
    }
}