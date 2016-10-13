package stringcalculator;

public class Calculator {
    public static int add(String text) {
        if(text.equals(""))
            return 0;
        String[] numbers = text.split(",");
        if(numbers.length == 1)
            return Integer.parseInt(numbers[0]);
        else if(numbers.length == 2)
            return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        else if(numbers.length == 3)
            return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]) + Integer.parseInt(numbers[2]);
        return 0;
    }
}