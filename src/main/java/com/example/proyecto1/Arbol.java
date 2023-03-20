package com.example.proyecto1;

import java.util.EmptyStackException;
import java.util.Stack;

public class Arbol {

    //public String preorden,postorden,inorden;
    private Nodo raiz;
    private String cadena;

    public Arbol() {
        raiz = null;
        cadena = null;
    }

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    private void preorden(Nodo n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getizq());
            preorden(n.getder());
        }
    }

    public String imprimirPreOrden() {
        String aux = imprimirPreOrden(this.raiz);
        return aux;
    }

    private String imprimirPreOrden(Nodo raiz) {
        String dato="";
        if (raiz != null) {
            System.out.print(raiz.getdato() + " ");
            String a = imprimirPreOrden(raiz.getizq());
            String b= imprimirPreOrden(raiz.getder());
            dato = raiz.getdato() + " " +a +b ;
         }
        return dato;
    }

    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getizq());
            n.imprimirDato();
            inorden(n.getder());
        }
    }

    public void imprimirInOrden() {
        imprimirInOrden(this.raiz);
    }

    private void imprimirInOrden(Nodo raiz) {
        if (raiz != null) {
            imprimirInOrden(raiz.getizq());
            System.out.print(raiz.getdato() + " ");
            imprimirInOrden(raiz.getder());
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getizq());
            postorden(n.getder());
            n.imprimirDato();
        }
    }

    public void imprimirPosOrden() {
        imprimirPosOrden(this.raiz);
    }

    private void imprimirPosOrden(Nodo raiz) {
        if (raiz != null) {
            imprimirPosOrden(raiz.getizq());
            imprimirPosOrden(raiz.getder());
            System.out.print(raiz.getdato() + " ");
        }
    }

    private String imprimir2(Nodo raíz){
        String r = "";
        if(raíz !=null){
            //
            r = r.concat(raíz.getdato() + "");
        }
        return r;
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

    private void recorrerPreOrden(StringBuilder sb, Nodo node) {
        if (node != null) {
            sb.append(node.getdato());
            sb.append("\n");
            recorrerPreOrden(sb, node.getizq());
            recorrerPreOrden(sb, node.getder());
        }
    }

    private void recorrerPosOrden(StringBuilder sb, Nodo node) {
        if (node != null) {
            recorrerPosOrden(sb, node.getizq());
            recorrerPosOrden(sb, node.getder());
            sb.append(node.getdato());
            sb.append("\n");
        }
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
                // s.push(new Nodo(c+""));
            }
        }
        return s.peek(); //Retorna el arbol sin borrarlo de la pila.
    }

    public Nodo agregar(char caracter) {
        Nodo nodo = new Nodo();
        nodo.setdato(caracter);
        nodo.setder(null);
        nodo.setizq(null);
        return nodo;
    }

    public void Generar(String cadena) {
        cadena = "(" + cadena;
        cadena += ")";
        this.cadena = cadena;
        this.raiz = Generar();
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

    public Nodo Generar() {
        String cadena = this.cadena;
        Stack<Nodo> pila = new Stack<>();
        Stack<Character> pila2 = new Stack<>();

        int[] simbolo = new int[123];
        simbolo['+'] = simbolo['-'] = 1;
        simbolo['/'] = simbolo['*'] = 2;
        simbolo['^'] = 3;
        simbolo[')'] = 0;

        Nodo aux;
        Nodo aux1;
        Nodo aux2;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '(') {
                pila2.add(cadena.charAt(i));
            }
            else if (Character.isDigit(cadena.charAt(i))) {
                aux = agregar(cadena.charAt(i));
                pila.add(aux);
            } else if (simbolo[cadena.charAt(i)] > 0) {
                while (!pila2.isEmpty() && pila2.peek() != '(' && ((cadena.charAt(i) != '^' && simbolo[pila2.peek()] >= simbolo[cadena.charAt(i)]) || (cadena.charAt(i) == '^' && simbolo[pila2.peek()] > simbolo[cadena.charAt(i)]))) {
                    aux = agregar(pila2.peek());
                    pila2.pop();
                    aux1 = pila.peek();
                    pila.pop();
                    aux2 = pila.peek();
                    pila.pop();
                    aux.setizq(aux2);
                    aux.setder(aux1);
                    pila.add(aux);
                }

                pila2.push(cadena.charAt(i));
            } else if (cadena.charAt(i) == ')') {
                while (!pila2.isEmpty() && pila2.peek() != '(') {
                    aux = agregar(pila2.peek());
                    pila2.pop();
                    aux1 = pila.peek();
                    pila.pop();
                    aux2 = pila.peek();
                    pila.pop();
                    aux.setizq(aux2);
                    aux.setder(aux1);
                    pila.add(aux);
                }

                pila2.pop();
            }
        }
        aux = pila.peek();
        return aux;
    }

    public void imprimirArbol() {
        imprimirArbol(this.raiz);
    }

    private void imprimirArbol(Nodo raiz) {
        imprimirArbol(raiz, 0);
    }

    private void imprimirArbol(Nodo raiz, int separador) {
        int espacios = 3;
        if (raiz == null) {return;}
        //separador += espacios;
        imprimirArbol(raiz.getder());
        //System.out.print("\n");
        /*for (int i = espacios; i < separador; i++) {
            System.out.print(" . ");
        }*/
        System.out.print(raiz.getdato());
        imprimirArbol(raiz.getizq(), separador);
    }
}
