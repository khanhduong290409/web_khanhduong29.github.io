package lab5;

public class task1 {
	public static int[][] add(int[][] a, int[][] b) {
	    int rows = a.length;
	    int cols = a[0].length; // Assuming both matrices have the same dimensions

	    int[][] result = new int[rows][cols];

	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            result[i][j] = a[i][j] + b[i][j];
	        }
	    }

	    return result;
	}
	public static int[][] subtract(int[][] a, int[][] b) {
	    int rows = a.length;
	    int cols = a[0].length; // Assuming both matrices have the same dimensions

	    int[][] result = new int[rows][cols];

	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            result[i][j] = a[i][j] - b[i][j];
	        }
	    }

	    return result;
	}
	public static int[][] multiply(int[][] a, int[][] b) {
	    int rowsA = a.length;
	    int colsA = a[0].length;
	    int colsB = b[0].length;

	    if (colsA != b.length) {
	        throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication.");
	    }

	    int[][] result = new int[rowsA][colsB];

	    for (int i = 0; i < rowsA; i++) {
	        for (int j = 0; j < colsB; j++) {
	            int sum = 0;
	            for (int k = 0; k < colsA; k++) {
	                sum += a[i][k] * b[k][j];
	            }
	            result[i][j] = sum;
	        }
	    }

	    return result;
	}
	public static int[][] transpose(int[][] a) {
	    int rows = a.length;
	    int cols = a[0].length;

	    int[][] result = new int[cols][rows];

	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            result[j][i] = a[i][j];
	        }
	    }

	    return result;
	}


	
}
