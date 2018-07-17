package com.dapeng.example.service

import com.dapeng.example.hello.scala.domain.Hello

class HelloServiceImpl extends com.dapeng.example.hello.scala.service.HelloService {

  override def sayHello(name: String): String = return name


  override def sayHello2(hello: Hello): String = return hello.toString
}
