/**
 * Sample Skeleton for 'Panifici.fxml' Controller Class
 */

package it.gov.itisfeltrinelli.panifici;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PanificiController {
	PanificiModel p=new PanificiModel();
	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="provincia"
    private ComboBox<String> provincia; // Value injected by FXMLLoader

    @FXML // fx:id="citta"
    private ComboBox<String> citta; // Value injected by FXMLLoader

    @FXML // fx:id="listaPanetterie"
    private TextArea listaPanetterie; // Value injected by FXMLLoader

    @FXML
    void cerca(ActionEvent event) {
    	listaPanetterie.setText(p.getFormattedResults(provincia.getValue(), citta.getValue()));
    }

    @FXML
    void cittaSelected(ActionEvent event) {
    	if(btnCerca.isDisable())
    		btnCerca.setDisable(false);
    }
    
    @FXML
    void cittaSelection(ActionEvent event) {
    	String provinc=provincia.getValue();
    	if(btnCerca.isDisable()) {
	    	if(citta.isDisable())
	    		citta.setDisable(false);
	    	citta.getItems().clear();
	    	citta.getItems().addAll(p.getCitta(provinc));
    	}else {
    		citta.getItems().clear();
    		citta.getItems().addAll(p.getCitta(provinc));
    		btnCerca.setDisable(true);
    	}
    }

    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Panifici.fxml'.";
        assert provincia != null : "fx:id=\"provincia\" was not injected: check your FXML file 'Panifici.fxml'.";
        assert citta != null : "fx:id=\"citta\" was not injected: check your FXML file 'Panifici.fxml'.";
        assert listaPanetterie != null : "fx:id=\"listaPanetterie\" was not injected: check your FXML file 'Panifici.fxml'.";
        System.out.println("Sono nell'init");
        provincia.getItems().addAll(p.getProvince());
        citta.setDisable(true);
        }
}
