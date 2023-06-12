package ejercicios2;

public class Television extends Electrodomestico{

	private int resolucion=20;
	private boolean TDT=false;
	
	/**
	 * 
	 */
	public Television() {
		super();
		
	}
	/**
	 * @param codigo
	 * @param precioBase
	 * @param peso
	 */
	public Television(String codigo, double precioBase, int peso) {
		super(codigo, precioBase, peso);
		this.codigo=codigo;
		this.precioBase=precioBase;
		this.peso=peso;
	}
	/**
	 * @param codigo
	 * @param precioBase
	 * @param color
	 * @param consumo
	 * @param peso
	 */
	public Television(String codigo, double precioBase, String color, char consumo, int peso) {
		super(codigo, precioBase, color, consumo, peso);
		this.codigo=codigo;
		this.precioBase=precioBase;
		this.color=color;
		this.consumo=consumo;
		this.peso=peso;
	}
	/**
	 * @param codigo
	 */
	public Television(String codigo) {
		super(codigo);
		this.codigo=codigo;
	}
	/**
	 * 
	 * @return resolucion de la television
	 */
	public int getResolucion() {
		return resolucion;
	}
	/**
	 * Set resolucion de la television
	 * @param resolucion
	 */
	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}
	
	/**
	 * Get de TDT
	 * @return verdadero o falso si tiene o no TDT
	 */
	public boolean getTDT() {
		return TDT;
	}
	/**
	 * Set el tdt
	 * @param tDT de la television
	 */
	public void setTDT(boolean tDT) {
		TDT = tDT;
	}
	
	/**
	 * Incrementa el precio base un 30% si la resolucion es mayor a 40 pulgadas
	 */
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
		return "Television " + "\n" + "Codigo: " + codigo +"\n" +"Precio Base: " + precioBase + "\n" + "Color: " + color + "\n" + "Consumo energético: " + consumo + "\n" + "Peso: " + peso + "\n" + "Resolución: " + resolucion + "\n" + "Sintonizador TDT: " + TDT ;
	}

	
	
	
}
