import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Mergesort {

    static Integer[] mergesort(int[] arr) {
        List<Integer> l = new LinkedList<Integer>();
        List<Integer> r = new LinkedList<Integer>();
        HashMap<Integer, LinkedList<Integer>> m = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < arr.length; i++){
            LinkedList<Integer> temp = new LinkedList<Integer>();
            temp.add(arr[i]);
            m.put(i, temp);
        }
        int i = 0;
        int j = 2;
        while(m.get(0).size() < arr.length){
            if(m.get(i+(j/2)) != null){
                m.put(i , merge(m.get(i), m.get(i+(j/2))));
            }
            i += j;
            if (i >= arr.length){
                i = 0;
                j = j*2;
            }
        }
        Integer[] result = m.get(0).toArray(new Integer[arr.length]);
        return result;
    }

    static LinkedList<Integer> merge(LinkedList<Integer> l, LinkedList<Integer> r){
        LinkedList<Integer> merged = new LinkedList<Integer>();
        while ((!l.isEmpty()) || (!r.isEmpty())){
            if (l.isEmpty()){
                merged.add(r.get(0));
                r.remove(0);
            } else if (r.isEmpty()){
                merged.add(l.get(0));
                l.remove(0);
            } else {
                if (l.get(0) < r.get(0)){
                    merged.add(l.get(0));
                    l.remove(0);
                } else {
                    merged.add(r.get(0));
                    r.remove(0);
                }
            }
        }
        return merged;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            if (n >= 1){
                Integer[] result = mergesort(arr);
                for (int i = 0; i < n; i++){
                    System.out.print(result[i] + " ");
                }
                System.out.println("");
            } else {
                System.out.println("n must be at least 1");
            }
        }
        in.close();
    }
}
