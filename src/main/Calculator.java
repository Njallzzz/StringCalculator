package stringcalculator;

public class Calculator {
    public static int add(String text) {
        if(text.equals(""))
            return 0;
        String[] numbers = text.replace("\n", ",").split(",");
        String errstring = "Negatives not allowed: ";
        int errlength = errstring.length();
        int comb = 0, tmp;
        for(int i = 0; i < numbers.length; i++) {
            tmp = Integer.parseInt(numbers[i]);
            if(tmp <= 1000 && tmp >= 0)
                comb += tmp;
            else if(tmp < 0) {
                if(errstring.length() != errlength)
                    errstring += ",";
                errstring += tmp;
            }
        }
        if(errstring.length() > errlength)
            throw new IllegalArgumentException(errstring);
        return comb;
    }
}