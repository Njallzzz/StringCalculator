package stringcalculator;

public class Calculator {
    public static int add(String text) {
        if(text.equals(""))
            return 0;
        String[] numbers = text.split(",");
        int comb = 0;
        for(int i = 0; i < numbers.length; i++) {
            comb += Integer.parseInt(numbers[i]);
        }
        return comb;
    }
}