package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class DeleteCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the id");
		int id=new Scanner(System.in).nextInt();
		CartDAO cd=new CartDAO();
		String c=cd.DeleteCart(id);
		System.out.println(c);
				

	}

}
