package com.ignek.crud.constance;

public class StudentConstance {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static final String USER = "user";

	public static final String PASSWORD = "password";

	public static final String PATH = "jdbc:mysql://localhost:3306/StudentForm";

	public static final String ID = "id";

	public static final String FIRST_NAME = "firstName";

	public static final String LAST_NAME = "lastName";

	public static final String EMAIL = "email";

	public static final String PHONE_NUMBER = "phoneNumber";

	public static final String GENDER = "gender";

	public static final String COURSE = "course";

	public static final String BLANK = "";

	public static final String SAVE_QUERY = "insert into form1(firstName,lastName,email,phoneNumber,gender,course) values (?,?,?,?,?,?)";

	public static final String UPDATE_QUERY = "update form1 set firstName=?,lastName=?,email=?,phoneNumber=?,gender=?,course=? where id=?";

	public static final String DELETE_QUERY = "delete from form1 where id=?";

	public static final String SELECT_QUERY_BY_ID = "select * from form1 where id=?";

	public static final String SELECT_QUERY = "select * from form1";

	public static final int DEFAULT_INTEGER = 0;

	public static final String EDIT_ID = "editId";

	public static final String DELETE_ID = "deleteId";

	public static final String STUDENT_LIST = "list";

	public static final String STUDENT_BY_ID = "student";

}
