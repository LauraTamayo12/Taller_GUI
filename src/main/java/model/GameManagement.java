package model;

import java.util.ArrayList;

public class GameManagement {
    private Dice diceOne;
    private Dice diceTwo;
    private ArrayList<Player> players;
    private byte level = 20;

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

    public void nPlayers() {
        players = new ArrayList<>(5);
        for (int i = 1; i <= 5; i++) {
            String id = String.valueOf( i );
            System.out.println(id);
            players.add(new Player( id, level));
        }
    }

    public void chooseLevel(String level) {
        if ( level.equals("Básico") )
            this.level = 20;
        else if ( level.equals("Medio") )
            this.level = 30;
        else if ( level.equals("Alto") )
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
        System.out.println("Indice act: " + indexAct);
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
        byte advan = (byte) (diceOne.getEdge() + diceTwo.getEdge());
        System.out.println( "res = " + advan);
        players.get(index).advance(advan);
    }
}
