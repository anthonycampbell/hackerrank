import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isBalanced(String expression) {
        String previousState = "";
        for (int i = 1; i <= expression.length(); i++){
            String currentP = expression.substring(i-1, i);
            if (previousState.equals("") && isClosedP(currentP)){
                return false;
            }
            if (isOpenP(currentP)){
                previousState = previousState.concat(currentP);
                continue;
            }
            if (!previousState.equals("") && isClosedP(currentP) && pMatch(currentP, previousState)){
                previousState = previousState.substring(0,previousState.length()-1);
            } else {
                return false;
            }
        }
        if (previousState.equals("")){
            return true;
        } else {
            return false;
        }
    }

    static private boolean pMatch(String cp, String ps){
        String psFinal = ps.substring(ps.length()-1, ps.length());
        return ((psFinal.equals("[") && cp.equals("]")) ||
                (psFinal.equals("{") && cp.equals("}")) ||
                (psFinal.equals("(") && cp.equals(")")));
    }

    static private boolean isClosedP(String cp){
        return (cp.equals(")") || cp.equals("]") || cp.equals("}"));
    }
    static private boolean isOpenP(String cp){
        return (cp.equals("(") || cp.equals("[") || cp.equals("{"));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
