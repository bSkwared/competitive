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
		scan.nextLine();
		String str = scan.next();
		String fin = "";
		
		boolean inBlack = str.charAt(0) == 'B';
		int blackCtr = 0;
		int groupCtr = 0;
		
		for (int i = 0; i < str.length(); ++i) {
			if (inBlack && str.charAt(i) == 'W') {
				fin+=Integer.toString(blackCtr) + " ";
				++groupCtr;
				blackCtr = 0;
				inBlack = false;
			} else if (!inBlack && str.charAt(i) == 'B') {
				inBlack = true;
				blackCtr = 1;
			} else {
				++blackCtr;	
			}
		}
		
		if (inBlack) {
			++groupCtr;
			fin += Integer.toString(blackCtr);
		}
		
		System.out.print(groupCtr);
		fin = fin.trim();
		if (!fin.isEmpty()){
			System.out.print("\n" + fin.trim());
		}
	}
}