package JavaHandsOn.readFile_collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class read {

    //class level variable
    List<String> stuff; //General purpose
    // ArrayList<String> stuff; //specific interface(contract), must be same type,e.g. LinkedList below throws error
    public static void main(String[] args) throws FileNotFoundException {

        //! Java collection framework readup!! Important!
        List<String> students = new ArrayList<String>(); //List is fine, but would be best be specific and use ArrayList
        
        Scanner in = new Scanner(new File("JavaHandsOn/readFile_collection/student.txt"));
        while(in.hasNextLine()){
            students.add(in.nextLine());
            // System.out.println(in.nextLine());
        }

        for(int i = 0;i < students.size(); i++){
            System.out.println("Name: " + students.get(i));
        }
        in.close();

        read p = new read(); //new instance for this class - read
        p.stuff = new ArrayList<String>(); //Interface! Must be same type, like a contract!

        // p.stuff = new LinkedList<String>(); //Interface! Must be same stype, type mismatch if above is arraylist

    }
}
