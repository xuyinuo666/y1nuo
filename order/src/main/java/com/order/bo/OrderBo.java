package com.order.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderBo  implements Serializable {

    private static final long serialVersionUID = 1L;
    private AddressBo addressBo;

    private List<ProductBo> productBoList;

    private String uniqueId;
}
