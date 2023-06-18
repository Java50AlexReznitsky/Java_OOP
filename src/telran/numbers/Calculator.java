package telran.numbers;

import java.util.function.BinaryOperator;

public class Calculator {
	static public double calculate(CalcData cd) {

		double num1 = cd.op1;
		double num2 = cd.op2;
		char oper = cd.operation;
		char operChar = oper;
		int asciiCode = (int) operChar;

		DoubleBinaryOperator[] operations = new DoubleBinaryOperator[48];
		operations[43] = (a, b) -> a + b;
		operations[45] = (a, b) -> a - b;
		operations[42] = (a, b) -> a * b;
		operations[47] = (a, b) -> a / b;
		return operations[asciiCode].apply(num1, num2);
	}

	interface DoubleBinaryOperator extends BinaryOperator<Double> {

	}
}
