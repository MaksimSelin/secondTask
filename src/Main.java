import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) {
        try {
            BufferedReader strReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter path to file:");
            String fileName = strReader.readLine();
            strReader.close();
            List <String> list = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String buffer = "";
            while ((buffer = reader.readLine()) != null){
                buffer = buffer.replaceAll("\\W+", " ");
                buffer = buffer.trim();
                list.addAll(Arrays.asList(buffer.split("\\s")));
            }
            reader.close();

            Collections.sort(list);

            for (String str : list){
                System.out.print(str + " ");
            }
            Map<String, Integer> map = new HashMap<>();

            for (String str : list){
                if (map.containsKey(str)){
                    map.put(str, map.get(str)+1);
                }
                else map.put(str, 1);
            }

            List<Integer> values = new ArrayList<>(map.values());
            Collections.sort(values);
            list.clear();
            System.out.println("\n");
            for (Map.Entry<String,Integer> pair : map.entrySet()){
                System.out.print("word: " + pair.getKey());
                System.out.println(" meets " + pair.getValue());
                if (pair.getValue()==values.get(values.size()-1))
                    list.add(pair.getKey());
            }
            System.out.println("\nmost popular words\n");
            for (String str : list){
                System.out.println(str);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
