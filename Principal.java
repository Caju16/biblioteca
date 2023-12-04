package biblioteca;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


//Importar otras clases necesarias
public class Principal {
		private static Scanner scanner = new Scanner(System.in);
		private static GestorFicheros gestorFicheros = new GestorFicheros();
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
							//Gestionar autores
							//gestionarAutores();
							break;
						case 3:
							//Gestionar préstamos
							//gestionarPrestamos();
							break;
						case 4:
							//Exportar/Importar datos con XML
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
					Libro.listarLibros();
					break;
				case 3:
					cambiarLibro();
					break;
				case 4:
					borrarLibro();
					break;
				case 5:
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCION NO VALIDA");
				}
			}
		}
		
		private static void borrarLibro() {
			// TODO Auto-generated method stub
			
		}
		private static void cambiarLibro() {
			// TODO Auto-generated method stub
			
		}
		
		

		
		/*private static void gestionarAutores() {
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
					crearLibro();
					break;
				case 2:
					listarLibro();
					break;
				case 3:
					cambiarLibro();
					break;
				case 4:
					borrarLibro();
					break;
				case 5:
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCION NO VALIDA");
				}
			}
		}
		private static void gestionarPrestamos() {
			boolean saliendo = false;
			while (!saliendo) {
				System.out.println("GESTIÓN DE PRESTAMOS");
				System.out.println("1. CREAR PRESTAMO");
				System.out.println("2. LISTAR PRESTAMO");
				System.out.println("3. CAMBIAR PRESTAMO");
				System.out.println("4. BORRAR PRESTAMO");
				System.out.println("5. VOLVER AL MENÚ PPAL ");
				System.out.print("Seleccione una opción: ");

				int opcion2 = scanner.nextInt();

				switch (opcion2) {
				case 1:
					crearLibro();
					break;
				case 2:
					listarLibro();
					break;
				case 3:
					cambiarLibro();
					break;
				case 4:
					borrarLibro();
					break;
				case 5:
					saliendo = true;
					System.out.println("SALIENDO");
					break;
				default:
					System.out.println("OPCION NO VALIDA");
				}
			}
		}*/
		
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
					GestorFicheros.crearXML();
					break;
				case 2:
					Libro.listarLibros();
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
		
}
