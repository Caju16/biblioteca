package biblioteca;

import java.io.Serializable;

public class Prestamo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idLibro;
	private String nombreUsuario;
	private String fPrestamo;
	private String fDevolucion;
	
	public Prestamo(int idLibro, String nombreUsuario, String fPrestamo, String fDevolucion) {
		super();
		this.idLibro = idLibro;
		this.nombreUsuario = nombreUsuario;
		this.fPrestamo = fPrestamo;
		this.fDevolucion = fDevolucion;
	}
	
	public Prestamo() {
		idLibro=0;
		nombreUsuario=" ";
		fPrestamo=" ";
		fDevolucion=" ";
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getfPrestamo() {
		return fPrestamo;
	}

	public void setfPrestamo(String fPrestamo) {
		this.fPrestamo = fPrestamo;
	}

	public String getfDevolucion() {
		return fDevolucion;
	}

	public void setfDevolucion(String fDevolucion) {
		this.fDevolucion = fDevolucion;
	}
	

	
	
	
}
