package studentpage.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentpage.model.Student;

public class StudentDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/studentPage?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "American";
	
	private static final String INSERT_STUDENT_SQL = "INSERT INTO students" + " (firstName, lastName, email, majorClass, minorClass, semester, state, country) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SELECT_STUDENT_BY_ID = "select id,firstName,lastName,email,majorClass,minorClass,semester,state,country from students where id =?";
	private static final String SELECT_ALL_STUDENTS = "select * from students";
	private static final String DELETE_STUDENTS_SQL = "delete from students where id = ?;";
	private static final String UPDATE_STUDENTS_SQL = "update students set firstName = ?,lastname = ?,email = ?,majorClass = ?,minorClass = ?,semester = ?,state = ?,country = ? where id = ?;"; 
	
	//connection to sql
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		return connection;
	}
	
	
	
	//Create student info
	public void insertStudent(Student student) throws SQLException {
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setString(4, student.getMajorClass());
			preparedStatement.setString(5, student.getMinorClass());
			preparedStatement.setString(6, student.getSemester());
			preparedStatement.setString(7, student.getState());
			preparedStatement.setString(8, student.getCountry());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Update info
	public boolean updateStudent(Student student) throws SQLException {
		boolean rowUpdated;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);) {
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setString(3, student.getEmail());
			statement.setString(4, student.getMajorClass());
			statement.setString(5, student.getMinorClass());
			statement.setString(6, student.getSemester());
			statement.setString(7, student.getState());
			statement.setString(8, student.getCountry());
			statement.setInt(9, student.getId());
			
			rowUpdated = statement.executeUpdate() > 0;
			
		
		}
		return rowUpdated;
		
	}
	
	
	
	//select student by id
	public Student selectStudent(int id) {
		Student student = null;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			ResultSet r = preparedStatement.executeQuery();
			while (r.next()) {
				String firstName = r.getString("firstName");
				String lastName = r.getString("lastName");
				String email = r.getString("email");
				String majorClass = r.getString("majorClass");
				String minorClass = r.getString("minorClass");
				String semester = r.getString("semester");
				String state = r.getString("state");
				String country = r.getString("country");
				student = new Student(id, firstName, lastName, email, majorClass, minorClass, semester, state, country);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	
	//select students
	public List<Student> selectAllStudents() {
		List<Student> students = new ArrayList<>(); 
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
			System.out.println(preparedStatement);
			
			ResultSet r = preparedStatement.executeQuery();
			while (r.next()) {
				int id = r.getInt("id");
				String firstName = r.getString("firstName");
				String lastName = r.getString("lastName");
				String email = r.getString("email");
				String majorClass = r.getString("majorClass");
				String minorClass = r.getString("minorClass");
				String semester = r.getString("semester");
				String state = r.getString("state");
				String country = r.getString("country");
				students.add(new Student(id, firstName, lastName, email, majorClass, minorClass, semester, state, country));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	
	//delete student
	
	public boolean deleteStudent(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
		
	}

}
