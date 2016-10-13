package stringcalculator;

public class Calculator {
    public static int add(String text) {
        if(text.equals(""))
            return 0;
        String[] numbers;
        String delim = ",";
        if(text.startsWith("//")) {
            delim = "";
            int offset;
            for(offset = 2; text.charAt(offset) != '\n'; offset++) {
                delim += Character.toString(text.charAt(offset));
            }
            text = text.substring(offset);
        }
        numbers = text.replace("\n", delim).split(delim);
        String errstring = "Negatives not allowed: ";
        int errlength = errstring.length();
        int comb = 0, tmp;
        for(int i = 0; i < numbers.length; i++) {
            if(!numbers[i].equals("")) {
                tmp = Integer.parseInt(numbers[i]);
                if (tmp < 0) {
                    if (errstring.length() != errlength)
                        errstring += ",";
                    errstring += tmp;
                } else if (tmp <= 1000)
                    comb += tmp;
            }
        }
        if(errstring.length() > errlength)
            throw new IllegalArgumentException(errstring);
        return comb;
    }
}