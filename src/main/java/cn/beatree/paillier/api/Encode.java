package cn.beatree.paillier.api;

import cn.beatree.paillier.core.Paillier;
import cn.beatree.paillier.entity.Numbers;
import cn.beatree.paillier.entity.ReturnObject;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/encode")
public class Encode {

    @Autowired
    private Paillier paillier;

    /*
    * 用于加密单个数字，通过路径传参
    * */
    @PostMapping("/single/{number}")
    public ReturnObject single(@PathVariable("number") BigInteger number){
        ReturnObject returnObject = new ReturnObject();
        paillier.init();

        BigInteger encryption = paillier.encryption(number);
        log.info(LocalDateTime.now().toString() + "单个数字加密成功");

        returnObject.setStatus(1);
        returnObject.setMessage("加密成功");
        returnObject.setData(encryption);

        return returnObject;
    }

    /*
    * 用于加密数组，使用请求体传参
    * */
    @PostMapping("/array")
    public ReturnObject array(@RequestBody Numbers toEncode){
        ReturnObject returnObject = new ReturnObject();
        paillier.init();

        // 获取长度，定义存放加密数据的数组
        int arrLength = toEncode.getNumbers().length;
        BigInteger[] encryption = new BigInteger[arrLength];

        for(int i = 0; i < arrLength; i++){
            // 循环进行加密
            encryption[i] = paillier.encryption(toEncode.getNumbers()[i]);
        }

        log.info(LocalDateTime.now().toString() + "数字数组加密成功");

        returnObject.setStatus(1);
        returnObject.setMessage("加密成功");
        returnObject.setData(encryption);

        return returnObject;
    }
}
