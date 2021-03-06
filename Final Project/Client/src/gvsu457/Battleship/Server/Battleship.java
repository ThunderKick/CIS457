package gvsu457.Battleship.Server;

/**
 * Created by Administrator on 11/27/2016.
 */
public class Battleship {

    private int size;
    private boolean sunk;
    private int hitCount;
    private boolean placed;
    private int shipID;

    public Battleship(int size, boolean sunk, int hitCount, boolean placed, int shipID) {
        this.setSize(size);
        this.setSunk(sunk);
        this.setHitCount(hitCount);
        this.setPlaced(placed);
        this.setShipID(shipID);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSunk() {
        return sunk;
    }

    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    public int getShipID() { return shipID; }

    public void setShipID(int shipID) { this.shipID = shipID; }
}
