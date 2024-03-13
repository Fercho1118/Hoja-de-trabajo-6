package uvg.edu.gt;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase LinkedHashMapFactory
 * Felipe Aguilar - 23195
 * Fernando Rueda - 23748
 * Fábrica para crear un LinkedHashMap.
 */
public class LinkedHashMapFactory implements MapFactory{
    @Override
    public Map<String, String> createMap() {
        return new LinkedHashMap<>();
    }   
}
