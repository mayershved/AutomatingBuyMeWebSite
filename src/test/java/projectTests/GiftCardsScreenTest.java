package projectTests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardsScreen;
import testsBases.CommonTestBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardsScreenTest extends CommonTestBase {

   private GiftCardsScreen giftCardsScreen = new GiftCardsScreen();

    @Test
    public void test_1_ChooseGiftCardCompany(){
        userAction.clickElement(giftCardsScreen.giftCardCompany);
    }
}
