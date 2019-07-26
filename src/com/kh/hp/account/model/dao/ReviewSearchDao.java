package com.kh.hp.account.model.dao;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.PreparedStatement;
import com.kh.hp.account.model.vo.ReviewSearchVO;
import static com.kh.hp.common.JDBCTemplate.*;

public class ReviewSearchDao {
	private Properties prop = new Properties();
	
	public ReviewSearchDao() {
		String fileName = ReviewSearchDao.class.getResource("/sql/account/account-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ReviewSearchVO selectList(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ReviewSearchVO rs = null;

		String query = prop.getProperty("reivewSearch");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				rs = new ReviewSearchVO();

				rs.setHallNm(rset.getString("HALL_NM"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return rs;
	}

}
