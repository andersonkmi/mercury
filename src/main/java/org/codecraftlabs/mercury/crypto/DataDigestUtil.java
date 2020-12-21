package org.codecraftlabs.mercury.crypto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataDigestUtil {
    private DigestAlgorithm digestAlgorithm = DigestAlgorithm.MD5;

    public DataDigestUtil() {
        // No action performed
    }

    public DataDigestUtil(DigestAlgorithm digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    public DigestAlgorithm getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public void setDigestAlgorithm(DigestAlgorithm digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    public String generateDigestIntoString(final String data) throws DigestException {
        byte[] digestContents = generateDigestByteArray(data);
        return convertFromByteArray(digestContents);
    }

    public byte[] generateDigestByteArray(final String data) throws DigestException {
        if (data == null || data.isEmpty()) {
            throw new DigestException("Data is empty or null");
        }
        return generateDigest(data.getBytes(StandardCharsets.UTF_8));
    }

    public byte[] generateDigest(byte[] contents) throws DigestException {
        if (digestAlgorithm == null) {
            throw new DigestException("Null digest algorithm");
        }

        try {
            MessageDigest digest = MessageDigest.getInstance(digestAlgorithm.getAlgorithmName());
            return digest.digest(contents);
        } catch (NoSuchAlgorithmException exception) {
            throw new DigestException("Digest algorithm is not valid", exception);
        }
    }

    public String generateDigestForFile(String file) throws DigestException {
        // Validates if the file exists
        Path filePath = Paths.get(file);
        if (!Files.exists(filePath) || Files.isDirectory(filePath)) {
            throw new DigestException("File not found");
        }

        try {
            byte[] contents = Files.readAllBytes(filePath);
            byte[] digest = generateDigest(contents);
            return convertFromByteArray(digest);
        } catch (IOException exception) {
            throw new DigestException("Error when opening file", exception);
        }
    }

    public String convertFromByteArray(byte[] contents) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : contents) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
