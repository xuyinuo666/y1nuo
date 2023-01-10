package com.order.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressBo implements Serializable{
    private String province;

    private String city;

    private String address;
}
