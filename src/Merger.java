import java.io.*;

public class Merger {

    final String beginningPath = "beginning";
    final String middlePath = "middle";
    final String endPath = "end";

    void merge() throws IOException {
        PrintWriter out = new PrintWriter("puzzle.tex");

        BufferedReader reader = new BufferedReader(new FileReader(beginningPath));
        String cur = reader.readLine();
        while (cur != null) {
            out.println(cur);
            cur = reader.readLine();
        }

        reader = new BufferedReader(new FileReader(middlePath));
        cur = reader.readLine();
        while (cur != null) {
            out.println(cur);
            cur = reader.readLine();
        }

        reader = new BufferedReader(new FileReader(endPath));
        cur = reader.readLine();
        while (cur != null) {
            out.println(cur);
            cur = reader.readLine();
        }

        out.close();
    }

}
