package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class CartUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the id:");
		int id=new Scanner(System.in).nextInt();
		System.out.println("Enter the Email:");
		String email =new Scanner(System.in).next();
		System.out.println("Enter the password:");
		String password =new Scanner(System.in).next();
		System.out.println("Enter the username:");
		String username =new Scanner(System.in).next();
		System.out.println("Enter the Adress:");
		String adress =new Scanner(System.in).next();
		CartDAO cd=new CartDAO();
		Cart c=new Cart();
		Cart res=cd.updateCart(c);
		res.setId(id);
		res.setEmail(email);
		res.setAddress(adress);
		res.setPassword(password);
		res.setUsername(username);
		System.out.println(res);
		

	}

}
