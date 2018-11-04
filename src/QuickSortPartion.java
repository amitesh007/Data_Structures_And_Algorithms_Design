package assignement;

public class QuickSortPartion {
	
	/**
	 *   Similar to standard partition method. Here we pass the pivot element
	 *   too instead of choosing it inside the method.
	 */
   
	 private static int partition(int[] arr, int low, int high, int pivot)
	    {
	        int i = low;
	        int temp1, temp2;
	        for (int j = low; j < high; j++)
	        {
	            if (arr[j] < pivot){
	                temp1 = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp1;
	                i++;
	            } else if(arr[j] == pivot){
	                temp1 = arr[j];
	                arr[j] = arr[high];
	                arr[high] = temp1;
	                j--;
	            }
	        }
	        temp2 = arr[i];
	        arr[i] = arr[high];
	        arr[high] = temp2;
	 
	        // Return the partition index of an array based on the pivot 
	        // element of other array.
	        return i;
	    }
	 
	 // Method which works just like quick sort
	    private static void QucikSort(int[] nuts, int[] bolts, int low,
	                                                              int high)
	    {
	    	
	        if (low < high)
	        {
	            // Choose last number from bolts array for nuts partition.
	            int pivot = partition(nuts, low, high, bolts[high]);
	 
	            /**
	             * Now using the partition of nuts choose that for bolts partition.
	             */
	            partition(bolts, low, high, nuts[pivot]);
	 
	            /**
	             *  Recur for 
	             *  Left -[low...pivot-1] 
	             *  Right- [pivot+1...high] 
	             *  for nuts and bolts
	             */
	           
	            QucikSort(nuts, bolts, low, pivot-1);
	            QucikSort(nuts, bolts, pivot+1, high);
	        }
	    }

	
	// Method to print the array
    private static void printArray(int[] arr,String type) {
    	String list=" ";
    	
        for (int value : arr){
        	list=value +"\t"+ list;
        }
        System.out.println(type+" :   "+ list );
        System.out.print("\n");
    }

	public static void main(String[] args) {
		// Nuts and bolts are represented as array of integers
        
        int nuts[] = {4,6,2,9,3,7,1,8,5};
        int bolts[] = {9,1,2,5,3,6,4,8,7};
 
        // Method based on quick sort which matches nuts and bolts
        QucikSort(nuts, bolts, 0, 8);
 
        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts,"NUTS ");
        printArray(bolts,"BOLTS");

	}

}
