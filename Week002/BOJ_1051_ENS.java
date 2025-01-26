import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSquare_1051 {

    public static final int MAX_SEQUENCE = 10;
    public static int MAX_COUNT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] command = br.readLine().split(" ");
        int r = Integer.parseInt(command[0]);
        int c = Integer.parseInt(command[1]);

        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < line.length; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int maxSquare = compareMaxLength(r, c);

        for (int i = 0; i < MAX_SEQUENCE; i++) {
            searchWidthAndLength(map, i, maxSquare);
        }

        System.out.println(MAX_COUNT);
    }

    private static void searchWidthAndLength(int[][] map, int target, int maxSquare) {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                int maxCount = 0;
                if (map[r][c] == target) {
                    for (int k = maxSquare; k > 0; k--) {
                        //값이 인덱스 밖으로 넘어가지 않는 경우
                        if (r + k < map.length && c + k < map[r].length) {
                            int tar1 = map[r][c];
                            int tar2 = map[r][c + k];
                            int tar3 = map[r + k][c];
                            int tar4 = map[r + k][c + k];

                            if (tar1 == tar2 && tar2 == tar3 && tar3 == tar4) {
                                int number = k + 1;
                                maxCount = number * number;
                                break;
                            }
                        }
                    }
                    compareMaxSquare(maxCount);
                }
            }
        }
    }

    private static int compareMaxLength(int r, int c) {
        return Math.min(r, c);
    }

    private static void compareMaxSquare(int maxCount) {
        if (maxCount > MAX_COUNT) {
            MAX_COUNT = maxCount;
        }
    }
}
