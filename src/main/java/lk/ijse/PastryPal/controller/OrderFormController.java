package lk.ijse.PastryPal.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class OrderFormController {

    @FXML
    private Label lblCustomerId;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    public void initialize(){
        setDateAndTime();
    }
    private void setDateAndTime(){
        lblDate.setText(String.valueOf(LocalDate.now()));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            String timeNow = LocalTime.now().format(formatter);
            lblTime.setText(timeNow);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

}