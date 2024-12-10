import java.util.*;

public class ListDemo {
    static void populateList(Scanner sc, ArrayList<Integer> al) {
        String line = sc.nextLine();
        Scanner a = new Scanner(line);
        while(a.hasNext()) {
            al.add(a.nextInt());
        }
    }
    static void displayList(String title, ArrayList<Integer> al) {
        Iterator<Integer> itr = al.iterator();
        System.out.println(title + ": ");
        while(itr.hasNext()) {
            System.out.print(" " + itr.next());
        }
        System.out.println();
    }
    static void sortListDesc(ArrayList<Integer> al) {
        al.sort(Comparator.reverseOrder());
    }
    static int binSearch(ArrayList<Integer> al, int key) {
        int index = Collections.binarySearch(al, key, Comparator.reverseOrder()) + 1;
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key, index;
        ArrayList<Integer> al = new ArrayList<Integer>();

        populateList(sc, al);
        displayList("Original List", al);
        sortListDesc(al);
        displayList("Sorted List", al);
        
        key = sc.nextInt();

        index = binSearch(al, key);
        if(index > 0) { System.err.println("Position: " + index); }
        else { System.err.println("Not found"); }
    }

    private static void While(boolean hasNextInt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
