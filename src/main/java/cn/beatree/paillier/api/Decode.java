package cn.beatree.paillier.api;

import cn.beatree.paillier.core.Paillier;
import cn.beatree.paillier.entity.Numbers;
import cn.beatree.paillier.entity.ReturnObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/decode")
public class Decode {

    @Autowired
    private Paillier paillier;

    @PostMapping("/single/{number}")
    public ReturnObject single(@PathVariable("number")BigInteger number){
        ReturnObject returnObject = new ReturnObject();
        paillier.init();

        BigInteger decryption = paillier.decryption(number);
        log.info(LocalDateTime.now().toString() + "单个数字解密完成");

        returnObject.setStatus(1);
        returnObject.setMessage("解密完成");
        returnObject.setData(decryption);

        return returnObject;
    }

    @PostMapping("/array")
    public ReturnObject array(@RequestBody Numbers numbers){
        ReturnObject returnObject = new ReturnObject();
        paillier.init();

        int length = numbers.getNumbers().length;
        BigInteger[] decryption = new BigInteger[length];

        for(int i = 0; i < length; i++){
            decryption[i] = paillier.decryption(numbers.getNumbers()[i]);
        }
        log.info(LocalDateTime.now().toString() + "数字数组解密完成");

        returnObject.setStatus(1);
        returnObject.setMessage("解密完成");
        returnObject.setData(decryption);

        return returnObject;
    }
}
