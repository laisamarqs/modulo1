import java.util.LinkedList;

public class Fila {
    private LinkedList<Integer> fila;

    public Fila() {
        fila = new LinkedList<>();
    }


    public void enqueue(int elemento) {
        fila.addLast(elemento);
    }


    public int dequeue() {
        if (fila.isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return fila.removeFirst();
    }


    public int rear() {
        if (fila.isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return fila.getLast();
    }


    public int front() {
        if (fila.isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return fila.getFirst();
    }


    public int size() {
        return fila.size();
    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        System.out.println("Tamanho da fila: " + fila.size());
        System.out.println("Elemento na frente: " + fila.front());
        System.out.println("Elemento no fim: " + fila.rear());

        fila.dequeue();
        System.out.println("Tamanho da fila após remover um elemento: " + fila.size());
        System.out.println("Novo elemento na frente: " + fila.front());
    }
}
