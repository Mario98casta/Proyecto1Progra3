package com.example.proyecto1;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

public class HelloController {


    private static Object AlertType;
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
        TxTResultado.appendText("SE COLOCA EL RESULTADO");
        TxtRecorridoPostorden.appendText("recorrido postorden ");
        TxtRecorridoInorden.appendText("recorrido inorden ");
        int ValorNumerio = showNumericInputDialog("A");
        TxTResultado.setText(String.valueOf(ValorNumerio));


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
    public static int showNumericInputDialog( String contentText) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("De Variable A Valor");
        dialog.setHeaderText("Introduce valor de "+contentText+":");
        dialog.setContentText("Valor Numerico:");

        String resultText;
        int num = 0;
        do {
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                resultText = result.get();
                try {
                    num = Integer.parseInt(resultText);
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("El valor introducido no es un número entero válido.");
                    alert.showAndWait();
                }
            } else {
                resultText = "";
                break;
            }
        } while (num == 0);

        return num;
    }




}