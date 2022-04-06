package com.example.lab08;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataSource {
    public static ObservableList<StudentRecord> getAllMarks(String filepath) {
        ObservableList<StudentRecord> marks =
                FXCollections.observableArrayList();

        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                String studentID = values[0];
                float  assignments = Float.parseFloat(values[1]);
                float midterm = Float.parseFloat(values[2]);
                float final_exam = Float.parseFloat(values[3]);
//                System.out.println(studentID);
//                System.out.println(assignments);
//                for (int i = 0; i < values.length; i++) {
//                    System.out.println(values[i]);
//                }

                marks.add(new StudentRecord(studentID,assignments,midterm,final_exam));
            }
        }  catch (IOException e){
            e.printStackTrace();
        }

// Student ID, Assignments, Midterm, Final exam
//        for (int i = 0; i < 10; i++) {
//            marks.add(new StudentRecord("100100100"+i,i,i,i));
//        }
//        marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
//        marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
//        marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
//        marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
//        marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
//        marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
//        marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
//        marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
//        marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
//        marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));

        return marks;
    }

}
