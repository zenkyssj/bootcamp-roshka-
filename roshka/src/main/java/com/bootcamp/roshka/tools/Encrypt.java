package com.bootcamp.roshka.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String GetBCRYPT(String pass) throws NoSuchAlgorithmException {
        return encoder.encode(pass);
    }
}
