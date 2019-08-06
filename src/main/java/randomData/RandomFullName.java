package randomData;

import java.io.IOException;

public class RandomFullName {
    private RandomFirstName randomFirstName = new RandomFirstName();
    private RandomLastName randomLastName = new RandomLastName();
    private RandomPatronymic randomPatronymic = new RandomPatronymic();

    public String getFullName(boolean sex) {
        try {
            return randomFirstName.printFirstName(sex) + " " + randomPatronymic.printPatronymic(sex) + " " + randomLastName.printLastName(sex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
