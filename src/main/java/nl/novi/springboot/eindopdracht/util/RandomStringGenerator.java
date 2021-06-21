package nl.novi.springboot.eindopdracht.util;

import java.util.Random;
public class RandomStringGenerator {

        public static String generateRandomString (int lenght){
            int leftLimit = 48;
            int rightLimit = 122;
            Random randomline = new Random();
             String randomString = randomline.ints(leftLimit, rightLimit+1)
                    .filter(i -> (i<= 57 || i >= 65) && (i <= 90 || i>=97))
                    .limit(lenght)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            return randomString;
        }
}
