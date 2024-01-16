package com.ignek.crud.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.ignek.crud.constance.StudentConstance;
import com.ignek.crud.dao.StudentDao;
import com.ignek.crud.dto.Student;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		List<Student> Student_List = StudentDao.getAllStudents();
		request.setAttribute(StudentConstance.STUDENT_LIST,Student_List);
		request.getRequestDispatcher("View.jsp").forward(request, response);
	}
}
