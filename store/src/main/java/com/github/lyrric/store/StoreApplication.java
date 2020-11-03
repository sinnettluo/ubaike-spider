package com.github.lyrric.store;

import com.github.lyrric.store.core.Store;
import com.github.lyrric.store.entity.CompanyInfo;
import com.github.lyrric.store.util.JdbcUtil;
import com.github.lyrric.store.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created on 2020-11-02.
 *
 * @author wangxiaodong
 */
@Slf4j
public class StoreApplication {


    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = JdbcUtil.class.getResourceAsStream("/application.properties");){
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("读取application.properties文件时发生错误", e);
            throw e;
        }
        new Store(properties).start();
    }


}

