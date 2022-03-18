package stage2.practice.one;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение");
//        String str = sc.nextLine();
//        Task1 test1 = new Task1();
//        test1.test(str);
        Task1Stack task1Stack = new Task1Stack();
        task1Stack.Task1(sc.nextLine());

    }
}
