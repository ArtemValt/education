package stage2.practice.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public void test(String s) {
        List<String> stack = new ArrayList<>();
        Collections.addAll(stack, s.split(""));
        stack = stack.stream().
                filter(x -> x.equals("(") || x.equals("{") || x.equals("[") || x.equals(")") || x.equals("}") || x.equals("]")).
                collect(Collectors.toList());
            if (stack.stream().filter(x -> x.equals("(")).count() != stack.stream().filter(x -> x.equals(")")).count())
                System.out.println("( не верно открыта/закрыта фигурная скобка");
            if (stack.stream().filter(x -> x.equals("{")).count() != stack.stream().filter(x -> x.equals("}")).count())
                System.out.println("{ не верно открыта/закрыта фигурная скобка");
            if (stack.stream().filter(x -> x.equals("[")).count() != stack.stream().filter(x -> x.equals("]")).count())
                System.out.println("[ не верно открыта/закрыта фигурная скобка");
        }

}

