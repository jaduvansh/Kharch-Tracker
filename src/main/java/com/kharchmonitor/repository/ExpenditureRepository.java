package com.kharchmonitor.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.kharchmonitor.persistence.entity.Expenditure;

public interface ExpenditureRepository extends MongoRepository<Expenditure, String> {

	public Expenditure findByUserNameAndDate(String userName, Date date);

	public List<Expenditure> findByUserNameOrderByDate(String userName);
	
	@Query("{$expr:{$and:[{$eq:[{$year:'$date'}, ?0]}, {$eq:[{$month:'$date'}, ?1]}]}}")
	public List<Expenditure> findByMonthAndYearOrderByDate(int year, int month,Sort sort);
	
	@Query("{$and:[{userName:{$eq:?0}},{$expr:{$and:[{$eq:[{$year:'$date'}, ?1]}, {$eq:[{$month:'$date'}, ?2]}]}}]}")
	public List<Expenditure> findByUsernameMonthAndYear(String userName, int year, int month,Sort sort);
	
	@Query("{$and:[{userName:{$eq:?0}},{date:{$gte: ?1,$lt: ?2}}]}")
	public List<Expenditure> findByUsernameDateRange(String userName, Date fromdate, Date toDate,Sort sort);
}

