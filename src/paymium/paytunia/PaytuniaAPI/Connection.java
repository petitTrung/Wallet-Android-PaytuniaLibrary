/*
 * 
 */
package paymium.paytunia.PaytuniaAPI;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import paymium.paytunia.PaytuniaAPI.account.Account;
import paymium.paytunia.PaytuniaAPI.device.Device;
import paymium.paytunia.PaytuniaAPI.device.NewDevice;
import paymium.paytunia.PaytuniaAPI.exceptions.ConnectionNotInitializedException;
import paymium.paytunia.PaytuniaAPI.transaction.Invoice;
import paymium.paytunia.PaytuniaAPI.transaction.ListTransaction;
import paymium.paytunia.PaytuniaAPI.transaction.Transaction;
import paymium.paytunia.PaytuniaAPI.transfer.TransferAddressBitcoin;
import paymium.paytunia.PaytuniaAPI.transfer.TransferMail;

import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// TODO: Auto-generated Javadoc
/**
 * Class Connection.
 * This is the most important class, it contain all methods to do all operations,
 */
public final class Connection 
{

	/** The backend url. */
	private String backendUrl;
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** A boolean which indicate if the account is locked **/
	private boolean locked = false;

	/** The gson. */
	private Gson gson;
	
	/** The authentication string. */
	private String authenticationString;
	
	/** The is initialized. */
	private Boolean isInitialized = false;
	
	/** The instance. */
	private static Connection instance;
	
	/** The cached account. */
	private static Account cachedAccount=null;
	
	/** The header. */
	private String header;

	/**
	 * Instantiates a new connection.
	 * Private constructor prevents instantiation from other classes
	 */
	private Connection() 
	{
		super();
	}

	/**
	 * Gets the single instance of Connection (Singleton)
	 *
	 * @return Singleton Connection
	 */
	public final static Connection getInstance() 
	{
		if (Connection.instance == null) 
		{
			synchronized (Connection.class) 
			{
				if (Connection.instance == null) 
				{
					Connection.instance = new Connection();
				}
			}
		}

		return Connection.instance;
	}

	/**
	 * Checks if the account is initialized.
	 *
	 * @return A Boolean which indicate if the account is initialized
	 */
	public Boolean isInitialized() 
	{
		return (isInitialized);
	}

	/**
	 * Initialize the connection.
	 *
	 * @param backendUrl the backend url
	 * @param username the username
	 * @param password the password
	 * @return Connection
	 */
	public Connection initialize(String backendUrl, String username, String password)
	{
		this.backendUrl = backendUrl;
		this.username = username;
		this.password = password;

		GsonBuilder gsonBuilder = new GsonBuilder();

		// TODO : Handle timezones properly
		gson = gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

		String plainAuthenticationString = this.username + ":" + this.password;

		try 
		{
			authenticationString = new String(Base64.encodeBase64(plainAuthenticationString.getBytes("UTF-8")));
		} 
		catch (UnsupportedEncodingException e) 
		{
			// This should never happen
		}

		this.isInitialized = true;

		return (Connection.getInstance());
	}

	
	
	/**
	 * Method GET and POST.
	 *
	 * @param httpVerb the http verb
	 * @param path
	 * @return A String
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConnectionNotInitializedException the connection not initialized exception
	 */
	public String doRequest(String httpVerb, String path) throws IOException, ConnectionNotInitializedException 
	{
		return (doRequest(httpVerb, path, null));
	}

