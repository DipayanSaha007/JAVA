import java.util.*;

class stack {
    int arr[] = new int[50];
    int i = -1;
    void push(int n) {arr[++i] = n;}
    int pop() {return arr[i--];}
    boolean isFull() {if(i==49) return true; else return false;}
    boolean isEmpty() {if(i==-1) return true; else return false;}
}
public class Postfix {
    public static void main(String[] args) {
        System.out.print("Enter an postfix expression(Seperated by ' '): ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String exp[] = line.split(" ");
        stack s = new stack();
        for (int i = 0; i < exp.length; i++) {
            switch (exp[i]) {
                case "+":
                    int var0;
                    if (s.isEmpty()) {var0=0;}
                    else {var0= s.pop() + s.pop();}
                    s.push(var0);
                    break;
                case "-":
                    int var1;
                    if (s.isEmpty()) {var1=0;}
                    else {var1 = s.pop();var1 = s.pop() - var1;}
                    s.push(var1);
                    break;
                case "*":
                    int var2;
                    if (s.isEmpty()) {var2=0;}
                    else {var2 = s.pop() * s.pop();}
                    s.push(var2);
                    break;
                case "/":
                    int var3;
                    if (s.isEmpty()) {var3=0;}
                    else {var3 = s.pop();var3 = s.pop() / var3;}
                    s.push(var3);
                    break;
                default:
                    if (s.isFull()) {System.out.println("Length exceeds"); System.exit(0);}
                    s.push(Integer.parseInt(exp[i]));
                    break;
            }
        }
        System.out.println("Result = " + s.pop());
    }
}