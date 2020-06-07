package projectTests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardSupplierScreen;
import testsBases.CommonTestBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardSupplierTest extends CommonTestBase {

   private GiftCardSupplierScreen giftCardSupplierScreen= new GiftCardSupplierScreen();

   @Test
    public void test_1_giftCardMoneyAmount() throws InterruptedException {
       userAction.userInput(giftCardSupplierScreen.giftCardAmmount,giftCardSupplierScreen.giftCardMoneyAmount);
   }

   @Test
   public void test_2_chooseGiftCard() throws InterruptedException {
       userAction.clickElement(giftCardSupplierScreen.submitGiftCardMoneyAmount);
   }
}
