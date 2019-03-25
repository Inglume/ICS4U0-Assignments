package a;

public class Primate {
	boolean isMale;
	int offspring;
	private int age;
	private double saturation;
	private double hydration;
	boolean isAlive;
	
	public void grow() {
		age++;
		hydration -= 50;
		saturation -= 50;
	}
	
	public void drink(double water) {
		hydration += water;
	}
	
	public void eat(double food) {
		saturation += food;
	}
	
	public void die() {
		isAlive = false;
	}

	public void reproduce() {
		offspring++;
		hydration -= 20;
		saturation -= 20;
	}
	
	public Primate() {
		isMale = true;
		age = 0;
		offspring = 0;
		saturation = 0;
		hydration = 0;
		isAlive = true;
	}
	
	public Primate(boolean isMale) {
		this();
		this.isMale = isMale;
	}
	
	public Primate(boolean isMale, int age) {
		this(isMale);
		this.age = age;
	}
	
	public Primate(boolean isMale, int age, int offspring, boolean isAlive) {
		this(isMale, age);
		this.offspring = offspring;
		this.isAlive = isAlive;
	}

	public static void main(String[] args) {
		Primate harambe = new Primate(true, 9, 2, true);
		harambe.drink(10);
		harambe.eat(5.67);
		harambe.reproduce();
		harambe.grow();
		harambe.die();
	}
}