package processor;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMenu();
            switch (chooseOption()) {
                case 1:
                    addMatrices();
                    break;
                case 2:
                    multiplyMatrixByConstant();
                    break;
                case 3:
                    multiplyMatrices();
                    break;
                case 4:
                    transposeMatrix();
                    break;
                case 5:
                    calculateDeterminant();
                    break;
                case 6:
                    inverseMatrix();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    printError();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add matrices" +
                "\n2. Multiply matrix by a constant" +
                "\n3. Multiply matrices" +
                "\n4. Transpose matrix" +
                "\n5. Calculate a determinant" +
                "\n6. Inverse matrix" +
                "\n0. Exit");
    }

    private static void printTransposeMenu() {
        System.out.println("\n1. Main diagonal" +
                "\n2. Side diagonal" +
                "\n3. Vertical line" +
                "\n4. Horizontal line");
    }

    private static void printResult(Matrix matrix) {
        System.out.println("The result is:");
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                System.out.print(String.format("%6.2f", matrix.getMatrix()[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private static void printError() {
        System.out.println("The operation cannot be performed.");
    }

    private static int chooseOption() {
        System.out.print("\nYour choice: ");
        return scanner.nextInt();
    }

    private static Matrix createMatrix() {
        System.out.println("\nEnter size of matrix:");
        Matrix matrix = new Matrix(scanner.nextInt(), scanner.nextInt());
        System.out.println("Enter matrix:");
        fillMatrix(matrix);
        return matrix;
    }

    private static void fillMatrix(Matrix matrix) {
        double[][] temp = new double[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                temp[i][j] = scanner.nextDouble();
            }
        }
        matrix.setMatrix(temp);
    }

    private static boolean areAbleToAdd(Matrix matrixA, Matrix matrixB) {
        return matrixA.getRows() == matrixB.getRows() &&
                matrixA.getColumns() == matrixB.getColumns();
    }

    private static boolean areAbleToMultiply(Matrix matrixA, Matrix matrixB) {
        return matrixA.getColumns() == matrixB.getRows();
    }

    private static boolean isSquare(Matrix matrix) {
        return matrix.getRows() == matrix.getColumns();
    }

    private static Matrix addMatrices(Matrix matrixA, Matrix matrixB) {
        Matrix finalMatrix = new Matrix(matrixA.getRows(), matrixA.getColumns());
        double[][] temp = new double[matrixA.getRows()][matrixA.getColumns()];
        for (int i = 0; i < matrixA.getRows(); i++) {
            for (int j = 0; j < matrixA.getColumns(); j++) {
                temp[i][j] = matrixA.getMatrix()[i][j] + matrixB.getMatrix()[i][j];
            }
        }
        finalMatrix.setMatrix(temp);
        return finalMatrix;
    }

    private static void addMatrices() {
        Matrix matrixA = createMatrix();
        Matrix matrixB = createMatrix();
        if (areAbleToAdd(matrixA, matrixB)) {
            printResult(addMatrices(matrixA, matrixB));
        } else {
            printError();
        }
    }

    private static Matrix multiplyMatrixByConstant(Matrix matrix, double constant) {
        Matrix finalMatrix = new Matrix(matrix.getRows(), matrix.getColumns());
        double[][] temp = new double[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                temp[i][j] = matrix.getMatrix()[i][j] * constant;
            }
        }
        finalMatrix.setMatrix(temp);
        return finalMatrix;
    }

    private static void multiplyMatrixByConstant() {
        Matrix matrix = createMatrix();
        System.out.println("Enter constant:");
        double constant = scanner.nextDouble();
        printResult(multiplyMatrixByConstant(matrix, constant));
    }

    private static Matrix multiplyMatrices(Matrix matrixA, Matrix matrixB) {
        Matrix finalMatrix = new Matrix(matrixA.getRows(), matrixB.getColumns());
        double[][] temp = new double[matrixA.getRows()][matrixB.getColumns()];
        for (int i = 0; i < matrixA.getRows(); i++) {
            for (int j = 0; j < matrixB.getColumns(); j++) {
                for (int k = 0; k < matrixA.getColumns(); k++) {
                    temp[i][j] += matrixA.getMatrix()[i][k] * matrixB.getMatrix()[k][j];
                }
            }
        }
        finalMatrix.setMatrix(temp);
        return finalMatrix;
    }

    private static void multiplyMatrices() {
        Matrix matrixA = createMatrix();
        Matrix matrixB = createMatrix();
        if (areAbleToMultiply(matrixA, matrixB)) {
            printResult(multiplyMatrices(matrixA, matrixB));
        } else {
            printError();
        }
    }

    private static Matrix transposeMatrix(Matrix matrix, int choice) {
        switch (choice) {
            case 1:
                return transposeAlongMainDiagonal(matrix);
            case 2:
                return transposeAlongSideDiagonal(matrix);
            case 3:
                return transposeAlongVerticalLine(matrix);
            case 4:
                return transposeAlongHorizontalLine(matrix);
            default:
                printError();
                return matrix;
        }
    }

    private static Matrix transposeAlongMainDiagonal(Matrix matrix) {
        Matrix finalMatrix = new Matrix(matrix.getColumns(), matrix.getRows());
        double[][] temp = new double[matrix.getColumns()][matrix.getRows()];
        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; j < matrix.getRows(); j++) {
                temp[i][j] = matrix.getMatrix()[j][i];
            }
        }
        finalMatrix.setMatrix(temp);
        return finalMatrix;
    }

    private static Matrix transposeAlongSideDiagonal(Matrix matrix) {
        Matrix finalMatrix = new Matrix(matrix.getColumns(), matrix.getRows());
        double[][] temp = new double[matrix.getColumns()][matrix.getRows()];
        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; j < matrix.getRows(); j++) {
                temp[i][j] = matrix.getMatrix()[matrix.getRows() - 1 - j][matrix.getColumns() - 1 - i];
            }
        }
        finalMatrix.setMatrix(temp);
        return finalMatrix;
    }

    private static Matrix transposeAlongVerticalLine(Matrix matrix) {
        Matrix finalMatrix = new Matrix(matrix.getRows(), matrix.getColumns());
        double[][] temp = new double[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                temp[i][j] = matrix.getMatrix()[i][matrix.getColumns() - 1 - j];
            }
        }
        finalMatrix.setMatrix(temp);
        return finalMatrix;
    }

    private static Matrix transposeAlongHorizontalLine(Matrix matrix) {
        Matrix finalMatrix = new Matrix(matrix.getRows(), matrix.getColumns());
        double[][] temp = new double[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                temp[i][j] = matrix.getMatrix()[matrix.getRows() - 1 - i][j];
            }
        }
        finalMatrix.setMatrix(temp);
        return finalMatrix;
    }

    private static void transposeMatrix() {
        printTransposeMenu();
        int choice = chooseOption();
        Matrix matrix = createMatrix();
        printResult(transposeMatrix(matrix, choice));
    }

    private static double calculateDeterminant(Matrix matrix) {
        if (matrix.getRows() == 2) {
            return calculateDeterminant2x2(matrix);
        } else if (matrix.getRows() > 2) {
            double result = 0d;
            for (int j = 0; j < matrix.getColumns(); j++) {
                result += matrix.getMatrix()[0][j] * createCofactorMatrix(matrix).getMatrix()[0][j];
            }
            return result;
        }
        return matrix.getMatrix()[0][0];
    }

    private static double calculateDeterminant2x2(Matrix matrix) {
        return matrix.getMatrix()[0][0] * matrix.getMatrix()[1][1] -
                matrix.getMatrix()[0][1] * matrix.getMatrix()[1][0];
    }

    private static Matrix createMinorMatrix(Matrix matrix, int i, int j) {
        Matrix minorMatrix = new Matrix(matrix.getRows() - 1, matrix.getColumns() - 1);
        double[][] temp = new double[minorMatrix.getRows()][minorMatrix.getColumns()];
        for (int p = 0; p < matrix.getRows(); p++) {
            for (int q = 0; q < matrix.getColumns(); q++) {
                if (q > j && p > i) {
                    temp[p - 1][q - 1] = matrix.getMatrix()[p][q];
                } else if (q > j && p < i) {
                    temp[p][q - 1] = matrix.getMatrix()[p][q];
                } else if (q < j && p > i) {
                    temp[p - 1][q] = matrix.getMatrix()[p][q];
                } else if (q < j && p < i) {
                    temp[p][q] = matrix.getMatrix()[p][q];
                }
            }
        }
        minorMatrix.setMatrix(temp);
        return minorMatrix;
    }

    private static Matrix createCofactorMatrix(Matrix matrix) {
        Matrix cofactorMatrix = new Matrix(matrix.getRows(), matrix.getColumns());
        double[][] temp = new double[matrix.getRows()][matrix.getColumns()];
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                temp[i][j] = setSign(i, j) * calculateDeterminant(createMinorMatrix(matrix,i, j));
            }
        }
        cofactorMatrix.setMatrix(temp);
        return cofactorMatrix;
    }

    private static double setSign(int i, int j) {
        return (i + j) % 2 == 0 ? 1 : -1;
    }

    private static void calculateDeterminant() {
        Matrix matrix = createMatrix();
        if (isSquare(matrix)) {
            System.out.println("The result is:\n" + (calculateDeterminant(matrix)));
        } else {
            printError();
        }
    }

    private static Matrix inverseMatrix(Matrix matrix) {
        return multiplyMatrixByConstant(transposeAlongMainDiagonal(createCofactorMatrix(matrix)),
                1 / calculateDeterminant(matrix));
    }

    private static void inverseMatrix() {
        Matrix matrix = createMatrix();
        if (isSquare(matrix) && calculateDeterminant(matrix) != 0) {
            printResult(inverseMatrix(matrix));
        } else {
            System.out.println("This matrix doesn't have an inverse.");
        }
    }
}
