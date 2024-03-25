package platform.codingnomads.co.springtest.lab;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import platform.codingnomads.co.springtest.TestUtil;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;



    @Test
    @Order(1)
    public void testGetAllMoviesSuccess() throws Exception {
        this.mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[0].rating").value(9.3))
//                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("The Pursuit of Happyness"))
                .andExpect(jsonPath("$[1].rating").value(8.0));
    }

    @Test
    @Order(2)
    public void testGetAllMoviesFailure() throws Exception {

        movieRepository.deleteAll();

        this.mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(0)));


    }




    @Test
    public void testGetAllMoviesJsonBytes() throws Exception{
        MvcResult mvcResult =
                mockMvc.perform(get("/all"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(jsonPath("$", hasSize(2)))
                        .andReturn();
        byte[] jsonByteArray =
                mvcResult.getResponse().getContentAsByteArray();
        Movie[] returnedMovies = TestUtil.convertJsonBytesToObject(
                jsonByteArray, Movie[].class
        );
        assertThat(returnedMovies.length).isEqualTo(2);

        for (Movie m: returnedMovies){
            assertThat(m).isNotNull();
            assertThat(m.getId()).isNotNull();

        }




    }
    @Test
    public void testGetAllMoviesByMinRatingJsonBytes() throws Exception{
        MvcResult mvcResult =
                mockMvc.perform(get("/min/9.0"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(jsonPath("$", hasSize(1)))
                        .andReturn();
        byte[] jsonByteArray =
                mvcResult.getResponse().getContentAsByteArray();
        Movie[] returnedMovies = TestUtil.convertJsonBytesToObject(
                jsonByteArray, Movie[].class
        );
        assertThat(returnedMovies.length).isEqualTo(1);

        for (Movie m: returnedMovies){
            assertThat(m).isNotNull();
            assertThat(m.getId()).isNotNull();

        }




    }


    @Test
    public void testGetAllMoviesByMinRatingJsonBytesFailure() throws Exception{
        MvcResult mvcResult =
                mockMvc.perform(get("/min/10.0"))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(jsonPath("$", hasSize(0)))
                        .andReturn();
        byte[] jsonByteArray =
                mvcResult.getResponse().getContentAsByteArray();
        Movie[] returnedMovies = TestUtil.convertJsonBytesToObject(
                jsonByteArray, Movie[].class
        );
        assertThat(returnedMovies.length).isEqualTo(0);

        for (Movie m: returnedMovies){
            assertThat(m).isNotNull();
            assertThat(m.getId()).isNotNull();

        }




    }
}
