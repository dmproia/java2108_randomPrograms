   

public class Node<E>
{
	public E data;
	public Node<E> next;
	public double importance;
	
	public Node(E dataItem)
	{
		data = dataItem;
		next = null;
	}
	
	public Node(E dataItem, Node<E> nodeRef)
	{
		data = dataItem;
		next = nodeRef;
	}
}
