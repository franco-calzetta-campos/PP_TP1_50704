/**
 ** StubGen contiene funciones de generación de datos de prueba para limpiar el main
 */

public class StubGen {
    public static Estudiante[] crearEstudiantes() {
        Estudiante[] estudiantes = new Estudiante[5];

        estudiantes[0] = new Estudiante();
        estudiantes[1] = new Estudiante();
        estudiantes[2] = new Estudiante();
        estudiantes[3] = new Estudiante();
        estudiantes[4] = new Estudiante();

        estudiantes[0].setNombre("Alvaro Alvarez");
        estudiantes[1].setNombre("Bernardo Beltran");
        estudiantes[2].setNombre("Camila Canales");
        estudiantes[3].setNombre("Diego D'Avalos");
        estudiantes[4].setNombre("Ernestina Estevanez");

        estudiantes[0].setLegajo("50501");
        estudiantes[1].setLegajo("50502");
        estudiantes[2].setLegajo("50503");
        estudiantes[3].setLegajo("50504");
        estudiantes[4].setLegajo("50505");

        return estudiantes;
    }

    public static EventoUniversitario[] crearEventosUniversitarios() {
        return new EventoUniversitario[]
            {
                new EventoUniversitario(
                    "A87E45",
                    "Charla de Arduino",
                    150000d,
                    false
                ),
                new EventoUniversitario(
                    "HK18HZ",
                    "Expo Cybercirujas",
                    250000d,
                    true
                ),
                new EventoUniversitario(
                    "PP210M",
                    "Competencia Game Jam",
                    325000d,
                    true
                )
            };
    }

    public static Sala generarSala(int id) {
        Sala sala = new Sala();

        switch (id) {
            case 1:
                sala.setId(1);
                sala.setNombre("Sala de Conferencias de Electronica");
                break;

            case 2:
                sala.setId(2);
                sala.setNombre("Salon de Usos Multiples");

            case 3:
                sala.setId(3);
                sala.setNombre("Laboratorio SUN");

            default:
                // No hay default según dicen
        }

        return sala;
    }
}
