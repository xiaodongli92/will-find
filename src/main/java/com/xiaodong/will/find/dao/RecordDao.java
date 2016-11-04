package com.xiaodong.will.find.dao;

import com.xiaodong.will.find.model.SearchParam;
import com.xiaodong.will.find.model.pojo.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * RecordDao
 */
public interface RecordDao extends CrudRepository<Record, Long> {

    @Query(value = "SELECT * FROM record ORDER BY time desc",nativeQuery = true)
    List<Record> allRecord();

    @Query(value = "SELECT * FROM record ORDER BY time desc limit ?,?",nativeQuery = true)
    List<Record> pageByParam(int start, int size);

    @Query(value = "SELECT count(1) FROM record",nativeQuery = true)
    Long count(SearchParam searchParam);
}
