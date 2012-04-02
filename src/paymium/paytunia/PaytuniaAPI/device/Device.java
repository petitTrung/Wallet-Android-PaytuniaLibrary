/*
 * 
 */
package paymium.paytunia.PaytuniaAPI.device;

import com.google.gson.annotations.SerializedName;

// TODO: Auto-generated Javadoc
/**
 * The Class Device.
 */
public class Device 
{
	
	/** The last login date. */
	@SerializedName("updated_at")
	private String updated_at;
	
	/** The date when the account was created. */
	@SerializedName("created_at")
	private String created_at;
	
	/** The app_id (not used). */
	@SerializedName("app_id")
	private int app_id;
	
	/** The user_id. */
	@SerializedName("user_id")
	private int user_id;
	
	/** The registration_id. */
	@SerializedName("registration_id")
	private String registration_id;
	
	/** The device id. */
	@SerializedName("id")
	private int id;

	/**
	 * Gets the updated_at.
	 *
	 * @return A String which indicate the last login date.
	 */
	public String getUpdated_at() 
	{
		return updated_at;
	}

	/**
	 * Sets the updated_at.
	 *
	 * @param updated_at
	 */
	public void setUpdated_at(String updated_at) 
	{
		this.updated_at = updated_at;
	}

	/**
	 * Gets the created_at.
	 *
	 * @return A String which indicate the date when this device was registered
	 */
	public String getCreated_at() {
		return created_at;
	}

	/**
	 * Sets the created_at.
	 *
	 * @param created_at
	 */
	public void setCreated_at(String created_at) 
	{
		this.created_at = created_at;
	}

	/**
	 * Gets the app_id.
	 *
	 * @return An integer which indicate the app_id
	 */
	public int getApp_id() 
	{
		return app_id;
	}

	/**
	 * Sets the app_id.
	 *
	 * @param app_id
	 */
	public void setApp_id(int app_id) 
	{
		this.app_id = app_id;
	}

	/**
	 * Gets the user_id.
	 *
	 * @return An integer which indicate the user_id
	 */
	public int getUser_id() 
	{
		return user_id;
	}

	/**
	 * Sets the user_id.
	 *
	 * @param user_id
	 */
	public void setUser_id(int user_id) 
	{
		this.user_id = user_id;
	}

	/**
	 * Gets the registration_id.
	 *
	 * @return A String which indicate the registration_id
	 */
	public String getRegistration_id() 
	{
		return registration_id;
	}

	/**
	 * Sets the registration_id.
	 *
	 * @param registration_id
	 */
	public void setRegistration_id(String registration_id) 
	{
		this.registration_id = registration_id;
	}

	/**
	 * Gets the id.
	 *
	 * @return An integer which indicate the id
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 */
	public void setId(int id) 
	{
		this.id = id;
	}
}
