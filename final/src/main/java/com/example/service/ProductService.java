package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.ProductVO;

@Service
public interface ProductService {
	public void insert(ProductVO vo);
}
