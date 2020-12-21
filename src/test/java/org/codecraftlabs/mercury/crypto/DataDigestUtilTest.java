package org.codecraftlabs.mercury.crypto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.codecraftlabs.mercury.crypto.DigestAlgorithm.MD5;
import static org.codecraftlabs.mercury.crypto.DigestAlgorithm.SHA1;
import static org.codecraftlabs.mercury.crypto.DigestAlgorithm.SHA256;
import static org.codecraftlabs.mercury.crypto.DigestAlgorithm.SHA384;
import static org.codecraftlabs.mercury.crypto.DigestAlgorithm.SHA512;
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

    @Test
    void generateDigestSha256() throws DigestException {
        util.setDigestAlgorithm(SHA256);
        String digest = util.generateDigestIntoString(SAMPLE_INPUT);
        assertThat(digest, is("78fe461fd72e68a1c7922b227a462e4b417e58bbccc81c6986d863069d8ae74e"));
    }

    @Test
    void generateDigestSha384() throws DigestException {
        util.setDigestAlgorithm(SHA384);
        String digest = util.generateDigestIntoString(SAMPLE_INPUT);
        assertThat(digest, is("e2b9180ccdde49c053de7cf20d7c0130af5e1f2bdfe7e93ba1cef5746194aeef326189b3ec2c04d2b50a108a50bd0090"));
    }

    @Test
    void generateDigestSha512() throws DigestException {
        util.setDigestAlgorithm(SHA512);
        String digest = util.generateDigestIntoString(SAMPLE_INPUT);
        assertThat(digest, is("879281e1bcc1082c51bb925b37c7dbd8cd427bb980dba905bb3d42717202ec574e03120495aef6ba746b338b17c0ec09e7168dfdd55f1084aa0fa23f71672ffe"));
    }
}
