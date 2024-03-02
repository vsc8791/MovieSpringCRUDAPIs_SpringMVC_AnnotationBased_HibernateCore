package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.MovieDAO;
import com.amigos.dto.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieDAO movieDAO;

	@Override
	public List<Movie> getAll() {
		return movieDAO.getAll();
	}

	@Override
	public Movie getMovieById(Long id) {
		return movieDAO.getMovieById(id);
	}

	@Override
	public void save(Movie movie) {
		movieDAO.save(movie);
	}

	@Override
	public void update(Movie movie) {
		movieDAO.update(movie);
	}

	@Override
	public void delete(Long id) {
		movieDAO.delete(id);
	}

}
