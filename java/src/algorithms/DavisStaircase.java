package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by blockost on 20/03/17.
 */
public class DavisStaircase {

    private static Map<Integer, Integer> cacheMap = new HashMap<>();

    public static int climb(int staircase) {

        if (cacheMap.containsKey(staircase))
            return cacheMap.get(staircase);

        if (staircase < 0) return 0;
        if (staircase == 1) return 1;
        if (staircase == 2) return 2;
        if (staircase == 3) return 4;

        int cache = climb(staircase - 1)
                + climb(staircase - 2)
                + climb(staircase - 3);

        cacheMap.put(staircase, cache);
        return cache;
    }
}
