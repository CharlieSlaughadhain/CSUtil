public class CSUtil{

    public static String trunc(double number, int places){
        return trunc(number, places, true);
    }

    public static String trunc(double number, int places, boolean includeZeros){

    // Handle negative exponents.
        if (places < 0){
            return new String ("" + number);
        }
    
    // Generate Exponent
        double p = 1;
        for (int i = 0; i < places; i++){
            p *= 10;
        }
    
    // Trim excess decimals and round to correct number (1.5 rounds to 2 and 
        long LNumber = (long) (number * p * 10);
        long mod = LNumber % 10L;
        int director = (int) mod;
        LNumber /= 10;
        if (director >= 5) LNumber++;
        double FNumber = (double) LNumber / p;

    // Convert Double to String
        String str = doubleToString(FNumber);

    // Ensure all zeros are shown
        if (places > 0 && includeZeros){
            int end;
            int dot;
            while (true){
                end = str.length() - 1;
                dot = str.indexOf(".");
                if ((end - dot) < places){
                    str += '0';
                } else {
                    break;
                }
            }
    // Remove implicit ".0" from double to String conversion
        } else if (places == 0){
            str = str.substring(0, str.length() - 2);
        }

    // Return the generated string for ouput
        return str;
    }


// Convert Double to a String
    public static String doubleToString(double d){

        // Find the length of the integral part.
        Long l = Long.valueOf(1);
        int len = 0;
        while(d > l){
            l *= 10;
            len++;
        }
        int intLen = len;

        // Rewrite as a string.
        int count = len - 3;
        String result = "";
        int letter;
        for (int i = 0; i < count; i++){
            l /= 10;
            letter = (int) (d / l);
            result += letter;
            d -= l * letter;
        }
        result += (float) d;

        return result;
    }


// Handle various use cases.
    public static String toCurrency(double value, String currency){ return formatString(trunc(value, 2, true), currency); }

    public static String formatString(double number, String prefix){ return formatString(String.valueOf(number), prefix); }

    public static String formatString(double number){ return formatString(String.valueOf(number)); }
    
    public static String formatString(String num){ return formatString(num, ""); }

    public static String formatString(String num, String prefix){

        int x = num.indexOf(".");
        int div = x / 3;
        int   r = x % 3;

        String tail = "";
        for (int i = x; i < num.length(); i++) {
            tail += num.charAt(i);
        }

        int point = 0;
        String str = prefix;

        for (int i = 0; i < r; i++) {
            str += num.charAt(point++);
        }

        for (int i = 0; i < div; i++){

            if (r != 0) str += ",";
            r++;

            for (int j = 0; j < 3; j++){
                str += num.charAt(point++);
            }
        }

        return str + tail;
    }
}
