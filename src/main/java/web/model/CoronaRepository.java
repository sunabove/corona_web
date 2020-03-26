package web.model;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoronaRepository extends PagingAndSortingRepository<Corona, Long> {
	
	Corona findByCoronaId(Long id); 
	
}