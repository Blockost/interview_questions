import java.util.HashMap;
import java.util.Map;

/**
 * Created by blockost on 20/03/17.
 */
public class HashTableRansomNote {
    private Map<String, Integer> magazineMap = new HashMap<>();

    private String note;

    public HashTableRansomNote(String magazine, String note) {
        for(String s : magazine.split(" ")){
            if(magazineMap.containsKey(s)){
                magazineMap.put(s, magazineMap.get(s) + 1);
            } else {
                magazineMap.put(s, 1);
            }
        }

        this.note = note;
    }

    public boolean solve(){
        for(String s : note.split(" ")){
            if(!magazineMap.containsKey(s) || magazineMap.get(s) <= 0)
                return false;
            magazineMap.put(s, magazineMap.get(s) - 1);
        }

        return true;
    }
}
