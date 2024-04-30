package lettersequences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class InvalidTransactions {
    public static void main(String[] args) {
        String[] s = {"alice,20,800,mtv","alice,50,100,beijing"};
        System.out.println(invalidTransactions(s).toString());
    }

    public static List<String> invalidTransactions(String[] transactions) {
        Map<String[], List<Integer>> map = new HashMap<>();
        List<String> l = new ArrayList<>();

        for(String transaction: transactions) {
            Scanner s = new Scanner(transaction).useDelimiter(",");
            boolean invalid = false;
            while(s.hasNext()) {
                String name = s.next();
                int time = Integer.parseInt(s.next());
                int amount = Integer.parseInt(s.next());
                if(amount > 1000) {
                    l.add(transaction);
                    invalid = true;
                }
                String city = s.next();
                String[] mapKey = {name, city};

                if(!map.containsKey(mapKey) && !invalid) {
                    map.put(mapKey, new ArrayList<>(time));
                } else {
                    for(int prevTime: map.get(mapKey)) {
                        if(prevTime+60>time && prevTime-60<time) {
                            l.add(transaction);
                            invalid = true;
                        }
                    }
                }
                if(invalid) {
                    break;
                }
            }
            s.close();
        }
        return l;
    }
}

