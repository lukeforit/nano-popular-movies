package com.rabbit.green.movies.app;

import com.rabbit.green.movies.app.data.model.Movie;
import com.rabbit.green.movies.app.data.repo.IMoviesRepository;
import com.rabbit.green.movies.app.data.repo.IMoviesRestService;
import com.rabbit.green.movies.app.di.ApiModule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;

public class ApiModuleUnitTest {

    private MockWebServer mockWebServer;
    private IMoviesRepository repository;

    @Before
    public void setup() {
        ApiModule apiModule = new ApiModule();
        mockWebServer = new MockWebServer();
        String mockServerUrl = mockWebServer.url("/").toString();
        Retrofit retrofit = apiModule.provideRetrofit(mockServerUrl);
        IMoviesRestService restService = apiModule.provideMoviesRestService(retrofit);
        repository = apiModule.provideMoviesRepository(restService, "fake_key");
    }

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void moviesTopRated_callSuccessful() throws IOException {
        MockResponse response = new MockResponse();
        response.setResponseCode(200)
                .setBody(ResourcesUtils.jsonFileToString("movie_response.json"));
        mockWebServer.enqueue(response);
        List<Movie> result = repository.getTopRatedMovies(1);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void moviesTopRated_callUnsuccessful_404() throws IOException {
        MockResponse response = new MockResponse();
        response.setResponseCode(404);
        mockWebServer.enqueue(response);
        List<Movie> result = repository.getTopRatedMovies(1);
        Assert.assertNull(result);
    }

    @Test
    public void moviesTopRated_callUnsuccessful_emptyBody() throws IOException {
        MockResponse response = new MockResponse();
        response.setResponseCode(200)
                .setBody("");
        mockWebServer.enqueue(response);
        List<Movie> result = repository.getTopRatedMovies(1);
        Assert.assertNull(result);
    }

    @Test
    public void moviesPopular_callSuccessful() throws IOException {
        MockResponse response = new MockResponse();
        response.setResponseCode(200)
                .setBody(ResourcesUtils.jsonFileToString("movie_response.json"));
        mockWebServer.enqueue(response);
        List<Movie> result = repository.getPopularMovies(1);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
    }
}