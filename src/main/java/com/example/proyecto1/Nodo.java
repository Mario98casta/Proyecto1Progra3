package com.example.proyecto1;
import java.util.EmptyStackException;
import java.util.Stack;

public class Nodo {
   /* public int dato;
    public Nodo izq;
    public Nodo der;
    public String texto="";

    public Nodo (int dato){
        this.dato=dato;
        this.izq= null;
        this.der=null;
    }

    public Nodo(String nuevo){
        texto=nuevo;
    }

    public Nodo(String nuevo, Nodo izquierda, Nodo derecha){
        texto=nuevo;
        izq=izquierda;
        der=derecha;
    }

    private void msj(String datos){
        System.out.println(datos);
    }

    public int getDato(){
        return dato;
    }

    public Nodo getizq() {
        return izq;
    }

    public void setizq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getder() {
        return der;
    }

    public void setder(Nodo der) {
        this.der = der;
    }

    public void imprimirDato() {
        System.out.print(" "+this.getDato());
    }

    public boolean esOperador(String nuevo){
        String []mOperadores={"+","-","*","/","=","^"};
        for(int i=0; i<mOperadores.length; ++i){
            if(nuevo.equalsIgnoreCase(mOperadores[i])==true ){
                return true;
            }
        }

        return false;
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
    */

    int ValorNodo;
    Nodo izquierdo, derecho;

    public Nodo(int ValorNodo) {
        this.ValorNodo = ValorNodo;
        izquierdo = null;
        derecho = null;
    }

}