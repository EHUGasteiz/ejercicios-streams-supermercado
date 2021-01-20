package supermercado;

// Nueva API para gestión de fechas y horas introducidad en Java 8
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Producto {
	private String nombre;
	private String seccion;
	private double precio;
	private LocalDate fechaExposicion;
	private LocalDate fechaCaducidad;

	/**
	 * Constructor del producto. Genera un nuevo objeto producto con los datos
	 * especificados.
	 * 
	 * @param pNombre
	 *            - nombre del producto
	 * @param pSeccion
	 *            - sección a la que pertenece el producto
	 * @param pPrecio
	 *            - precio del producto
	 * @param pFechaCaducidad
	 *            - fecha en la que caduca el producto
	 */
	public Producto(String pNombre, String pSeccion, double pPrecio,
			LocalDate pFechaCaducidad) {
		this(pNombre, pSeccion, pPrecio, LocalDate.now(), pFechaCaducidad);
		// La fecha de exposición se calcula
											// a partir de la fecha de creación
											// del producto

	}
	
	

	public Producto(String pNombre, String pSeccion, double pPrecio, LocalDate pFechaExposicion,
			LocalDate pFechaCaducidad) {
		super();
		nombre = pNombre;
		seccion = pSeccion;
		precio = pPrecio;
		fechaExposicion = pFechaExposicion;
		fechaCaducidad = pFechaCaducidad;
	}



	/**
	 * getNombre. Devuelve el nombre del producto.
	 * 
	 * @return el nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * getSeccion. Devuelve la sección a la que pertenece el producto.
	 * 
	 * @return la seccion
	 */
	public String getSeccion() {
		return seccion;
	}

	/**
	 * getPrecio. Devuelve el precio del producto.
	 * 
	 * @return el precio
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * estaCaducado. Devuelve true si el producto esta caducado y false en caso contrario.
	 * @return true si el producto esta caducado y false en caso contrario
	 */
	public boolean estaCaducado() {
		return fechaCaducidad.isBefore(LocalDate.now());
	}

	/**
	 * getFechaExposicion. Devuelve la fecha de exposición del producto.
	 * 
	 * @return la fecha de exposicion del producto
	 */
	public LocalDate getFechaExposicion() {
		return fechaExposicion;
	}

	/**
	 * getFechaCaducidad. Devuelve la fecha de caducidad del producto.
	 * 
	 * @return la fecha de caducidad del producto
	 */
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendText(ChronoField.DAY_OF_MONTH)
        .appendLiteral(" de ")
        .appendText(ChronoField.MONTH_OF_YEAR)
        .appendLiteral(" de ")
        .appendText(ChronoField.YEAR)
        .parseCaseInsensitive().toFormatter();
		return String
				.format("Producto: %1$s\nSección: %2$s\nPrecio: %3$.2f\nFecha caducidad: %4$s\n",
						getNombre(), getSeccion(), getPrecio(),
						getFechaCaducidad().format(formatter));

	}
}
