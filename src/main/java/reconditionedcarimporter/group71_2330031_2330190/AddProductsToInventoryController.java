package reconditionedcarimporter.group71_2330031_2330190;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AddProductsToInventoryController
{

    @javafx.fxml.FXML
    private ComboBox<String> transmissiontypeComboBoxfxid;
    @javafx.fxml.FXML
    private TextField typeOfFuelfxid;
    @javafx.fxml.FXML
    private TextField vinfxid;
    @javafx.fxml.FXML
    private TextField brandNamefxid;
    @javafx.fxml.FXML
    private TextField typeOfCarfxid;
    @javafx.fxml.FXML
    private TextField pricefxid;
    @javafx.fxml.FXML
    private TextField milieagefxid;
    @javafx.fxml.FXML
    private ComboBox<String> steeringTypeComboBoxfxid;
    @javafx.fxml.FXML
    private TextField quantityfxid;
    @javafx.fxml.FXML
    private TextField engineCcfxid;
    @javafx.fxml.FXML
    private TextField stockNumberfxid;

    @javafx.fxml.FXML
    public void initialize() {
        transmissiontypeComboBoxfxid.getItems().addAll("Manual","Automatic");
        steeringTypeComboBoxfxid.getItems().addAll("Right Hand Drive","Left Hand Drive");


    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchScene("InventoryManager-view.fxml", actionEvent);
        //
    }

    @javafx.fxml.FXML
    public void addProductstoInventoryOnAction(ActionEvent actionEvent) {
        try{
            File f = new File("AddedProductToInventory.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);;
            }
            else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
//            oos = new ObjectOutputStream(fos);


            oos.writeObject(new AddProductToInventory(Integer.parseInt(stockNumberfxid.getText()),vinfxid.getText(),brandNamefxid.getText(),milieagefxid.getText(),engineCcfxid.getText(),typeOfCarfxid.getText(),typeOfFuelfxid.getText(),quantityfxid.getText(),Double.parseDouble(pricefxid.getText()),transmissiontypeComboBoxfxid.getValue(),steeringTypeComboBoxfxid.getValue()));



            oos.close();
        }
        catch(Exception e){
            //

        }
    }
}