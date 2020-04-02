package dreamincode;
public class bubbleSort{
public void bubbleSort()
{
	int dataAssigns = 0, dataCompare = 0, loopAssigns = 0, loopCompare = 0, other = 0;
	boolean swaps;
	Node left, right;

	do
	{
		swaps = false;
		
		for(((right = this.head.next)&&( left = this.head))&&(( right.next != this.head)&&( right = right.next)&&( left = left.next)))
		{
			if(left.data.comparTo(right.data) > 0)
			{
				Comparable temp = left.data;
				left.data = right.data;
				right.data = temp;
				swaps = true;
			}//end if
			
		}//end for
		
	}while(swaps);//end do while
	
}//end bubbleSort
}