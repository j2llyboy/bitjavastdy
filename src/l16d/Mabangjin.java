package l16d;

public class Mabangjin {

	public void makeMa(int[][] arr) {
		int row = arr.length -1;
		int col = arr.length /2;
		int value = 0;
		
		arr[row][col] = ++value;
		
		while (value < arr.length * arr.length) {
			if(arr[(row + 1) % arr.length][(col + 1) % arr.length] == 0) {
				row++;
				col++;
			}else {
				row--;
			}
			arr[row % arr.length][col % arr.length] = ++value;
		}
		
	}

}
