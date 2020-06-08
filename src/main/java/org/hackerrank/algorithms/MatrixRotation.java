package org.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Prashant Patel (312455)
 * Date: 7/20/2019
 *
 * https://www.hackerrank.com/challenges/matrix-rotation-algo/problem
 *
 **/
public class MatrixRotation {

    // Complete the matrixRotation function below.
    private static void matrixRotation(List<List<Integer>> matrix, int m, int n, int r, int[][] resultMatrix, int cycle) {
        for(int j=cycle; j<=m; j++) {
            for(int k=cycle; k<=n; k++) {
                if(k>cycle && k < n && j>cycle && j<m) {
                    k=n-1;
                } else {
                    findProperPosition(j, k, m, n, cycle, r, matrix, resultMatrix);
                }
            }
        }
    }

    private static void findProperPosition(int row, int column, int totalRow, int totalColumn, int cycle, int rotation, List<List<Integer>> matrix, int[][] resultMatrix) {
        String[] positionAfterRotation = (row+","+column).split(",");
        if(row == cycle && row == totalRow) {
            positionAfterRotation = findPositionForSingleRow(row, column, totalColumn, cycle, rotation).split(",");
        } else if(column == cycle && column == totalColumn) {
            positionAfterRotation = findPositionForSingleColumn(row, column, totalRow, cycle, rotation).split(",");
        } else if(row == cycle && column > cycle) {
            positionAfterRotation = findPositionForQ1Elem(row, column, totalRow, totalColumn, cycle, rotation).split(",");
        } else if(column == cycle && row < totalRow) {
            positionAfterRotation = findPositionForQ2Elem(row, column, totalRow, totalColumn, cycle, rotation).split(",");
        } else if(row == totalRow && column < totalColumn) {
            positionAfterRotation = findPositionForQ3Elem(row, column, totalRow, totalColumn, cycle, rotation).split(",");
        } else if(column == totalColumn && row > cycle) {
            positionAfterRotation = findPositionForQ4Elem(row, column, totalRow, totalColumn, cycle, rotation).split(",");
        }
        int newRow = Integer.parseInt(positionAfterRotation[0]);
        int newCol = Integer.parseInt(positionAfterRotation[1]);
        resultMatrix[newRow][newCol] = matrix.get(row-1).get(column-1);
    }

    private static String findPositionForSingleRow(int currentRow, int currentCol, int totalColumn, int cycle, int rotation) {
        boolean cond1 = rotation > (currentCol-cycle);
        String value1 = cycle + "," + (currentCol-rotation);
        String value2 = cycle + "," + (totalColumn - (rotation - (currentCol-cycle))+1);

        return cond1 ? value2 : value1;
    }

    private static String findPositionForSingleColumn(int currentRow, int currentCol, int totalRow, int cycle, int rotation) {
        boolean cond1 = rotation > (totalRow-currentRow);
        String value1 = (currentRow + rotation) + "," + cycle;
        String value2 = (cycle + rotation - (totalRow-currentRow) - 1) + "," + cycle;

        return cond1 ? value2 : value1;
    }

    private static String findPositionForQ1Elem(int currentRow, int currentCol, int totalRow, int totalColumn, int cycle, int rotation){
        boolean cond1 = rotation > (currentCol-cycle);
        boolean cond2 = (rotation - (currentCol-cycle)) > (totalRow-cycle);
        boolean cond3 = (rotation - (currentCol-cycle) - (totalRow-cycle)) > (totalColumn-cycle);
        boolean cond4 = (rotation - (currentCol-cycle) - (totalRow-cycle) - (totalColumn-cycle)) > (totalRow-cycle);

        String value1 = currentRow + "," + (currentCol-rotation);
        String value2 = (cycle + rotation - (currentCol-cycle)) + "," + cycle;
        String value3 = totalRow + "," + (cycle + rotation - (currentCol-cycle) - (totalRow-cycle));
        String value4 = (totalRow - (rotation - (currentCol-cycle) - (totalRow-cycle) - (totalColumn-cycle))) + "," + totalColumn;
        String value5 = cycle + "," + (totalColumn - (rotation - (currentCol-cycle) - (totalRow-cycle) - (totalColumn-cycle) - (totalRow-cycle)));

        return cond1 ? cond2 ? cond3 ? cond4 ? value5 : value4 : value3 : value2: value1;
    }

