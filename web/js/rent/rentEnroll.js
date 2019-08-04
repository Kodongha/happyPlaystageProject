
$(function(){

    //Initialize tooltips
  var facSeq = 0;
  var coutionSeq = 0;
  var detAddrSeq = 0;
    $('.nav-tabs > li a[title]').tooltip();

    //Wizard
    $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {
        var $target = $(e.target);
        if ($target.parent().hasClass('disabled')) {
            return false;
        }
    });

    $(".next-step").click(function (e) {
        var $active = $('.wizard .nav-tabs li.active');
        $active.next().removeClass('disabled');
        nextTab($active);
        scroll(0,0);
    });
    $(".prev-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        prevTab($active);
        scroll(0,0);
    });

    /*시설 안내 추가 관련*/
  $("#facInfoContentAddBtn").click(function(){

    console.log("facInfoContentAddBtn");
    console.log("facSeq::"+facSeq);

    var facInfoContent = $.trim($("#facInfoContent").val())
    if(facInfoContent != "" && facInfoContent != null && facSeq < 5){
      facSeq++;
      $("#facInfoContent").clone(true).attr({"name" : "facInfoContentReq", "id" : "facInfoContent"+facSeq, "value" : $("facInfoContent").val(), "readonly" : "true"}).appendTo($(".facInfo"));

      $("#facInfoContent").val("");
      $("#facInfoContent").focus();
      /* $("#facInfoContentAddBtn").append($("<br>")); */
      $(".facInfo").append($("<br>"));
    }

    if(facSeq == 5){

      $("#facInfoContent").attr({"readonly" : "true"});
      $("#facInfoContentAddBtn").attr("disabled", "true");

      /*
      $("#facInfoContent").attr({"style" : "display:none"});
      $("#facInfoContentAddBtn").attr({"style" : "display:none"});
       */
    }
  });

  /*주의사항 추가 관련*/
  $("#cautionContentAddBtn").click(function(){

    console.log("cautionContentAddBtn");
    console.log("coutionSeq::"+coutionSeq);

    var cautionContent = $.trim($("#cautionContent").val())
    if(cautionContent != "" && cautionContent != null && coutionSeq < 5){
      coutionSeq++;
      $("#cautionContent").clone(true).attr({"name" : "cautionContentReq", "id" : "cautionContent"+coutionSeq, "value" : $("cautionContent").val(), "readonly" : "true"}).appendTo($(".caution"));
      $("#cautionContent").val("");
      $("#cautionContent").focus();
      /* $("#facInfoContentAddBtn").append($("<br>")); */
      $(".caution").append($("<br>"));
    }

    if(coutionSeq == 5){
      $("#cautionContent").attr("readonly", "true");
      $("#cautionContentAddBtn").attr("disabled", "true");
    }
  });

  /*상세 주소 추가 관련*/
  $("#detAddressAddBtn").click(function(){
    var facInfoContent = $.trim($("#detAddress").val())
    if(facInfoContent != "" && facInfoContent != null && detAddrSeq < 5){
      detAddrSeq++;
      $("#detAddress").clone(true).attr({"name" : "detAddressReq", "id" : "detAddress"+detAddrSeq, "value" : $("detAddress").val(), "readonly" : "true"}).appendTo($(".detAddr"));
      $("#detAddress").val("");
      $("#detAddress").focus();
      /* $("#facInfoContentAddBtn").append($("<br>")); */
      $(".detAddr").append($("<br>"));
    }

    if(detAddrSeq == 5){
      $("#detAddress").attr("readonly", "true");
      $("#detAddressAddBtn").attr("disabled", "true");
    }
  });

  $(".fileArea").hide();

  $("#titleImgDiv").click(function(){
    $("#titleImgInput").click();
  });
  $(".subImgDiv").click(function(){
    $("#subImgInput"+i).click();
    i++;
  });

  /* 공연장 등록증 첨부 */
  $("#hallRegisCerPathAddBtn").click(function(){
    $("#hallRegisCerPathInput").click();
  });

  $("#hallRegisCerPathInput").change(function(){
    $("#hallRegisCerPath").val($(this).val());
  });

  $("#corpRegisCerPathInput").hide();

  $("#corpRegisCerPathAddBtn").click(function(){
    $("#corpRegisCerPathInput").click();
  });

  $("#corpRegisCerPathInput").change(function(){
    $("#corpRegisCerPath").val($(this).val());
  });

  function nextTab(elem) {
      $(elem).next().find('a[data-toggle="tab"]').click();
  }
  function prevTab(elem) {
      $(elem).prev().find('a[data-toggle="tab"]').click();
  }

  $("#allTime").click(function(){
    $("#availStartTm").val("00:00");
    $("#availEndTm").val("24:00");
  });

  $(".availTime").change(function(){
    if($("#allTime").prop("checked")){
      $("#allTime").prop("checked", false);
    }
  });

  $("#regCloseCd").change(function(){
    var thisVal = $(this).val();
    if(thisVal == "11"){
      var $regDaySelect = $('<select/>', {id:"regOneDay",  class:'form-control'}).css({"width":"200px"});
      for(var i=1; i<=31; i++){
        var option = $('<option/>', {value:i, text:i+"일"});
        $regDaySelect.append(option);
      }
      $("#regHolidayForm").append($regDaySelect);
    }else{
      $("#regOneDay").remove();
    }

    if(thisVal != "1" && thisVal != "10"){

    }
  })

  $("#samePhoneNum").change(function(){

     if($(this).is(":checked") == true){
        console.log("check");
        var rentPhone1 = $("#rentPhone1").val()
        var rentPhone2 = $('#rentPhone2').val()
        var rentPhone3 = $('#rentPhone3').val()

        console.log("rentPhone1::" + rentPhone1);
        console.log("rentPhone2::" + rentPhone2);
        console.log("rentPhone3::" + rentPhone3);

        $("#rentMainTel1").val(rentPhone1);
        $("#rentMainTel2").val(rentPhone2);
        $("#rentMainTel3").val(rentPhone3);
     } else {
        console.log("out");
     }
  });

  //키를 누르거나 떼었을때 이벤트 발생
  $("#rentPrice").bind('keyup keydown',function(){
     inputNumberFormat(this);
  });

  //입력한 문자열 전달
  function inputNumberFormat(obj) {
     obj.value = comma(uncomma(obj.value));
  }

  //콤마찍기
  function comma(str) {
     str = String(str);
     return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
  }

  //콤마풀기
  function uncomma(str) {
     str = String(str);
     return str.replace(/[^\d]+/g, '');
  }

  //숫자만 리턴(저장할때)
  //alert(cf_getNumberOnly('1,2./3g')); -> 123 return
  function cf_getNumberOnly (str) {
     var len      = str.length;
     var sReturn  = "";

     for (var i=0; i<len; i++){
        if ( (str.charAt(i) >= "0") && (str.charAt(i) <= "9") ){
           sReturn += str.charAt(i);
        }
     }
     return sReturn;
  }

  // 환불 기준
  $("input[name=rentRefundTypeSeq]").change(function(){

      var rentRefundTypeSeq = $(this).val();
      $.ajax({
        url:'getrentRefundTypeInfo.rt',
        data:{rentRefundTypeSeq:rentRefundTypeSeq},
        type:'POST',
        success: function(data){

          $('#refundTable tr').remove();

          // var $table = $('<table/>', {class:'table', id:'refundTable'});
        var refundTable = $('#refundTable');

          for(var key in data){
            var $tr = $('<tr/>')
            var $td1 = $('<td/>', {width:'100px', align:'center'});
            var $td2 = $('<td/>', {width:'100px', align:'center'});

            if(data[key].dtCd == 1){
              $td1.text('이용 당일');
            } else if(data[key].dtCd == 2){
              $td1.text('이용 전날');
            } else {
              $td1.text('이용 ' + data[key].dtCd + '일 전');

            }
            $td2.text(data[key].refundDeductPer + '%');

            if(data[key].refundDeductPer == 0){
               $td2.css({'font-weight':'bold', 'color':'red'});
            } else if(data[key].refundDeductPer == 100){
               $td2.css({'font-weight':'bold', 'color':'blue'});
            } else {
               $td2.css({'font-weight':'bold', 'color':'black'});
            }

            $tr.append($td1);
            $tr.append($td2);

            refundTable.append($tr);
          }
        },
        error: function(){
          console.log("error");
        }

      });
    });

     // 신청버튼
   $('#submitBtn').click(function(){
      var result = false;
      result = fnSearchAccessToken();
      if(result){
         console.log("성공");
         $('#enrollForm').submit();
      } else {
         console.log("실패");
         alert('계좌정보가 불일치합니다.');
         $('#bankNm').focus();
      }
   });

});
// 사용자 인증을 위한 Function
function fnSearchAccessToken(){

   var client_id = 'l7xx8afc5179c3be41bb94c13f4a9354e25a';
   var client_secret = '4cc0d8fa519f4732ba0c0882f6a06b4f';
   var grant_type = "client_credentials";
   var scope = "oob";

   var result = false;

   $.ajax({
      //url: "/tpt/test/getOauthToken",
      url : "https://testapi.open-platform.or.kr/oauth/2.0/token",
      type : "POST",
      //cache: false,
      contenType : "application/json",
      async: false,
      data : {
         "client_id" : client_id,
         "client_secret" : client_secret,
         "grant_type" : grant_type,
         "scope" : scope
      },
      dataType : "json",
      success : function(data, data2, data3) {
         var list = JSON.parse(data3.responseText);
         $("#access_token").val(list.access_token);
         $("#user_seq_no").val(list.user_seq_no);
         result = fnSearchRealName();
      },
      error : function(data, data2, data3) {
         alert('error!!!');
      }
   });

   return result;
}

