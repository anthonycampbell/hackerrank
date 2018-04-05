import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class cavityMap {

    static String[] cavityMap(String[] grid) {
        int n = grid.length;
        int f = n - 1;
        String[] cavityMap = new String[n];
        int top;
        int bot;
        int lef;
        int rit;
        int e;
        int tE;
        int bE;
        int lE;
        int rE;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                top = i - 1;
                bot = i + 1;
                lef = j - 1;
                rit = j + 1;
                e  = Character.getNumericValue(grid[i].charAt(j));
                if ((top >= 0) &&
                    (bot <= f) &&
                    (lef >= 0) &&
                    (rit <= f)){
                    tE = Character.getNumericValue(grid[top].charAt(j));
                    bE = Character.getNumericValue(grid[bot].charAt(j));
                    lE = Character.getNumericValue(grid[i].charAt(lef));
                    rE = Character.getNumericValue(grid[i].charAt(rit));
                    if ((e > tE) &&
                        (e > bE) &&
                        (e > lE) &&
                        (e > rE)){
                        cavityMap[i] += "X";
                    } else {
                        cavityMap[i] += grid[i].charAt(j);
                    }
                } else {
                    if (cavityMap[i] == null){
                        cavityMap[i] = Character.toString(grid[i].charAt(j));
                    } else {
                        cavityMap[i] += grid[i].charAt(j);
                    }
                }
            }
        }
        return cavityMap;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i = 0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        String[] result = cavityMap(grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
