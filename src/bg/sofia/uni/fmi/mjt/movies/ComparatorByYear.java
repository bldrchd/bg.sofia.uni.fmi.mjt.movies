package bg.sofia.uni.fmi.mjt.movies;

import java.util.Comparator;
import bg.sofia.uni.fmi.mjt.movies.model.Movie;

public class ComparatorByYear implements Comparator<Movie>{

   @Override
   public int compare(Movie m1, Movie m2) {
       return Integer.compare(m1.getYear(), m2.getYear());
    }
   
}
