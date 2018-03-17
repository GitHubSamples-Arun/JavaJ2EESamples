package org.arpit.java2blog.dao;

import java.util.List;
import java.util.Random;

import org.arpit.java2blog.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(CountryDAO.class);

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Country> getAllCountries() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Country> countryList = session.createQuery("from Country").list();
		logger.info("Number of countries="+countryList.size());
		return countryList;
	}

	public Country getCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country country = (Country) session.get(Country.class, new Integer(id));
		return country;
	}

	public Country addCountry(Country country) {
		Session session = this.sessionFactory.getCurrentSession();
		Random rand = new Random();
		int x = rand.nextInt(100);
		country.setId(x);
		session.persist(country);
		logger.info("Country saved successfully, country Details="+country);
		return country;
	}

	public void updateCountry(Country country) {
		Session session = this.sessionFactory.getCurrentSession();
		logger.info("Country updated successfully, country Details="+country);
		session.update(country);
	}

	public void deleteCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country p = (Country) session.load(Country.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Country deleted successfully, country Details="+id);
	}	
}
