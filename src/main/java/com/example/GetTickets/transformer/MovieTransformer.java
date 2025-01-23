package com.example.GetTickets.transformer;

import com.example.GetTickets.dto.request.MovieRequest;
import com.example.GetTickets.dto.response.MovieResponse;
import com.example.GetTickets.model.Movie;

public class MovieTransformer {
    public static Movie movieRequestToMovie(MovieRequest movieRequest){
                return Movie.builder()
                .movieName(movieRequest.getMovieName())
                .duration(movieRequest.getDuration())
                .releaseDate(movieRequest.getReleaseDate())
                .language(movieRequest.getLanguage())
                .rating(movieRequest.getRating())
                .build();
    }

    public static MovieResponse movieToMovieResponse(Movie movie) {

        return MovieResponse.builder()
                .movieName(movie.getMovieName())
                .language(movie.getLanguage())
                .build();
    }
}
