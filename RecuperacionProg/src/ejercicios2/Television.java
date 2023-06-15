package ejercicios2;

import ejercicios2.Electrodomestico.Color;
import ejercicios2.Electrodomestico.Consumo;

public class Television extends Electrodomestico{

	/**
	 * resolucion de la television es un int
	 */
	private int resolucion=20;
	/**
	 * tdt de la tele es un boolean, por defecto false
	 */
	private boolean tdt=false;
	
	/**
	 * Constructor por defecto
	 */
	protected Television() {
		super();
	}

	/**
	 * Constructor con todos los atributos de television
	 * @param codigo
	 * @param precioBase
	 * @param peso
	 * @param colores
	 * @param consumacion
	 * @param resolucion
	 * @param tdt
	 */
	protected Television(String codigo, double precioBase, int peso, String colores, char consumacion, int resolucion, boolean tdt) {
		super(codigo, precioBase, peso, colores, consumacion);
		this.codigo=codigo;
		this.precioBase=precioBase;
		this.peso=peso;
		this.color=Color.valueOf(colores);
		this.consumacion=Consumo.valueOf(String.valueOf(consumacion));
		this.resolucion=resolucion;
		this.tdt=tdt;
	}

	/**
	 * @param codigo
	 * @param precioBase
	 * @param peso
	 */
	protected Television(String codigo, double precioBase, int peso) {
		super(codigo, precioBase, peso);
		this.codigo=codigo;
		this.precioBase=precioBase;
		this.peso=peso;
	}

	/**
	 * @param codigo
	 */
	protected Television(String codigo) {
		super(codigo);
	}

	public int getResolucion() {
		return resolucion;
	}

	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}

	public boolean getTdt() {
		return tdt;
	}

	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}

	@Override
	public void precioFinal() {
		if (resolucion>40) {
			precioBase=precioBase+((precioBase*30)/100);
		}
		super.precioFinal();
	}
	
	/**
	 * Método toString de la televisión
	 */
	@Override
	public String toString() {
		return "Television " + "\n" + "Codigo: " + codigo +"\n" +"Precio Base: " + precioBase + "\n" + "Color: " + color + "\n" + "Consumo energético: " + consumacion + "\n" + "Peso: " + peso + "\n" + "Resolución: " + resolucion + "\n" + "Sintonizador TDT: " + tdt ;
	}

}
