package com.dapeng.example.dao;

import com.dapeng.example.entity.UserAccount;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.List;

/**
 *
 * @author tangliu
 * @date 17/7/28
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDAO {


    /**
     * 插入记录，返回id
     *
     * @param
     * @return
     */
    public Integer insert(UserAccount userAccount) {

        final String strSql = "insert into global_transactions(status, curr_sequence, created_at, created_by, updated_by) values(?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.getJdbcTemplate().update(conn -> {
            int i = 0;
            PreparedStatement ps = conn.prepareStatement(strSql);
            ps = conn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
//            ps.setInt(++i, g.getStatus().getValue());
//            ps.setInt(++i, g.getCurrSequence());
//            ps.setTimestamp(++i, new Timestamp(g.getCreatedAt() == null ? new java.util.Date().getTime() : g.getCreatedAt().getTime()));
//            ps.setInt(++i, g.getCreatedBy());
//            ps.setInt(++i, g.getCreatedBy());getCreatedBy
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }


    /**
     * 查找所有的失败的或者未知的事务过程记录
     * 升序
     *
     * @param transactionId
     * @return
     */
    public List<UserAccount> findFailedProcess(Integer transactionId) {
//        return this.getJdbcTemplate().query("select * from global_transaction_process where transaction_id=? and (status=3 or status=4) order by transaction_sequence asc", new Object[]{transactionId}, new GlobalTransactionProcessMapper());
    return  null;
    }



}
