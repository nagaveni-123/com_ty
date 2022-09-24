package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.StudentDOA;
import com.ty.dto.Student;

public class StudentUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the id:");
		int id=new Scanner(System.in).nextInt();
		System.out.println("Enter the name:");
		String name =new Scanner(System.in).next();
		System.out.println("Enter the Phone:");
		long phone =new Scanner(System.in).nextLong();
		System.out.println("Enter the adress:");
		String address =new Scanner(System.in).next();
		System.out.println("Enter the pincode:");
		int pin =new Scanner(System.in).nextInt();
		Student s=new Student();
		s.setId(id);
		s.setName(name);
		s.setAddress(address);
		s.setPhone(phone);
		s.setPincode(pin);
		StudentDOA sd=new StudentDOA();
		Student s1=sd.insertStudent(s);
		System.out.println(s1);

	}

}
