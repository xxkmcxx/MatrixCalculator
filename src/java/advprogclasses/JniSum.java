package advprogclasses;

/**
 *
 * @author Kevin
 */
public class JniSum {
    
    public native double[][] calculateSum(double[][] matrix1,double[][] matrix2);
    
    static{
        System.load("C:\\Users\\Kevin\\Documents\\NetBeansProjects\\AdvProy\\src\\java\\JniSum.dll");
    }
}