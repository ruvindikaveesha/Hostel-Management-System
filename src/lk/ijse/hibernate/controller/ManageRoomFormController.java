package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.BOType;
import lk.ijse.hibernate.bo.custom.RoomBO;
import lk.ijse.hibernate.dto.RoomDTO;
import lk.ijse.hibernate.view.tm.RoomTM;

import java.io.IOException;
import java.util.List;

public class ManageRoomFormController {
    public AnchorPane ManageRoomContext;
    public JFXButton btnAddNewRoom;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public TableView <RoomTM> tblRoom;
    public TableColumn colRoomId;
    public TableColumn colRoomType;
    public TableColumn colKeymny;
    public TableColumn colRoomQty;
    public JFXComboBox<String> cmbRoomID;
    public JFXComboBox <String>cmbRoomType;




    RoomBO roomBO = BOFactory.getInstance().getBO(BOType.ROOM);
    // StudentBO studentBO=new StudentBOImpl();

    public void initialize() throws IOException {

        cmbRoomID.getItems().addAll("RM-1324","RM-5467","RM-7896","RM-0093");
        cmbRoomType.getItems().addAll("Non-AC","Non-Ac/Food","AC","AC/Food");

        tblRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomID"));
        tblRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("roomType"));
        tblRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        tblRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("roomQty"));

        initUI();

        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnDelete.setDisable(false);

            if(newValue != null){
                cmbRoomID.setValue(newValue.getRoomID());
                cmbRoomType.setValue(newValue.getRoomType());
                txtKeyMoney.setText(newValue.getKeyMoney());
                txtRoomQty.setText(String.valueOf(newValue.getRoomQty()));


                cmbRoomID.setDisable(false);
                cmbRoomType.setDisable(false);
                txtKeyMoney.setDisable(false);
                txtRoomQty.setDisable(false);


                btnSave.setDisable(false);
            }
        });

        loadAllRooms();
    }
    private void loadAllRooms(){
        tblRoom.getItems().clear();
        try {
            List<RoomDTO> allrooms = roomBO.getAllRooms();
            for(RoomDTO r : allrooms) {
                tblRoom.getItems().add(new RoomTM(
                        r.getRoomID(),
                        r.getRoomType(),
                        r.getKeyMoney(),
                        r.getRoomQty()
                ));
            }
        } catch (Exception e) {
            // System.out.println(e);
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }
    private void clearFields(){
        cmbRoomID.setValue(null);
        cmbRoomType.setValue(null);
        txtKeyMoney.clear();
        txtRoomQty.clear();

    }

    private void initUI() {
        cmbRoomID.setValue(null);
        cmbRoomType.setValue(null);
        txtKeyMoney.clear();
        txtRoomQty.clear();
        // txtDOB.clear();
        cmbRoomID.setDisable(true);
        cmbRoomType.setDisable(true);
        txtKeyMoney.setDisable(true);
        txtRoomQty.setDisable(true);
        cmbRoomID.setEditable(true);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
    }


    public void AddNewRoomOnAction(ActionEvent actionEvent) {
        cmbRoomID.setDisable(false);
        cmbRoomType.setDisable(false);
        txtKeyMoney.setDisable(false);
        txtRoomQty.setDisable(false);
        cmbRoomID.setValue(null);
        cmbRoomType.setValue(null);
        txtKeyMoney.clear();
        txtRoomQty.clear();
        //cmbRoomID.setValue(generateNewId());
        cmbRoomID.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("Save");
        tblRoom.getSelectionModel().clearSelection();
    }

    public void SaveRoomOnAction(ActionEvent actionEvent) throws IOException {
        String id =cmbRoomID.getValue();
        String type = cmbRoomType.getValue();
        String key_mny = txtKeyMoney.getText();
        int qty = Integer.valueOf(txtRoomQty.getText());



        if (!key_mny.matches("^[0-9]{3,5}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Key_Money").show();
            txtKeyMoney.requestFocus();
            return;
        } else if (!txtRoomQty.getText().matches("^[0-9]{1,5}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid qty ").show();
            txtRoomQty.requestFocus();
            return;

        }
        if (btnSave.getText().equalsIgnoreCase("Save")) {


            if (roomBO.saveRoom(new RoomDTO(id, type, key_mny, qty)))
            {

                new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
                tblRoom.getItems().add(new RoomTM(id, type, key_mny, qty));
                clearFields();
            }else{
                new Alert(Alert.AlertType.ERROR, "Something Went Wrong!").show();

            }


        } else {
            try {
                if (roomBO.updateRoom(new RoomDTO(id, type, key_mny, qty))) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();
                    loadAllRooms();
                    clearFields();
                }
            } catch (Exception e) {
                // System.out.println("Exception 2");
                //System.out.println(e);
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Something Went Wrong!").show();
            }
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) throws IOException {
        /*RoomTM selectedItem = tblRoom.getSelectionModel().getSelectedItem();
        // System.out.println(selectedItem.get);
        if (roomBO.deleteRoom(selectedItem.getRoomID())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted SuccessFully").show();
            loadAllRooms();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something Went Wrong !!").show();

        }*/

        String id=tblRoom.getSelectionModel().getSelectedItem().getRoomID();
        try {
            roomBO.deleteRoom(id);
            tblRoom.getItems().remove(tblRoom.getSelectionModel().getSelectedItem());
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted..!").show();

            tblRoom.getSelectionModel().clearSelection();
            clearFields();
        } catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Something Happened.Try again Carefully..!").show();
        }


    }
}