	/**
	 * Do request.
	 * There are two principals types of request : GET and POST
	 * If the server return an error, this method will return a String containing the error code and the error message.
	 * If the request is accepted, this method will return a String containing the message response.
	 *
	 * @param httpVerb
	 * @param path the
	 * @param jsonData
	 * @return A String
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConnectionNotInitializedException the connection not initialized exception
	 */
	public String doRequest(String httpVerb, String path, JsonObject jsonData) throws IOException, ConnectionNotInitializedException 
	{

		if (!isInitialized()) 
		{
			throw new ConnectionNotInitializedException("Connection has not been initialized");
		}
		
		System.out.println("ACTUAL VERSION SDK : " + Build.VERSION.SDK);
		System.out.println("FROYO VERSION SDK : " + Build.VERSION_CODES.FROYO);
		
		if (Integer.parseInt(Build.VERSION.SDK) <= Build.VERSION_CODES.FROYO) 
		{
	        System.setProperty("http.keepAlive", "false");
	        System.out.println("C'EST LE CAS !!");
	        
	        if (httpVerb.equals(HttpVerb.GET))
	        {
	        	HttpClient http_client = new DefaultHttpClient();
	        	
		        HttpGet http_get = new HttpGet(backendUrl + path);
		        http_get.setHeader("Authorization", "Basic " + authenticationString);
		        http_get.setHeader("Accept", "application/json");
		        //http_get.setHeader("Content-Type", "application/json");

		        
		        HttpResponse response = http_client.execute(http_get);
		        System.out.println(response);
				InputStream content = response.getEntity().getContent();
				
				BufferedReader responseReader = new BufferedReader(new InputStreamReader(content));
				
				StringBuilder responseBuilder = new StringBuilder();
				String line = null;
				
				while ((line = responseReader.readLine()) != null) 
				{
					responseBuilder.append(line);
				}
				System.out.println("Return get : " + responseBuilder.toString());
				return (responseBuilder.toString());
	        }
	        else if (httpVerb.equals(HttpVerb.POST))
	        {
	        	if (jsonData == null) 
				{
					throw new IllegalArgumentException("Cannot POST with empty body");
				}
	        	
	        	String jsonString = jsonData.toString();
	        	
	        	HttpClient http_client = new DefaultHttpClient();
	        	http_client.getParams().setParameter("http.protocol.version",HttpVersion.HTTP_1_0);
	        	
				HttpPost http_post = new HttpPost(backendUrl + path);
				http_post.setHeader("Authorization", "Basic " + authenticationString);
				http_post.setHeader("Accept", "application/json");
				http_post.setHeader("Content-Type", "application/json");

				//http_post.setHeader("Content-Length", Integer.toString(jsonString.getBytes().length));
				StringEntity s = new StringEntity(jsonString);
				s.setContentType("application/json");
				http_post.setEntity(s);


				
				HttpResponse response = http_client.execute(http_post);
				InputStream content = response.getEntity().getContent();
				
				BufferedReader responseReader = new BufferedReader(new InputStreamReader(content));
				
				StringBuilder responseBuilder = new StringBuilder();
				String line = null;
				
				while ((line = responseReader.readLine()) != null) 
				{
					responseBuilder.append(line);
				}
				System.out.println("Return post: " + responseBuilder.toString());
				return (responseBuilder.toString());
				
				
	        }

	        return null;
	    }
		else
		{
			URL requestURL = new URL(backendUrl + path);
			HttpURLConnection backendConnection = (HttpURLConnection) requestURL.openConnection();

			backendConnection.setRequestProperty("Authorization", "Basic " + authenticationString);
			backendConnection.setRequestProperty("Accept", "application/json");
			backendConnection.setRequestMethod(httpVerb);

			if (httpVerb == HttpVerb.POST) 
			{
				if (jsonData == null) 
				{
					throw new IllegalArgumentException("Cannot POST with empty body");
				}

				String jsonString = jsonData.toString();

				backendConnection.setDoOutput(true);
				backendConnection.setRequestProperty("Content-Type", "application/json");
				backendConnection.setRequestProperty("Content-Length", Integer.toString(jsonString.getBytes().length));

				// Send request
				DataOutputStream dataOutputStream = new DataOutputStream(backendConnection.getOutputStream());
				dataOutputStream.writeBytes(jsonString);
				dataOutputStream.flush();
				dataOutputStream.close();

			}

			
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

				//System.out.println("Code d'erreur : " + backendConnection.getResponseCode());
				//System.out.println("Message d'erreur : " + errorBuilder.toString());
				//System.out.println("Return : " + String.valueOf(backendConnection.getResponseCode()) + " " + errorBuilder.toString());
				
				return ("Resulat : " + String.valueOf(backendConnection.getResponseCode()) + " " + errorBuilder.toString());

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
				
				//System.out.println("Code de succes :"+backendConnection.getResponseCode());
				//System.out.println("Message de succes :"+responseBuilder.toString());
				//System.out.println("Message de succes de la pagniation  (S'il existe) : "+backendConnection.getHeaderField("Pagination"));
				this.header = backendConnection.getHeaderField("Pagination");			
				//System.out.println("Return " + responseBuilder.toString());
				
				return (responseBuilder.toString());
			}
		}
		
	}

	
	
	// Authentication
	/**
	 * Gets the account.
	 *
	 * @return Account
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConnectionNotInitializedException the connection not initialized exception
	 */
	public Account getAccount() throws IOException, ConnectionNotInitializedException 
	{
		return (getAccount(false));
	}

	/**
	 * Gets the account.
	 *
	 * @param cached
	 * @return Account
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConnectionNotInitializedException the connection not initialized exception
	 */
	public Account getAccount(Boolean cached) throws IOException, ConnectionNotInitializedException 
	{
		
		Pattern pattern;
		Matcher matcher;
		boolean address,btc,unconfirmed_btc,locked;
		
		
		String response = doRequest(HttpVerb.GET, "/account");
		
		pattern = Pattern.compile("address");
		matcher = pattern.matcher(response);
		address = matcher.find();
		
		pattern = Pattern.compile("BTC");
		matcher = pattern.matcher(response);
		btc = matcher.find();
		
		pattern = Pattern.compile("UNCONFIRMED_BTC");
		matcher = pattern.matcher(response);
		unconfirmed_btc = matcher.find();
		
		pattern = Pattern.compile("locked");
		matcher = pattern.matcher(response);
		locked = matcher.find();

		System.out.println("--Response Account : " + response);
		
		if (address && btc && unconfirmed_btc)
		{
			System.out.println("AUTHENTICATION SUCCESSFUL !!");
			String account = doRequest(HttpVerb.GET, "/account");
			System.out.println("ACCOUNT : " + account);
			cachedAccount = gson.fromJson(account, Account.class);
			return cachedAccount;
		}
		
		if (locked)
		{
			this.setLocked(true);
		}
		
		System.out.println("AUTHENTICATION FAIL !!");
		
		return null;
	
	}
	
	public boolean isLocked() 
	{
		return locked;
	}

	public void setLocked(boolean locked) 
	{
		this.locked = locked;
	}
	

	// Method get transactions (according to page number and how many transactions per page)
	/**
	 * Gets the transfers.
	 *
	 * @param page
	 * @param per_page
	 * @return ListTransaction
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConnectionNotInitializedException the connection not initialized exception
	 */
	public ListTransaction getTransfers(int page,int per_page) throws IOException, ConnectionNotInitializedException 
	{
		
		if (page == 0 && per_page == 0)
		{
			return (gson.fromJson(doRequest(HttpVerb.GET, "/account/transfers"), ListTransaction.class));
		}
		else
		{
			return (gson.fromJson(doRequest(HttpVerb.GET, "/account/transfers?page="+page+"&"+"per_page="+per_page), ListTransaction.class));
		}
		
	}
	
	
	//Method get recent transactions (>=id)
	
	/**
	 * Gets the latest transfers
	 * 
	 * @param min_id
	 * @param number_of_transactions
	 * @return
	 * @throws IOException
	 * @throws ConnectionNotInitializedException
	 */
	public ListTransaction getRecentTransfers(int min_id, int number_of_transactions) throws IOException, ConnectionNotInitializedException 
	{
		return (gson.fromJson(doRequest(HttpVerb.GET, "/account/transfers?min_id=" + min_id + "&" + "per_page=" + number_of_transactions), ListTransaction.class));	
	}
	
	
	/**
	 * Gets the previous transfers
	 * 
	 * @param max_id
	 * @param number_of_transactions
	 * @return
	 * @throws IOException
	 * @throws ConnectionNotInitializedException
	 */
	//Method get previous transactions (<=id)
	public ListTransaction getPreviousTransfers(int max_id, int number_of_transactions) throws IOException, ConnectionNotInitializedException 
	{
		return (gson.fromJson(doRequest(HttpVerb.GET, "/account/transfers?max_id=" + max_id + "&" + "per_page=" + number_of_transactions), ListTransaction.class));	
	}
	
	
	
	
	// Method get description of invoice (Get HEADER of RESPONSE)
	/**
	 * Gets the invoice.
	 *
	 * @param page
	 * @param per_page
	 * @return the invoice
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConnectionNotInitializedException the connection not initialized exception
	 */
	public Invoice getInvoice(int page,int per_page) throws IOException, ConnectionNotInitializedException 
	{
		if (page == 0 && per_page == 0)
		{
			doRequest(HttpVerb.GET, "/account/transfers");
			return (gson.fromJson(header, Invoice.class));
		}
		else
		{
			doRequest(HttpVerb.GET, "/account/transfers?page="+page+"&"+"per_page="+per_page);
			return (gson.fromJson(header, Invoice.class));
		}
	}
	
	
	
	/**
	 * Post a transfer by email
	 *
	 * @param transfer
	 * @return Transaction
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConnectionNotInitializedException the connection not initialized exception
	 */
	public Transaction postTransferMail(TransferMail transfer) throws IOException, ConnectionNotInitializedException 
	{
		transfer.setType("EmailTransfer");
		JsonElement transferData = gson.toJsonTree(transfer);
		
		JsonObject jsonData = new JsonObject();

		jsonData.add("transfer", transferData);
			
		
		//System.out.println(jsonData.toString());
		Pattern pattern;
		Matcher matcher;
		boolean address,amount,email;
		
		String response = doRequest(HttpVerb.POST, "/account/transfers", jsonData);
		
		pattern = Pattern.compile("address");
		matcher = pattern.matcher(response);
		address = matcher.find();
					
		pattern = Pattern.compile("amount");
		matcher = pattern.matcher(response);
		amount = matcher.find();
		
		pattern = Pattern.compile("email");
		matcher = pattern.matcher(response);
		email = matcher.find();
		
		System.out.println("--Response transfer : " + response);
		if( address && amount && email )
		{
			System.out.println("Your transfer is done");
			return (gson.fromJson(response, Transaction.class));
		}	
		else
		{
			System.out.println("Please check the address of beneficiary");
			
			return null;
		}
	}
	
	
	
	/**
	 * Post a transfer by address bitcoin	
	 *
	 * @param transfer
	 * @return Transaction
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConnectionNotInitializedException the connection not initialized exception
	 */
	public Object postTransferAddressBitcoin(TransferAddressBitcoin transfer) throws IOException, ConnectionNotInitializedException 
	{
		
		JsonElement transferData = gson.toJsonTree(transfer);
		
		JsonObject jsonData = new JsonObject();

		jsonData.add("transfer", transferData);
			
		//System.out.println(jsonData.toString());
		
		Pattern pattern;
		Matcher matcher;
		boolean address,amount,email;
		
		String response = doRequest(HttpVerb.POST, "/account/transfers", jsonData);
		
		pattern = Pattern.compile("address");
		matcher = pattern.matcher(response);
		address = matcher.find();
					
		pattern = Pattern.compile("amount");
		matcher = pattern.matcher(response);
		amount = matcher.find();
		
		pattern = Pattern.compile("email");
		matcher = pattern.matcher(response);
		email = matcher.find();
		
		System.out.println("--Response transfer : " + response);
		if( address && amount && email )
		{
			System.out.println("Your transfer is done");
			return (gson.fromJson(response, Transaction.class));
		}	
		else
		{
			System.out.println("Please check the address of beneficiary");
			
			return response;
		}		
	}


	/**
	 * Register the device id.
	 *
	 * @param deviceId
	 * @return String
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConnectionNotInitializedException the connection not initialized exception
	 */
	public String registerDevice(String deviceId) throws IOException, ConnectionNotInitializedException 
	{
		JsonElement deviceData = gson.toJsonTree(new NewDevice(deviceId), NewDevice.class);
		JsonObject jsonData = new JsonObject();

		jsonData.add("android_device", deviceData);

		return doRequest(HttpVerb.POST, "/user/android_devices", jsonData);
	}
	

	/**
	 * Delete the device id
	 *
	 * @param deviceId
	 * @return Device
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ConnectionNotInitializedException the connection not initialized exception
	 */
	public Device deleteDevice(String deviceId) throws IOException, ConnectionNotInitializedException 
	{	
		Device device = gson.fromJson(this.registerDevice(deviceId), Device.class);
		
		doRequest(HttpVerb.DELETE, "/user/android_devices/" + String.valueOf(device.getId()));
		
		return device;
	}
}
