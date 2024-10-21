import util.NestedLoop;
import util.math.PrimeNumberGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("To Factorize");
        int input=Integer.parseInt(br.readLine());
        Map<Integer,Integer> factorizingResult = new HashMap<>();
        List<Integer> primes = PrimeNumberGenerator.generatePrimeNumbers(input);
        while(input!=1){
            for(Integer prime:primes)
            {
                if(input%prime==0)
                {
                    factorizingResult.put(prime,factorizingResult.getOrDefault(prime,0)+1);
                    input/=prime;
                }
            }
        }
        System.out.println(factorizingResult);
//        System.out.println(Arrays.toString(factorizingResult.values().stream().mapToInt(i -> i+1).toArray()));
        NestedLoop thisLoop = new NestedLoop(factorizingResult.values().stream().mapToInt(i -> i+1).toArray());
        List<int[]> loops=thisLoop.indiciesList;
        List<Integer> factors=new ArrayList<>();
        List<Integer> keySet=new ArrayList<>();
        for(int i : factorizingResult.keySet())
        {
            keySet.add(i);
        }
        for(int[] loop : loops)
        {
            int factor = 1;

            for (int i = 0; i < loop.length; i++) {
                int index = loop[i];
                factor*= (int) Math.pow(keySet[i],index);
            }
            factors.add(factor);
        }
        Collections.sort(factors);
        System.out.println(factors);

        //        for(Integer prime:primes)
//        {
//            System.out.println(prime);
//        }



    }
    public static Integer productOfFactors(Map<Integer,Integer> factorization)
    {
        int prod=1;
        for(Map.Entry<Integer,Integer> entry:factorization.entrySet())
        {
            prod*=(int) Math.pow(entry.getKey(),entry.getValue());

        }
        return prod;
    }
//    public static List<Integer> getFactors(Map<Integer,Integer> factorization)
//    {
//
//    }

}