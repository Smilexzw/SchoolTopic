package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xuzhangwang
 * @date 2019/7/29
 */
public class _146LRU缓存机制使用LinkedHashMap {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int i = cache.get(1);
        System.out.println(i);
        cache.put(3, 3);
        i = cache.get(2);
        System.out.println(i);
        cache.put(4,4);
        i = cache.get(1);
        System.out.println(i);
        i = cache.get(3);
        System.out.println(i);
        i = cache.get(4);
        System.out.println(i);
    }
}


class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}



