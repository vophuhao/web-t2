package vn.iostart.service;

import java.util.List;

import vn.iostart.model.Category;

	public interface ICategoryService {

	List<Category> findAll();
	
	Category findById(int id);
	
	void insert(Category category);
	
	void update(Category category);
	
	void delete(int id);
	
	List<Category> findName(String keyword);
}