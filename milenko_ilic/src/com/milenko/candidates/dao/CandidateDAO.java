package com.milenko.candidates.dao;

import java.util.List;

import com.milenko.candidates.model.Candidate;

public interface CandidateDAO {

	public int save(Candidate candidate);

	public int update(Candidate candidate);

	public Candidate get(Integer id);
	
	public int delete(Integer id);

	public List<Candidate> list();
}
