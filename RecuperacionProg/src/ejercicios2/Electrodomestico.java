package ejercicios2;

public class Electrodomestico implements Comparable<Electrodomestico> {

	protected String codigo = "";
	protected double precioBase = 100;
	protected String color = "blanco";
	protected char consumo = 'F';
	protected int peso = 5;

	/**
	 * @param codigo     del electrodomestico, es un int
	 * @param precioBase del electrodomestico, double
	 * @param color      del electrodomestico, array de Strings
	 * @param consumo    del electrodomestico, char que tendría que ser de la A a la F; por defecto es F
	 * @param peso       del electrodomestico, un int.
	 */
	public Electrodomestico(String codigo, double precioBase, String color, char consumo, int peso) {
		this.codigo = codigo;
		this.precioBase = precioBase;
		this.color = color;
		this.consumo = consumo;
		this.peso = peso;
	}

	/**
	 * @param codigo del electrodomestico
	 */
	public Electrodomestico(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @param codigo     del electrodomestico
	 * @param precioBase del electrodomestico
	 * @param peso       del electrodomestico
	 */
	public Electrodomestico(String codigo, double precioBase, int peso) {
		this.codigo = codigo;
		this.precioBase = precioBase;
		this.peso = peso;
	}

	/**
	 * Constructor por defecto sin parámetros.
	 */
	public Electrodomestico() {

	}

	/**
	 * Get del código
	 * 
	 * @return código del electrodomestico
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * set del código
	 * 
	 * @param codigo del electrodomestico
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * get del precioBase
	 * 
	 * @return el precio de base del electrodomestico
	 */
	public double getPrecioBase() {
		return precioBase;
	}

	/**
	 * set del precio base del electrodomestico
	 * 
	 * @param precioBase del electrodomestico
	 */
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	/**
	 * get color del electrodomestico
	 * 
	 * @return el color del electrodomestico
	 */
	public String getColor() {
		return color;
	}

	/**
	 * set del color del electrodomestico
	 * 
	 * @param color del electrodomestico
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * get del consumo del electrodomestico
	 * 
	 * @return consumo del electrodomestico
	 */
	public char getConsumo() {
		return consumo;
	}

	/**
	 * setConsumo del electrodomestico
	 * 
	 * @param consumo del electrodomestico
	 */
	public void setConsumo(char consumo) {
		this.consumo = consumo;
	}

	/**
	 * get del peso del electrodomestico
	 * 
	 * @return el peso del electrodomestico
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * set peso del electrodomestico
	 * 
	 * @param peso del electrodomestico
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

	private static char comprobarConsumoEnergetico(char letra) {
		if (letra != 'A' && letra != 'B' && letra != 'C' && letra != 'D' && letra != 'E' && letra != 'F') {
			return 'F';
		} else {
			return letra;
		}
	}

	private static String comprobarColor(String color) {
		if (!color.equals("blanco") || !color.equals("negro") || !color.equals("rojo") || !color.equals("azul")
				|| !color.equals("gris")) {
			return "blanco";
		} else {
			return color;
		}
	}

	public void precioFinal() {
		switch (consumo) {
		case 'A':
			precioBase += 100;
			break;
		case 'B':
			precioBase += 80;
		case 'C':
			precioBase += 60;
		case 'D':
			precioBase += 50;
		case 'E':
			precioBase += 30;
		case 'F':
			precioBase += 10;
		}
		if (peso >= 0 && peso <= 19) { // Ojo, ninguno de estas condiciones comprueba que el peso es negativo.
			precioBase += 10;
		} else if (peso >= 20 && peso <= 49) {
			precioBase += 50;
		} else if (peso >= 50 && peso <= 79) {
			precioBase += 80;
		} else {
			precioBase += 100;
		}
	}

	/**
	 * Compare to del electrodomestico
	 */
	@Override
	public int compareTo(Electrodomestico el) {
		return this.codigo.compareTo(el.codigo);
	}

	@Override
	public String toString() {
		return "Código: " + codigo + "\n" + " precio base: " + precioBase + "\n" + "color: " + color + "\n"
				+ "consumo: " + consumo + "\n" + "peso: " + peso;
	}
}