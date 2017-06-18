/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int numPass = scan.nextInt();
		int numFail = scan.nextInt();
		int[] lens = new int[numPass];
		for (int i = 0; i < numPass; ++i) {
			lens[i] = scan.next().length();
		}
		Arrays.sort(lens);
		int correctLen = scan.next().length();
		int numReq = 0;
		long curTime = 0;
		long maxTime = 0;
		boolean min = false;
		boolean max = false;
		
		for (int i = 0; i < numPass; ++i) {
			curTime += 1;
			if (!min && lens[i] == correctLen) {
				min = true;
				System.out.print(Long.toString(curTime) + " ");
			}
			if (i == (numPass-1) || lens[i+1] > correctLen) {
				System.out.print(Long.toString(curTime));
				break;
			}
			if ((i+1) % numFail == 0) curTime += 5;
		}
		
		
	}
}