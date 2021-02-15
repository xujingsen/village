package com.xjb_villager.lifei.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultLV<T> implements Serializable {
    private static final long serialVersionUID = -4696008537295855861L;
    private int code;
    private String msg;
    private T data;
}