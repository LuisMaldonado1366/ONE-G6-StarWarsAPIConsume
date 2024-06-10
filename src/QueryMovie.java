import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QueryMovie {

    public Movie queryMovie(int movieId) {
        Movie queriedMovie;

        URI movieUrl = URI.create("https://swapi.dev/api/films/" + movieId);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(movieUrl)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            queriedMovie = new Gson().fromJson(response.body(), Movie.class);

        } catch (Exception e) {

            throw new RuntimeException("Movie not found");
        }

        return queriedMovie;
    }
}
