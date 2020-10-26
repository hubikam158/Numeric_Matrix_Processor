package processor;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        Matrix matrixA = new Matrix(scanner.nextInt(), scanner.nextInt());
//        fillMatrix(matrixA);
//
//        Matrix matrixB = new Matrix(scanner.nextInt(), scanner.nextInt());
//        fillMatrix(matrixB);
//
//        if (areAbleToAdd(matrixA,matrixB)) {
//            printMatrix(addMatrices(matrixA,matrixB));
//        } else {
//            System.out.println("ERROR");
//        }

        Matrix matrix = new Matrix(scanner.nextInt(), scanner.nextInt());
        fillMatrix(matrix);
        int constant = scanner.nextInt();
        printMatrix(multiplyMatrixByConstant(matrix, constant));
    }

    private static void fillMatrix(Matrix matrix) {
        int[][] temp = new int[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                temp[i][j] = scanner.nextInt();
            }
        }
        matrix.setMatrix(temp);
    }

    private static Matrix addMatrices(Matrix matrixA, Matrix matrixB) {
        Matrix finalMatrix = new Matrix(matrixA.getRows(), matrixA.getColumns());
        int[][] temp = new int[matrixA.getRows()][matrixA.getColumns()];
        for (int i = 0; i < matrixA.getRows(); i++) {
            for (int j = 0; j < matrixA.getColumns(); j++) {
                temp[i][j] = matrixA.getMatrix()[i][j] + matrixB.getMatrix()[i][j];
            }
        }
        finalMatrix.setMatrix(temp);
        return finalMatrix;
    }

    private static void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                System.out.print(matrix.getMatrix()[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean areAbleToAdd(Matrix matrixA, Matrix matrixB) {
        return matrixA.getRows() == matrixB.getRows() &&
                matrixA.getColumns() == matrixB.getColumns();
    }

    private static Matrix multiplyMatrixByConstant(Matrix matrix, int constant) {
        Matrix finalMatrix = new Matrix(matrix.getRows(), matrix.getColumns());
        int[][] temp = new int[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                temp[i][j] = matrix.getMatrix()[i][j] * constant;
            }
        }
        finalMatrix.setMatrix(temp);
        return finalMatrix;
    }
}
