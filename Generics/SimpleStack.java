/* Import libraries */
import java.util.*;

/* Declare public class SimpleStack with main() method */
public class SimpleStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenSimpleStack<String> stack = new GenSimpleStack<>(5);
        while(true) {
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    try {
                        String item = sc.nextLine();
                        stack.push(item);
                    }
                    catch(StackFullException full) {
                        System.out.print(full.msg);
                    }
                    break;
                case 2:
                    try {
                        String poppedItem = stack.pop();
                        System.out.print(poppedItem + " ");
                    }
                    catch(StackEmptyException empty) {
                        System.out.print(empty.msg);
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }  
    }
}

/* Declare interface IGenSimpleStack<T> */
interface IGenSimpleStack<T> {
    void push(T item) throws StackFullException;
    T pop() throws StackEmptyException;
    boolean isFull();
    boolean isEmpty();
}

/* Declare GenSimpleStack<T> implementing interface IGenSimpleStack  */
class GenSimpleStack<T> implements IGenSimpleStack<T>{
    private Stack<T> stack;
    private int max;
    
    public GenSimpleStack(int size) {
        this.max = size;
        this.stack = new Stack<>();
    }

    @Override
    public boolean isFull() {
        return stack.size() == max;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    @Override
    public void push(T item) throws StackFullException {
        if(isFull()) {
            throw new StackFullException("[Full-" + max + "] ");
        } else {
            stack.push(item);
        }
    }
    
    @Override
    public T pop() throws StackEmptyException {
        if(isEmpty()) {
            throw new StackEmptyException("[Empty] ");
        } else {
            return stack.pop();
        }
    }
}

/* Declare StackFullException class */
class StackFullException extends Exception {
    String msg;
    public StackFullException(String msg) {
        this.msg = msg;
    }
}

/* Declare StackEmptyException class */
class StackEmptyException extends Exception {
    String msg;
    public StackEmptyException(String msg) {
        this.msg = msg;
    }
}
