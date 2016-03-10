package com.ddubson.cassandra.v1.controllers;

import com.ddubson.cassandra.v1.models.Movie;
import com.ddubson.cassandra.v1.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddubson on 1/23/16.
 */
@RestController
public class AppController {
	@Autowired
	MovieRepository movieRepository;

	@RequestMapping("/movies")
	public List<Movie> index() {
		Iterable<Movie> movies = movieRepository.findAll();
		List<Movie> movieList = new ArrayList<>();
		movies.forEach(movieList::add);
		return movieList;
	}
}
