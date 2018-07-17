/**
 *    Copyright 2011-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.dapeng.example.mapping

import org.mybatis.scala.config.ConfigurationException
import org.mybatis.scala.mapping.{Statement, XSQL}

import scala.util.control.NonFatal
import org.scalatest._
import org.mybatis.scala.mapping.FQI
/**
 * The specification for [[org.mybatis.scala.mapping.Statement]].
 */
class StatementSpec extends FunSpec with Matchers {
  val simpleStatement = new Statement {
    def parameterTypeClass: Class[_] = classOf[Unit]

    def xsql: XSQL = <xsql>SELECT 1</xsql>
  }

  describe("A Statement") {
    it("should throw an exception if FQI isn't set") {
      intercept[ConfigurationException] {
        simpleStatement.execute {
          fail("should not come here")
        }
      }
    }

//    it("should not throw any exception if FQI is set") {
//      try {
//        simpleStatement.fqi = new FQI("databases", "local")
//        simpleStatement.execute {}
//      } catch {
//        case NonFatal(e) => fail(e.getMessage)
//      }
//    }
    it("should return XSQL") {
      simpleStatement.xsql should equal (<xsql>SELECT 1</xsql>)
    }
  }
}
