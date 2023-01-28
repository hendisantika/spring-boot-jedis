package com.hendisantika.springbootjedis.controller;

import com.hendisantika.springbootjedis.service.PincodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jedis
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/28/23
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/redis/pincode")
@RequiredArgsConstructor
public class RedisController {
    private final PincodeService pincodeService;

}
