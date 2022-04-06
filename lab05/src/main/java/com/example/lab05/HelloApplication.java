package com.example.lab05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    TableView<StudentRecord> tabView;

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        int columnWidth = 200;

        TableColumn<StudentRecord, String> StudentIDColumn = new TableColumn<>("Student ID");
        StudentIDColumn.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        StudentIDColumn.setMinWidth(columnWidth);

        TableColumn<StudentRecord, String> AssignmentsColumn = new TableColumn<>("Assignments");
        AssignmentsColumn.setCellValueFactory(new PropertyValueFactory<>("Assignments"));
        StudentIDColumn.setMinWidth(columnWidth);

        TableColumn<StudentRecord, String> MidtermColumn = new TableColumn<>("Midterm");
        MidtermColumn.setCellValueFactory(new PropertyValueFactory<>("Midterm"));
        StudentIDColumn.setMinWidth(columnWidth);

        TableColumn<StudentRecord, String> FinalExamColumn = new TableColumn<>("Final Exam");
        FinalExamColumn.setCellValueFactory(new PropertyValueFactory<>("Final_exam"));
        StudentIDColumn.setMinWidth(columnWidth);

        TableColumn<StudentRecord, String> FinalMarksColumn = new TableColumn<>("Final Mark");
        FinalMarksColumn.setCellValueFactory(new PropertyValueFactory<>("Final_mark"));
        StudentIDColumn.setMinWidth(columnWidth);

        TableColumn<StudentRecord, String> LetterGradeColumn = new TableColumn<>("Letter Grade");
        LetterGradeColumn.setCellValueFactory(new PropertyValueFactory<>("Letter_grade"));
        StudentIDColumn.setMinWidth(columnWidth);

        tabView = new TableView<>();
        tabView.setItems(DataSource.getAllMarks());
        tabView.getColumns().addAll(StudentIDColumn, AssignmentsColumn, MidtermColumn, FinalExamColumn,
                FinalMarksColumn, LetterGradeColumn);
//
        GridPane gridPane = new GridPane();
        gridPane.getChildren().addAll(tabView);
        Scene scene = new Scene(gridPane);
        stage.setTitle("Lab05");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}

