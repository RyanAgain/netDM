var dailymessage = {
    URL:{

        coresummit:function (gsmNum,lteNum,volteNum,volteErl,lteRatio) {

            return '/dm/'+gsmNum+'/'+lteNum+'/'+volteNum+'/'+volteErl+'/'+lteRatio+'/core'

        },
        
        wlsummit:function (gsmAll,gsmWave,gsmDead,rsAll,rsDead,lteAll,lteWave,lteDead,wlanAc,wlanHot,wlanAp,wlanAllvo,wlanApdead,wlanApdrop) {

            return '/dm/'+gsmAll+'/'+gsmWave+'/'+gsmDead+'/'+rsAll+'/'+rsDead+'/'+lteAll+'/'+lteWave+'/'+lteDead+'/'+wlanAc+'/'+wlanHot+'/'+wlanAp+'/'+wlanAllvo+'/'+wlanApdead+'/'+wlanApdrop+'/wireless'

        },

        opsummit:function (gsmAllvo,gsmBusyvo,gsmAlldata,gsmbusydata,gsmUsage,gsmConnect,gsmDrop,lteAlldata,lteBusy,lteConnect,lteSwitch,lteDrop) {

            return '/dm/'+gsmAllvo+'/'+gsmBusyvo+'/'+gsmAlldata+'/'+gsmbusydata+'/'+gsmUsage+'/'+gsmConnect+'/'+gsmDrop+'/'+lteAlldata+'/'+lteBusy+'/'+lteConnect+'/'+lteSwitch+'/'+lteDrop+'/optimization'
        },

        brsummit:function (groupAll,dataLine,voiceLine,gprsLine,rentLine,groupMsg,schoolLine,familyAll,oneLine,opticalLine,oneAdd,opticalAdd) {
            return '/dm/'+groupAll+'/'+dataLine+'/'+voiceLine+'/'+gprsLine+'/'+rentLine+'/'+groupMsg+'/'+schoolLine+'/'+familyAll+'/'+oneLine+'/'+opticalLine+'/'+oneAdd+'/'+opticalAdd+'/broadband'
        },

        trsummit:function (firstUse,firstUsage,secUse,secUsage,thirdUse,thirdUsage,forthUse,forthUsage,fifthUse,fifthUsage) {
            return '/dm/'+firstUse+'/'+firstUsage+'/'+secUse+'/'+secUsage+'/'+thirdUse+'/'+thirdUsage+'/'+forthUse+'/'+forthUsage+'/'+fifthUse+'/'+fifthUsage+'/transfer'
        }

    },

    checkinput:function (node) {
        var i=0,j=0;
        node.each(function () {
            i++;
            if($(this).val() && !isNaN($(this).val())){
                j++;
                console.log(this);
            }
        });
        if(i==j){
            console.log(i,j);
            return true;

        }else {
            console.log(i,j);
            return false;
        }
    },

    coresummit:function () {
       //TODO 增加用户登录验证
        var gsmNum = parseFloat($('#gsmNum').val()).toFixed(2);
        var lteNum = parseFloat($('#lteNum').val()).toFixed(2);
        var volteNum = parseFloat($('#volteNum').val()).toFixed(2);
        var volteErl = parseFloat($('#volteErl').val()).toFixed(2);
        var lteRatio = parseFloat($('#lteRatio').val()).toFixed(2);
        var node = $('.core');
        console.log(gsmNum);
        if(dailymessage.checkinput(node)){
            // $.cookie('userId',userId,{expires:1,path:'/dailymessage'})
            var coreUrl = dailymessage.URL.coresummit(gsmNum,lteNum,volteNum,volteErl,lteRatio);
            $.post(coreUrl,{},function (result) {
                if(result && result['success']){
                    var rentresult = result['data'];
                    var stateinfo = rentresult['stateInfo'];
                    $('#coreErrorInfo').hide().html('<span class="label label-warning">'+stateinfo+'</span>').show(300);
                }
            })
        }else{
            $('#coreErrorInfo').hide().html('<span class="label label-warning">请检查是否完整填写或填写正确！</span>').show(300);
        }
    },

    wlsummit:function () {
        //TODO 增加用户登录验证
        // var userId = 1;
        var gsmAll = parseInt($('#gsmAll').val());
        var gsmDead = parseInt($('#gsmDead').val());
        var gsmWave = parseInt($('#gsmWave').val());
        var rsAll = parseInt($('#rsAll').val());
        var rsDead = parseInt($('#rsDead').val());
        var lteAll = parseInt($('#lteAll').val());
        var lteDead = parseInt($('#lteDead').val());
        var lteWave = parseInt($('#lteWave').val());
        var wlanAc = parseInt($('#wlanAc').val());
        var wlanHot = parseInt($('#wlanHot').val());
        var wlanAp = parseInt($('#wlanAp').val());
        var wlanAllvo = parseFloat($('#wlanAllvo').val()).toFixed(2);
        var wlanApdead = parseFloat($('#wlanApdead').val()).toFixed(2);
        var wlanApdrop = parseFloat($('#wlanApdrop').val()).toFixed(2);
        var node = $('.wireless');
        console.log(wlanAllvo,gsmAll);
        if(dailymessage.checkinput(node)){
            // $.cookie('userId',userId,{expires:1,path:'/dailymessage'})
            var wlUrl = dailymessage.URL.wlsummit(gsmAll,gsmWave,gsmDead,rsAll,rsDead,lteAll,lteWave,lteDead,wlanAc,wlanHot,wlanAp,wlanAllvo,wlanApdead,wlanApdrop);
            $.post(wlUrl,{},function (result) {
                if(result && result['success']){
                    var rentresult = result['data'];
                    var stateinfo = rentresult['stateInfo'];
                    $('#wlErrorInfo').hide().html('<span class="label label-warning">'+stateinfo+'</span>').show(300);
                    console.log(2);
                }
            })
        }else{
            $('#wlErrorInfo').hide().html('<span class="label label-warning">请检查是否完整填写或填写正确！</span>').show(300);
        }
    },

    opsummit:function () {
        //TODO 增加用户登录验证
        // var userId = 1;
        var gsmAllvo = parseFloat($('#gsmAllvo').val()).toFixed(2);
        var gsmBusyvo = parseFloat($('#gsmBusyvo').val()).toFixed(2);
        var gsmAlldata = parseFloat($('#gsmAlldata').val()).toFixed(2);
        var gsmbusydata = parseFloat($('#gsmbusydata').val()).toFixed(2);
        var gsmUsage = parseFloat($('#gsmUsage').val()).toFixed(2);
        var gsmConnect = parseFloat($('#gsmConnect').val()).toFixed(2);
        var gsmDrop = parseFloat($('#gsmDrop').val()).toFixed(2);
        var lteAlldata = parseFloat($('#lteAlldata').val()).toFixed(2);
        var lteBusy = parseFloat($('#lteBusy').val()).toFixed(2);
        var lteConnect = parseFloat($('#lteConnect').val()).toFixed(2);
        var lteSwitch = parseFloat($('#lteSwitch').val()).toFixed(2);
        var lteDrop = parseFloat($('#lteDrop').val()).toFixed(2);
        var node = $('.opti');
        if(dailymessage.checkinput(node)){
            // $.cookie('userId',userId,{expires:1,path:'/dailymessage'})
            var opUrl = dailymessage.URL.opsummit(gsmAllvo,gsmBusyvo,gsmAlldata,gsmbusydata,gsmUsage,gsmConnect,gsmDrop,lteAlldata,lteBusy,lteConnect,lteSwitch,lteDrop);
            $.post(opUrl,{},function (result) {
                if(result && result['success']){
                    var rentresult = result['data'];
                    var stateinfo = rentresult['stateInfo'];
                    $('#opErrorInfo').hide().html('<span class="label label-warning">'+stateinfo+'</span>').show(300);
                    console.log(2);
                }
            })
        }else{
            $('#opErrorInfo').hide().html('<span class="label label-warning">请检查是否完整填写或填写正确！</span>').show(300);
        }
    },

    brsummit:function () {
        //TODO 增加用户登录验证
        // var userId = 1;
        var groupAll = parseInt($('#groupAll').val());
        var dataLine = parseInt($('#dataLine').val());
        var voiceLine = parseInt($('#voiceLine').val());
        var gprsLine = parseInt($('#gprsLine').val());
        var rentLine = parseInt($('#rentLine').val());
        var groupMsg = parseInt($('#groupMsg').val());
        var schoolLine = parseInt($('#schoolLine').val());
        var familyAll = parseInt($('#familyAll').val());
        var oneLine = parseInt($('#oneLine').val());
        var opticalLine = parseInt($('#opticalLine').val());
        var oneAdd = parseInt($('#oneAdd').val());
        var opticalAdd = parseInt($('#opticalAdd').val());
        var node = $('.broad');
        if(dailymessage.checkinput(node)){
            // $.cookie('userId',userId,{expires:1,path:'/dailymessage'});
            var brUrl = dailymessage.URL.brsummit(groupAll,dataLine,voiceLine,gprsLine,rentLine,groupMsg,schoolLine,familyAll,oneLine,opticalLine,oneAdd,opticalAdd);
            $.post(brUrl,{},function (result) {
                if(result && result['success']){
                    var rentresult = result['data'];
                    var stateinfo = rentresult['stateInfo'];
                    $('#brErrorInfo').hide().html('<span class="label label-warning">'+stateinfo+'</span>').show(300);
                    console.log(2);
                }
            })
        }else{
            $('#brErrorInfo').hide().html('<span class="label label-warning">请检查是否完整填写或填写正确！</span>').show(300);
        }
    },

    trsummit:function () {
        //TODO 增加用户登录验证
        // var userId = 1;
        var firstUse = $('#tj1').val();
        var firstUsage = parseFloat($('#ly1').val()).toFixed(2);
        var secUse = $('#tj2').val();
        var secUsage = parseFloat($('#ly2').val()).toFixed(2);
        var thirdUse = $('#tj3').val();
        var thirdUsage = parseFloat($('#ly3').val()).toFixed(2);
        var forthUse = $('#tj4').val();
        var forthUsage = parseFloat($('#ly4').val()).toFixed(2);
        var fifthUse = $('#tj5').val();
        var fifthUsage = parseFloat($('#ly5').val()).toFixed(2);
        var node = $('.transfer');
        if(dailymessage.checkinput(node)){
            // $.cookie('userId',userId,{expires:1,path:'/dailymessage'});
            var brUrl = dailymessage.URL.trsummit(firstUse,firstUsage,secUse,secUsage,thirdUse,thirdUsage,forthUse,forthUsage,fifthUse,fifthUsage);
            $.post(brUrl,{},function (result) {
                if(result && result['success']){
                    var rentresult = result['data'];
                    var stateinfo = rentresult['stateInfo'];
                    $('#trErrorInfo').hide().html('<span class="label label-warning">'+stateinfo+'</span>').show(300);
                    console.log(2);
                }
            })
        }else{
            $('#trErrorInfo').hide().html('<span class="label label-warning">请检查是否完整填写或填写正确！</span>').show(300);
        }
    },


}