import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Parser {

    /*

     */
    boolean[][] parsePBM(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String currentLine = reader.readLine();
        while (currentLine.charAt(0) == '#') {
            currentLine = reader.readLine();
        }
        String format = currentLine;

        //
        System.err.println("format is " + format + (format.toLowerCase().equals("p1") ? "" : "which is bad."));
        //

        currentLine = reader.readLine();
        while (currentLine.charAt(0) == '#') {
            currentLine = reader.readLine();
        }
        StringTokenizer tokenizer = new StringTokenizer(currentLine);

        int m = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());

        boolean[][] result = new boolean[n][m];

        for (int i = 0; i < n; ++i) {
            currentLine = reader.readLine();
            while (currentLine.charAt(0) == '#') {
                currentLine = reader.readLine();
            }
            tokenizer = new StringTokenizer(currentLine);

            for (int j = 0; j < m; ++j) {
                if (tokenizer.nextToken().charAt(0) == '0') {
                    result[i][j] = false;
                } else {
                    result[i][j] = true;
                }
            }
        }

        return result;
    }

}
