package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;



public class CartGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enetr the id");
		int id3 = new Scanner(System.in).nextInt();
		
		CartDAO pd3 = new CartDAO();
		Cart p3=pd3.getCart(id3);
		System.out.println(p3.getId());
		System.out.println(p3.getEmail());
		System.out.println(p3.getPassword());
		System.out.println(p3.getUsername());
		System.out.println(p3.getAddress());
	
	}

}
