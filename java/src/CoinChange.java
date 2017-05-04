import java.util.HashMap;
import java.util.Map;

/**
 * Created by blockost on 20/03/17.
 */
public class CoinChange {

    static Map<Integer, Long> cacheMap = new HashMap<>();

    // Dynamic programming problem (memorization, i.e caching!)
    public static long makeChange(int[] coins, int money){
        if(coins.length == 0) return 0;
        if(money == 0) return 1;


        for(int coin : coins){
            for(Integer key : cacheMap.keySet())
        }
    }
}
