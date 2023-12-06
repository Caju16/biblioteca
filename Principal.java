package biblioteca;

import java.util.Scanner;


public class Principal {
		private static Scanner scanner = new Scanner(System.in);
		public static void main(String[] args) {
				boolean salir = false;
						while (!salir) {
							mostrarMenu();
							int opcion = scanner.nextInt();
							switch (opcion) {
						case 1:
							gestionarLibros();
							break;
						case 2:
							gestionarAutores();
							break;
						case 3:
							gestionarPrestamos();
							break;
						case 4:
							gestionarExportImportXML();
							break;
						case 5:
							salir = true;
							break;
						default:
							System.out.println("Opción no válida. Por favor, intente de nuevo.");
						}
				}
		}
		
		private static void mostrarMenu() {
			System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
			System.out.println("1. Gestionar Libros");
			System.out.println("2. Gestionar Autores");
			System.out.println("3. Gestionar Préstamos");
			System.out.println("4. Exportar/Importar Datos (XML)");
			System.out.println("5. Salir");
			System.out.print("Seleccione una opción: ");
		}
		
		private static void gestionarLibros() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("GESTIÓN DE LIBROS");
				System.out.println("1. CREAR LIBRO");
				System.out.println("2. LISTAR LIBRO");
				System.out.println("3. CAMBIAR LIBRO");
				System.out.println("4. BORRAR LIBRO");
				System.out.println("5. VOLVER AL MENÚ PPAL ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();

				switch (opcion2) {
				case 1:
					Libro.crearLibro();
					break;
				case 2:
					GestorFicheros.listarLibros();
					break;
				case 3:
					GestorFicheros.cambiarLibro();
					break;
				case 4:
					GestorFicheros.borrarLibro();
					break;
				case 5:
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCIÓN NO VÁLIDA");
				}
			}
		}		
		
		private static void gestionarAutores() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("GESTIÓN DE AUTORES");
				System.out.println("1. CREAR AUTOR");
				System.out.println("2. LISTAR AUTOR");
				System.out.println("3. CAMBIAR AUTOR");
				System.out.println("4. BORRAR AUTOR");
				System.out.println("5. VOLVER AL MENÚ PPAL ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();

				switch (opcion2) {
				case 1:
					Autor.crearAutor();
					break;
				case 2:
					GestorFicheros.listarAutor();
					break;
				case 3:
					GestorFicheros.cambiarAutor();
					break;
				case 4:
					GestorFicheros.borrarAutor();
					break;
				case 5:
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCIÓN NO VÁLIDA");
				}
			}
		}
		
		private static void gestionarPrestamos() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("GESTIÓN DE PRESTAMOS");
				System.out.println("1. CREAR PRESTAMO");
				System.out.println("2. VOLVER AL MENÚ PPAL ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();

				switch (opcion2) {
				case 1:
					GestorFicheros.crearPrestamo();
					break;
				case 2:
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCIÓN NO VÁLIDA");
				}
			}
		}
		
		private static void gestionarExportImportXML() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("GESTIÓN XML");
				System.out.println("1. EXPORTAR XML");
				System.out.println("2. IMPORTAR XML");
				System.out.println("3. VOLVER AL MENÚ PPAL ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();

				switch (opcion2) {
				case 1:
					exportarXML();
					break;
				case 2:
					importarXML();
					break;
				case 3:
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCION NO VALIDA");
				}
			}
		}
			

		private static void exportarXML() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("ELIGE EL ARCHIVO A EXPORTAR EN XML");
				System.out.println("1. LIBROS");
				System.out.println("2. AUTORES");
				System.out.println("3. VOLVER ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();

				switch (opcion2) {
				case 1:
					GestorFicheros.crearXMLLibros();
					break;
				case 2:
					GestorFicheros.crearXMLAutores();
					break;
				case 3:
					saliendo = true;
					System.out.println("VOLVIENDO");
					break;
				default:
					System.out.println("OPCION NO VALIDA");
				}
			}
		}
		
		private static void importarXML() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("ELIGE EL ARCHIVO A IMPORTAR DE XML");
				System.out.println("1. LIBROS");
				System.out.println("2. AUTORES");
				System.out.println("3. VOLVER ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();

				switch (opcion2) {
				case 1:
					GestorFicheros.importarXMLLibros();
					break;
				case 2:
					GestorFicheros.importarXMLAutores();
					break;
				case 3:
					saliendo = true;
					System.out.println("VOLVIENDO");
					break;
				default:
					System.out.println("OPCION NO VALIDA");
				}
			}
		}
		
}
