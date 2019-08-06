package randomData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLastName {
    public String printLastName(boolean sex) throws IOException {
        String maleLastName = "C:/DEV/Project/Test3InfinnitySolutions/src/main/resources/maleLastNames.txt";
        String femaleLastName = "C:/DEV/Project/Test3InfinnitySolutions/src/main/resources/femaleLastNames.txt";
        String filePath;
        if (!sex) {
            filePath = femaleLastName;
        } else {
            filePath = maleLastName;
        }
        Random random = new Random();
        List<String> lastNames = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), "UTF8"));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        String r;
        while ((r = in.readLine()) != null) {
            lastNames.add(r.replaceAll("\\s+",""));
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastNames.get(random.nextInt(lastNames.size()));
    }

}

