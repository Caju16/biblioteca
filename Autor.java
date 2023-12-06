package biblioteca;

import java.io.Serializable;
import java.util.Scanner;

public class Autor implements Serializable{
	private static final Scanner scanner = new Scanner(System.in);
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String nacionalidad;
	private String nacimiento;
	
	public Autor(int id, String nombre, String nacionalidad, String nacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.nacimiento = nacimiento;
	}
	
	public Autor() {
		id=0;
		nombre=" ";
		nacionalidad=" ";
		nacimiento=" ";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	public static void crearAutor() {	
		System.out.println("Introduce el id del autor \n");
		int id_a = scanner.nextInt();

		System.out.println("Introduce el nombre del autor \n");
		String nombre = scanner.next();
		
		System.out.println("Introduce la nacionalidad del autor \n");
		String nacionalidad = scanner.next();

		System.out.println("Introduce la fecha de nacimiento del autor \n");
		String nacimiento = scanner.next();
		
		Autor nuevo = new Autor(id_a, nombre, nacionalidad, nacimiento);
		
		GestorFicheros.nuevoAutor(nuevo);		
		}
	
	
	

}
