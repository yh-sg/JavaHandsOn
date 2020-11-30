package JavaHandsOn.readFile_collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class read {
    public static void main(String[] args) throws FileNotFoundException {

        List<String> students = new ArrayList<String>();
        
        Scanner in = new Scanner(new File("JavaHandsOn/readFile_collection/student.txt"));
        while(in.hasNextLine()){
            students.add(in.nextLine());
            // System.out.println(in.nextLine());
        }

        for(int i = 0;i < students.size(); i++){
            System.out.println("Name: " + students.get(i));
        }
        in.close();
    }
}
