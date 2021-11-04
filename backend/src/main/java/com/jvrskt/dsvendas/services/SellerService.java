package com.jvrskt.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvrskt.dsvendas.dto.SellerDTO;
import com.jvrskt.dsvendas.entities.Seller;
import com.jvrskt.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		return result.stream().map(obj -> new SellerDTO(obj)).collect(Collectors.toList());
	}
}
