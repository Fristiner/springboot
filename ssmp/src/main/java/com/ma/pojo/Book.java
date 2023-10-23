package com.ma.pojo;

import lombok.Data;

/* *
 * @packing com.ma.domain
 * @author mtc
 * @date 15:07 10 21 15:07
 *
 */

@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
