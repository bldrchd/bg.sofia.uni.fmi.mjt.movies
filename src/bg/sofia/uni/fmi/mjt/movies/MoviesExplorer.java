package bg.sofia.uni.fmi.mjt.movies;

import java.io.InputStream;
import java.util.Collection;

import bg.sofia.uni.fmi.mjt.movies.model.Actor;
import bg.sofia.uni.fmi.mjt.movies.model.Movie;

public class MoviesExplorer {
    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public MoviesExplorer(InputStream dataInput) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * Returns all the movies loaded from the dataset.
     **/
    public Collection<Movie> getMovies() {
        return null;
    }

    // Other methods ...
    /*
     * Returns the count of the movies released in @code year
     * */
    public int countMoviesReleasedIn(int year){
        return year;
    }
    
    /*
     * Returns the first (by order) movie from the data set that includes the @code title 
     * @throws IllegalArgumentException if not found such
     * */
    public Movie findFirstMovieWithTitle(String title) throws IllegalArgumentException {
        return null;
        
    }
    
    /*
     * Returns all the actors in the data set
     * */
    public Collection<Actor> getAllActors() {
        return null;
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
        int year = 0;
        return year;
    }
    
    /*
     * Returns a Movie that contains the biggest number of actors in it. If there is two or more, returns randomly one.
     * */
    public Movie findMovieWithGreatestNumberOfActors() {
        return Movie;
    }
}
