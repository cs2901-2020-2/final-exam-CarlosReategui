package blockudoku;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

public class BlockudokuTest {

    @Test
    public void printOpcionesTest() {
        Blockudoku.printOpciones();
        assertTrue(true, "dado que solo son prints, se coloca un assert true");
    }

    @Test
    public void elegirPiezaTest() {
        for (int i = 1; i <= 8; ++i) {
            Pieza p = Blockudoku.elegirPieza(i);
            assertNotNull(p);
        }
        Pieza p = Blockudoku.elegirPieza(0);
        assertNull(p);
    }

    @Test
    public void printBoardTest() {
        Blockudoku.printBoard();
        assertTrue(true, "dado que solo son prints, se coloca un assert true");
    }

    @Test
    public void ponerPiezaTest() {
        Pieza p = Piezas.getBloqueLGrande();
        Blockudoku.initTable();
        boolean expected = Blockudoku.ponerPieza(p, 1, 3);
        assertTrue(expected);
    }


    @Test
    public void constructorTest() {
        Blockudoku b = new Blockudoku();
        assertTrue(true, "assert de que no de error el constructor");
    }

    @Test
    public void ponerPiezaEncimaDeOtraTest() {
        Pieza p = Piezas.getBloqueLGrande();
        Blockudoku.initTable();
        Blockudoku.ponerPieza(p, 1, 3);
        boolean expected = Blockudoku.ponerPieza(p, 1, 3);
        assertFalse(expected);
    }

    @Test
    public void checkPointsTest() {
        Blockudoku.initTable();
        int p = Blockudoku.checkPuntaje();
        assertEquals(p, 0);
    }
}
