import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

public abstract class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    private List<Inscripcion> inscripciones;

    public static final int CUPO_MINIMO = 1; // idk

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
    }

    // ABSTRACT METHODS ON TOP
    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

    public Inscripcion inscribir(Estudiante estudiante) {
        // No se especifica constructor, pero inscripciones se puede
        // inicializar aca
        if (inscripciones == null) {
            inscripciones = new Vector<Inscripcion>();
        }

        Inscripcion nueva_inscripcion = 
            new Inscripcion(LocalDate.now(), "INSCRITO", this, estudiante);

        inscripciones.add(nueva_inscripcion);

        return nueva_inscripcion;
    }

    public void mostrarInscripciones() {
        if (inscripciones == null) {
            System.out.println("No hay inscriptos en esta actividad.");
        }

        System.out.println("Estudiantes inscriptos en actividad \"" + titulo + "\":");

        for (Inscripcion i : inscripciones) {
            Estudiante e = i.getEstudiante();
            System.out.println(e.getNombre() + " (L#" + e.getLegajo() + ")");
        }
    }

    public final void mostrarIdentificacion() {
        System.out.println(
                "ACTIVIDAD: \"" + this.titulo +   "\" (ID: " + this.id + ")"
        );
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getCupoMaximo() {
        return this.cupoMaximo;
    }
}
