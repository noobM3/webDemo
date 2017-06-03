package com.zhuhang.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class MyDBConnection {
	private String			userName	= "root";
	private String			pwd			= "Zhuhang@1234";
	private String			url			= 
    "jdbc:mysql://localhost:3306/njupt?characterEncoding=UTF-8&useSSL=false";
	private static String	driverURL	= "com.mysql.jdbc.Driver";

	private Connection		conn		= null;
	
	static{
		try{
			Class.forName(driverURL);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public MyDBConnection()
	{
		try{
		  conn=DriverManager.getConnection(url, userName, pwd);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public int executeUpdate(String sql)
	{
		if(conn==null) return 0;
		 Statement stmt=null;
		try{
		   stmt=conn.createStatement();
		 int res=stmt.executeUpdate(sql);
		 //stmt.close();
		 return res;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			try{
			  if(stmt!=null) stmt.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int executeUpdate(String sql, Object[] params)
	{
		if (conn == null)
			return 0;
		PreparedStatement pStatement = null;
		try
		{
			pStatement = (PreparedStatement) conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++)
				pStatement.setObject(i + 1, params[i]);
			int res = pStatement.executeUpdate();
			return res;
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (pStatement != null)
					pStatement.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public ResultSet executeQuery(String sql)
	{

		if(conn==null) return null;
		 Statement stmt=null;
		 ResultSet rs=null;
		 try{
			 stmt=conn.createStatement();
			 rs=stmt.executeQuery(sql);
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return rs;
	}

	public List<Object> executeQueryOne(String sql, Object[] params) throws SQLException
	{

		if (conn == null)
			return null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Object> list = new ArrayList<>();
		try
		{
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++)
				stmt.setObject(i + 1, params[i]);

			rs = stmt.executeQuery();
			
			int col = rs.getMetaData().getColumnCount();
			
			while(rs.next())
			{
				Object[] data = new Object[col];
				for (int i = 0; i < col; i++)
				{
					data[i] = rs.getObject(i + 1);
				}
				list.add(data);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			rs.close();
			stmt.close();
		}
		return list;
	}
}
