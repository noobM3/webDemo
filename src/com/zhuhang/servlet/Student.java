package com.zhuhang.servlet;

public class Student
{
	String	sno;	// ѧ��-->����
	String	sname;	// ����
	int		age;	// ����
	String	sex;	// �Ա�
	String	depart;	// Ժϵ
	
	public String getSno()
	{
		return sno;
	}
	public void setSno(String sno)
	{
		this.sno = sno;
	}
	public String getSname()
	{
		return sname;
	}
	public void setSname(String sname)
	{
		this.sname = sname;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getDepart()
	{
		return depart;
	}
	public void setDepart(String depart)
	{
		this.depart = depart;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == this) return true;
		if(obj == null || obj.getClass() != Student.class) return false;
		return ((Student)obj).sno.equals(this.sno);
	}
}