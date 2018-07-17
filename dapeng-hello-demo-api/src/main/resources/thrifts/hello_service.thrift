namespace java com.dapeng.example.hello.service

include "hello_domain.thrift"

/**
* HelloTodayService
**/
service HelloService {

/**
# sayHello
## 业务描述
    sayHello
## 接口依赖
    无cle
## 边界异常说明
    无
## 输入
    hello
## 前置检查
    无
## 权限检查
    无
## 逻辑处理
    sayHello
## 数据库变更
    无
## 事务处理
    无
## 输出
    string
## 事件
    无
*/
    string sayHello(1:string name),
/**
# sayHello
## 业务描述
    sayHello
## 接口依赖
    无
## 边界异常说明
    无
## 输入
    hello
## 前置检查
    无
## 权限检查
    无
## 逻辑处理
    sayHello
## 数据库变更
    无
## 事务处理
    无
## 输出
    string
## 事件
    无
*/
    string sayHello2(1:hello_domain.Hello hello)

}(group="hello")
/**
* AccountService
*/
service AccountService {

    /**
    # queryAccount
    ## 业务描述
        账户信息查询
    ## 接口依赖
        无
    ## 边界异常说明
        无
    ## 输入
        uids
    ## 前置检查
        无
    ## 权限检查
        无
    ## 逻辑处理
        queryAccount
    ## 数据库变更
        无
    ## 事务处理
        无
    ## 输出
        list<LongRetResult>
    ## 事件
        无
    */
    list<hello_domain.LongRetResult> queryAccount(1:list<i64> uids);

    /**
    # verifyAccount
    ## 业务描述
       验证用户帐户的合法性
    ## 接口依赖
        无
    ## 边界异常说明
        无
    ## 输入
        uid
    ## 前置检查
        无
    ## 权限检查
        无
    ## 逻辑处理
        verifyAccount
    ## 数据库变更
        无
    ## 事务处理
        无
    ## 输出
        RetCode
    ## 事件
        无
    */
    hello_domain.RetCode verifyAccount(1:i64 uid);

 /**
    * queryReceiptResult
     ## 业务描述
            划扣结果查询
        ## 接口依赖
            无
        ## 边界异常说明
            无
        ## 输入
            bidId
            periodDate
            uid
        ## 前置检查
            无
        ## 权限检查
            无
        ## 逻辑处理
            queryReceiptResult
        ## 数据库变更
            无
        ## 事务处理
            无
        ## 输出
            LongRetResult
        ## 事件
            无
        */
    hello_domain.LongRetResult queryReceiptResult(1:i64 bidId , 2:i64 periodDate, 3:i64 uid);

    /*
    * cardReceiptProc
        ## 业务描述
            划扣处理
        ## 接口依赖
            无
        ## 边界异常说明
            无
        ## 输入
            batchId
        ## 前置检查
            无
        ## 权限检查
            无
        ## 逻辑处理
            cardReceiptProc
        ## 数据库变更
            无
        ## 事务处理
            无
        ## 输出
            BoolRetResult
        ## 事件
            无
        */
    hello_domain.BoolRetResult cardReceiptProc(1:string batchId);


    /**
        # queryAccount
        ## 业务描述
            账户信息查询
        ## 接口依赖
            无
        ## 边界异常说明
            无
        ## 输入
            uids
        ## 前置检查
            无
        ## 权限检查
            无
        ## 逻辑处理
            queryAccount
        ## 数据库变更
            无
        ## 事务处理
            无
        ## 输出
            list<AccountRetResult>
        ## 事件
            无
        */
        list<hello_domain.AccountRetResult> queryUserAccount(1:list<i64> uids);

}(group="hello")