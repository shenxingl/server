package com.yuny.jpademo.repository;

import com.yuny.jpademo.pojo.yuyue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface YuyueRepository extends PagingAndSortingRepository<yuyue, Integer> {
    public List<yuyue> findByNameIsLike(String Name);
    public yuyue findByDatetimeAndRoom(String date,int room);
    public yuyue findByDatetimeAndName(String date,String name);
    @Query("select y from yuyue y where y.datetime like %:datetime%")
    List<yuyue> findByDatetimeLike(@Param("datetime") String datetime);
    public yuyue findByDatetime(String date);
}

