/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advprogclasses;

/**
 *
 * @author Kevin
 */

public class MatrixCalculator {

 private double matrixA[][];
 private double matrixB[][];
 
 
 public void setMatrixA(int rows, int cols)
 {
     this.matrixA = new double[rows][cols];
 }
 
 public double[][] getMatrixA()       
 {
     return this.matrixA.clone();
 }
 
 public void setMatrixB(int rows, int cols)
 {
     this.matrixB = new double[rows][cols];
 }
 
 public double[][] getMatrixB()
 {
     return this.matrixB.clone();
 }
         
 public double getValueOfIndexA(int row,int cols)
 {
    return this.matrixA[row][cols];
 }
 
 public double getValueOfIndexB(int row,int cols)
 {
    return this.matrixB[row][cols];
 }      
 
    
 public void addValuesMatrixA(int row,int col,double value)
 {
     this.matrixA[row][col] = value;
 }
 
 public void addValuesMatrixB(int row,int col,double value)
 {
     this.matrixB[row][col] = value;
 }
    public double[][] sumMatrix()
    {
        int rows = this.matrixA.length;
        int cols = this.matrixA[0].length;
        
        double resultMatrix[][] = new double[rows][cols];
        for(int i=0; i < rows;i++)
        {
            for(int j = 0; j < cols; j++)
            {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return resultMatrix;
    }
    
    public double[][] subsMatrix()
    {
        int rows = this.matrixA.length;
        int cols = this.matrixA[0].length;
        double resultMatrix[][] = new double[rows][cols];
        for(int i=0; i < rows;i++)
        {
            for(int j = 0; j < cols; j++)
            {
                resultMatrix[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return resultMatrix;
    }
    public double[][] prodMatrix()
    {
        int row = this.matrixA.length;
        int col = this.matrixB[0].length;
        int row2 = this.matrixB.length;
        double resultMatrix[][] = new double[row][col];
        for(int i=0;i< row;i++)
        {
          for(int j=0;j< col;j++)
          {
            resultMatrix[i][j] = 0;
            for(int k=0;k < row2;k++)
            {
             resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
            }
  
          }
        }
        return resultMatrix;
    }
    public double dpresult(int row,int col)
    {
        double result = 0;
        double cols = matrixA[0].length;
            for(int k=0;k < cols;k++)
            {
             result += matrixA[row][k] * matrixB[k][col];
            }
            return result;
    }
}

