package supermercado;

import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// Obtener la instancia de supermercado
		Supermercado supermercado = Supermercado.getSupermercado();

		// Añadir algunos productos
		supermercado.addProducto(new Producto("Producto1", "Sec1", 5.5f, LocalDate.of(2014, 12, 12)));
		supermercado.addProducto(new Producto("Producto2", "Sec1", 3.1f, LocalDate.of(2015, 12, 12)));
		supermercado.addProducto(new Producto("Producto3", "Sec2", 11f, LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(
				new Producto("Producto4", "Sec2", 12.5f, LocalDate.of(2020, 1, 17), LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(new Producto("Producto3", "Sec2", 11f, LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(
				new Producto("Producto5", "Sec2", 12.5f, LocalDate.of(2020, 1, 17), LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(new Producto("Producto3", "Sec2", 11f, LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(
				new Producto("Producto6", "Sec2", 112.5f, LocalDate.of(2020, 1, 17), LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(new Producto("Producto3", "Sec2", 11f, LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(
				new Producto("Producto7", "Sec3", 2.5f, LocalDate.of(2020, 1, 17), LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(new Producto("Producto3", "Sec2", 11f, LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(
				new Producto("Producto8", "Sec4", 18.5f, LocalDate.of(2020, 1, 17), LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(new Producto("Producto3", "Sec2", 11f, LocalDate.of(2025, 12, 21)));
		supermercado.addProducto(
				new Producto("Producto9", "Sec5", 19.5f, LocalDate.of(2020, 1, 17), LocalDate.of(2025, 12, 21)));

		// TODO: gehitu beste productu batzuk eta emaitzak bistaratzen dituzten metodoak

		System.out.println("\nEjercicio 1: Productos caducados");
		System.out.println("==================================");
		supermercado.getProductosCaducados().stream().forEach(System.out::println);

		System.out.println("\nEjercicio 2: ¿Hay algún producto expuesto antes del 25/3/2020?");
		System.out.println("================================================================");
		System.out.printf("Respuesta: %s\n",
				supermercado.hayProductosExpuestoAntesDe(LocalDate.of(2020, 3, 25)) ? "Sí" : "No");

		System.out.println("\nEjercicio 3: Estadísticas de los precios:");
		System.out.println("===========================================");
		DoubleSummaryStatistics estadisticas = supermercado.getEstadisticasPrecios();
		double mean = estadisticas.getAverage();
		// Calcular la desviación estándar
		double stdev = Math.sqrt(supermercado.getInventario().stream().mapToDouble(p -> p.getPrecio() - mean)
				.map(p -> p * p).average().orElse(0.0));

		System.out.printf(
				"Número de productos: %d\n" + "Suma de precios: %.2f€\n" + "Precio mínimo: %.2f€\n"
						+ "Precio máximo: %.2f€\n" + "Precio medio: %.2f€\n" + "Desviación estándar: %.2f\n",
				estadisticas.getCount(), estadisticas.getSum(), estadisticas.getMin(), estadisticas.getMax(),
				estadisticas.getAverage(), stdev);

		System.out.println("\nEjercicio 4: Productos ordenados por sección y por precio (descendente)");
		System.out.println("=========================================================================");
		List<Producto> listaOrdenada = supermercado.getInventarioOrdenado();
		listaOrdenada.stream().forEach(System.out::println);

		System.out.println("\nEjercicio 5: Producto más barato por sección");
		System.out.println("==============================================");
		Map<String, Double> precioPorSeccion = supermercado.getProductoMasBaratoPorSeccion();
		precioPorSeccion.entrySet().stream().sorted(Entry.comparingByKey())
				.forEach(p -> System.out.printf("Sección: %s Precio %.2f€\n", p.getKey(), p.getValue()));

		System.out.println("\nEjercicio 6: Precio medio de productos caducados y no caducados");
		System.out.println("=================================================================");
		Map<Boolean, Double> precioMedioCaducadosYNo = supermercado.getPrecioMedioCaducadosNoCad();
		precioMedioCaducadosYNo.entrySet().forEach(p -> System.out.printf("%s\t Precio medio: %.2f\n",
				p.getKey() ? "Caducados" : "No caducados", p.getValue()));
	}

}
