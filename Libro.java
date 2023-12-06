package biblioteca;

import java.io.Serializable;
import java.util.Scanner;

public class Libro implements Serializable {
	private static final Scanner scanner = new Scanner(System.in);
	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private String autor;
	private String publicacion;
	private String genero;

	public Libro(int id, String titulo, String autor, String publicacion, String genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.publicacion = publicacion;
		this.genero = genero;
	}
	
	public Libro() {
		id=0;
		titulo=" ";
		autor=" ";
		publicacion=" ";
		genero=" ";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
	}
	
	public String getPublicacion() {
		return publicacion;
	}

	public void publicacion(String publicacion) {
		this.publicacion = publicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public static void crearLibro() {
			System.out.println("Introduce el id del libro \n");
			int id_l = scanner.nextInt();

			System.out.println("Introduce el título del libro \n");
			String titulo = scanner.next();
			
			System.out.println("Introduce el id del autor \n");
			String autor = scanner.next();

			System.out.println("Introduce la fecha de publicación del libro \n");
			String publicacion = scanner.next();

			System.out.println("Introduce el género del libro \n");
			String genero = scanner.next();
			
			Libro nuevo = new Libro(id_l, titulo, autor, publicacion, genero);
			
			GestorFicheros.nuevoLibro(nuevo);		
			}


}
