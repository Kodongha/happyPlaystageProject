package com.kh.hp.serviceCenter.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.hp.common.JDBCTemplate.*;

import com.kh.hp.serviceCenter.model.vo.FaQVO;

public class ServiceCenterDao {
	private Properties prop = new Properties();

	public ServiceCenterDao() {
		String fileName = ServiceCenterDao.class.getResource("/sql/serviceCenter/serviceCenter-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<FaQVO> selectFaQ(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<FaQVO> list= null;

		String query = prop.getProperty("selectFaQ");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<FaQVO>();

			while(rset.next()) {
				FaQVO faq = new FaQVO();

				faq.setFnqCate(rset.getString("FNQ_CATE"));
				faq.setFnqQuestion(rset.getString("FNQ_QUESTION"));
				faq.setFnqAnswer(rset.getString("FNQ_ANSWER"));

				list.add(faq);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

}
