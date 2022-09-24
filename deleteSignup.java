package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.SignupDAO;
import com.ty.dto.Signup;

public class deleteSignup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter the details name which you want to delete?");
		String firstname=new Scanner(System.in).next();
		
		SignupDAO sd=new SignupDAO();
		String s=sd.deleteSignup(firstname);
		System.out.println(s);
	}

}
