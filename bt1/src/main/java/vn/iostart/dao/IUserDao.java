package vn.iostart.dao;

import java.util.List;

import vn.iostart.model.Users;

public interface IUserDao {
	
	List<Users> findAll(); // hàm lấy toàn bộ User
	Users findOne(int id); // hàm lấy 01 đối tượng User theo ID I
	Users findOne(String username); // hàm lấy 01 đối tượng User theo username
	void insert (Users user); // hàm này thêm dữ liệu mới cho User
	void insertregister (Users user); //ham này dùng cho register
	void update (Users user); // hàm này cập nhật 1 đối tượng User
	void updatestatus (Users user); //hàm này dùng active tài khoản
	void delete(int id); // hàm này xóa 1 đối tượng User
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	void updatePass(String Email,String userName,String Pass);
}
