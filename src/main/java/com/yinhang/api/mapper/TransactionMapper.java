package com.yinhang.api.mapper;

import com.yinhang.api.entity.Transaction;
import com.yinhang.api.entity.TransactionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    int countByExample(TransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    int deleteByExample(TransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    int insert(Transaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    int insertSelective(Transaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    List<Transaction> selectByExample(TransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    Transaction selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") Transaction record, @Param("example") TransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    int updateByExample(@Param("record") Transaction record, @Param("example") TransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    int updateByPrimaryKeySelective(Transaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table YU_TRANSACTION
     *
     * @mbggenerated Mon Dec 16 21:28:17 CST 2019
     */
    int updateByPrimaryKey(Transaction record);
}