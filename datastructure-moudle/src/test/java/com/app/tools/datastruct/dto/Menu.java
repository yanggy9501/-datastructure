package com.app.tools.datastruct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yanggy
 */
@Data
@AllArgsConstructor
public class Menu {
    private int parentId;
    private int id;
    private String menuName;
}
