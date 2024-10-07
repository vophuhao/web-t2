package vn.iostart.service.impl;

import java.util.List;

import vn.iostart.configs.DBConnection;
import vn.iostart.dao.ICategoryDao;
import vn.iostart.dao.impl.CategoryDaoImpl;
import vn.iostart.model.Category;
import vn.iostart.service.ICategoryService;

public class CategoryServiceImpl extends DBConnection implements ICategoryService {

	public ICategoryDao cateDao = new CategoryDaoImpl();
	
	@Override
	public List<Category> findAll() {
		return cateDao.findAll();
	}

	@Override
	public Category findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public void insert(Category category) {
		cateDao.insert(category);
		
	}

	@Override
	public void update(Category category) {
		
		Category cate = new Category();
		cate = cateDao.findById(category.getCategoryid());
		
		if (cate != null) {
			cateDao.update(category);
		} 
	}

	@Override
	public void delete(int id) {

		Category cate = new Category();
		cate = cateDao.findById(id);
		
		if (cate != null) {
			cateDao.delete(id);
		}
		
	}

	@Override
	public List<Category> findName(String keyword) {
		return cateDao.findName(keyword);
	}

}