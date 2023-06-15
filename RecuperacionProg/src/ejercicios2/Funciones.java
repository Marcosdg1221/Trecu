package ejercicios2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

import ejercicios.NoPerecedero;
import ejercicios.Perecedero;
import ejercicios.Producto;
import ejercicios2.Electrodomestico.Color;
import ejercicios2.Electrodomestico.Consumo;

public class Funciones {

	// Añadir electrodomestico
	public static void añadirElectro() {

		String codigo = "";
		double precioBase = 0;
		enum Color{blanco, negro, rojo,azul,gris};
		Color colores=Color.blanco;
		String colorGuardar="";
		enum Consumo{A,B,C,D,E,F}
		Consumo consumacion=Consumo.F;
		char consumoGuardar='F';
		int peso = 0;
		Electrodomestico el = new Electrodomestico();
		int resolucion = 0;
		int carga = 0;
		boolean tdt = false;

		String tipoElectro = "";
		System.out.println("Introduzca el código del electrodoméstico");
		codigo = Main.all.next();
		Main.all.nextLine();
		el = new Electrodomestico(codigo);
		if (Main.lista.contains(el)) {
			System.out.println("Ya existe ese electrodoméstico");
		} else {
			do { // Preguntar una y otra vez hasta que la respuesta sea correcta.
				System.out.println("¿El producto es Electrodomestico, lavadora o Television?"); // Si no metes nada, se
																								// añade
				System.out.println("Por favor, sólo introduzca Electrodomestico, lavadora o television"); // Condición
				tipoElectro = Main.all.next();
				Main.all.nextLine();
			} while (!tipoElectro.equalsIgnoreCase("Electrodomestico")
					&& !tipoElectro.equalsIgnoreCase("lavadora") && !tipoElectro.equalsIgnoreCase("television") && !tipoElectro.equalsIgnoreCase("tele"));

			// preguntar datos del producto
			System.out.println("Introduzca el precio del electrodomestico");
			precioBase = Main.all.nextDouble();
			Main.all.nextLine();
			
			System.out.println("Introduzca su color");
			
			colorGuardar=Main.all.next();
			
			Color.valueOf(colorGuardar);
			
			Main.all.nextLine();
			System.out.println("Introduzca su consumo");
			
			Main.all.nextLine();
			System.out.println("Introduzca su peso");
			peso = Main.all.nextInt();
			Main.all.nextLine();
			// Si se introdujo lavadora, preguntar por sus atributos.
			if (tipoElectro.equalsIgnoreCase("lavadora")) {
				System.out.println("Introduzca su carga");
				carga = Main.all.nextInt();
				Electrodomestico lava = new Lavadora(codigo, precioBase, peso, colorGuardar, consumoGuardar);
				Main.lista.add(lava);
			} // Si se introdujo television, introducir tdt.
			else if (tipoElectro.equalsIgnoreCase("Television") || tipoElectro.equalsIgnoreCase("Tele")) {
				System.out.println("¿Cuál es la resolución de la tele?");
				resolucion=Main.all.nextInt();
				Main.all.nextLine();
				System.out.println("¿La televisión tiene tdt?");
				String boleanAux;
				boleanAux = Main.all.next();
				Main.all.nextLine();
				// Tiene tdt
				if (boleanAux.equalsIgnoreCase("si")) {
					tdt = true;
				} // No tiene tdt
				else if (boleanAux.equalsIgnoreCase("no")) {
					tdt = false;
				} else { // No tiene tdt
					System.out.println("Me lo tomaré como un no.");
					tdt = false;
				}
				Electrodomestico tele= new Television(codigo, precioBase, peso, colorGuardar, consumoGuardar, resolucion, tdt);
				Main.lista.add(tele);
			} else { // añadir electrodomestico (no tele ni lavadora)
				Electrodomestico electr = new Electrodomestico(codigo, precioBase, peso, colorGuardar, consumoGuardar);
				Main.lista.add(electr);
			}
		}

	}

	// Listar los electrodomésticos
	public static void listarElectros() {
		if (Main.lista.size() == 0) {
			System.out.println("No hay electrodomésticos" + "\n");
		} else {
			for (Electrodomestico i : Main.lista) { // For each para que me vaya recorriendo la tabla de lo que
													// contenga.
				System.out.println(i + "\n");
			}
		}
	}

