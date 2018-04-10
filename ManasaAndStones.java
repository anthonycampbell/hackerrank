import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ManasaAndStones {

    static void stones(int n, int a, int b) {
        int acc = 0;
        int smaller;
        int larger;
        if (a <= b){
            smaller = a;
            larger = b;
        } else {
            smaller = b;
            larger = a;
        }
        for (int i = 1; i < n; i++){
            acc += smaller;
        }
        System.out.print(acc);
        System.out.print(" ");
        for (int i = 1; i < n; i ++){
            if (((acc - a) + b) != acc){
                acc -= smaller;
                acc += larger;
                System.out.print(acc);
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            stones(n, a, b);
            System.out.println("");
        }
        in.close();
    }
}
