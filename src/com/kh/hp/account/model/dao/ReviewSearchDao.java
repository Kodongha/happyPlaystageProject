package com.kh.hp.account.model.dao;
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
	
	public ReviewSearchVO selectList(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ReviewSearchVO rs = null;

		String query = prop.getProperty("reivewSearch");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setString(2, "완료");

			rset = pstmt.executeQuery();

			if(rset.next()) {
				rs = new ReviewSearchVO();

				rs.setRentSeq(rset.getInt("RENT_SEQ"));
			
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
