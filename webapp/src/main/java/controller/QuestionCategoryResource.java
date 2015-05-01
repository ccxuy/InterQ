/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import model.Category;
import model.dal.ModelDAO;

/**
 * @author yxx03
 *
 */
@Path("/category")
public class QuestionCategoryResource {

    @GET @Path("/{categoryid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategory(@PathParam("categoryid") String categoryid) {
    	Category category = new Category();
    	category.setId(1);
    	category.setName("hi a");
        return category;
    }
    
    @GET @Path("/all/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories() {
    	Category category = new Category();
    	ModelDAO<Category> categoryDao = new ModelDAO<Category>(category);
    	categoryDao.beginTransaction();
    	List<Category> cList = categoryDao.getAll();
    	categoryDao.commit();
    	
    	Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson(cList)).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCategory(@FormParam(value = "name") String name) {
    	Category category = new Category();
    	category.setName(name);
    	
    	Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson(category)).build();
    }
    
    @POST @Path("/{categoryid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCategory() {
        return "Hello!";
    }
    
    @DELETE @Path("/{categoryid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCategory() {
        return "Hello!";
    }

}
