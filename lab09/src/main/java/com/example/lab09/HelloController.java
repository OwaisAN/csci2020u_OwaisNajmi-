package com.example.lab09;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    Canvas canvas;

    public void initialize(){
        List<Float> stockPrices1 = downloadStockPrices("AAPL");
        List<Float> stockPrices2 = downloadStockPrices("GOOG");

        drawLinePlot(stockPrices1, stockPrices2);

    }

    private List<Float> downloadStockPrices(String symbol){
        List<Float> stockPrices = new ArrayList<>();

        // INTERVAL BOUNDARIES
        long periodStart = LocalDate.of(2010, 1, 1)
                .atStartOfDay(ZoneId.systemDefault())
                .toEpochSecond();
        long periodEnd = LocalDate.of(2015, 12, 31)
                .atStartOfDay(ZoneId.systemDefault())
                .toEpochSecond();

        try {
            URL url = new URL("https://query1.finance.yahoo.com/v7/finance/download/" + symbol + "?period1=" + periodStart + "&period2=" + periodEnd + "&interval=1mo&events=history&includeAdjustedClose=true");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(false);
            conn.setDoInput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = br.readLine();

            while ((line = br.readLine())!= null){
                String[] data = line.split(",");
                stockPrices.add(Float.parseFloat(data[4]));
            }

            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return stockPrices;
    }

    private void drawLinePlot(List<Float> stockPrices1, List<Float> stockPrices2){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int top = 20;
        int left = 50;
        int bottom = 400;
        int right = 775;
        gc.setStroke(Color.BLACK);
        gc.strokeLine(left, top, left, bottom);
        gc.strokeLine(left, bottom, right, bottom);


        plotLine(gc,stockPrices1,Color.BLUE,12.0,34.0);
        plotLine(gc,stockPrices2,Color.RED,12.0,34.0);

    }

    private void plotLine(GraphicsContext gc, List<Float> stockPrices, Color color, double min, double max){
        gc.setStroke(color);
        int x1 = 50;
        double scale = .5;
        for (int i = 0; i <stockPrices.size()-1; i++) {
            int x2 = x1+10;
            double y1 = stockPrices.get(i)*scale;
            double y2 = stockPrices.get(i+1)*scale;
            gc.strokeLine(x1, 400-y1, x2, 400-y2);
            x1 = x2;
            System.out.println(stockPrices.get(i));
        }

    }

//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
}