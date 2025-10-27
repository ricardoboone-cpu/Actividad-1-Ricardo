/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;


public class DataTypeExamples {

    public interface ContactInfo {
        String getName();
        String getAddress();
        String getPhone();
    }

    public static class Contact implements ContactInfo {
        private String name;
        private String address;
        private String phone;

        public Contact(String name, String address, String phone) {
            this.name = name;
            this.address = address;
            this.phone = phone;
        }

        public String getName() { return name; }
        public String getAddress() { return address; }
        public String getPhone() { return phone; }

        @Override
        public String toString() {
            return "Contacto: " + name + " | " + address + " | " + phone;
        }
    }

    // Demostraciones
    public static void demoPrimitives(LinkedList<Object> list) {
        list.clear();
        System.out.println("\n=== Ejemplo de tipos primitivos ===");
        list.insertEnd(25);
        list.insertEnd(3.14);
        list.insertEnd(true);
        list.insertEnd('Z');
        System.out.println(list.display());
    }

    public static void demoComplex(LinkedList<Object> list) {
        list.clear();
        System.out.println("\n=== Ejemplo de tipos complejos ===");
        list.insertEnd("Hola");
        list.insertEnd("NetBeans");
        list.insertEnd(new Contact("Juan", "Mi casa", "55-1234-5678"));
        System.out.println(list.display());
    }

    public static void demoAbstract(LinkedList<ContactInfo> list) {
        list.clear();
        System.out.println("\n=== Ejemplo de tipo abstracto (interfaz) ===");
        list.insertEnd(new Contact("Gael", "Colonia Aquinadievive 4", "555-0001"));
        list.insertEnd(new Contact("Gerardo", "Colonia Colorida 5", "555-0002"));
        System.out.println(list.display());
    }
}
