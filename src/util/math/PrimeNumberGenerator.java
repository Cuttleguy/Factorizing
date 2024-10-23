package util.math;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {
    public static List<Long> generatePrimeNumbers(long limit)
    {
        List<Long> primes=new ArrayList<>();
        for (long i = 2; i < limit+1; i++) {
            boolean wasPrime=true;
            for(Long prime:primes)
            {
                wasPrime&=i%prime!=0;
                if(!wasPrime)
                {
                    break;
                }
            }
            if(wasPrime)
            {
                primes.add(i);
            }
        }
        return primes;
    }
}