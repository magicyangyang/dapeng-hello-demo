//package com.dapeng.example.dao
//
//import com.dapeng.example.hello.scala.domain.{AccountRetResult, RetCode}
//import com.dapeng.example.service.BizDataSource
//import com.github.dapeng.soa.scala.entity.UserAccount
//import wangzx.scala_commons.sql.BeanBuilder
//
//class IAccountDao {
//    val SQL = "SELECT  id, uid, createTime, access_token, ip, city FROM $access_token"
//    val COLUMN_LIST = " id, uid, createTime, access_token, ip, city"
//    @DAO(catalog = "android") trait AccessTokenDAO {
//    @SQL("SELECT  id, uid, createTime, access_token, ip, city FROM $access_token " + "WHERE uid = :1 AND date_add(createTime,interval :2 day) >=now() ORDER BY ID DESC LIMIT 1") def get(@ShardBy uid: Long, day: Int): Nothing
//
//    @SQL("SELECT  id, uid, createTime, access_token, ip, city FROM $access_token WHERE uid = :1") def getList(@ShardBy uid: Long): util.List[Nothing]
//
//    @ReturnGeneratedKeys
//    @SQL("INSERT INTO user_account (" + "id" + "#if(:1.uid!=null){,uid}" + "#if(:1.createtime!=null){,createTime}" + "#if(:1.accessToken!=null){,access_token}" + "#if(:1.ip!=null){,ip}" + "#if(:1.city!=null){,city}" + ") VALUES(" + ":1.id" + "#if(:1.uid!=null){,:1.uid}" + "#if(:1.createtime!=null){,:1.createtime}" + "#if(:1.accessToken!=null){,:1.accessToken}" + "#if(:1.ip!=null){,:1.ip}" + "#if(:1.city!=null){,:1.city}" + ")") def save(accesstoken: Nothing, @ShardBy uid: Long): Long
//
//    @SQL("SELECT COUNT(1) FROM $access_token WHERE uid=:1") def count(@ShardBy uid: Long): Int
//      override def queryUserAccount(uids: List[Long]): List[AccountRetResult] = {
//        val users = BizDataSource.dataSource.rows[UserAccount](sql"""select * from user_account""")
//        users.map(x =>transForResult(x))
//      }
//
//      def  transForResult(x:UserAccount): AccountRetResult ={
//        BeanBuilder.build[AccountRetResult](x:UserAccount)(
//          "retCode"->RetCode.SUCCESS,
//          "id"->x.id,
//          "uid"->x.uid,
//          "balanceAmount"->operationLong(x.balanceAmount),
//          "currentAmount"->operationLong(x.currentAmount),
//          "accountType"->operationInt(x.accountType),
//          "version"->x.version,
//          "accountInfo"->operationString(x.accountInfo),
//          "createTime"->operationTime(x.createTime),
//          "updateTime"->operationTime(x.updateTime)
//        )
//      }
//      def operationLong(s:Option[Long]):Long={
//        s.isDefined
//        if(null==s){
//          0L
//        }else{
//          s.get
//        }
//      }
//      def operationInt(s:Option[Int]):Int={
//        if(null==s){
//          0
//        }else{
//          s.get
//        }
//      }
//      def operationString(s:Option[String]):String={
//        if(null==s){
//          ""
//        }else{
//          s.get
//        }
//      }
//      def operationTime(s:Option[java.sql.Timestamp]):String={
//        if(null==s){
//          ""
//        }else{
//          s.get.toString
//        }
//      }
//}
