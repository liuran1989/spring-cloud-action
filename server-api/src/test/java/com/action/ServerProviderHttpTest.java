package com.action;

import com.action.http.ServerProviderHttp;
import com.action.utils.ApiResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by Liuran1991 on 2020/5/29.
 */
@SpringBootTest
public class ServerProviderHttpTest {

    @Autowired
    private ServerProviderHttp serverProviderHttp;

    @Test
    public void getListTest() {
        ApiResult apiResult = serverProviderHttp.getList(1);
        System.out.println(apiResult);
    }

    @Test
    public void getTest() {
        ApiResult apiResult = serverProviderHttp.get(1);
        System.out.println(apiResult);
    }

    @Test
    public void selectTest() {
        ApiResult apiResult = serverProviderHttp.select("2", 1);
        System.out.println(apiResult);
    }

    @Test
    public void waitTest() {
        ApiResult apiResult = serverProviderHttp.wait("1000");
        System.out.println(apiResult);
    }

}
