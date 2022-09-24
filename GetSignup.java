package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignupDAO;
import com.ty.dto.Signup;

public class GetSignup {
	public static void main(String[] args) {
		System.out.println("enetr the email: ");
		String email=new Scanner(System.in).next();
		System.out.println("enetr the password: ");
		String password=new Scanner(System.in).next();
			SignupDAO sd=new SignupDAO();
		Signup s=sd.getSignup(email,password);
		if(s!=null) {
			System.out.println("The name is : "+s.getFirstname());
		}else
		{
			System.out.println("enter valid email and password");
		}
		
	}

}
