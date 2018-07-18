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
package com.dapeng.example.config

import org.mybatis.scala.session.{Session, SessionManager}

/**
 * This trait provides the feature of using databases in test cases.
 */
trait DatabaseSupport {
  /**
   * Executes a callback function provided by a argument of this function within a read-only database transaction.
   * @param block the callback function to be executed within a database transaction.
   */
  def withReadOnly(db: SessionManager)(block: Session => Unit): Unit = {
    db.readOnly { implicit session =>
      DatabaseSchema.prepare
      block(session)
    }
  }
  /**
    * Executes a callback function provided by a argument of this function within a managed database transaction.
    * @param block the callback function to be executed within a database transaction.
    */
  def withManager(db: SessionManager)(block: Session => Unit): Unit = {
    db.managed{ implicit session =>
      DatabaseSchema.prepare
      block(session)
    }
  }
  /**
    * Executes a callback function provided by a argument of this function within a transaction database transaction.
    * @param block the callback function to be executed within a database transaction.
    */
  def withTransaction(db: SessionManager)(block: Session => Unit): Unit = {
    db.transaction{ implicit session =>
      DatabaseSchema.prepare
      block(session)
    }
  }
}
