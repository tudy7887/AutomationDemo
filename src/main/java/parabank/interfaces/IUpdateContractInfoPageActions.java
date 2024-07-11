package parabank.interfaces;

public interface IUpdateContractInfoPageActions extends IUserBaseActions {
   void EnterFirstName(String text);
   void EnterLastName(String text);
   void EnterAddress(String text);
   void EnterState(String text);
   void EnterCity(String text);
   void EnterZipCode(String text);
   void EnterPhone(String text);
   void ClickUpdateProfileButton();
   String GetUpdateSuccessfulMessage();
   void ClearFirstName();
   void ClearLastName();
   void ClearAddress();
   void ClearState();
   void ClearCity();
   void ClearZipCode();
   void ClearPhone();
}
