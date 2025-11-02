/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;

public class Cola<T> {
    private LinkedList<T> lista = new LinkedList<>(true);

    public void enqueue(T data) {
        lista.addLast(data);
    }

    public T dequeue() {
        return lista.removeFirst();
    }

    public T peek() {
        return lista.peekFirst();
    }

    public boolean isEmpty() {
        return lista.size() == 0;
    }
}
