<%@page import="com.kh.hp.rent.model.vo.RefundTypeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  ArrayList<RefundTypeVO> refundTypeVOList = (ArrayList<RefundTypeVO>) request.getAttribute("refundTypeVOList");
%>

  <div class="container">
    <h2>정산 정보를 입력해주세요.</h2>
    <hr style="background: black">

    <!-- 상호명 -->
    <div class="form-group">
      <label class="necessary">*</label><label for="compNm">상호명 (개인/법인)</label> <br><br>
      <input type="text" class="form-control" id="compNm" placeholder="상호명을 입력해주세요." name="compNm">
    </div>

    <br>

    <!-- 공연장명 -->
    <div class="form-group">
      <label class="necessary">*</label><label for="ceoNm">대표자명</label> <br><br>
      <input type="text" class="form-control" id="ceoNm" placeholder="대표자명을 입력해주세요." name="ceoNm">
    </div>

    <br>

    <!-- 사업자 등록번호 -->
    <div class="form-group">
      <label class="necessary">*</label><label for="corpNo1">사업자 등록번호</label>
      <br><br>
      <input id="corpNo1" type="tel" class="form-control" name="corpNo1" style="width: 100px; min-width: 100px; display:inline; margin: 0 1% 0 0%">
      <label>-</label>
      <input id="corpNo2" type="tel" class="form-control" name="corpNo2" style="width: 100px; min-width: 100px; display:inline; margin: 0 1% 0 1%">
      <label>-</label>
      <input id="corpNo3" type="tel" class="form-control" name="corpNo3" style="width: 100px; min-width: 100px; display:inline; margin: 0 0% 0 1%">
    </div>

    <br>

    <!-- 사업자 등록증 첨부 -->
    <div class="form-group">
      <label class="necessary">*</label><label for="hallInfo">사업자 등록증 첨부</label> <br><br>
      <div class="form-group">
        <input type="text" class="col-sm-10 col-xs-10 form-control" id="corpRegisCerPath" name="corpRegisCerPath" placeholder="사업자 등록증을 첨부해주세요." readonly="readonly" style="width: 80%">
        <button type="button" id="corpRegisCerPathAddBtn" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">첨부</button>
        <input type="file" id="corpRegisCerPathInput" name="corpRegisCerPathInput">
      </div>
    </div>

    <br><br><br>

    <!-- 사업장 주소 -->
    <div class="form-group">
      <label class="necessary">*</label><label for="corpAddress1">사업장 주소</label> <br><br>
      <div class="form-group">
        <input type="text" class="col-sm-10 col-xs-10 form-control" id="corpAddress1" placeholder="주소를 입력해주세요." name="corpAddress1" readonly="readonly" style="width: 80%">
        <button type="button" id="search_button2" class="col-sm-2 col-xs-2 btn btn btn-primary" style="width: 15%; float: right;">주소등록</button>
        <br><br>
        <input type="text" class="form-control" id="corpAddress2" placeholder="상세주소를 입력해주세요." name="corpAddress2" style="width: 100%;">
      </div>
    </div>

    <br>

    <!-- 정산용 이메일 -->
    <div class="form-group">
      <label class="necessary">*</label><label for="settleEmail">정산용 이메일</label> <br><br>
      <input id="settleEmail" type="text" class="form-control" name="settleEmail" placeholder="Email">
    </div>

    <br>

    <!-- 정산용 연락처 -->
    <div class="form-group">
      <label class="necessary">*</label><label for="settlePhone1">정산용 연락처</label> <br>
      <br>
      <select class="form-control" name="settlePhone1" id="settlePhone1" style="width: 100px; min-width: 100px; display:inline; margin: 0 2% 0 0">
        <option>010</option>
        <option>011</option>
        <option>016</option>
        <option>017</option>
        <option>019</option>
      </select>
      <label>-</label>
      <input id="settlePhone2" type="tel" class="form-control" name="settlePhone2" style="width: 100px; min-width: 100px; display:inline; margin: 0 1% 0 1%">
      <label>-</label>
      <input id="settlePhone3" type="tel" class="form-control" name="settlePhone3" style="width: 100px; min-width: 100px; display:inline; margin: 0 1% 0 1%">
    </div>

    <br><br>

    <h2>계좌 정보를 입력해주세요.</h2>
    <hr>

    <!-- 은행명 -->
    <div class="form-group" style="width: 50%; display: inline; float: left;">
      <label class="necessary">*</label><label for="bankNm">은행명</label> <br>
      <br>
      <select class="form-control" name="bankNm" id="bankNm" style="width: 400px;">
             <option value=''>선택하세요
         <option value='003'>기업은행
         <option value='004' selected="selected" >국민은행
         <option value='011'>농협중앙회
         <option value='012'>단위농협
         <option value='020'>우리은행
         <option value='031'>대구은행
         <option value='005'>외환은행
         <option value='023'>SC제일은행
         <option value='032'>부산은행
         <option value='045'>새마을금고
         <option value='027'>한국씨티은행
         <option value='034'>광주은행
         <option value='039'>경남은행
         <option value='007'>수협
         <option value='048'>신협
         <option value='037'>전북은행
         <option value='035'>제주은행
         <option value='064'>산림조합
         <option value='071'>우체국
         <option value='081'>하나은행
         <option value='088'>신한은행
         <option value='209'>동양종금증권
         <option value='243'>한국투자증권
         <option value='240'>삼성증권
         <option value='230'>미래에셋
         <option value='247'>우리투자증권
         <option value='218'>현대증권
         <option value='266'>SK증권
         <option value='278'>신한금융투자
         <option value='262'>하이증권
         <option value='263'>HMC증권
         <option value='267'>대신증권
         <option value='270'>하나대투증권
         <option value='279'>동부증권
         <option value='280'>유진증권
         <option value='287'>메리츠증권
         <option value='291'>신영증권
         <option value='238'>대우증권
      </select>
   </div>

    <div class="form-group" style="width: 50%; display: inline; float: right;">
      <label class="necessary">*</label><label for="accNo">계좌번호</label> <br><br>
      <input name="accNo" id="accNo" type="text" class="form-control" placeholder="계좌번호" style="width: 400px">
    </div>

   <br clear="all"><br><br>

    <div class="form-group" style="width: 50%; display: inline; float: left;">
      <label class="necessary">*</label><label for="accHolder">예금주</label> <br><br>
      <input id="accHolder" type="text" class="form-control" name="accHolder" placeholder="예금주" style="width: 400px">
    </div>

    <div class="form-group" style="width: 50%; display: inline; float: right;">
      <label class="necessary">*</label><label for="accBirth">생년월일</label> <br><br>
      <input id="accBirth" type="text" class="form-control" name="accBirth" placeholder="생년월일" style="width: 400px">
      <h5>* 계좌 인증을 위해 생년월일을 입력 받고 있습니다.</h5>
    </div>

   <div id="accDiv">
      <input type="hidden" id="access_token">
      <input type="hidden" id="user_seq_no">

   </div>


    <br clear="all"><br><br>

    <h2>환불 기준을 입력해주세요.</h2>
    <hr>
    <div class="container" >
      <label class="radio-inline"><input type="radio" id="refundType1" name="rentRefundTypeSeq" value="1" checked>유형 1</label>
      <label class="radio-inline"><input type="radio" id="refundType2" name="rentRefundTypeSeq" value="2">유형 2</label>
      <label class="radio-inline"><input type="radio" id="refundType3" name="rentRefundTypeSeq" value="3">유형 3</label>
      <label class="radio-inline"><input type="radio" id="refundType4" name="rentRefundTypeSeq" value="4">유형 4</label>
    </div>
    <br><br>
    <div class="container" id="refundDiv">
      <table class="table" id="refundTable">
         <!-- 초기 화면에서 type 1을 보여준다 -->
        <%for(int i=0; i<refundTypeVOList.size(); i++){
          if(refundTypeVOList.get(i).getRefundType() == 1){%>
        <tr>
          <%switch(refundTypeVOList.get(i).getDtCd()) {
          case 1:%>
          <td width="100px" align="center" id="123" style="font-weight: bold;">이용 당일</td>
          <%break;
          case 2:%>
          <td width="100px" align="center" style="font-weight: bold;">이용 전날</td>
          <%break;
          default:%>
          <td width="100px" align="center" style="font-weight: bold;">이용 <%=refundTypeVOList.get(i).getDtCd() %>일 전</td>
          <%break;
          } // end switch %>

          <%if(refundTypeVOList.get(i).getRefundDeductPer() == 0) {%>
          <td width="100px" align="center" style="color: red; font-weight: bold"><%=refundTypeVOList.get(i).getRefundDeductPer() %> %</td>
          <%} else if(refundTypeVOList.get(i).getRefundDeductPer() == 100){ %>
          <td width="100px" align="center" style="color: black; font-weight: bold"><%=refundTypeVOList.get(i).getRefundDeductPer() %> %</td>
        <%} else {%>
          <td width="100px" align="center" style="color: blue; font-weight: bold"><%=refundTypeVOList.get(i).getRefundDeductPer() %> %</td>
        <%} %>
        </tr>
        <%
          } // end if
        } // end for
        %>
      </table>
    </div>

    <script type="text/javascript">
      $(function(){


      });

    </script>

    <br><br>
    <button type="button" class="btn btn-danger prev-step" style="width: 49%;">취소</button>
    <button type="button" class="btn btn-success" id="submitBtn" name="submitBtn" style="width: 49%; float: right;">신청</button>
  </div>