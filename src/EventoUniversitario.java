import java.util.List;
import java.util.Vector;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;
    private Sala sala;
    /* No es posible respetar la cardinalidad 1..* con las restricciones de
     * constructor y composicion. i.e. resulta imposible garantizar la
     * existencia de un mínimo de 1 actividad al inicio del ciclo de vida del
     * objeto
     */
    private List<Actividad> actividades;

    public EventoUniversitario(
            String id,
            String titulo,
            double costoBase,
            boolean gratuito)
    {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;

        /*
         * Considerando que:
         * - La cardinalidad de composicion es de 1 (no 0..1)
         * - No se plantea en el ejercicio que se asigne una sala por constructor
         * - Se asigna una sala solamente con la funcion asignarSala(sala: Sala)
         *
         * Se opta por un valor por defecto que se sobreescribirá al invocar asignarSala.
         */
        this.sala = new Sala(-1, "SIN SALA");

        this.actividades = new Vector<>();

        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        // Se asume por la premisa del resultado esperado que se espera que la
        // cantidad total incluya las copias, ergo se usa el mismo constructor
        // parametrizado
        this(
                otro.id,
                otro.titulo,
                otro.costoBase,
                otro.gratuito);
    }

    public double calcularCostoEstimado() {
        if (gratuito) return 0d;

        double costoEstimado = costoBase;

        if (actividades != null) {
            for (Actividad a : actividades) {
                costoEstimado += a.calcularCostoMateriales();
            }
        }

        return costoEstimado * 1.21d;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupo, String tipo) {
        /*
         * Como no hay constructor especiicado ni funcion específica de
         * validacion del cupo especificado, se opta por que se valide aquí
         */
        if (cupo < Actividad.CUPO_MINIMO) {
            System.err.println("ERROR: CREANDO ACTIVIDAD CON CUPO MENOR AL"
                    + " MINIMO, ABORTANDO CREACION DE ACTIVIDAD.\n");
            return;
        }

        Actividad nueva_actividad;

        // Lamentablemente no se puede hacer con switch
        if (tipo.equals("Charla")) {
            nueva_actividad = new Charla(id, titulo, cupo, "Pepe Hongo");
        }
        else if (tipo.equals("Taller")) {
            nueva_actividad = new Taller(id, titulo, cupo, true);
        }
        else {
            System.err.println("ERROR: INGRESADO TIPO DE ACTIVIDAD INVALIDO."
                    + " ABORTANDO CREACION DE ACTIVIDAD.");
            return;
        }

        // Hardcodeando inscripcion de estudiantes
        Estudiante[] estudiantes = (Estudiante[])(Context.getContextVar("Estudiantes"));
        if (estudiantes != null) {
            // Inscribir a todos los estudiantes
            for (Estudiante e : estudiantes) {
                nueva_actividad.inscribir(e);
            }
        }

        actividades.add(nueva_actividad);
    }

    public void mostrarDatos() {
        System.out.println(
                "Evento \"" + this.titulo + "\" (ID#" + this.id + "):\n"
                        +   "Gratuito: " + (gratuito ? "SI" : "NO") + "\n\n"
                        +   "Costo: ARS " + calcularCostoEstimado() + "\n"
                        +   "Actividades:"
        );

        for (Actividad a : actividades) {
            System.out.println(
                    "Actividad " + a.getId() + ": " + a.getTitulo() + "\nTipo: " + a.getTipo()
            );
            switch (a.getTipo()) {
                case "Charla":
                    System.out.println("Disertante: " + ((Charla)a).getDisertante());
                    break;
                case "Taller":
                    System.out.println(
                            "Requiere notebook: "
                        +   (((Taller)a).getRequiereNotebook() ? "SI" : "NO" )
                    );
                    break;
            }


            // Asumimos en este punto que no hay tipos incorrectos

            a.mostrarInscripciones();
            System.out.println();
        }
        System.out.println();
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    // Quite los getters/setters porque para eso están el constructor y mostrarDatos
}
