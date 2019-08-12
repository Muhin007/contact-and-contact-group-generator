package randomData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPatronymic {
    public String printPatronymic(boolean sex) throws IOException {
        String malePatronymic = "malePatronymic.txt";
        String femalePatronymic = "femalePatronymic.txt";
        String filePath;
        if (!sex) {
            filePath = femalePatronymic;
        } else {
            filePath = malePatronymic;
        }
        Random random = new Random();
        List<String> patronymics = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(RandomPatronymic.class.getClassLoader()
                .getResourceAsStream(filePath), "UTF8"));
        String r;
        assert in != null;
        while ((r = in.readLine()) != null) {
            patronymics.add(r.replaceAll("\\s+", ""));
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patronymics.get(random.nextInt(patronymics.size()));
    }
}
