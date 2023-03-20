package com.example.proyecto1;

public class ClasePrincipal {

 ClasePrincipal() {

    }


    public  String[]  EntradaDatos(String val) {
        String[] recorridos = new String[2];

        Arbol arbol = new Arbol();
<<<<<<< HEAD
        Nodo nodo = new Nodo();
        HelloController ventana = new HelloController();
        arbol.Generar(val);
        String aux = arbol.imprimirPreOrden();
        System.out.println(aux);
        ventana.TxtRecorridoPostorden.appendText(aux);
        System.out.println("");
        return "master";
=======
        Nodo nodoGenerado = new Nodo();

        nodoGenerado = arbol.Generar(val);

        recorridos[0] = arbol.imprimirPreOrden();


        return recorridos;
>>>>>>> master
    }

}
