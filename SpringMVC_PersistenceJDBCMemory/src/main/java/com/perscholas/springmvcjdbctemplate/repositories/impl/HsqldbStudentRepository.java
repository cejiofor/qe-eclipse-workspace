package com.perscholas.springmvcjdbctemplate.repositories.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.perscholas.springmvcjdbctemplate.model.Student;
import com.perscholas.springmvcjdbctemplate.repositories.StudentRepository;

@Repository("hsqldbStudentRepository")
public class HsqldbStudentRepository implements StudentRepository {

	@Autowired
	private NamedParameterJdbcTemplate hsqldbJdbcTemplate;

	@Override
	public Integer createStudent(Student student) {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", student.getName());
		params.addValue("email", student.getEmail());
		String createStudentSql = "insert into students (name, email) values "
				+ "(:name,:email)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = hsqldbJdbcTemplate.update(createStudentSql, 
				params, keyHolder);
		if (createResult > 0) {
			id = keyHolder.getKey().intValue();
		}
		return id;
	}
	@Override
	public Student getStudentById(Integer id) {
		String selectStudentsById = "select * from students where student_id = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Student student = null;
		try
		{
			student = (Student)hsqldbJdbcTemplate.queryForObject(
					selectStudentsById, params, new StudentMapper());
		}
		catch (EmptyResultDataAccessException e)
		{
			e.getMessage();
		}
		return student;
	}
	@Override
	public Boolean updateStudent(Student student) {
		Integer result;
		Map<String, Object> params = new HashMap<>();
		params.put("name", student.getName());
		params.put("email", student.getEmail());
		params.put("id", student.getStudentId());
		String updateSql = "update students set name = :name, email = :email "
				+ "where student_id = :id";
		result = hsqldbJdbcTemplate.update(updateSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
	@Override
	public Boolean deleteStudent(Integer studentId) {
		Integer result;
		String deleteSql = "delete from students where student_id = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", studentId);
		result = hsqldbJdbcTemplate.update(deleteSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Student> getAllStudents() throws ClassNotFoundException, IOException, SQLException {
		String selectStudents = "SELECT * FROM students";
		List<Student> result = hsqldbJdbcTemplate.query(selectStudents, 
				new StudentMapper());
		return result;
	}
	private final class StudentMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setStudentId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setEmail(rs.getString(3));
			return student;
		}
	}
}