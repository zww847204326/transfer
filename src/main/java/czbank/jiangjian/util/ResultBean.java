package czbank.jiangjian.util;

import lombok.Data;

import java.io.Serializable;


@Data
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = -6170260707118223381L;

    public static final int SUCCESS = 0;

    private String msg = "SUCCESS";

    private int code = SUCCESS;

    private T data;

    public ResultBean() {

    }


    public ResultBean(T data) {
        this.data = data;
    }

    public ResultBean(String msg , int code) {
        this.msg = msg;
        this.code = code;
    }

    public ResultBean(Throwable e , int code) {
        this.msg = e.getMessage();
        this.code = code;
    }


}