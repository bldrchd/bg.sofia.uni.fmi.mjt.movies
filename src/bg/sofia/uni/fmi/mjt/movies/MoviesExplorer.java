package bg.sofia.uni.fmi.mjt.movies;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bg.sofia.uni.fmi.mjt.movies.model.Actor;
import bg.sofia.uni.fmi.mjt.movies.model.Movie;

public class MoviesExplorer {
    
    private List<Movie> movies = null;
    /**
     * Loads the dataset from the given {@code dataInput} stream.
     * @throws IOException 
     */
    public MoviesExplorer(InputStream dataInput) throws IOException {
       // throw new UnsupportedOperationException("Method not yet implemented");
         try( BufferedReader reader = new BufferedReader(new InputStreamReader(dataInput))) {
             movies = reader.lines().map(Movie::createMovie).collect(Collectors.toList());
         }
    }

    /**
     * Returns all the movies loaded from the dataset.
     **/
    public Collection<Movie> getMovies() {
        List<Movie> list = movies.stream().collect(Collectors.toList());
        return list;
    }

    // Other methods ...
    /*
     * Returns the count of the movies released in @code year
     * */
    public int countMoviesReleasedIn(int year){
        long count = movies.stream().filter(m -> m.getYear() == year).count();
        return (int) count;
    }
    
    /*
     * Returns the first (by order) movie from the data set that includes the @code title 
     * @throws IllegalArgumentException if not found such
     * */
    public Movie findFirstMovieWithTitle(String title) { 
        Optional<Movie> movie = movies.stream().filter(m -> m.getTitle().equals(title)).findFirst();
        if (movie.isPresent())
            return movie.get();
        throw new IllegalArgumentException();
    }
    
    /*
     * Returns all the actors in the data set
     * */
    public Collection<Actor> getAllActors() {
        
        return  null;
    }
    
    /*
     * Returns the earliest release year   
     */
    public int getFirstYear() {
        int year = 0;
        return year;
    }
    
    /*
     * Returns a collection of all movies that an actor presents
     * */
    public Collection<Movie> getAllMoviesBy(Actor actor){
        return null;
        
    }
    /*
     * Returns a collection of all movies, sorted by year of release in ascendent order
     * */
    public Collection<Movie> getMoviesSortedByReleaseYear() {
        return null;
    }
    /*
     * Returns an year that has least released movies. If there are two or more - returns randomly one
     * */
    public int findYearWithLeastNumberOfReleasedMovies(){
       // ComparatorByYear cby = (y1, y2) -> return cby.compare(m1, m2);
        return 0;
    }
    
    /*
     * Returns a Movie that contains the biggest number of actors in it. If there is two or more, returns randomly one.
     * */
    public Movie findMovieWithGreatestNumberOfActors() {
        return null;
    }
}
