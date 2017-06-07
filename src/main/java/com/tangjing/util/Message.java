package com.tangjing.util;


import org.apache.commons.collections.map.HashedMap;
import org.springframework.ui.Model;

import java.util.Map;

/**
 * Created by tangjing on 2017/3/7.
 */
public enum Message {

    /**
     * 登陆相关
     */
    USER_NOT_EXIST("1", false, "用户不存在"),
    PASSWORD_ERROR("2", false, "密码错误"),
    lOGIN_ERROR("3", false, "用户名密码错误"),
    UNlOGIN_ERROR("4", false, "请登录"),
    VERIFCODE_ERROR("5", false, "验证码错误"),
    VERIFCODE_NULL("6", false, "验证码不能为空"),
    /**
     * 新增
     */
    ADD_SUCCESS("7", true, "数据新增成功"),
    ADD_FAILURE("8", false, "数据新增失败"),
    /**
     * 修改
     */
    UPDATE_SUCCESS("9", true, "数据修改成功"),
    UPDATE_FAILURE("10", false, "数据修改失败"),
    /**
     * 删除
     */
    DELETE_SUCCESS("11", true, "数据删除成功"),
    DELETE_FAILURE("12", false, "数据删除失败"),

    /**
     * 服务器异常
     */
    SERVER_ERROR("9999", false, "服务器异常");

    private String  code;
    private Boolean success;
    private String  msg;

    Message() {

    }

    Message(String code, Boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public static void getMessage(Model model, String code) {
        for (Message message : Message.values()) {
            if (code.equals(message.name())) {
                model.addAttribute("message", new MessagePojo(message.getSuccess(), message.getMsg()));
            }
        }
    }

    /**
     * @param MessageName 信息特征名
     * @param coustomText 添加自定义信息
     * @return
     */
    public static Map<String, Object> getMessage(String MessageName, String coustomText) {
        Map<String, Object> map = new HashedMap();
        for (Message message : Message.values()) {
            if (MessageName.equals(message.name())) {
                map.put("code", message.getCode());
                map.put("success", message.getSuccess());
                map.put("msg", coustomText == "" ? message.getMsg() : message.getMsg() + "," + coustomText);
            }
        }
        return map;
    }


    public static MessagePojo getMessage(String code) {
        MessagePojo messagePojo = new MessagePojo();
        for (Message message : Message.values()) {
            if (code.equals(message.name())) {
                messagePojo = new MessagePojo(message.getSuccess(), message.getMsg());
                break;
            }
        }
        return messagePojo;
    }

}

class MessagePojo {

    private Boolean success;
    private String  note;


    public MessagePojo() {
    }

    public MessagePojo(Boolean success, String msg) {
        this.success = success;
        this.note = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean succsee) {
        this.success = succsee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}