// 계좌 실명조회를 위한 Function
function fnSearchRealName() {

   $.support.cors = true;
   var reqDate = new Date();
   var year = reqDate.getFullYear() +"";
   var month = (reqDate.getMonth() + 1) >= 10?reqDate.getMonth() + 1 + "":"0" + (reqDate.getMonth() + 1);
   var date = (reqDate.getDate() >= 10?reqDate.getDate() + "":"0" + reqDate.getDate());
   var hour = reqDate.getHours() >= 10?reqDate.getHours() + "":"0" + reqDate.getHours();
   var min = reqDate.getMinutes() >= 10?reqDate.getMinutes() + "":"0" + reqDate.getMinutes();
   var sec = reqDate.getSeconds() >= 10?reqDate.getSeconds() + "":"0" + reqDate.getSeconds();

   var currentTime = year + month + date + hour + min + sec;
   console.log(currentTime)

   var bank_code_std = $("#bankNm").val();
   var account_num = $("#accNo").val();
   var account_holder_info = $("#accBirth").val();
   var tran_dtime = currentTime;
   var access_token = "Bearer " + $("#access_token").val();

   var result = false;
   console.log("bank_code_std :: " + bank_code_std);
   console.log("account_num :: " + account_num);
   console.log("account_holder_info :: " + account_holder_info);
   console.log("tran_dtime :: " + currentTime);
   console.log("access_token :: " + access_token);

   var resData = {
         "bank_code_std" : bank_code_std,
         "account_num" : account_num,
         "account_holder_info" : account_holder_info,
         "tran_dtime" : tran_dtime
      };

   $.ajax({
      url : "https://testapi.open-platform.or.kr/v1.0/inquiry/real_name",
      beforeSend : function(request) {
         request.setRequestHeader("Authorization",
               access_token);
      },
      type : "POST",
      data : JSON.stringify(resData),
      dataType : "json",
      async: false,
      success : function(data, data2, data3) {
         console.log(data)
         if (data.account_holder_name == $("#accHolder").val()) {
            result = true;
         } else {
            result = false;
         }
      },
      error : function(data, data2, data3) {
         alert('error!!!');

         result = false;
      }
   });

   return result;
}