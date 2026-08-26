public class Charla extends Actividad {
    private String disertante;

    @Override
    public double calcularCostoMateriales() {
        // Las charlas son gratuitas
        return 0d;
    }

    @Override
    public String getTipo() {
        return "Charla";
    }

    public void setDisertante(String disertante) {
        this.disertante = disertante;
    }

    public String getDisertante() {
        return this.disertante;
    }
}
