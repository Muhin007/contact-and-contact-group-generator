package randomData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAddress {
    private Random random = new Random();

    private String getCity() throws IOException {
        String cites = "C:/DEV/Project/Test3InfinnitySolutions/src/main/resources/cites.txt";
        List<String> sites = new ArrayList<>();
        File file = new File(cites);
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), "UTF8"));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        String r;
        while ((r = in.readLine()) != null) {
            sites.add(r.replaceAll("\\s+", ""));
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sites.get(random.nextInt(sites.size()));
    }

    private String getStreet() throws IOException {
        String cites = "C:/DEV/Project/Test3InfinnitySolutions/src/main/resources/streets.txt";
        List<String> streets = new ArrayList<>();
        File file = new File(cites);
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), "UTF8"));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        String r;
        while ((r = in.readLine()) != null) {
            streets.add(r);
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return streets.get(random.nextInt(streets.size()));
    }

    private int getHouse(){
        return random.nextInt(100);
    }
    private int getFlat(){
        return random.nextInt(100);
    }

    public String getAddress() {
        try {
            return "г." + getCity() + ", " + getStreet() + ", д." + getHouse() + ", кв." + getFlat();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
