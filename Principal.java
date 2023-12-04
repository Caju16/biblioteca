package biblioteca;

import java.util.Scanner;
//Importar otras clases necesarias


public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static gestionficheros gestorFicheros = new gestionficheros();
    private static libro biblioteca = new libro();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
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
                    gestionarExportarXML();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
        System.out.println("1. Gestionar Libros");
        System.out.println("2. Gestionar Autores");
        System.out.println("3. Gestionar Préstamos");
        System.out.println("4. Exportar a XML");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void gestionarLibros() {
        boolean salirLibros = false;
        while (!salirLibros) {
            mostrarMenuLibros();
            int opcionLibros = scanner.nextInt();
            switch (opcionLibros) {
                case 1:
                    leerLibro();
                    break;
                case 2:
                    actualizarLibro();
                    break;
                case 3:
                    eliminarLibro();
                    break;
                case 4:
                    salirLibros = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void mostrarMenuLibros() {
        System.out.println("\nGestión de Libros:");
        System.out.println("1. Leer Libro");
        System.out.println("2. Actualizar Libro");
        System.out.println("3. Eliminar Libro");
        System.out.println("4. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void leerLibro() {
        
       
    }

    private static void actualizarLibro() {
       
        
    }

    private static void eliminarLibro() {
        
       
    }

    private static void gestionarAutores() {
        boolean salirAutores = false;
        while (!salirAutores) {
            mostrarMenuAutores();
            int opcionAutores = scanner.nextInt();
            switch (opcionAutores) {
                case 1:
                    leerAutor();
                    break;
                case 2:
                    actualizarAutor();
                    break;
                case 3:
                    eliminarAutor();
                    break;
                case 4:
                    salirAutores = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void mostrarMenuAutores() {
        System.out.println("\nGestión de Autores:");
        System.out.println("1. Leer Autor");
        System.out.println("2. Actualizar Autor");
        System.out.println("3. Eliminar Autor");
        System.out.println("4. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void leerAutor() {
        
       
    }

    private static void actualizarAutor() {
        
        
    }

    private static void eliminarAutor() {
        
        
    }

    private static void gestionarPrestamos() {
        boolean salirPrestamos = false;
        while (!salirPrestamos) {
            mostrarMenuPrestamos();
            int opcionPrestamos = scanner.nextInt();
            switch (opcionPrestamos) {
                case 1:
                    gestionarPrestamo();
                    break;
                case 2:
                    gestionarDevolucion();
                    break;
                case 3:
                    salirPrestamos = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void mostrarMenuPrestamos() {
        System.out.println("\nGestión de Préstamos:");
        System.out.println("1. Gestionar Préstamo");
        System.out.println("2. Gestionar Devolución");
        System.out.println("3. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void gestionarPrestamo() {
        
    }

    private static void gestionarDevolucion() {
        
    }

    private static void gestionarExportarXML() {
    	 boolean salirMenuXML = false;
         while (!salirMenuXML) {
             mostrarMenuXML();
             int opcionXML = scanner.nextInt();
             switch (opcionXML) {
                 case 1:
                     gestionarImportar();
                     break;
                 case 2:
                     gestionarExportar();
                     break;
                 case 3:
                     salirMenuXML = true;
                     break;
                 default:
                     System.out.println("Opción no válida. Por favor, intente de nuevo.");
             }
         }
     }

     private static void mostrarMenuXML() {
         System.out.println("\nImportar/Exportar XML:");
         System.out.println("1. Importar XML");
         System.out.println("2. Exportar XML");
         System.out.println("3. Volver al Menú Principal");
         System.out.print("Seleccione una opción: ");
     }

     private static void gestionarImportar() {
         
     }

     private static void gestionarExportar() {
         
     }
 }