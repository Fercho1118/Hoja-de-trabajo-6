package uvg.edu.gt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CardManager {
    private Map<String, String> availableCards;
    private Map<String, Integer> userCollection;

    public CardManager(MapFactory factory) {
        this.availableCards = factory.createMap();
        this.userCollection = new HashMap<>();
    }

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

    public void addCardToUserCollection(String cardName) {
        if (availableCards.containsKey(cardName)) {
            userCollection.put(cardName, userCollection.getOrDefault(cardName, 0) + 1);
        } else {
            System.out.println("Error: La carta no existe entre las cartas disponibles.");
        }
    }

    public void showCardType(String cardName) {
        String cardType = availableCards.get(cardName);
        if (cardType != null) {
            System.out.println(cardName + ": " + cardType);
        } else {
            System.out.println("La carta no existe.");
        }
    }

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

    public void showAllAvailableCards() {
        for (Map.Entry<String, String> entry : availableCards.entrySet()) {
            System.out.println("Carta: " + entry.getKey() + " - Tipo: " + entry.getValue());
        }
    }

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