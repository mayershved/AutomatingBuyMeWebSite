package pageObjects;

import commonMethods.UserActions;
import singleton.SingletonDriver;

public class GiftCardsScreen extends UserActions {

    protected static SingletonDriver singletonDriver = SingletonDriver.getInstance();




    public GiftCardsScreen(){
        super(singletonDriver.driver);
    }
}
