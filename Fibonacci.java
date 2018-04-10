import java.util.*;
import java.math.BigInteger;

public class Fibonacci {

    private static Map<Long, BigInteger> fibs = new HashMap<Long, BigInteger>();

    public static BigInteger fibonacci(Long n) {
        for (Long i = 2L; i < n; i++){
            fibs.put(i, fibs.get(i-1).add(fibs.get(i-2)));
        }
        return fibs.get(n-1).add(fibs.get(n-2));
    }


    public static void main(String[] args) {
        fibs.put(0l, BigInteger.valueOf(0));
        fibs.put(1l, BigInteger.valueOf(1));
        Scanner scanner = new Scanner(System.in);
        Long n = scanner.nextLong();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
