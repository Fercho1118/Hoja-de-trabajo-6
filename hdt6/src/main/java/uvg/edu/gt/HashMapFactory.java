package uvg.edu.gt;
import java.util.HashMap;
import java.util.Map;

public class HashMapFactory implements MapFactory {
    @Override
    public Map<String, String> createMap() {
        return new HashMap<>();
    } 
}
