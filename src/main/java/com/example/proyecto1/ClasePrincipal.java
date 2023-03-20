package com.example.proyecto1;

public class ClasePrincipal {

 ClasePrincipal() {

    }


    public  String[]  EntradaDatos(String val) {
        String[] recorridos = new String[2];

        Arbol arbol = new Arbol();
        Nodo nodoGenerado = new Nodo();

        nodoGenerado = arbol.Generar(val);

        recorridos[0] = arbol.imprimirPreOrden();


        return recorridos;
    }

}
