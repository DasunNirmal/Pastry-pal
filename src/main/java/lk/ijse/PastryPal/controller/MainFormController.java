package lk.ijse.PastryPal.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    @FXML
    private JFXButton btnComplains;

    @FXML
    private JFXButton btnCustomers;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnItems;

    @FXML
    private JFXButton btnMaterials;

    @FXML
    private JFXButton btnOrders;

    @FXML
    private JFXButton btnSuppliers;

    @FXML
    private AnchorPane mainNode;

    public void initialize() throws IOException {
        selectCss(btnDashboard);
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);
    }

    private void selectCss(JFXButton mainFormBtn){
        this.btnDashboard.getStyleClass().remove("select_button");
        this.btnOrders.getStyleClass().remove("select_button");
        this.btnCustomers.getStyleClass().remove("select_button");
        this.btnSuppliers.getStyleClass().remove("select_button");
        this.btnMaterials.getStyleClass().remove("select_button");
        this.btnItems.getStyleClass().remove("select_button");
        this.btnEmployee.getStyleClass().remove("select_button");
        this.btnComplains.getStyleClass().remove("select_button");

        this.btnDashboard.getStyleClass().add("default_button");
        this.btnOrders.getStyleClass().add("default_button");
        this.btnCustomers.getStyleClass().add("default_button");
        this.btnSuppliers.getStyleClass().add("default_button");
        this.btnMaterials.getStyleClass().add("default_button");
        this.btnItems.getStyleClass().add("default_button");
        this.btnEmployee.getStyleClass().add("default_button");
        this.btnComplains.getStyleClass().add("default_button");

        mainFormBtn.getStyleClass().remove("default_button");
        mainFormBtn.getStyleClass().add("select_button");
    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) throws IOException {
        selectCss(btnDashboard);
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        selectCss(btnCustomers);
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/customer_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);
    }

    @FXML
    void btnOrderOnAction(ActionEvent event) throws IOException {
        selectCss(btnOrders);
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/Order_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);
    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        selectCss(btnSuppliers);
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/supplier_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);
    }

    @FXML
    void btnMaterialsOnAction(ActionEvent event) throws IOException {
        selectCss(btnMaterials);
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/materials_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);
    }

    @FXML
    void btnItemsOnAction(ActionEvent event) throws IOException {
        selectCss(btnItems);
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/item_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        selectCss(btnEmployee);
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/employee_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);
    }

    @FXML
    void btnComplainsOnAction(ActionEvent event) throws IOException {
        selectCss(btnComplains);
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/complains_form.fxml"));
        this.mainNode.getChildren().clear();
        this.mainNode.getChildren().add(anchorPane);
    }

    @FXML
    void btnLogoutOnAction(MouseEvent event) throws IOException {
        mainNode.getScene().getWindow().hide();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"))));
        stage.centerOnScreen();
        stage.show();
    }
}
