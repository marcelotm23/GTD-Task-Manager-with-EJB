package com.sdi.util;

import java.util.List;

import javax.ws.rs.core.GenericType;

import alb.util.console.Console;

import com.sdi.client.Category;

public class Output {

	public static void printCategories(List<Category> categorias) {
		Console.println("Id\tNombre");
		for(Category c:categorias){
			Console.println(c.getId()+"\n"+c.getName());
		}
	}

}
