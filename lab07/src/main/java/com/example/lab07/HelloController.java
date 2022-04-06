package com.example.lab07;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HelloController {

    private static final String FILENAME = "src/main/resources/weatherwarnings-2015.csv";

    private static Color[] pieColours = {
            Color.DARKORANGE, Color.DARKSALMON,
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    @FXML
    public Canvas canvas;

    @FXML
    private void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
//        Map<String, Integer> warningsMap = loadCSV(FILENAME, 5);
        drawPieChart(loadCSV(FILENAME,5), gc);
        drawLegend(loadCSV(FILENAME,5),gc);
    }

//    private void countWarning(Map<String, Integer> warningCounts, String warning){
//
//    }

    private Map<String, Integer> loadCSV(String filepath, int columnIndex) {
        String line = "";
        Map<String, Integer> warningCounts = new HashMap<String, Integer>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                String warnings = values[columnIndex];
                if (warningCounts.containsKey(warnings)){
                    warningCounts.replace(warnings, warningCounts.get(warnings)+1);
                }else{
                    warningCounts.put(warnings, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String i: warningCounts.keySet()) {
            System.out.println(i + ": " + warningCounts.get(i));
        }
        return warningCounts;
    }

    private void drawPieChart(Map<String, Integer> warningCounts, GraphicsContext gc) {
        // calc total based on warning counts
        int colorCounter = 0;
        int totalWarnings = 0;
        int startAngle = 283;
        for (int i : warningCounts.values()) {
            totalWarnings += i;
        }


        for (int i: warningCounts.values()) {
            double warningPercentage = ((double)i/totalWarnings)*100;
            double arcExtent = warningPercentage*360/100;


            gc.setFill(Color.BLACK);
            gc.fillArc(450-1, 80-1, 300+2, 300+2,startAngle, arcExtent, ArcType.ROUND);

            gc.setFill(pieColours[colorCounter]);
            gc.fillArc(450, 80, 300, 300,startAngle, arcExtent, ArcType.ROUND);
            startAngle += arcExtent;
            colorCounter += 1;
        }
    }

    private void drawLegend(Map<String, Integer> labels, GraphicsContext gc) {

        // define x,y, width, height;
        int x = 20;
        int y = 120;
        int width = 20;
        int height = 20;
        int colorCounter = 0;
        int textY = 135;

        // traverse label..
        for (String i: labels.keySet()) {

            gc.setFill(Color.BLACK);
            gc.fillRect(x-1,y-1,width+2,height+2);

            gc.setFill(pieColours[colorCounter]);
            gc.fillRect(x,y,width,height);


            gc.setFill(Color.BLACK);
            gc.fillText(i,50,textY);

            y+=40;
            textY+=40;
            colorCounter+=1;
        }
    }
//    private void drawLegend(List<String> labels, GraphicsContext gc) {
//        // define x,y, width, height;
//
//        // traverse label..
//            // gc.setFill
//            // gc.fillRect(x,y, width, height)
////            gc.fillText("", 10, 50);
////            update y
//    }
}