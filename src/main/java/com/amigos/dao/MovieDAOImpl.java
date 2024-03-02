package com.amigos.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.amigos.dto.Movie;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Movie> getAll() {
		Transaction tx = null;
		List<Movie> movies = new ArrayList<>();
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			movies = session.createQuery("FROM Movie", Movie.class).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
			movies = null;
		}
		return movies;
	}

	@Override
	public Movie getMovieById(Long id) {
		Transaction tx = null;
		Movie movie = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			movie = session.get(Movie.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return movie;
	}

	@Override
	public void save(Movie movie) {
		Transaction tx = null;

		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.save(movie);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void update(Movie movie) {
		Transaction tx = null;

		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.update(movie);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Long id) {
		Transaction tx = null;

		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			Movie movie = session.get(Movie.class, id);
			if (movie != null) {
				session.delete(movie);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
