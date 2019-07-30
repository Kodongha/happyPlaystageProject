package com.kh.hp.admin.model.dao;

import static com.kh.hp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class MainImgDao {

	private Properties prop = new Properties();

	public MainImgDao() {

		String fileName = UserDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	//대표이미지
	public String[] mainImg(Connection con, int rentSeq) {

		System.out.println("대표이미지 dao까지는 왔어? ");

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String[] mainImg = new String[4];

		String query = prop.getProperty("mainImg");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, rentSeq);

			rset = pstmt.executeQuery();
			int i=0;
			while(rset.next()) {



				mainImg[i] = rset.getString("CHANGE_NM");

				System.out.println("333333333333333333");

				System.out.println(mainImg);

				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return mainImg;
	}






}
