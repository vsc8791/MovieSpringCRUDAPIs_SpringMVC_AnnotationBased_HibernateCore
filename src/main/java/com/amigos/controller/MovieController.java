package com.amigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amigos.dto.Movie;
import com.amigos.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> getProducts() {
		List<Movie> movies = movieService.getAll();
		if (movies.isEmpty()) {
			return new ResponseEntity<List<Movie>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public ResponseEntity<Void> saveMovie(@RequestBody Movie movie, UriComponentsBuilder ucBuilder) {
		if (movie == null || movie.getTitle() == null || "".equals(movie.getTitle())) {
			throw new RuntimeException("Movie Title  are required fields");
		}
		movieService.save(movie);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/movie/{id}").buildAndExpand(movie.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/movie", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateMovie(@RequestBody Movie movie) {
		if (movie == null || movie.getTitle() == null || "".equals(movie.getTitle()) || movie.getId() <= 0) {
			throw new RuntimeException("Movie Title, Id  are required fields");
		}
		Movie updatedMovie = movieService.getMovieById(movie.getId());
		if (updatedMovie == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		movieService.update(movie);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public ResponseEntity<Movie> getProductByid(@PathVariable Long id) {
		Movie movie = movieService.getMovieById(id);
		if (movie == null) {
			return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/product/{name}", method = RequestMethod.GET) public
	 * ResponseEntity<Product> getProductByName(@PathVariable String name) { Product
	 * product = productService.findProductByName(name); if (product == null) {
	 * return new ResponseEntity<Product>(HttpStatus.NOT_FOUND); } return new
	 * ResponseEntity<Product>(product, HttpStatus.OK); }
	 */

	@RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProductByid(@PathVariable Long id) {
		Movie existingMovie = movieService.getMovieById(id);

		if (existingMovie == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		movieService.delete(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/products", method = RequestMethod.DELETE) public
	 * ResponseEntity<Void> deleteProducts() { productService.deleteAllProducts();
	 * return new ResponseEntity<Void>(HttpStatus.OK); }
	 */

}