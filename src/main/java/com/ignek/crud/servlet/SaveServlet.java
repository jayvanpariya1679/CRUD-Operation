package com.ignek.crud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
		PrintWriter out = response.getWriter();
		String id = request.getParameter(StudentConstance.ID);
		int status = 0;
		int sid = 0;
		if (!id.equals(null) && !id.equals(StudentConstance.BLANK)) {
			sid = Integer.parseInt(id);
		}

		String firstName = request.getParameter(StudentConstance.FIRSTNAME);
		String lastName = request.getParameter(StudentConstance.LASTNAME);
		String email = request.getParameter(StudentConstance.EMAIL);
		String phoneNumber = request.getParameter(StudentConstance.PHONENUMBER);
		String gender = request.getParameter(StudentConstance.GENDER);
		String course = request.getParameter(StudentConstance.COURSE);

		Student student = new Student();
		student.setId(sid);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setPhoneNumber(phoneNumber);
		student.setGender(gender);
		student.setCourse(course);

		if (sid != 0) {
			status = StudentDao.update(student);
			out.print("<p>Record Updated successfully</p>");
		} else {
			status = StudentDao.save(student);
			out.print("<p>Record saved successfully</p>");
		}
		if (status > 0) {
			request.getRequestDispatcher("index.jsp").include(request, response);
		}

		out.close();
	}
}
