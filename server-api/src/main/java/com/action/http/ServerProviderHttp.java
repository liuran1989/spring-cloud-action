package com.action.http;

import com.action.utils.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Liuran1991
 * @date 2020/5/28
 */
@FeignClient(name = "server-provider",
        path = "/server/data",
        fallback = ServerProviderFallBack.class
)
public interface ServerProviderHttp {

    @GetMapping(value = "/{id}")
    ApiResult getList(@PathVariable Integer id);

    @PostMapping("/get")
    ApiResult get(@RequestParam Integer id);

    @RequestMapping("/select")
    ApiResult select(@RequestParam String name, @RequestParam Integer value);

    @PostMapping("/save")
    ApiResult save(@RequestBody Object json);

    @RequestMapping("/wait")
    ApiResult wait(@RequestParam String waitTime);
}
