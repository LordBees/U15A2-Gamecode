package Assignment.game;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //boolean run_game = true;
        System.out.println(" a game called\n" +
                "    .___                                          ._.\n" +
                "  __| _/___________     ____   ____   ____   _____| |\n" +
                " / __ |\\_  __ \\__  \\   / ___\\ /  _ \\ /    \\ /  ___/ |\n" +
                "/ /_/ | |  | \\// __ \\_/ /_/  >  <_> )   |  \\\\___ \\ \\|\n" +
                "\\____ | |__|  (____  /\\___  / \\____/|___|  /____  >__\n" +
                "     \\/            \\//_____/             \\/     \\/ \\/");
        Gameloop gamex = new Gameloop();
        gamex.run();
        //while (!gamex.getquittime()) {
//
//            gamex.run();
//        }
    }
}
