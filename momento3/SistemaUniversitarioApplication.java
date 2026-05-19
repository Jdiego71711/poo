package momento3;

import java.util.Scanner;

public class SistemaUniversitarioApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EstudianteService estudianteService =
                new EstudianteService();

        UndoRedoService undoRedoService =
                new UndoRedoService();

        Aula aula = new Aula("101");

        int opcion;

        do {

            System.out.println();
            System.out.println("=================================================");
            System.out.println("PLANIFICACION ACADEMICA - SISTEMA UNIVERSITARIO");
            System.out.println("=================================================");

            System.out.println();
            System.out.println("=== GESTION DE ESTUDIANTES ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante por ID");
            System.out.println("3. Listar todos los estudiantes");
            System.out.println("4. Eliminar estudiante");

            System.out.println();
            System.out.println("=== GESTION DE MATERIAS ===");
            System.out.println("5. Crear materia");
            System.out.println("6. Agregar pre-requisito");
            System.out.println("7. Mostrar pre-requisitos");
            System.out.println("8. Inscribir estudiante");
            System.out.println("9. Cancelar inscripcion");
            System.out.println("10. Mostrar cola de espera");

            System.out.println();
            System.out.println("=== GESTION DE HORARIOS ===");
            System.out.println("11. Reservar horario en aula");
            System.out.println("12. Liberar horario");
            System.out.println("13. Consultar disponibilidad");

            System.out.println();
            System.out.println("=== RUTAS ENTRE EDIFICIOS ===");
            System.out.println("14. Agregar conexion entre edificios");
            System.out.println("15. Calcular ruta mas corta");

            System.out.println();
            System.out.println("=== REPORTES ACADEMICOS ===");
            System.out.println("16. Registrar nota");
            System.out.println("17. Ver reporte academico");
            System.out.println("18. Navegador de reportes");

            System.out.println();
            System.out.println("=== SISTEMA DESHACER/REHACER ===");
            System.out.println("19. Deshacer ultima operacion");
            System.out.println("20. Rehacer ultima operacion");

            System.out.println();
            System.out.println("=== PROCESAMIENTO POR LOTES ===");
            System.out.println("21. Procesar archivo CSV");

            System.out.println();
            System.out.println("22. Salir");

            System.out.println();
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println();
                    System.out.println("=== REGISTRAR ESTUDIANTE ===");

                    System.out.print("ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Semestre: ");
                    int semestre = scanner.nextInt();
                    scanner.nextLine();

                    Estudiante estudiante =
                            new Estudiante(
                                    nombre,
                                    id,
                                    email,
                                    semestre
                            );

                    estudianteService.registrarEstudiante(
                            estudiante
                    );

                    undoRedoService.guardarOperacion(
                            "Registro estudiante"
                    );

                    System.out.println();
                    System.out.println(
                            "Estudiante registrado exitosamente"
                    );

                    break;

                case 2:

                    System.out.println();
                    System.out.println(
                            "=== BUSCAR ESTUDIANTE ==="
                    );

                    System.out.print("Ingrese ID: ");

                    String buscarId = scanner.nextLine();

                    Estudiante encontrado =
                            estudianteService.buscarPorId(
                                    buscarId
                            );

                    if (encontrado != null) {

                        System.out.println();
                        System.out.println(
                                "ESTUDIANTE ENCONTRADO"
                        );

                        encontrado.mostrarInformacion();

                    } else {

                        System.out.println();
                        System.out.println(
                                "No existe estudiante con ese ID"
                        );
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println(
                            "=== LISTA DE ESTUDIANTES ==="
                    );

                    estudianteService.listarEstudiantes();

                    break;

                case 4:

                    System.out.println();
                    System.out.println(
                            "=== ELIMINAR ESTUDIANTE ==="
                    );

                    System.out.print("Ingrese ID: ");

                    String eliminarId =
                            scanner.nextLine();

                    estudianteService.eliminarEstudiante(
                            eliminarId
                    );

                    undoRedoService.guardarOperacion(
                            "Eliminar estudiante"
                    );

                    System.out.println();
                    System.out.println(
                            "Estudiante eliminado"
                    );

                    break;

                case 5:

                    System.out.println();
                    System.out.println(
                            "=== CREAR MATERIA ==="
                    );

                    System.out.print("Codigo: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombreMateria =
                            scanner.nextLine();

                    System.out.print("Cupos maximos: ");
                    int cupos = scanner.nextInt();

                    System.out.print("Creditos: ");
                    int creditos = scanner.nextInt();
                    scanner.nextLine();

                    new Materia(
                            codigo,
                            nombreMateria,
                            cupos,
                            creditos
                    );

                    System.out.println();
                    System.out.println(
                            "Materia creada correctamente"
                    );

                    break;

                case 6:

                    System.out.println();
                    System.out.println(
                            "=== AGREGAR PRE-REQUISITO ==="
                    );

                    break;

                case 7:

                    System.out.println();
                    System.out.println(
                            "=== MOSTRAR PRE-REQUISITOS ==="
                    );

                    break;

                case 8:

                    System.out.println();
                    System.out.println(
                            "=== INSCRIBIR ESTUDIANTE ==="
                    );

                    break;

                case 9:

                    System.out.println();
                    System.out.println(
                            "=== CANCELAR INSCRIPCION ==="
                    );

                    break;

                case 10:

                    System.out.println();
                    System.out.println(
                            "=== MOSTRAR COLA DE ESPERA ==="
                    );

                    break;

                case 11:

                    System.out.println();
                    System.out.println(
                            "=== RESERVAR HORARIO ==="
                    );

                    System.out.print("Dia: ");
                    int dia = scanner.nextInt();

                    System.out.print("Hora: ");
                    int hora = scanner.nextInt();

                    System.out.print("Duracion: ");
                    int duracion = scanner.nextInt();
                    scanner.nextLine();

                    aula.reservar(
                            dia,
                            hora,
                            duracion
                    );

                    undoRedoService.guardarOperacion(
                            "Reservar horario"
                    );

                    System.out.println();
                    System.out.println(
                            "Horario reservado"
                    );

                    break;

                case 12:

                    System.out.println();
                    System.out.println(
                            "=== LIBERAR HORARIO ==="
                    );

                    System.out.print("Dia: ");
                    int diaLiberar = scanner.nextInt();

                    System.out.print("Hora: ");
                    int horaLiberar = scanner.nextInt();

                    System.out.print("Duracion: ");
                    int duracionLiberar =
                            scanner.nextInt();
                    scanner.nextLine();

                    aula.liberar(
                            diaLiberar,
                            horaLiberar,
                            duracionLiberar
                    );

                    System.out.println();
                    System.out.println(
                            "Horario liberado"
                    );

                    break;

                case 13:

                    System.out.println();
                    System.out.println(
                            "=== CONSULTAR DISPONIBILIDAD ==="
                    );

                    System.out.print("Dia: ");
                    int diaConsulta = scanner.nextInt();

                    System.out.print("Hora: ");
                    int horaConsulta =
                            scanner.nextInt();
                    scanner.nextLine();

                    boolean disponible =
                            aula.consultarDisponibilidad(
                                    diaConsulta,
                                    horaConsulta
                            );

                    if (disponible) {

                        System.out.println(
                                "Horario disponible"
                        );

                    } else {

                        System.out.println(
                                "Horario ocupado"
                        );
                    }

                    break;

                case 14:

                    System.out.println();
                    System.out.println(
                            "=== AGREGAR CONEXION ==="
                    );

                    break;

                case 15:

                    System.out.println();
                    System.out.println(
                            "=== RUTA MAS CORTA ==="
                    );

                    Dijkstra dijkstra =
                            new Dijkstra(5);

                    dijkstra.agregarConexion(
                            0,
                            1,
                            100
                    );

                    dijkstra.agregarConexion(
                            1,
                            2,
                            150
                    );

                    dijkstra.agregarConexion(
                            2,
                            3,
                            200
                    );

                    dijkstra.agregarConexion(
                            3,
                            4,
                            250
                    );

                    dijkstra.dijkstra(0);

                    break;

                case 16:

                    System.out.println();
                    System.out.println(
                            "=== REGISTRAR NOTA ==="
                    );

                    break;

                case 17:

                    System.out.println();
                    System.out.println(
                            "=== VER REPORTE ACADEMICO ==="
                    );

                    break;

                case 18:

                    System.out.println();
                    System.out.println(
                            "=== NAVEGADOR REPORTES ==="
                    );

                    break;

                case 19:

                    System.out.println();
                    System.out.println(
                            "=== DESHACER ==="
                    );

                    undoRedoService.deshacer();

                    break;

                case 20:

                    System.out.println();
                    System.out.println(
                            "=== REHACER ==="
                    );

                    undoRedoService.rehacer();

                    break;

                case 21:

                    System.out.println();
                    System.out.println(
                            "=== PROCESAR CSV ==="
                    );

                    break;

                case 22:

                    System.out.println();
                    System.out.println(
                            "Saliendo del sistema..."
                    );

                    break;

                default:

                    System.out.println();
                    System.out.println(
                            "ERROR: Opcion invalida"
                    );
            }

        } while (opcion != 22);

        scanner.close();
    }
}