package ejercicios;

public class Producto implements Comparable<Producto> {

	protected String nombre;
	protected double precio;

	/**
	 * 
	 * @param nombre
	 */
	public Producto(String nombre) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
	}
	
	/**
	 * @param nombre
	 * @param precio
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
	 * @return nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
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
	 * @param precio
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