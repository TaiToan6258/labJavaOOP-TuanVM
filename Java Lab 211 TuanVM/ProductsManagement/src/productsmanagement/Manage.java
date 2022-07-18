/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productsmanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


class Manage {

    static void addStorekeeper(ArrayList<StoreKepper> listStoreKepper) {
        int ID = GetData.getInt("StoreKeeper ID: ");
        // check duplicate store keeper
        if (checkStoreKeeperExits(ID, listStoreKepper) == true) {
            System.out.println("Duplicate !!!");
        } else {
            String storeKepperName = GetData.getString("StoreKeeper Name: ");
            listStoreKepper.add(new StoreKepper(ID, storeKepperName));
        }
        displayStoreKepper(listStoreKepper);
    }

    static void addProduct(ArrayList<StoreKepper> listStoreKepper,
            ArrayList<Product> listProduct) {
        if (listStoreKepper.isEmpty()) {
            System.out.println("No StoreKepper !!!");
            return;
        }
        System.out.println("------------- ADD PRODUCT -------------");
        String id = GetData.getString("ID: ");
        // check duplicate ID
        if (checkIDExits(listProduct, id) == true) {
            System.out.println("Duplicate !!!");
            return;
        }
        String name = GetData.getString("Name: ");
        String location = GetData.getString("Location: ");
        String category = GetData.getString("Category: ");
        // show list of store kepper for user select
        displayStoreKepper(listStoreKepper);

        // loop until user selects correct store kepper
        StoreKepper store = null;
        while (true) {
            int ID = GetData.getInt("ID :");
            // Check if storekepper exists ?
            if (checkStoreKeeperExits(ID, listStoreKepper) == true) {
                /* loop to traverse each object Product from fist obj to 
        last obj of listProduct */
                for (StoreKepper storeKepper : listStoreKepper) {
                    // Find Store Keepper User select in listStorekepper
                    if (storeKepper.getStorekeeperID() == ID) {
                        store = new StoreKepper(ID, storeKepper.getStorekeeperName());
                    }
                }
                break;
            } else {
                System.out.println("No StoreKepper !!!");
            }

        }

        int price = GetData.getInt("Price: ");
        Date dateOfManufacture = null;
        Date expiryDate = GetData.getDate("ExpiryDate: ", dateOfManufacture);
        dateOfManufacture = GetData.getDate("ManufactureDate: ", expiryDate);
        Date receiptDate = GetData.getDate("ReceiptDate: ", dateOfManufacture);

        listProduct.add(new Product(id, name, location, category, store,
                price, expiryDate, dateOfManufacture, receiptDate));
        System.out.println("-----------------------");
        System.out.println("Add Succesfully !!!");
        displayProduct(listProduct);

    }

    static void updateProduct(ArrayList<StoreKepper> listStoreKepper,
            ArrayList<Product> listProduct) {
        if (listProduct.isEmpty() == true) {
            System.out.println("No Data !!!");
            return;
        }
        System.out.println("------------- UPDATE PRODUCT -------------");
        String id = GetData.getString("Enter ID For Update: ");
        // check id for update already exists
        if (checkIDExits(listProduct, id) == false) {
            System.out.println("ID not exits !!!");
            return;
        }
        String newID = GetData.getString("New ID: ");
        // check duplicate newID vs oldID
        if (checkIDExits(listProduct, newID) == false) {
            String name = GetData.getString("Name: ");
            String location = GetData.getString("Location: ");
            String category = GetData.getString("Category: ");
            int storeID = 0;
            // loop until user selects correct store kepper
            while (true) {
                storeID = GetData.getInt("Enter new id Store:");
                //check duplicate storekepper
                if (checkStoreKeeperExits(storeID, listStoreKepper) == false) {
                    break;
                } else {
                    System.out.println("Duplicate StoreKepper !!!");
                }

            }
            String storeName = GetData.getString("Enter new name Store:");
            listStoreKepper.add(new StoreKepper(storeID, storeName));
            int price = GetData.getInt("Price: ");
            Date dateOfManufacture = null;
            Date expiryDate = GetData.getDate("ExpiryDate: ", dateOfManufacture);
            dateOfManufacture = GetData.getDate("ManufactureDate: ", expiryDate);
            Date receiptDate = GetData.getDate("ReceiptDate: ", dateOfManufacture);
            /* loop to traverse each object Product from fist obj to 
        last obj of listProduct */
            for (Product product : listProduct) {
                // found the record to update
                if (product.getID().equals(id)) {
                    product.setID(newID);
                    product.setName(name);
                    product.setLocation(location);
                    product.setCategory(category);
                    product.getStorekeeper().setStorekeeperID(storeID);
                    product.getStorekeeper().setStorekeeperName(storeName);
                    product.setPrice(price);
                    product.setExpiryDate(expiryDate);
                    product.setDateOfManufacture(dateOfManufacture);
                    product.setReceiptDate(receiptDate);
                }
            }
            // display list after update
            displayProduct(listProduct);
        } else {
            System.out.println("New ID already exists !!!");
        }

    }

