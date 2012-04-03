package paymium.paytunia.library;

import java.io.IOException;
import java.math.BigDecimal;

import paymium.paytunia.PaytuniaAPI.Connection;
import paymium.paytunia.PaytuniaAPI.Currency;
import paymium.paytunia.PaytuniaAPI.account.Account;
import paymium.paytunia.PaytuniaAPI.account.NewAccount;
import paymium.paytunia.PaytuniaAPI.account.RegisterAccount;
import paymium.paytunia.PaytuniaAPI.exceptions.ConnectionNotInitializedException;
import paymium.paytunia.PaytuniaAPI.transaction.ListTransaction;
import paymium.paytunia.PaytuniaAPI.transfer.TransferAddressBitcoin;
import paymium.paytunia.PaytuniaAPI.transfer.TransferMail;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PaytuniaLibraryActivity extends Activity 
{
   
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView a = (TextView) findViewById(R.id.textView1);
        
        Connection connection = Connection.getInstance().initialize("https://paytunia.com", 
																	//"trung.nguyen@paymium.com",
																	//"nguyennhuquoctrung300890@gmail.com",
		        													"BC-U881424",
																	"trung.nguyen");
        try {

			/* LOG IN TO AN ACCOUNT AND SHOW ACCOUNT DESCRIPTION */
			
			Account account = connection.getAccount();
			System.out.println(account);
			System.out.println(connection.isLocked());
			
			if (account != null)
			{
			
				a.setText(account.toString());
				/* PRINT THE FIRST PAGE AND THE SECOND PAGE OF TRANSACTIONS */
				
				
				ListTransaction transactions = new ListTransaction();
				

				//First page (20 transactions per page)
				System.out.println("**************PAGE 1**************");
				transactions = connection.getTransfers(0,0); // or transactions = connection.getTransfers(1,20)
				System.out.println(transactions.toString());
				
				
				//Second page (20 transactions per page)
				System.out.println("**************PAGE 2**************");		
				transactions = connection.getTransfers(2,20);
				System.out.println(transactions.toString());
				
				
				//min_id = 24624
				System.out.println("**************min_id = 24624**************");			
				transactions = connection.getRecentTransfers(24624, 100);
				System.out.println(transactions.toString());
				
				//max_id = 24934
				System.out.println("**************max_id = 24934**************");		
				transactions = connection.getPreviousTransfers(24934, 20);
				System.out.println(transactions.toString());
				
				
				/* MAKE A TRANSFER */
				
				
				// By Email
				
				TransferMail transferMail = new TransferMail();
				
				transferMail.setEmail("nguyennhuquoctrung300890@gmail.com");
				transferMail.setAmount(BigDecimal.valueOf(0.0623));
				transferMail.setCurrency(Currency.BTC);
				
				Object transaction = null;
				transaction = connection.postTransferMail(transferMail);
				
				System.out.println("++++++++++++++++++++++++++++++++++");
				System.out.println(transaction.getClass().getSimpleName());
				System.out.println(transaction.toString());
				System.out.println("++++++++++++++++++++++++++++++++++");
				
				
				
				// By Address Bitcoin
				
				TransferAddressBitcoin transferAddressBitcoin = new TransferAddressBitcoin();
				
				transferAddressBitcoin.setAddressBitcoin("13bUaUVYd29RdvburspmwumBiDEycHS8Yq");
				transferAddressBitcoin.setAmount(BigDecimal.valueOf(0.0525));
				transferAddressBitcoin.setCurrency(Currency.BTC);
				
				transaction = connection.postTransferAddressBitcoin(transferAddressBitcoin);
				
				System.out.println("++++++++++++++++++++++++++++++++++");
				System.out.println(transaction.getClass().getSimpleName());
				System.out.println(transaction.toString());
				System.out.println("++++++++++++++++++++++++++++++++++");
				
				
				
				// Sending to yourself ( Your Address Bitcoin )
				
				transferAddressBitcoin = new TransferAddressBitcoin();
				
				transferAddressBitcoin.setAddressBitcoin("1PpzTD8BqxZwjyT9ybsLEjUXNxbgsc8PYE");
				transferAddressBitcoin.setAmount(BigDecimal.valueOf(0.0525));
				transferAddressBitcoin.setCurrency(Currency.BTC);
				
				transaction = connection.postTransferAddressBitcoin(transferAddressBitcoin);
				
				System.out.println("++++++++++++++++++++++++++++++++++");
				System.out.println(transaction.getClass().getSimpleName());
				System.out.println(transaction.toString());
				System.out.println("++++++++++++++++++++++++++++++++++");
				
				
				
				/* SIGN UP */
				
				NewAccount newAccount = new NewAccount("nguyen.nhu.quoc.trung300890@gmail.com"
														,"trung30890"
														,"trung30890");
				RegisterAccount register = new RegisterAccount();
				
				String registerToken = "nguyen nhu quoc trung";
				System.out.println(register.Request(newAccount,registerToken));

				
				
				/* REGISTER AND DELETE DEVICE TOKEN ( PUSH NOTIFICATION ) */
				
				//System.out.println(connection.registerDevice("APA91bH_N7p34tY4s7SsY-n2uN7TaI-8LyRcZvuURyQ_g9hn1m1JQ75SGAkPXu9Zl90h7MjIBDqNSjx-xpYtd7VRXA0Ux6LiHBoFS9up9Rrz8-M2gVP_Dkilme7GVtOOZBWEa-z9FJjwlMMO99E8CsZmnr9N5Dk-lQ"));
				//connection.deleteDevice("APA91bH_N7p34tY4s7SsY-n2uN7TaI-8LyRcZvuURyQ_g9hn1m1JQ75SGAkPXu9Zl90h7MjIBDqNSjx-xpYtd7VRXA0Ux6LiHBoFS9up9Rrz8-M2gVP_Dkilme7GVtOOZBWEa-z9FJjwlMMO99E8CsZmnr9N5Dk-lQ");
				
				
				
				/* INVOICE (NUMBER OF PAGES, NUMBER OF TRANSACTIONS PER PAGE) */
				
				
				// Invoice by default
				/*Invoice a = connection.getInvoice(0,0);
				
				System.out.println(a.getOffset());
				System.out.println(a.isFirst_page());
				System.out.println(a.getTotal());
				System.out.println(a.getPrevious_page());
				System.out.println(a.getTotal_pages());
				System.out.println(a.isLast_page());
				System.out.println(a.getNext_page());
				
				
				// Invoice modified
				a = connection.getInvoice(3,20);
				
				System.out.println(a.getOffset());
				System.out.println(a.isFirst_page());
				System.out.println(a.getTotal());
				System.out.println(a.getPrevious_page());
				System.out.println(a.getTotal_pages());
				System.out.println(a.isLast_page());
				System.out.println(a.getNext_page());*/

			}
			
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ConnectionNotInitializedException e) 
		{
			e.printStackTrace();
		}
    }
}