import java.io.*;
import java.util.*;

interface read_write {
    void reader();
    void writer();
}

class File implements read_write {
    String input;
    String lines;
    String exp[] = new String[10];
    int num[] = new int[50];
    String names[] = new String[50];
    int j=0;
    int k=0;
    Scanner sc = new Scanner(System.in);
    @Override
    public void reader() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Students.txt"));
            System.out.println("The Contents are: ");
            while((lines = br.readLine()) != null) {
                System.out.println(lines);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
        } catch (IOException ex) {
            System.err.println("Input Output Exception!");
        }
    }
    @Override
    public void writer() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Students.txt"));
            System.out.println("Enter the content: ");
            input = sc.nextLine();
            bw.write(input);
        }
        catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
        } 
        catch (IOException ex) {
            System.err.println("Input Output Exception!");
        }
    }
}

public class Tasks {
    public static void main(String[] args) {
        File obj = new File();
        int type;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.printf("\n1. Write into file:\n2. Read from file:\n3. Exit\n");
            System.out.println("Enter Your Choice: ");
            type = sc.nextInt();
            System.out.println();
            switch (type) {
                case 1:
                    obj.writer();
                    break;
                case 2:
                    obj.reader();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");;
            }
        }
    }
}