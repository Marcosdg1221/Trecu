package ejercicios;

public class NoPerecedero extends Producto {

	private String tipo="";

	/**
	 * Comprueba también de que los valores sean correctos (nombre no nulo, precio positivo, tipo no vacío, etc...)
	 * @param nombre
	 * @param precio
	 * @param tipo
	 */
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
	 * 
	 * @param tipo , si el tipo no está vacío.
	 */
	public void setTipo(String tipo) {
		if (nombre != null && !nombre.isEmpty()) {
		this.tipo = tipo;
		}
	}

	/**
	 * 
	 * @return el tipo del producto se devuelve aquí.
	 */
	public String getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Tipo: " + tipo;
	}
}