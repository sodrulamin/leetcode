package p460;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    /**
     * Key for this map is the original key specified in the method {@link #get(int)} and value is a pair of
     * corresponding value and frequency of access of the key.
     */
    private final HashMap<Integer, Pair<Integer, Integer>> cache;

    /**
     * Key for this map is the frequency of access and the value is the list of keys that has been accessed given
     * frequency times
     */
    private final HashMap<Integer, LinkedHashSet<Integer>> frequencies;

    /**
     * Defines the maximum capacity for this {@link LFUCache}. At any point if the size of this {@link LFUCache} reaches
     * this value, on next addition, we will remove the least frequency key and add the new one.
     */
    private final int capacity;

    /**
     * Current value of minimum frequency, that any value have. We will target a key with this frequency value to remove
     * for next time.
     */
    private int minimumFrequency;

    /**
     * Only constructor
     * @param capacity the maximum capacity that this {@link LFUCache} can grow.
     */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.minimumFrequency = 0;
    }

    public int get(int key) {
        Pair<Integer, Integer> pair = cache.get(key);
        if(pair == null)
            return -1;

        LinkedHashSet<Integer> frequency = frequencies.get(pair.getKey());
        frequency.remove(key);
        if(frequency.size() == 0) {
            frequencies.remove(pair.getKey());
            if(minimumFrequency == pair.getKey()){
                minimumFrequency++;
            }
        }

        insert(key, pair.getKey() + 1, pair.getValue());

        return pair.getValue();
    }

    public void put(int key, int value) {
        if(capacity <= 0)
            return;

        Pair<Integer, Integer> pair = cache.get(key);
        if(pair != null){
            cache.put(key, new Pair<>(pair.getKey(), value));
            get(key);
            return;
        }

        if(cache.size() == capacity){
            LinkedHashSet<Integer> frequency = frequencies.get(minimumFrequency);
            int keyToDelete = frequency.iterator().next();
            frequency.remove(keyToDelete);
            cache.remove(keyToDelete);
        }

        minimumFrequency = 1;
        insert(key, 1, value);
    }

    private void insert(int key, int frequency, int value){
        cache.put(key, new Pair<>(frequency, value));

        LinkedHashSet<Integer> values = frequencies.computeIfAbsent(frequency, k -> new LinkedHashSet<>());
        values.add(key);
    }
}
