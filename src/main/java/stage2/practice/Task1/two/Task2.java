package stage2.practice.Task1.two;

import java.util.Scanner;
import java.util.Stack;

public class Task2 {
    public static int N;
    public static Stack<Integer>[] tower = new Stack[4];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        tower[1] = new Stack<>();
        tower[2] = new Stack<>();
        tower[3] = new Stack<>();
        System.out.println("Enter number of disks");
        int num = scan.nextInt();
        N = num;
        toh(num);
    }

    public static void toh(int n) {
        for (int i = n; i > 0; i--)
            tower[1].push(i);
        dis();
        move(n, 1, 2, 3);
    }

    public static void move(int n, int a, int b, int c) {
        if (n > 0) {
            move(n - 1, a, c, b);
            int d = tower[a].pop();
            tower[c].push(d);
            dis();
            move(n - 1, b, a, c);
        }
    }

    public static void dis() {
        System.out.println("A " + tower[1] + "\nB " + tower[2] + "\nC " + tower[3]);
        System.out.println("=====================");
    }
}

