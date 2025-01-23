package com.example.GetTickets.service;

import com.example.GetTickets.dto.request.MovieRequest;
import com.example.GetTickets.model.Movie;
import com.example.GetTickets.repository.MovieRepository;
import com.example.GetTickets.transformer.MovieTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public String addMovie(MovieRequest movieRequest) {

        if(movieRepository.existsByMovieName(movieRequest.getMovieName())){
            return "This movie is already Existing";
        }
        Movie movie = MovieTransformer.movieRequestToMovie(movieRequest);
        Movie savedMovie = movieRepository.save(movie);

        return savedMovie.getMovieName()+" Movie as Successfully Added";
    }
}
