public class Lista <T>{
    private Nodo <T> head;
    public Lista (){
        this.head = null;
    }
    public boolean isEmpty (){
        return head == null;
    }
    public void aggiungiInTesta(T dato) {
        Nodo<T> nuovoNodo = new Nodo<>(dato);
        nuovoNodo.next = head;
        head = nuovoNodo;
    }
   public void aggiungiInCoda(T dato) {
        Nodo<T> nuovoNodo = new Nodo<>(dato);
        if (head == null) {
            head = nuovoNodo;
            return;
        }        
        Nodo<T> dC = head;
        while (dC.next != null) {
            dC = dC.next;
        }
        dC.next = nuovoNodo;
    }
    public void aggiungiInPosizione(T dato, int posizione) {
        if (posizione == 0) {
            aggiungiInTesta(dato);
            return;
        }
        
        Nodo<T> dC = head;
        int i = 0;
        
        while (cdC != null && i < posizione - 1) {
            dC = dC.next;
            i++;
        }
        
        if (dC == null) {
            throw new IndexOutOfBoundsException("Posizione oltre la fine della lista");
        }
        
        Nodo<T> nuovoNodo = new Nodo<>(dato);
        nuovoNodo.next = dC.next;
        dC.next = nuovoNodo;
    }
    public T leggiTesta() {
        if (head == null) {
            throw new NoSuchElementException("Lista vuota");
        }
        return head.dato;
    }
    public T leggiCoda() {
        if (head == null) {
            throw new NoSuchElementException("Lista vuota");
        }
        
        Nodo<T> dC = head;
        while (dC.next != null) {
            dC = dC.next;
        }
        return dC.dato;
    }
    public T leggiInPosizione(int posizione) {
        Nodo<T> dC = head;
        int i = 0;
        while (dC != null && i < posizione) {
            dC = dC.next;
            i++;
        }
        if (dC == null) {
            throw new IndexOutOfBoundsException("Posizione oltre la fine della lista");
        }
        return dC.dato;
    }
    public int size() {
        int c = 0;
        Nodo<T> dC = head;
        
        while (dC != null) {
            c++;
            dC = dC.next;
        }
        
        return c;
    }
    public boolean contiene(T dato) {
        Nodo<T> dC = head;
        while (dC != null) {
            if (dC.dato.equals(dato)) {
                return true;
            }
            dC = dC.next;
        }
        return false;
    }
    public int indiceDi(T dato) {
        Nodo<T> dC = head;
        int indice = 0;
        while (dC != null) {
            if (dC.dato.equals(dato)) {
                return indice;
            }
            dC = dC.next;
            indice++;
        }
        return -1;
    }
    public boolean cancella(T dato) {
        if (head == null) {
            return false;
        }
        
        // Caso speciale: il dato è in testa
        if (head.dato.equals(dato)) {
            head = head.next;
            return true;
        }
        
        Nodo<T> p = head;
        Nodo<T> dC = head.next;
        
        while ( dC != null) {
            if ( dC.dato.equals(dato)) {
                p.next = dC.next;
                return true;
            }
            p = dC;
            dC = dC.next;
        }
        
        return false;
    }
    public T cancellaInPosizione(int posizione) {
        if (posizione < 0 || head == null) {
            throw new IndexOutOfBoundsException("Posizione non valida");
        }
        
        // Caso speciale: cancellazione in testa
        if (posizione == 0) {
            T dato = head.dato;
            head = head.next;
            return dato;
        }
        
        Nodo<T> p = head;
        int i = 0;
        
        while (p.next != null && i < posizione - 1) {
            p = p.next;
            i++;
        }
        
        if (p.next == null) {
            throw new IndexOutOfBoundsException("Posizione oltre la fine della lista");
        }
        
        T dato = p.next.dato;
        p.next = p.next.next;
        return dato;
    }
    public void concatena(Lista<T> altraLista) {
        if (altraLista == null || altraLista.head == null) {
            return;
        }
        
        if (head == null) {
            head = altraLista.head;
            return;
        }
        
        Nodo<T> dC = head;
        while (dC.next != null) {
            dC = dC.next;
        }
        dC.next = altraLista.head;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> dC = head;
        
        while (dC != null) {
            sb.append(dC.dato);
            sb.append(" -> ");
            dC = dC.next;
        }
        sb.append("NULL");
        
        return sb.toString();
    }
}