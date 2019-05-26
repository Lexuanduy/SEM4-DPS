package sem4.st.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sem4.st.entities.Subject;
import sem4.st.model.SubjectModel;

/**
 * Servlet implementation class Subject
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubjectServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertSubject(request, response);
				break;
			case "/delete":
				deleteSubject(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateSubject(request, response);
				break;
			default:
				listSubject(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List< Subject > listSubject = SubjectModel.listAllSubject();
		request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/subjects/SubjectList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/subjects/FormSubject.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		Subject existingSubject = SubjectModel.SearchById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/subjects/FormSubject.jsp");
		request.setAttribute("user", existingSubject);
		dispatcher.forward(request, response);

	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		Subject newSubject = new Subject();
		newSubject.setName(name);
		SubjectModel.createSubject(newSubject);
		response.sendRedirect("list");
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		long updatedAt = Long.parseLong(request.getParameter("updatedAt"));

		Subject subject = new Subject();
		subject.setId(id);
		subject.setName(name);
		subject.setUpdatedAt(updatedAt);
		SubjectModel.updateSubject(subject);
		response.sendRedirect("list");
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String id = request.getParameter("id");
		SubjectModel.deleteSubject(id);
		response.sendRedirect("list");

	}

}
