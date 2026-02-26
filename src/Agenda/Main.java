package Agenda;

import java.util.Scanner;

public class Main {
		public static void main (String[] args) {
			Scanner scanner = new Scanner(System.in);
			Agenda miAgenda = new Agenda();
			boolean salir = false;
			
			
			while (!salir) {
				System.out.println("1.- Añadir contacto");
				System.out.println("2.- Lista de contactos");
				System.out.println("3.- Buscar contacto");
				System.out.println("4.- Comprobar si existe el contacto");
				System.out.println("5.- Eliminar contacto");
				System.out.println("6.- Comprobar espacio disponible");
				System.out.println("7.- Cuantos espacios disponibles hay");
				System.out.println("8.- Salir");
				
				int opcion = scanner.nextInt();
				scanner.nextLine();
				
				String nombre;
				String telefono;
				Contacto c;
				
				switch(opcion) {
				case 1:
					System.out.print("Introduce el nombre: ");
					nombre = scanner.nextLine();
					System.out.print("Introduce el numero de telefono: ");
					telefono = scanner.nextLine();
					c = new Contacto(nombre, telefono);
					miAgenda.añadirContacto(c);
					break;
				case 2:
					miAgenda.listarContactos();
					break;
				case 3:
					System.out.print("Buscar contacto: ");
					nombre = scanner.nextLine();
					miAgenda.buscaContacto(nombre);
					break;
				case 4:
					System.out.print("Introducir el contacto a comprobar: ");
					nombre = scanner.nextLine();
					c = new Contacto(nombre,"");
					if (miAgenda.existeContacto(c)) {
						System.out.println("El contacto ya existe");
					} else {
						System.out.println("El contacton no existe");
					}
					break;
				case 5: 
					 System.out.print("Nombre del contacto que deseas eliminar: ");
					 nombre = scanner.nextLine();
					 c = new Contacto(nombre, "");
					 miAgenda.eliminarContacto(c);
					 break;
				case 6:
					if (miAgenda.agendaLlena()) {
					System.out.println("La ageenda esta llena!");
					} else {
						System.out.println("Usted tiene espacios en la agenda disponibles");
					}
					break;
				case 7:
					System.out.println("Usted tiene " + miAgenda.espacioLibres() + " espacios libres en su agenda");
					break;

				case 8:
					salir = true;
					System.out.println("Saliendo de la agenda");
					break;
				default:
					System.out.println("Opcion invalida. Por favor, ingrese un numero del 1 al 8.");
				}
		}
			scanner.close();
}
}
