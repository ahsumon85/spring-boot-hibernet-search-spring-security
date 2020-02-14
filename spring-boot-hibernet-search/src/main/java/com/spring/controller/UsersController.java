package com.spring.controller;

import com.spring.model.dto.UserDTO;
import com.spring.model.entity.User;
import com.spring.service.HibernateSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsersController {

	@Autowired
	private HibernateSearchService searchservice;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String search(@RequestParam(value = "value", required = false) String value, Model model) {
		List<UserDTO> searchResults = null;
		try {
			searchResults = searchservice.fuzzySearch(value);
			searchResults.forEach((name) -> System.out.println(name.getEmail()));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		model.addAttribute("users", searchResults);
		return "users-list";

	}

}
