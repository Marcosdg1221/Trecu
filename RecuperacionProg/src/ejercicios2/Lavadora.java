package ejercicios2;

public class Lavadora extends Electrodomestico {

	private int carga = 5;

	/**
	 * Constructor con los parámetros heredados y la carga
	 * 
	 * @param codigo
	 * @param precioBase
	 * @param color
	 * @param consumo
	 * @param peso
	 * @param carga
	 */
	public Lavadora(String codigo, double precioBase, String color, char consumo, int peso, int carga) {
		super(codigo, precioBase, color, consumo, peso);
		this.carga = carga;
	}

	/**
	 * Constructor sólo con código
	 * 
	 * @param codigo
	 */
	public Lavadora(String codigo) {
		super(codigo);
		this.codigo = codigo;
	}

	/**
	 * Constructor con codigo precio y peso
	 * 
	 * @param codigo
	 * @param precioBase
	 * @param peso
	 */
	public Lavadora(String codigo, double precioBase, int peso) {
		super(codigo, precioBase, peso);
		this.codigo = codigo;
		this.precioBase = precioBase;
		this.peso = peso;
	}

	/**
	 * Constructor defecto
	 */
	public Lavadora() {

	}

	/**
	 * Get de la carga de la lavadora
	 * 
	 * @return la carga de la lavadora
	 */
	public int getCarga() {
		return carga;
	}

	/**
	 * Set de la lavadora
	 * 
	 * @param carga de la lavadora
	 */
	public void setCarga(int carga) {
		this.carga = carga;
	}

	@Override
	public void precioFinal() {
		if (precioBase > 30) {
		precioBase += 50;
		}
		super.precioFinal();
	}

	@Override
	public String toString() {
		return "Lavadora " + "\n" + "Codigo: " + "Precio base: " + precioBase + "\n" + "Color: " + color + "\n"
				+ "Consumo energético: " + consumo + "\n" + "Peso :" + "\n" + "Carga: " + carga;
	}

}
