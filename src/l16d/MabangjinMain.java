package l16d;

public class MabangjinMain {
	public static void main(String[] args) {
		int a[][] = new int[5][5];
		Mabangjin m = new Mabangjin();
		m.makeMa(a);
				
		for(int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf("%2d ", a[i][j]); 
			}
			System.out.println();
		}
		
	}
}