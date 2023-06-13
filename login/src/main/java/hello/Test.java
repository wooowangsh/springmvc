package hello;

import java.util.Date;
import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();

        System.out.println(uuid);

        Date date = new Date();
        System.out.println(date.getTime());

    }
}
