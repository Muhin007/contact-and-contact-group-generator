package randomData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNameGroup {

    public String printNameGroup() throws IOException {

        String filePath = "words.txt";
        Random random = new Random();
        List<String> firstNames = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(RandomNameGroup.class.getClassLoader()
                .getResourceAsStream(filePath), "UTF8"));
        String r;
        assert in != null;
        while ((r = in.readLine()) != null) {
            firstNames.add(r);
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstNames.get(random.nextInt(firstNames.size()));
    }
}
