package vn.iostart.dao;

import java.util.List;

import vn.iostart.model.Category;

public interface ICategoryDao {

	List<Category> findAll();
	
	Category findById(int id);
	
	void insert(Category category);
	
	void update(Category category);
	
	void delete(int id);
	
	List<Category> findName(String keyword);
	
}