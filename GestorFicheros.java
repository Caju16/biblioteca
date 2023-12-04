package biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GestorFicheros {
	private static final List<Libro> listaLibros = new ArrayList<>();
	
	public static void nuevoLibro(Libro Libro) {
		
		try {
			FileOutputStream fos = new FileOutputStream("Libro.bin", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Libro);
			oos.close();
			
			listaLibros.add(Libro);
			System.out.println("Libro creado.");

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void listarLibros() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Libro.bin"))) {
        	System.out.println("\nListado de Libros");
            for (Libro libro : listaLibros) {
                System.out.println("ID: " + libro.getId() + ", Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor() + ", Publicación: " + libro.getPublicacion() + ", Género: " + libro.getGenero());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void crearXML() {
		
	}



}