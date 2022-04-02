package com.wbw.demo.controller;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-3-30 10:44
 */
@Slf4j
@RestController
public class SessionController {
    @GetMapping("/putsession.html")
    public String putSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info(String.valueOf(session.getClass()));
        log.info(session.getId());
        String name = "wangxiaohu";
        session.setAttribute("user", name);
        return "hey," + name;
    }

}
