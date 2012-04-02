/*
 * 
 */
package paymium.paytunia.PaytuniaAPI.account;

import java.math.BigDecimal;
import com.google.gson.annotations.SerializedName;

// TODO: Auto-generated Javadoc
/**
 * Class Account.
 * This class is used in order to get a full description of an account
 * @author Mrgiua
 */


public class Account 
{

	/** The address BTC. */
	@SerializedName("address")
	private String address;

	
	/** Amount in BTC. */
	@SerializedName("BTC")
	private BigDecimal btc;
  
	
	/** Amount in BTC which is unconfirmed. */
	@SerializedName("UNCONFIRMED_BTC")
	private BigDecimal unconfirmedBtc;
  
	
	/** Amount in Euro. */
	@SerializedName("EUR")
	private BigDecimal eur;
  
	
	/** Liberty Reserve in Euro. */
	@SerializedName("LREUR")
	private BigDecimal lreur;
  
	
	/** Liberty Reserve in Dollar. */
	@SerializedName("LRUSD")
	private BigDecimal lrusd;

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		StringBuilder asString = new StringBuilder();

	    asString.append("Account\n=============================\n");
	    asString.append("Address           : ");
	    asString.append(address);
	    asString.append("\n");
	
	    asString.append("BTC               : ");
	    asString.append(btc.toString());
	    asString.append("\n");
	
	    asString.append("BTC (unconfirmed) : ");
	    asString.append(unconfirmedBtc);
	    asString.append("\n");
	
	    asString.append("EUR               : ");
	    asString.append(eur.toString());
	    asString.append("\n");
	
	    asString.append("LRUSD             : ");
	    asString.append(lrusd.toString());
	    asString.append("\n");
	
	    asString.append("LREUR             : ");
	    asString.append(lreur.toString());
	    asString.append("\n\n");
	
	    return (asString.toString());
	}

	
	
	/**
	 * Gets the address BTC.
	 *
	 * @return A string which indicate the address BTC
	 */
	public String getAddress() 
	{
		return address;
	}

	
	
	/**
	 * Defines the address BTC .
	 *
	 * @param address
	 */
	public void setAddress(String address) 
	{
		this.address = address;
	}

	
	
	/**
	 * Gets the Amount in BTC.
	 *
	 * @return A BigDecimal which indicate the Amount in BTC.
	 */
	public BigDecimal getBtc() 
	{
		return btc;
	}

	
	
	/**
	 * Defines the Amount in BTC.
	 *
	 * @param btc
	 */
	public void setBtc(BigDecimal btc) 
	{
		this.btc = btc;
	}

	/**
	 * Gets the Amount in Euro.
	 *
	 * @return A BigDecimal which indicate the Amount in Euro.
	 */
	public BigDecimal getEur() 
	{
		return eur;
	}

	/**
	 * Defines the Amount in Euro.
	 *
	 * @param eur
	 */
	public void setEur(BigDecimal eur) 
	{
		this.eur = eur;
	}

	/**
	 * Gets the Liberty Reserve in Euro.
	 *
	 * @return A BigDecimal which indicate the Liberty Reserve in Euro.
	 */
	public BigDecimal getLreur() 
	{
		return lreur;
	}

	/**
	 * Defines the Liberty Reserve in Euro.
	 *
	 * @param lreur
	 */
	public void setLreur(BigDecimal lreur) 
	{
		this.lreur = lreur;
	}

	/**
	 * Gets the the Liberty Reserve in Dollar.
	 *
	 * @return A BigDecimal which indicate Liberty Reserve in Dollar
	 */
	public BigDecimal getLrusd() 
	{
		return lrusd;
	}

	/**
	 * Defines the Liberty Reserve in Dollar.
	 *
	 * @param lrusd
	 */
	public void setLrusd(BigDecimal lrusd) 
	{
		this.lrusd = lrusd;
	}

	/**
	 * Gets the unconfirmed BTC.
	 *
	 * @return A BigDecimal which indicate the unconfirmed BTC
	 */
	public BigDecimal getUnconfirmedBtc() 
	{
		return unconfirmedBtc;
	}

	/**
	 * Defines the unconfirmed BTC.
	 *
	 * @param unconfirmedBtc
	 */
	public void setUnconfirmedBtc(BigDecimal unconfirmedBtc) 
	{
		this.unconfirmedBtc = unconfirmedBtc;
	}
}
