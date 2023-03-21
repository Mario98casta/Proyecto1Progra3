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
    public TextArea TxtRecorridopreorden;

    public String ValorNumero(String cadena){
        String NuevaCadena = cadena;
        char [] acaracteres;

        acaracteres = NuevaCadena.toCharArray();

        for (int i=0; i < cadena.length(); i++){

            if (Character.isLetter(acaracteres[i])) {
                int ValorNum = Valor_a_Variables(String.valueOf(acaracteres[i]));

                acaracteres[i]= Integer.toString(ValorNum).charAt(0);


                System.out.println(acaracteres[i]);
                System.out.println(ValorNum);
            }


        }
        NuevaCadena= String.valueOf(acaracteres);

        return NuevaCadena;
    }

    @FXML
    protected void CLICKBTResultado() {
        BtNuevo.setVisible(true);
        BtResultado.setVisible(false);
        TxTResultado.appendText("Resultado de la Operacion");
        TxtRecorridoPostorden.appendText("recorrido Postorden ");
        TxtRecorridoInorden.appendText("Recorrido Inorden ");
        TxtRecorridopreorden.appendText("Recorrido Preorden");

        Arbol arbol = new Arbol();
        ClasePrincipal cl = new ClasePrincipal();
        String[] recorridos = new String[2];
        String val = String.valueOf(ValorNumero(TxtIngresoExp.getText()));
        recorridos = cl.EntradaDatos(val);
        TxTResultado.setText(val);
        TxtRecorridoPostorden.setText(recorridos[0]);
    }

    @FXML
    protected void CLICKBTnuevo() {
        BtNuevo.setVisible(false);
        BtResultado.setVisible(true);
        TxtIngresoExp.clear();
        TxTResultado.clear();
        TxtRecorridoPostorden.clear();
        TxtRecorridoInorden.clear();
        TxtRecorridopreorden.clear();
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