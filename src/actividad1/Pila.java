/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;

public class Pila<T> {
    private LinkedList<T> lista = new LinkedList<>(false);

    public void push(T data) {
        lista.insertFront(data);
    }

    public T pop() {
        return lista.removeFirst();
    }

    public T peek() {
        return lista.peekFirst();
    }

    public boolean isEmpty() {
        return lista.size() == 0;
    }
}
