import java.util.*;
import java.lang.*;
import java.io.*;

class CryptKicker
{
    public static void main (String[] args) throws java.lang.Exception
    {
        long startTime = System.currentTimeMillis();
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        String[] org = new String[n];
        String[] con = new String[n];


        String str;
        for (int i = 0; i < n; ++i) {
            str = scan.next();
            org[i] = str;
            con[i] = convert(str);
        }
        scan.nextLine();
        while (scan.hasNextLine()) {

            char[] alph = new char[26];
            resetAlph(alph);
            boolean allFound = true;

            str = scan.nextLine();

            Scanner words = new Scanner(str);
            String given;
            String converted;

            ArrayList<ArrayList<String>> poss = new ArrayList<>();
            ArrayList<String> word = new ArrayList<>();

            System.out.println(System.currentTimeMillis() - startTime);
            while (words.hasNext()) {

                given = words.next();
                if (word.contains(given)) {
                    continue;
                }
                converted = convert(given);
                word.add(given);
                ArrayList<String> al = new ArrayList<>();
                poss.add(al);

                for (int i = 0; i < con.length; ++i) {
                    if (converted.equals(con[i])) {
                        al.add(org[i]);
                    }
                }

                if (al.isEmpty()) {
                    allFound = false;
                    break;
                }
            }

            if (allFound) {


                boolean found = false;
                int[] starting = new int[word.size()];

                boolean lastCase = false;
                while(!found) {

                    if (!lastCase) {
                        lastCase = true;
                        for (int k = 0; k < starting.length; ++k) {
                            if (starting[k] + 1 != poss.get(k).size()) {
                                lastCase = false;
                                break;
                            }
                        }

                    } else {
                        Arrays.fill(alph, '*');
                        break;
                    }

                    String[] strs = new String[word.size()];
                    for(int i = 0; i < starting.length; ++i) {
                        strs[i] = poss.get(i).get(starting[i]);
                    }

                    for (int i = 0; i < strs.length; ++i) {
                        String guess = strs[i];
                        String crypt = word.get(i);
                        boolean collision = false;

                        for (int k = 0; k < guess.length(); ++k) {
                            if (alph[crypt.charAt(k) - 'a'] == 0 || alph[crypt.charAt(k) - 'a'] == guess.charAt(k)) {
                                alph[crypt.charAt(k) - 'a'] = guess.charAt(k);
                            } else {
                                collision = true;
                                break;
                            }
                        }

                        if (collision) {
                            incrementInts(starting, poss, 0);
                            resetAlph(alph);
                            break;
                        } else if (i + 1 == strs.length) {
                            found = true;
                        }
                    }


                }

                System.out.println(replaceChars(str, alph));
            } else {
                Arrays.fill(alph, '*');
                System.out.println(replaceChars(str, alph));

            }

        }
    }

    public static void incrementInts(int[] nums, ArrayList<ArrayList<String>> al, int position) {
        nums[position] = (nums[position] + 1) % al.get(position).size();

        if (nums[position] == 0 && position + 1 < nums.length) {
            incrementInts(nums, al, position + 1);
        }

    }

    public static void resetAlph(char[] alph) {
        for (int i = 0; i < alph.length; ++i) {
            alph[i] = 0;
        }
    }

    public static String replaceChars(String str, char[] key) {
        char[] s = str.toCharArray();

        for (int i = 0; i < s.length; ++i) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                s[i] = key[s[i]-'a'];
            }
        }

        return new String(s);
    }

    public static String convert(String str) {
        StringBuilder ret = new StringBuilder(str.length());
        char[] alph = new char[26];
        for (int i = 0; i < 26; ++i) {
            alph[i] = 0;
        }

        char ctr = 'a';
        for (int i = 0; i < str.length(); ++i) {
            if (alph[str.charAt(i) - 'a'] == 0) {
                alph[str.charAt(i) - 'a'] = ctr;
                ret.append(ctr);
                ++ctr;
            } else {
                ret.append(alph[str.charAt(i) - 'a']);
            }
        }

        return ret.toString();
    }
}