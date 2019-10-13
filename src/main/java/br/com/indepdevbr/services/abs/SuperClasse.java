package br.com.indepdevbr.services.abs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class SuperClasse<R extends JpaRepository<?,?>> {
	
	@Autowired
	protected R repository;
	
	protected final Logger logger = LogManager.getLogger(getClass());
	
}
