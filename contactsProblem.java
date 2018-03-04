import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ContactsProblem {

    public static void main(String[] args) {
        Hashtable<String, Integer> contactHash = new Hashtable<String, Integer>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")){
                for (int i = 1; i <= contact.length(); i++){
                    if (contactHash.containsKey(contact.substring(0,i))){
                        int count = contactHash.get(contact.substring(0,i));
                        count++;
                        contactHash.put(contact.substring(0,i), count);
                    } else {
                        contactHash.put(contact.substring(0,i), 1);
                    }
                }
            } else {
                if (contactHash.get(contact) == null){
                    System.out.println(0);
                } else {
                    System.out.println(contactHash.get(contact));
                }
            }
        }
    }
}

//opCons.add(op"+"con);
            /*if (op.equals("add")){
                contacts.add(contact);
            }
            if (op.equals("find")){
                Object[] cs = contacts.toArray();
                Arrays.sort(cs);
                for (int i = 0; i < cs.length; i++){
                    System.out.println(cs[i]);
                }
                System.out.println(count);
                count = 0;
            }*/

/*for (entry: opCOns){
            String[] oc = entry.split("+");
            String o = oc[0];
            String c = oc[1];
            if(o.equals("add")){
                sortedContacts.add(c);
            } else {
                Object[] cs = sortedContacts.toArray();
                Arrays.sort(cs);

            }
        }*/

/*for (String c : contacts){
                    if (c.substring(0,contact.length()).equals(contact)){
                        count++;
                    }
                }*/
