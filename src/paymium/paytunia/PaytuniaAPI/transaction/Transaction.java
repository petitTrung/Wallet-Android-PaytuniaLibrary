/*
 * 
 */
package paymium.paytunia.PaytuniaAPI.transaction;

import java.math.BigDecimal;
import java.util.Date;

import paymium.paytunia.PaytuniaAPI.Currency;

import com.google.gson.annotations.SerializedName;

// TODO: Auto-generated Javadoc
/**
 * The Class Transaction.
 * This class is used to get a transaction from trade history
 */
public class Transaction 
{

	/** The id of transaction on https://Paytunia.com . */
	@SerializedName("id")
	private Integer id;

	/** The amount of transaction. */
	@SerializedName("amount")
	private BigDecimal amount;

	/** The currency used. */
	@SerializedName("currency")
	private Currency currency;

	/** The number of confirmations. */
	@SerializedName("bt_tx_confirmations")
	private Integer confirmations;

	/** The boolean which indicate if the transaction is confirmed. */
	@SerializedName("confirmed?")
	private Boolean isConfirmed;

	/** The number of confirmations which remain to confirm transaction. */
	@SerializedName("required_confirmations")
	private Integer confirmationsToGo;

	/** The address of beneficiary. */
	@SerializedName("address")
	private String address;

	/** The email of beneficiary. */
	@SerializedName("email")
	private String email;

	/** The comment. */
	@SerializedName("comment")
	private String comment;

	/** The BCT transaction id. */
	@SerializedName("bt_tx_id")
	private String bitcoinTransactionId;

	/** The boolean which indicate if the user have already seen the transaction. */
	@SerializedName("unread")
	private Boolean isUnread;

	/** The date of transaction. */
	@SerializedName("created_at")
	private Date createdAt;

	/** The last date when the state of transaction was updated. */
	@SerializedName("updated_at")
	private Date updatedAt;

	/** The type. */
	@SerializedName("type")
	private String type;

	/**
	 * Gets the address.
	 *
	 * @return A String which indicate the address of beneficiary
	 */
	public String getAddress() 
	{
		return address;
	}

	/**
	 * Sets the address of beneficiary.
	 *
	 * @param address
	 */
	public void setAddress(String address) 
	{
		this.address = address;
		this.type = null;
	}

	/**
	 * Gets the amount.
	 *
	 * @return A BigDecimal which indicate the amount of transaction
	 */
	public BigDecimal getAmount() 
	{
		return amount;
	}

	/**
	 * Sets the amount of transaction.
	 *
	 * @param amount
	 */
	public void setAmount(BigDecimal amount) 
	{
		this.amount = amount;
	}

	/**
	 * Gets the BTC transaction id.
	 *
	 * @return A String which indicate the BTC transaction id
	 */
	public String getBitcoinTransactionId() 
	{
		return bitcoinTransactionId;
	}

	/**
	 * Sets the BTC transaction id.
	 *
	 * @param bitcoinTransactionId
	 */
	public void setBitcoinTransactionId(String bitcoinTransactionId) 
	{
		this.bitcoinTransactionId = bitcoinTransactionId;
	}

	/**
	 * Gets the comment.
	 *
	 * @return A String which show the comment of transaction
	 */
	public String getComment() 
	{
		return comment;
	}

	/**
	 * Sets the comment of transaction.
	 *
	 * @param comment
	 */
	public void setComment(String comment) 
	{
		this.comment = comment;
	}

	/**
	 * Gets the number of confirmations.
	 *
	 * @return An Integer which indicate the number of confirmations of transaction
	 */
	public Integer getConfirmations() 
	{
		return confirmations;
	}

	/**
	 * Sets the confirmations of transaction.
	 *
	 * @param confirmations
	 */
	public void setConfirmations(Integer confirmations) 
	{
		this.confirmations = confirmations;
	}

	/**
	 * Gets the number of confirmations which remain to confirm the transaction.
	 *
	 * @return An Integer which indicate the number of confirmations which remain to confirm the transaction
	 */
	public Integer getConfirmationsToGo() 
	{
		return confirmationsToGo;
	}

	/**
	 * Sets the number of confirmations which remain to confirm the transaction.
	 *
	 * @param confirmationsToGo
	 */
	public void setConfirmationsToGo(Integer confirmationsToGo) 
	{
		this.confirmationsToGo = confirmationsToGo;
	}

	/**
	 * Gets the date of transaction.
	 *
	 * @return A Date which show the date of transaction
	 */
	public Date getCreatedAt() 
	{
		return createdAt;
	}

	/**
	 * Sets the date of transaction.
	 *
	 * @param createdAt
	 */
	public void setCreatedAt(Date createdAt) 
	{
		this.createdAt = createdAt;
	}

