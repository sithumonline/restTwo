package com.example.resttwo.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;

/*
 *default Port : 4080
 *http://localhost:4080/api/v1/category/*
*/
@Path("/api/v1/category")
public class CategoryController {
	private final Client client;
	private final String BASE_SERVICE_URI;

	public CategoryController(String baseUri) {
		this.client = ClientBuilder.newClient();
		this.BASE_SERVICE_URI = baseUri + "/category/";
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCategory(HashMap<String, ?> categoryData) {
		Entity<HashMap<String, ?>> entity = Entity.entity(categoryData, MediaType.APPLICATION_JSON);
		return client.target(BASE_SERVICE_URI)
				.request(MediaType.APPLICATION_JSON)
				.post(entity, Response.class);
	}

	@PUT
	@Path("/{categoryId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCategory(HashMap<String, ?> categoryData, @PathParam("categoryId") Integer categoryId) {
		Entity<HashMap<String, ?>> entity = Entity.entity(categoryData, MediaType.APPLICATION_JSON);
		return client.target(BASE_SERVICE_URI + categoryId)
				.request(MediaType.APPLICATION_JSON)
				.put(entity, Response.class);
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategorys() {
		return client.target(BASE_SERVICE_URI)
				.request(MediaType.APPLICATION_JSON)
				.get(Response.class);
	}

	@GET
	@Path("/{categoryId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoryById(@PathParam("categoryId") Integer categoryId) {
		return client.target(BASE_SERVICE_URI + categoryId)
				.request(MediaType.APPLICATION_JSON)
				.get(Response.class);
	}

	@DELETE
	@Path("/{categoryId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("categoryId") Integer categoryId) {
		return client.target(BASE_SERVICE_URI + categoryId)
				.request(MediaType.APPLICATION_JSON)
				.delete(Response.class);
	}
}
