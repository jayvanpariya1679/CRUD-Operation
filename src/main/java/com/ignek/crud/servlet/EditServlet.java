package com.ignek.crud.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.ignek.crud.constance.StudentConstance;
import com.ignek.crud.dao.StudentDao;
import com.ignek.crud.dto.Student;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String editId = request.getParameter("editId");
		String deleteId = request.getParameter("deleteId");
	
		if(editId != null) {
			Student Student_BY_ID = StudentDao.getStudentById(Integer.parseInt(editId));
			request.setAttribute(StudentConstance.STUDENT_BY_ID,Student_BY_ID);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if(deleteId!=null){
			StudentDao.delete(Integer.parseInt(deleteId));
			response.sendRedirect("ViewServlet");
		}
		
	}

}
