/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanagerment;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = GetData.getChoice(1,5);
            switch(choice){
                case 1:
                    //Get Doctor information
                    Doctor infoOfDoctor = GetData.getDoctorInformation();
                    // Add Doctor
                    DoctorHash.addDoctor(infoOfDoctor);
                    break;
                case 2:
                    // find doctor in database to update
                    Doctor DoctorToUpdate = DoctorHash.findDoctor("update");
                    // Update Doctor
                    DoctorHash.updateDoctor(DoctorToUpdate);
                    break;
                case 3:
                    // find doctor in database to update
                    Doctor DoctorToDelete = DoctorHash.findDoctor("delete");
                    //Delete Doctor
                    DoctorHash.deleteDoctor(DoctorToDelete);
                    break;
                case 4:
                    //get text to search doctor
                    String searchDoctor = GetData.getString("Enter text:", false);
                    //Search Doctor
                    DoctorHash.searchDoctor(searchDoctor);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("========= Doctor Management ==========");
        System.out.println("•  Add Doctor");
        System.out.println("•  Update Doctor");
        System.out.println("•  Delete Doctor");
        System.out.println("•  Search Doctor");
        System.out.println("•  Exit");
        System.out.println("Enter your choice: ");       
    }



    
}
