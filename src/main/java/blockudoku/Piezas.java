package blockudoku;

public interface Piezas {
    static Pieza getBloqueLGrande() {
        Integer[][] forma = {
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 1}
        };
        return new Pieza(forma, 3, 3);
    }

    static Pieza getBloqueLGrandeVolteada() {
        Integer[][] forma = {
                {1, 1, 1},
                {0, 0, 1},
                {0, 0, 1},
        };
        return new Pieza(forma, 3, 3);
    }

    static Pieza getBloqueFila() {
        Integer[][] forma = {
                {1, 1, 1},
        };
        return new Pieza(forma, 1, 3);
    }

    static Pieza getBloqueColumna() {
        Integer[][] forma = {
                {1},
                {1},
                {1}
        };
        return new Pieza(forma, 3, 1);
    }

    static Pieza getBloqueT() {
        Integer[][] forma = {
                {1, 1, 1},
                {0, 1, 0},
                {0, 1, 0},
        };
        return new Pieza(forma, 3, 3);
    }

    static Pieza getBloqueTVolteado() {
        Integer[][] forma = {
                {0, 1, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        return new Pieza(forma, 3, 3);
    }

    static Pieza getBloqueLChica() {
        Integer[][] forma = {
                {1, 0},
                {1, 0},
                {1, 1},
        };
        return new Pieza(forma, 3, 2);
    }

    static Pieza getBloqueLChicaVolteada() {
        Integer[][] forma = {
                {1, 1},
                {1, 0},
                {1, 0},
        };
        return new Pieza(forma, 3, 2);
    }
}
