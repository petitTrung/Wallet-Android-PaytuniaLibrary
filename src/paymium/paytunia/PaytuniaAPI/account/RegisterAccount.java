/*
 * 
 */
package paymium.paytunia.PaytuniaAPI.account;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


// TODO: Auto-generated Javadoc
/**
 * The Class RegisterAccount.
 */
public class RegisterAccount 
{
	
	/** Data in gson. We use the library Gson */
	private Gson gson;
	
	/**
	 * Instantiates a new register account.
	 */
	public RegisterAccount() 
	{
		GsonBuilder gsonBuilder = new GsonBuilder();
		gson = gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
	}

	/**
	 * Request a new account in http://paytunia.com with a proper token
	 *
	 * @param newAccount
	 * @param registerToken
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String Request(NewAccount newAccount, String registerToken) throws IOException
	{
		
		JsonElement skip_captcha_token = gson.toJsonTree(registerToken);
		
		JsonElement newAccountData = gson.toJsonTree(newAccount);
		JsonObject jsonData = new JsonObject();
			
		jsonData.add("skip_captcha_token",skip_captcha_token);
		jsonData.add("user", newAccountData);

		String jsonString = jsonData.toString();
		
		
		URL requestURL = new URL("https://paytunia.com/users");
		HttpURLConnection backendConnection = (HttpURLConnection) requestURL.openConnection();

		backendConnection.setRequestProperty("Accept", "application/json");
		backendConnection.setRequestMethod("POST");
	
		backendConnection.setDoInput(true);
		backendConnection.setDoOutput(true);
		backendConnection.setRequestProperty("Content-Type", "application/json");
		backendConnection.setRequestProperty("Content-Length", Integer.toString(jsonString.getBytes().length));

		// Send request
		DataOutputStream dataOutputStream = new DataOutputStream(backendConnection.getOutputStream());
		dataOutputStream.writeBytes(jsonString);
		dataOutputStream.flush();
		dataOutputStream.close();			

		
		if (backendConnection.getResponseCode() > 400)
		{
			InputStream errorStream = backendConnection.getErrorStream();
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
			
			StringBuilder errorBuilder = new StringBuilder();
			String line = null;
			
			while ((line = errorReader.readLine()) != null) 
			{
				errorBuilder.append(line);
			}

			System.out.println("Code d'erreur : " + backendConnection.getResponseCode());
			System.out.println("Message d'erreur : "+backendConnection.getResponseCode()+" "+errorBuilder.toString());
			
			
			return String.valueOf(backendConnection.getResponseCode()+" "+errorBuilder.toString());

		}
		
		else
		{
			backendConnection.connect();
			InputStream responseStream = (InputStream) backendConnection.getInputStream();
			BufferedReader responseReader = new BufferedReader(new InputStreamReader(responseStream));

			StringBuilder responseBuilder = new StringBuilder();
			String line = null;
			
			while ((line = responseReader.readLine()) != null) 
			{
				responseBuilder.append(line);
			}
			backendConnection.disconnect();	
			
			System.out.println("Code de succes : "+ backendConnection.getResponseCode());
			System.out.println("Message de succes :"+backendConnection.getResponseCode());
			return responseBuilder.toString();
		}
		
	}
}
