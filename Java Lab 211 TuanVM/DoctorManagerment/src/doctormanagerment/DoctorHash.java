/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanagerment;

import java.util.LinkedHashMap;


public class DoctorHash {

    public static final String fileName = "doctor.txt";

    static void addDoctor(Doctor infoOfDoctor) {
        LinkedHashMap<String, Doctor> doctorHashMap = ProcessFile.
                readDatabase(fileName);
        // for check database is exits or not ?
        if (doctorHashMap == null) {
            ProcessFile.getFile(fileName);
            return;
        }

        // for check data null or not
        if (infoOfDoctor != null) {
            // check duplicate doctor
            if (!doctorHashMap.containsKey(infoOfDoctor.getCode())) {
                doctorHashMap.put(infoOfDoctor.getCode(), infoOfDoctor);
                ProcessFile.writeToDatabase(doctorHashMap, fileName);
                System.out.println("Add Succesfully !!!");
            } else {
                System.out.println("Doctor code " + infoOfDoctor.getCode()
                        + " is duplicated");
            }
            display(doctorHashMap);
        } else {
            System.out.println("-----------------------");
            System.out.println("Data does not exist");
        }

    }

    private static void display(LinkedHashMap<String, Doctor> doctorLinkedHash) {
        System.out.println("---------------- Result ------------------");
        System.out.format("%-10s%-10s%-20s%-20s", "Code", "Name",
                "Specialization", "Availability");
        System.out.println();
        for (Doctor doctor : doctorLinkedHash.values()) {
            System.out.format("%-10s%-10s%-20s%-20s", doctor.getCode(),
                    doctor.getName(), doctor.getSpecialization(),
                    doctor.getAvalability());
            System.out.println();
        }

    }

    static Doctor findDoctor(String mgs) {
        LinkedHashMap<String, Doctor> doctorHashMap = ProcessFile.
                readDatabase(fileName);
        if (doctorHashMap.isEmpty()) {
            System.out.println("No Database");

        } else {
            display(doctorHashMap);
            String Code = GetData.getString("Enter Code for " + mgs + ":", false);
            if (doctorHashMap.containsKey(Code) == true) {
                return doctorHashMap.get(Code);
            }
        }
        return null;
    }

    static void updateDoctor(Doctor DoctorToUpdate) {
        LinkedHashMap<String, Doctor> doctorHashMap = ProcessFile.
                readDatabase(fileName);

        if (DoctorToUpdate == null) {
            System.out.println("Data doesn't exist");
            return;
        }
        // check code user enter early exits in data
        if (doctorHashMap.containsKey(DoctorToUpdate.getCode())) {
            System.out.println("---------------- Update Doctor ----------------");

            String Code = GetData.getString("Enter Code: ", false);
            // check new code is the same old code
            if (!Code.equalsIgnoreCase(DoctorToUpdate.getCode())) {
                String name = GetData.getString("Enter Name:", false);
                String specialization = GetData.getString("Enter Specialization:",
                        false);
                int availability = GetData.getInt("Enter Availability:");
                Doctor doctor = doctorHashMap.get(DoctorToUpdate.getCode());
                doctor.setCode(Code);
                doctor.setName(name);
                doctor.setSpecialization(specialization);
                doctor.setAvalability(availability);

                ProcessFile.writeToDatabase(doctorHashMap, fileName);
                System.out.println("Update Succesfully !!!");
            } else {
                System.out.println("Duplicate code !!!");
            }

        } else {
            System.out.println("Doctor code doesn’t exist !!!");
        }
        display(doctorHashMap);
    }

    static void deleteDoctor(Doctor DoctorToDelete) {
        LinkedHashMap<String, Doctor> doctorHashMap = ProcessFile.
                readDatabase(fileName);
        if (DoctorToDelete == null) {
            System.out.println("Data doesn't exist");
            return;
        }
        // check code user enter early exits in data
        if (doctorHashMap.containsKey(DoctorToDelete.getCode())) {
            doctorHashMap.remove(DoctorToDelete.getCode());
            ProcessFile.writeToDatabase(doctorHashMap, fileName);
            System.out.println("Delete Succesfully !!!");

        } else {
            System.out.println("Doctor code doesn’t exist !!!");
        }
        display(doctorHashMap);
    }

    static void searchDoctor(String searchDoctor) {
        LinkedHashMap<String, Doctor> doctorHashMap = ProcessFile.
                readDatabase(fileName);
        LinkedHashMap<String, Doctor> doctorHashMapFound = new LinkedHashMap<>();
        int flag = 0;
        if (doctorHashMap == null) {
            System.out.println("Database does not exist");
            return;
        }

        // iterate over each value contained in doctorHashMap      
        for (Doctor doctor : doctorHashMap.values()) {
            if (doctor.getCode().contains(searchDoctor) || doctor.getName().
                    contains(searchDoctor) || String.valueOf(doctor.getAvalability())
                    .contains(searchDoctor) || doctor.getSpecialization()
                    .contains(searchDoctor)) {
                doctorHashMapFound.put(doctor.getCode(), doctor);
                flag++;
            }
        }

        if (flag != 0) {
            display(doctorHashMapFound);
        } else {
            System.out.println("Can't Found Doctor !!!");
        }
    }

}
