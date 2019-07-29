package com.kh.hp.admin.model.dao;

import static com.kh.hp.common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.admin.model.vo.RealTimeVO;

public class RealTimeDao {

	Properties prop = new Properties();

	public RealTimeDao() {
		String fileName = RealTimeDao.class.getResource("/sql/admin/realtime-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<RealTimeVO> selectRealTimeList(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RealTimeVO> realTimeVOs = null;

		String query = prop.getProperty("selectRealTimeList");

		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();

			realTimeVOs = new ArrayList<RealTimeVO>();
			while(rset.next()) {
				RealTimeVO realTimeVO = new RealTimeVO();
				realTimeVO.setRoomSeq(rset.getInt("ROOM_SEQ"));
				realTimeVO.setUserSeq(rset.getInt("USER_SEQ"));
				realTimeVO.setStatus(rset.getInt("STATUS"));
				realTimeVO.setLastRcvDate(rset.getDate("LAST_RCV_DATE"));
				realTimeVO.setUserNick(rset.getString("USER_NICK"));
				realTimeVO.setRcvMsg(rset.getString("RCV_MSG"));

				realTimeVOs.add(realTimeVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return realTimeVOs;
	}

	public ArrayList<RealTimeVO> selectConversationList(Connection con, String roomSeq) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RealTimeVO> realTimeVOList = null;

		String query = prop.getProperty("selectConversationList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(roomSeq));

			rset = pstmt.executeQuery();

			realTimeVOList = new ArrayList<RealTimeVO>();
			while(rset.next()) {
				RealTimeVO realTimeVO = new RealTimeVO();
				realTimeVO.setChatSeq(rset.getInt("CHAT_SEQ"));
				realTimeVO.setRoomSeq(rset.getInt("ROOM_SEQ"));
				realTimeVO.setRcvMsg(rset.getString("RCV_MSG"));
				realTimeVO.setSendMsg(rset.getString("SEND_MSG"));
				realTimeVO.setAdminNo(rset.getInt("ADMIN_NO"));
				realTimeVO.setCharDate(rset.getDate("CHAR_DATE"));
				realTimeVO.setUserNick(rset.getString("USER_NICK"));
				realTimeVOList.add(realTimeVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return realTimeVOList;
	}



}
