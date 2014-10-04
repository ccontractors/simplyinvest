package dk.cccontractors.www.swing;

public class Model {
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public double getYheigt() {
		return yheigt;
	}
	public void setYheigt(double yheigt) {
		this.yheigt = yheigt;
	}
	
	
	String modelName;
	int priority = 2;
	double yheigt;
	public double getyMin() {
		return yMin;
	}
	public void setyMin(double yMin) {
		this.yMin = yMin;
	}


	double yMin;
	
}
