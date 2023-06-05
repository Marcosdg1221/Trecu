package ejercicios;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		String nombreProducto = "";
		String tipoProducto = "";
		double precioProducto = 0;
		int diasCaducar = 0;
		String tipo = "";
		int opcion;
		Producto p = null; // Sólo se necesita el nombre del producto de momento en el objeto.
		TreeSet<Producto> productos = new TreeSet<Producto>();
		Scanner all = new Scanner(System.in);

		do {
			System.out.println("1. Añadir producto" + "\n" + "2.Listar productos" + "\n" + "3.Eliminar producto" + "\n"
					+ "0.Salir");
			opcion = all.nextInt();
			all.nextLine();
			switch (opcion) {
			case 1:
				System.out.println("¿El producto es perecedero o noPerecedero?"); //Si no metes nada, se añade al vacío extremo
				tipoProducto = all.next();
				all.nextLine();
				//TODO metes la comprobación en un do while, porque no estás comprobando si el usuario mete cualquier otra cosa que no sea perecedero o noperecedero
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
					if (tipoProducto.equalsIgnoreCase("perecedero")) {
						System.out.println("¿Cuántos días tiene para que caduque?");
						diasCaducar = all.nextInt();
						all.nextLine();

						// Aquí ya sí que sí, dentro de p, añado en el objeto el precio y los días
						// también.

						p = new Perecedero(nombreProducto, precioProducto, diasCaducar);

						// Añadir producto

						productos.add(p);
					} else if (tipoProducto.equalsIgnoreCase("noperecedero")) { // Si es noPerecedero, se ejecuta esta
																				// acción
						System.out.println("Introduzca el tipo");
						tipo = all.next();
						all.nextLine();

						// Lo mismo que con Perecedero pero con tipo en lugar de los días de caducación.

						p = new NoPerecedero(nombreProducto, precioProducto, tipo);

						// Añadir producto

						productos.add(p);
					}
					System.out.println("El producto se añadió");
					break;
				}

			case 2: // Esto simplemente imprime la lista de los productos.
				if (productos.size() == 0) {
					System.out.println("No hay productos" + "\n");
				} else {
					for (Producto i : productos) { // For each para que me vaya recorriendo la tabla de lo que contenga.
						System.out.println(i);
					}
				}
				break;

			case 3:
				System.out.println("Introduzca el nombre del producto a eliminar");
				nombreProducto = all.next(); //crear un producto nombre; esto sin más te elimina el último añadido
				all.nextLine();
				if (productos.remove(p)) { // Si contiene el producto p con su nombre, no se hace nada, si no, se
												// elimina
					System.out.println("Producto eliminado" + "\n");
				} else {
					System.out.println("El producto no existe");
				}
				break;
			case 0: // Sale con la opción 0
				System.out.println("Salida");
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (opcion != 0);
		all.close();
	}
}