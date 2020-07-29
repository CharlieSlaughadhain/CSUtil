
public class Test {
    public static void main(String[] args) {
        
        double tester = 99999999999.99; // Good for up too 11 digits

        System.out.println(CSUtil.toCurrency(tester, "$"));
    }
}