	/**
	 * Gets the type of currency of transaction.
	 *
	 * @return A Currency which indicate the type of currency which is used in the transaction
	 */
	public Currency getCurrency() 
	{
		return currency;
	}

	/**
	 * Sets the type of currency of transaction.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(Currency currency) 
	{
		this.currency = currency;
	}

	/**
	 * Gets the email of beneficiary.
	 *
	 * @return A String which indicate the email of beneficiary
	 */
	public String getEmail() 
	{
		return email;
	}

	/**
	 * Sets the email of beneficiary.
	 *
	 * @param email
	 */
	public void setEmail(String email) 
	{
		this.email = email;
		this.type = ("EmailTransfer");
	}

	/**
	 * Gets the id of transaction.
	 *
	 * @return An Integer which indicate the identity of transaction
	 */
	public Integer getId() 
	{
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 */
	public void setId(Integer id) 
	{
		this.id = id;
	}

	/**
	 * Gets the checks if the transaction is confirmed.
	 *
	 * @return A boolean which indicate if the transaction is confirmed
	 */
	public Boolean getIsConfirmed() 
	{
		return isConfirmed;
	}

	/**
	 * Sets the checks if the transaction is confirmed.
	 *
	 * @param isConfirmed
	 */
	public void setIsConfirmed(Boolean isConfirmed) 
	{
		this.isConfirmed = isConfirmed;
	}

	/**
	 * Gets the checks if the transaction has already been consulted.
	 *
	 * @return A boolean which indicate if the transaction has already been consulted.
	 */
	public Boolean getIsUnread() 
	{
		return isUnread;
	}

	/**
	 * Sets the checks if the transaction has already been consulted.
	 *
	 * @param isUnread
	 */
	public void setIsUnread(Boolean isUnread) 
	{
		this.isUnread = isUnread;
	}

	/**
	 * Gets the date when the transaction was made.
	 *
	 * @return A Date which indicate the date when the transaction was made
	 */
	public Date getUpdatedAt() 
	{
		return updatedAt;
	}

	/**
	 * Sets the latest date when the transaction was updated.
	 *
	 * @param updatedAt
	 */
	public void setUpdatedAt(Date updatedAt) 
	{
		this.updatedAt = updatedAt;
	}

	/**
	 * Gets the type of transaction.
	 *
	 * @return A String which indicate the type of transaction
	 */
	public String getType() 
	{
		return type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("Transaction\n=============================\n");
		stringBuilder.append("Id                   : ");
		stringBuilder.append(id.toString());
		stringBuilder.append("\n");

		stringBuilder.append("Currency             : ");
		stringBuilder.append(currency.toString());
		stringBuilder.append("\n");

		stringBuilder.append("Amount               : ");
		stringBuilder.append(amount.toString());
		stringBuilder.append("\n");

		stringBuilder.append("Confirmations        : ");
		if (confirmations != null) {
			stringBuilder.append(confirmations.toString());
		}
		stringBuilder.append("\n");

		stringBuilder.append("IsConfirmed          : ");
		if (isConfirmed != null) {
			stringBuilder.append(isConfirmed.toString());
		}
		stringBuilder.append("\n");

		stringBuilder.append("ConfirmationsToGo    : ");
		if (confirmationsToGo != null) {
			stringBuilder.append(confirmationsToGo.toString());
		}
		stringBuilder.append("\n");

		stringBuilder.append("Address              : ");
		if (address != null) {
			stringBuilder.append(address.toString());
		}
		stringBuilder.append("\n");
		
		stringBuilder.append("E-mail               : ");
		if (email != null) {
			stringBuilder.append(email.toString());
		}
		stringBuilder.append("\n");

		stringBuilder.append("Comment              : ");
		if (comment != null) {
			stringBuilder.append(comment.toString());
		}
		stringBuilder.append("\n");

		stringBuilder.append("BitcoinTransactionId : ");
		if (bitcoinTransactionId != null) {
			stringBuilder.append(bitcoinTransactionId.toString());
		}
		stringBuilder.append("\n");

		stringBuilder.append("isUnread             : ");
		if (isUnread != null) {
			stringBuilder.append(isUnread.toString());
		}
		stringBuilder.append("\n");

		stringBuilder.append("CreatedAt            : ");
		if (createdAt != null) {
			stringBuilder.append(createdAt.toString());
		}
		stringBuilder.append("\n");

		stringBuilder.append("UpdatedAt            : ");
		if (updatedAt != null) {
			stringBuilder.append(updatedAt.toString());
		}
		stringBuilder.append("\n\n");

		return (stringBuilder.toString());
	}
}
