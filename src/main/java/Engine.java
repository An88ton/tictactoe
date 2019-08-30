import java.util.Scanner;

public class Engine {
    private Game game;
    private String[][] field;
    Scanner scanner;

    public Engine(Game game){
        this.game = game;
        field = game.getField();
        scanner = new Scanner(System.in);
    }

    public void print(){
        for (String[] i: field){
            System.out.print("|");
            for (String j: i){
                System.out.print(j + "|");
            }
            System.out.println();
        }
    }
    public void battle(){
        while (!game.isEndOfGame()){
            print();
            makeStep();
        }
    }

    public void makeStep(){
        int line = 0;
        int column = 0;
        System.out.println("Print line and column:");
        char[] coord = scanner.nextLine().toCharArray();
        int counter = 0;
        for(int i = 0; i < coord.length; i++){
            if(Character.isDigit(coord[i]) && counter == 0){
                line = Character.digit(coord[i], 10);
                counter++;
            }
            if(Character.isDigit(coord[i]) && counter == 1){
                column = Character.digit(coord[i], 10);
            }
        }
       // System.out.println(line + " " + column);
        game.step(line, column);
    }




}
