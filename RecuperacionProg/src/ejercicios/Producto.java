package ejercicios;

public class Producto implements Comparable<Producto> {

	protected String nombre;
	protected double precio;

	/**
	 * 
	 * @param nombre; comprobando que no es vacío.
	 */
	public Producto(String nombre) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
	}
	
	/**
	 * @param nombre, comprobando que no esté vacío ni null
	 * @param precio, comprobando que el valor sea 0 o más
	 */
	public Producto(String nombre, double precio) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
		if (precio >= 0) {
			this.precio = precio;
		}
	}

	/**
	 * 
	 * @param nombre, si el nombre es vacío o null no hace nada
	 */
	public void setNombre(String nombre) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
	}

	/**
	 * 
	 * @return precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * 
	 * @param precio, comprobando que el precio sea positivo o 0
	 */
	public void setPrecio(double precio) {
		if (precio >= 0) {
			this.precio = precio;
		}
	}

	/**
	 * 
	 * @param cantidad
	 * @return precio por la cantidad
	 */
	public double calcular(int cantidad) {
		return this.precio * cantidad;
	}
	
	/**
	 * 
	 * @return nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	public boolean equals(Object objeto) {
		boolean igual = false;
		Producto pr = (Producto) objeto;
		if (this.nombre.equals(pr.nombre)) {
			igual = true;
		}
		return igual;
	}

	@Override
	public int compareTo(Producto pr) {
		return this.nombre.compareTo(pr.nombre);
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\n" + "Precio: " + precio + "\n";
	}
}