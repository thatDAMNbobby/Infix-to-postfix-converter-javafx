
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author bobby
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField inputField;
    @FXML
    private Label outputField;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String infix = inputField.getText();
        String postfix = Postfix.convertToPostfix(infix);
        outputField.setText(postfix);
        inputField.setText("");
    }
    
    @FXML
    private void handleCancelBtn(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
