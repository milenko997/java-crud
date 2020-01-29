package com.milenko.candidates.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.milenko.candidates.model.Candidate;

class CandidateDAOTest {

	private DriverManagerDataSource dataSource;
	private CandidateDAO dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/candidates");
		dataSource.setUsername("root");
		dataSource.setPassword("milenko");
		dao = new CandidateDAOImpl(dataSource);
	}

	@Test
	void testSave() {
		Candidate candidate = new Candidate("Someone Else", "25. 11. 1997.", "0695833352", "someone.else@gmail.com");
		int result = dao.save(candidate);

		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Candidate candidate = new Candidate(2, "Vukasin Kosanovic", "16. 4. 1997.", "0695833352", "fuks.fcb@gmail.com");
		int result = dao.update(candidate);

		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 10;
		Candidate candidate = dao.get(id);
		if (candidate != null) {
			System.out.println(candidate);
		}
		assertNotNull(candidate);
	}

	@Test
	void testDelete() {
		Integer id = 3;
		int result = dao.delete(id);

		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Candidate> listCandidate = dao.list();

		for (Candidate aCandidate : listCandidate) {
			System.out.println(aCandidate);
		}

		assertTrue(!listCandidate.isEmpty());
	}

}
