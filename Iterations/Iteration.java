package JavaHandsOn.Iterations;

import java.util.Iterator;
import java.util.LinkedList;

public class Iteration {
        public static void main(String[] args) {
            // //*Link list
            // LinkedList<String> names = new LinkedList<String>();
            // names.add("Luke");
            // names.add("Sue");
            // names.add("Sherry");

            // System.out.println(names.remove()); //LinkList as an queue! First in, first out!

            //*Stacks! First in, last out
            LinkedList<String> nnames = new LinkedList<String>();
            nnames.push("Luke");
            nnames.push("Sue");
            nnames.push("Sherry");

            nnames.add(1, "Leia");

            Iterator<String> it = nnames.iterator(); //Alternative, ListIterator

            while(it.hasNext()){
                System.out.println(it.next());
            }
            //a way to use Iterator, for loop could replace this method
            
            // System.out.println(nnames.remove());
        }
        
}
