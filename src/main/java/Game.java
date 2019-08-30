public class Game {
    private String[][] field;
    private int player;

    private boolean endOfGame;
    public Game(){
        field = new String[3][3];
        initialization();
        player = 1;
        endOfGame = false;
    }

    public void initialization(){
        for (int i = 0; i < field.length; i++){
            for(int j = 0; j < field[i].length; j++){
                field[i][j] = " ";
            }
        }
    }



    public boolean step(int line, int column) { // return true if step was made
        line--;
        column--;
        boolean worked = false;
        if(!endOfGame){
            if (!isCellTaken(line, column)) {
                worked = true;
                if (player % 2 != 0) {
                    field[line][column] = "0";
                    player--;
                } else {
                    field[line][column] = "X";
                    player++;
                }
            }else
                System.out.println("Cell already taken");
            }

        combinationsOfVictories();
        return worked;
    }
    public boolean isCellTaken(int line, int column){
        if(field[line][column] != " "){
            return true;
        }else
            return false;
    }



    public void endOfGame(String a) {
        endOfGame = true;
        System.out.println("Game has end");
        System.out.println(a + " won");
    }

    public boolean combinationsOfVictories(){
        if(field[0][0] != " " && field[0][0] == field[0][1] && field[0][1] == field[0][2]){
            endOfGame(field[0][0]);
            return true;
        }
        if(field[1][0] != " " && field[1][0] == field[1][1] && field[1][1] == field[1][2]){
            endOfGame(field[1][0]);
            return true;
        }
        if(field[2][0] != " " && field[2][0] == field[2][1] && field[2][1] == field[2][2]){
            endOfGame(field[2][0]);
            return true;
        }

        if(field[0][0] != " " && field[0][0] == field[1][0] && field[1][0] == field[2][0]){
            endOfGame(field[0][0]);
            return true;
        }
        if(field[0][1] != " " && field[0][1] == field[1][1] && field[1][1] == field[2][1]){
            endOfGame(field[0][1]);
            return true;
        }
        if(field[0][2] != " " && field[0][2] == field[1][2] && field[1][2] == field[2][2]){
            endOfGame(field[0][2]);
            return true;
        }

        if(field[0][0] != " " && field[0][0] == field[1][1] && field[1][1] == field[2][2]){
            endOfGame(field[0][0]);
            return true;
        }
        if(field[0][2] != " " && field[0][2] == field[1][1] && field[1][1] == field[2][0]){
            endOfGame(field[0][2]);
            return true;
        }
        return false;
    }


    public boolean isEndOfGame() {
        return endOfGame;
    }
    public String[][] getField() {
        return field;
    }

}
