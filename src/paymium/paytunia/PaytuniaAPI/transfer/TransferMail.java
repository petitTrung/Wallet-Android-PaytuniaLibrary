/*
 * 
 */
package paymium.paytunia.PaytuniaAPI.transfer;

import java.math.BigDecimal;

import paymium.paytunia.PaytuniaAPI.Currency;


// TODO: Auto-generated Javadoc
/**
 * The Class TransferMail.
 */
public class TransferMail 
{
	
	/** The email address of beneficiary. */
	private String email;
	
	/** The amount of transfer. */
	private BigDecimal amount;
	
	/** The type of currency. */
	private Currency currency;
	
	/** The type which indicate that the transfer was realized by email. */
	private String type ;
	
	/**
	 * Instantiates a new transfer mail.
	 */
	public TransferMail() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Gets the email address of beneficiary.
	 *
	 * @return A String which indicate the email address of beneficiary
	 */
	public String getEmail() 
	{
		return email;
	}
	
	/**
	 * Sets the email address of beneficiary.
	 *
	 * @param email
	 */
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	/**
	 * Gets the amount of transfer.
	 *
	 * @return A BigDecimal which indicate the amount of transfer
	 */
	public BigDecimal getAmount() 
	{
		return amount;
	}
	
	/**
	 * Sets the amount of transfer.
	 *
	 * @param amount
	 */
	public void setAmount(BigDecimal amount) 
	{
		this.amount = amount;
	}


	/**
	 * Gets the type of currency.
	 *
	 * @return A Currency which indicate the type of currency used in transfer
	 */
	public Currency getCurrency()
	{
		return currency;
	}
	
	/**
	 * Sets the type of currency.
	 *
	 * @param currency
	 */
	public void setCurrency(Currency currency) 
	{
		this.currency = currency;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() 
	{
		return type;
	}


	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) 
	{
		this.type = type;
	}
}
