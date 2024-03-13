package uvg.edu.gt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Clase CardManager
 * Felipe Aguilar - 23195
 * Fernando Rueda - 23748
 * Gestiona la colección de cartas disponibles y la colección de cartas del usuario.
 */
public class CardManager {
    private Map<String, String> availableCards;
    private Map<String, Integer> userCollection;

    /**
     * Constructor que inicializa las colecciones utilizando una fábrica de Mapas.
     * @param factory La fábrica para crear el Mapa de cartas disponibles.
     */    
    public CardManager(MapFactory factory) {
        this.availableCards = factory.createMap();
        this.userCollection = new HashMap<>();
    }

    /**
     * Carga las cartas desde un archivo de texto.
     * @param filename Nombre del archivo que contiene las descripciones de las cartas.
     * @throws IOException Si ocurre un error al leer el archivo.
     */    
    public void loadCards(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    availableCards.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
    }

    /**
     * Agrega una carta a la colección del usuario.
     * @param cardName Nombre de la carta a agregar.
     */    
    public void addCardToUserCollection(String cardName) {
        if (availableCards.containsKey(cardName)) {
            userCollection.put(cardName, userCollection.getOrDefault(cardName, 0) + 1);
        } else {
            System.out.println("Error: La carta no existe entre las cartas disponibles.");
        }
    }

    /**
     * Muestra el tipo de una carta específica.
     * @param cardName Nombre de la carta cuyo tipo se desea mostrar.
     */    
    public void showCardType(String cardName) {
        String cardType = availableCards.get(cardName);
        if (cardType != null) {
            System.out.println(cardName + ": " + cardType);
        } else {
            System.out.println("La carta no existe.");
        }
    }

    /**
     * Muestra la colección de cartas del usuario.
     */    
    public void showUserCollection() {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(userCollection.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                String type1 = availableCards.get(o1.getKey());
                String type2 = availableCards.get(o2.getKey());
                return type1.compareTo(type2);
            }
        });
        
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println("Carta: " + entry.getKey() + " - Tipo: " + availableCards.get(entry.getKey()) + " - Cantidad: " + entry.getValue());
        }
    }

    /**
     * Muestra la colección de cartas del usuario ordenada por tipo.
     */    
    public void showUserCollectionSortedByType() {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(userCollection.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                String type1 = availableCards.get(o1.getKey());
                String type2 = availableCards.get(o2.getKey());
                return type1.compareTo(type2);
            }
        });
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println("Carta: " + entry.getKey() + " - Tipo: " + availableCards.get(entry.getKey()) + " - Cantidad: " + entry.getValue());
        }
    }

    /**
     * Muestra todas las cartas disponibles.
     */
    public void showAllAvailableCards() {
        for (Map.Entry<String, String> entry : availableCards.entrySet()) {
            System.out.println("Carta: " + entry.getKey() + " - Tipo: " + entry.getValue());
        }
    }

    /**
     * Muestra todas las cartas disponibles ordenadas por tipo.
     */    
    public void showAllAvailableCardsSortedByType() {
        List<Map.Entry<String, String>> list = new LinkedList<>(availableCards.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, String> entry : list) {
            System.out.println("Carta: " + entry.getKey() + " - Tipo: " + entry.getValue());
        }
    }
}