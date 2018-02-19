package com.rabbit.green.movies.app.data.repo;

public class MoviesRetrofitRepository {
    private static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static final String DISCOVER = "discover/movie";
    private static final String MOVIE = "movie";
    private static final String SORT_BY_PARAM = "sort_by";
    private static final String SORT_BY_POPULARITY = "popularity.desc";
    private static final String SORT_BY_RELEASE_DATE = "release_date.desc";
    private static final String SORT_BY_VOTE_AVERAGE = "vote_average.desc";
    private static final String API_KEY_PARAM = "api_key";

    private static final String JSON_MOVIES_ARRAY = "results";
    private static final String JSON_POSTER_PATH = "poster_path";
    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_VOTE_AVERAGE = "vote_average";
    private static final String JSON_OVERVIEW = "overview";
    private static final String JSON_RELEASE_DATE = "release_date";

    private static final String POSTER_BASEURL = "http://image.tmdb.org/t/p/";
    public static final String POSTER_SIZE_W185 = "w185/";
    public static final String POSTER_SIZE_W342 = "w342/";
    public static final String POSTER_SIZE_W500 = "w500/";
    public static final String POSTER_SIZE_W780 = "w780/";

    private String key;

    public static String posterPath(String relativePath){
        return POSTER_BASEURL + POSTER_SIZE_W342 + relativePath;
    }
    public static String posterPath(String relativePath, String size){
        return POSTER_BASEURL + size + relativePath;
    }
}
