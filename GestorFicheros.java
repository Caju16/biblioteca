package biblioteca;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GestorFicheros {
	private static final List<Libro> listaLibros = new ArrayList<>();
	private static final List<Autor> listaAutores = new ArrayList<>();
	private static final List<Prestamo> listaPrestamos = new ArrayList<>();
	private static final Scanner scanner = new Scanner(System.in);

	public static void nuevoLibro(Libro nuevo) {

		try {
			FileOutputStream fos = new FileOutputStream("Libro.bin", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(nuevo);
			oos.close();

			listaLibros.add(nuevo);
			System.out.println("Libro creado.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void listarLibros() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Libro.bin"))) {
			System.out.println("\nListado de Libros");
			for (Libro libro : listaLibros) {
				System.out.println(
						"ID: " + libro.getId() + ", Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor()
								+ ", Publicación: " + libro.getPublicacion() + ", Género: " + libro.getGenero());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void cambiarLibro() {
		System.out.println("Introduce el ID del libro:");
		int idBuscado = scanner.nextInt();

		boolean libroEncontrado = false;

		for (Libro libro : listaLibros) {
			if (libro.getId() == idBuscado) {
				libroEncontrado = true;
				System.out.println("Libro encontrado: " + libro.getTitulo());

				System.out.println("Ingrese el nuevo título: ");
				String nuevoTitulo = scanner.next();

				System.out.println("Ingrese el nuevo autor: ");
				String nuevoAutor = scanner.next();

				System.out.println("Ingrese el nuevo publicación: ");
				String nuevoPublicacion = scanner.next();

				System.out.println("Ingrese el nuevo género: ");
				String nuevoGenero = scanner.next();

				libro.setTitulo(nuevoTitulo);
				libro.setAutor(nuevoAutor);
				libro.setPublicacion(nuevoPublicacion);
				libro.setGenero(nuevoGenero);

				System.out.println("Libro actualizado: " + libro.getTitulo());
				return;
			}
		}

		if (!libroEncontrado) {
			System.out.println("LIBRO NO ENCONTRADO");
		}

	}

	public static void borrarLibro() {
		;
		System.out.println("Introduce el ID del libro:");
		int idBuscado = scanner.nextInt();

		boolean libroEncontrado = false;

		for (Libro libro : listaLibros) {
			if (libro.getId() == idBuscado) {
				libroEncontrado = true;
				System.out.println("Libro encontrado: " + libro.getTitulo());
				listaLibros.remove(libro);
				return;
			}
		}

		if (!libroEncontrado) {
			System.out.println("LIBRO NO ENCONTRADO");
		}
	}

	public static void nuevoAutor(Autor nuevo) {

		try {
			FileOutputStream fos = new FileOutputStream("Autor.bin", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(nuevo);
			oos.close();

			listaAutores.add(nuevo);
			System.out.println("Autor creado.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void listarAutor() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Autor.bin"))) {
			System.out.println("\nListado de Autores:");
			for (Autor autor : listaAutores) {
				System.out.println("ID: " + autor.getId() + ", Nombre: " + autor.getNombre() + ", Nacionalidad: "
						+ autor.getNacionalidad() + ", Nacimiento: " + autor.getNacimiento());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void cambiarAutor() {
		System.out.println("Introduce el ID del autor:");
		int idBuscado = scanner.nextInt();

		boolean autorEncontrado = false;

		for (Autor autor : listaAutores) {
			if (autor.getId() == idBuscado) {
				autorEncontrado = true;
				System.out.println("Autor encontrado: " + autor.getNombre());

				System.out.println("Ingrese el nuevo nombre: ");
				String nuevoNombre = scanner.next();

				System.out.println("Ingrese la nueva nacionalidad: ");
				String nuevoNacionalidad = scanner.next();

				System.out.println("Ingrese la fecha de nacimiento: ");
				String nuevoNacimiento = scanner.next();

				autor.setNombre(nuevoNombre);
				autor.setNacionalidad(nuevoNacionalidad);
				autor.setNacimiento(nuevoNacimiento);

				System.out.println("Autor actualizado: " + autor.getNombre());
				return;
			}
		}

		if (!autorEncontrado) {
			System.out.println("AUTOR NO ENCONTRADO");
		}

	}

	public static void borrarAutor() {
		;
		System.out.println("Introduce el ID del autor:");
		int idBuscado = scanner.nextInt();

		boolean autorEncontrado = false;

		for (Autor autor : listaAutores) {
			if (autor.getId() == idBuscado) {
				autorEncontrado = true;
				System.out.println("Autor borrado: " + autor.getNombre());
				listaAutores.remove(autor);
				return;
			}
		}

		if (!autorEncontrado) {
			System.out.println("AUTOR NO ENCONTRADO");
		}
	}

	public static void crearPrestamo() {

		System.out.println("Introduce el id del libro \n");
		int idLibro = scanner.nextInt();

		boolean libroEncontrado = false;

		for (Libro libro : listaLibros) {

			if (libro.getId() == idLibro) {
				libroEncontrado = true;

				System.out.println("Introduce el nombre del usuario \n");
				String nombreUsuario = scanner.next();

				System.out.println("Introduce la fecha del préstamo \n");
				String fPrestamo = scanner.next();

				System.out.println("Introduce la fecha de la devolución \n");
				String fDevolucion = scanner.next();

				Prestamo nuevo = new Prestamo(idLibro, nombreUsuario, fPrestamo, fDevolucion);

				nuevoPrestamo(nuevo);

			}
		}

		if (!libroEncontrado) {
			System.out.println("EL LIBRO NO EXISTE");
		}
	}

	public static void nuevoPrestamo(Prestamo nuevo) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Prestamo.txt", true))) {
			writer.write("Id del Libro: " + nuevo.getIdLibro());
			writer.newLine();
			writer.write("Nombre del usuario que lo solicita: " + nuevo.getNombreUsuario());
			writer.newLine();
			writer.write("Fecha del préstamo: " + nuevo.getfPrestamo());
			writer.newLine();
			writer.write("Fecha de la devolución: " + nuevo.getfDevolucion());
			writer.newLine();
			writer.newLine();

			listaPrestamos.add(nuevo);
			System.out.println("Prestamo creado.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void crearXMLLibros() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("libros");
			doc.appendChild(rootElement);

			for (Libro nuevo : listaLibros) {
				Element libroElement = doc.createElement("libro");
				rootElement.appendChild(libroElement);

				Element idElement = doc.createElement("id");
				idElement.appendChild(doc.createTextNode(String.valueOf(nuevo.getId())));
				libroElement.appendChild(idElement);

				Element tituloElement = doc.createElement("titulo");
				tituloElement.appendChild(doc.createTextNode(nuevo.getTitulo()));
				libroElement.appendChild(tituloElement);

				Element autorElement = doc.createElement("autor");
				autorElement.appendChild(doc.createTextNode(nuevo.getAutor()));
				libroElement.appendChild(autorElement);

				Element publicacionElement = doc.createElement("publicacion");
				publicacionElement.appendChild(doc.createTextNode(nuevo.getPublicacion()));
				libroElement.appendChild(publicacionElement);

				Element generoElement = doc.createElement("genero");
				generoElement.appendChild(doc.createTextNode(nuevo.getGenero()));
				libroElement.appendChild(generoElement);

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("libros.xml"));
			transformer.transform(source, result);

			System.out.println("EXPORTACIÓN REALIZADA");

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void crearXMLAutores() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("autores");
			doc.appendChild(rootElement);

			for (Autor nuevo : listaAutores) {
				Element autorElement = doc.createElement("autor");
				rootElement.appendChild(autorElement);

				Element idElement = doc.createElement("id");
				idElement.appendChild(doc.createTextNode(String.valueOf(nuevo.getId())));
				autorElement.appendChild(idElement);

				Element nombreElement = doc.createElement("nombre");
				nombreElement.appendChild(doc.createTextNode(nuevo.getNombre()));
				autorElement.appendChild(nombreElement);

				Element nacionalidadElement = doc.createElement("nacionalidad");
				nacionalidadElement.appendChild(doc.createTextNode(nuevo.getNacionalidad()));
				autorElement.appendChild(nacionalidadElement);

				Element nacimientoElement = doc.createElement("nacimiento");
				nacimientoElement.appendChild(doc.createTextNode(nuevo.getNacimiento()));
				autorElement.appendChild(nacimientoElement);

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("autores.xml"));
			transformer.transform(source, result);

			System.out.println("EXPORTACIÓN REALIZADA");

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void importarXMLLibros() {
		try {
			File xmlFile = new File("libros.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			NodeList nodeList = doc.getElementsByTagName("libro");

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Libro.bin"))) {
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
						String titulo = element.getElementsByTagName("titulo").item(0).getTextContent();
						String autor = element.getElementsByTagName("autor").item(0).getTextContent();
						String publicacion = element.getElementsByTagName("publicacion").item(0).getTextContent();
						String genero = element.getElementsByTagName("genero").item(0).getTextContent();

						oos.writeInt(id);
						oos.writeObject(titulo);
						oos.writeObject(autor);
						oos.writeObject(publicacion);
						oos.writeObject(genero);

						Libro nuevoLibro = new Libro(id, titulo, autor, publicacion, genero);

						oos.writeObject(nuevoLibro);

						listaLibros.add(nuevoLibro);

					}
				}
				System.out.println("Conversión exitosa: XML a binario.");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void importarXMLAutores() {
		try {
			File xmlFile = new File("autores.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			NodeList nodeList = doc.getElementsByTagName("autor");

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Autor.bin"))) {
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
						String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
						String nacionalidad = element.getElementsByTagName("nacionalidad").item(0).getTextContent();
						String nacimiento = element.getElementsByTagName("nacimiento").item(0).getTextContent();

						oos.writeInt(id);
						oos.writeObject(nombre);
						oos.writeObject(nacionalidad);
						oos.writeObject(nacimiento);

						Autor nuevoAutor = new Autor(id, nombre, nacionalidad, nacimiento);

						oos.writeObject(nuevoAutor);

						listaAutores.add(nuevoAutor);

					}
				}
				System.out.println("Conversión exitosa: XML a binario.");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
