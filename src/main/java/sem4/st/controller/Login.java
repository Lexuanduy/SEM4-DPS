package sem4.st.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sem4.st.entities.Account;
import sem4.st.model.AccountModel;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	static Logger logger = Logger.getLogger(Login.class.getName());
	private static final long serialVersionUID = 1L;
	AccountModel accountModel = new AccountModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		Account acc = new Account();
		acc.setUserName(userName);
		acc.setPassWord(passWord);

		if (login(acc) == true) {
			response.setStatus(200);
		} else {
			response.setStatus(404);
		}
	}

	private boolean login(Account acc) {
		Account acc2 = accountModel.searchByName(acc.getUserName());
		String salt = acc2.getSalt();
		logger.info("salt: " + salt);
		String passWord = acc.getPassWord();
		logger.info("passWord: " + passWord);

		String passEnd = generatePassword(passWord, salt);
		logger.info("passEnd: " + passEnd);

		if (acc2 == null) {
			logger.info("userName not exist!");
			return false;
		} else {
			if (passEnd.equals(acc2.getPassWord())) {
				logger.info("login success!");
				return true;
			} else {
				logger.info("login error passWord!");
				return false;
			}
		}
	}

	private String generatePassword(String passFirst, String salt) {
		// TODO Auto-generated method stub
		String str = passFirst + salt;
		logger.info("str: " + str);
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] hashInBytes = md.digest(str.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		for (byte b : hashInBytes) {
			sb.append(String.format("x", b));
		}

		String passEnd = sb.toString();

		logger.info("passEnd: " + passEnd);
		return passEnd;
	}

}
