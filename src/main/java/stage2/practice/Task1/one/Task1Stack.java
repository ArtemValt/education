package stage2.practice.Task1.one;

import java.util.*;


public class Task1Stack {
     static Stack<Character> stack = new Stack<>();
     static final List<Character> OPEN_BRACKETS = Arrays.asList('(', '{', '[');
     static final List<Character> CLOSING_BRACKETS = Arrays.asList(')', '}', ']');
    public void Task1(String s) {
        char[] textChar = s.toCharArray();
        for (int i = 0; i < textChar.length; i++) {
            if (OPEN_BRACKETS.contains(textChar[i]))
                stack.push(textChar[i]);
            else {
                if (CLOSING_BRACKETS.contains(textChar[i])) {
                    if (!stack.empty() && stack.peek() == getOpenBracketPair(textChar[i])) {
                        stack.pop();
                    } else {
                        if (stack.empty()) {
                            System.out.println("Скобки расставлены не правильно! Нет открывающей " + getOpenBracketPair(textChar[i]));
                            return;
                        }

                        char symbol = ' ';
                        while (!stack.empty()) {
                            if (stack.peek() == getOpenBracketPair(textChar[i])) {
                                System.out.println("Скобки расставлены не правильно! Нет закрывающей " + getClosingBracketPair(symbol));
                                return;
                            }
                            symbol = stack.pop();
                        }

                        System.out.println("Скобки расставлены не правильно! Нет открывающей " + getOpenBracketPair(textChar[i]));
                        return;
                    }
                }
            }
        }
        if (!stack.empty()) {
            System.out.println("Скобки расставлены не правильно! Нет закрывающей " + getClosingBracketPair(stack.pop()));
            return;
        }
        System.out.println("Скобки расставлены правильно!");
    }
    public  char getOpenBracketPair(char bracket) {
        return (bracket == '}') ? '{' : (bracket == ')') ? '(' :
                (bracket == ']') ? '[' : '\0';
    }
    public  char getClosingBracketPair(char bracket) {
        return (bracket == '{') ? '}' : (bracket == '(') ? ')' :
                (bracket == '[') ? ']' : '\0';
    }
}