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
		Scanner all = new Scanner(System.in);
		TreeSet<Producto> productos = new TreeSet<Producto>();

		do {
			System.out.println("1. Añadir producto" + "\n" + "2.Listar productos" + "\n" + "3.Eliminar producto" + "\n" + "0.Salir");
			opcion = all.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("¿El producto es perecedero o noPerecedero?");
				tipoProducto = all.next();
				System.out.println("Introduzca el nombre del producto");
				nombreProducto = all.next();
				if (productos.contains(nombreProducto)) {
					System.out.println("El producto ya existe");
				} else {
					System.out.println("Introduzca el precio del producto");
					precioProducto = all.nextDouble();
					if (tipoProducto.equalsIgnoreCase("perecedero")) {
						System.out.println("¿Cuántos días tiene para que caduque?");
						diasCaducar = all.nextInt();
						Perecedero producto = new Perecedero(nombreProducto, precioProducto, diasCaducar);
						productos.add(producto);
					} else if (tipoProducto.equalsIgnoreCase("noperecedero")) {
						System.out.println("Introduzca el tipo");
						tipo = all.next();
						NoPerecedero producto = new NoPerecedero(nombreProducto, precioProducto, tipo);
						productos.add(producto);
					}
					System.out.println("El producto se añadió");
					break;
				}

			case 2:
				System.out.println(productos);
				break;

			case 3:
				System.out.println("Introduzca el nombre del producto a eliminar");
				nombreProducto = all.next();
				productos.remove();
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (opcion != 0);
		all.close();
	}
}