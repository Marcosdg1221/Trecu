package ejercicios;

public class NoPerecedero extends Producto {

	private String tipo="";

	public NoPerecedero(String nombre, double precio, String tipo) {
		super(nombre, precio);
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
		if (precio >= 0) {
			this.precio = precio;
		}
		if (nombre != null && !nombre.isEmpty()) {
			this.tipo = tipo;
		}
	}

	/**
	 * @param nombre
	 * @param precio
	 */
	public double calcular(int cantidad) {
		return this.precio * cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if (nombre != null && !nombre.isEmpty()) {
		this.tipo = tipo;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Tipo: " + tipo;
	}
}