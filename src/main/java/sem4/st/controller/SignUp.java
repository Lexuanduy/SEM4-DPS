package sem4.st.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger LOGGER = Logger.getLogger(SignUp.class.getName());
	AccountModel accountModel = new AccountModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUp() {
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
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/SignUp.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");

		LOGGER.info("userName: " + userName);
		LOGGER.info("passWord: " + passWord);

		String salt = getAlphaNumericString();

//		String salt = String.valueOf(System.currentTimeMillis());
		LOGGER.info("salt: " + salt);

		String passEnd = generatePassword(passWord, salt);

		Account acc = new Account();
		acc.setId(String.valueOf(System.currentTimeMillis() / 1000));
		acc.setUserName(userName);
		acc.setPassWord(passEnd);
		acc.setSalt(salt);
		acc.setCreatedAt(System.currentTimeMillis());
		acc.setUpdatedAt(System.currentTimeMillis());
		if (accountModel.register(acc) == true) {
			response.setStatus(200);
		} else {
			response.setStatus(404);
		}
	}

	private String getAlphaNumericString() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "02062019" + "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder(5);

		for (int i = 0; i < 5; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	private String generatePassword(String passFirst, String salt) {
		// TODO Auto-generated method stub
		String str = passFirst + salt;
		LOGGER.info("str: " + str);
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

		LOGGER.info("passEnd: " + passEnd);
		return passEnd;
	}

}
