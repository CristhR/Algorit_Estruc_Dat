package Ejercicio4;

import Actividad1.ExceptionIsEmpty;
import Actividad1.Stack;
import Ejercicio1.StackLink;

public class Application {
    public static boolean symbolBalancing(String s) {
        Stack<Character> pila = new StackLink<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) return false;
                char top;
                try {
                    top = pila.pop();
                } catch (ExceptionIsEmpty e) {
                    return false;
                }
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{'))
                    return false;
            }
        }
        return pila.isEmpty();
    }
}
