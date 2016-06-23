import java.util.*;
import java.lang.*;
import java.io.*;

class StudyPlans
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs;

        inputs = bi.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int q = Integer.parseInt(inputs[1]);



        TreeMap<Integer, Integer> classes = new TreeMap<Integer, Integer>();

        HashMap<Key, Integer> visits = new HashMap<Key, Integer>();

        Integer s, e;
        int max = 0;
        Integer tempGet;
        for (int i = 0; i < n; ++i) {
            inputs = bi.readLine().split(" ");
            s = Integer.parseInt(inputs[0]);
            e = Integer.parseInt(inputs[1]);
            
            tempGet = classes.put(s, e);
            if (tempGet != null && tempGet < e) {
                classes.put(s, tempGet);
            }
        }

        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

//log.write("This will be printed on stdout!\n");
//log.flush();

        for (int cases = 0; cases < q; ++cases) {

            inputs = bi.readLine().split(" ");
            Integer start = Integer.parseInt(inputs[0]);
            int finish = Integer.parseInt(inputs[1]);
            Key k = new Key(start, finish);

            if (visits.containsKey(k)) {
                log.write(Integer.toString(visits.get(k)) + '\n');
                continue;
            }

            int classesTaken = 0;

// find first class
            int index;
            Map.Entry tEntry;

            while (start < finish) {

                tEntry = classes.ceilingEntry(start);
                if (tEntry == null) {
                    break;
                } else {
                    index = (int)tEntry.getValue();
                    int minFinish = index;

                    for (Map.Entry<Integer, Integer> ent : classes.tailMap(start).entrySet()) {
                        if ((int)ent.getValue() < minFinish) {
                            minFinish = (int)ent.getValue();
                        }
                        if ((int)ent.getKey() > minFinish) {
                            break;
                        }

                    }

                    if (minFinish <= finish) {
                        ++classesTaken;
                    }
                    start = minFinish + 1;
                }

            }

            log.write(Integer.toString(classesTaken) + '\n');
            visits.put(k, classesTaken);

        }

        log.flush();

    }


}
class Key {

    private final int x;
    private final int y;

    public Key(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key key = (Key) o;
        return x == key.x && y == key.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}