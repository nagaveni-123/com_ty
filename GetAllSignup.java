package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.dao.SignupDAO;
import com.ty.dto.Signup;

public class GetAllSignup {
	public static void main(String[] args) {
		
		
		SignupDAO sd=new SignupDAO();
		List<Signup> s=sd.getSignup();
		for(Signup s1:s) {
			System.out.println(s1);
		}
	}

}
