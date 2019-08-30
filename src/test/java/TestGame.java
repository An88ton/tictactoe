import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestGame {
    Game game;
    String[][] field;
    @Before
    public void init(){
        game = new Game();
        field = game.getField();
    }
    @Test
    public void isFieldHaveCorrectSize(){

        assertEquals(field.length, 3);
        for(int i = 0; i < field.length; i++){
           assertEquals(field[i].length, 3);
        }
    }
    @Test
    public void isInitialisationFillsField(){
        for(String[] i : field){
            for (String j: i){
                assertEquals(j, " ");
            }
        }
    }
    @Test
    public void isStepChangesField(){
        game.step(1,2);
        assertEquals(field[0][1], "0");
    }
    @Test
    public void isCellTakenMustReturnTrue() {
        assertTrue(!game.isCellTaken(1,1));
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = "X";
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                assertTrue(game.isCellTaken(i, j));
            }
        }
    }

    @Test
    public void isStepFillsCells(){
        assertTrue(!game.isCellTaken(0, 0));
        game.step(1,1);
        assertTrue(game.isCellTaken(0, 0));
    }

    @Test
    public void isEndOfGameStopsGame(){
        game.endOfGame("X");
        assertTrue(!game.step(1, 1));
    }
    @Test
    public void isCombinationOfVictoriesStopsTheGame(){
        game.step(1, 1);
        game.step(2, 1);
        game.step(1, 2);
        game.step(2, 2);
        game.step(1, 3);
        assertTrue(game.combinationsOfVictories());
    }

    }






