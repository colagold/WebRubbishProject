package com.sxu.rubbishclassify.Utils.detectors;

public class Box {

    private float left;
    private float top;
    private float width;
    private float height;

    public Box() {

    }
    public Box(float left,float top,float width,float height) {
    	this.left=left;
    	this.top=top;
    	this.width=width;
    	this.height=height;
    }

    public Box(float[] box) {
        left = box[1];
        top = box[0];
        width = box[3] - box[1];
        height = box[2] - box[0];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("left: ").append(left).append(", ");
        sb.append("top: ").append(top).append(", ");
        sb.append("width: ").append(width).append(", ");
        sb.append("height: ").append(height);
        sb.append(")");
        return sb.toString();
    }
	public float getLeft() {
		return left;
	}
	public void setLeft(float left) {
		this.left = left;
	}
	public float getTop() {
		return top;
	}
	public void setTop(float top) {
		this.top = top;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
    
}

