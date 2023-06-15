package ejercicios2;

public class Electrodomestico implements Comparable<Electrodomestico> {

	/**
	 *  Color es un enumerado, su atributo se llama colores y por defecto es blanco
	 */
	protected enum Color{blanco, negro, rojo, azul, gris};

	/**
	 * Consumo es igual que colores, se llama consumacion.
	 */  
	protected enum Consumo {A,B,C,D,E,F};
	
	/**
	 * Codigo es un string y la clave primaria
	 */
	protected String codigo = "";
	
	/**
	 * Precio es el precio del electro y un double
	 */
	protected double precioBase = 100;
	/**
	 * Por ultimo está el peso, que es un int.
	 */
	protected int peso = 5;
	
	/**
	 * El tipo Color que por defecto será blanco
	 */
	protected Color color=Color.blanco;
	
	/**
	 * El tipo consumo que por defecto será F
	 */
	protected Consumo consumacion=Consumo.F;

	
	
	/**
	 * Constructor con todos los campos
	 * @param codigo
	 * @param precioBase
	 * @param peso
	 * @param colores
	 * @param consumacion
	 */
	protected Electrodomestico(String codigo, double precioBase, int peso, String color, char consumo) {
		super();
		comprobarColor(color);
		comprobarConsumo(consumo);
		this.codigo = codigo;
		this.precioBase = precioBase;
		this.peso = peso;

	}

	/**
	 * Constructor por defecto
	 */
	protected Electrodomestico() {
		super();
	}
	
	/**
	 * Constructor solo codigo
	 * @param codigo
	 */
	protected Electrodomestico(String codigo) {
		super();
		this.codigo = codigo;
	}

	/**
	 * Constructor con los campos codigo, precio y el peso
	 * @param codigo
	 * @param precioBase
	 * @param peso
	 */
	protected Electrodomestico(String codigo, double precioBase, int peso) {
		super();
		this.codigo = codigo;
		this.precioBase = precioBase;
		this.peso = peso;
	}


	/**
	 * 
	 * @return codigo del electro
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Set del codigo
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Get del precio del elctrodomestico
	 * @return el precio del electro
	 */
	public double getPrecioBase() {
		return precioBase;
	}

	/**
	 * Set del precio del electro
	 * @param precioBase
	 */
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	/**
	 * get del peso del electro
	 * @return peso
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * Set del peso del electro
	 * @param peso
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

	/**
	 * Get de los colores del electro
	 * @return los colores
	 */
	public String getColores() {
		return String.valueOf(color);
	}

	/**
	 * Set de los colores
	 * @param colores
	 */
	public void setColores(String colores) {
		comprobarColor(colores);
	}

	/**
	 * Get del enumerado del consumo
	 * @return consumacion
	 */
	public char getConsumacion() {
		return String.valueOf(consumacion).charAt(0);
	}

	/**
	 * Set de la consumacion
	 * @param consumacion
	 */
	public void setConsumacion(char consumacion) {
		comprobarConsumo(consumacion);
	}

	/**
	 * Compare to del electrodomestico
	 */
	@Override
	public int compareTo(Electrodomestico el) {
		return this.codigo.compareTo(el.codigo);
	}

	/**
	 * Precio final que tendrá una serie de cálculos; dependiendo del peso  del electro costará más o menos
	 */

	public void precioFinal() {
		switch (consumacion.toString()) {
		case "A":
			precioBase += 100;
			break;
		case "B":
			precioBase += 80;
			break;
		case "C":
			precioBase += 60;
			break;
		case "D":
			precioBase += 50;
			break;
		case "E":
			precioBase += 30;
			break;
		case "F":
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
	 * Comprobar color comprueba si el usuario introdujo algún valor dentro del enumerado, si no pone por defecto blanco.
	 * @param color
	 * @return
	 */
	private void comprobarColor(String color) {
		if (!color.equals("blanco") || !color.equals("negro") || !color.equals("rojo") || !color.equals("azul")
				|| !color.equals("gris")) {
			this.color=Color.blanco;
		} else {
			this.color=Color.valueOf(color);
		}
	}
	
	private void comprobarConsumo(char consumo) {
		if (consumo!='A'|| consumo!='B' || consumo!='C' || consumo!='D' || consumo!='E' ||consumo!='F') {
			this.consumacion= consumacion.F;
		}
		else {
			this.consumacion=Consumo.valueOf(String.valueOf(consumo));
		}
	}

	/**
	 * ToString del electrodomestico
	 */
	@Override
	public String toString() {
		return "Código: " + codigo + "\n" + " precio base: " + precioBase + "\n" + "color: " + color + "\n"
				+ "consumo: " + consumacion + "\n" + "peso: " + peso;
	}


}
