/**
 ** StubGen contiene funciones de generación de datos de prueba para limpiar el main
 */

public class StubGen {
    public static Estudiante[] crearEstudiantes() {
        return new Estudiante[] {
            new Estudiante("50501", "Alvaro Alvarez"),
            new Estudiante("50502", "Bernardo Beltran"),
            new Estudiante("50503", "Camila Canales")
        };
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
        // Podríamos validar id

        String[] nombresSala = { 
            "Sala de Conferencias de Electronica",
            "Salon de Usos Multiples",
            "Laboratorio SUN"
        };




        // ...






        return new Sala(id, nombresSala[id - 1]);
    }
}
