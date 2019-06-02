package sem4.st.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sem4.st.entities.Score;
import sem4.st.model.ScoreModel;

/**
 * Servlet implementation class ScoreManager
 */
@WebServlet("/ScoreManager")
public class ScoreManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/ScoreManager/new":
				showNewForm(request, response);
				break;
			case "/ScoreManager/insert":
				insertScore(request, response);
				break;
			case "/ScoreManager/delete":
				deleteScore(request, response);
				break;
			case "/ScoreManager/edit":
				showEditForm(request, response);
				break;
			case "/ScoreManager/update":
				updateScore(request, response);
				break;
			default:
				listScore(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listScore(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Score> listScore = ScoreModel.listAllScore();
		request.setAttribute("listScore", listScore);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/ScoreList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/FormScore.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String idStudent = request.getParameter("idStudent");
		String idSubject = request.getParameter("idSubject");
		Score existingScore = ScoreModel.SearchByStudentIdSubjectId(idStudent, idSubject);
		System.out.println(existingScore.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/FormScore.jsp");
		request.setAttribute("score", existingScore);
		dispatcher.forward(request, response);

	}

	private void insertScore(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String idStudent = request.getParameter("idStudent");
		String idSubject = request.getParameter("idSubject");
		String score = request.getParameter("score");
		String accountId = request.getParameter("accountId");
		Score newScore = new Score();
		newScore.setIdStudent(idStudent);
		newScore.setIdSubject(idSubject);
		newScore.setScore(Integer.parseInt(score));
		newScore.setAccountId(accountId);
		newScore.setCreatedAt(new Date().getTime());
		newScore.setUpdatedAt(new Date().getTime());
		ScoreModel.saveScore(newScore);
		response.sendRedirect("/ScoreManager");
	}

	private void updateScore(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String idStudent = request.getParameter("idStudent");
		String idSubject = request.getParameter("idSubject");
		String score = request.getParameter("score");
		String accountId = request.getParameter("accountId");
		/* long updatedAt = Long.parseLong(request.getParameter("updatedAt")); */

		Score newScore = new Score();
		newScore.setIdStudent(idStudent);
		newScore.setIdSubject(idSubject);
		newScore.setScore(Integer.parseInt(score));
		newScore.setAccountId(accountId);
		newScore.setUpdatedAt(new Date().getTime());
		ScoreModel.updateScore(newScore);
		response.sendRedirect("/ScoreManager");
	}

	private void deleteScore(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String idSubject = request.getParameter("idSubject");
		String idStudent = request.getParameter("idStudent");
		ScoreModel.deleteScore(idSubject, idStudent);
		response.sendRedirect("/ScoreManager");
	}

}
