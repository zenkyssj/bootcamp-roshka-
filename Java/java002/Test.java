package java002;

import java.util.ArrayList;
import java.util.function.Consumer;;

interface StringFunction {
    String run(String str);
}

public class Test {

    public static void main(String[] args) {

        StringFunction exclaim = (n) -> n + "!";
        StringFunction ask = (n) -> n + "?";

        stringFormated("Hola", exclaim);
        stringFormated("Hola", ask);

    }

    public static void stringFormated(String str, StringFunction format) {
        String result = format.run(str);

        System.out.println(result);
    }

}
