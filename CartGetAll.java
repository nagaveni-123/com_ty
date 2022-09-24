package com.ty.controller;

import java.util.List;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class CartGetAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CartDAO c=new CartDAO();
		List<com.ty.dto.Cart> li=c.getCartAll();
		for(Cart c1:li) {
			System.out.println(c1);
		}

	}

}
