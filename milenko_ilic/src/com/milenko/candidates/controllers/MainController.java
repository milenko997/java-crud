package com.milenko.candidates.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.milenko.candidates.dao.CandidateDAO;
import com.milenko.candidates.model.Candidate;

@Controller
public class MainController {

	@Autowired
	private CandidateDAO candidateDAO;

	@RequestMapping(value = "/")
	public ModelAndView listCandidate(ModelAndView model) {
		List<Candidate> listCandidate = candidateDAO.list();
		model.addObject("listCandidate", listCandidate);
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newCandidate(ModelAndView model) {
		Candidate newCandidate = new Candidate();
		model.addObject("candidate", newCandidate);
		model.setViewName("candidate_form");
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveCandidate(@ModelAttribute Candidate candidate) {
		candidateDAO.save(candidate);

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCandidate(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Candidate candidate = candidateDAO.get(id);

		ModelAndView model = new ModelAndView("candidate_form");

		model.addObject("candidate", candidate);

		return model;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteCandidate(@RequestParam Integer id) {
		candidateDAO.delete(id);

		return new ModelAndView("redirect:/");
	}
}
