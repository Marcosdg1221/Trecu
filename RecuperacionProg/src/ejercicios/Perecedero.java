package ejercicios;

public class Perecedero extends Producto {

	private int díasCaducar;

	/**
	 * @param nombre
	 * @param precio
	 */
	public Perecedero(String nombre, double precio, int díasCaducar) {
		super(nombre, precio);
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
		if (precio >= 0) {
			this.precio = precio;
		}
		if (díasCaducar >= 0) {
			this.díasCaducar = díasCaducar;
		}
	}

	public int getDíasCaducar() {
		return díasCaducar;
	}

	public void setDíasCaducar(int díasCaducar) {
		if (díasCaducar >= 0) {
			this.díasCaducar = díasCaducar;
		}
	}

	@Override
	public double calcular(int cantidad) {
		double precioDef;
		double spPrecio=super.calcular(cantidad);
		switch (díasCaducar) {
		case 1:
			precioDef = spPrecio / 4;
			break;
		case 2:
			precioDef = spPrecio / 3;
			break;
		case 3:
			precioDef = spPrecio / 2;
			break;
		default:
			precioDef = spPrecio;
		}
		return precioDef;
	}

	@Override
	public String toString() {
		return super.toString() + "Días a caducar: " + díasCaducar;
	}
}