package com.mx.AgenciaApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.AgenciaApi.Dao.BranchesDAO;
import com.mx.AgenciaApi.Domain.Branches;

@Service
public class BranchService {
	
	@Autowired
	BranchesDAO brnchDao;
	
	public List<Branches> branchesList(){
		
		return brnchDao.findAll();
	}
	
	public String save(Branches branch) {
		
		for (Branches branchF : branchesList()) {
			if(branchF.getId()==branch.getId()) {
				return "El id existe";
			}else if (branchF.getName().equals(branch.getName())) {
				return "El nombre ya existe";
			}
		}
		
		brnchDao.save(branch);
		return "ok";
		
	}
	
	public Branches search(Long id) {
		
		return brnchDao.findById(id).orElse(null);
	}

	public boolean edit(Branches branch) {
		boolean exist=false;
		for (Branches branchF : branchesList()) {
			if (branchF.getName()==branch.getName()) {
				return false;
			}else if (branchF.getId()==branch.getId()) {
				exist=true;
			}
		}
		
		if(exist)
			brnchDao.save(branch);
		else
			return false;
		
		return true;
	}
	
	public boolean delete(Long id) {
		
		for (Branches branchF : branchesList()) {
			if(branchF.getId()==id) {
				brnchDao.deleteById(id);
				return true;
			}
				
		}
		
		return false;
	}


}
