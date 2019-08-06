package randomData;

import java.util.Random;

public class RandomNumberOfPhone {
    private static final int PHONE_NUMBER_LENGTH = 9;

    public String getNumberOfPhone() {
        String s = "0123456789";
        StringBuffer phoneNumber = new StringBuffer();

        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            phoneNumber.append(s.charAt(new Random().nextInt(s.length())));
        }
        return "+79" + phoneNumber.toString();
    }
}
