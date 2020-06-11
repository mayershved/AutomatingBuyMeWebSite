package pageObjects;

import org.openqa.selenium.By;

/**
 *Gift Card Receiver Screen Page Object
 *
 * @author Mayer Shved
 */
public class GiftCardReceiverScreen {

    //class constants
    private static final String RECEIVER_NAME = "ReceiverName";
    private static final String SENDER_NAME = "SenderName";
    private static final String BLESSING_TEXT = "blessingText";
    private static final String EMAIL_FOR_GIFT_CARD = "email_for@gift.com";

    //page By elements
    public By receiverOption = By.xpath("//span[text() = 'למישהו אחר']");
    public By receiverNameElement = By.xpath("//div[@class = 'mx2 md1']/label/input");
    public By senderNameElement = By.xpath("//div[@class = 'mx2 md1']/label[2]/input");
    public By giftCardReasonDropMenu = By.xpath("//span[text() = 'לאיזה אירוע?']");
    public By giftCardReasonOption = By.xpath("//*[text() = 'לידה']");
    public By blessingTextElement = By.xpath("//label[@class = 'ember-view ui-field ui-textarea']/textarea");
    public By loadImage = By.xpath("//div[@class = 'media-fields']/label/input");
    public By GiftPaymentTime = By.cssSelector("label.send-now");
    public By sendGiftCardByEmail = By.cssSelector("span.icon.icon-envelope");
    public By emailForGiftCard = By.xpath("//input[@placeholder = 'כתובת המייל של מקבל/ת המתנה']");
    public By confirmGiftEmail = By.xpath("//button[text() = 'שמירה']");
    public By submitGiftCardReceiverDetails = By.xpath("//button[text() = 'תשלום']");

    /**
     * class field getter
     * @return
     */
    public String getReceiverName(){
        return RECEIVER_NAME;
    }

    /**
     * class field getter
     * @return
     */
    public String getSender_Name(){
        return SENDER_NAME;
    }

    /**
     * class field getter
     * @return
     */
    public String getBlesingText(){
        return BLESSING_TEXT;
    }

    /**
     * class field getter
     * @return
     */
    public String getEmailForGiftCard(){
        return EMAIL_FOR_GIFT_CARD;
    }
}


