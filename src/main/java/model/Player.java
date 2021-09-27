package model;

public class Player {
    private String id;
    private int advan;
    private int contP;
    private int res;
    private int returns;

    public Player(String id, int level) {
        this.id = id;
        advan = 0;
        contP = 0;
        res = level;
        returns = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAdvan() {
        return advan;
    }

    public void setAdvan(int advan) {
        this.advan = advan;
    }

    public void contPairs() {
        contP++;
        System.out.println("# pares: " + contP);
    }

    public int getContP() {
        return contP;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public int getReturns() {
        return returns;
    }

    public void setReturns(int returns) {
        this.returns = returns;
    }

    public void advance(int advan) {
        this.advan += advan;
        this.res -= advan;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", advan=" + advan +
                ", contP=" + contP +
                ", res=" + res +
                ", returns=" + returns +
                '}';
    }
}
