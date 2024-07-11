package parabank.facade;

import org.openqa.selenium.WebDriver;
import parabank.actions.*;
import parabank.classes.User;
import parabank.interfaces.*;

import java.util.HashMap;
import java.util.Map;

public class ParaBankFacade implements IParaBankFacade {
    protected IAccountsDetailPageActions iAccountsDetailPageActions;
    protected ITransactionDetailsPageActions iTransactionDetailsPageActions;
    protected IAccountsOverviewPageActions iAccountsOverviewPageActions;
    protected IBillPayPageActions iBillPayPageActions;
    protected IFindTransactionsPageActions iFindTransactionsPageActions;
    protected ILoginPageActions iLoginPageActions;
    protected IOpenNewAccountPageActions iOpenNewAccountPageActions;
    protected IRegisterPageActions iRegisterPageActions;
    protected IRequestLoanPageActions iRequestLoanPageActions;
    protected ITransferFundsPageActions iTransferFundsPageActions;
    protected IUpdateContractInfoPageActions iUpdateContractInfoPageActions;
    protected IWelcomePageActions iWelcomePageActions;
    protected Map<String, User> users;

    public ParaBankFacade(WebDriver driver){
        iAccountsDetailPageActions = new AccountsDetailPageActions(driver);
        iTransactionDetailsPageActions = new TransactionDetailsPageActions(driver);
        iAccountsOverviewPageActions = new AccountsOverviewPageActions(driver);
        iBillPayPageActions = new BillPayPageActions(driver);
        iFindTransactionsPageActions = new FindTransactionsPageActions(driver);
        iLoginPageActions = new LoginPageActions(driver);
        iOpenNewAccountPageActions = new OpenNewAccountPageActions(driver);
        iRegisterPageActions = new RegisterPageActions(driver);
        iRequestLoanPageActions = new RequestLoanPageActions(driver);
        iTransferFundsPageActions = new TransferFundsPageActions(driver);
        iUpdateContractInfoPageActions = new UpdateContractInfoPageActions(driver);
        iWelcomePageActions = new WelcomePageActions(driver);
        users = new HashMap<String, User>();
    }

    protected void AddUser(User user){ users.put(user.GetUsername(), user); }
    protected User GetUser(String username){ return users.get(username); }
}
