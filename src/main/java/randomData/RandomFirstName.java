package randomData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFirstName {
    public String printFirstName(boolean sex) throws IOException {

        String maleFirstName = "maleFirstNames.txt";
        String femaleFirstName = "femaleFirstNames.txt";
        String filePath;
        if (!sex) {
            filePath = femaleFirstName;
        } else {
            filePath = maleFirstName;
        }
        Random random = new Random();
        List<String> firstNames = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(RandomFirstName.class.getClassLoader()
                .getResourceAsStream(filePath), "UTF8"));
        String r;
        assert in != null;
        while ((r = in.readLine()) != null) {
            firstNames.add(r.replaceAll("\\s+", ""));
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstNames.get(random.nextInt(firstNames.size()));
    }
}
