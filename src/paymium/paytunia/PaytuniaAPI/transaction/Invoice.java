/*
 * 
 */
package paymium.paytunia.PaytuniaAPI.transaction;

import com.google.gson.annotations.SerializedName;

// TODO: Auto-generated Javadoc
/**
 * The Class Invoice.
 */
public class Invoice 
{
	
	/** The first_page. */
	@SerializedName("first_page")
	private boolean first_page;
	
	/** The last_page. */
	@SerializedName("last_page")
	private boolean last_page;
	
	/** The previous_page. */
	@SerializedName("previous_page")
	private int previous_page;
	
	/** The next_page. */
	@SerializedName("next_page")
	private int next_page;
	
	/** The total_pages. */
	@SerializedName("total_pages")
	private int total_pages;
	
	/** The total. */
	@SerializedName("total")
	private int total;
	
	/** The offset. */
	@SerializedName("offset")
	private int offset;

	/**
	 * Checks if is first_page.
	 *
	 * @return true, if is first_page
	 */
	public boolean isFirst_page() 
	{
		return first_page;
	}

	/**
	 * Sets the first_page.
	 *
	 * @param first_page the new first_page
	 */
	public void setFirst_page(boolean first_page) 
	{
		this.first_page = first_page;
	}

	/**
	 * Checks if is last_page.
	 *
	 * @return true, if is last_page
	 */
	public boolean isLast_page() 
	{
		return last_page;
	}

	/**
	 * Sets the last_page.
	 *
	 * @param last_page the new last_page
	 */
	public void setLast_page(boolean last_page) 
	{
		this.last_page = last_page;
	}

	/**
	 * Gets the previous_page.
	 *
	 * @return the previous_page
	 */
	public int getPrevious_page() 
	{
		return previous_page;
	}

	/**
	 * Sets the previous_page.
	 *
	 * @param previous_page the new previous_page
	 */
	public void setPrevious_page(int previous_page) 
	{
		this.previous_page = previous_page;
	}

	/**
	 * Gets the next_page.
	 *
	 * @return the next_page
	 */
	public int getNext_page() 
	{
		return next_page;
	}

	/**
	 * Sets the next_page.
	 *
	 * @param next_page the new next_page
	 */
	public void setNext_page(int next_page) 
	{
		this.next_page = next_page;
	}

	/**
	 * Gets the total_pages.
	 *
	 * @return the total_pages
	 */
	public int getTotal_pages() 
	{
		return total_pages;
	}

	/**
	 * Sets the total_pages.
	 *
	 * @param total_pages the new total_pages
	 */
	public void setTotal_pages(int total_pages) 
	{
		this.total_pages = total_pages;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public int getTotal() 
	{
		return total;
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(int total) 
	{
		this.total = total;
	}

	/**
	 * Gets the offset.
	 *
	 * @return the offset
	 */
	public int getOffset() 
	{
		return offset;
	}

	/**
	 * Sets the offset.
	 *
	 * @param offset the new offset
	 */
	public void setOffset(int offset) 
	{
		this.offset = offset;
	}
}
