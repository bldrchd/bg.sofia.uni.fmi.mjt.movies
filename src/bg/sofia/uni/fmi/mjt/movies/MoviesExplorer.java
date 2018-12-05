package bg.sofia.uni.fmi.mjt.movies;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
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
         try( BufferedReader reader = new BufferedReader(new InputStreamReader(dataInput))) {
             movies = reader.lines().map(Movie::createMovie).collect(Collectors.toList());
         }
    }

    /**
     * Returns all the movies loaded from the dataset.
     **/
    public Collection<Movie> getMovies() {
        return movies.stream().collect(Collectors.toList());
    }

    // Other methods ...
    /*
     * Returns the count of the movies released in @code year
     * */
    public int countMoviesReleasedIn(int year){
        return (int) movies.stream().filter(m -> m.getYear() == year).count();
    }
    
    /*
     * Returns the first (by order) movie from the data set that includes the @code title 
     * @throws IllegalArgumentException if not found such
     * */
    public Movie findFirstMovieWithTitle(String title) { 
            return movies.stream().filter(m -> m.getTitle().equals(title))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
    }
    
    /*
     * Returns all the actors in the data set
     * */
    public Collection<Actor> getAllActors() {
        //Set<Actor> a = movies.stream().collect(Collections.copy(Movie::getActors, a);
        return null;
    }
    
    /*
     * Returns the earliest release year   
     */
    public int getFirstYear() {
        List<Integer> years = movies.stream().map(Movie::getYear).collect(Collectors.toList());
        return years.stream().mapToInt(v -> v).min().getAsInt();
    }
    
    /*
     * Returns a collection of all movies that an actor presents
     * */
    public Collection<Movie> getAllMoviesBy(Actor actor){
        return movies.stream().filter(m -> m.getActors().contains(actor)).collect(Collectors.toList());
        
    }
    /*
     * Returns a collection of all movies, sorted by year of release in ascendent order
     * */
    public Collection<Movie> getMoviesSortedByReleaseYear() {
        return movies.stream().sorted(Comparator.comparing(Movie::getYear)).collect(Collectors.toList());
    }
    /*
     * Returns an year that has least released movies. If there are two or more - returns randomly one
     * */
    public int findYearWithLeastNumberOfReleasedMovies(){
        Map<Integer, Long> years = movies.stream().collect(Collectors.groupingBy(Movie::getYear, Collectors.counting()));
        return years.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
    }
    
    /*
     * Returns a Movie that contains the biggest number of actors in it. If there is two or more, returns randomly one.
     * */
    public Movie findMovieWithGreatestNumberOfActors() {
        Map<Movie, Integer> mov = new HashMap<>();
        for(Movie m : movies) {
            mov.put(m, m.getActors().size());
        }
        return mov.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }
}
