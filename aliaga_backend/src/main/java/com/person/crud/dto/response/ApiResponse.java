package com.person.crud.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private Boolean status;
    private String msg;
    private Object data;

}
