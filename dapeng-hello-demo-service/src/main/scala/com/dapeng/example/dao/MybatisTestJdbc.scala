package com.dapeng.example.dao

import com.dapeng.example.entity.User
import org.mybatis.scala.config.Configuration
import org.mybatis.scala.mapping.{Insert, JdbcGeneratedKey, ResultMap, SelectOneBy}

class MybatisTestJdbc {

  val config = Configuration("mybatis.xml")
  config.addSpace("mynamespace") { space =>
//    space += findPeople                            // Adds mapped statement findPeople
//    space ++= PersonDAO 、                            // Adds all mapped statements declared in PersonDAO
//    space ++= Seq(deletePerson, updatePerson, ...)  // Adds all specified statements
  }
  val personResultMap = new ResultMap[Person] {
    id ( property="id", column="pid" )
    result ( property="name" column="full_name" )
  }

  val findUserById = new SelectOneBy[Int,User] {
    def xsql = <xsql>SELECT * from user WHERE id = {"id"?}</xsql>
  }

  // this is also valid
  val findUserById = new SelectOneBy[Int,User] {
    def xsql =
      <xsql>
        SELECT *
        FROM user
        WHERE id = {"id"?}
      </xsql>
  }
  val insertNewUser = new Insert[User] {
    keyGenerator = JdbcGeneratedKey(null, "id")
    def xsql =
      <xsql>
        INSERT INTO user(name, username, password)
        VALUES ({"name"?}, {"username"?}, {"password"?})
      </xsql>
  }
}
