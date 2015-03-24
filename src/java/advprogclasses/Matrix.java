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
public class Matrix {
    
    private int rows1;
    private int cols1;
    private int rows2;
    private int cols2;
    private double matrix1[][];
    private double matrix2[][];
    private double resultMatrix[][];
    private String operation;
    private double dp;
    
 //Setters   
public void setCols1(int col1)
{
    this.cols1 = col1;
}
public void setRows1(int row1)
{
    this.rows1 = row1;
}
public void setRows2(int row2)
{
    this.rows2 = row2;
}
public void setCols2(int col2)
{
    this.cols2 = col2;
}
public void setDp(double dp)
{
    this.dp = dp;
}

public void setMatrix1(double matrix[][])
{
    this.matrix1 = matrix;
}
public void setMatrix2(double matrix[][])
{
    this.matrix2 = matrix;
}
public void setResultMatrix(double matrix[][])
{
    this.resultMatrix = matrix;
}

public void setOperation(String operation)
{
    this.operation = operation;
}
//Getters
public int getCols1()
{
    return this.cols1;
}
public int getRows1()
{
   return this.rows1;
}
public int getRows2()
{
   return this.rows2;
}
public int getCols2()
{
   return this.cols2;
}
public double[][] getMatrix1()
{
    return this.matrix1;
}
public double[][] getMatrix2()
{
    return this.matrix2;
}

public double[][] getResultMatrix()
{
    return this.resultMatrix;
}

public String getOperation()
{
  return this.operation;
}

public double getDp()
{
    return this.dp;
}

}

