

import java.util.Stack;


public class Buffer
{
 private Stack<Character> bufferLeft;
	private Stack<Character> bufferRight;
	
	// necessary when serializing buffer
	private boolean reverse = true;


	// create an empty buffer
	public Buffer()
	{
		bufferLeft = new Stack<Character>();
		bufferRight = new Stack<Character>();
	}
	
	// insert c at the cursor position
	public void insert(char c)
	{
		bufferLeft.push(c);
	}
	
	// delete and return the character at the cursor
	public char delete() 
	{
		return bufferRight.isEmpty() ? '\0' : bufferRight.pop();
	}

	// move the cursor k positions to the left
	public void left(int k)
	{
		while(!bufferLeft.isEmpty() && --k >= 0) bufferRight.push(bufferLeft.pop());
	}
	
	// move the cursor k positions to the right
	public void right(int k)
	{
		while(!bufferRight.isEmpty() && --k >= 0) bufferLeft.push(bufferRight.pop());
	}
	
	// number of characters in the buffer
	public int size()
	{
		return bufferLeft.size() + bufferRight.size();
	}
	
	// class-specific helper function to serialize each buffer
	private String serializeBuffer(Stack<Character> bf)
	{
		int size = bf.size();
		
		StringBuilder out = new StringBuilder();
		if(reverse = !reverse)
		{
			for(int i = size - 1; i>=0; --i)
			{
				out.append(bf.get(i));
			}
		} else {
			for(int i = 0; i < size; ++i)
			{
				out.append(bf.get(i));
			}
		}
		return out.toString();
	}
	
	public String toString()
	{
		return serializeBuffer(bufferLeft) + "•" + serializeBuffer(bufferRight);
	}
}