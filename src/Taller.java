public class Taller extends Actividad {
    private boolean requiereNotebook;

    public Taller (int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    @Override
    public double calcularCostoMateriales() {
        // $5000 si requieren uso de notebook
        // y $2000 si no requieren uso de notebook.
        return (requiereNotebook ? 5000d : 2000d);
    }

    @Override
    public String getTipo() {
        return "Taller";
    }

    public boolean getRequiereNotebook() {
        return this.requiereNotebook;
    }
}

