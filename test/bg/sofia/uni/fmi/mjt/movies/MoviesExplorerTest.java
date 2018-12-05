package bg.sofia.uni.fmi.mjt.movies;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import bg.sofia.uni.fmi.mjt.movies.model.Actor;
import bg.sofia.uni.fmi.mjt.movies.model.Movie;

public class MoviesExplorerTest {
    
    private MoviesExplorer me;
    
    @Before
    public void loadData() {
        String dataInput = "Title1 (1990)/ActorLastName1, Name1/ActorLastName2, Name2 \nTitleMovie2 (1991)/ LastName1, Name1/LastName2, Name2/ LastName3, Name3 \nTitle3 (2000)/Actor1/Actor2, Name2/Actor3, Name3";
        try (ByteArrayInputStream input = new ByteArrayInputStream(dataInput.getBytes())) {
            me = new MoviesExplorer(input);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void testGetMovies() throws IOException {
       List<String> titles = new LinkedList<>();
        for (Movie m : me.getMovies()) {
            titles.add(m.getTitle());
        }
        assertTrue(titles.contains("Title1"));
        assertTrue(titles.contains("TitleMovie2"));
        assertTrue(titles.contains("Title3"));
    }
    
    @Test
    public void testCountMoviesReleasedIn() {
        assertEquals(1, me.countMoviesReleasedIn(1991));
    }
    
    @Test
    public void testFindFirstMovieWithTitle() {
        assertEquals("TitleMovie2", me.findFirstMovieWithTitle("TitleMovie2").getTitle());
    }
    
    @Test
    public void testGetAllActors() throws IOException {
        LinkedList<Actor> test = new LinkedList<Actor>();
        Collection<Actor> actors = me.getAllActors();
        actors.stream().forEach(a -> {
            System.out.println(a.getFirstName() + " " + a.getLastName());
            assertTrue(a.equals(test.iterator().next())); 
            } );
    }
    
    @Test
    public void testGetFirstYear() {
        assertEquals(1990, me.getFirstYear());
    }
    
    @Test
    public void testGetAllMoviesByActor() {
        Actor actor = new Actor("Actor1",null);
        Movie m = Movie.createMovie("Title3 (2000)/Actor1/Actor2, Name2/Actor3, Name3");
        Collection<Movie> movies = me.getAllMoviesBy(actor);
        assertTrue(movies.stream().allMatch(mov -> mov.equals(m)));
    }
    
    @Test
    public void testFindYearWithLeastNumberOfReleasedMovies(){
        String dataInput = "Title1 (1990)/ActorLastName1, Name1/ActorLastName2, Name2 \nTitleMovie2 (2000)/ LastName1, Name1/LastName2, Name2/ LastName3, Name3 \nTitle3 (2000)/Actor1/Actor2, Name2/Actor3, Name3";
        try (ByteArrayInputStream input = new ByteArrayInputStream(dataInput.getBytes())) {
            me = new MoviesExplorer(input);
            assertEquals(1990, me.findYearWithLeastNumberOfReleasedMovies());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    @Test
    public void testFindMovieWithGreatestNumberOfActors() {
        Movie m = Movie.createMovie("Title3 (2000)/Actor1/Actor2, Name2/Actor3, Name3");
        assertTrue(m.equals(me.findMovieWithGreatestNumberOfActors()));
    }
}
