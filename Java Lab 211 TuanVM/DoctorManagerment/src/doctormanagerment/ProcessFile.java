/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanagerment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

public class ProcessFile {

    static LinkedHashMap<String, Doctor> readDatabase(String fileName) {
        LinkedHashMap<String, Doctor> doctorHash = new LinkedHashMap<>();
        BufferedReader reader = null;
        try {
            FileReader file = new FileReader(fileName);
            reader = new BufferedReader(file);
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] tokens = line.split(",");
                    String code = tokens[0].trim();
                    String name = tokens[1].trim();
                    String specialization = tokens[2].trim();
                    int availability = Integer.parseInt(tokens[3].trim());
                    doctorHash.put(code, new Doctor(code, name,
                            specialization, availability));
                }
            }
        } catch (IOException ex) {
            doctorHash = null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        }
        return doctorHash;
    }

    static void getFile(String fileName) {
        try {
            File file = new File(fileName);
            file.createNewFile();
            System.out.println("Created File Sucessfully !!!");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    static void writeToDatabase(LinkedHashMap<String, Doctor> doctorLinkedHash,
            String fileName) {
        BufferedWriter line = null;
        try {
            line = new BufferedWriter(new FileWriter(fileName));
            for (Doctor doctor : doctorLinkedHash.values()) {
                line.write(doctor.getCode() + "," + doctor.getName() + ","
                        + doctor.getSpecialization() + ","
                        + doctor.getAvalability());
                line.newLine();
            }
            line.flush();
        } catch (IOException ex) {
           
        }
    }

}
