package com.example.proyecto1;

public class ClasePrincipal {

    public ClasePrincipal() {

    }


    public  String  EntradaDatos(String val){
        Arbol arbol = new Arbol();
        Nodo nodo = new Nodo();
        HelloController ventana = new HelloController();
        arbol.Generar(val);
        String aux = arbol.imprimirPreOrden();
        System.out.println(aux);
        ventana.TxtRecorridoPostorden.appendText(aux);
        System.out.println("");
        return "master";
    }
}
