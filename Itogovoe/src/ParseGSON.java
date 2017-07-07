
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;

public class ParseGSON implements Parser {

    @Override
    public Root parse() {

        Root root = null;
        String path = "student.json";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            /// Gson gson = new Gson();
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd").create();

            root = gson.fromJson(reader, Root.class);
        } catch (Exception ex) {
            System.out.println("error" + ex.toString());
        }
        return root;

    }
}
