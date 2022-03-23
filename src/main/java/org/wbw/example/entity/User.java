package org.wbw.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-3-23 12:06
 */
@Data
public class User implements Serializable {
    private String name;
    private Integer age;
    private Integer high;
}
