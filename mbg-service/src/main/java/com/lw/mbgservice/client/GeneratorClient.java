package com.lw.mbgservice.client;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GeneratorClient
 * @Description 代码生成客户端
 * @Date 2019/12/12 9:03
 * @Author lw
 */
public class GeneratorClient {

    /**
     * 代码生成：
     *  1.将pom.xml中，自定义注释mbg-comment依赖放开
     *  2.generatorConfig.xml文中，targetProject属性加上项目名称，使用targetProject="mbg-service/src/main/java"
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;

        try{
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(is);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }catch (Exception e){
            e.printStackTrace();
        }

        warnings.forEach(warning -> {
            System.out.println("=== " + warning);
        });
    }

}
