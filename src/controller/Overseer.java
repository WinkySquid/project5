package controller;

import models.List;
import view.Window;

public class Overseer {
	
	//INSTANCE VARIABLES
    private Window _w = new Window();
    private List _l;
    
    //STATIC FINAL VARIABLES
    public static final String[] PLAY_OR_EXIT = new String[]{"exit this world", "play this game", "mom help me I'm scared"};
    public static final String[] YES_OR_NO = new String[]{"Yes!", "No..."};

    //CONSTRUCTOR
    public Overseer() {
        this.start();
        do {
            int p = this.ask();
            this._l = new List(p);
            this.respond(this._l);
            this.askAgain();
        } while (true);
    }

    /*
	 * This method displays the starting option dialog box. It exits 
	 * the program, displays the help message dialog box, or starts 
	 * the game depending on what option the user chooses.
	 */
    public void start() {
    	boolean b = false;
    	while(!b) {
    		try {
    			int x = this._w.option(PLAY_OR_EXIT, "Baldi's Basics in Mathematics\n"
    	        		+ "(Loosely based on Baldi's Basics in Education and Learning)");
    	        if (x == 0) {
    	            this._w.msg("Looks like you don't want to do math anyways...\n"
    	            		+ "now we're sending you out of Baldi's world...\n"
    	            		+ "THE END");
    	            System.exit(0);
    	        } else if (x == 2) {
    	            this._w.msg("How to play:\n "
    	            		+ "Ask how many basic math questions (only addition and subtraction) you want to answer!\n "
    	            		+ "Answer all of them to the best of your abilities,\n"
    	            		+ "and you may win something SPECIAL...\n"
    	            		+ "Now you're ready to play!");
    	        }
    		}
    		catch(ArrayIndexOutOfBoundsException | NullPointerException e){
    			this._w.msg("Looks like you don't want to do math anyways...\n"
	            		+ "now we're sending you out of Baldi's world...\n"
	            		+ "THE END");
	            System.exit(0);
    		}
    	}
        
    }

    /*
     * This method sets the number of math problems that the user
     * likes to answer depending on the user's input and returns
     * that amount. It also catches any exceptions and displays
     * the warning messages accordingly.
     */
    public int ask() {
        int s2 = 0;
        boolean done = false;
        this._w.msg("As you enter your school,\nyou start to see Mr. Baldi with a sort of creepy smile.\nWhen you come into his classroom and get situated,\nhe then begins to say something in some weird voice...");
        while (!done) {
            try {
                String s = this._w.in("'Welcome to Baldi's Basics in MATHEMATICS!!!\nHow many problems would you like to solve?'");
                if (s.equals("exit") && !s.equals(null)) {
                    this._w.msg("welp, looks like you don't like math, so Baldi \n beats the devil out of you with his almighty wooden ruler.\n THE END");
                    System.exit(0);
                }
                if ((s2 = Integer.parseInt(s)) <= 0) {
                    this._w.msg("Baldi shakes his head at you and shouted:\n'And that's how many problems you want to ANSWER?!!?!??!??'");
                }
                done = true;
            }
            catch (NumberFormatException e) {
                this._w.msg("Baldi gives you his mini death stare as you realized you\nonly input an integer and nothing else.");
            }
            catch (NullPointerException n) {
                this._w.msg("As you exit this world of Baldi's basics and leave his classroom,\n Baldi said: 'You sneaky one...'");
                System.exit(0);
            }
        }
        return s2;
    }

    /*
     * This method displays the list of questions whose size depends on 
     * the user's input (the return value of the ask method) one question 
     * at a time and prompts the user to answer the questions. The method 
     * also counts how many questions the user has gotten right. When the
     * user has answered all the questions specified in l (the List object),
     * the method calculates the score (as a percent and displays it to the 
     * player. (It also catches any exceptions/errors and displays the warning 
     * messages accordingly.)
     */
    public void respond(List l) {
        int cnt = 0;
        for (int i = 0; i < l.getList().size(); ++i) {
            boolean b = false;
            while (!b) {
                try {
                    int s2;
                    String s = this._w.in("Problem " + (i + 1) + ": " + l.getList().get(i) + " = ");
                    if (s.equals("exit")) {
                        this._w.msg("Wwelp, looks like you don't want to solve more problems, so Baldi\n "
                        		+ "chases you around his classroom and then \n "
                        		+ "beats the devil out of you to death with his almighty wooden ruler.\n "
                        		+ "THE END");
                    }
                    if ((s2 = Integer.parseInt(s)) == l.getList().get(i).getResult()) {
                        this._w.msg("You sense that Baldi is liking you more,\nas you typed the right answer.\n"
                        		+ "He even said, 'You're incredible!'");
                        ++cnt;
                    } else {
                        this._w.msg("You feel Baldi's anger getting stronger as you\ninputted the wrong answer...\n"
                        		+ "Just don't do it next time.");
                    }
                    b = true;
                }
                catch (NumberFormatException e) {
                    this._w.msg("Baldi now says: 'You think this is funny? YOU'RE NOT SUPPOSED TO PUT ANYTHING\n"
                    		+ "OTHER THAN AN INTEGER ANSWER IN THE INPUT BOX !!!");
                }
                catch (NullPointerException n) {
                    this._w.msg("As you exit this world of Baldi's basics and leave his classroom,\n "
                    		+ "Baldi said: 'You sneaky one...'");
                    System.exit(0);
                }
            }
        }
        int x = (int)((double)cnt * 1.0 / (double)l.getList().size() * 100.0);
        if (x >= 90) {
            this._w.msg("Problems that you got right: " + cnt + "/" + l.getList().size() + "\n"
            		+ "Your score: " + x + "%\n" 
        + "Looks like you've REALLY shown your mathematical talent,\n" + 
            		"as Baldi gives you his look of approval...and a shiny U.S. quarter.");
        } else {
            this._w.msg("Problems that you got right: " + cnt + "/" + l.getList().size() + "\n"
            		+ "Your score: " + x + "%\n" 
            		+ "It seems that you're going to have a bad time\n" 
            		+ "as he gives you his ultimate death stare...\n" + "(I WARNED YOU...)");
        }
    }

    /*
     * This method asks if the player wants to play again and exits the
     * program or restarts the game depending on the user's option.
     */
    public void askAgain() {
        int a = this._w.option(YES_OR_NO, "Would you like to try again and get a better score\nso that you can impress Baldi once more?");
        if (a == 1) {
            this._w.msg("Baldi left you alone as you made your way\nout of his classroom. THE END");
            System.exit(0);
        }
    }
}

