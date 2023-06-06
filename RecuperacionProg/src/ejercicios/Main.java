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
			System.out.println("1. Añadir producto" + "\n" + "2.Listar productos" + "\n" + "3.Eliminar producto" + "\n" + "4.Modificar producto" +"\n"
					+ "0.Salir");
			opcion = all.nextInt();
			all.nextLine();
			switch (opcion) {
			case 1:
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
						System.out.println("¿El producto es perecedero o noPerecedero?"); 
						System.out.println("Por favor, sólo introduzca perecedero o noPerecedero");													
						tipoProducto = all.next();
						all.nextLine();

					} while (!tipoProducto.equalsIgnoreCase("perecedero")
							&& !tipoProducto.equalsIgnoreCase("noperecedero"));
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
					
				}
				break;
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
				nombreProducto = all.next(); // crear un producto nombre; esto sin más te elimina el último añadido
				all.nextLine();
				p = new Producto(nombreProducto);
				if (productos.remove(p)) { // Si contiene el producto p con su nombre, no se hace nada, si no, se
											// elimina
					System.out.println("Producto eliminado" + "\n");
				} else {
					System.out.println("El producto no existe");
				}
				break;
				
			case 4:
				System.out.println("Introduzca el nombre del producto a modificar");
				nombreProducto=all.next();
				int opcion2=0; //Importante tener esto para después preguntar qué se quiere modificar
				all.nextLine();
				p=new Producto(nombreProducto);
				if (productos.contains(p)) { //?
					System.out.println("¿Qué dato del producto desea modificar?");
					
					//TODO Si el producto no es perecedero, imprimir un menu, y si lo es, imprimir otro menu (piden otro tipo de datos)
					
					System.out.println("1. El precio del producto"); //Esto se va a imprimir sí o sí en ambos tipos del producto
					for (Producto product:productos) {
						if (product.equals(p)){ //Comprueba si algún producto es equivalente al nombre que se introdujo
	
							if (product instanceof NoPerecedero) { //Si NO es perecedero
	
								System.out.println("2.El tipo");
								}
								else if(product instanceof Perecedero) {
								System.out.println("2. Los días de caducación");
								}
								//Acaba el menú aquí
								
								//Comprobación de la opción elegida
								do {
								if (opcion2!=0) { //Para que en la primera vez no imprima opción no válida sin que el usuario no haya puesto nada.
								System.out.println("opción no válida");
								}
								opcion2=all.nextInt();
								all.nextLine();
								}while(opcion2!=1 && opcion2!=2);
							
							if (opcion2==1) { //Modificar el precio del producto
								System.out.println("Introduzca el precio");
								product.setPrecio(all.nextDouble());
								System.out.println("producto modificado");
							}
							else {
								if (product instanceof Perecedero) {
									System.out.println("Introduzca los días a caducar");
									Perecedero per=(Perecedero)product;
									per.setDíasCaducar(all.nextInt());
									System.out.println("producto modificado");
								}
								else if(product instanceof NoPerecedero) {
									System.out.println("Introduzca el tipo");
									NoPerecedero noper = (NoPerecedero)product;
									noper.setTipo(all.next());
									System.out.println("producto modificado");
								}
							}
								
							}
//							else if(product instanceof Perecedero) { //Si es perecedero
//							System.out.println("2. Días a caducar del producto");	
//							if (opcion2!=0) { //Para que en la primera vez no imprima opción no válida sin que el usuario no haya puesto nada.
//							System.out.println("opción no válida");
//							}
//							opcion2=all.nextInt();
//							all.nextLine();
//							if (opcion2==1) { //Modificar el precio del producto
//								p.precio=all.nextDouble();
//							}
//							opcion2=0; //Para que al repetir esta opción no imprima "opción no válida" directamente, ya que chequea de que opcion2 sea 0.
//							}
						}			
					}
				else {
					System.out.println("El producto no existe");
				}
				break;
			case 0: // Sale con la opción 0
				System.out.println("Salida");
				break;
			default:
				System.out.println("Opción no válida");
			}

		}while(opcion!=0);all.close();
	}
}
