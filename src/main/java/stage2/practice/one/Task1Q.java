package stage2.practice.one;

import java.util.*;
import java.util.stream.Collectors;

public class Task1Q {
    public static Deque<Character> queue = new LinkedList<>();
    private static final List<Character> OPEN_BRACKETS = Arrays.asList('(', '{', '[');
    private static final List<Character> CLOSING_BRACKETS = Arrays.asList(')', '}', ']');
    public void Task1Q(String s) {
        char[] txtmassiv = s.toCharArray();
        for (int i = 0; i < txtmassiv.length; i++) {
            if (OPEN_BRACKETS.contains(txtmassiv[i]))
                queue.push(txtmassiv[i]);
            else {
                if (CLOSING_BRACKETS.contains(txtmassiv[i])) {
                    if (!queue.isEmpty() && queue.peek().equals(getOpenBracketPair(txtmassiv[i])))
                        queue.remove();
                    else {
                        if (queue.isEmpty()) {
                            System.out.println("Скобки расставлены не правильно! Нет открывающей " + getOpenBracketPair(txtmassiv[i]));
                            return;
                        }
                        char symbol = ' ';
                        while (!queue.isEmpty()) {
                            if (queue.peek() == getClosingBracketPair(txtmassiv[i])) {
                                System.out.println("Скобки расставлены не правильно! Нет закрывающей " + getClosingBracketPair(symbol));
                                return;
                            }
                            symbol = queue.remove();
                        }
                        System.out.println("Скобки расставлены не правильно! Нет открывающей " + getOpenBracketPair(txtmassiv[i]));
                        return;
                    }

                }
            }

        }
        if (!queue.isEmpty()) {
            System.out.println("Скобки расставлены не правильно! Нет закрывающей " + getClosingBracketPair(queue.peek()));
            return;

        }
        else
            System.out.println("Все правильно");
    }
    public  char getOpenBracketPair(char bracket) {
        return switch (bracket) {
            case '}' -> '{';
            case ')' -> '(';
            case ']' -> '[';
            default -> '\0';
        };
    }
    public  char getClosingBracketPair(char bracket) {
        return switch (bracket) {
            case '{' -> '}';
            case '(' -> ')';
            case '[' -> ']';
            default -> '\0';
        };
    }
}
