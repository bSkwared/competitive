// Problem statement: https://www.codechef.com/problems/SNAKPROC/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
 
public class SnakProc {
 
    public static void main(String[] args) {
 
        Scanner scan = new Scanner(System.in);
        
        scan.nextInt();
        while (scan.hasNextInt()) {
            scan.nextInt();
            String next = scan.next();
            
            boolean isValid = false;
            
            Pattern snake = Pattern.compile("\\.*(\\.*H\\.*T\\.*)*\\.*");
            Matcher match = snake.matcher(next);
            
            isValid = match.matches();
            
            System.out.print((isValid ? "V" : "Inv"));
            System.out.println("alid");
        }
    }
    
}