package com.ignek.crud.servlet;

import java.io.IOException;
import javax.swing.JOptionPane;
import com.ignek.crud.constance.StudentConstance;
import com.ignek.crud.dao.StudentDao;
import com.ignek.crud.dto.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter(StudentConstance.ID);
		int status = StudentConstance.DEFAULT_INTEGER;
		int sid = StudentConstance.DEFAULT_INTEGER;
		if (!id.equals(null) && !id.equals(StudentConstance.BLANK)) {
			sid = Integer.parseInt(id);
		}

		String firstName = request.getParameter(StudentConstance.FIRST_NAME);
		String lastName = request.getParameter(StudentConstance.LAST_NAME);
		String email = request.getParameter(StudentConstance.EMAIL);
		String phoneNum = request.getParameter(StudentConstance.PHONE_NUMBER);
		long phoneNumber = Long.parseLong(phoneNum);
		String gender = request.getParameter(StudentConstance.GENDER);
		String course = request.getParameter(StudentConstance.COURSE);

		Student student = new Student(sid,firstName,lastName,email,phoneNumber,gender,course);
		

		if (sid != StudentConstance.DEFAULT_INTEGER) {
			status = StudentDao.update(student);
			JOptionPane.showMessageDialog(null, "Record Updated successfully");	
		} else {
			status = StudentDao.save(student);
			JOptionPane.showMessageDialog(null, "Record saved successfully");
		}
		if (status > StudentConstance.DEFAULT_INTEGER) {
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}
}
