package com.example.proyecto1;

import java.util.EmptyStackException;
import java.util.Stack;

public class Arbol {
    private Nodo raiz;

    public Arbol() {

    }

    private boolean existe(Nodo n, int busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getDato() == busqueda) {
            return true;
        } else if (busqueda < n.getDato()) {
            return existe(n.getizq(), busqueda);
        } else {
            return existe(n.getder(), busqueda);
        }

    }

    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    private void insertar(Nodo padre, int dato) {
        if (dato > padre.getDato()) {
            if (padre.getder() == null) {
                padre.setder(new Nodo(dato));
            } else {
                this.insertar(padre.getder(), dato);
            }
        } else {
            if (padre.getizq() == null) {
                padre.setizq(new Nodo(dato));
            } else {
                this.insertar(padre.getizq(), dato);
            }
        }
    }

    private void preorden(Nodo n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getizq());
            preorden(n.getder());
        }
    }

    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getizq());
            n.imprimirDato();
            inorden(n.getder());
        }
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getizq());
            postorden(n.getder());
            n.imprimirDato();
        }
    }



    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
    }

    public Nodo CrearArbol(String cadena){
        if(cadena.isEmpty()==true){
            return null;
        }
        Stack<Nodo> s=new Stack();//Primer uso de Stack en Java, jueves 1 de setiembre del 2022.
        for(char c: cadena.toCharArray()){
            if(this.esOperador(c + "")==true){
                //La entrada actual es un operador.
                Nodo x=null;
                try{
                    x=s.pop();
                }catch(EmptyStackException e){}

                Nodo y=null;
                try{
                    y=s.pop();
                }catch(EmptyStackException e){}

                //Un nuevo arbol binario de expreciones.
                Nodo nodo = new Nodo(c +"", y, x);
                s.push(nodo); //Se inserta en la pila.
            }
            else{
                //La entrada actual es un operando.
                s.push(new Nodo(c+""));
            }
        }
        return s.peek(); //Retorna el arbol sin borrarlo de la pila.
    }

    public boolean esOperador(String nuevo_texto){
        String []mOperadores={"+","-","*","/","=","^"};
        for(int i=0; i<mOperadores.length; ++i){
            if(nuevo_texto.equalsIgnoreCase(mOperadores[i])==true ){
                return true;
            }
        }

        return false;
    }


}
