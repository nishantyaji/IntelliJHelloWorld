import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * A number can be written as sum of consecutive positive integers.
 * Find out the shortest possible such sequence of numbers.
 * The sequence should be of length more than 1
 *
 * Consider the number 15
 * It can be written as sum of consecutive integers in 3 different ways
 * 1+2+3+4+5
 * 4+5+6
 * 7+8
 * Among these different way, the desired way is 7+8
 *
 * For any given positive number, find out the shortest possible sequence
 * of consecutive numbers that can be added to result in the given number
 * Can all positive numbers be represented as sum of consecutive numbers
 *
 * (Source: Job interview)
 *
 */
public class ConsecutiveSumBest {
    public static void main(String[] args) {
        int inputNum  = 14267488;
        int [] series = findSeries(inputNum);
        if(series.length == 0)
            System.out.println("Cannot find such a series representation. The number is a power of 2");
        else {
            Arrays.stream(series).forEach(e -> System.out.print(e + ", "));
        }
    }

    public static int [] findSeries(int number)
    {
        int [] returnArray;
        if(number % 2 == 1)
            returnArray = seriesFromXtoY((number-1)/2, (number+1)/2);
        else{
            number = number * 2;
            int powerOf2 = 0;
            while(number%2 == 0)
            {
                number = number/2;
                powerOf2++;
            }
            if(number == 1)
                returnArray = new int[0];
            else
            {
                int oddPrimeLeast  = leastOddPrimeDivisor(number);
                int powerOf2Contribution = (int) Math.pow(2, powerOf2);
                int min = powerOf2Contribution < oddPrimeLeast ? powerOf2Contribution : oddPrimeLeast;
                if(min % 2 == 0)
                {
                    int n = (powerOf2Contribution + number - 1) / 2;
                    int r = n - powerOf2Contribution;
                    returnArray = seriesFromXtoY(r+1,n);
                }
                else{
                    int n = (oddPrimeLeast + (powerOf2Contribution * number / oddPrimeLeast) - 1)/2;
                    int r = n - oddPrimeLeast;
                    returnArray = seriesFromXtoY(r+1, n);
                }
            }
        }
        return(returnArray);
    }

    private static int leastOddPrimeDivisor(int number) {
        int maxLimit = (int) Math.sqrt(number);
        for(int i = 3; i <= maxLimit; i = i+2)
        {
            if(number % i == 0) {
                return(i);
            }
        }
        return(number);
    }

    private static int [] seriesFromXtoY(int x, int y)
    {
        // both x and y are included in the series
        return IntStream.range(x, y+1).toArray();
    }
}
