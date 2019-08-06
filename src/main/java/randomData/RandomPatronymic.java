package randomData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPatronymic {
    public String printPatronymic(boolean sex) throws IOException {
        String malePatronymic = "C:/DEV/Project/Test3InfinnitySolutions/src/main/resources/malePatronymic.txt";
        String femalePatronymic = "C:/DEV/Project/Test3InfinnitySolutions/src/main/resources/femalePatronymic.txt";
        String filePath;
        if (!sex) {
            filePath = femalePatronymic;
        } else {
            filePath = malePatronymic;
        }
        Random random = new Random();
        List<String> patronymics = new ArrayList<>();
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
            patronymics.add(r.replaceAll("\\s+",""));
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patronymics.get(random.nextInt(patronymics.size()));
    }
}
