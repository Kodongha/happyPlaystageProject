/**
 *
 */


$(function(){

    // Initialize tooltips
	var facSeq = 0;
	var cautionSeq = 0;
	var detAddrSeq = 0;
    $('.nav-tabs > li a[title]').tooltip();

    // Wizard
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

//==================================================================

    $(function(){
    	// 시설 안내 정보 가져오기
    	var rentSeq = requestRentSeq;	// 수정필요
    	var imgType = 1;

    	if(rentSeq > 0) {	// 수정필요
    		getFacInfo(rentSeq);
    		getCaution(rentSeq);
    		getDetAddress(rentSeq);
    		getAttachment(rentSeq);
    		getTitleRentImg(rentSeq, imgType)
    	}
    });

//==================================================================
    /* 시설 안내 추가 관련 */
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
		console.log("rentSeq::" + rentSeq);

		$.ajax({
		    url:url, 					// request 보낼 서버의 경로
		    type:'get',					// 메소드(get, post, put 등)
		    data:{'rentSeq':rentSeq},	// controller에게 보낼 데이터
		    success: function(facInfoVOList) {
		        // 서버로부터 정상적으로 응답이 왔을 때 실행
		    	// for(var i=0; i< facInfoVOList.length; i++) {
		    	// addFacInfo( facInfoVOList[i].facInfoContent );
		    	// }

		    	$.each(facInfoVOList, function(i, facInfoVO) {
		    		addFacInfo(facInfoVO.facInfoContent);
				});
		    },
		    error: function(err) {
		        // 서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
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

/*
			$("#facInfoContentDeleteBtn")
				.clone(true)
				.attr('name', 'facInfoContentDeleteBtnReq')
				.attr('id', 'facInfoContentDeleteBtn'+facSeq)
				.appendTo($(".facInfo"));
*/

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

//==================================================================
	/* 주의사항 추가 관련 */
	$("#cautionContentAddBtn").click(function(){

		var cautionContent = $.trim($("#cautionContent").val());
		addCautions(cautionContent);
	});


	function getCaution(rentSeq){
		var url = 'cautions';

		$.ajax({
			url:url,
			type:'get',
			data:{'rentSeq':rentSeq},
			success:function(cautionsVOList){
				$.each(cautionsVOList, function(i, CautionsVO) {
		    		addCautions(CautionsVO.cautionContent);
				});
		    },
		    error: function(err) {
		        // 서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
		    	alert(url+'ajax 호출 오류');
		    }
		});
	}

	function addCautions(cautionContent) {

		if(cautionContent != "" && cautionContent != null && cautionSeq < 5){
			cautionSeq++;

			$("#cautionContent")
				.clone(true)
				.attr('name', 'cautionContentReq')
				.attr('id', 'cautionContent'+cautionSeq)
				.attr('readonly', true)
				.val(cautionContent)
				.appendTo($(".caution"))

			$("#cautionContent").val("").focus();
			$(".caution").append($("<br>"));
		}

		if(cautionSeq == 5){
			$("#cautionContent").attr("readonly", "true");
			$("#cautionContentAddBtn").attr("disabled", "true");
		}
	}

//==================================================================
	/* 상세 주소 추가 관련 */
	$("#detAddressAddBtn").click(function(){

		var detAddress = $.trim($("#detAddress").val());
		addDetAddress(detAddress);
	});

	function getDetAddress(rentSeq){
		var url = 'rentDet';

		$.ajax({
			url:url,
			type:'get',
			data:{'rentSeq':rentSeq},
			success:function(rentDetVOList){
				$.each(rentDetVOList, function(i, RentDetVO) {
		    		addDetAddress(RentDetVO.detAddress);
				});
		    },
		    error: function(err) {
		        // 서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
		    	alert(url+'ajax 호출 오류');
		    }
		});
	}

	function addDetAddress(detAddress) {
		if(detAddress != "" && detAddress != null && detAddrSeq < 5){
			detAddrSeq++;

			$("#detAddress")
			.clone(true)
			.attr('name', 'detAddressReq')
			.attr('id', 'detAddress'+detAddrSeq)
			.attr('readonly', true)
			.val(detAddress)
			.appendTo($(".detAddr"));

			$("#detAddress").val("").focus();

			$(".detAddr").append($("<br>"));

		}

		if(detAddrSeq == 5){
			$("#detAddress").attr("readonly", "true");
			$("#detAddressAddBtn").attr("disabled", "true");
		}
	}

//==================================================================

	$(".fileArea").hide();
	$("#titleImgDiv").click(function(){
		$("#titleImgInput").click();
	});
	$(".subImgDiv").click(function(){
		$("#subImgInput"+i).click();
		i++;
	});

	function getTitleRentImg(rentSeq, imgType){
		var url = 'rentImg.md';

		$.ajax({
			url:url,
			type:'get',
			data:{'rentSeq':rentSeq, 'imgType':imgType},
			success:function(rentImgVOList){

			}
		});
	}

//==================================================================
	/* 공연장 등록증 첨부 */
	$("#hallRegisCerPathAddBtn").click(function(){
		$("#hallRegisCerPathInput").click();
	});

	$("#hallRegisCerPathInput").change(function(){
		$("#hallRegisCerPath").val($(this).val());
	});

	function getAttachment(rentSeq) {
		var url = 'attachment';

		$.ajax({
			url:url,
			type:'get',
			data:{'rentSeq':rentSeq},
			success:function(rentDetVOList){
				//console.log($("#hallRegisCerPath").val());
		    },
		    error: function(err) {
		        // 서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
		    	alert(url+'ajax 호출 오류');
		    }
		});
	}


//==================================================================
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


