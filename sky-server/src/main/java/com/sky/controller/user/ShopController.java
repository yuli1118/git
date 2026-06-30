package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("userShopController")
@Slf4j
@RequestMapping("/user/shop")
public class ShopController {


        public static final String KEY = "SHOP_STATUS";
        @Autowired
        private RedisTemplate redisTemplate;

        /**
         * 查询状态
         */
        @GetMapping("/get")
        @ApiOperation("查询店铺状态")
        public Result<Integer> get() {

        //模拟从数据库中查询状态
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("查询店铺状态: {}",status == 1 ? "营业中" : "打烊中");
        return Result.success(status);
    }

}
