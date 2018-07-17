 package com.github.dapeng.soa.scala.entity 
 import java.sql.Timestamp 
 import wangzx.scala_commons.sql.ResultSetMapper 

  case class GlobalTransactionProces ( 
 /**  */ 
id: Int,
 /**  */ 
transactionId: Int,
 /** 过程所属序列号 */ 
transactionSequence: Int,
 /** 过程当前状态，1：新建；2：成功；3：失败；4：未知，5：已回滚； */ 
status: Int,
 /** 过程目标状态，1：成功；2：已回滚； */ 
expectedStatus: Int,
 /** 服务名称 */ 
serviceName: String,
 /** 服务版本 */ 
versionName: String,
 /** 方法名称 */ 
methodName: String,
 /** 回滚方法名称 */ 
rollbackMethodName: String,
 /** 过程请求参数Json序列化 */ 
requestJson: String,
 /** 过程响应参数Json序列化 */ 
responseJson: String,
 /** 重试次数 */ 
redoTimes: Option[Int],
 /** 下次重试时间 */ 
nextRedoTime: Option[Timestamp],
 /**  */ 
createdAt: Timestamp,
 /**  */ 
updatedAt: Timestamp,
 /**  */ 
createdBy: Option[Int],
 /**  */ 
updatedBy: Option[Int],
) 	
 	
 object GlobalTransactionProces { 
 	implicit val resultSetMapper: ResultSetMapper[GlobalTransactionProces] = ResultSetMapper.material[GlobalTransactionProces] 
 }
