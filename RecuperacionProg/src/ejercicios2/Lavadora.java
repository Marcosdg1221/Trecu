package ejercicios2;

public class Lavadora extends Electrodomestico {

	/**
	 * Atributo carga para lavadora y es un int
	 */
	private int carga = 5;

	/**
	 * Constructor por defecto
	 */
	protected Lavadora() {
		super();
	}

	/**
	 * @param codigo
	 * @param precioBase
	 * @param peso
	 * @param colores
	 * @param consumacion
	 */
	protected Lavadora(String codigo, double precioBase, int peso, String colores, char consumacion) {
		super(codigo, precioBase, peso, colores, consumacion);
		this.codigo=codigo;
		this.precioBase=precioBase;
		this.peso=peso;
		this.color=Color.valueOf(colores);
		this.consumacion=Consumo.valueOf(String.valueOf(consumacion));
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
				+ "Consumo energético: " + consumacion + "\n" + "Peso :" + "\n" + "Carga: " + carga;
	}

}
