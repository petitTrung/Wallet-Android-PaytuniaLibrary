/*
 * 
 */
package paymium.paytunia.PaytuniaAPI.account;

// TODO: Auto-generated Javadoc
/**
 * The Class NewAccount.
 * This class is used to register a new account in https://paytunia.com
 */
public class NewAccount 
{
	
	/** The new user's email address. */
	private String email;
	
	/** The password. */
	private String password;
	
	/** The password confirmation. */
	private String password_confirmation;
	
	
	/**
	 * Instantiates a new new account.
	 *
	 * @param email the email
	 * @param password the password
	 * @param password_confirmation the password_confirmation
	 */
	public NewAccount(String email, String password, String password_confirmation) 
	{
		super();
		this.email = email;
		this.password = password;
		this.password_confirmation = password_confirmation;
	}

	
	/**
	 * Gets the email.
	 *
	 * @return A String which indicate the email address 
	 */
	public String getEmail() 
	{
		return email;
	}

	/**
	 * Defines the email.
	 *
	 * @param email
	 */
	public void setEmail(String email) 
	{
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return A String which indicate the password
	 */
	public String getPassword() 
	{
		return password;
	}

	/**
	 * Defines the password.
	 *
	 * @param password
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}

	/**
	 * Gets the password_confirmation.
	 *
	 * @return  A String which indicate the password confirmation
	 */
	public String getPassword_confirmation() 
	{
		return password_confirmation;
	}

	/**
	 * Defines the password_confirmation.
	 *
	 * @param password_confirmation
	 */
	public void setPassword_confirmation(String password_confirmation) 
	{
		this.password_confirmation = password_confirmation;
	}

}
