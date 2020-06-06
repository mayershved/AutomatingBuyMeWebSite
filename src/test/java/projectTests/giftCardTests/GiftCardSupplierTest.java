package projectTests.giftCardTests;

import org.junit.Test;
import pageObjects.GiftCardSupplierScreen;

public class GiftCardSupplierTest extends GiftCardSupplierBaseForTest{

   private GiftCardSupplierScreen giftCardSupplierScreen= new GiftCardSupplierScreen();

   @Test
    public void test_1_giftCardMoneyAmount() throws InterruptedException {
       Thread.sleep(300);
       userActions.userInput(giftCardSupplierScreen.giftCardAmmount,giftCardSupplierScreen.giftCardMoneyAmount);
   }

   @Test
   public void test_2_chooseGiftCard(){
      userActions.clickElement(giftCardSupplierScreen.submitGiftCardMoneyAmount);
   }

}