    static void searchProduct(ArrayList<StoreKepper> listStoreKepper,
            ArrayList<Product> listProduct) {
        if (listProduct.isEmpty() == true) {
            System.out.println("No Data !!!");
            return;
        }
        int flag = 0;
        ArrayList<Product> productFound = new ArrayList<>();
        System.out.println("-----------Search Product---------");
        System.out.println("Search Product By:");
        System.out.println("1. Name");
        System.out.println("2. Category");
        System.out.println("3. Storekeeper");
        System.out.println("4. ReceiptDate");
        System.out.println("Enter your choice: ");
        int choice = GetData.getChoice(1, 4);
        String value = GetData.getString("Enter the value to be searched: ");

        /* loop to traverse each object Product from fist obj to 
        last obj of listProduct */
        for (int i = 0; i < listProduct.size(); i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String ReceiptDate = sdf.format(listProduct.get(i).getReceiptDate());
            // Match the user's selection with the corresponding search field
            if (choice == 1 && listProduct.get(i).getName().contains(value)
                    || choice == 2 && listProduct.get(i).
                            getCategory().contains(value)
                    || choice == 3 && listProduct.get(i).
                            getStorekeeper().getStorekeeperName().contains(value)
                    || choice == 4 && ReceiptDate.equalsIgnoreCase(value)) {
                flag++;
                productFound.add(listProduct.get(i));
            }
        }
        // for found case
        if (flag != 0) {
            displayProduct(productFound);
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("Not found !!!");

        }
    }

    static void sortProduct(ArrayList listStoreKepper,
            ArrayList<Product> listProduct) {
        if (listProduct.isEmpty() == true) {
            System.out.println("No Data !!!");
            return;
        }
        System.out.println("Befor Sort ");
        System.out.println("------------------------------------");
        displayProduct(listProduct);
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product t, Product t1) {
                // sort by DateOfManufacture if ExporyDate is same
                if (t.getExpiryDate().compareTo(t1.getExpiryDate()) == 0) {
                    return t.getDateOfManufacture().
                            compareTo(t1.getDateOfManufacture());
                    // sort by ExporyDate
                }
                return t.getExpiryDate().compareTo(t1.getExpiryDate());

            }

        });
        System.out.println("After Sort ");
        System.out.println("------------------------------------");
        displayProduct(listProduct);
    }

    private static boolean checkStoreKeeperExits(int storeKepperID,
            ArrayList<StoreKepper> list) {
        /* loop to traverse each object Employee from fist obj to 
        last obj of listEmployee */
        for (StoreKepper store : list) {
            if (store.StorekeeperID == storeKepperID) {
                return true;
            }
        }
        return false;
    }

    private static void displayStoreKepper(ArrayList<StoreKepper> listStoreKepper) {
        System.out.println("---------------------------");
        System.out.println("List of StoreKeeper");
        for (int i = 0; i < listStoreKepper.size(); i++) {
            System.out.println(listStoreKepper.get(i).getStorekeeperID()
                    + ". " + listStoreKepper.get(i).getStorekeeperName());
        }

    }

    private static boolean checkIDExits(ArrayList<Product> listProduct,
            String id) {
        /* loop to traverse each object Employee from fist obj to 
        last obj of listEmployee */
        for (int i = 0; i < listProduct.size(); i++) {
            // check duplicate ID
            if (listProduct.get(i).getID().toLowerCase().
                    equalsIgnoreCase(id.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void displayProduct(ArrayList<Product> listProduct) {
        if (listProduct.isEmpty()) {
            //System.out.println("List is empty");
            return;
        }
        System.out.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s%-20s%-15s\n",
                "ID", "Name", "Location", "Category", "Storekeeper", "Price",
                "ExpiryDate", "DateOfManufacture", "ReceiptDate");
        //run from first element to the end
        for (int i = 0; i < listProduct.size(); i++) {
            System.out.println(listProduct.get(i).toString());
        }
    }

}
