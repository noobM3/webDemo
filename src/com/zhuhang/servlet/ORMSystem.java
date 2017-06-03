package com.zhuhang.servlet;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class PO
{
	public static String toSQL(Object object)
	{
		StringBuffer sql = new StringBuffer("insert into ");
		Class<?> cobj = object.getClass();
		String  table = cobj.getSimpleName();
		sql = sql.append(table + "(");
		Field[] fields = cobj.getDeclaredFields();
		for (Field field : fields)
		{
			sql.append(field.getName()).append(",");
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(") values ('");
		for (Field field : fields)
		{
			field.setAccessible(true);
			try
			{
				sql.append(field.get(object)).append("','");
			} catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		sql.deleteCharAt(sql.length()-1);
		sql.deleteCharAt(sql.length()-1);
		sql.append(")");
		String result = sql.toString();
		return result;
	}
	
	public static Object toObject(ResultSet rs,Class<?> cobj)
	{
		Object object = null;
		try
		{
			object = cobj.newInstance();
			Field[] fields = cobj.getDeclaredFields();
			for (Field field : fields)
			{
				field.set(object, rs.getObject(field.getName()));
			}
		} catch (InstantiationException e1)
		{
			e1.printStackTrace();
		} catch (IllegalAccessException e1)
		{
			e1.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return object;
	}
}

public class ORMSystem
{
	public int executeInsert(Object object)
	{
		return new MyDBConnection().executeUpdate(PO.toSQL(object));
	}
	
	public List<Object> toObject(ResultSet rs,Class<?> cobj)
	{
		List<Object> list = new ArrayList<>();
		try
		{
			while (rs.next())
			{
				list.add(PO.toObject(rs, cobj));
			}
		} catch (SQLException e)
		{
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return list;
	}
	
	
	//��ѯ���,���ذ�����������list
	public List<Object> executeQuery(String sql,Object object)
	{
		ResultSet rs = new MyDBConnection().executeQuery(sql);
		return toObject(rs, object.getClass());
	}
	
	//ע��
	public void register()
	{
		Scanner scanner = new Scanner(System.in);
		Student student = new Student();
		
		System.out.println("ѧ��:");
		String sno = scanner.nextLine();
		student.setSno(sno);
		
		System.out.println("����:");
		String sname = scanner.nextLine();
		student.setSname(sname);
		
		System.out.println("����:");
		int age = scanner.nextInt();
		student.setAge(age);
		
		executeInsert(student);
	}
	
	public void register(String sno,String sname,int age)
	{
		Student student = new Student();
		
		student.setSno(sno);
		student.setSname(sname);
		student.setAge(age);
		
		executeInsert(student);
	}
	
	//��¼
	public boolean login()
	{
		Scanner reader = new Scanner(System.in);
		Student student1 = new Student();
		System.out.println("ѧ��:");
		String sno1 = reader.nextLine();
		student1.setSno(sno1);
		System.out.println("����");
		String sname1 = reader.nextLine();
		student1.setSname(sname1);
		String sql = "select * from student;";
		List<Object> students = executeQuery(sql, new Student());
		for (Object object : students)
		{
			if(!((Student)object).equals(student1)) continue;
			else
				{
					return true;
				}
		}
		return false;
	}
	
	public boolean login(String sno1,String sname1)
	{
		Student student1 = new Student();
		student1.setSno(sno1);
		student1.setSname(sname1);
		String sql = "select * from student;";
		List<Object> students = executeQuery(sql, new Student());
		for (Object object : students)
		{
			if(!((Student)object).equals(student1)) continue;
			else
				{
					return true;
				}
		}
		return false;
	}
	
	
}






