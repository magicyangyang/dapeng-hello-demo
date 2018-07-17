package com.dapeng.example.service

import com.dapeng.example.hello.scala.domain.{AccountRetResult, BoolRetResult, LongRetResult, RetCode}
import com.github.dapeng.soa.scala.entity.UserAccount
import wangzx.scala_commons.sql._


class AccountServiceImpl extends com.dapeng.example.hello.scala.service.AccountService {
  /**
    *
    **
    * # queryAccount
    * ## 业务描述
    * 账户信息查询
    * ## 接口依赖
    * 无
    * ## 边界异常说明
    * 无
    * ## 输入
    * uids
    * ## 前置检查
    * 无
    * ## 权限检查
    * 无
    * ## 逻辑处理
    * queryAccount
    * ## 数据库变更
    * 无
    * ## 事务处理
    * 无
    * ## 输出
    * list<LongRetResult>
    * ## 事件
    * 无
    *
    **/
  override def queryAccount(uids: List[Long]): List[LongRetResult] ={
//    val myArray : List[LongRetResult] = List();
//    for(i <- 0 until uids.length){
//      myArray(i) = LongRetResult(RetCode.SUCCESS,i)
//    }
    val xx = LongRetResult(RetCode.SUCCESS,1)
    val yy = LongRetResult(RetCode.SERVER_ERROR,2)
    val zz = LongRetResult(RetCode.ACCOUNT_NOT_EXIST,3)
    val accounts = List(xx,yy,zz)
    accounts
  }

  /**
    *
    **
    * # verifyAccount
    * ## 业务描述
    * 验证用户帐户的合法性
    * ## 接口依赖
    * 无
    * ## 边界异常说明
    * 无
    * ## 输入
    * uid
    * ## 前置检查
    * 无
    * ## 权限检查
    * 无
    * ## 逻辑处理
    * verifyAccount
    * ## 数据库变更
    * 无
    * ## 事务处理
    * 无
    * ## 输出
    * RetCode
    * ## 事件
    * 无
    *
    **/
  override def verifyAccount(uid: Long): RetCode = {
    if(uid%2==0){
      return RetCode.SERVER_ERROR
    }
    return RetCode.SUCCESS;
  }

  /**
    *
    **
    * queryReceiptResult
    * ## 业务描述
    * 划扣结果查询
    * ## 接口依赖
    * 无
    * ## 边界异常说明
    * 无
    * ## 输入
    * bidId
    * periodDate
    * uid
    * ## 前置检查
    * 无
    * ## 权限检查
    * 无
    * ## 逻辑处理
    * queryReceiptResult
    * ## 数据库变更
    * 无
    * ## 事务处理
    * 无
    * ## 输出
    * LongRetResult
    * ## 事件
    * 无
    *
    **/
  override def queryReceiptResult(bidId: Long, periodDate: Long, uid: Long): LongRetResult = {
    if(uid%2==0){
      return LongRetResult(RetCode.SERVER_ERROR,uid)
    }
    if(uid%3==0){
      return LongRetResult(RetCode.ACCOUNT_ALREADY_EXIST,bidId)
    }
    return LongRetResult(RetCode.SUCCESS,1L);
  }

  def findCardReceiptProc(batchId: String): BoolRetResult = {
    if(null==batchId||batchId.isEmpty){
      BoolRetResult(RetCode.SERVER_ERROR,false);
    }
    return BoolRetResult(RetCode.SUCCESS,true);
  }

  /**
    *
    **/
  override def cardReceiptProc(batchId: String): BoolRetResult = findCardReceiptProc(batchId)

  /**
    *
    **
    * # queryAccount
    * ## 业务描述
    * 账户信息查询
    * ## 接口依赖
    * 无
    * ## 边界异常说明
    * 无
    * ## 输入
    * uids
    * ## 前置检查
    * 无
    * ## 权限检查
    * 无
    * ## 逻辑处理
    * queryAccount
    * ## 数据库变更
    * 无
    * ## 事务处理
    * 无
    * ## 输出
    * list<AccountRetResult>
    * ## 事件
    * 无
    *
    **/
  override def queryUserAccount(uids: List[Long]): List[AccountRetResult] = {
    val users = BizDataSource.dataSource.rows[UserAccount](sql"""select * from user_account""")
    users.map(x =>transForResult(x))
  }

  def  transForResult(x:UserAccount): AccountRetResult ={
       BeanBuilder.build[AccountRetResult](x:UserAccount)(
 "retCode"->RetCode.SUCCESS,
      "id"->x.id,
      "uid"->x.uid,
      "balanceAmount"->operationLong(x.balanceAmount),
      "currentAmount"->operationLong(x.currentAmount),
      "accountType"->operationInt(x.accountType),
      "version"->x.version,
      "accountInfo"->operationString(x.accountInfo),
      "createTime"->operationTime(x.createTime),
      "updateTime"->operationTime(x.updateTime)
       )
  }
  def operationLong(s:Option[Long]):Long={
    s.isDefined
    if(null==s){
      0L
    }else{
      s.get
    }
  }
  def operationInt(s:Option[Int]):Int={
    if(null==s){
      0
    }else{
      s.get
    }
  }
  def operationString(s:Option[String]):String={
    if(null==s){
      ""
    }else{
      s.get
    }
  }
  def operationTime(s:Option[java.sql.Timestamp]):String={
    if(null==s){
      ""
    }else{
      s.get.toString
    }
  }




}
