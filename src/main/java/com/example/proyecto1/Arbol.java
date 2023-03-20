package com.example.proyecto1;

import java.util.EmptyStackException;
import java.util.Stack;

public class Arbol {

    public String preorden,postorden,inorden;
    private Nodo raiz;
<<<<<<< HEAD
    private String cadena;

    public Arbol() {
        raiz = null;
        cadena = null;
=======
    public Arbol() {
        raiz = null;
    }

    // Inserta un valor en el árbol
    public void insertarNodo(int valor) {
        raiz = insertarRectificarNodo(raiz, valor);
    }

    // Función auxiliar para insertar un valor en el árbol si es mayor
    private Nodo insertarRectificarNodo(Nodo nodo, int valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            return nodo;
        }

        if (valor < nodo.ValorNodo) {
            nodo.izquierdo = insertarRectificarNodo(nodo.izquierdo, valor);
        } else if (valor > nodo.ValorNodo) {
            nodo.derecho = insertarRectificarNodo(nodo.derecho, valor);
        }

        return nodo;
    }

    public void preorden() {
        Validarpreorden(raiz);
    }

    // Función auxiliar para el recorrido preorden
    private void Validarpreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.ValorNodo + " ");
            Validarpreorden(nodo.izquierdo);
            Validarpreorden(nodo.derecho);
        }
    }

    public void Inorden() {
        ValidarInorden(raiz);
    }

    // Función auxiliar para el recorrido preorden
    private void ValidarInorden(Nodo nodo) {
        if (nodo != null) {
            Validarpreorden(nodo.izquierdo);
            System.out.print(nodo.ValorNodo + " ");
            Validarpreorden(nodo.derecho);
        }
    }


    /*public Arbol() {

>>>>>>> mario98
    }

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    private void preorden(Nodo n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getizq());
            preorden(n.getder());
        }
    }

    public void imprimirPreOrden() {
        imprimirPreOrden(this.raiz);
    }

    private void imprimirPreOrden(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.getdato() + " ");
            imprimirPreOrden(raiz.getizq());
            imprimirPreOrden(raiz.getder());
        }
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
        Stack<Nodo> s=new Stack();//Primer uso de Stack en Java
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

<<<<<<< HEAD
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
=======
*/
>>>>>>> mario98
}
