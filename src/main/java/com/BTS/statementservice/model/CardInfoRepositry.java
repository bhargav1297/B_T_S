package com.BTS.statementservice.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardInfoRepositry extends JpaRepository<CardInfo, Long>{

//	List<CardInfo> fetchBycardNo(Long cardNo);
	
	@Query(value = "SELECT * FROM cardinfo WHERE ctype = :cType", nativeQuery = true)
	List<CardInfo> fetchByCtpe(@Param("cType") String cType);

}





