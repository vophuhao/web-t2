package vn.iostart.service;

import vn.iostart.model.Users;

public interface IUserService {
	Users findOne (String username); // hàm lấy 01 đối tượng User theo username
	void insert(Users user); // hàm này thêm dữ liệu mới cho User
	void update (Users user); // hàm này cập nhật 1 đối tượng User
	void updatestatus (Users user); //hàm này dùng active tài khoản
	void delete(int id); // hàm này xóa 1 đối tượng User
	boolean register (String email, String password, String username, String fullname, String code);
	Users login(String username, String password);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
}
