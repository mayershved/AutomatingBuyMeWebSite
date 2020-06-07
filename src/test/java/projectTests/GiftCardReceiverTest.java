package projectTests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pageObjects.GiftCardReceiverScreen;
import testsBases.CommonTestBase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GiftCardReceiverTest extends CommonTestBase {

    private GiftCardReceiverScreen  giftReceiver= new GiftCardReceiverScreen();

    @Test
    public void test_1_ChooseReceiver(){
        userAction.clickElement(giftReceiver.receiverOption);
    }

    @Test
    public void test_2_inputReceiverName(){
//        userAction.userInput(giftReceiver.receiverNameElement,giftReceiver.receiverName);
    }
// not in use
//    @Test
//    public void test_3_GiftCardReasonDropMenu(){
//        userAction.clickElement(giftReceiver.giftCardReasonDropMenu);
//    }
//not in use
    @Test
    public void test_3_ChooseGiftCardReasonOption() {
//        userAction.clickElement(giftReceiver.giftCardReasonOption);
    }

    @Test
    public void test_4_BlessingTextForGiftCard(){
        //userAction.clearFromText(giftReceiver.blessingTextElement);
        userAction.userInput(giftReceiver.blessingTextElement,giftReceiver.blessingText);
    }

//    @Test
//    public void test_5_LoadImage() {
//        userAction.clickElement(giftReceiver.loadImage);
//        System.out.println("file choosen");
//    }
//
    @Test
    public void test_5_GiftCardPaymentTime(){
        userAction.clickElement(giftReceiver.GiftPaymentTime);
    }

    @Test
    public void test_6_SendGiftCardByEmail(){
        userAction.clickElement(giftReceiver.sendGiftCardByEmail);
    }

    @Test
    public void test_7_EmailForGiftCard(){
        userAction.clearFromText(giftReceiver.emailForGiftCard);
        userAction.userInput(giftReceiver.emailForGiftCard,giftReceiver.emailForGift);
    }

    @Test
    public void test_8_ConfirmGiftEmail(){
        userAction.clickElement(giftReceiver.confirmGiftEmail);
    }

//    @Test
//    public void test_19_SubmitGiftCardReceiverDetails() throws InterruptedException {
//        userAction.clickElement(giftReceiver.submitGiftCardReceiverDetails);
//    }
}
