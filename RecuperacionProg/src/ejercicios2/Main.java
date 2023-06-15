package ejercicios2;

import java.util.Scanner;
import java.util.LinkedHashSet;

public class Main {
	
	public static LinkedHashSet<Electrodomestico> lista = new LinkedHashSet<Electrodomestico>(); //Puede ser estático
	public static Scanner all = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcion;
		do {
			System.out.println("1.Añadir electrodoméstico." + "\n" + "2.Listar electrodomésticos." + "\n"
					+ "3.Modificar electrodoméstico" + "\n" + "4.Eliminar electrodoméstico" + "\n"
					+ "5.Guardar en fichero" + "\n" + "0.Salir");
			opcion = all.nextInt();
			all.nextLine();
			switch (opcion) {
			case 1:
				Funciones.añadirElectro();		
				break;
			case 2:
				Funciones.listarElectros();
				break;
			case 3:
				Funciones.modificarElectros();
				break;
			case 4:
				Funciones.eliminarElectrodomestico();
				break;
			case 5:
				Funciones.guardarfichero();
				break;
			case 0:
				System.out.println("Salida");
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (opcion != 0);
	}
}
