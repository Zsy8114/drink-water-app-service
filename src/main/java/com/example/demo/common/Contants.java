package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Contants {


    @Getter
    @AllArgsConstructor
    public enum ActiveEnum {
        NOT_DELETE("0", "标识未删除"),
        DELETE("1", "标识已删除");
        private String value;
        private String describe;
    }

    @Getter
    @AllArgsConstructor
    public enum statusEnum {
        ABLE("0", "启动"),
        DISABLE("1", "禁用");
        private String value;
        private String describe;
    }
    @Getter
    @AllArgsConstructor
    public enum collectionEnum {
        YES("0", "收藏"),
        NO("1", "取消");
        private String value;
        private String describe;
    }
    @Getter
    @AllArgsConstructor
    public enum shoppingCarEnum {
        YES("0", "加入"),
        NO("1", "取消");
        private String value;
        private String describe;
    }
}
