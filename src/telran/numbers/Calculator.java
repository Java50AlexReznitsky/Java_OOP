package telran.numbers;

import java.util.function.BinaryOperator;

public class Calculator {
	static public double calculate(CalcData cd) {

		DoubleBinaryOperator[] operations = new DoubleBinaryOperator[48];
		operations[43] = (a, b) -> a + b;
		operations[45] = (a, b) -> a - b;
		operations[42] = (a, b) -> a * b;
		operations[47] = (a, b) -> a / b;
		return operations[(int) cd.operation].apply(cd.num1, cd.num2);
	}

	interface DoubleBinaryOperator extends BinaryOperator<Double> {

	}
}
