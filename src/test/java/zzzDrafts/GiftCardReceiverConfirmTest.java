//package projectTests;
//
//import com.aventstack.extentreports.Status;
//import commonMethods.ScreenShot;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import pageObjects.GiftCardReceiverScreen;
//import testsBases.TestBaseForLastTestClass;
//
//import java.io.IOException;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class GiftCardReceiverConfirmTest extends TestBaseForLastTestClass {
//
//    private static GiftCardReceiverTest receiverScreen = new GiftCardReceiverTest();
//    private GiftCardReceiverScreen confirmReceiver = new GiftCardReceiverScreen();
//    private ScreenShot screenShot = new ScreenShot(singletonDriver.driver);
//
////    @Test
////    public void test_1_SendGiftCardByEmail(){
////
////        try{
////            userAction.clickElement(confirmReceiver.sendGiftCardByEmail);
////            isClicked = true;
////        }catch(Exception e){
////            receiverScreen.testReportForGiftCardReceiver.log(Status.ERROR, "email option was not clicked");
////            receiverScreen.testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
////        }finally {
////            if(isClicked){
////                receiverScreen.testReportForGiftCardReceiver.log(Status.PASS, "email option clicked succesfully");
////            }
////        }
////    }
////
////    @Test
////    public void test_2_EmailForGiftCard(){
////        try{
////            userAction.clearFromText(confirmReceiver.emailForGiftCard);
////            userAction.userInput(confirmReceiver.emailForGiftCard,confirmReceiver.emailForGift);
////            isClicked = true;
////        }catch (Exception e){
////            receiverScreen.testReportForGiftCardReceiver.log(Status.ERROR, "receiver email input failed");
////            receiverScreen.testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
////        }finally {
////            if(isClicked)
////                receiverScreen.testReportForGiftCardReceiver.log(Status.PASS, "receiver email input succeeded");
////
////        }
////    }
////    @Test
////    public void test_3_ConfirmGiftEmail() {
////
////        try{
////            userAction.clickElement(confirmReceiver.confirmGiftEmail);
////            isClicked = true;
////        }catch(Exception e){
////            receiverScreen.testReportForGiftCardReceiver.log(Status.ERROR, "receiver email has not been confirmed");
////            receiverScreen.testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
////        }finally {
////            if(isClicked)
////                receiverScreen.testReportForGiftCardReceiver.log(Status.PASS, "receiver email confirmed succesfully");
////        }
////    }
//
//    @Test
//    public void test_01_GiftReceiverCoinfirm() throws IOException, InterruptedException {
//        Thread.sleep(2000);
//        screenShot.setScreenShotToReportDetails("gift card details", receiverScreen.testReportForGiftCardReceiver);
//
//        try {
//            userAction.clickElement(confirmReceiver.submitGiftCardReceiverDetails);
//            isClicked = true;
//        } catch (Exception e) {
//            receiverScreen.testReportForGiftCardReceiver.log(Status.ERROR, "gift card submit button was not clicked");
//            receiverScreen.testReportForGiftCardReceiver.log(Status.INFO, e.getMessage());
//        } finally {
//            if (isClicked)
//                receiverScreen.testReportForGiftCardReceiver.log(Status.PASS, "gift card submit button was clicked");
//                Thread.sleep(3000);
//                screenShot.setScreenShotToReportDetails("final Screen", receiverScreen.testReportForGiftCardReceiver);
//        }
//    }
//}
