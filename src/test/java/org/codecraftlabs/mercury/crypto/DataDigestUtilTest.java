package org.codecraftlabs.mercury.crypto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.codecraftlabs.mercury.crypto.DigestAlgorithm.MD5;
import static org.codecraftlabs.mercury.crypto.DigestAlgorithm.SHA1;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DataDigestUtilTest {
    private static DataDigestUtil util;
    private static final String SAMPLE_INPUT = "sample input";

    @BeforeAll
    static void setupForAll() {
        util = new DataDigestUtil();
    }

    @Test
    void generateDigestMd5() throws DigestException {
        util.setDigestAlgorithm(MD5);
        String digest = util.generateDigestIntoString(SAMPLE_INPUT);
        assertThat(digest, is("ceb268093ddd5aa9df1769eda5d1c8cd"));
    }

    @Test
    void generateDigestSha1() throws DigestException {
        util.setDigestAlgorithm(SHA1);
        String digest = util.generateDigestIntoString(SAMPLE_INPUT);
        assertThat(digest, is("d1da188388b84050e9c75a7755b327fd911c21a0"));
    }
}
