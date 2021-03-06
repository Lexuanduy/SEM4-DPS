package sem4.st.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
/*import javax.servlet.annotation.WebServlet;*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sem4.st.entities.Subject;
import sem4.st.model.SubjectModel;

/**
 * Servlet implementation class Subject
 */
/* @WebServlet("/SubjectServlet") */
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
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/SubjectServlet/new":
				showNewForm(request, response);
				break;
			case "/SubjectServlet/insert":
				insertSubject(request, response);
				break;
			case "/SubjectServlet/delete":
				deleteSubject(request, response);
				break;
			case "/SubjectServlet/edit":
				showEditForm(request, response);
				break;
			case "/SubjectServlet/update":
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Subject> listSubject = SubjectModel.listAllSubject();
		request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/SubjectList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/FormSubject.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		Subject existingSubject = SubjectModel.SearchById(id);
		System.out.println(existingSubject.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/FormSubject.jsp");
		request.setAttribute("subject", existingSubject);
		dispatcher.forward(request, response);

	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Subject newSubject = new Subject();
		newSubject.setId(id);
		newSubject.setName(name);
		newSubject.setStatus(1);
		newSubject.setCreatedAt(new Date().getTime());
		newSubject.setUpdatedAt(new Date().getTime());
		SubjectModel.createSubject(newSubject);
		response.sendRedirect("/SubjectServlet");
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		/* long updatedAt = Long.parseLong(request.getParameter("updatedAt")); */

		Subject subject = new Subject();
		subject.setId(id);
		subject.setName(name);
		subject.setStatus(1);
		subject.setUpdatedAt(new Date().getTime());
		System.out.println(subject.toString());
		SubjectModel.updateSubject(subject);
		response.sendRedirect("/SubjectServlet");
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String id = request.getParameter("id");
		SubjectModel.deleteSubject(id);
		response.sendRedirect("/SubjectServlet");

	}

}
