**Automation Demo**

- App Diagram
- ![Untitled Diagram drawio](https://github.com/user-attachments/assets/bb80017b-8370-4e34-b558-4eed1c27a6b0)
- Run tests on 2 Apps
- Use Page Object Model Pattern
  - Each Web Page is defined separately
  - Bridge Pattern to separate between elements definition and elements behavior
    ![image](https://github.com/user-attachments/assets/4af38852-5df8-458b-822b-be039127870f)
  - Elements behavior must implement it's interface
    ![image](https://github.com/user-attachments/assets/7fbd9e7f-9e58-49c6-95b6-91c90bf7db51)
- Facade to merge all interface in a single one that defines all behaviors  in the app
  ![image](https://github.com/user-attachments/assets/fdf7468e-4b45-4dc1-92cc-a1aba016e881)
- Define a Base Test class used by both Cucumber and TestNG
  ![image](https://github.com/user-attachments/assets/b637e79f-689b-466b-940a-9a1eae582945)
  - Defines WebDriver and property files
  - Use Selenium to perform automations
  - Manages reports, and screenshots
- Generated report looks like this
  ![image](https://github.com/user-attachments/assets/bb1e3660-963c-47b9-83e3-a1cb50871bd2)
