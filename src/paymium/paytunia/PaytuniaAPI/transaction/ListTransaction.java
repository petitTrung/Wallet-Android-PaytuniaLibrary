/*
 * 
 */
package paymium.paytunia.PaytuniaAPI.transaction;

import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ListTransaction.
 * A list of transactions
 */
public class ListTransaction extends LinkedList<Transaction>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("******* ID TRANSACTION LIST ********");
		
		for (int i = 0 ; i < this.size() ; i++)
		{
			stringBuilder.append("----------------------------\n");
			stringBuilder.append((i+1)+"/. " + this.get(i).getId() + "\n");
		}
		
		return stringBuilder.toString();
	}


}
