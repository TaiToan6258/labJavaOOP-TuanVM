/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productsmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;


class Product {

    String ID;
    String Name, Location, Category;
    StoreKepper Storekeeper;
    int price;
    Date ExpiryDate, DateOfManufacture, ReceiptDate;

    public Product(String ID, String Name, String Location, String Category, StoreKepper Storekeeper, int price, Date ExpiryDate, Date DateOfManufacture, Date ReceiptDate) {
        this.ID = ID;
        this.Name = Name;
        this.Location = Location;
        this.Category = Category;
        this.Storekeeper = Storekeeper;
        this.price = price;
        this.ExpiryDate = ExpiryDate;
        this.DateOfManufacture = DateOfManufacture;
        this.ReceiptDate = ReceiptDate;
    }

    public StoreKepper getStorekeeper() {
        return Storekeeper;
    }

    public void setStorekeeper(StoreKepper Storekeeper) {
        this.Storekeeper = Storekeeper;
    }

    public Product() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public Date getDateOfManufacture() {
        return DateOfManufacture;
    }

    public void setDateOfManufacture(Date DateOfManufacture) {
        this.DateOfManufacture = DateOfManufacture;
    }

    public Date getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(Date ReceiptDate) {
        this.ReceiptDate = ReceiptDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-5s%-15s%-15s%-15s%-15s%-15d%-15s%-20s%-15s",
                ID, Name, Location, Category, getStorekeeper(), price,
                String.valueOf(date.format(ExpiryDate)),
                String.valueOf(date.format(DateOfManufacture)),
                String.valueOf(date.format(ReceiptDate)));

    }

}
