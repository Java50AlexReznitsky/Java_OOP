package telran.numbers;

public class CalcData {
	double num1;
	double num2;
	char operation; //'*','+',...
	
	public CalcData(double op1, double op2, char operation) {
		this.num1 = op1;
		this.num2 = op2;
		this.operation = operation;
	}

	public double getOp1() {
		return num1;
	}

	public double getOp2() {
		return num2;
	}

	public char getOperation() {
		return operation;
	}

}
