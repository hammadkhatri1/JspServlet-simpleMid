package com.tech.web.utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.Connection;

public class DBUtil {

			private static Connection conn;
			
			public static Connection getConnection(){
				
				InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream( "/db.properties" );
				Properties properties = new Properties();
				
				try {
					properties.load(inputStream);
					String driver = properties.getProperty( "driver" );
					String url = properties.getProperty( "url" );
					String user = properties.getProperty( "user" );
					String password = properties.getProperty( "password" );
					
					Class.forName( driver );
					conn = DriverManager.getConnection( url, user, password );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return conn;
			}
		}


