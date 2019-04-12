package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Recipe;
import com.qa.persistence.domain.Recipe;
import com.qa.persistence.domain.Recipe;
import com.qa.persistence.domain.Recipe;
import com.qa.persistence.domain.Recipe;
import com.qa.business.service.RecipeService;
import com.qa.persistence.domain.Recipe;
import com.qa.util.JSONUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Transactional(SUPPORTS)
@Default
public class RecipeDBRepositry implements RecipeRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Transactional(REQUIRED)
	public String createRecipe(String recipe) {
		Recipe aRecipe = util.getObjectForJSON(recipe, Recipe.class);
		manager.persist(aRecipe);
		return "{\"message\": \"movie has been sucessfully added\"}";
	}

	public String getAllRecipes() {
		Query query = manager.createQuery("Select f FROM Recipe f");
		Collection<Recipe> recipes =  (Collection<Recipe>) query.getResultList();
		
//		manager.find(Movie.class, 1L);

		return util.getJSONForObject(recipes);
	}

	public String getARecipe(Long id) {
		
		return util.getJSONForObject(manager.find(Recipe.class, id));
	}

	public String updateRecipe(String recipe, Long id) {
	
		return null;
	}

	
	@Transactional(REQUIRED)
	public String deleteRecipe(Long id) {
		Recipe recipeInDB = util.getObjectForJSON(getARecipe(id), Recipe.class);
		if (manager.contains(manager.find(Recipe.class, id))) {

			manager.remove(manager.find(Recipe.class, id));
		}
		return "{\"message\": \"movie sucessfully deleted\"}";
	}

	
	public int cycleRecipes(String name) {
		Query query = manager.createQuery("Select a FROM Movie a");
		Collection<Recipe> movies = (Collection<Recipe>) query.getResultList();

		return 0;
	}







}

	
	


