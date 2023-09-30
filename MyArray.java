package lab1;

public class MyArray {

	private int[] array;

	public MyArray(int[] array) {
		this.array = array;

	}

	public int[] mirror() {
		int n = array.length;
		int[] mirrorArray = new int[2 * n];
		for (int i = 0; i < n; i++) {
			mirrorArray[i] = array[i];
		}
		for (int i = 0; i < n; i++) {
			mirrorArray[i + n] = array[n - i - 1];

		}
		return mirrorArray;
		// test
	}

	public int[] removeDuplicates() {
		int soDem = 0;
		int[] arrmoi = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			boolean trunglap = false;
			for (int j = 0; j < soDem; j++) {
				if (arrmoi[j] == array[i]) {
					trunglap = true;
					break;
				}
			}
			if (!trunglap) {
				arrmoi[soDem] = array[i];
				soDem++;
			}

		}
		return arrmoi;
	}

	public int[] getMissingValues() {

		int soDem = 0;
		int[] arrmoi = new int[100];
		int khoangcach;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i + 1] - array[i] > 1) {
				khoangcach = array[i + 1] - array[i];
				for (int j = 1; j < khoangcach; j++) {
					arrmoi[soDem] = array[i] + j;
					soDem++;
				}
			}

		}
		return arrmoi;
	}
	

	private static void printArray(int[] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 4, 5, 8, 9, 10, 12 };
		MyArray myArray = new MyArray(array1);
		// int[] removeDuplicates = myArray.removeDuplicates();
		// int[] mirrorArray = myArray.mirror(); //printArray(mirrorArray);
		int[] getMissingValue = myArray.getMissingValues();
		printArray(getMissingValue);
		// printArray(removeDuplicates);

	}
}
