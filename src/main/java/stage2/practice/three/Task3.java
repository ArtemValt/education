package stage2.practice.three;

import java.util.*;

public class Task3 {
    private static final TreeMap<Character, String> treemap = new TreeMap<>();
    private static int size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Какую операцию хотите выполнить:
                1)compress (упаковка)
                2)decompress (распаковка)
                """);
        String answer = sc.nextLine();
        switch (answer) {
            case "1" -> {
                System.out.println("Введите текст: ");
                String text = sc.nextLine();
                makingAlphabet(text);
                compress(text);
                break;
            }
            case "2" -> {
                System.out.println("Введите алфавит: ");
                String text = sc.nextLine();
                makingAlphabet(text);
                System.out.println("Введите бинарный код: ");
                text = sc.nextLine();
                decompress(text);
                break;
            }
            default -> System.out.println("Такого варианта ответа нет");
        }
    }
    private static void compress(String binary) {
        int count = 0;
        BitSet bitset = new BitSet();
        for (int i = 0; i < binary.length(); i++) {
            for( HashMap.Entry pair: treemap.entrySet()) {
                if (binary.charAt(i) == (char) pair.getKey()) {
                    String value = (String) pair.getValue();

                    for (int j = 0; j < value.length(); j++) {
                        if (value.charAt(j) == '1') {
                            bitset.set(count);
                        }
                        count++;
                    }
                }
            }
        }
        System.out.println("\nБитовое представление :" + bitset + "\n");
        System.out.println("Ваша запись в двоичном виде:");
        for(int i = 0; i < getSize(removeDuplicates(binary).toCharArray())*binary.length(); i++) {
            if(bitset.get(i)) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
    }
    private static void decompress (String binary) {
        BitSet bitset = new BitSet();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                bitset.set(i);
            }
        }
        System.out.println("\nБитовое представление в BitSet:" + bitset + "\n");
        System.out.println("\nНормальный вид:");
        int i = 0;
        while (i < binary.length()) {
            String numBin = "";
            while (size != numBin.length()) {
                numBin += bitset.get(i) ? "1" : "0";
                i++;
            }
            for( HashMap.Entry pair: treemap.entrySet()) {
                if (numBin.equals(pair.getValue())) {
                    System.out.print(pair.getKey());
                }
            }
        }
    }
    public static int plusOneBinaryNum(int firstNum) {
        StringBuilder output = new StringBuilder();
        int carry = 0, secondNum = 1, temp;
        while (firstNum != 0 || secondNum != 0) {
            temp = (firstNum % 10 + secondNum % 10 + carry) % 2;
            output.append(temp);

            carry = (firstNum % 10 + secondNum % 10 + carry) / 2;
            firstNum = firstNum / 10;
            secondNum = secondNum / 10;
        }
        if (carry != 0) {
            output.append(carry);
        }

        return Integer.parseInt(output.reverse().toString());
    }public static void makingAlphabet(String text) {
        int binary = 0;

        char[] textChar = removeDuplicates(text).toCharArray();
        size = getSize(textChar);
        Arrays.sort(textChar);

        for (char c : textChar) {
            String fullBinaryString = String.valueOf(binary);

            while (fullBinaryString.length() != size) {
                fullBinaryString = "0" + fullBinaryString;
            }

            treemap.put(c, fullBinaryString);
            binary = plusOneBinaryNum(binary);
        }
        System.out.println(treemap);
    }
    public static String removeDuplicates(String text){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,text.split(""));
        return list.stream().distinct().toString();
    }
    public static int getSize(char[] textChar) {
        return (int) Math.ceil(Math.sqrt(textChar.length));
    }
}