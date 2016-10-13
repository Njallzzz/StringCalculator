package stringcalculator;

public class Calculator {
    public static int add(String text) {
        if(text.equals(""))
            return 0;
        String[] numbers = text.replace("\n", ",").split(",");
        int comb = 0, tmp;
        for(int i = 0; i < numbers.length; i++) {
            tmp = Integer.parseInt(numbers[i]);
            if(tmp <= 1000)
                comb += tmp;
        }
        return comb;
    }
}