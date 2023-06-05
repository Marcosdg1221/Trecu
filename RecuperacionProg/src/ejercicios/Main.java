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
		Producto p = new Producto(nombreProducto); //Sólo se necesita el nombre del producto de momento en el objeto.
		TreeSet<Producto> productos = new TreeSet<Producto>();
		Scanner all = new Scanner(System.in);
		
		do {
			System.out.println("1. Añadir producto" + "\n" + "2.Listar productos" + "\n" + "3.Eliminar producto" + "\n" + "0.Salir");
			opcion = all.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("¿El producto es perecedero o noPerecedero?");
				tipoProducto = all.next();
				System.out.println("Introduzca el nombre del producto");
				nombreProducto = all.next();
				if (productos.contains(p)) { //Si productos contiene un producto del mismo nombre, se cancela la opción haciéndoselo saber al usuario.
					System.out.println("El producto ya existe");
				} else {
					System.out.println("Introduzca el precio del producto");
					precioProducto = all.nextDouble();
					if (tipoProducto.equalsIgnoreCase("perecedero")) {
						System.out.println("¿Cuántos días tiene para que caduque?");
						diasCaducar = all.nextInt();
						
						//Aquí ya sí que sí, dentro de p, añado en el objeto el precio y los días también.
						
						p = new Perecedero(nombreProducto, precioProducto, diasCaducar);
						
						//Añadir producto
						
						productos.add(p);
					} else if (tipoProducto.equalsIgnoreCase("noperecedero")) { //Si es noPerecedero, se ejecuta esta acción
						System.out.println("Introduzca el tipo");
						tipo = all.next();
						
						//Lo mismo que con Perecedero pero con tipo en lugar de los días de caducación.
						
						p = new NoPerecedero(nombreProducto, precioProducto, tipo);
						
						//Añadir producto
						
						productos.add(p);
					}
					System.out.println("El producto se añadió");
					break;
				}

			case 2: //Esto simplemente imprime la lista de los productos.
				System.out.println(productos);
				break;

			case 3:
				System.out.println("Introduzca el nombre del producto a eliminar");
				nombreProducto = all.next();
				productos.remove(p);
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (opcion != 0);
		all.close();
	}
}