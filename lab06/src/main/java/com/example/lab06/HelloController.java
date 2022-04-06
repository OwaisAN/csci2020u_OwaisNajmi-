package com.example.lab06;

import javafx.fxml.FXML;
import javafx.scene.canvas.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.Arrays;

public class HelloController {
    // Part 1 data
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    // Part 2 data
    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    @FXML
    public Canvas canvas;

    @FXML
    private void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawBarChart(gc);
        drawPieChart(gc);
    }

    private void drawBarChart(GraphicsContext gc) {
//        int avgHousingWidthBetween = 20;
//        for (int i = 0; i < avgHousingPricesByYear.length; i++) {
//            // balanced value
//            double value = avgHousingPricesByYear[i]/5000;
//            double standardHeight = 400 - value;
//            gc.setFill(Color.RED);
//            gc.fillRect(avgHousingWidthBetween,standardHeight,15,value);
//            avgHousingWidthBetween += 40;
//            System.out.println(value);
//        }

//        int avgCommWidthBetween = 35;
//        for (int i = 0; i < avgCommercialPricesByYear.length; i++) {
//            // balanced value
//            double value = avgCommercialPricesByYear[i]/5000;
//            double standardHeight = 400 - value;
//            gc.setFill(Color.BLUE);
//            gc.fillRect(avgCommWidthBetween,standardHeight,15,value);
//            avgCommWidthBetween += 40;
//            System.out.println(value);
//        }

//  TURNED BOTH FOR LOOPS ABOVE INTO A FUNCTION CALLED drawRect()
        drawRect(gc, avgHousingPricesByYear, 400, 15, 5000, Color.RED, 20);

        drawRect(gc, avgCommercialPricesByYear, 400, 15, 5000, Color.BLUE, 35);
    }

    private void drawPieChart(GraphicsContext gc) {

        double sum = Arrays.stream(purchasesByAgeGroup).sum(); // GETTING TOTAL SUM OF purchasesByAgeGroup array
        int startAngle = 0;

        for (int i = 0; i < ageGroups.length; i++) { // LOOPING THRU ageGroups array
            double purchasePercentage = (purchasesByAgeGroup[i]/sum)*100; // GETTING PERCENTAGE OF PURCHASES BY CURRENT AGR GROUP
            double arcExtent = purchasePercentage*360/100; // CONVERTING PERCENTAGE TO AN ANGLE
            gc.setFill(pieColours[i]);
            gc.fillArc(450, 80, 300, 300, startAngle, arcExtent, ArcType.ROUND );
            startAngle += arcExtent; // CHANGING START ANGLE SO NEXT ARC WILL START WHERE THIS ONE FINISHED
        }
    }



    // THIS FUNCTION IS USED IN THE drawBarChart FUNCTION TO CREATE THE DIFFERENT BARS
    public void drawRect(GraphicsContext gc, double[] data, int baseHeight, int width, int scaling, Color color, int widthBetween) {
        for (double datum : data) {
            double value = datum / scaling;
            gc.setFill(color);
            gc.fillRect(widthBetween, baseHeight - value, width, value);
            widthBetween += 40;
        }
    }
}