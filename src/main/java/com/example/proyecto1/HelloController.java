package com.example.proyecto1;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {



    @FXML
   public Button BtResultado;
    @FXML
    public Button BtNuevo;
    @FXML
    public TextField TxtIngresoExp;
    @FXML
    public TextField TxTResultado;

    @FXML
    public TextArea TxtRecorridoInorden;
    @FXML
    public TextArea TxtRecorridoPostorden;

    @FXML
    protected void CLICKBTResultado() {
            BtNuevo.setVisible(true);
        BtResultado.setVisible(false);

        String val = "(5+8)*3/(6-7)";
        ClasePrincipal cl = new ClasePrincipal();
        cl.EntradaDatos(val);


    }
    @FXML
    protected void CLICKBTnuevo() {
        BtNuevo.setVisible(false);
        BtResultado.setVisible(true);
        TxtIngresoExp.clear();
        TxTResultado.clear();
        TxtRecorridoPostorden.clear();
        TxtRecorridoInorden.clear();




    }


    public void HAND(MouseEvent mouseEvent) {
        BtResultado.setCursor(Cursor.HAND);
        BtNuevo.setCursor(Cursor.HAND);

    }

    public void DEFAULT(MouseEvent mouseEvent) {
        BtNuevo.setCursor(Cursor.DEFAULT);
        BtResultado.setCursor(Cursor.DEFAULT);

    }
}