 package com.github.dapeng.soa.scala.entity 
 import java.sql.Timestamp 
 import wangzx.scala_commons.sql.ResultSetMapper 

  case class UserAccount ( 
 /** 主键id */ 
id: Long,
 /** 用户uid */ 
uid: Long,
 /** 用户余额,单位分 */ 
balanceAmount: Option[Long],
 /** 用户当前总额度,单位分 */ 
currentAmount: Option[Long],
 /** 用户账户类型1为默认财务账户2为划扣账户 */ 
accountType: Option[Int],
 /** 用户账户信息 */ 
accountInfo: Option[String],
 /** 创建时间 */ 
createTime: Option[Timestamp],
 /** 修改时间 */ 
updateTime: Option[Timestamp],
 /** 乐观锁版本号 */ 
version: Int,
) 	
 	
 object UserAccount { 
 	implicit val resultSetMapper: ResultSetMapper[UserAccount] = ResultSetMapper.material[UserAccount] 
 }
