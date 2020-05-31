package com.action.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Liuran1991
 * @date 2020/5/29
 */
@Setter
@Getter
public class ServerData {

    private String id = UUID.randomUUID().toString().replaceAll("-", "");

    private String data;

    private int status;

    private List<String> list;

}
