import java.util.Arrays;
import java.util.Scanner;

public class PotionsHomework {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        long total = 0;

        for (int i = 0; i < n; ++i) {
            total += (arr[i]*arr[n-1-i]) % 10007;
            total = total % 10007;
        }

        System.out.println(total);
    }
}
