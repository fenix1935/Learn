package com.learn.ws.mod.conexion;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class conexion {
	private static BasicDataSource dataSource=null;
	
	private static DataSource getDataSource() {
		if (dataSource==null) {

			dataSource= new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("ser");
			dataSource.setPassword("12345671");
			dataSource.setUrl("jdbc:mysql://learntodb.c7dxti9sjybq.us-east-1.rds.amazonaws.com:3306/biblioteca");
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);
			dataSource.setMaxWaitMillis(5000);
		}
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
}
