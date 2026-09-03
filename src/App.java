//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    // Construyendo lista de estudiantes
    Estudiante[] estudiantes = StubGen.crearEstudiantes();

    // Agregando estudiantes al contexto general para no vincular directamente
    // con EventoUniversitario
    Context.addContextVar("Estudiantes", estudiantes);

    // Creando eventos universitarios
    EventoUniversitario[] eventos = StubGen.crearEventosUniversitarios();

    // Asignando salas a cada evento
    for (int i = 0; i < EventoUniversitario.getCantidadEventos(); i++) {
        eventos[i].asignarSala(StubGen.generarSala(i + 1));
    }

    // Creando actividades propias de cada evento
    eventos[0].crearActividad(1001, "Armar un Roomba con Arduino", 50, "Taller");
    eventos[0].crearActividad(1002, "Creando un home server con Arduino", 70, "Taller");

    eventos[1].crearActividad(2001, "Exposición de invenciones", 40, "Charla");
    eventos[1].crearActividad(2002, "Charla final", 50, "Charla");

    eventos[2].crearActividad(3001, "Onboarding", 80, "Charla");
    eventos[2].crearActividad(3002, "Sesión de trabajo", 80, "Taller");
    eventos[2].crearActividad(3003, "Exposición final", 80, "Charla");

    // Mostrando los datos de los eventos creados
    System.out.println("== DATOS DE EVENTOS EN BASE ==");
    for (EventoUniversitario e : eventos) {
        e.mostrarDatos();
    }

    // Mostrando contador de eventos con totalidad de eventos creados
    System.out.println("Cantidad de eventos en base: " +
            EventoUniversitario.getCantidadEventos());
}
