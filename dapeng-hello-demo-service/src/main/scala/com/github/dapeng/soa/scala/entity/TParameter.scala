 package com.github.dapeng.soa.scala.entity 
 import com.github.dapeng.soa.scala.enum._ 
 import wangzx.scala_commons.sql.ResultSetMapper 

  case class TParameter ( 
 /**  */ 
id: Int,
 /** 系统参数编码 */ 
code: String,
 /** 系统参数值 */ 
value: String,
 /** 状态,0:无效(invalid);1:有效(valid) */ 
status: TParameterStatus,
 /** 备注 */ 
remark: Option[String],
) 	
 	
 object TParameter { 
 	implicit val resultSetMapper: ResultSetMapper[TParameter] = ResultSetMapper.material[TParameter] 
 }
