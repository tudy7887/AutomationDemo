package parabank.interfaces;

public interface IUpdateContractInfoPageActions extends IBaseActions {
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
   String GetFirstName();
   String GetLastName();
   String GetAddress();
   String GetState();
   String GetCity();
   String GetZipCode();
   String GetPhone();
}
