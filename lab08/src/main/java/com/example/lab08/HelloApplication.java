package com.example.lab08;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static final String currentFilename = "src/main/resources/weatherwarnings-2015.csv";

    @FXML
    public TableView<StudentRecord> tabView;

    @Override
    public void start(Stage stage) throws IOException {
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
        tabView.setItems(DataSource.getAllMarks(currentFilename));
        tabView.getColumns().addAll(StudentIDColumn, AssignmentsColumn, MidtermColumn, FinalExamColumn,
                FinalMarksColumn, LetterGradeColumn);
//

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        BorderPane root = new BorderPane();
        final Menu menu1 = new Menu("File");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1);

        GridPane gridPane = new GridPane();
        gridPane.getChildren().addAll(tabView);
        root.setTop(menuBar);
        root.setCenter(gridPane);
        Scene scene = new Scene(root, 600, 450);
//        Scene scene = new Scene(fxmlLoader.load(),800,450);

        stage.setTitle("Lab05");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}