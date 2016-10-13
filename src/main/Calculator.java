package stringcalculator;

public class Calculator {
    public static int add(String text) {
        if(text.equals(""))
            return 0;
        String[] numbers;
        if(text.contains(";"))
            numbers = text.replace("\n", "").replace(",", "").replace("\\", "").split(";");
        else
            numbers = text.replace("\n", ",").split(",");
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