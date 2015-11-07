package nju.ics.lixiaofan.algorithm;
/*
Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrime {
    public int countPrimes(int n) {
        boolean[] composite = new boolean[n];
        int count = 0;
        for(int i = 2;i < composite.length;i++){
            if(composite[i])
                continue;
            count++;
            for(int j = i+i;j < composite.length;j+=i)
                composite[j] = true;
        }
        
        return count;
    }
}
