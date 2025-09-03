package com.bootcamp.roshka.tools;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

    public static String GetSHA256(String pass) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        digest.update(pass.getBytes(StandardCharsets.UTF_8));

        byte[] hashBytes = digest.digest();

        BigInteger bigInt = new BigInteger(1, hashBytes);

        return bigInt.toString(16);
    }
}
