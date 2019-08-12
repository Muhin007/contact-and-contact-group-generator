package randomData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLastName {
    public String printLastName(boolean sex) throws IOException {
        String maleLastName = "maleLastNames.txt";
        String femaleLastName = "femaleLastNames.txt";
        String filePath;
        if (!sex) {
            filePath = femaleLastName;
        } else {
            filePath = maleLastName;
        }
        Random random = new Random();
        List<String> lastNames = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(RandomLastName.class.getClassLoader()
                .getResourceAsStream(filePath), "UTF8"));
        String r;
        assert in != null;
        while ((r = in.readLine()) != null) {
            lastNames.add(r.replaceAll("\\s+", ""));
        }
        try {
            in.close();
        } catch (
                IOException e)
        {
            e.printStackTrace();
        }
        return lastNames.get(random.nextInt(lastNames.size()));
    }
}

