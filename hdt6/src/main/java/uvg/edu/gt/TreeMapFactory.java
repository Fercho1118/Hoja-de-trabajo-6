package uvg.edu.gt;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapFactory implements MapFactory{
    @Override
    public Map<String, String> createMap() {
        return new TreeMap<>();
    }   
}
