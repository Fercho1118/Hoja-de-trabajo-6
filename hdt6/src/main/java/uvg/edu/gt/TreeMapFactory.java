package uvg.edu.gt;
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase TreeMapFactory
 * Felipe Aguilar - 23195
 * Fernando Rueda - 23748
 * Fábrica para crear un TreeMap.
 */
public class TreeMapFactory implements MapFactory{
    @Override
    public Map<String, String> createMap() {
        return new TreeMap<>();
    }   
}
