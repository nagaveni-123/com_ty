package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignupDAO;
import com.ty.dto.Signup;

public class UpdateSignup {

	public static void main(String[] args) {
		System.out.println("Enetr the Firstname");
		String name=new Scanner(System.in).next();
		System.out.println("Enet the last name");
		String lname=new Scanner(System.in).next();
		System.out.println("Enetr the email");
		String email=new Scanner(System.in).next();
		System.out.println("Enter the password");
		String password=new Scanner(System.in).next();
		System.out.println("Enter the Phone");
		long phone=new Scanner(System.in).nextLong();
		System.out.println("Enter the DateOF BIrth");
		String dob=new Scanner(System.in).next();
		System.out.println("Entr the gender");
		String gender=new Scanner(System.in).next();
		Signup s=new Signup();
		SignupDAO sd=new SignupDAO();
		s.setFirstname(name);
		s.setLastname(lname);
		s.setEmail(email);
		s.setGender(gender);
		s.setPassword(password);
		s.setPhone(phone);
		s.setDob(dob);
		Signup s1=sd.updateSignup(s);
		System.out.println(s1);

	}

}
