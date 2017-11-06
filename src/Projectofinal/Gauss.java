package Projectofinal;

import java.util.Arrays;

public class Gauss {
	
	private double[][] originalMatrix;
	
	public Gauss (double[][] matrix) {
		this.originalMatrix = matrix;
	}
	
	public void displayMatrix(double[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public double[][] triangulateMatrix(double[][] matrix) {	
		double fm = 0;// FACTOR MULTIPLICADOR
		double ep = 0;// ELEMENTO PIVOTE
		
		for(int k = 0;k < matrix.length - 1; k++) {
			ep = matrix[k][k];
			//System.out.println("Elemento pivote: " + ep);
			for(int i = k+1; i < matrix.length; i++) {
				fm = matrix[i][k]/ep;
				for(int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] =  matrix[i][j] - (fm*matrix[k][j]);
				}
//				displayMatrix(matrix);
			}			
		}
		return matrix;
	}
	
	public double[] calculateSolution(double[][] matrix) {
		double[] variables = new double[matrix.length];
		
		// ULTIMA INCOGNITA
		variables[matrix.length-1] = matrix[matrix.length-1][matrix[0].length-1]/matrix[matrix.length-1][matrix[0].length-2];
		
		for(int i = matrix.length - 2; i >= 0; i--) {
			// matrix[1][3]
			variables[i] = matrix[i][matrix[i].length-1];
			for(int j = matrix[i].length - 2; j >= i; j--) {
				if(i != j) {
					variables[i] = variables[i] - (matrix[i][j]*variables[j]);
				} else {
					variables[i] = variables[i]/matrix[i][j];
				}	
			}
		}	
//		System.out.println("Solución: ");
//		System.out.println(Arrays.toString(variables));
		return variables;
	}

	public double[][] getOriginalMatrix() {
		return originalMatrix;
	}

	public void setOriginalMatrix(double[][] originalMatrix) {
		this.originalMatrix = originalMatrix;
	}

}