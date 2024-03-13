package uvg.edu.gt;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase HashMapFactory
 * Felipe Aguilar - 23195
 * Fernando Rueda - 23748
 * Fábrica para crear un HashMap.
 */
public class HashMapFactory implements MapFactory {
    @Override
    public Map<String, String> createMap() {
        return new HashMap<>();
    } 
}
