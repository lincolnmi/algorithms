package StringAlgorithm.KeyIndexCount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Jason on 2016/4/24.
 */
public class KeyIndexCount {

    private static final int maxR = 5;

    public static void process(ArrayList<Student> students) {
        int n = students.size();
        int[] count = new int[maxR+1];
        for (Student student:students) {
            count[student.getGroup()+1]++;
        }
        for (int i=1;i<=maxR;i++) {
            count[i] += count[i-1];
        }
        Student[] aux = new Student[n];
        for (Student student:students) {
            aux[count[student.getGroup()]++] = student;
        }
        for (int i=0;i<n;i++) {
            students.set(i,aux[i]);
        }
    }

    public static ArrayList<Student> inputStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/StringAlgorithm/KeyIndexCount/students.txt"));
            String str = null;
            while((str=br.readLine())!=null) {
                String[] values = str.split(" ");
                students.add(new Student(values[0],Integer.valueOf(values[1])));
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void output(ArrayList<Student> students) {
        for (Student student:students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = inputStudents();
        output(students);
        process(students);
        System.out.println("after sort");
        output(students);
    }

}
