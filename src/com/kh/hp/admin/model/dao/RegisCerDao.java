package com.kh.hp.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.hp.admin.model.vo.AttachmentVO;
import static com.kh.hp.common.JDBCTemplate.*;

public class RegisCerDao {

	private Properties prop = new Properties();

	public RegisCerDao() {
		String fileName = 
				RegisCerDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//공연장등록증
	public AttachmentVO regisCer(Connection con, int rentSeq) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AttachmentVO file = null;
		
		//System.out.println(rentSeq);

		String query = prop.getProperty("regisCer");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, rentSeq);
			
			rset = pstmt.executeQuery();

			if (rset.next()) {
				
				file = new AttachmentVO();

				file.setAttchSeq(rset.getInt("ATTCH_SEQ"));
				file.setOriginNm(rset.getString("ORIGIN_NM"));
				file.setChangeNm(rset.getString("CHANGE_NM"));
				file.setFilePath(rset.getString("FILE_PATH"));
				file.setUploadDt(rset.getDate("UPLOAD_DT"));
				file.setFileType(rset.getInt("FILE_TYPE"));
				file.setRentSeq(rset.getInt("RENT_SEQ"));
				file.setPropSeq(rset.getInt("PROP_SEQ"));
				file.setUserSeq(rset.getInt("USER_SEQ"));
				file.setSubType(rset.getInt("SUB_TYPE"));


			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}

		System.out.println("등록증 dao 마지막라인");
		System.out.println("등록증dao에서의 출력:::::" +file);
		return file;
	}
}