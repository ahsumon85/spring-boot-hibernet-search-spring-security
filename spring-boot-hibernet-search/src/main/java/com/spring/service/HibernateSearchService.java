package com.spring.service;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.dto.UserDTO;
import com.spring.model.entity.User;
import com.spring.repo.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Service
public class HibernateSearchService {

	@Autowired
	private final EntityManager centityManager;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	public HibernateSearchService(EntityManager entityManager) {
		super();
		this.centityManager = entityManager;
	}

	public void initializeHibernateSearch() {

		try {
			FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
			fullTextEntityManager.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public List<UserDTO> fuzzySearch(String searchTerm) {

		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
		QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(User.class).get();
		Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(2).withPrefixLength(0)
				.onFields("email", "lastName", "firstName").matching(searchTerm + "*").createQuery();

		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, User.class);

		List<UserDTO> userList = null;
		try {
			List<User> users = jpaQuery.getResultList();
			if (users.isEmpty()) {
				users = userRepository.findAll();
			}
			userList = userService.findAllUsers(users);
		} catch (NoResultException e) {
			System.out.println(e);
		}
		return userList;

	}
}
