import java.util.*;

class ThreadDemo implements Runnable {
    Thread thrd;
    String name;
    int[] list;
    int result;
    ThreadDemo(String tname, int[] arr) {
        thrd = new Thread(this, tname);
        name = tname;
        list = arr;
        thrd.start();
    }

    @Override
    public void run() {
        System.out.println("Run Method...");
        for (int i = 0; i < list.length; i++) {
            result += list[i];
        }
    }
    public int getSum() {
        return result;
    }
}

public class MyThread {
    public static void main(String[] args) {
        int i = 0;
        String line;
        System.out.println("Enter list of numbers(Range = 10): ");
        Scanner sc = new Scanner(System.in);
        line = sc.nextLine();
        int[] arr = new int[line.length()];
        Scanner a = new Scanner(line);
        while(a.hasNext()) {
            arr[i++] = a.nextInt();
        }
        ThreadDemo t1 = new ThreadDemo("Thread 1", arr);
        ThreadDemo t2 = new ThreadDemo("Thread 2", arr);

        System.out.println("Waiting for threads to finish...");
        while(t1.thrd.isAlive() || t2.thrd.isAlive()) {}

        System.out.println(t1.thrd.getName() + ": " + t1.getSum());
        System.out.println(t2.thrd.getName() + ": " + t2.getSum());
    }
}