import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        QueryMovie queryMovie = new QueryMovie();


        try {
            System.out.println("Enter the Star Wars episode number: ");
            int episodeNumber = Integer.parseInt(userInput.nextLine());
            Movie queriedMovie = queryMovie.queryMovie(episodeNumber);

            System.out.println(queriedMovie);

            FileGenerator fileGenerator = new FileGenerator();
            fileGenerator.savejson(queriedMovie);
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid episode number - " + e.getMessage());

        } catch (RuntimeException | IOException e) {
            System.out.println("Exit on error - " + e.getMessage());

        } finally {
            System.out.println("\n\n\nFinished application.");
        }
    }
}
