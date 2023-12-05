package com.my.app.controller;


import com.my.app.vo.TestInput;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
public class TestController {
    @PostMapping("/test1")
    String test1(@RequestBody @Valid TestInput input) {
        return "success";
    }
}
