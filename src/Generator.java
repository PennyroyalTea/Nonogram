import java.io.PrintWriter;
import java.util.ArrayList;

public class Generator {

    String generate(boolean[][] map) {
        int n = map.length;
        int m = (map.length > 0 ? map[0].length : 0);

        ArrayList<Integer>[] rows = new ArrayList[n];
        ArrayList<Integer>[] columns = new ArrayList[m];
        for (int i = 0; i < Math.max(n, m); ++i) {
            if (i < n) {
                rows[i] = new ArrayList<>();
            }
            if (i < m) {
                columns[i] = new ArrayList<>();
            }
        }
        /*
        rows calculating
         */
        for (int i = 0; i < n; ++i) {
            boolean newSegment = true;
            for (int j = 0; j < m; ++j) {
                if (map[i][j]) {
                    if (newSegment) {
                        rows[i].add(1);
                        newSegment = false;
                    } else {
                        int last = rows[i].get(rows[i].size() - 1);
                        rows[i].set(rows[i].size() - 1, last + 1);
                    }
                } else {
                    newSegment = true;
                }
            }
        }

        /*
        columns calculating
         */
        for (int j = 0; j < m; ++j) {
            boolean newSegment = true;
            for (int i = 0; i < n; ++i) {
                if (map[i][j]) {
                    if (newSegment) {
                        columns[j].add(1);
                        newSegment = false;
                    } else {
                        int last = columns[j].get(columns[j].size() - 1);
                        columns[j].set(columns[j].size() - 1, last + 1);
                    }
                } else {
                    newSegment = true;
                }
            }
        }

        int itemsLeft = 0, itemsUp = 0;
        for (int i = 0; i < n; ++i) {
            itemsLeft = Math.max(itemsLeft, rows[i].size());
        }
        for (int i = 0; i < m; ++i) {
            itemsUp = Math.max(itemsUp, columns[i].size());
        }

        /*
        generating the string
         */


        StringBuilder result = new StringBuilder();


        result.append("{|");
        for (int i = 0; i < m + itemsLeft; ++i) {
            result.append("p{5pt}|");
            if (i >= itemsLeft - 1 && (i - itemsLeft + 5) % 5 == 4) {
                result.append('|');
            }
        }
        result.append("}\n");

        for (int i = 0; i < n + itemsUp; ++i) {

            result.append("\\hline\n");
            if (i >= itemsUp && (i - itemsUp) % 5 == 0) {
                result.append("\\hline\n");
            }

            if (i < itemsUp) {
                for (int j = 0; j < itemsLeft; ++j) {
                    result.append(" &");
                }
                for (int j = 0; j < m; ++j) {
                    int arrayPos = columns[j].size() - itemsUp + i;

                    if (arrayPos < 0) {
                        result.append(" ");
                    } else {
                        result.append(columns[j].get(arrayPos));
                    }

                    if (j == m - 1) {
                        result.append("\\\\\n");
                    } else {
                        result.append("&");
                    }
                }
            } else {

                for (int j = 0; j < itemsLeft; ++j) {
                    int arrayPos = rows[i - itemsUp].size() - itemsLeft + j;
                    if (arrayPos < 0) {
                        result.append(" ");
                    } else {
                        result.append(rows[i - itemsUp].get(arrayPos));
                    }
                    result.append("&");
                }
                for (int j = 0; j < m; ++j) {
                    if (j == m - 1) {
                        result.append(" \\\\\n");
                    } else {
                        result.append(" &");
                    }
                }
            }
        }

        result.append("\\hline\n");

        return result.toString();

    }
}
