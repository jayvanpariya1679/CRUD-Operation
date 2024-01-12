package com.ignek.crud.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter out = response.getWriter();
		String eId = request.getParameter("eId");
		String dId = request.getParameter("dId");
	
		if(eId != null) {
			Student student = StudentDao.getStudentById(Integer.parseInt(eId));
			request.setAttribute("student", student);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if(dId!=null){
			StudentDao.delete(Integer.parseInt(dId));
			response.sendRedirect("ViewServlet");
		}
		
	}

}
