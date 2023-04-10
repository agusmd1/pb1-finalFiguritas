package ar.edu.unlam.pb1.album;

public class Album {

	private static String selecciones[] = { "Qatar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Irán", "EEUU",
			"Gales", "Argentina", "Arabia Saudita", "México", "Polonia", "Francia", "Australia", "Dinamarca", "Tunez",
			"España", "Costa Rica", "Alemania", "Japón", "Bélgica", "Canadá", "Marruecos", "Croacia", "Brasil",
			"Serbia", "Suiza", "Camerún", "Portugal", "Ghana", "Uruguay", "Corea del Sur" };

	private static Figurita figuritasDisponibles[] = new Figurita[704];

	private Figurita figuritasActuales[];

	public Album() {
		/*
		 * El constructor debe generar las condiciones necesaias para garantizar el
		 * correcto funcionamiento de la app
		 */
		this.figuritasActuales = new Figurita[704];
	}

	public static void inicializarCodigosDeFiguritas() {
		int figusCount = 0;
		String codigoSeleccion = " ";
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 22; j++) {
				codigoSeleccion = selecciones[i];
				codigoSeleccion = codigoSeleccion.substring(0, 3).toUpperCase();
				codigoSeleccion += j + 1;
				figuritasDisponibles[figusCount] = new Figurita(codigoSeleccion);
				figusCount++;
			}
		}
		/*
		 * Por cada país debe generar 22 códigos de manera automática por ejemplo QAT1,
		 * URU12, COS10
		 */

	}

	public static void actualizarDatosFigurita(String codigo, char grupo, String nombreJugador, double valor) {
		for (int i = 0; i < figuritasDisponibles.length; i++) {
			if (figuritasDisponibles[i].getCodigo().equals(codigo)) {
				figuritasDisponibles[i].setGrupo(grupo);
				figuritasDisponibles[i].setNombreJugador(nombreJugador);
				figuritasDisponibles[i].setValor(valor);
			}
		}
		/*
		 * En función del código de figurita, se deben actualizar los datos de la misma
		 * en figuritasDisponibles
		 */
	}

	public static Figurita getFigurita(String codigo) {
		Figurita figuAux = new Figurita(" ");
		/*
		 * En función del código de figurita, devuelve la figurita de
		 * figuritasDisponibles
		 */
		for (int i = 0; i < figuritasDisponibles.length; i++) {
			if (figuritasDisponibles[i].getCodigo().equals(codigo)) {
				figuAux = figuritasDisponibles[i];
			}
		}
		return figuAux;
	}

	public Figurita[] comprarSobre() {
		/*
		 * Se debe calcular y devolver 5 códigos de figurita de manera aleatoria.
		 */
		Figurita sobre[] = new Figurita[5];
		int numeroRandom = 0;

		for (int i = 0; i < 5; i++) {
			numeroRandom = (int) (Math.random() * 704);
			sobre[i] = figuritasDisponibles[numeroRandom];
		}
		return sobre;
	}

	public void agregarFigurita(Figurita nueva) {
		/*
		 * Agrega una nueva figurita al array figuritasActuales
		 */
		for (int j = 0; j < figuritasActuales.length; j++) {
			if (figuritasActuales[j] != null && figuritasActuales[j].getCodigo().equals(nueva.getCodigo())) {
				break;
			}
		}

		for (int i = 0; i < figuritasActuales.length; i++) {
			if (figuritasActuales[i] == null) {
				figuritasActuales[i] = nueva;
				break;
			}
		}

	}

	public void ordenarFiguritasActuales() {
		/*
		 * Debe ordenar el array figuritasActuales
		 */
	}

	public boolean elAlbumEstaCompleto() {
		/*
		 * Debe verificar que todas las figuritas disponibles estén presentes al menos
		 * una vez en las figuritas actuales
		 */
		for (int i = 0; i < figuritasActuales.length; i++) {
			if (figuritasActuales[i] == null
					|| !figuritasActuales[i].getCodigo().equals(figuritasDisponibles[i].getCodigo())) {
				return false;
			}
		}
		return true;
	}

	public double calcularPorcentajeCompletado() {
		double figusContadas = 0.0;
		double figusTotales = 0.0;
		/*
		 * Debe calcular el porcentaje de figuritas del album que está completo. Para
		 * esto se debe basar en la información de las figuritasDisponibles en relación
		 * a las figuritasActuales que se tiene en el album.
		 */
		for (int i = 0; i < figuritasActuales.length; i++) {
			if (figuritasActuales[i] != null) {
				figusContadas++;
			}
		}
		figusTotales = (figusContadas * 100) / 704;
		return figusTotales;
	}

}