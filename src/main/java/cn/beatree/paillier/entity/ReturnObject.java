package cn.beatree.paillier.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;

@Getter
public class ReturnObject<T> extends JSONObject {

    /*返回值：0 1 2*/
    private int status;
    private String message;     // 携带信息
    private T data;             // 主题数据

    public ReturnObject(){
        this.setStatus(0);
        this.setMessage("初始信息");
        this.setData(null);
    }

    public ReturnObject(int status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
        this.put("status", status);
        this.put("message", message);
        this.put("data", data);
    }

    public void setStatus(int status) {
        this.status = status;
        this.put("status", status);
    }

    public void setMessage(String message) {
        this.message = message;
        this.put("message", message);
    }

    public void setData(T data) {
        this.data = data;
        this.put("data", data);
    }
}
