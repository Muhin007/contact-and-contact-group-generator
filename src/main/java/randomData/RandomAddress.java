package randomData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAddress {
    private Random random = new Random();

    private String getCity() throws IOException {
        String city = "cites.txt";
        List<String> cites = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(RandomAddress.class.getClassLoader()
                .getResourceAsStream(city), "UTF8"));
        String r;
        while ((r = in.readLine()) != null) {
            cites.add(r.replaceAll("\\s+", ""));
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cites.get(random.nextInt(cites.size()));
    }

    private String getStreet() throws IOException {
        String street = "streets.txt";
        List<String> streets = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(RandomAddress.class.getClassLoader()
                .getResourceAsStream(street), "UTF8"));
        String r;
        assert in != null;
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

    private int getHouse() {
        return random.nextInt(100);
    }

    private int getFlat() {
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
