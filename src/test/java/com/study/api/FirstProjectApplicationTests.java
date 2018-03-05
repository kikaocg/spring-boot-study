package com.study.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.study.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FirstProjectApplicationTests {

	@Value("${paginacao.qtd.por_pagina}")
	private int qntPorPagina;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void tstLoadTestContext() {
		assertEquals(100, qntPorPagina);
	}
	
	@Test
	public void tstBcryptGeneration() {
		String passwordEncoded = PasswordUtils.createBCrypt("123456");
		passwordEncoded = PasswordUtils.createBCrypt("123456");
		assertTrue(PasswordUtils.passwordIsValid("123456", passwordEncoded));
	}
	
}
