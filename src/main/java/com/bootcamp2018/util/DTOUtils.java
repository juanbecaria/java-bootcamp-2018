package com.bootcamp2018.util;

import com.bootcamp2018.dto.*;
import com.bootcamp2018.model.*;
public final class DTOUtils {

    public static ItemDTO toItemDTO (Item item ){
        ItemDTO itemDTO = new ItemDTO(item.getId(),item.getName(),item.getPrice());
        return itemDTO;
    }
}
