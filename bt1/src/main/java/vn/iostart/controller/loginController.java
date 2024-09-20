package vn.iostart.controller;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostart.model.Users;
import vn.iostart.service.IUserService;
import vn.iostart.service.impl.UserServiceImpl;
import vn.iostart.ultils.Constant;
import vn.iostart.ultils.Email;

//
@WebServlet(urlPatterns = { "/login", "/register", "/forgotpass","/logout", "/waiting", "/VerifyCode" })

public class loginController extends HttpServlet {
//
//	/**
//	 * 
//	 */
	private static final long serialVersionUID = 1L;
//

	IUserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String url = req.getRequestURL().toString();
		if (url.contains("register")) {
			getRegister(req, resp);
		} else if (url.contains("login")) {
			getLogin(req, resp);
		} else if (url.contains("forgotpass")) {
			req.getRequestDispatcher("views/web/forgotpassword.jsp").forward(req, resp);
		} else if (url.contains("waiting")) {
			getWaiting(req, resp);
		} else if (url.contains("VerifyCode")) {
			req.getRequestDispatcher("/views/web/verify.jsp").forward(req, resp);
		} else if (url.contains("logout")) {
			getlogout(req, resp);
		} 
	}

	private void getlogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("account"); // remove session
		System.out.println("jjj");
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
					cookie.setMaxAge(0); // <=> remove cookie resp.addCookie(cookie); // add again break;
				}
			}
		}
		resp.sendRedirect(req.getContextPath()+"/home");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("register")) {
			postRegister(req, resp);
		} else if (url.contains("login")) {
			postLogin(req, resp);
		} else if (url.contains("forgotpass")) {
			postForgotPassword(req, resp);
		} else if (url.contains("VerifyCode")) {
			postVerifyCode(req, resp);
		}
	}// home với method Get

	private void postVerifyCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {

			HttpSession session = req.getSession();
			Users user = (Users) session.getAttribute("account");
			String code = req.getParameter("authcode");
			if (code.equals(user.getCode()))

			{
				user.setEmail(user.getEmail());
				user.setStatus(1);

				userService.updatestatus(user);

				out.println("<div class=\"container\"><br/>\r\n" + " <br/>\r\n"
						+ "<br/>Kích hoạt tài khoản thành công! <br/>\r\n" + " <><br/></div>");
			} else {
				out.println("<div class=\"container\"><br/>\r\n" + " <br/>\r\n"
						+ "<br/>Sai mã kích hoạt, vui lòng kiểm tra lại<br/>\r\n" + " <br/></div>");
			}
		}
	}

	private void postForgotPassword(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		Users user = userService.findOne(username);
		if (user.getEmail().equals(email) && user.getUserName().equals(username)) {
			Email sm = new Email();
			boolean test = sm.Emailsend(user);
			if (test) {
				req.setAttribute("message", "Vui lòng kiểm tra email để nhận mật khẩu mới nhé");
			} else {
				req.setAttribute("error", "Lỗi gửi mail!");
			}
		} else {

			req.setAttribute("error", "Username hoặc Email không tồn tại trong hệ thống!");
			req.getRequestDispatcher("views/web/forgotpassword.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("views/web/forgotpassword.jsp").forward(req, resp);
	}

	private void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String alertMsg = "";

		if (userService.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
		} else if (userService.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
		}
//		} else {
//			Email sm = new Email();
//			// get the 6-digit code
//			String code = sm.getRandom();
//			// craete new user using all information
//			Users user = new Users(username, email, fullname, code);
//			boolean test = sm.sendEmail(user);
//			System.out.println(test);
//			if (test) {
//
//				HttpSession session = req.getSession();
//				session.setAttribute("account", user);
//				boolean isSuccess = userService.register(email, password, username, fullname, code);
//				if (isSuccess) {
//					resp.sendRedirect(req.getContextPath() + "/VerifyCode");
//				} else {
//					alertMsg = "Lỗi hệ thống!";
//					req.setAttribute("error", alertMsg);
//					req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
//				}
//			} else {
//				PrintWriter out = resp.getWriter();
//				out.println("Lỗi khi gửi mail!!!!!!!!");
//			}
//		}
			else
			{
				
				boolean isSuccess = userService.register(email, password, username, fullname, "007");
				alertMsg=("Dang ki thanh cong");
				req.setAttribute("succesful", alertMsg);
				if (isSuccess) {
					resp.sendRedirect(req.getContextPath() + "/login");
				} else {
					alertMsg = "Lỗi hệ thống!";
					req.setAttribute("error", alertMsg);
					req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
				}
			}
			
	}
	

	private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username);
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");
		if ("on".equals(remember)) {

			isRememberMe = true;
		}
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("message", alertMsg);
			req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);

		}
		Users user = userService.login(username, password);

		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(resp, username);
			}

			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}

	private void saveRemeberMe(HttpServletResponse resp, String username) {
		// TODO Auto-generated method stub

	}

	

	private void getWaiting(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			Users u = (Users) session.getAttribute("account");
			req.setAttribute("username", u.getUserName());
			if (u.getRoleid() == 1) {
				resp.sendRedirect(req.getContextPath() + "/admin/home");

			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}

		} else

		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

	private void getRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);

	}

	private static void getLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);

	}

}
