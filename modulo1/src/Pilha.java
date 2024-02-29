import java.util.EmptyStackException;

public class Pilha {
    private int[] elementos;
    private int tamanho;
    private static final int CAPACIDADE_PADRAO = 10;


    public Pilha() {
        this.elementos = new int[CAPACIDADE_PADRAO];
        this.tamanho = 0;
    }


    public void push(int elemento) {
        if (tamanho == elementos.length) {
            // Se a pilha estiver cheia, dobramos sua capacidade
            int[] novaArray = new int[elementos.length * 2];
            System.arraycopy(elementos, 0, novaArray, 0, elementos.length);
            elementos = novaArray;
        }
        elementos[tamanho++] = elemento;
    }


    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos[--tamanho];
    }


    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos[tamanho - 1];
    }


    public boolean isEmpty() {
        return tamanho == 0;
    }


    public int size() {
        return tamanho;
    }
}
