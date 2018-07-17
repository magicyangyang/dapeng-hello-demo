 package com.github.dapeng.soa.scala.entity 
 import java.sql.Timestamp 
 import wangzx.scala_commons.sql.ResultSetMapper 

  case class GlobalTransaction ( 
 /**  */ 
id: Int,
 /** 状态，1：新建；2：成功；3：失败；4：已回滚；5：已部分回滚；99：挂起； */ 
status: Int,
 /** 当前过程序列号 */ 
currSequence: Int,
 /**  */ 
createdAt: Timestamp,
 /**  */ 
updatedAt: Timestamp,
 /**  */ 
createdBy: Option[Int],
 /**  */ 
updatedBy: Option[Int],
) 	
 	
 object GlobalTransaction { 
 	implicit val resultSetMapper: ResultSetMapper[GlobalTransaction] = ResultSetMapper.material[GlobalTransaction] 
 }
