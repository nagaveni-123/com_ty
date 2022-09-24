package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class CartInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
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
			
			c.setId(id);
			c.setEmail(email);
			c.setAddress(adress);
			c.setPassword(password);
			c.setUsername(username);
			Cart res=cd.cartInsert(c);
			System.out.println(res);

		}

	

	}


