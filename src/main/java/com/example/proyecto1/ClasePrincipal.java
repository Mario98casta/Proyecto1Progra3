package com.example.proyecto1;

public class ClasePrincipal {

    public ClasePrincipal() {

    }


    public  String  EntradaDatos(String val){
        Arbol arbol = new Arbol();
        Nodo nodo = new Nodo();
        HelloController ventana = new HelloController();
        arbol.Generar(val);
        String cadena = arbol.imprimirPreOrden();
        System.out.println(cadena);
        ventana.TxtRecorridoPostorden.appendText(cadena);
        return "master";
    }
}
