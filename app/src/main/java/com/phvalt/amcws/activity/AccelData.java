package com.phvalt.amcws.activity;

public class AccelData {

	private long timestamp;


    private int index;
	private double x;
	private double y;
	private double z;
	
	public AccelData(int index, long timestamp, double x, double y, double z) {
		this.timestamp = timestamp;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String toString(){
		return index +", t= "+timestamp+", x="+x+", y="+y+", z="+z+"\n";
	}
	
	
	
}
