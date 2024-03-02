package com.amigos.dao;

import java.util.List;

import com.amigos.dto.Movie;

public interface MovieDAO {

	List<Movie> getAll();

	Movie getMovieById(Long id);

	void save(Movie movie);

	void update(Movie movie);

	void delete(Long id);

}
