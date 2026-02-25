package Agenda;

import java.util.HashMap;


public class Agenda {
    // Definimos el HashMap y una variable para controlar el límite
    private HashMap<String, Contacto> contactos;
    private int capacidadMaxima;

    // Constructor 1: Indica el tamaño de la agenda
    public Agenda() {
        this.contactos = new HashMap<>();
        this.capacidadMaxima = 10; 
    }

    public Agenda(int tamaño) {
        this.contactos = new HashMap<>();
        this.capacidadMaxima = tamaño;
    }

    // Genera clave para el hashmap
    private String generarClave(String nombre) {
        return nombre.toLowerCase();
    }

    // Indica si ya existe este contacto
    public boolean existeContacto(Contacto c) {
        return contactos.containsKey(generarClave(c.getNombre()));
    }

    // Espacios libres restantes
    public int espacioLibres() {
        return capacidadMaxima - contactos.size();
    }

    // Indica si la agenda está llena
    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    // Agreaga el contancto verificando si hay espacios libres o si esta duplicado
    public void añadirContacto(Contacto c) {
        if (existeContacto(c)) {
            System.out.println("❌ No se puede añadir: Ya existe un contacto con el nombre '" + c.getNombre() + "'.");
            return;
        }
        if (agendaLlena()) {
            System.out.println("❌ No se puede añadir: La agenda está llena.");
            return;
        }

        // Si pasa las validaciones, lo agregamos al hashMap
        contactos.put(generarClave(c.getNombre()), c);
        System.out.println("✅ Contacto añadido correctamente.");
    }

    // Lista toda la agenda
    public void listarContactos() {
        System.out.println("\n--- Lista de Contactos ---");
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            // Recorremos los valores del HashMap
            for (Contacto c : contactos.values()) {
                System.out.println(c.toString());
            }
        }
        System.out.println("--------------------------");
    }

    // Busca un contacto por su nombre y muestra su teléfono
    public void buscaContacto(String nombre) {
        String clave = generarClave(nombre);
        if (contactos.containsKey(clave)) {
            Contacto c = contactos.get(clave);
            System.out.println("📞 El teléfono de " + c.getNombre() + " es: " + c.getTelefono());
        } else {
            System.out.println("❌ No se ha encontrado ningún contacto con el nombre '" + nombre + "'.");
        }
    }

    // Elimina el contacto de la agenda
    public void eliminarContacto(Contacto c) {
        String clave = generarClave(c.getNombre());
        
        // El método remove del HashMap devuelve el objeto eliminado, o null si no existía
        if (contactos.remove(clave) != null) {
            System.out.println("✅ El contacto ha sido eliminado exitosamente.");
        } else {
            System.out.println("❌ No se ha podido eliminar: El contacto no existe en la agenda.");
        }
    }
}