	// Modificar el electrodomestico.
	public static void modificarElectros() {
		String codigo = "";
		int opcion2 = 0;
		System.out.println("Introduce el código del electrodoméstico a modificar");
		codigo = Main.all.next();
		Electrodomestico electro = new Electrodomestico(codigo);
		if (!Main.lista.contains(electro)) {
			System.out.println("No existe ese electrodomestico");
		} else {
			System.out.println("¿Qué dato del electrodoméstico quieres modificar?");
			System.out.println("1.El precio del electrodoméstico");
			System.out.println("2.El color");
			System.out.println("3.El consumo");
			for (Electrodomestico e : Main.lista) {
				if (electro.equals(e)) { // Comprueba si algún producto es equivalente al nombre que se
											// introdujo
					if (electro instanceof Lavadora) { // Si es lavadora
						System.out.println("4.La carga");
					} else if (electro instanceof Television) {
						System.out.println("4. La resolucion");
						System.out.println("5. Si tiene o no tdt");
					}
					opcion2 = Main.all.nextInt();
				}
				switch (opcion2) {
				case 1:
					System.out.println("Introduzca el nuevo precio del electrodoméstico");
					e.setPrecioBase(Main.all.nextDouble());
					break;

				case 2:
					System.out.println("Introduzca el nuevo color del electrodoméstico");
					e.setColores(Main.all.next());
					break;

				case 3:
					System.out.println("Introduzca el nuevo consumo del electrodoméstico");
					e.setConsumacion(Main.all.next().charAt(0));
					break;
				case 4:
					if (e instanceof Lavadora) {
						System.out.println("Introduzca la carga de la lavadora");
						Lavadora l = (Lavadora) e;
						l.setCarga(Main.all.nextInt());
					} else {
						System.out.println("Introduzca la resolución de la televishion");
						Television t = (Television) e;
						t.setResolucion(Main.all.nextInt());
					}
				case 5:
					if (e instanceof Television) {
						String respuesta;
						System.out.println("Introduzca si tiene tdt o no");
						Television t = (Television) e;
						respuesta = Main.all.next();
						do {
							if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("true")) {
								t.setTdt(true);
							} else if (respuesta.equalsIgnoreCase("no") || respuesta.equalsIgnoreCase("false")) {
								t.setTdt(false);
							} else {
								System.out.println("Por favor, sólo ponga si, no, true o false");
							}
						} while (!respuesta.equalsIgnoreCase("si") || !respuesta.equalsIgnoreCase("no")
								|| !respuesta.equalsIgnoreCase("true") || !respuesta.equalsIgnoreCase("false"));
					} else {
						System.out.println("Opción incorrecta");
					}
					break;
				default:
					System.out.println("Opción incorrecta");
				}
			}
		}
	}

	public static void eliminarElectrodomestico() {
		String nombreProducto;
		System.out.println("Introduce el nombre del producto que quieras modificar");
		nombreProducto = Main.all.next();
		Main.all.nextLine();
		Electrodomestico e = new Electrodomestico(nombreProducto);
		if (Main.lista.remove(e)) {
			System.out.println("Producto eliminado");
			System.out.println();
		} else {
			System.out.println("No existe ese electrodoméstico");
		}
	}

	public static void guardarfichero() {
		String linea = ""; // Es lo que se guardará en "archivo de texto"

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.txt"));
			for (Electrodomestico e : Main.lista) { // For each para que me vaya recorriendo la tabla de lo que
													// contenga.
				linea = e.getCodigo() + ";" + e.getPrecioBase() + ";" + e.getColores() + ";" + e.getConsumacion() + ";";
				if (e instanceof Lavadora) {
					linea += ((Lavadora) e).getCarga();

				} else {
					linea += ((Television) e).getResolucion() + ";";
					linea += ((Television) e).getTdt();
				}
				try {
					String[] datos = linea.split(";");
				} catch (ArrayIndexOutOfBoundsException a) { // Si en la tabla no existe una dimension 6, entonces es de
																// tipo Television

				} finally {
					Main.lista.add(e);
				}
				bw.write(linea);
				bw.newLine();
			}
			System.out.println("Guardado con éxito");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			System.out.println("El fichero tuvo un error");
		}
	}
}