    private static String findPositionForQ2Elem(int currentRow, int currentCol, int totalRow, int totalColumn, int cycle, int rotation){

        boolean cond1 = rotation > (totalRow - currentRow);
        boolean cond2 = (rotation - (totalRow - currentRow)) > (totalColumn-cycle);
        boolean cond3 = (rotation - (totalRow - currentRow) - (totalColumn-cycle)) > (totalRow-cycle);
        boolean cond4 = (rotation - (totalRow - currentRow) - (totalColumn-cycle) - (totalRow-cycle)) > (totalColumn-cycle);

        String value1 = (currentRow + rotation) + "," + currentCol;
        String value2 = totalRow + "," + (cycle + rotation - (totalRow - currentRow));
        String value3 = (totalRow - (rotation - (totalRow - currentRow) - (totalColumn-cycle))) + "," + totalColumn;
        String value4 = cycle + "," + (totalColumn - (rotation - (totalRow - currentRow) - (totalColumn-cycle) - (totalRow-cycle)));
        String value5 = (cycle + rotation - (totalRow - currentRow) - 2*(totalColumn-cycle) - (totalRow-cycle)) + "," + cycle;

        return cond1 ? cond2 ? cond3 ? cond4 ? value5 : value4 : value3 : value2: value1;
    }

    private static String findPositionForQ3Elem(int currentRow, int currentCol, int totalRow, int totalColumn, int cycle, int rotation){

        boolean cond1 = rotation > (totalColumn - currentCol);
        boolean cond2 = (rotation - (totalColumn - currentCol)) > (totalRow-cycle);
        boolean cond3 = (rotation - (totalColumn - currentCol) - (totalRow-cycle)) > (totalColumn-cycle);
        boolean cond4 = (rotation - (totalColumn - currentCol) - (totalRow-cycle) - (totalColumn-cycle)) > (totalRow-cycle);
        String value1 = totalRow + "," + (currentCol + rotation);
        String value2 = (totalRow - (rotation - (totalColumn - currentCol))) + "," + totalColumn;
        String value3 = cycle + "," + (totalColumn - (rotation - (totalColumn - currentCol) - (totalRow-cycle)));
        String value4 = (cycle + (rotation - (totalColumn - currentCol) - (totalRow-cycle)) - (totalColumn-cycle)) + "," + cycle;
        String value5 = totalRow + "," + (cycle + (rotation - (totalColumn - currentCol) - 2*(totalRow-cycle)) - (totalColumn-cycle));

        return cond1 ? cond2 ? cond3 ? cond4 ? value5 : value4 : value3 : value2: value1;
    }

    private static String findPositionForQ4Elem(int currentRow, int currentCol, int totalRow, int totalColumn, int cycle, int rotation) {

        boolean cond1 = rotation > (currentRow-cycle);
        boolean cond2 = (rotation - (currentRow-cycle)) > (totalColumn-cycle);
        boolean cond3 = (rotation - (currentRow-cycle) - (totalColumn-cycle)) > (totalRow-cycle);
        boolean cond4 = (rotation - (currentRow-cycle) - (totalColumn-cycle) - (totalRow-cycle)) > (totalColumn-cycle);
        String value1 = currentRow - rotation + "," + totalColumn;
        String value2 = cycle + "," + (totalColumn - (rotation - (currentRow-cycle)));
        String value3 = (cycle + rotation - (currentRow-cycle) - (totalColumn-cycle)) + "," + cycle;
        String value4 = totalRow + "," + (cycle + rotation - (currentRow-cycle) - (totalColumn-cycle) - (totalRow-cycle));
        String value5 = (totalRow - (rotation - (currentRow-cycle) - 2*(totalColumn-cycle) - (totalRow-cycle))) + "," + totalColumn;

        return cond1 ? cond2 ? cond3 ? cond4 ? value5 : value4 : value3 : value2: value1;
    }

    private static void printMatrix(int[][] resultMatrix) {
        for(int i=1; i<resultMatrix.length; i++) {
            for(int j=1; j<resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int[][] resultMatrix = new int[m+1][n+1];

        int ring = 0, cycle=1;

        while((m-ring) > 0 && (n-ring) > 0) {
            int wholeRotation = ((m-ring) * 2 + (n-ring) * 2 - 4);
            int rotation = r % wholeRotation;
            matrixRotation(matrix, m - cycle + 1 , n - cycle +1, rotation, resultMatrix, cycle);
            ring += 2;
            cycle++;
        }

        printMatrix(resultMatrix);

        bufferedReader.close();
    }

}
