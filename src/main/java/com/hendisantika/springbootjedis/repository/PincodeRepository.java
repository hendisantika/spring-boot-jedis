package com.hendisantika.springbootjedis.repository;

import com.hendisantika.springbootjedis.model.Pincode;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jedis
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/28/23
 * Time: 20:44
 * To change this template use File | Settings | File Templates.
 */
public interface PincodeRepository {
    void save(Pincode pincode);

    Pincode find(Long id);
}
