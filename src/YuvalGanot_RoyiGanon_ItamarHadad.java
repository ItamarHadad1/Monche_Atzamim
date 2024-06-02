// Yuval Ganot, ID: 209531425
// Royi Ganon, ID: 211697701
// Itamar Hadad, ID: 211825666

// Teacher: Keren Kalif

import java.util.Objects;
import java.util.Scanner;

public class YuvalGanot_RoyiGanon_ItamarHadad {
    private static String[] sellersList = new String[0];
    private static String[] buyersList = new String[0];
    static Scanner s = new Scanner(System.in);
    private static int counterBuyers = 0;
    private static int counterSellers = 0;

    //Checking if the name exist in the list
    public static boolean isNameExistInList(String[] lst, int counter, String name) {
        for (int i = 0; i < counter; i++) {
            if (Objects.equals(lst[i], name)) {
                System.out.println("This user already exists!, try a different one");
                return true;
            }
        }
        return false;
    }

    // Checking if there is available space to put the new name
    public static boolean isAvailableSpace(String[] list, int counter){
        return list.length != counter && list.length != 0;
    }

    //Add the name to the list
    public static void addName (String[] list, int counter, String name){
        list[counter] = name;
        System.out.println("You have successfully added " + name + " to the list!");
    }

    //Extending the space in the list
    public static String[] duplicateArr(String[] list) {
        String[] new_list = new String[list.length == 0 ? 1 : list.length * 2];
        for (int i = 0; i < list.length ; i++) {
            new_list[i] = list[i];
        }
        return new_list;
    }

    //Print organized list by numbers
    public static void printList(String[] list, int counter) {
        for (int i = 0; i < counter; i++) {
            System.out.println((i + 1) + ") " + list[i]);
        }
    }

    // Adding seller to the sellers list
    public static void addSeller() {
        boolean resIfExistSeller;
        String sellerName;
        do {
            System.out.println("Please enter your user name: ");
            sellerName = s.next();
            resIfExistSeller = isNameExistInList(sellersList, counterSellers, sellerName);
        } while (resIfExistSeller);

        if (!isAvailableSpace(sellersList, counterSellers)) {
            sellersList = duplicateArr(sellersList);
        }
        addName(sellersList, counterSellers, sellerName);
        counterSellers++;
    }

    // Adding buyer to the buyers list
    public static void addBuyer() {
        boolean resIfexistBuyer;
        String buyerName;
        do {
            System.out.println("Please enter your user name: ");
            buyerName = s.next();
            resIfexistBuyer = isNameExistInList(buyersList, counterBuyers, buyerName);
        } while (resIfexistBuyer);

        if (!isAvailableSpace(buyersList, counterBuyers)) {
            buyersList = duplicateArr(buyersList);
        }
        addName(buyersList, counterBuyers, buyerName);
        counterBuyers++;
    }

    // Add product to the seller
    public static void addProductSeller(){
        if (sellersList.length == 0) {
            System.out.println("No sellers available. Please add a seller first.");
            }
        else {
            System.out.println("Choose a seller from this list to add the product to him: ");
            printList(sellersList, counterSellers);

            System.out.println("\nEnter your choice: ");
            int chooseSeller = s.nextInt();
            s.nextLine();

            System.out.println("\nEnter the product name: ");
            String productName = s.nextLine();

            System.out.println("\nEnter the product price (in dollars without $): ");
            double price = s.nextDouble();
            s.nextLine();

            System.out.println("\nEnter the product category: ");
            String category = s.nextLine();

            System.out.println("Product added to seller: " + sellersList[chooseSeller - 1] + ", The product: " +
                    productName + ", Price: " + price +  "$, Category: " + category);

        }

    }

    //Add Product to the buyer
    public static void addProductBuyer(){
        if (sellersList.length == 0 ) {
            System.out.println("No sellers available. Please add a seller first.");
        } else if (buyersList.length == 0 ) {
            System.out.println("No buyers available. Please add a seller first.");
        } else {
            System.out.println("Choose a buyer from this list to add the product to him: ");
            printList(buyersList, counterBuyers);
            System.out.println("\nEnter your choice: ");
            int chooseBuyer = s.nextInt();

            System.out.println("Choose a seller from this list to add the product to him: ");
            printList(sellersList, counterSellers);
            System.out.println("\nEnter your choice: ");
            int chooseSeller = s.nextInt();
            System.out.println("You added a product to buyer: " + buyersList[chooseBuyer - 1] +
                    " ,from the seller: " + sellersList[chooseSeller - 1]);

        }
    }

    // Pay the cart
    public static void payCart(){
        if (buyersList.length == 0) {
            System.out.println("No buyers available. Please add a seller first.");
        } else {
            System.out.println("Choose a buyer from this list to pay cart: ");
            printList(buyersList, counterBuyers);
            System.out.println("\nEnter your choice: ");
            int chooseBuyer = s.nextInt();
            System.out.println("You chose successfully to pay - " + buyersList[chooseBuyer - 1] + "'s cart");
        }
        
    }

    public static void listOfBuyers(){
        System.out.println("The list of buyers is: ");
        printList(buyersList, counterBuyers);

    }

    public static void listOfSellers(){
        System.out.println("The list of sellers is: ");
        printList(sellersList, counterSellers);

    }

    public static void menu() {

        int choice;
        boolean notQuit = true;

        do {
            System.out.println("\nWelcome to IYR \uD83C\uDFB6\uD83D\uDCC0\uD83C\uDFB5\uD83D\uDCBF (International Y Records by Itamar, Yuval and Royi).");
            System.out.println("Thank you for choosing us, we will take care that you will get whatever record you want.");
            System.out.println("We hope that you will enjoy our website");
            System.out.println();
            System.out.println("Please choose one of the following options:");
            System.out.println("0) Exit");
            System.out.println("1) Add a seller");
            System.out.println("2) Add a buyer");
            System.out.println("3) Add a product for the seller");
            System.out.println("4) Add a product for the buyer");
            System.out.println("5) Pay for your products in your cart (Yay!)");
            System.out.println("6) Show the list of buyers");
            System.out.println("7) Show the list of sellers");

            System.out.println("So which option do you want?");
            choice = s.nextInt();

            switch (choice) {
                case 0:
                    notQuit = false;
                    break;

                case 1:
                    addSeller();
                    break;

                case 2:
                    addBuyer();
                    break;

                case 3:
                    addProductSeller();
                    break;

                case 4:
                    addProductBuyer();
                    break;

                case 5:
                    payCart();
                    break;

                case 6:
                    listOfBuyers();
                    break;

                case 7:
                    listOfSellers();
                    break;

                default:
                    System.out.println("That is not a valid option");

            }




        } while (notQuit); {
            System.out.println("\nThank you for visiting our website!");
            System.out.println("We hope that we will see you again");
        }

    }

    public static void main(String[] args) {
        menu();
    }
}
