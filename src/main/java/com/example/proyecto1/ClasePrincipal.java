package com.example.proyecto1;

public class ClasePrincipal {

    public ClasePrincipal() {

    }


    public  String  EntradaDatos(String val){
        Arbol arbol = new Arbol();
        HelloController ventana = new HelloController();
        arbol.Generar(val);
        arbol.imprimirPosOrden();
        System.out.println();
        arbol.imprimirInOrden();
        System.out.println();
        arbol.imprimirPreOrden();
        //System.out.println(arbol.getImprimirposOrden());
        //postorden = arbol.imprimirPosOrden();
        /*
        System.out.print("La expresion en preorden es: ");
        arbol.imprimirPreOrden();
        System.out.print("La expresion en inorden es: ");
        arbol.imprimirInOrden();
        System.out.println();
        System.out.print("La expresion en postorden es: ");
        arbol.imprimirPosOrden();
        System.out.println();
         */
        return "master";
    }

}
