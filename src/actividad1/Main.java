/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String readLine(String prompt, BufferedReader br) throws IOException {
        System.out.print(prompt);
        return br.readLine();
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("=======================================");
        System.out.println("Alumno: Ricardo Sebastián Boone Delgado");
        System.out.println("Materia: Estructuras de Datos");
        System.out.println("Profesor: Profe Paco");
        System.out.println("Proyecto: Actividad 2");
        System.out.println("=======================================");

        LinkedList<Object> lista = null;

        try {
            while (true) {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1) Crear lista simplemente enlazada");
                System.out.println("2) Crear lista doblemente enlazada");
                System.out.println("3) Insertar elemento");
                System.out.println("4) Mostrar lista");
                System.out.println("5) Buscar elemento");
                System.out.println("6) Eliminar elemento");
                System.out.println("7) Ejemplos de tipos de datos");
                System.out.println("8) Probar Pila");
                System.out.println("9) Probar Cola");
                System.out.println("0) Salir");

                String opt = readLine("Elige opción: ", br);
                if (opt.equals("0")) break;

                switch (opt) {
                    case "1":
                        lista = new LinkedList<>(false);
                        System.out.println("Lista simplemente enlazada creada.");
                        break;
                    case "2":
                        lista = new LinkedList<>(true);
                        System.out.println("Lista doblemente enlazada creada.");
                        break;
                    case "3":
                        if (lista == null) { System.out.println("Crea una lista primero."); break; }
                        String dato = readLine("Introduce un valor: ", br);
                        lista.insertEnd(dato);
                        System.out.println("Dato insertado.");
                        break;
                    case "4":
                        if (lista == null) { System.out.println("Crea una lista primero."); break; }
                        System.out.println(lista.display());
                        break;
                    case "5":
                        if (lista == null) { System.out.println("Crea una lista primero."); break; }
                        String buscar = readLine("Valor a buscar: ", br);
                        int pos = lista.search(buscar);
                        System.out.println(pos >= 0 ? "Encontrado en posición: " + pos : "No encontrado.");
                        break;
                    case "6":
                        if (lista == null) { System.out.println("Crea una lista primero."); break; }
                        String eliminar = readLine("Valor a eliminar: ", br);
                        boolean ok = lista.deleteByValue(eliminar);
                        System.out.println(ok ? "Eliminado." : "No se encontró.");
                        break;
                    case "7":
                        if (lista == null) lista = new LinkedList<>(false);
                        DataTypeExamples.demoPrimitives(lista);
                        DataTypeExamples.demoComplex(lista);
                        LinkedList<DataTypeExamples.ContactInfo> absList = new LinkedList<>(false);
                        DataTypeExamples.demoAbstract(absList);
                        break;

                    case "8":
                        System.out.println("\n=== Prueba de Pila ===");
                        Pila<String> pila = new Pila<>();
                        pila.push("A");
                        pila.push("B");
                        pila.push("C");

                        System.out.println("Peek: " + pila.peek());
                        System.out.println("Pop: " + pila.pop());
                        System.out.println("Nuevo Peek: " + pila.peek());
                        break;

                    case "9":
                        System.out.println("\n=== Prueba de Cola ===");
                        Cola<String> cola = new Cola<>();
                        cola.enqueue("Ricardo");
                        cola.enqueue("Karen");
                        cola.enqueue("Valeria");

                        System.out.println("Peek: " + cola.peek());
                        System.out.println("Dequeue: " + cola.dequeue());
                        System.out.println("Nuevo Peek: " + cola.peek());
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            }
            System.out.println("Fin del programa.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
