package com.example.proyecto1;

public class ClasePrincipal {

 ClasePrincipal() {

    }


    public  String[]  EntradaDatos(String val) {
        String[] recorridos = new String[3];

        Arbol arbol = new Arbol();
        Nodo nodoGenerado = new Nodo();

        nodoGenerado = arbol.Generar(val);

        recorridos[0] = arbol.imprimirPreOrden();
        recorridos[1] = arbol.imprimirInOrden();
        recorridos[2] = arbol.imprimirPosOrden();

        return recorridos;
    }

}
