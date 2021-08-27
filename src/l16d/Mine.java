package l16d;

import java.util.Scanner;

public class Mine {
	public static void main(String[] args) {
		int row, col, sum;
		Scanner sc = new Scanner(System.in);
		int mine[][] ={{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 1, 0, 0, 1, 0, 0, 0, 0 },
						{ 0, 0, 0, 1, 0, 0, 0, 0, 0 },
						{ 0, 1, 0, 0, 0, 0, 1, 1, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 1 },
						{ 0, 0, 0, 1, 0, 1, 1, 0, 0 },
						{ 0, 0, 1, 0, 0, 0, 0, 0, 1 },
						{ 0, 1, 0, 0, 1, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		
		while (true) {
			sum = 0;
			System.out.println("Row Column 입력: ");
			row = sc.nextInt(); 
			col = sc.nextInt();
			if (row == -1)
				break;
			if (mine[row][col] == 1) {
				System.out.println("꽝!! \n");
				break;
			}
			for (int i = row; i <= row +1; i++) {
				for (int j = col - 1; j <= col +1; j++) {
					if(i < 0 || i > 8 || j < 0 || j > 8)
						continue;
					sum+= mine[i][j];
				}
			}
			System.out.println("======== " + sum);
		}
		System.out.println("게임 종료");
		sc.close();	
		
		
	}
}
