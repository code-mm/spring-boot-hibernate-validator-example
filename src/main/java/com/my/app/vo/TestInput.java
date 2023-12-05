package com.my.app.vo;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TestInput {
    @AssertFalse(message = "age值错误")
    private Boolean age;
    @NotBlank(message = "name 错误")
    private String name;
}