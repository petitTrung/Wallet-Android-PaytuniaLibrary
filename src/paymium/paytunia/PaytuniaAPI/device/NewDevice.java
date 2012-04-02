/*
 * 
 */
package paymium.paytunia.PaytuniaAPI.device;

import com.google.gson.annotations.SerializedName;

// TODO: Auto-generated Javadoc
/**
 * The Class NewDevice.
 * We use this class to register a new device (for push notification)
 */
public class NewDevice 
{

	/** The device id. */
	@SuppressWarnings("unused")
	@SerializedName("registration_id")
	private String deviceId;

	/**
	 * Instantiates a new new device.
	 *
	 * @param deviceId the device id
	 */
	public NewDevice(String deviceId) 
	{
		this.deviceId = deviceId;
	}
}
