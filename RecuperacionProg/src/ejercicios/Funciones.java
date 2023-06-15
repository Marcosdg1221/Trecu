package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class Funciones {

	

	public static void añadirProducto(TreeSet<Producto> productos) {
		
		String nombreProducto;
		double precioProducto;
		String tipoProducto;
		int diasCaducar;
		String tipo;
		System.out.println("Introduzca el nombre del producto");
		nombreProducto = Main.all.next();
		Main.all.nextLine();
		Producto p = new Producto(nombreProducto);
		if (productos.contains(p)) { // Si productos contiene un producto del mismo nombre, se cancela la opción
										// haciéndoselo saber al usuario.
			System.out.println("El producto ya existe");

		} else {
			System.out.println("Introduzca el precio del producto");
			precioProducto = Main.all.nextDouble();
			Main.all.nextLine();
			do {
				System.out.println("¿El producto es perecedero o noPerecedero?"); // Si no metes nada, se añade
				System.out.println("Por favor, sólo introduzca perecedero o noPerecedero"); // Condición
				// vacío extremo
				tipoProducto = Main.all.next();
				Main.all.nextLine();

			} while (!tipoProducto.equalsIgnoreCase("perecedero") && !tipoProducto.equalsIgnoreCase("noperecedero"));
			if (tipoProducto.equalsIgnoreCase("perecedero")) {
				System.out.println("¿Cuántos días tiene para que caduque?");
				diasCaducar = Main.all.nextInt();
				Main.all.nextLine();

				// Aquí ya sí que sí, dentro de p, añado en el objeto el precio y los días
				// también.

				p = new Perecedero(nombreProducto, precioProducto, diasCaducar);

			} else if (tipoProducto.equalsIgnoreCase("noperecedero")) { // Si es noPerecedero, se ejecuta esta
																		// acción
				System.out.println("Introduzca el tipo");
				tipo = Main.all.next();
				Main.all.nextLine();

				// Lo mismo que con Perecedero pero con tipo en lugar de los días de caducación.

				p = new NoPerecedero(nombreProducto, precioProducto, tipo);

			}
			productos.add(p);
			System.out.println("El producto se añadió");
		}
	}

	public static void listar(TreeSet<Producto> productos) {
		if (productos.size() == 0) {
			System.out.println("No hay productos" + "\n");
		} else {
			for (Producto i : productos) { // For each para que me vaya recorriendo la tabla de lo que contenga.
				System.out.println(i);
				System.out.println();
			}
		}
	}

	public static void eliminarProducto(TreeSet<Producto> productos) {
		String nombreProducto;
		System.out.println("Introduzca el nombre del producto a eliminar");
		nombreProducto = Main.all.next(); // crear un producto nombre; esto sin más te elimina el último añadido
		Main.all.nextLine();
		Producto p = new Producto(nombreProducto);
		if (productos.remove(p)) { // Si contiene el producto p con su nombre, no se hace nada, si no, se
									// elimina
			System.out.println("Producto eliminado" + "\n");
		} else {
			System.out.println("El producto no existe");
		}
	}

	public static void modificarProducto(TreeSet<Producto> productos) {
		String nombreProducto;
		System.out.println("Introduzca el nombre del producto a modificar");
		nombreProducto = Main.all.next();
		int opcion2 = 0; // Importante tener esto para después preguntar qué se quiere modificar
		Main.all.nextLine();
		Producto p = new Producto(nombreProducto);
		if (productos.contains(p)) { // ?
			System.out.println("¿Qué dato del producto desea modificar?");

			System.out.println("1. El precio del producto"); // Esto se va a imprimir sí o sí en ambos tipos del
																// producto
			for (Producto product : productos) {
				if (product.equals(p)) { // Comprueba si algún producto es equivalente al nombre que se
											// introdujo

					if (product instanceof NoPerecedero) { // Si NO es perecedero

						System.out.println("2.El tipo");
					} else if (product instanceof Perecedero) {
						System.out.println("2. Los días de caducidad");
					}
					// Acaba el menú aquí

					// Comprobación de la opción elegida
					do {
						if (opcion2 != 0) { // Para que en la primera vez no imprima opción no válida sin que el
											// usuario no haya puesto nada.
							System.out.println("opción no válida");
						}
						opcion2 = Main.all.nextInt();
						Main.all.nextLine();
					} while (opcion2 != 1 && opcion2 != 2);

					if (opcion2 == 1) { // Modificar el precio del producto
						System.out.println("Introduzca el precio");
						product.setPrecio(Main.all.nextDouble());
						System.out.println("producto modificado");
					} else {
						if (product instanceof Perecedero) {
							System.out.println("Introduzca los días a caducar");
							Perecedero per = (Perecedero) product;
							per.setDíasCaducar(Main.all.nextInt());
							System.out.println("producto modificado");
						} else if (product instanceof NoPerecedero) {
							System.out.println("Introduzca el tipo");
							NoPerecedero noper = (NoPerecedero) product;
							noper.setTipo(Main.all.next());
							System.out.println("producto modificado");
						}
					}

				}
			}
		} else {
			System.out.println("El producto no existe");
		}
	}

	public static void guardar(TreeSet<Producto> productos) {
		String linea = ""; // Es lo que se guardará en "archivo de texto"

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.txt"));
			for (Producto pr : productos) { // For each para que me vaya recorriendo la tabla de lo que contenga.
				linea = pr.getNombre() + ";" + pr.getPrecio() + ";";
				if (pr instanceof Perecedero) {
					linea += ((Perecedero) pr).getDíasCaducar();
					
				} else {
					linea += ((NoPerecedero) pr).getTipo();
				}
				try {
					String[] datos = linea.split(";");
					int diasACaducar = Integer.parseInt(datos[2]);

					// pr=new Perecedero(nombreProducto, precio, diasACaducar);
				} catch (NumberFormatException e) {
					// pr=new NoPerecedero(nombreProducto, precio, tipoProducto);
				} finally {
					productos.add(pr);
				}

				bw.write(linea);
				bw.newLine();
				// linea = ""; // Lo fijo a línea vacía para que en la siguiente no me vuelva a
				// poner el
				// producto anterior
			}
			System.out.println("Guardado con éxito");
			bw.flush(); // ¿Poner en "finally"?
			bw.close();
		} catch (IOException e) {
			System.out.println("El fichero tuvo un error");
		}
	}

	public static TreeSet<Producto> lecturaFichero() {
		TreeSet<Producto> productos = new TreeSet<Producto>();
		try {
			Producto p=null;
			String[] datos = new String[2];
			BufferedReader br = new BufferedReader(new FileReader("archivo.txt"));
			String linea = br.readLine();
			while (linea != null) {
				datos = linea.split(";");
				String nombre = datos[0];
				Double precio = Double.parseDouble(datos[1]);
				try {
					// Si no hay error es perecedero
					int diasACaducar = Integer.parseInt(datos[2]);
					p = new Perecedero(nombre, precio, diasACaducar);
					//linea = (p + "");
				} catch (NumberFormatException ex) {
					// Cuando sé que el producto es no perecedero
					String tipo = datos[2];
					p = new NoPerecedero(nombre, precio, tipo);
					//linea = (p + "");
				} finally {
					productos.add(p);
				}
				linea = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error en el fichero");
		}
		return productos;
	}
}
