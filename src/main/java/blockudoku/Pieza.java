package blockudoku;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pieza {
    private Integer[][] forma;
    private int altura;
    private int ancho;

    Logger logger = Logger.getLogger(Pieza.class.getName());

    public Pieza(Integer[][] forma, int altura, int ancho) {
        this.forma = forma;
        this.altura = altura;
        this.ancho = ancho;
    }

    public Integer[][] getForma() {
        return forma;
    }

    public int getAltura() {
        return altura;
    }

    public int getAncho() {
        return ancho;
    }

    public void printPieza() {
        for (int i = 0; i < this.getAltura(); ++i) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < this.getAncho(); ++j) {
                if (this.getForma()[i][j] == 1) {
                    line.append('*');
                } else {
                    line.append('-');
                }
            }
            line.append('\n');
            if (logger.isLoggable(Level.INFO))
                logger.info(line.toString());
        }
    }
}
