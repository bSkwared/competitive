// Problem statement: https://www.codechef.com/problems/ISSNAKE/
 
import java.util.*;
 
 
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        
        for (int i = 0; i < T; ++i) {
            int n = scan.nextInt();
            String top = scan.next();
            String bot = scan.next();
            
            boolean impossible = false;
            boolean foundStart = false;
            boolean foundEnd = false;
            char cur = 'e';
            
            for (int spot = 0; spot < top.length(); ++spot) {
                char tc = top.charAt(spot);
                char bc = bot.charAt(spot);
                
                if (foundStart) {
                    if (tc == '.' && bc == '.') {
                        foundEnd = true;
                        continue;
                    }
                    
                    if (foundEnd) {
                        impossible = true;
                        break;
                    }
                    
                    
                    
                    switch (cur) {
                        case 'e':
                            if (tc == '#' && bc == '#') {
                                
                            } else if (tc == '#') {
                                cur = 't';
                            } else if (bc == '#') {
                                cur = 'b';
                            }
                            break;
                        case 'b':
                            if (tc == '#' && bc == '#') {
                                cur = 't';
                            } else if (tc == '#') {
                                impossible = true;
                                break;
                            } else if (bc == '#') {
                                
                            }
                            break;
                        case 't':
                            if (tc == '#' && bc == '#') {
                                cur = 'b';
                            } else if (tc == '#') {
                                
                            } else if (bc == '#') {
                                impossible = true;
                                break;
                                
                            }
                            break;
                    }
                        
                } else {
                    if (tc == '#' ) {
                        if (bc == '#') {
                            cur = 'e';
                        } else {
                            cur = 't';
                        }
                        foundStart = true;
                    }
                    
                    else if (bc == '#') {
                        foundStart = true;
                        cur = 'b';
                    }
                }
            }
            
            if (!impossible && foundStart) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        
    }
}