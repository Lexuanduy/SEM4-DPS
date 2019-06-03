package sem4.st.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sem4.st.entities.Score;
import sem4.st.entities.Student;
import sem4.st.entities.Subject;
import sem4.st.model.ScoreModel;
import sem4.st.model.StudentModel;
import sem4.st.model.SubjectModel;

/**
 * Servlet implementation class ScoreManager
 */
//@WebServlet("/ScoreManager")
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
		System.out.println(listScore.size());
		request.setAttribute("listScores", listScore);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/ScoreList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Score score = new Score();
		score.setAccountId("A001");
		List<Student> listStudent = StudentModel.listAllStudent("",1);
		System.out.println(listStudent.size());
		List<Subject> listSubject = SubjectModel.listAllSubject();
		System.out.println(listSubject.size());
		request.setAttribute("score", score);
		request.setAttribute("listStudent", listStudent);
		request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/FormScore.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int scoreId = Integer.parseInt(request.getParameter("scoreId"));
		Score existingScore = ScoreModel.searchByScoreId(scoreId);
		List<Student> listStudent = StudentModel.listAllStudent("",1);
		System.out.println(listStudent.size());
		List<Subject> listSubject = SubjectModel.listAllSubject();
		System.out.println(listSubject.size());
		System.out.println(existingScore.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/FormScore.jsp");
		request.setAttribute("score", existingScore);
		request.setAttribute("listStudent", listStudent);
		request.setAttribute("listSubject", listSubject);
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
		int scoreId = Integer.parseInt(request.getParameter("scoreId"));
		String idStudent = request.getParameter("idStudent");
		String idSubject = request.getParameter("idSubject");
		String score = request.getParameter("score");
		String accountId = request.getParameter("accountId");
		/* long updatedAt = Long.parseLong(request.getParameter("updatedAt")); */

		Score newScore = new Score();
		newScore.setScoreId(scoreId);
		newScore.setIdStudent(idStudent);
		newScore.setIdSubject(idSubject);
		newScore.setScore(Integer.parseInt(score));
		newScore.setAccountId(accountId);
		newScore.setCreatedAt(new Date().getTime());
		newScore.setUpdatedAt(new Date().getTime());
		System.out.println(newScore.toString());
		ScoreModel.updateScore(newScore);
		response.sendRedirect("/ScoreManager");
	}

	private void deleteScore(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int scoreId = Integer.parseInt(request.getParameter("scoreId"));
		ScoreModel.deleteScore(scoreId);
		response.sendRedirect("/ScoreManager");
	}

}
