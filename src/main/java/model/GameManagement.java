package model;

import java.util.ArrayList;

public class GameManagement {
    private Dice diceOne;
    private Dice diceTwo;
    private ArrayList<Player> players;
    private byte level;

    public GameManagement() {
        diceOne = new Dice();
        diceTwo = new Dice();
    }

    public void rollDices() {
        byte d_1 = (byte) ((Math.random() * 6) + 1);
        byte d_2 = (byte) ((Math.random() * 6) + 1);

        this.diceOne.setEdge( d_1 );
        this.diceTwo.setEdge( d_2 );
    }

    public Dice getDiceOne() {
        return diceOne;
    }

    public Dice getDiceTwo() {
        return diceTwo;
    }

    public byte getLevel() {//ESTE LO AGREGE
        return level;
    }

    public void nPlayers() {
        players = new ArrayList<>(5);
        for (int i = 1; i <= 5; i++) {
            String id = String.valueOf( i );
            players.add(new Player( id, level));
        }
    }

    //LO DE LOS NIVELES
    public void chooseLevel(int level) {
        if ( level == 0 )
            this.level = 20;
        else if ( level == 1 )
            this.level = 30;
        else if ( level == 2 )
            this.level = 50;
    }

    public Player intialPlayer() {
        int n = (int) ((Math.random() * players.size()) + 1);
        System.out.println("Jugador alzar: " + n);
        String id = String.valueOf(n);
        return findPlayer(id);
    }

    public Player findPlayer(String id) {
        for (Player pls : players) {
            if ( pls.getId().equals( id ) ) {
                return pls;
            }
        }
        return null;
    }

    public Player nextPlayer(Player player) {
        int indexAct = players.indexOf(player);
        //System.out.println("Indice act: " + indexAct);
        return indexAct == (players.size() - 1) ? players.get(0) : players.get(indexAct + 1);
    }

    public ArrayList<Player> getPlayers() {
        return (ArrayList<Player>) players.clone();
    }

    public boolean pair() {
        return ( diceOne.getEdge() == diceTwo.getEdge() );
    }

    public boolean finish(int points) {
        return ( points >= level );
    }

    public boolean pairThree(Player player) {
        return player.getContP() == 3;
    }

    public void addPoints(Player player) {
        int index = players.indexOf(player);
        byte advan = (byte) (diceOne.getEdge() + diceTwo.getEdge()) == 1 ? 7 : (byte) (diceOne.getEdge() + diceTwo.getEdge());//MODIFIQUE AQUI
        //System.out.println( "r = " + advan);
        players.get(index).advance(advan);
    }

    public void returns(Player player) {
        int index = -1;//ESTO NO ESTA FUNCINANDO HAHA
        for (int i = 0; i < players.size(); i++){
            if ( (player.getAdvan() > 0 && players.get(i).getAdvan() > 0) && (player.getAdvan() == players.get(i).getAdvan()) ) {
                index = players.indexOf(players.get(i));
                System.out.println("Player resturn = " + index);
            } else {

            }
        }
        players.forEach( p -> System.out.println(p) );

    }
}
