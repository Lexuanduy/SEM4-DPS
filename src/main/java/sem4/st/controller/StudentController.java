package sem4.st.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sem4.st.entities.Student;
import sem4.st.model.StudentModel;

/**
 * Servlet implementation class StudentController
 */
//@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println("action - "+action);
		try {
			switch (action) {
			case "/StudentController/list":
				System.out.println("ok1");
				listStudent(request, response);
			break;
			case "/StudentController/new":
				showNewForm(request, response);
				break;
			case "/StudentController/insert":
				insertStudent(request, response);
				break;
			case "/StudentController/delete":
				deleteStudent(request, response);
				break;
			case "/StudentController/edit":
				showEditForm(request, response);
				break;
			case "/StudentController/update":
				updateStudent(request, response);
				break;
			default:
				System.out.println("ok");
				listStudent(request, response);
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
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String search = request.getParameter("search") == null ? "" : request.getParameter("search");;
		int page = request.getParameter("page") == null  ? 1 : Integer.parseInt(request.getParameter("page"));
		List<Student> listStudent = StudentModel.listAllStudent(search,page);
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/StudentList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/StudentForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String rollNumber = request.getParameter("rollNumber") == null ? "" : request.getParameter("rollNumber");
		Student existingStudent = StudentModel.searchByRollNumber(rollNumber);
		System.out.println(existingStudent.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/StudentForm.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String rollNum = request.getParameter("rollNumber");
		String gender = request.getParameter("gender");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String cmnd = request.getParameter("cmnd");
		String email = request.getParameter("email");
		String accountId = request.getParameter("accountId");
		System.out.println(request.getParameter("mediumScore"));
		Float mediumScore = Float.parseFloat(request.getParameter("mediumScore"));
		int status = Integer.parseInt(request.getParameter("status"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		long bod = 0;
		try {
			Date datebirth = sdf.parse(request.getParameter("bod"));
			bod =  datebirth.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		long createdAt = Long.parseLong(request.getParameter("createdAt"));
//		long updatedAt = Long.parseLong(request.getParameter("updatedAt"));
		Student student = new Student();
		student.setAccountId(accountId);
		student.setAddress(address);
		student.setBod(bod);
		student.setCmnd(cmnd);
		student.setCreatedAt(new Date().getTime());
		student.setEmail(email);
		student.setGender(gender);
		student.setMediumScore(mediumScore);
		student.setName(name);
		student.setPhone(phone);
		student.setRollNumber(rollNum);
		student.setStatus(status);
		student.setUpdatedAt(new Date().getTime());
		System.out.println(student.toString());
		StudentModel.createStudent(student);
		response.sendRedirect("/StudentController/list");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		long bod = 0;
		String rollNum = request.getParameter("rollNumber");
		String gender = request.getParameter("gender");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String cmnd = request.getParameter("cmnd");
		String email = request.getParameter("email");
		String accountId = request.getParameter("accountId");
		Float mediumScore = Float.parseFloat(request.getParameter("mediumScore"));
		int status = Integer.parseInt(request.getParameter("status"));
		try {
			Date datebirth = sdf.parse(request.getParameter("bod"));
			bod =  datebirth.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student student = new Student();
		student.setAccountId(accountId);
		student.setAddress(address);
		student.setBod(bod);
		student.setCmnd(cmnd);
		student.setEmail(email);
		student.setGender(gender);
		student.setMediumScore(mediumScore);
		student.setName(name);
		student.setPhone(phone);
		student.setRollNumber(rollNum);
		student.setStatus(status);
		student.setUpdatedAt(new Date().getTime());
		StudentModel.updateStudent(student);
		response.sendRedirect("/StudentController/list");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String rollNumber = request.getParameter("rollNumber");

		StudentModel.deleteStudent(rollNumber);
		response.sendRedirect("/StudentController/list");

	}

}
