namespace java com.dapeng.example.hello.domain

/**
* hello
**/
struct Hello {
/**
* name
**/
    1: string name,

/**
* message
**/
    2: optional string message

}
/**
*返回结果
*/
enum RetCode {
     /**
     *SUCCESS
     */
     SUCCESS  = 0,
     /**
     *ACCOUNT_ALREADY_EXIST
     */
     ACCOUNT_ALREADY_EXIST = 1,
     /**
     *ACCOUNT_NOT_EXIST
     */
     ACCOUNT_NOT_EXIST = 2,
     /**
     *ACCOUNT_BAN
     */
     ACCOUNT_BAN = 3,
     /**
     *ACCOUNT_INSUFFICIENT_BALANCE
     */
     ACCOUNT_INSUFFICIENT_BALANCE = 4,
     /**
     *WITHDRAW_CARD_INVALID
     */
     WITHDRAW_CARD_INVALID = 5,
     /**
     *WITHDRAW_PASSWORD_INVALID
     */
     WITHDRAW_PASSWORD_INVALID = 6,
     /**
     *WITHDRAW_RECORD_INVALID
     */
     WITHDRAW_RECORD_INVALID = 7,
     /**
     *WITHDRAW_PASSWORD_CHANGE_INVALIDOLD
     */
     WITHDRAW_PASSWORD_CHANGE_INVALIDOLD = 8,
     /**
     *WITHDRAW_AMOUNT_INVALID
     */
     WITHDRAW_AMOUNT_INVALID = 9,
     /**
     *SERVER_PROC
     */
     SERVER_PROC = 98,
     /**
     *SERVER_ERROR
     */
     SERVER_ERROR = 99
}
/*
*系统调用结果说明--帐户锁定记录
*/
struct LongRetResult {
   1: required RetCode retCode,
   2: required i64 retMsg
}
/*
*系统调用结果说明--帐户锁定结果
*/
struct BoolRetResult {
   1: required RetCode retCode,
   2: required bool retMsg
}
/*
*系统调用结果说明--帐户锁定结果
*/
struct StringRetResult {
   1: required RetCode retCode,
   2: required string retMsg
}
/*
*系统调用结果说明--帐户锁定结果
*/
struct ListRetResult {
   1: required RetCode retCode,
   2: required list<string> retMsg
}
/*
*系统调用结果说明--帐户锁定结果
*/
struct ListLongRetResult {
   1: required RetCode retCode,
   2: required list<i64> retMsg
}
/*
*系统调用结果说明--帐户锁定结果
*/
struct SetRetResult {
   1: required RetCode retCode,
   2: required set<string> retMsg
}
/*
*系统调用结果说明--帐户锁定结果
*/
struct SetLongRetResult {
   1: required RetCode retCode,
   2: required set<i64> retMsg
}
/*
*系统调用结果说明--帐户锁定结果
*/
struct MapRetResult {
   1: required RetCode retCode,
   2: required map<string,string> retMsg
}
/*
*系统调用结果说明--帐户锁定结果
*/
struct MapLongRetResult {
   1: required RetCode retCode,
   2: required map<string,i64> retMsg
}
/*
*系统调用结果说明--帐户锁定记录
*/
struct AccountRetResult {
   1: required RetCode retCode,
   2: required i64 id,
   3: required i64 uid,
   4: required i64 balanceAmount,
   5: required i64 currentAmount,
   6: required i32 accountType,
   7: required string accountInfo,
   8: required string createTime,
   9: required string updateTime,
   10: required i32 version
}
