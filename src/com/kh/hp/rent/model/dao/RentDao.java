package com.kh.hp.rent.model.dao;

import static com.kh.hp.common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.hp.myPage.model.dao.MyPageDao_mh;
import com.kh.hp.rent.model.vo.DetFacVO;

public class RentDao {

	private Properties prop = new Properties();

	public RentDao() {
		String fileName = MyPageDao_mh.class.getResource("/sql/rent/rent-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DetFacVO> selectDetFacAll(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<DetFacVO> detFacVOList = null;

		String query = prop.getProperty("selectDetFacAll");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			detFacVOList = new ArrayList<DetFacVO>();

			while(rset.next()) {
				DetFacVO detFacVO = new DetFacVO();

				detFacVO.setDetFacSeq(rset.getInt("DET_FAC_SEQ"));
				detFacVO.setDetFacNm(rset.getString("DET_FAC_NM"));
				detFacVO.setDetFacImgPath(rset.getString("DET_FAC_IMG_PATH"));

				detFacVOList.add(detFacVO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return detFacVOList;
	}

}
