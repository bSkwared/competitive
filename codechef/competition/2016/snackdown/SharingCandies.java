import java.util.*;
import java.lang.*;
import java.io.*;

class SharingCandies
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();

        for (int cases = 0; cases < t; ++cases) {
            long A = scan.nextLong();
            long B = scan.nextLong();
            long C = scan.nextLong();
            long D = scan.nextLong();

            long initDiff = A - B;

            if (initDiff < 0) {
                initDiff = -initDiff;
            }

            if ( initDiff == 0 || (C == 0 && D == 0) ) {
                System.out.println(initDiff);
            
            } else {
                if (A > B) {
                    if (D == 0) {
                        System.out.println(initDiff);
                    } else {
                        System.out.println(findMin(A, B, C, D));
                    }
                } else {
                    if (C == 0) {
                        System.out.println(initDiff);
                    } else {
                        System.out.println(findMin(B, A, D, C));
                    }
                }
            }


        }
    }

    public static long findMin(long a, long b, long c, long d) {

        long diff = a - b;
        long min;

        if (c == 0) {
            long ctr = diff/d;
            min = diff - (ctr * d);

            long t = ((ctr + 1) * d) - diff;

            if (t < min) {
                min = t;
            }

        } else {
            
            long gcd = GCD(c, d);

            diff %= gcd;

            min = diff;

            long t = diff - gcd;
            t = -t;
            if (t < min) {
                min = t;
            }
        }

        return min;
    }


    public static long GCD(long n1, long n2) {
        if(n2 == 0){
            return n1;
        } else {
            return GCD(n2, n1 % n2);
        }
    }
}