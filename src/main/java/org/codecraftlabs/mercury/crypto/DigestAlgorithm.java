package org.codecraftlabs.mercury.crypto;

public enum DigestAlgorithm {
    SHA1("SHA-1"),
    SHA256("SHA-256");

    private final String algorithmName;
    DigestAlgorithm(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }
}
