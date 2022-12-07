import java.util.ArrayDeque;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        // ArrayDeque<Integer> test = new ArrayDeque<>();

        // test.push(1);
        // test.push(2);
        // test.push(3);
        // test.push(4);
        // test.push(5);
        // test.push(6);

        // System.out.println(test.size());
        // int i = 0; 
        // while (i < 6){
        //     System.out.println(test.pop());
        //     i++;
        // }


        HashMap<String,Integer> test = new HashMap<>();

        test.put("1",0);
        test.put("2",0);
        test.put("3",0);
        test.put("4",0);
        test.put("5",0);


        System.out.println(test.size());
        
        System.out.println(test.values());
        
        System.out.println(test.keySet());

        for(String s: test.keySet()){
            System.out.println(s);
            System.out.println(test.get(s));
        }

    }
}
