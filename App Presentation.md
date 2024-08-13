**Automation Demo**

- App Diagram
- ![Java Automation Demo Diagram](https://github.com/user-attachments/assets/bf84c051-495e-452c-a285-1844584828f8)
- Run tests on 2 Apps
- ![image](https://github.com/user-attachments/assets/96e70a1a-81a1-4b91-9248-754c74b67f4c)
- Use Page Object Model Pattern
  - Each Web Page is defined separately
  - ![image](https://github.com/user-attachments/assets/8aed3769-3c9f-48db-b3e8-1f57a04f7bfa)
  - Bridge Pattern to separate between elements definition and elements behavior
    ![image](https://github.com/user-attachments/assets/4af38852-5df8-458b-822b-be039127870f)
  - Elements behavior must implement it's interface
    ![image](https://github.com/user-attachments/assets/7fbd9e7f-9e58-49c6-95b6-91c90bf7db51)
- Facade Pattern to merge all interface in a single one that defines all behaviors  in the app
  ![image](https://github.com/user-attachments/assets/fdf7468e-4b45-4dc1-92cc-a1aba016e881)
- Define a Base Test class thats gonna be used by both, Cucumber and TestNG
  ![image](https://github.com/user-attachments/assets/b637e79f-689b-466b-940a-9a1eae582945)
  - Defines WebDriver and property files
  - Manages reports, and screenshots
- Generated report looks like this
  ![image](https://github.com/user-attachments/assets/bb1e3660-963c-47b9-83e3-a1cb50871bd2)
