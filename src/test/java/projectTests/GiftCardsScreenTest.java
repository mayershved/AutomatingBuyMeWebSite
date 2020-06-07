package projectTests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardsScreen;
import testsBases.GiftCardsBaseForTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardsScreenTest extends GiftCardsBaseForTest {

    GiftCardsScreen giftCardsScreen = new GiftCardsScreen();

    @Test
    public void test_1_ChooseGiftCardCompany() throws InterruptedException {
        Thread.sleep(1000);
        userAction.clickElement(giftCardsScreen.giftCardCompany);
        System.out.println("test_1_ChooseGiftCardCompany");
    }
}
