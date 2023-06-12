package ejercicios;

import java.util.Scanner;
import java.util.TreeSet;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
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
					+ "4.Modificar producto" + "\n" + "5.Guardar fichero" + "\n" + "0.Salir");
			opcion = all.nextInt();
			all.nextLine();
			switch (opcion) {
			case 1:
				
				Funciones.añadirProducto(nombreProducto, p, productos, precioProducto, tipoProducto, diasCaducar, tipo);
				break;
			case 2: // Esto simplemente imprime la lista de los productos.
				Funciones.listar(productos);
				break;
			case 3:
				Funciones.eliminarProducto(productos, nombreProducto, p);
				break;
			case 4:
				Funciones.modificarProducto(nombreProducto, p, productos, precioProducto);
				break;
			case 5:
				Funciones.guardar(productos);
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
