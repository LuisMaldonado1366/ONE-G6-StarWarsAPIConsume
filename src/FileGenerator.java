import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public void savejson (Movie movie) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(movie.title() + ".json");
        writer.write(gson.toJson(movie));
        writer.close();

    }
}
