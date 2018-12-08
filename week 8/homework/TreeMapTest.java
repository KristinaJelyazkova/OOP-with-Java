import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();

        map.put("San Francisco", "Forty-niners");
        map.put("Chicago", "Bears");
        map.put("Denver", "Broncos");
        map.put("Seattle", "Seahawks");
        map.put("Miami", "Dolphins");
        map.put("Detroit", "Lions");

        System.out.printf("The size of the map is %d.%n",
                map.size());

        System.out.printf("The Chicago team is %s.%n",
                map.get("Chicago"));

        map.replace("San Francisco", "Niners");

        System.out.printf("San Diego does %shave a team in the map.%n",
                map.get("San Diego") == null ? "not " : "");

        map.remove("Denver");

        map.put("Dallas", "Cowboys");

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<String, String> current = it.next();
            char firstLetter = current.getValue().charAt(0);

            if(firstLetter >= 'M' && firstLetter <= 'Z'){
                it.remove();
            }
        }

        it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<String, String> current = it.next();
            System.out.printf("City: %s, Team: %s%n",
                    current.getKey(), current.getValue());
        }
    }

}
