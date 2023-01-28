package com.hendisantika.springbootjedis.controller;

import com.hendisantika.springbootjedis.model.Pincode;
import com.hendisantika.springbootjedis.service.PincodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @PostMapping
    public String saveNewPincode(@RequestBody Pincode pincode) {
        pincodeService.save(pincode);
        return "Successfully added : " + pincode.pincodeVal() + " pincode";
    }

    @Cacheable(key = "#id", value = "picondes", unless = "#result.id < 1200")
    @GetMapping(path = "/{id}")
    public Pincode fetchStudent(@PathVariable("id") long id) {
        return pincodeService.find(id);
    }

    @CacheEvict(key = "#id", value = "picondes")
    @DeleteMapping(path = "/{id}")
    public String deleteOldPincode(@PathVariable("id") long id) {
        pincodeService.delete(id);
        return "Successfully removed #pincode with id : " + id;
    }

    @Cacheable(key = "#id", value = "students", unless = "#result.id < 1200")
    @GetMapping
    public Map<Long, Pincode> fetchAllPincodes() {
        return pincodeService.findAllPincodes();
    }

//    @CachePut - Update a Cache. Use it with PutMapping
	/*@CachePut(key="#id",cacheNames="pincode")
	@PutMapping(path = "{id}")
	public String updateOldPincode(@PathVariable("id") long id,@RequestBody Pincode pincode) {
		pincodeService.update(id,pincode);
		return "Successfully update #pincode with id : " + id;
	}*/
}
