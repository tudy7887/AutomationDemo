package testng.fetraining;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CustomerTrainingTest extends LoginTest {
    private String biceps, triceps, legs, chest;

    @BeforeSuite (alwaysRun = true)
    public void Setup(){
        super.Setup();
        InitializeProperties();
    }

    @Test (dependsOnMethods = "LoginSuccessful", groups = "trainingprogram")
    public void ToggleWeekendsCheckBox(){

    }

    private void InitializeProperties(){
        biceps = configLoader.GetProperties("biceps");
        triceps = configLoader.GetProperties("triceps");
        chest = configLoader.GetProperties("chest");
        legs = configLoader.GetProperties("legs");
    }

}
