package cn.beatree.paillier;

import cn.beatree.paillier.core.Paillier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

@SpringBootTest
class PaillierApplicationTests {
    @Autowired
    Paillier paillier;

    @Test
    void contextLoads() {
    }

    @Test
    void testPaillier(){
        paillier.init();
        BigInteger encryption1 = paillier.encryption(new BigInteger("1"));
        BigInteger encryption2 = paillier.encryption(new BigInteger("2"));

        BigInteger bigInteger = paillier.cipherAdd(encryption1, encryption2);
        System.out.println("密文运算 1+2 = " + paillier.decryption(bigInteger));

    }

    @Test
    void getN_square(){
        paillier.encryption(new BigInteger("1"));
    }
}
