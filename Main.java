import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("zipcodes.txt"));
        Integer[] data = new Integer[input.nextInt()];
        for (int i = 0; i < data.length; i++) {
            data[i] = input.nextInt();
        }

		// int tableSize = 287;
		// LinkedList<Integer>[] table = getHashTable(data, tableSize);

		// int collisions = 0;
		// int bucketsUsed = 0;
		// int bucketWithMaxNumberOfCollisions = 0;

		// for (int i = 0; i < table.length; i++) {
		// 	System.out.println(i + ": " + table[i]);
		// 	if (table[i] != null && !table[i].isEmpty()) {
		// 		bucketsUsed++;
		// 		if (table[i].size() > table[bucketWithMaxNumberOfCollisions].size()) {
		// 			bucketWithMaxNumberOfCollisions = i;
		// 		}
		// 		collisions += table[i].size() - 1;
		// 	}
		// }
				
		int tableSize = 0;
		while (true) {
			tableSize++;
			LinkedList<Integer>[] table = getHashTable(data, tableSize);

			int collisions = 0;

			for (int i = 0; i < table.length; i++) {
				//System.out.println(i + ": " + table[i]);
				if (table[i] != null && !table[i].isEmpty()) {
					collisions += table[i].size() - 1;
				}
			}

			if (collisions == 0) {
				System.out.println(tableSize);
				break;
			}
		}
		


        // System.out.printf("\nNumber of collisions = %d\n", collisions);
        // System.out.printf("Average Collisions per bucket = %.2f\n", ((double)collisions / bucketsUsed));
        // System.out.printf("Bucket with the most collisions = %d with %d collisions\n", bucketWithMaxNumberOfCollisions, table[bucketWithMaxNumberOfCollisions].size());
    }

    public static LinkedList<Integer>[] getHashTable(Integer[] data, int size) {
        // create hash table
        LinkedList<Integer>[] hashTable = new LinkedList[size];

		// initialize each LinkedList in the array
		//for (int i = 0; i < size; i++) {
		//	hashTable[i] = new LinkedList<>();
		//}


		// add elements 
		for (int i = 0; i < data.length; i++) {
			int num = data[i];
			int idxVal = num % size;
			if (hashTable[idxVal] == null) {
				hashTable[idxVal] = new LinkedList<>();
			}
			hashTable[idxVal].add(num);
		}


        return hashTable;
    }
}
