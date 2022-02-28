package com.example.resttwo.controller;

import java.util.HashMap;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

import com.example.resttwo.model.Category;
import com.example.resttwo.service.CategoryService;

/*
 *default Port : 3080
 *http://localhost:3080/category/*
*/
@Path("/category")
public class CategoryController {
	private Category category;
	private CategoryService categoryService = new CategoryService();

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCategory(HashMap<String, ?> categoryData) {
		String name = (String) categoryData.get("name");
		String description = (String) categoryData.get("description");
		System.out.println(
				"CategoryController.addCategory() : name = " + name + " description = " + description);
		category = new Category(name, description);

		return categoryService.addCategory(category);
	}

	@PUT
	@Path("/{categoryId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCategory(HashMap<String, ?> categoryData, @PathParam("categoryId") Integer categoryId) {
		String name = (String) categoryData.get("name");
		String description = (String) categoryData.get("description");
		category = new Category(name, description);
		category.setId(categoryId);

		return categoryService.updateCategory(category);
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategorys() {
		return categoryService.getCategorys();
	}

	@GET
	@Path("/{categoryId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoryById(@PathParam("categoryId") Integer categoryId) {
		return categoryService.getCategoryById(categoryId);
	}

	@DELETE
	@Path("/{categoryId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("categoryId") Integer categoryId) {
		return categoryService.deleteCategory(categoryId);
	}
}
