package web.model;

import java.sql.Timestamp;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoronaRepository extends PagingAndSortingRepository<Corona, Long> { 
	
	CoronaList findAllByUpDtGreaterThanEqualOrderById(Timestamp upDt);
	
}