import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IsPrime {
    public static void isPrime(int n){
        int i = (int) Math.pow((double) n, 0.5);
        for (int j = 2; j <= i; j++){
            if (n%j == 0){
                System.out.println("Not prime");
                return;
            }
        }
        if (n == 1){
            System.out.println("Not prime");
            return;
        }
        System.out.println("Prime");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            isPrime(n);
        }
    }
}
