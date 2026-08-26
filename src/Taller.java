public class Taller extends Actividad {
    private boolean requiereNotebook;

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

    public void setRequiereNotebook(boolean requiereNotebook) {
        this.requiereNotebook = requiereNotebook;
    }

    public boolean getRequiereNotebook() {
        return this.requiereNotebook;
    }
}

