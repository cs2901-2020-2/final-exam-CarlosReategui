package blockudoku;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Blockudoku {

    static final int N = 9;

    private static String[][] table = new String[N][N];

    static final Logger logger = Logger.getLogger(Blockudoku.class.getName());

    private static int score = 0;

    public Blockudoku() {
        initTable();
    }

    public static void initTable() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                table[i][j] = "-";
            }
        }
    }

    public static void printOpcion(int opcion, Pieza pieza) {
        StringBuilder line = new StringBuilder("Opcion ").append(opcion);
        if (logger.isLoggable(Level.INFO))
            logger.info(line.toString());
        pieza.printPieza();
    }

    public static void printOpciones() {
        printOpcion(1, Piezas.getBloqueColumna());
        printOpcion(2, Piezas.getBloqueFila());
        printOpcion(3, Piezas.getBloqueLChica());
        printOpcion(4, Piezas.getBloqueLChicaVolteada());
        printOpcion(5, Piezas.getBloqueT());
        printOpcion(6, Piezas.getBloqueTVolteado());
        printOpcion(7, Piezas.getBloqueLGrande());
        printOpcion(8, Piezas.getBloqueLGrandeVolteada());
    }


    public static Pieza elegirPieza(int opcion) {
        switch (opcion) {
            case 1:
                return Piezas.getBloqueColumna();
            case 2:
                return Piezas.getBloqueFila();
            case 3:
                return Piezas.getBloqueLChica();
            case 4:
                return Piezas.getBloqueLChicaVolteada();
            case 5:
                return Piezas.getBloqueT();
            case 6:
                return Piezas.getBloqueTVolteado();
            case 7:
                return Piezas.getBloqueLGrande();
            case 8:
                return Piezas.getBloqueLGrandeVolteada();
            default:
                return null;
        }
    }

    private static boolean piezaChoca(Pieza pieza, int x, int y) {
        Integer[][] forma = pieza.getForma();
        for (int i = 0; i < pieza.getAltura(); ++i) {
            for (int j = 0; j < pieza.getAncho(); ++j) {
                if (table[i + x - 1][y - pieza.getAncho() + j].equals("*") && forma[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean ponerPieza(Pieza pieza, int x, int y) {
        if (piezaChoca(pieza, x, y)) {
            return false;
        }
        Integer[][] forma = pieza.getForma();
        if (pieza.getAncho() - x >= 0 && y - pieza.getAltura() >= 0) {
            for (int i = 0; i < pieza.getAltura(); ++i) {
                for (int j = 0; j < pieza.getAncho(); ++j) {
                    if (forma[i][j] == 1) {
                        table[i + x - 1][y - pieza.getAncho() + j] = String.valueOf('*');
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static int ingresarCoordenada(Scanner in, String coordenada) {
        int punto;
        StringBuilder s = new StringBuilder("Ingrese ").append(coordenada).append(" (entre 1 y 9)");
        do {
            if (logger.isLoggable(Level.INFO))
                logger.info(s.toString());
            punto = in.nextInt();
        } while (punto < 1 || punto > 9);
        return punto;
    }

    static void printBoard() {
        for (int i = 0; i < N; ++i) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < N; ++j) {
                line.append(table[i][j]);
            }
            line.append("\n");
            if (logger.isLoggable(Level.INFO))
                logger.info(line.toString());
        }
    }

    public static int checkPuntaje() {
        int p1 = checkCuadrantes();
        int p2 = checkVertical();
        int p3 = checkHorizontal();
        int bloques = p1 + p2 + p3;
        int currentScore = p1 * 150 + p2 * 120 + p3 * 120;
        if (bloques >= 3) {
            currentScore *= bloques;
        }
        score += currentScore;
        return currentScore;
    }

    public static int checkCuadrantes() {
        return 0;
    }

    public static int checkVertical() {
        int totalBlocks = 0;
        for (int i = 0; i < N; ++i) {
            totalBlocks += 1;
            for (int j = 0; j < N; ++j) {
                if (table[j][i].equals("-")) {
                    totalBlocks -= 1;
                    break;
                }
            }
        }
        return totalBlocks;
    }

    public static int checkHorizontal() {
        int totalBlocks = 0;
        for (int i = 0; i < N; ++i) {
            totalBlocks += 1;
            for (int j = 0; j < N; ++j) {
                if (table[i][j].equals("-")) {
                    totalBlocks -= 1;
                    break;
                }
            }
        }
        return totalBlocks;
    }

    public static void main(String[] args) {
        initTable();
        Scanner in = new Scanner(System.in);
        while (true) {
            printBoard();
            int x = ingresarCoordenada(in, "X");
            int y = ingresarCoordenada(in, "Y");
            printOpciones();
            int opcion;
            logger.info("Seleccione una opcion (coloque un número fuera del rango para salir):");
            opcion = in.nextInt();
            Pieza piezaElegida = elegirPieza(opcion);
            if (piezaElegida == null) {
                break;
            }
            if (!ponerPieza(piezaElegida, x, y) && logger.isLoggable(Level.INFO)) {
                logger.info("La pieza no es válida. Volver a intentar");
            }
        }
    }
}
