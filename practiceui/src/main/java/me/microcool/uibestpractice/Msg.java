package me.microcool.uibestpractice;

/**
 * Created by gaoshiwei on 2017/9/25.
 */

public class Msg {

    public static final int TYPE_RECEIVED = 0;  //TYPE_RECEIVED 表示这是一条收到的消息
    public static final int TYPE_SENT = 1;  //TYPE_SENT 表示这是一条发出的消息
    private String content; //消息的内容
    private int type;   //消息的类型 两种 发送和接收

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

}
