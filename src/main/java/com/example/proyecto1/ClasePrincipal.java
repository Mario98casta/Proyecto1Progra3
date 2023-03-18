package com.example.proyecto1;

public class ClasePrincipal {

    public ClasePrincipal() {

    }

    public  String  EntradaDatos(String val){
        Arbol arbol = new Arbol();
        arbol.CrearArbol(val);
        return "master";
    }

}
