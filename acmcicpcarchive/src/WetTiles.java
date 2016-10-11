import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by anon on 10/9/16.
 */
public class WetTiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int X, Y, T, L, W;
        boolean isFirst = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        while ((X = scan.nextInt()) != -1) {
            queue.clear();
            Y = scan.nextInt();
            T = scan.nextInt();
            L = scan.nextInt();
            W = scan.nextInt();

            int[][] house = new int[Y][X];
            /*for (int i = 0; i < Y; ++i) {
                for (int j = 0; j < X; ++j) {
                    house[i][j] = -1;
                }
            }*/

            for (int i = 0; i < L; ++i) {
                queue.addLast(scan.nextInt()-1);
                queue.addLast(scan.nextInt()-1);
            }

            for (int i = 0; i < W; ++i) {
                int x1 = scan.nextInt()-1;
                int y1 = scan.nextInt()-1;
                int x2 = scan.nextInt()-1;
                int y2 = scan.nextInt()-1;

                house[y1][x1] = -1;
                house[y2][x2] = -1;

                if (x1 == x2) {
                    if (y1 > y2) {
                        for (int j = y2; j <= y1; ++j) {
                            house[j][x1] = -1;
                        }
                    } else {
                        for (int j = y1; j <= y2; ++j) {
                            house[j][x1] = -1;
                        }
                    }
                } else if (y1 == y2) {
                    if (x1 > x2) {
                        for (int j = x2; j <= x1; ++j) {
                            house[y1][j] = -1;
                        }
                    } else {
                        for (int j = x1; j <= x2; ++j) {
                            house[y1][j] = -1;
                        }
                    }
                } else {
                    if (x2 < x1) {
                        int t = x1; x1 = x2; x2 = t;
                        t = y1; y1 = y2; y2 = t;
                    }
                    if (y1 < y2) {
                        for (int j = 0; j < (x2-x1); ++j) {
                            house[y1+j][x1+j] = -1;
                        }
                    } else {
                        for (int j = 0; j < (x2-x1); ++j) {
                            house[y1-j][x1+j] = -1;
                        }
                    }
                }
            }
            /*for (int i = Y-1; i >= 0; --i) {
                for (int j = 0; j < X; ++j) {
                    //if (house[i][j] == 1) ++tileCtr;
                    //System.out.print(house[i][j]);
                }
                //System.out.println();
            }*/

            for (int i = 0; (i < (T-1)) && !queue.isEmpty(); ++i) {
                int size = queue.size()/2;
                for (int j = 0; j < size; ++j) {
                    int x = queue.removeFirst();
                    int y = queue.removeFirst();

                    if (x > 0 && house[y][x-1] == 0) {
                        house[y][x-1] = 1;
                        queue.addLast(x-1);
                        queue.addLast(y);
                    }
                    if (x+1 < X && house[y][x+1] == 0) {
                        house[y][x+1] = 1;
                        queue.addLast(x+1);
                        queue.addLast(y);
                    }

                    if (y > 0 && house[y-1][x] == 0) {
                        house[y-1][x] = 1;
                        queue.addLast(x);
                        queue.addLast(y-1);
                    }
                    if (y+1 < Y && house[y+1][x] == 0) {
                        house[y+1][x] = 1;
                        queue.addLast(x);
                        queue.addLast(y+1);
                    }
                }

            }

            int tileCtr = 0;
            for (int i = Y-1; i >= 0; --i) {
                for (int j = 0; j < X; ++j) {
                    if (house[i][j] == 1) ++tileCtr;
                    //System.out.print(house[i][j]);
                }
                //System.out.println);
            }
            /*if (isFirst) { isFirst = false; }
            else {
                System.out.println("");
            }*/
            System.out.println(tileCtr);


        }
    }
}
