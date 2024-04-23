package com.tutran.eazybank.repository;

import com.tutran.eazybank.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    @Query(value = "FROM Notice n WHERE CURDATE() BETWEEN noticeBegDt AND noticeEndDt")
    List<Notice> findAllActiveNotices();

}