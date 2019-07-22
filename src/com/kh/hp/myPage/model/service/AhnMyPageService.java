package com.kh.hp.myPage.model.service;


import java.sql.Connection;
import java.util.ArrayList;

import com.kh.hp.myPage.model.dao.AhnMyPageDao;
import com.kh.hp.myPage.model.vo.AhnLevelupVO;
import com.kh.hp.myPage.model.vo.AhnMyPageVO;
import com.kh.hp.myPage.model.vo.AhnUsingInfoVO;

import static com.kh.hp.common.JDBCTemplate.*;

public class AhnMyPageService {

	public AhnMyPageVO selectOne(int userSeq) {
		Connection con = getConnection();
		AhnMyPageVO responseUserVO = new AhnMyPageDao().selectOne(con, userSeq);
		close(con);
		
		return responseUserVO;
	}

	public AhnLevelupVO updateLevelOne(int levelUpInfo) {
		Connection con = getConnection();
		AhnLevelupVO responseUserVO = new AhnMyPageDao().updateLevelOne(con, levelUpInfo);
		close(con);
		
		return responseUserVO;
	}

	/*public ArrayList<AhnUsingInfoVO> searchCheck(int usingInfo) {

		Connection con = getConnection();
		
		ArrayList<AhnUsingInfoVO> list = new AhnMyPageDao().searchCheck(con, usingInfo);
		
		close(con);
		
		return list;
	}*/

	
	
	
	
	
	
	public AhnUsingInfoVO searchCheck(int usingInfo) {
		Connection con = getConnection();
		AhnUsingInfoVO responseUserVO = new AhnMyPageDao().searchCheck(con, usingInfo);
		close(con);
		
		return responseUserVO;
	}

	/*public AhnUsingInfoVO updateUsingOne(int usingInfo) {
		Connection con = getConnection();
		AhnUsingInfoVO responseUserVO = new AhnMyPageDao().updateUsingOne(con, usingInfo);
		close(con);
		
		return responseUserVO;
	}*/

	/*public AhnUsingInfoVO searchCheck(AhnUsingInfoVO reqAhnUsingInfoVO) {
		Connection con = getConnection();
		AhnUsingInfoVO responseUserVO = new AhnMyPageDao().searchCheck(con, reqAhnUsingInfoVO);
		close(con);
		
		return responseUserVO;
	}*/
	
}
