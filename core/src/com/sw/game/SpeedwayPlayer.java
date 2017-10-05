package com.sw.game;

public class SpeedwayPlayer {
    private String name;
    private String color;
    private int points;
    private SpeedwayBike motur;

    // TODO (everything here is todo, but dont forget about this one)
    private float reaction_time;
    private float finish_time;

    public SpeedwayPlayer(String _n) {
        name = _n;
        motur = new SpeedwayBike();
    }

    public SpeedwayPlayer() {
        name = "Bob Blox";
        motur = new SpeedwayBike();
    }

    public String GetName(){return name;}
    public void SetName(String _n) { name = _n;}

    public String GetColor() {return color;}
    public void SetColor(String _c) {color = _c;}

    public int GetPoints() {return points;}
    public void ResetPoints() {points = 0;}
    public void AddPoints(Integer _p) {points += _p;}
    public void SetPointe(Integer _p) {points = _p;}
}
