package com.milenko.candidates.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.milenko.candidates.model.Candidate;

public class CandidateDAOImpl implements CandidateDAO {

	private JdbcTemplate jdbcTemplate;

	public CandidateDAOImpl(DataSource dataSouce) {
		this.jdbcTemplate = new JdbcTemplate(dataSouce);
	}

	@Override
	public int save(Candidate c) {
		String sql = "INSERT INTO Candidate (full_name, date_of_birth, contact_number, email) VALUES(?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getFull_name(), c.getDate_of_birth(), c.getContact_number(), c.getEmail());
	}

	@Override
	public int update(Candidate c) {
		String sql = "UPDATE Candidate SET full_name=?, date_of_birth=?, contact_number=?, email=? WHERE id=?";
		return jdbcTemplate.update(sql, c.getFull_name(), c.getDate_of_birth(), c.getContact_number(), c.getEmail(),
				c.getId());
	}

	@Override
	public Candidate get(Integer id) {
		String sql = "SELECT * FROM Candidate WHERE id=" + id;

		ResultSetExtractor<Candidate> extrator = new ResultSetExtractor<Candidate>() {

			@Override
			public Candidate extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String full_name = rs.getString("full_name");
					String date_of_birth = rs.getString("date_of_birth");
					String contact_number = rs.getString("contact_number");
					String email = rs.getString("email");

					return new Candidate(id, full_name, date_of_birth, contact_number, email);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extrator);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Candidate WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Candidate> list() {
		String sql = "SELECT * FROM Candidate";
		RowMapper<Candidate> rowMapper = new RowMapper<Candidate>() {

			@Override
			public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String full_name = rs.getString("full_name");
				String date_of_birth = rs.getString("date_of_birth");
				String contact_number = rs.getString("contact_number");
				String email = rs.getString("email");

				return new Candidate(id, full_name, date_of_birth, contact_number, email);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
}
