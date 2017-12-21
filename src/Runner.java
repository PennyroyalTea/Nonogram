import java.io.IOException;
import java.io.PrintWriter;

public class Runner {

    public static void main(String[] args) throws IOException {
        String path;
        if (args.length > 0) {
            path = args[0];
        } else {
            path = "image.pbm";
        }

        boolean[][] map = new Parser().parsePBM(path);

        String table = new Generator().generate(map);

        PrintWriter out = new PrintWriter("middle");
        out.println(table);
        out.close();

        new Merger().merge();
    }
}
