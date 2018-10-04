package core;

public class Calculator {
	private int number1;
	private int number2;

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public Calculator(int firstNum, int secondNum) {
		this.number1 = firstNum;
		this.number2 = secondNum;
	}

	public Calculator() {

	}

	public int sum() {
		return number1 + number2;
	}

	public int sum(int a, int b) {
		return a + b;
	}

	public int diff() {
		return number1 - number2;
	}

	public int diff(int a, int b) {
		return a - b;
	}

}
