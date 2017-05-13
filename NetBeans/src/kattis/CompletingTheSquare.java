
import java.util.Scanner;

public class CompletingTheSquare {

    static int x1;
    static int y1;
    static int x2;
    static int y2;
    static int x3;
    static int y3;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        x1 = scan.nextInt();
        y1 = scan.nextInt();
        x2 = scan.nextInt();
        y2 = scan.nextInt();
        x3 = scan.nextInt();
        y3 = scan.nextInt();

        double dist12 = dist(x1, y1, x2, y2);
        double dist13 = dist(x1, y1, x3, y3);
        double dist23 = dist(x2, y2, x3, y3);

        int x = 0, y = 0;

        for (int i = 0; i < 6; ++i) {
            if (i % 2 == 0) {
                swap(2, 3);
            } else {
                swap(1, 2);
            }

            int xdiff12 = x1 - x2;
            int ydiff12 = y1 - y2;

            int xdiff23 = x2 - x3;
            int ydiff23 = y2 - y3;

            if (xdiff12 == ydiff23) {
                if (ydiff12 == xdiff23) {
                    x = x3 + ydiff23;
                    y = y3 + xdiff23;
                    break;
                } else if (ydiff12 == -xdiff23) {
                    x = x3 + ydiff23;
                    y = y3 - xdiff23;
                    break;
                }
            } else if (xdiff12 == -ydiff23) {
                if (ydiff12 == xdiff23) {
                    x = x3 - ydiff23;
                    y = y3 + xdiff23;
                    break;
                } else if (ydiff12 == -xdiff23) {
                    x = x3 - ydiff23;
                    y = y3 - xdiff23;
                    break;
                }
            }
        }
        /*
            if (dist12 - 0.001 > dist13) {
                x = x3 + ((y1 - y2) * -1);
                y = y3 + ((x1 - x2) * -1);

            } else if (dist13 - 0.001 > dist23) {
                x = x2 + ((y1 - y3) * -1);
                y = y2 + ((x1 - x3) * -1);

            } else {
                // dist23 is the max
                x = x1 + ((y2 - y1) * -1);
                y = y1 + ((x2 - x1) * -1);

            }*/

        System.out.println(x + " " + y);
        return;
    }

    private static double dist(int x1, int y1, int x2, int y2) {
        int xdiff = x1 - x2;
        int ydiff = y1 - y2;

        int xsqr = xdiff * xdiff;
        int ysqr = ydiff * ydiff;

        return Math.sqrt(xsqr + ysqr);
    }

    private static void swap(int a, int b) {
        if (a == 1) {
            if (b == 2) {
                int tx = x1;
                int ty = y1;
                x1 = x2;
                y1 = y2;
                x2 = tx;
                y2 = ty;
            } else {
                int tx = x1;
                int ty = y1;
                x1 = x3;
                y1 = y3;
                x3 = tx;
                y3 = ty;

            }
        } else if (a == 2) {
            if (b == 1) {
                int tx = x2;
                int ty = y2;
                x2 = x1;
                y2 = y1;
                x1 = tx;
                y1 = ty;
            } else {
                int tx = x2;
                int ty = y2;
                x2 = x3;
                y2 = y3;
                x3 = tx;
                y3 = ty;
            }

        } else if (a == 3) {
            if (b == 1) {
                int tx = x3;
                int ty = y3;
                x3 = x1;
                y3 = y1;
                x1 = tx;
                y1 = ty;

            } else {
                int tx = x3;
                int ty = y3;
                x3 = x2;
                y3 = y2;
                x2 = tx;
                y2 = ty;

            }

        }
    }
}
