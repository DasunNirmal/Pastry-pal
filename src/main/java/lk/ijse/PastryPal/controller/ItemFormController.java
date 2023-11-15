package lk.ijse.PastryPal.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import lk.ijse.PastryPal.dto.ItemDto;
import lk.ijse.PastryPal.model.ItemModel;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ItemFormController {


    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemID;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblItemID;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    private ItemModel itemModel = new ItemModel();

    public void initialize(){
        setDateAndTime();
        generateNextItemID();
    }

    private void generateNextItemID() {
        try {
            String previousItemID = lblItemID.getId();
            String itemID = itemModel.generateNextItemID();
            lblItemID.setText(itemID);
            clearFields();
            if (btnClearPressed){
                lblItemID.setText(previousItemID);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private boolean btnClearPressed = false;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
        generateNextItemID();
    }

    private void clearFields(){
        txtDescription.setText("");
        txtQty.setText("");
        txtPrice.setText("");
    }

    private void setDateAndTime(){
        Platform.runLater(() -> {
            lblDate.setText(String.valueOf(LocalDate.now()));

            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
                String timeNow = LocalTime.now().format(formatter);
                lblTime.setText(timeNow);
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        });
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = lblItemID.getText();
        String description = txtDescription.getText();
        String qtyText = txtQty.getText();
        String priceText = txtPrice.getText();
        //check if the text fields are empty before parse to double or int otherwise program will throw a Exception
        if (id.isEmpty() || description.isEmpty() || qtyText.isEmpty() || priceText.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Can not Save Item. Text Field is Empty").showAndWait();
            return;
        }
        try {
            double qty = Double.parseDouble(qtyText);
            double price = Double.parseDouble(priceText);

            var dto = new ItemDto(id, description, qty, price);
            try {
                boolean isSaved = itemModel.saveItem(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Item Is Saved").show();
                    clearFields();
                    generateNextItemID();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Item Is Not Saved").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid quantity or price format").showAndWait();
        }
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnActon(ActionEvent event) {

    }

}
