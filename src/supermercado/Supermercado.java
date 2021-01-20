package supermercado;


// Para poder utilizar los métodos estáticos sin tener que indicar la clase
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

public class Supermercado {
	private List<Producto> listaProductos;
	private static Supermercado mSupermercado = new Supermercado();

	/**
	 * Constructor privado de la clase
	 */
	private Supermercado() {
		listaProductos = new ArrayList<>();
	}

	/**
	 * getSupermercado.
	 * Método estático que devuelve la instancia única de la clase
	 * @return la instancia única
	 */
	public static Supermercado getSupermercado() {
		return mSupermercado;
	}
	
	/**
	 * addProducto.
	 * Método que añade un nuevo producto a la lista de productos disponibles en el supermercado.
	 * @param pProd
	 */
	public void addProducto(Producto pProd) {
		listaProductos.add(pProd);
	}
	
	/**
	 * getInventario
	 * Método que devuelve una copia de la lista de productos disponibles en el supermercado
	 * @return la lista de productos
	 */
	public List<Producto> getInventario() {
		// Devuelve una copia para preservar la ocultación de infomación y que no se pueda alterar el contenido del atributo
		return listaProductos.stream().collect(toList());
	}
	
	/**
	 * getProductosCaducados
	 * @return devuelve una lista que contiene los productos del supermercado que han caducado.
	 */
	public List<Producto> getProductosCaducados() {
		// TODO: Ejercicio 1
		return null;
	}

	/**
	 * hayProductosExpuestosAntesDe
	 * @param pDate - la fecha de exposición
	 * @return devuelve true si hay algún producto expuesto antes de la fecha indicada y false en caso contrario
	 */
	public boolean hayProductosExpuestoAntesDe(LocalDate pDate) {
		// TODO: Ejercicio 2
		return false;
	}
	
	/**
	 * getEstadisticasPrecios
	 * @return Las estadísticas (número, suma, mínimo, máximo, media) de los precios de los productos del supermercado
	 */
	public DoubleSummaryStatistics getEstadisticasPrecios() {
		// TODO: Ejercicio 3
		return null;
	}
	
	/**
	 * getInventarioOrdenado
	 * @return la lista de productos ordenados por sección y por precio (este último criterio de mayor a menor)
	 */
	public List<Producto> getInventarioOrdenado() {
		// TODO: Ejercicio 4
		return null;
	}
	
	/**
	 * getProductoMasBaratoPorSeccion
	 * @return devuelve un mapa que indica para cada sección el precio del producto más barato de dicha sección
	 */
	public Map<String, Double> getProductoMasBaratoPorSeccion() {
		// TODO: Ejercicio 5
		return null;
	}
	
	/**
	 * getPrecioMedioCaducadosNoCad
	 * @return devuelve un mapa que indica el precio medio de los productos caducados y el precio medio de los productos no caducados
	 */
	public Map<Boolean, Double> getPrecioMedioCaducadosNoCad() {
		// TODO: Ejercicio 6
		return listaProductos.stream().collect(partitioningBy(Producto::estaCaducado,averagingDouble(Producto::getPrecio)));
	}

}
