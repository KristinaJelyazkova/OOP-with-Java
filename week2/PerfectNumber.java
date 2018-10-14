import java.awt.*;
import java.lang.reflect.Array;

public class PerfectNumber {
    private final int NUMBER_PER_LINE = 5;

    public boolean isPerfect(int number){
        if(number == 1){
            return true;
        }

        int originalNumber = number;
        int sum = 1;
        boolean isPrime = true;

        while(number > 0){
            isPrime = true;
            if(sum > originalNumber){
                return false;
            }

            long biggestPossibleMultiplier = Math.round(Math.sqrt(number));
            for(int multiplier = 2; multiplier <= biggestPossibleMultiplier; multiplier++){
                if(number % multiplier == 0){
                    number /= multiplier;
                    sum += multiplier;
                    isPrime = false;
                    break;
                }
            }

            if (isPrime){
                return sum + number == originalNumber;
            }
        }
        return sum == originalNumber;
    }

    public void showMultipliers(int number){
        if(number == 1){
            System.out.printf("\t%d", number);
            return;
        }

        int counterMultipliers = 0;
        boolean isPrime = true;

        while(number > 1){
            isPrime = true;
            long biggestPossibleMultiplier = Math.round(Math.sqrt(number)) + 1;

            for(int multiplier = 2; multiplier <= biggestPossibleMultiplier; multiplier++){
                if(number % multiplier == 0){
                    number /= multiplier;
                    counterMultipliers++;
                    isPrime = false;

                    System.out.printf("\t%d", multiplier);
                    if(counterMultipliers == NUMBER_PER_LINE){
                        System.out.println();
                        counterMultipliers = 0;
                    }
                    break;
                }
            }

            if(isPrime){
                System.out.printf("\t%d", number);
                return;
            }
        }

        System.out.print("\t1");
    }
}
