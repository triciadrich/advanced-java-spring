package platform.codingnomads.co.springtest.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MockitoTest {
    @MockBean
    MovieService movieService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllMoviesSuccessMockService() throws Exception {
        when(movieService.getAllMovies()).thenReturn(
                new ArrayList<>(Arrays.asList(
                        Movie.builder()
                                .id(1L)
                                .name("Oceans 8")
                                .rating(10.0)
                                .build(),
                        Movie.builder()
                                .id(2L)
                                .name("Oceans 11")
                                .rating(9.0)
                                .build(),
                        Movie.builder()
                                .id(3L)
                                .name("low movie")
                                .rating(1.0)
                                .build(),
                        Movie.builder()
                                .id(4L)
                                .name("low movie 2")
                                .rating(4.0)
                                .build()))

        );

        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Oceans 8"))
                .andExpect(jsonPath("$[0].rating").value(10.0))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Oceans 11"))
                .andExpect(jsonPath("$[1].rating").value(9.0));
    }


}
