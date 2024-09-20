package vn.iostart.service.impl;

import vn.iostart.dao.IUserDao;
import vn.iostart.dao.impl.UserDaoImpl;
import vn.iostart.model.Users;
import vn.iostart.service.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDao userDao =new UserDaoImpl();
	@Override
	public Users findOne(String username) {
		// TODO Auto-generated method stub
		return userDao.findOne(username);
	}

	@Override
	public void insert(Users user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePass(String Email,String username,String Pass) {
		
		userDao.updatePass(Email, username, Pass);
	}

	@Override
	public void updatestatus(Users user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String code) {
		if (userDao.checkExistEmail(email)) {
			return false;
			}
			if (userDao.checkExistUsername(username)) {
			return false;
			}
			userDao.insertregister(new Users(username, email, fullname, password, 2, 1, code)); 
			return true;
	}

	@Override
	public Users login(String username, String password) {
		Users user =this.findOne(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.checkExistUsername(username);
	}
	
	

}
