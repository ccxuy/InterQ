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

    /**
     * For getting category by id
     * @param categoryid
     * @return
     */
    @GET @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategory(@PathParam("id") int categoryid) {
    	Category category = new Category();
    	ModelDAO<Category> categoryDao = new ModelDAO<Category>(category);
    	categoryDao.beginTransaction();
    	category = categoryDao.getById(categoryid);
    	categoryDao.commit();
        return category;
    }
    
    /**
     * For getting all categories
     * @return
     */
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
    
    /**
     * Create a category via a given category.
     * @param category
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Category createCategory(Category category) {
    	ModelDAO<Category> categoryDao = new ModelDAO<Category>(category);
    	categoryDao.beginTransaction();
    	categoryDao.insert(category);
    	categoryDao.commit();

    	return category;
//    	Gson gson = new Gson();
//        return Response.status(200).entity(gson.toJson(category)).build();
    }
    
    /**
     * Update a category via a given category.
     * @param category
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Category updateCategory(Category category) {
    	ModelDAO<Category> categoryDao = new ModelDAO<Category>(category);
    	categoryDao.beginTransaction();
    	categoryDao.update(category);
    	categoryDao.commit();
    	return category;
    }
    
    /**
     * Delete a category with given id.
     * @param id
     * @return
     */
    @DELETE @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategory(@PathParam("id") String id) {
    	Category category = new Category(id);
    	ModelDAO<Category> categoryDao = new ModelDAO<Category>(category);
    	categoryDao.beginTransaction();
    	categoryDao.delete(category);
    	categoryDao.commit();
    	Gson gson = new Gson();
        return Response.status(200).entity(gson.toJson("success")).build();
    }

}
