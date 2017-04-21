import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HopperMain {
    private static HashMap<String, Integer> combinationsHashMap = new HashMap<>();

    public static void main(String[] args) {
        int n, k;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please enter N");
            n = scanner.nextInt();
            System.out.println("Please enter K");
            k = scanner.nextInt();
            if (n > 0 && k > 0) {
                System.out.println(countCompositionRecursive(n, k));
            } else {
                System.out.println("Please enter positive number!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter integer");
        }
    }

    private static int countCompositionRecursive(int n, int k) {
        int r = 0;
        String keyString = "" + n + "," + k;
        Integer value = combinationsHashMap.get(keyString);
        if (value != null) {
            r = value;
        } else {
            if (k == n - 1) {
                r = (int) Math.pow(2, n - 1) - 1;
            } else if (k >= n) {
                r = (int) Math.pow(2, n - 1);
            } else {
                for (int i = 1; i <= k; i++) {
                    r += countCompositionRecursive(n - i, k);
                }
            }
            combinationsHashMap.put(keyString, r);
        }
        return r;
    }
}
