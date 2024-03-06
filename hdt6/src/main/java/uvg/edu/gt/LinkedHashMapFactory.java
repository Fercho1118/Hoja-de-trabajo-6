package uvg.edu.gt;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapFactory implements MapFactory{
    @Override
    public Map<String, String> createMap() {
        return new LinkedHashMap<>();
    }   
}
