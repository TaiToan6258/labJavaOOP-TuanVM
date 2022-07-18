/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Employee {

    public String ID, firstName, lastName, Phone,
            Email, Address, Sex, Agency;
    public int Salary;
    public Date Dob;

    public Employee() {
    }

    public Employee(String ID, String firstName, String lastName, String Phone, 
            String Email, String Address, String Sex, String Agency, int Salary,
            Date Dob) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Sex = Sex;
        this.Agency = Agency;
        this.Salary = Salary;
        this.Dob = Dob;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getAgency() {
        return Agency;
    }

    public void setAgency(String Agency) {
        this.Agency = Agency;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }

     @Override
    public String toString() {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-8s%-16s%-16s%-15s%-25s%-25s%-8s%-25s%-16d%-16s",
                    ID,firstName,lastName,Phone,Email,Address,Sex,Agency,Salary,
                    String.valueOf(date.format(Dob)));
    }

}
