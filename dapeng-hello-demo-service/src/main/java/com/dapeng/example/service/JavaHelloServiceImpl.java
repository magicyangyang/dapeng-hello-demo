package com.dapeng.example.service;


import com.dapeng.example.hello.domain.Hello;
import com.github.dapeng.core.SoaException;

public class JavaHelloServiceImpl  implements com.dapeng.example.hello.service.HelloService {




    /**
     *
     **
     * # sayHello
     * ## 业务描述
     * sayHello
     * ## 接口依赖
     * 无
     * ## 边界异常说明
     * 无
     * ## 输入
     * hello
     * ## 前置检查
     * 无
     * ## 权限检查
     * 无
     * ## 逻辑处理
     * sayHello
     * ## 数据库变更
     * 无
     * ## 事务处理
     * 无
     * ## 输出
     * string
     * ## 事件
     * 无
     *
     **/
    @Override
    public String sayHello(String name) throws SoaException {
        return name;
    }
    /**
     *
     **
     * # sayHello
     * ## 业务描述
     * sayHello
     * ## 接口依赖
     * 无
     * ## 边界异常说明
     * 无
     * ## 输入
     * hello
     * ## 前置检查
     * 无
     * ## 权限检查
     * 无
     * ## 逻辑处理
     * sayHello
     * ## 数据库变更
     * 无
     * ## 事务处理
     * 无
     * ## 输出
     * string
     * ## 事件
     * 无
     *
     **/
    @Override
    public String sayHello2(Hello hello) throws SoaException {
        return hello.toString();
    }

}
