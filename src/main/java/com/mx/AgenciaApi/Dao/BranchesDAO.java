package com.mx.AgenciaApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.AgenciaApi.Domain.Branches;

public interface BranchesDAO extends JpaRepository<Branches, Long>{

}
