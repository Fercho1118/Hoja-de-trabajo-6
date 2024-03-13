package uvg.edu.gt;
import java.util.HashMap;
import java.util.Map;
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
        userCollection.forEach((card, count) -> System.out.println("Carta: " + card + " - Tipo: " + availableCards.get(card) + " - Cantidad: " + count));
    }

    public void showUserCollectionSortedByType() {
        userCollection.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(availableCards::get)))
                .forEach(entry -> System.out.println("Carta: " + entry.getKey() + " - Tipo: " + availableCards.get(entry.getKey()) + " - Cantidad: " + entry.getValue()));
    }

    public void showAllAvailableCards() {
        availableCards.forEach((name, type) -> System.out.println("Carta: " + name + " - Tipo: " + type));
    }

    public void showAllAvailableCardsSortedByType() {
        availableCards.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println("Carta: " + entry.getKey() + " - Tipo: " + entry.getValue()));
    }
}