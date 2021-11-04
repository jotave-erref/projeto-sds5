package com.jvrskt.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jvrskt.dsvendas.dto.SaleSuccessDTO;
import com.jvrskt.dsvendas.dto.SaleSumDTO;
import com.jvrskt.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("Select new com.jvrskt.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupBySeller();
	
	@Query("Select new com.jvrskt.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupBySeller();
}
