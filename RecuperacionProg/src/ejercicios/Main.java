package ejercicios;

public class Main {

	public static void main(String[] args) {
		Producto[] pr = new Producto[5];
		pr[0] = new Perecedero("Filete", 4, 2);
		pr[1] = new NoPerecedero("Repollo", 3, "Verdura");
		pr[2] = new Perecedero("Fuet", 2, 1);
		pr[3] = new NoPerecedero("Manzana", 0.4, "Fruta");
		pr[4] = new Producto("Agua", 1);
	}

}