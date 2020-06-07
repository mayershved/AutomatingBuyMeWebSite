package projectTests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardSupplierScreen;
import testsBases.GiftCardSupplierBaseForTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardSupplierTest extends GiftCardSupplierBaseForTest {

   private GiftCardSupplierScreen giftCardSupplierScreen= new GiftCardSupplierScreen();

   @Test
    public void test_1_giftCardMoneyAmount() throws InterruptedException {
       Thread.sleep(3000);
       userActions.userInput(giftCardSupplierScreen.giftCardAmmount,giftCardSupplierScreen.giftCardMoneyAmount);
   }

   @Test
   public void test_2_chooseGiftCard(){
      userActions.clickElement(giftCardSupplierScreen.submitGiftCardMoneyAmount);
   }

}
