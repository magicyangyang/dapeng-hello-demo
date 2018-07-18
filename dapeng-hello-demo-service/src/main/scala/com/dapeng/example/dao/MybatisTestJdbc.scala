package com.dapeng.example.dao

import com.dapeng.example.entity.User
import org.mybatis.scala.config.Configuration
import org.mybatis.scala.mapping.{Insert, JdbcGeneratedKey, ResultMap, SelectOneBy}

class MybatisTestJdbc {

  val config = Configuration("mybatis.xml")
  config.addSpace("test") { space =>
  }
}
