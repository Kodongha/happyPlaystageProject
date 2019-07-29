/**
 *
 */


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

    $(function(){
    	// 시설 안내 정보 가져오기
    	var rentSeq = 1;	// 수정필요

    	if(rentSeq > 0) {	// 수정필요
    		getFacInfo(rentSeq);
    	}
    });

    // 시설안내 추가 버튼 클릭
	$("#facInfoContentAddBtn").click(function(){
		// 입력 문자열
		var facInfoContent = $.trim($("#facInfoContent").val());

		// 시설 안내 정보 추가
		addFacInfo(facInfoContent);
	});

	// 시설 안내 정보 가져오기
	function getFacInfo(rentSeq) {
		var url = 'facInfo';

		$.ajax({
		    url:url, 					//request 보낼 서버의 경로
		    type:'get',					// 메소드(get, post, put 등)
		    data:{'rentSeq':rentSeq},	// controller에게 보낼 데이터
		    success: function(facInfoVOList) {
		        //서버로부터 정상적으로 응답이 왔을 때 실행
//		    	for(var i=0; i< facInfoVOList.length; i++) {
//		    		addFacInfo( facInfoVOList[i].facInfoContent );
//		    	}

		    	$.each(facInfoVOList, function(i, facInfoVO) {
		    		addFacInfo(facInfoVO.facInfoContent);
				});
		    },
		    error: function(err) {
		        //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
		    	alert(url+'ajax 호출 오류');
		    }
		});
	}

	// 시설 안내 정보 추가
	function addFacInfo(facInfoContent) {

		// 입력 문자열 append
		if(facInfoContent != "" && facInfoContent != null && facSeq < 5){
			// count
			facSeq++;

			// append
			$("#facInfoContent")
				.clone(true)
				.attr('name', 'facInfoContentReq')
				.attr('id', 'facInfoContent'+facSeq)
				.attr('readonly', true)
				.val(facInfoContent)
				.appendTo($(".facInfo"));

			// 입력창 초기화
			$("#facInfoContent").val("").focus();

			$(".facInfo").append($("<br>"));
		}

		// 꽉찼을 때
		if(facSeq >= 5){
			$("#facInfoContent").attr({"readonly" : "true"});
			$("#facInfoContentAddBtn").attr("disabled", "true");
		}
	}

	/*주의사항 추가 관련*/
	$("#cautionContentAddBtn").click(function(){

		console.log("cautionContentAddBtn");
		console.log("coutionSeq::"+coutionSeq);

		var facInfoContent = $.trim($("#cautionContent").val())
		if(facInfoContent != "" && facInfoContent != null && coutionSeq < 5){
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

		console.log("detAddressAddBtn");
		console.log("detAddrSeq::"+detAddrSeq);

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

});


