package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        String[] inputs = {
            "()()()[()]()", "((()))[]", "([])[](", "([{)]}", "[", "[][][]{{{}}}"
        };
        for (String s : inputs) {
            System.out.println(s + " => " + Application.symbolBalancing(s));
        }
    }
}
