import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

public abstract class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    private List<Inscripcion> inscripciones;

    public static final int CUPO_MINIMO = 1; // idk

    // ABSTRACT METHODS ON TOP
    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

    public Inscripcion inscribir(Estudiante estudiante) {
        // No se especifica constructor, pero inscripciones se puede
        // inicializar aca
        if (inscripciones == null) {
            inscripciones = new Vector<Inscripcion>();
        }

        Inscripcion nueva_inscripcion = new Inscripcion();

        nueva_inscripcion.setActividad(this);
        nueva_inscripcion.setEstudiante(estudiante);
        nueva_inscripcion.setFecha(LocalDate.now());
        nueva_inscripcion.setEstado("INSCRITO");

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

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCupoMaximo() {
        return this.cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }
}
