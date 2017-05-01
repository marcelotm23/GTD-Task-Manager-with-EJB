package com.sdi.util;

import java.util.List;

import alb.util.console.Console;

import com.sdi.client.model.Category;
import com.sdi.client.model.Task;

public class Output {

	public static void printCategories(List<Category> categorias) {
		Console.println("Id\tNombre");
		for (Category c : categorias) {
			Console.println(c.getId() + "\t" + c.getName());
		}
	}

	public static void printTasks(List<Task> tasks) {
		if (tasks.size() == 0) {
			Console.println("Ninguna tarea asociada a dicha categoría");
		} else {
			Console.println("Id\tNombre\tComentarios\tFecha planificada");
			for (Task t : tasks) {
				Console.println(t.getId()+"\t"+ t.getTitle() + "\t" 
						+ t.getComments() + "\t"
						+ t.getPlanned() + "\t");
			}
		}
	}

}
