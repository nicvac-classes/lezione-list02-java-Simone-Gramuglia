public class Nodo<T>{
    T dato;
    Nodo<T> next;
    public Nodo<T>(T dato){
        this.dato = dato;
        this.next = null;
    }
}