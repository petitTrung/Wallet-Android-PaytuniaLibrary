/*
 * 
 */
package paymium.paytunia.PaytuniaAPI.transfer;

import java.math.BigDecimal;

import paymium.paytunia.PaytuniaAPI.Currency;


// TODO: Auto-generated Javadoc
/**
 * The Class TransferAddressBitcoin.
 */
public class TransferAddressBitcoin 
{
	
	/** The address BTC of beneficiary. */
	private String address;
	
	/** The amount of transfer. */
	private BigDecimal amount;
	
	/** The currency of transfer. */
	private Currency currency;


	/**
	 * Instantiates a new transfer by address BTC.
	 */
	public TransferAddressBitcoin() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Gets the address BTC of beneficiary.
	 *
	 * @return A String which indicate the address BTC of beneficiary
	 */
	public String getAddressBitcoin() 
	{
		return address;
	}
	
	/**
	 * Sets the address BTC of beneficiary.
	 *
	 * @param addressBitcoin
	 */
	public void setAddressBitcoin(String addressBitcoin) 
	{
		this.address = addressBitcoin;
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

}
