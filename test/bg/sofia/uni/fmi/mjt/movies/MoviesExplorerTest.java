package bg.sofia.uni.fmi.mjt.movies;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import bg.sofia.uni.fmi.mjt.movies.model.Movie;

public class MoviesExplorerTest {
    
    private MoviesExplorer me;
    
/*    @Before
    public void loadData(){
        try {
            InputStream is = new FileInputStream("movies-mpaa.txt");
            me = new MoviesExplorer(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    
    @Before
    public void loadData() throws IOException{
        String dataInput = "Title1 (1990)/ActorLastName1, Name1/ActorLastName2, Name2 \nTitleMovie2 (1991)/ LastName1, Name1/LastName2, Name2/ LastName3, Name3 \nTitle3 (2000)/Actor1/Actor2, Name2/Actor3, Name3";
        ByteArrayInputStream input = new ByteArrayInputStream(dataInput.getBytes());
        me = new MoviesExplorer(input);
    }

    @Test
    public void testGetMovies() throws IOException {
       // Collection<Movie> collection = me.getMovies();
        assertTrue(me.getMovies().contains("Title1"));
        assertTrue(me.getMovies().contains("TitleMovie2"));
        assertTrue(me.getMovies().contains("Title3"));
    }
    
    @Test
    public void testCountMoviesReleasedIn() {
        assertEquals(1, me.countMoviesReleasedIn(1991));
    }
    
    @Test
    public void testFindFirstMovieWithTitle() {
        assertEquals("TitleMovie2", me.findFirstMovieWithTitle("TitleMovie2").getTitle());
    }
}
