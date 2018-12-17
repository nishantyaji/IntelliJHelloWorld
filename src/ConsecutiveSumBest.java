import java.util.Arrays;

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
            returnArray = seriesFromXtoY((int) Math.floor(number/ 2), (int) Math.ceil(number/2));
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
        int [] returnArray = new int[y - x + 1];
        for(int i = x; i <= y; i++)
            returnArray[i-x] = x;
        return(returnArray);
    }
}
