package edu.fa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import edu.fa.model.Student;

@Component
public class StudentJDBCDaoSupport extends JdbcDaoSupport{

	public void insertStudent(Student student) {
		String query = "insert into student values (" + student.getId() + ",'" + student.getName() + "','"
				+ student.getLocation() + "')";
		this.getJdbcTemplate().execute(query);
	}
	public void deleteStudent() {
		String query = "delete from student";
		this.getJdbcTemplate().execute(query);
	}
	public int countStudent() {
		String query = "select count(*) from student";
		return this.getJdbcTemplate().queryForObject(query, Integer.class);
	}
	
	public Student getStudentById(int id) {
		String query = "select * from student where id = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] {id}, new StudentMapper() );
		
	}
	
	public static final class StudentMapper implements RowMapper<Student> {
		public Student mapRow(ResultSet resultSet, int args) throws SQLException {
			return new Student(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("location"));
		}
	}

	
	public List<Student> getAllStudent() {
		String query = "select * from student";
		return this.getJdbcTemplate().query(query, new StudentMapper());
	}

}
