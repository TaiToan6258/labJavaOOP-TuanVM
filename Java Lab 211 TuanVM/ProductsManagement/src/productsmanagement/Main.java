/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productsmanagement;

import java.util.ArrayList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        ArrayList<StoreKepper> listStoreKepper = new ArrayList<>();
        ArrayList<Product> listProduct = new ArrayList<>();
        while (true) {
            // Display Menu
            Display();
            int Choice = GetData.getChoice(1,6);
            switch (Choice) {
                case 1:
                    // Add Storekeeper 
                    Manage.addStorekeeper(listStoreKepper);
                    break;
                case 2:
                    // Add product
                    Manage.addProduct(listStoreKepper, listProduct);
                    break;
                case 3:
                    // Update product
                    Manage.updateProduct(listStoreKepper, listProduct);
                    break;
                case 4:
                    // Search product by Name,Category,Storekeeper,ReceiptDate
                    Manage.searchProduct(listStoreKepper, listProduct);
                    break;
                case 5:
                    // Sort product by Expiry date, Date of manufacture
                    Manage.sortProduct(listStoreKepper, listProduct);
                    break;
                case 6:
                    return;
            }
        }

    }

    private static void Display() {
        System.out.println("Main menu:");
        System.out.println("    1. Add Storekeeper");
        System.out.println("    2. Add product");
        System.out.println("    3. Update product");
        System.out.println("    4. Search product by Name, Category, "
                + "Storekeeper, ReceiptDate");
        System.out.println("    5. Sort product by Expiry date, "
                + "Date of manufacture");
        System.out.println("    6. Exit");
        System.out.print("Enter Your Choice :");
    }
}
