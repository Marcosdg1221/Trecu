package ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Funciones {

	public static void añadirProducto(String nombreProducto, Producto p, TreeSet<Producto> productos,
			double precioProducto, String tipoProducto, int diasCaducar, String tipo) {
		Scanner all = new Scanner(System.in);
		System.out.println("Introduzca el nombre del producto");
		nombreProducto = all.next();
		all.nextLine();
		p = new Producto(nombreProducto);
		if (productos.contains(p)) { // Si productos contiene un producto del mismo nombre, se cancela la opción
										// haciéndoselo saber al usuario.
			System.out.println("El producto ya existe");

		} else {
			System.out.println("Introduzca el precio del producto");
			precioProducto = all.nextDouble();
			all.nextLine();
			do {
				System.out.println("¿El producto es perecedero o noPerecedero?"); // Si no metes nada, se añade
				System.out.println("Por favor, sólo introduzca perecedero o noPerecedero"); // Condición
				// vacío extremo
				tipoProducto = all.next();
				all.nextLine();

			} while (!tipoProducto.equalsIgnoreCase("perecedero") && !tipoProducto.equalsIgnoreCase("noperecedero"));
			if (tipoProducto.equalsIgnoreCase("perecedero")) {
				System.out.println("¿Cuántos días tiene para que caduque?");
				diasCaducar = all.nextInt();
				all.nextLine();

				// Aquí ya sí que sí, dentro de p, añado en el objeto el precio y los días
				// también.

				p = new Perecedero(nombreProducto, precioProducto, diasCaducar);

			} else if (tipoProducto.equalsIgnoreCase("noperecedero")) { // Si es noPerecedero, se ejecuta esta
																		// acción
				System.out.println("Introduzca el tipo");
				tipo = all.next();
				all.nextLine();

				// Lo mismo que con Perecedero pero con tipo en lugar de los días de caducación.

				p = new NoPerecedero(nombreProducto, precioProducto, tipo);

			}
			productos.add(p);
			System.out.println("El producto se añadió");
			all.close();
		}
	}

	public static void listar(TreeSet<Producto> productos) {
		if (productos.size() == 0) {
			System.out.println("No hay productos" + "\n");
		} else {
			for (Producto i : productos) { // For each para que me vaya recorriendo la tabla de lo que contenga.
				System.out.println(i);
			}
		}
	}

	public static void eliminarProducto(TreeSet<Producto> productos, String nombreProducto, Producto p) {
		Scanner all = new Scanner(System.in);
		System.out.println("Introduzca el nombre del producto a eliminar");
		nombreProducto = all.next(); // crear un producto nombre; esto sin más te elimina el último añadido
		all.nextLine();
		p = new Producto(nombreProducto);
		if (productos.remove(p)) { // Si contiene el producto p con su nombre, no se hace nada, si no, se
									// elimina
			System.out.println("Producto eliminado" + "\n");
		} else {
			System.out.println("El producto no existe");
		}
		all.close();
	}

	public static void modificarProducto(String nombreProducto, Producto p, TreeSet<Producto> productos,
			double precioProducto) {
		Scanner all = new Scanner(System.in);
		System.out.println("Introduzca el nombre del producto a modificar");
		nombreProducto = all.next();
		int opcion2 = 0; // Importante tener esto para después preguntar qué se quiere modificar
		all.nextLine();
		p = new Producto(nombreProducto);
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
						opcion2 = all.nextInt();
						all.nextLine();
					} while (opcion2 != 1 && opcion2 != 2);

					if (opcion2 == 1) { // Modificar el precio del producto
						System.out.println("Introduzca el precio");
						product.setPrecio(all.nextDouble());
						System.out.println("producto modificado");
					} else {
						if (product instanceof Perecedero) {
							System.out.println("Introduzca los días a caducar");
							Perecedero per = (Perecedero) product;
							per.setDíasCaducar(all.nextInt());
							System.out.println("producto modificado");
						} else if (product instanceof NoPerecedero) {
							System.out.println("Introduzca el tipo");
							NoPerecedero noper = (NoPerecedero) product;
							noper.setTipo(all.next());
							System.out.println("producto modificado");
						}
					}

				}
				all.close();
			}
		} else {
			System.out.println("El producto no existe");
		}
	}

	public static void guardar(TreeSet<Producto> productos)  {
		String linea = ""; // Es lo que se guardará en "archivo de texto"
		String[] datos=linea.split(";");
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
					int diasACaducar=Integer.parseInt(datos[2]);
					
					//pr=new Perecedero(nombreProducto, precio, diasACaducar);
				}
				catch(NumberFormatException e) {
					//pr=new NoPerecedero(nombreProducto, precio, tipoProducto);
				}
				finally {
					productos.add(pr);
				}
				
				bw.write(linea);
				bw.newLine();
				//linea = ""; // Lo fijo a línea vacía para que en la siguiente no me vuelva a poner el
							// producto anterior
			}
			System.out.println("Guardado con éxito");
			bw.flush(); // ¿Poner en "finally"?
			bw.close();
		} catch (IOException e) {
			System.out.println("El fichero tuvo un error");
		}
	}
}