package data;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 24/02/2024
 */
public class Pair <Key, Value> {
    private final Key key;
    private final Value value;

    public Pair (Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }
}
