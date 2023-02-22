/**
 * 
 * @author good0161
 * @version 3.0.1
 *
 */
public class Triangle {
	
	private double sideA;
	private double sideB;
	private double sideC;
	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1;
	
	//constructors
	public Triangle() {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}
	public Triangle(double sideA, double sideB, double sideC) {
		if(sideA < 1 || sideB < 1 || sideC < 1 || (sideA + sideB) <= sideC || (sideB + sideC) <= sideA || (sideC + sideA) <= sideB) {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		else {
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		}
	}
	public Triangle(double[] sides) {
		if(sides == null ||sides.length != 3 || sides[0] < 1 || sides[1] < 1 || sides[2] < 1 || (sides[0] + sides[1]) <= sides[2] || (sides[1] + sides[2]) <= sides[0]|| (sides[2] +sides[0]) <= sides[1]){
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		else {
			sideA = sides[0];
			sideB = sides[1];
			sideC = sides[2];
		}
	}
	public Triangle(Triangle triangle) {
		if(triangle != null) {
			this.sideA = triangle.getSideA();
			this.sideB = triangle.getSideB();
			this.sideC = triangle.getSideC();
		}
		else {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	//access
	public double getSideA() {
		return sideA;
	}
	public double getSideB() {
		return sideB;
	}
	public double getSideC() {
		return sideC;
	}
	public double[] getSides() {
		double[] sides = {sideA,sideB,sideC};
		return sides;
	}
	public double getAngleA() {
		return lawOfCosines( sideB, sideC, sideA);
	}
	public double getAngleB() {
		return lawOfCosines( sideA, sideC, sideB);
	}
	public double getAngleC() {
		return lawOfCosines( sideA, sideB, sideC);
	}
	public double[] getAngles() {
		double[] angles = {getAngleA(), getAngleB(), getAngleC()};
		return angles;
	}
	
	//mutator
	public boolean setSideA(double sideA) {
		if(sideA < 1 || sideB < 1 || sideC < 1 || (sideA + sideB) <= sideC || (sideB + sideC) <= sideA || (sideC + sideA) <= sideB)
			return false;
		else {
			this.sideA = sideA;
			return true;
		}
	}
	public boolean setSideB(double sideB) {
		if(sideA < 1 || sideB < 1 || sideC < 1 || (sideA + sideB) <= sideC || (sideB + sideC) <= sideA || (sideC + sideA) <= sideB)
			return false;
		else {
			this.sideB = sideB;
			return true;
		}
	}
	public boolean setSideC(double sideC) {
		if(sideA < 1 || sideB < 1 || sideC < 1 || (sideA + sideB) <= sideC || (sideB + sideC) <= sideA || (sideC + sideA) <= sideB)
			return false;
		else {
			this.sideC = sideC;
			return true;
		}
	}
	public boolean setSides(double[] sides) {
		if(sides == null || sides.length != 3 || sides[0] < 1 || sides[1] < 1 || sides[2] < 1 || (sides[0] + sides[1]) <= sides[2] || (sides[1] + sides[2]) <= sides[0]|| (sides[2] +sides[0]) <= sides[1]) {
			return false;
		}
		else {
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
			return true;
		}
	}
	
	public static boolean isTriangle(double a, double b, double c) {
		if((a + b) <= c || (b + c) <= a || (c + a) <= b) 
			return false;
		else
			return true;
	}
	public static boolean isTriangle(double[] sides) {
		if(sides == null || sides.length != 3 || sides[0] < 1 || sides[1] < 1 || sides[2] < 1 || (sides[0] + sides[1]) <= sides[2] || (sides[1] + sides[2]) <= sides[0]|| (sides[2] +sides[0]) <= sides[1])
			return false;
		else
			return true;
	}
	public static double lawOfCosines(double a, double b, double c) {
		double tot = (Math.pow(c, 2) - Math.pow(a, 2) - Math.pow(b, 2)) / (-2 * a * b);
		double result = Math.acos(tot) * (180 / Math.PI);
		return result;
	}
	public String toString() {
		String rtn = POLYGONSHAPE + "".format("(%.4f, %.4f, %.4f)", sideA,sideB,sideC);
		return rtn;
	}
}
