package dk.cccontractors.www.swing.dimension;

import java.awt.Graphics2D;

public class ScreenConstants {

	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
	}
	public double getOffset() {
		return offset;
	}
	public void setOffset(double offset) {
		this.offset = offset;
	}
	public Graphics2D getG2D() {
		return g2D;
	}
	public void setG2D(Graphics2D g2d) {
		g2D = g2d;
	}
	public double getMargin() {
		return margin;
	}
	public void setMargin(double margin) {
		this.margin = margin;
	}
	public ScreenConstants(double scale, double offset, double margin, Graphics2D g2d) {
		super();
		this.scale = scale;
		this.offset = offset;
		g2D = g2d;
		this.margin = margin;
	}
	private double scale;
	private double offset;
	private Graphics2D g2D;
	private double margin; 
	
	
}
