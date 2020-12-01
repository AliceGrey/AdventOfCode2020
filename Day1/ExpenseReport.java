import java.util.HashSet;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ExpenseReport {
	
	static void findPairs(int array[], int sum)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i < array.length; i++)
		{
			int x = sum - array[i];
			if (set.contains(x)) 
			{
				System.out.println("Pair that adds to " + sum + " is " + array[i] + " + " + x );
				System.out.println("Pair multiples to " + array[i] * x);
			}
			set.add(array[i]);
		}
	}
	
	static void findTriplet(int array[], int sum) 
	{ 
		for (int i = 0; i < array.length - 2; i++) 
		{ 
			HashSet<Integer> set = new HashSet<Integer>(); 
			int tempSum = sum - array[i]; 
			for (int j = i + 1; j < array.length; j++)  
			{ 
				if (set.contains(tempSum - array[j]))  
				{ 
					System.out.printf("Triplet is %d, %d, %d \n", array[i], array[j], tempSum - array[j]); 
					System.out.println("Triplet multiples to " + array[i]*array[j]*(tempSum - array[j]));
				} 
				set.add(array[j]); 
			} 
		}  
	} 
	
	public static void main(String[] args) throws IOException
	{
		int[] E = Files.lines(Paths.get("input.txt"))
                .mapToInt(Integer::parseInt).toArray();
		int n = 2020;		
		findPairs(E,n);
		findTriplet(E,n);
	}
}

