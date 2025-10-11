package demo;

import aims.cart.Cart;
import aims.disc.DigitalVideoDisc;
import aims.store.Store;
import java.util.Scanner;

public class Aims {
    public static Store initStore() {
        Store store = new Store();

        DigitalVideoDisc dv1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dv2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        DigitalVideoDisc dv3 = new DigitalVideoDisc("Demon Slayer: Infinity Castle", "Anime", "Ufotable", 130, 35.99f);
        DigitalVideoDisc dv4 = new DigitalVideoDisc("Haikyu!! The Dumpster Battle", "Anime / Sports", "Production I.G", 85, 22.50f);
        DigitalVideoDisc dv5 = new DigitalVideoDisc("Lisa Frankenstein", "Horror / Romantic / Comedy", "Zelda Williams", 101, 28.75f);
        DigitalVideoDisc dv6 = new DigitalVideoDisc("Roofman", "Romantic / Comedy", "Derek Cianfrance", 110, 27.00f);
        DigitalVideoDisc dv7 = new DigitalVideoDisc("Dan Da Dan: First Encounter", "Action / Horror / Anime", "Fuga Yamashiro", 75, 24.30f);
        DigitalVideoDisc dv8 = new DigitalVideoDisc("The Running Man", "Action / Thriller", "Edgar Wright", 115, 30.50f);
        DigitalVideoDisc dv9 = new DigitalVideoDisc("The Conjuring: Last Rites", "Horror", "Michael Chaves", 120, 32.95f);
        DigitalVideoDisc dv10 = new DigitalVideoDisc("Inside Out 2", "Animation / Comedy", "Disney / Pixar", 95, 25.40f);


        store.addDVD(dv1);
        store.addDVD(dv2);
        store.addDVD(dv3);
        store.addDVD(dv4);
        store.addDVD(dv5);
        store.addDVD(dv6);
        store.addDVD(dv7);
        store.addDVD(dv8);
        store.addDVD(dv9);
        store.addDVD(dv10);

        return store;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void printMenu() {
        System.out.println("#------------------Menu------------------#");
        System.out.println("1. Add a disc to cart");
        System.out.println("2. Remove a disc from cart");
        System.out.println("3. Number of discs in the cart");
        System.out.println("4. Total cost");
        System.out.println("5. Show all discs in cart");
        System.out.println("6. Show available DVDs in store");
        System.out.println("7. Exit");
        System.out.println("#----------------------------------------#");
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Store store = initStore();
        Cart cart1 = new Cart();

        System.out.println("#-----AIMS - An Internet Movie Store-----#");
        System.out.println("Available DVDs:");
        store.getInfo();
        System.out.println("#----------------------------------------#");
        printMenu();

        while (true) {
            System.out.print("\nPlease enter your choice (1 - 7): ");
            String input = s.nextLine();

            if (!isInteger(input)) {
                System.out.println("Invalid input! Please enter an integer number (1 - 7)");
                continue;
            }

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1: 
                    System.out.print("Enter disc ID or title to add: ");
                    String ansAdd = s.nextLine();
                    if (isInteger(ansAdd)) {
                        int id = Integer.parseInt(ansAdd);
                        if (id <= 0 || id > store.getNumberDVDs()) {
                            System.out.println("Invalid disc ID");
                            break;
                        }
                        cart1.addDigitalVideoDisc(store.items.get(id - 1));
                    } else {
                        DigitalVideoDisc found = store.findDVD(ansAdd);
                        if (found != null) {
                            cart1.addDigitalVideoDisc(found);
                        } else {
                            System.out.println("Disc not found");
                        }
                    }
                    break;

                case 2: 
                    System.out.print("Enter disc ID or title to remove: ");
                    String ansRem = s.nextLine();
                    if (isInteger(ansRem)) {
                        int id = Integer.parseInt(ansRem);
                        if (id <= 0 || id > store.getNumberDVDs()) {
                            System.out.println("Invalid disc ID");
                            break;
                        }
                        cart1.removeDigitalVideoDisc(store.items.get(id - 1));
                    } else {
                        DigitalVideoDisc foundRem = store.findDVD(ansRem);
                        if (foundRem != null) {
                            cart1.removeDigitalVideoDisc(foundRem);
                        } else {
                            System.out.println("Disc not found");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Number of discs in the cart: " + Cart.getNumofOrders());
                    break;

                case 4:
                    System.out.printf("Total cost: $%.2f%n", cart1.totalCost());
                    break;

                case 5:
                    System.out.println("Your order:");
                    cart1.printAllOrders();
                    break;

                case 6:
                    System.out.println("Available DVDs in store:");
                    store.getInfo();
                    break;

                case 7:
                    System.out.println("Thanks for using our AIMS system");
                    s.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose (1 - 7)");
                    break;
            }

            printMenu();
        }
    }
}
