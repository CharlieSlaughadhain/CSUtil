public class CSUtil{

    public static String trunc(double number, int places){

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
        int LNumber = (int) (number * p * 10);
        int director = LNumber % 10;
        LNumber /= 10;
        if (director >= 5) LNumber++;
        double FNumber = (double) LNumber / p;

    // Convert Double to String
        String str = new String("" + FNumber);

    // Ensure all zeros are shown
        if (places > 0){
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
}