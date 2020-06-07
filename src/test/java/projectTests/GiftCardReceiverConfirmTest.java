package projectTests;

import org.junit.Test;
import pageObjects.GiftCardReceiverConfirm;
import testsBases.CommonTestBase;

public class GiftCardReceiverConfirmTest extends CommonTestBase {

    private GiftCardReceiverConfirm confirmReceiver = new GiftCardReceiverConfirm();

    @Test
    public void testGiftReceiverCoinfirm(){
        userAction.clickElement(confirmReceiver.submitGiftCardReceiverDetails);
    }
}
