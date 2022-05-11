package hello.typeconverter.controller;


import hello.typeconverter.type.IpPort;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data");
        Integer intValue = Integer.valueOf(data);
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/hello-v3")
    public String helloV3(@ModelAttribute UserData data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/hello-v4")
    public String helloV4(@ModelAttribute IpPort ipPort) {
        System.out.println("ipPort = " + ipPort);
        return "ok";
    }

    @Data
    static class UserData {
        Integer data;
    }

    @GetMapping("/hello-v4/{data}")
    public String helloV4(@PathVariable Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }
}
