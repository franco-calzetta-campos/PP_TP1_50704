/**
 ** StubGen contiene funciones de generación de datos de prueba para limpiar el main
 */

public class StubGen {
    public static Estudiante[] crearEstudiantes() {
        Estudiante[] estudiantes = new Estudiante[5];

        estudiantes[0] = new Estudiante("Alvaro Alvarez", "50501");
        estudiantes[0] = new Estudiante("Bernardo Beltran", "50502");
        estudiantes[0] = new Estudiante("Camila Canales", "50503");
        estudiantes[0] = new Estudiante("Diego D'Avalos", "50504");
        estudiantes[0] = new Estudiante("Ernestina Estevanez", "50505");

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
        String[] nombresSala = { 
            "Sala de Conferencias de Electronica",
            "Salon de Usos Multiples",
            "Laboratorio SUN"
        };

        return new Sala(id, nombresSala[id - 1]);
    }
}
