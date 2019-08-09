//Exam Code: 
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        Set<String> obstacleList = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleList.add(obstacles[i][0] + " | " + obstacles[i][1]);
        }


        int verticalMovesCount = getPossibleVerticalMoves(n, r_q, c_q, obstacleList);
        int horizontalMovesCount = getPossibleHorizontalMoves(n, r_q, c_q, obstacleList);
        int diagonalMovesCount = getPossibleDiagonalMoves(n, r_q, c_q, obstacleList);

        int totalPossibleMovesCount = verticalMovesCount + horizontalMovesCount + diagonalMovesCount;

        System.out.println("possible moves count: " + totalPossibleMovesCount);
        return totalPossibleMovesCount;
    }
    private static int getPossibleVerticalMoves(int n, int r_q, int c_q, Set<String> obstacleList) {
        int verticalMovesCount = 0;

        // moveUp
        int row = r_q;
        while (row < n) {
            row++;
            if (!isOrigin(r_q, c_q, row, c_q)) {
                if (isObstacle(obstacleList, row, c_q)) {
                    break;
                }
                verticalMovesCount++;
            }
        }

        // moveDown
        row = r_q;
        while (row > 1) {
            row--;
            if (!isOrigin(r_q, c_q, row, c_q)) {
                if (isObstacle(obstacleList, row, c_q)) {
                    break;
                }
                verticalMovesCount++;
            }
        }

        return verticalMovesCount;
    }

    private static int getPossibleHorizontalMoves(int n, int r_q, int c_q, Set<String> obstacleList) {
        int horizontalMovesCount = 0;

        // moveRight
        int col = c_q;
        while (col < n) {
            col++;
            if (!isOrigin(r_q, c_q, r_q, col)) {
                if (isObstacle(obstacleList, r_q, col)) {
                    break;
                }
                horizontalMovesCount++;
            }
        }

        // moveLeft
        col = c_q;
        while (col > 1) {
            col--;
            if (!isOrigin(r_q, c_q, r_q, col)) {
                if (isObstacle(obstacleList, r_q, col)) {
                    break;
                }
                horizontalMovesCount++;
            }
        }

        return horizontalMovesCount;
    }

    private static int getPossibleDiagonalMoves(int n, int r_q, int c_q, Set<String> obstacleList) {
        int diagonalMovesCount = 0;

        // moveUpRight diagonally
        int row = r_q;
        int col = c_q;

        while (row < n && col < n) {
            row++;
            col++;
            if (!isOrigin(r_q, c_q, row, col)) {
                if (isObstacle(obstacleList, row, col)) {
                    break;
                }
                diagonalMovesCount++;
            }
        }

        // moveUpLeft diagonally
        row = r_q;
        col = c_q;
        while (row < n && col > 1) {
            row++;
            col--;
            if (!isOrigin(r_q, c_q, row, col)) {
                if (isObstacle(obstacleList, row, col)) {
                    break;
                }
                diagonalMovesCount++;
            }
        }



        // moveDownLeft diagonally
        row = r_q;
        col = c_q;
        while (row > 1 && col > 1) {
            row--;
            col--;
            if (!isOrigin(r_q, c_q, row, col)) {
                if (isObstacle(obstacleList, row, col)) {
                    break;
                }
                diagonalMovesCount++;
            }
        }


        // moveDownRight diagonally
        row = r_q;
        col = c_q;
        while (row > 1 && col < n) {
            row--;
            col++;
            if (!isOrigin(r_q, c_q, row, col)) {
                if (isObstacle(obstacleList, row, col)) {
                    break;
                }
                diagonalMovesCount++;
            }
        }

        return diagonalMovesCount;
    }



    private static boolean isObstacle(Set<String> obstacleList, int r_q, int c_q) {
        return obstacleList.contains(r_q + " | " + c_q);
    }

    private static boolean isOrigin(int r_q, int c_q, int mr_q, int mc_q) {
        return r_q == mr_q && c_q == mc_q;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
