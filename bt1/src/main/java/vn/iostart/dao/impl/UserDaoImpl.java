package vn.iostart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import vn.iostart.dao.DBConnection;
import vn.iostart.dao.IUserDao;
import vn.iostart.model.Users;

public class UserDaoImpl implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
//	IUserRoleService userRoleService =new UserRoleServiceImpl(); // lấy dữ liệu từ UserRole

	
//	public List<Users> findAll() {
//	List<Users> userList = new ArrayList<Users>();
//	String sql="select Users.userId, users.email, Users.fullname, users.images, users.username, user
//	+ "from Users\r\n"
//	+ "INNER JOIN UserRoles ON Users.roleId = UserRoles.roleId";
//	try {
//	conn = new DBConnection().getConnection();
//	ps = conn.prepareStatement(sql);
//	rs ps.executeQuery();
//	while (rs.next()) {
//	UserRoles userRoles userRoleService.findOne(rs.getInt("roleId"));

	@Override
	public void insertregister(Users user) {
		String sql = "Insert INTO users (email, username, fullname, password, status, roleid, code) Values (?,?,?,?,?,?,?)";
		try {
			
			new DBConnection();
			conn = DBConnection.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getEmail());
			
			ps.setString(2, user.getUserName());
			
			ps.setString(3, user.getFullName());
			
			ps.setString(4, user.getPassWord());
			
			ps.setInt(5, user.getStatus());
			
			ps.setInt(6, user.getRoleid());
			
			ps.setString(7, user.getCode());
			
			ps.executeUpdate();
			
			System.out.println("hhh");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String sql = "Select * From users where email =?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String sql = "Select * From users where username =?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(duplicate);
		
		return duplicate;
	}

	@Override
	public void updatestatus(Users user) {
		String sql = "UPDATE [Users] SET status=?, code=? WHERE email = ?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getStatus());
			ps.setString(2, user.getCode());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Users findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updatePass(String Email,String userName,String Pass)
	{
		String sql = "UPDATE users SET password=? WHERE username = ?";
		try {
			new DBConnection();
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Pass);
			ps.setString(2, userName);
			ps.executeUpdate();
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Users findOne(String username) {
		
		String sql = "SELECT * FROM Users WHERE username = ?";
        Users user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            // Tạo kết nối đến cơ sở dữ liệu
            conn = DBConnection.getConnection();
            // Chuẩn bị câu lệnh SQL
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            // Thực thi câu lệnh và nhận kết quả
            rs = ps.executeQuery();
            
            // Kiểm tra xem có bản ghi nào trong ResultSet không
            if (rs.next()) {
                // Lấy thông tin từ ResultSet và tạo đối tượng User
                String email = rs.getString("email");
                String password=rs.getString("password");
                String userid = rs.getString("userid");
                String fullname=rs.getString("fullname");
                int status = rs.getInt("status");
                String code=rs.getString("code");
                int roleid=rs.getInt("roleid");
                user = new Users(email, username, fullname,password, roleid, status, code);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo tài nguyên được đóng trong khối finally
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }
    
	
	@Override
	public void insert(Users user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Users user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
