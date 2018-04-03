import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FairRations {

    static int fairRations(int[] B) {
        int ans = 0;
        for (int i = 0; i < B.length; i++){
            if (((B[i] & 1) != 0) && (i == (B.length-1))){
                return -1;
            } else if ((B[i] & 1) != 0){
                ans += 2;
                B[i]++;
                B[i+1]++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] B = new int[N];
        for(int B_i = 0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
        }
        int result = fairRations(B);
        if (result == -1){
            System.out.println("NO");
        } else {
            System.out.println(result);
        }
        in.close();
    }
}
