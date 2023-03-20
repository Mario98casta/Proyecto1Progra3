package com.example.proyecto1;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

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
        TxtRecorridoPostorden.appendText("recorrido inorden ");
        TxtRecorridoInorden.appendText("recorrido inorden ");
        int ValorNumerio = Valor_a_Variables("A");
        TxTResultado.setText(String.valueOf(ValorNumerio));
        TxtRecorridoPostorden.setText("holamundot");
        TxtRecorridoInorden.setText("holamundoi");
        Arbol arbol = new Arbol();
        String val = TxtIngresoExp.getText();
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
    public static int Valor_a_Variables(String contentText) {
        TextInputDialog dialog = new TextInputDialog();
        DialogPane dialogPane = dialog.getDialogPane();
        dialog.setTitle("De Variable A Valor");
        dialog.setHeaderText("Introduce valor de "+contentText+":");
        dialog.setContentText("Valor Numerico:");
      //  dialog.initStyle(true);

        String ResultText;
        int num = 0;
        do {
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                ResultText = result.get();
                try {
                    num = Integer.parseInt(ResultText);
                } catch (NumberFormatException e) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error al Ingresar Valor");
                    alerta.setContentText("El valor introducido no es válido.");
                    alerta.showAndWait();

                }
            } else {
                ResultText = "";
                break;
            }
        } while (num == 0);

        return num;
    }




}