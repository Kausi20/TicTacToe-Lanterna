import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Kaushican Uthayakumaran
 * @version: 1.0
 * @date: 04.06.2020
 */

public class TicTacToe {

    static Scanner input;
    static String spieler;
    static String feld[];
    static String gewinner = null;

    public static void main(String[] args) {

        input = new Scanner(System.in);
        feld = new String[9];
        spieler = "X";

        emptyZahlen();

        System.out.println("TicTacToe");
        System.out.println("--------------------------------------");
        Layout();
        System.out.println("Spieler X ist dran");

        int zahlput;
        while (gewinner == null) {

            zahlput = input.nextInt();

            if (!(zahlput > 0 && zahlput <= 9)) {
                System.out.println("Nur Zahlen zwischen 1-9");
            }

            if(!(feld[zahlput-1] == "X" || feld[zahlput-1] == "O")){
                feld[zahlput-1] = spieler;
                Layout();
                for (int a = 0; a < 9; a++) {
                    if (Arrays.asList(feld).contains(String.valueOf(a + 1))) {
                        break;
                    } else if (a == 8){
                        gewinner = "draw";
                    }
                }
                gewinnerZahlen();
                if(gewinner == null){
                    playerChange();
                }else if(gewinner.equalsIgnoreCase("draw")){
                    System.out.println("Unentschieden!!!");
                } else {
                    System.out.println("Spieler "+gewinner+" hat gewonnen");
                }
            }else{
                System.out.println("Zahl benutzt! Andere Zahl eingeben");
            }
        }
    }

    public static void gewinnerZahlen(){
        for (int i = 0; i  <8; i++){
            String allThree = null;
            switch (i) {
                case 0:
                    allThree = feld[0] + feld[1] + feld[2];
                    break;
                case 1:
                    allThree = feld[3] + feld[4] + feld[5];
                    break;
                case 2:
                    allThree = feld[6] + feld[7] + feld[8];
                    break;
                case 3:
                    allThree = feld[0] + feld[3] + feld[6];
                    break;
                case 4:
                    allThree = feld[1] + feld[4] + feld[7];
                    break;
                case 5:
                    allThree = feld[2] + feld[5] + feld[8];
                    break;
                case 6:
                    allThree = feld[0] + feld[4] + feld[8];
                    break;
                case 7:
                    allThree = feld[2] + feld[4] + feld[6];
                    break;
            }
            if (allThree.equals("XXX")) {
               setGewinner();
            } else if (allThree.equals("OOO")) {
                setGewinner();
            }
        }
    }

    private static void setGewinner(){
        if(spieler == "X"){
            gewinner = "X";
        }else if(spieler == "O"){
            gewinner = "O";
        }
    }

    private static void playerChange(){
        if (spieler == "X"){
            spieler = "O";
            System.out.println("Spieler O ist dran");
        } else if (spieler == "O"){
            spieler = "X";
            System.out.println("Spieler X ist dran");
        }
    }

    public static void Layout(){
        System.out.println("|-----|-----|-----|");
        System.out.println("|  "+feld[0]+"  |  "+feld[1]+"  |  "+feld[2]+"  |");
        System.out.println("|-----|-----|-----|");
        System.out.println("|  "+feld[3]+"  |  "+feld[4]+"  |  "+feld[5]+"  |");
        System.out.println("|-----|-----|-----|");
        System.out.println("|  "+feld[6]+"  |  "+feld[7]+"  |  "+feld[8]+"  |");
        System.out.println("|-----|-----|-----|");
    }

    public static void emptyZahlen() {
        for (int i = 0; i < 9; i++) {
            feld[i] = String.valueOf(i+1);
        }
    }
}