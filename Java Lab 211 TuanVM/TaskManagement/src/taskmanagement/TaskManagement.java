/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement;

import java.util.ArrayList;

public class TaskManagement {

    public static void main(String[] args) {
        ArrayList<Task> listTask = new ArrayList<>();
        int choice;
        int id = 1;
        while (true) {
            //Display menu for user to choose
            displayMenu();
            choice = GetData.getChoice();
            switch (choice) {
                case 1:
                    // Add task                          
                    id = addTask(id, listTask);
                    break;
                case 2:
                    // Delete task
                    deleteTask(String.valueOf(id), listTask);
                    break;
                case 3:
                    // Get Data Tasks
                    getDataTasks(listTask);
                    break;
                case 4:
                    return;
            }
        }

    }

    private static void displayMenu() {
        System.out.println("========= Task program =========");
        System.out.println("•  Add Task");
        System.out.println("•  Delete Task");
        System.out.println("•  Display Task");
        System.out.println("•  exit");
    }

    private static int addTask(int id, ArrayList<Task> listTask) {

        System.out.println("-------------Add Task-----------------");
        System.out.print("Requiremanet Name: ");
        String requirementName = GetData.getString();

        System.out.print("Task Type: ");
        String taskTypeID = GetData.getTaskType();

        System.out.print("Date: ");
        String date = GetData.getDate();

        System.out.print("From: ");
        String planFrom = GetData.getPlan();

        System.out.print("To: ");
        String planTo = GetData.getPlan();
        // Repeat until the working time is reasonable
        while (true) {
            //  Check time end > time start ?
            if (checkWorkingTime(planFrom, planTo) == false) {
                planTo = GetData.getPlan();
            } else {
                break; // working time > 0, end while loop
            }
        }

        System.out.print("Assignee: ");
        String assignee = GetData.getString();

        System.out.print("Reviewer: ");
        String reviewer = GetData.getString();

        // Check duplicate the input data, if not add to listTask
        if (checkDuplicate(listTask, date, planFrom,
                planTo, assignee) == true) {
            return id;
        } else {
            listTask.add(new Task(id, requirementName, taskTypeID, date,
                    planFrom, planTo, assignee, reviewer));
            id++;
            System.out.println("----------------------");
            System.out.println("Add Successfully !!!");
        }

        return id;
    }

    private static boolean checkWorkingTime(String planFrom, String planTo) {
        if (Double.parseDouble(planTo) <= Double.parseDouble(planFrom)) {
            System.out.println("Working time must be > 0 !!!");
            System.out.print("Re-input :");
            return false;
        }
        return true;
    }

    private static boolean checkDuplicate(ArrayList<Task> listTask, String date,
            String planFrom, String planTo, String assignee) {
        /* loop to traverse each object Task from fist obj to 
        last obj of listTask */
        for (Task task : listTask) {
            if (task.getDate().equalsIgnoreCase(date)
                    && task.getPlanFrom().equalsIgnoreCase(planFrom)
                    && task.getPlanTo().equalsIgnoreCase(planTo)
                    && task.getAsignee().equalsIgnoreCase(assignee)) {
                System.out.println("----------------------");
                System.out.println("Duplicate !!!");
                return true;
            }
        }
        return false;
    }

    private static void deleteTask(String id, ArrayList<Task> listTask) {
        if (listTask.isEmpty()) {
            System.out.println("No Data !!!");
            return;
        }

        boolean flag = false;
        System.out.print("ID :");
        id = GetData.getString();
        // traverse objects from the beginning to the end in listTask
        for (int i = 0; i < listTask.size(); i++) {
            /* compare user-entered IDs and existing IDs 
            and delete records if they match */
            if (listTask.get(i).getId() == Integer.parseInt(id)) {
                listTask.remove(i);
                flag = true;
            }
        }
        // this case for deleted ID
        if (flag == true) {
            System.out.println("-------------------------");
            System.out.println("Delete Successfully !!!");
        } else {
            System.out.println("-----------------------------------");
            System.out.println("The ID to be deleted was not found");
        }
    }

    private static void getDataTasks(ArrayList<Task> listTask) {
        if (listTask.isEmpty()) {
            System.out.println("No Data !!!");
        } else {
            System.out.println("--------------------------------Task-----------"
                    + "------------------------------");
            System.out.printf("%-5s%-13s%-15s%-15s%-8s%-10s%-10s\n",
                    "ID", "Name", "Task Type", "Date", "Time", "Assignee",
                    "Reviewer");
            /* loop to traverse each object Task from fist obj to 
             last obj of listTask */
            for (Task task : listTask) {
                task.display();
            }
        }
    }

}
