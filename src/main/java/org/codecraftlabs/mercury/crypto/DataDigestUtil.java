package org.codecraftlabs.mercury.crypto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataDigestUtil {
    private DigestAlgorithm digestAlgorithm = DigestAlgorithm.SHA1;

    public DataDigestUtil() {
        // No action performed
    }

    public DataDigestUtil(DigestAlgorithm digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    public byte[] generateDigest(final String data) throws DigestException {
        if (data == null || data.isEmpty()) {
            throw new DigestException("Data is empty or null");
        }

        try {
            MessageDigest digest = MessageDigest.getInstance(digestAlgorithm.getAlgorithmName());
            return digest.digest(data.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException exception) {
            throw new DigestException("Error when processing message digest", exception);
        }
    }

    public String generateDigestForFile(String file) throws IOException, NoSuchAlgorithmException {
        byte[] contents = Files.readAllBytes(Paths.get(file));

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(contents);
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}