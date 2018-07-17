 package com.github.dapeng.soa.scala.enum 
 import wangzx.scala_commons.sql.DbEnum 
 import wangzx.scala_commons.sql._ 
 class TParameterStatus private(val id:Int, val name:String) extends DbEnum { 
 	 override def toString(): String = "(" + id + "," + name + ")"  

 	 override def equals(obj: Any): Boolean = { 
 			 if (obj == null) false 
 			 else if (obj.isInstanceOf[TParameterStatus]) obj.asInstanceOf[TParameterStatus].id == this.id 
 			 else false 
 	 } 

 	 override def hashCode(): Int = this.id 
 } 

 object TParameterStatus { 
	 val INVALID = new TParameterStatus(0,"INVALID") 
	 val VALID = new TParameterStatus(1,"VALID") 
	 def unknown(id: Int) = new TParameterStatus(id, id+"") 
	 def valueOf(id: Int): TParameterStatus = id match { 
 		 case 0 => INVALID 
 		 case 1 => VALID 
 		 case _ => unknown(id) 
 } 
 def apply(v: Int) = valueOf(v) 
 def unapply(v: TParameterStatus): Option[Int] = Some(v.id) 
 implicit object Accessor extends DbEnumJdbcValueAccessor[TParameterStatus](valueOf) 
}
