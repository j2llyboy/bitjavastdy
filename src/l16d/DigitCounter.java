package l16d;

import java.util.Scanner;

public class DigitCounter {
	public static void main(String[] args) {
		int num1, num2, num3, result;
		int a[] = new int[10];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++)
			a[i] = 0;
		
		System.out.println("정수 3개 입력: ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		result = num1 * num2 * num3;
		System.out.println("result: " + result);
		while (result != 0) {
			a[result % 10]++;
			result /=10;
		}
		for (int i = 0; i <10; i++)
			System.out.println(i + " = " + a[i]);
		System.out.println();
		sc.close();

		
		
		
	}
}
