package com.example.proyecto1;
import java.util.EmptyStackException;
import java.util.Stack;

public class Nodo {
<<<<<<< HEAD
    public char dato;
=======
   /* public int dato;
>>>>>>> mario98
    public Nodo izq;
    public Nodo der;
    public String texto="";

<<<<<<< HEAD
    public Nodo padre;

    public Nodo() {
        this.izq = null;
        this.der = null;
=======
    public Nodo (int dato){
        this.dato=dato;
        this.izq= null;
        this.der=null;
>>>>>>> mario98
    }

    public Nodo(char dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public Nodo(String nuevo, Nodo izquierda, Nodo derecha){
        texto=nuevo;
        izq=izquierda;
        der=derecha;
    }

    private void msj(String datos){
        System.out.println(datos);
    }

    public void setdato(char dato) {
        this.dato = dato;
    }

    public char getdato() {
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

    public Nodo getpadre() {
        return padre;
    }

    public void setNodoPadre(Nodo padre) {
        this.padre = padre;
    }

    public void imprimirDato() {
        System.out.print(" "+this.getdato());
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

<<<<<<< HEAD
    public void postOrder(){
        vPOrden="";
        System.out.println(postOrder(this));
    }
=======






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
>>>>>>> mario98

    private String vPOrden="";
    private String postOrder(Nodo nueva_raizq){
        if(nueva_raizq==null){
            return "";
        }
        postOrder(nueva_raizq.izq);
        postOrder(nueva_raizq.der);
        vPOrden+=nueva_raizq.texto;
        return vPOrden;
    }


    public void inOrder(){
        vInOrden="";
        System.out.println(inOrder(this));
    }
    private String vInOrden="";
    private String inOrder(Nodo nueva_raizq) {
        if (nueva_raizq == null) {
            return "";
        }

        if (this.esOperador(nueva_raizq.texto) == true) {
            vInOrden += "(";
        }

        inOrder(nueva_raizq.izq);
        vInOrden += nueva_raizq.texto;
        inOrder(nueva_raizq.der);

        if (this.esOperador(nueva_raizq.texto) == true) {
            vInOrden += ")";
        }
        return vInOrden;
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