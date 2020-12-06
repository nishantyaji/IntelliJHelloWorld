import com.sun.deploy.util.ArrayUtil;

public class LongestArithmeticProgression {
    public static void main(String [] args)
    {
        int [] inputArray = {10,50,60,80,100,120,130,140,150,160,200}; //input is assumed sorted
        int longestSize = findLongestAP(inputArray);
    }

    private static int findLongestAP(int[] inputArray) {
        int [][] diff = new int[inputArray.length][inputArray.length];
        //diff[i][j] = inputArray[i]-inputArray[j]
        //Therefore diff[j][i] = -diff[i][j]
        //and diff[i][i] = 0
        for(int i = 0; i < inputArray.length; i++)
        {
            diff[i] = new int [inputArray.length];
            diff[i][i] = 0;
            for(int j = i+1; j < inputArray.length; j++)
                diff[i][j] = inputArray[i]-inputArray[j];
            for(int j = 0; j < i;j++)
                diff[i][j]= -diff[j][i];
        }
        print2DArray(diff);
        return 0;
    }

    private static void print2DArray(int [][] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.println();
            for(int j = 0; j < array[i].length; j++)
                System.out.print( array[i][j] + "  ");
        }
        System.out.println();
    }
}
