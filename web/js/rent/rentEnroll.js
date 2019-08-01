
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


});


