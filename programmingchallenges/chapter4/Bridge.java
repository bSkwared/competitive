import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();

        for (int ctr = 0; ctr < cases; ++ctr) {
            int n = scan.nextInt();

            int[] ppl = new int[n];
            for (int i = 0; i < n; ++i) {
                ppl[i] = scan.nextInt();
            }

            Arrays.sort(ppl);

            int amntToCross = n;

            int[] ppr = new int[n];

            int time = 0;
            ArrayDeque<Integer> order = new ArrayDeque<>();

            while (amntToCross > 3) {
                int possA = 2*ppl[0] + ppl[amntToCross - 1] + ppl[amntToCross - 2];
                int possB = ppl[0] + 2*ppl[1] + ppl[amntToCross-1];

                if (possA < possB) {
                   time += possA;

                    order.addLast(ppl[0]);
                    order.addLast(ppl[amntToCross - 2]);
                    order.addLast(-1);
                    order.addLast(ppl[0]);
                    order.addLast(-1);
                    order.addLast(ppl[0]);
                    order.addLast(ppl[amntToCross - 1]);
                    order.addLast(-1);
                    order.addLast(ppl[0]);
                    order.addLast(-1);
                } else {
                    time += possB;

                    order.addLast(ppl[0]);
                    order.addLast(ppl[1]);
                    order.addLast(-1);
                    order.addLast(ppl[0]);
                    order.addLast(-1);
                    order.addLast(ppl[amntToCross - 2]);
                    order.addLast(ppl[amntToCross - 1]);
                    order.addLast(-1);
                    order.addLast(ppl[1]);
                    order.addLast(-1);

                }
                amntToCross -= 2;
            }

            switch (amntToCross) {
                case 3:
                    time += ppl[0] + ppl[1] + ppl[2];
                    order.addLast(ppl[0]);
                    order.addLast(ppl[1]);
                    order.addLast(-1);
                    order.addLast(ppl[0]);
                    order.addLast(-1);
                    order.addLast(ppl[0]);
                    order.addLast(ppl[2]);
                    order.addLast(-1);
                    break;
                case 2:
                    time += ppl[1];
                    order.addLast(ppl[0]);
                    order.addLast(ppl[1]);
                    order.addLast(-1);
                    break;
                case 1:
                    time += ppl[0];
                    order.addLast(ppl[0]);
                    order.addLast(-1);
                    break;
            }

            System.out.println(time);

            while (order.size() > 0) {
               int item = order.removeFirst();
               if (item == -1) {
                   System.out.print('\n');
               } else {
                   System.out.print(item);
                   if (order.size() > 0 && order.peek() != -1) {
                       System.out.print(' ');
                   }
               }
            }



            System.out.println();






        }
    }
}
