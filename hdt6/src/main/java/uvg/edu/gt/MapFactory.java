package uvg.edu.gt;
import java.util.Map;
/**
 * Interfaz MapFactory
 * Felipe Aguilar - 23195
 * Fernando Rueda - 23748
 * Interfaz para las fábricas de Mapas. Define el método para crear un nuevo Mapa.
 */
public interface MapFactory {
    /**
     * Crea un nuevo Mapa para almacenar cartas.
     * @return Mapa de cartas.
     */
    Map<String, String> createMap();
}
