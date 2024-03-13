package uvg.edu.gt;

import java.util.Scanner;

public class App {
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de Map que desea utilizar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Opción: ");
        int option = scanner.nextInt();
        
        MapFactory factory;
        
        switch(option) {
            case 1:
                factory = new HashMapFactory();
                break;
            case 2:
                factory = new TreeMapFactory();
                break;
            case 3:
                factory = new LinkedHashMapFactory();
                break;
            default:
                System.out.println("Opción no válida. Utilizando HashMap por defecto.");
                factory = new HashMapFactory();
        }

        CardManager manager = new CardManager(factory);
        
        try {
            manager.loadCards("cards_desc.txt"); // Carga las cartas disponibles
            scanner.nextLine(); // Asegúrate de consumir el salto de línea restante.
            
            while (true) {
                System.out.println("\nMenú de Opciones:");
                System.out.println("1. Agregar una carta a la colección del usuario.");
                System.out.println("2. Mostrar el tipo de una carta específica.");
                System.out.println("3. Mostrar la colección del usuario.");
                System.out.println("4. Mostrar la colección del usuario ordenada por tipo.");
                System.out.println("5. Mostrar todas las cartas existentes.");
                System.out.println("6. Mostrar todas las cartas existentes, ordenadas por tipo.");
                System.out.println("7. Salir.");
                System.out.print("Seleccione una opción: ");
                option = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después de leer un número
                
                switch (option) {
                    case 1:
                        System.out.print("Ingrese el nombre de la carta a agregar: ");
                        String cardToAdd = scanner.nextLine();
                        manager.addCardToUserCollection(cardToAdd);
                        break;
                    case 2:
                        System.out.print("Ingrese el nombre de la carta para mostrar su tipo: ");
                        String cardToShow = scanner.nextLine();
                        manager.showCardType(cardToShow);
                        break;
                    case 3:
                        manager.showUserCollection();
                        break;
                    case 4:
                        manager.showUserCollectionSortedByType();
                        break;
                    case 5:
                        manager.showAllAvailableCards();
                        break;
                    case 6:
                        manager.showAllAvailableCardsSortedByType();
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            }
        } catch (Exception e) {
            System.err.println("Se produjo un error: " + e.getMessage());
            e.printStackTrace();
        }        
    }
}
