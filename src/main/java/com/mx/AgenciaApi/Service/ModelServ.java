package com.mx.AgenciaApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.AgenciaApi.Dao.BranchesDAO;
import com.mx.AgenciaApi.Dao.ModelsDao;
import com.mx.AgenciaApi.Domain.Branches;
import com.mx.AgenciaApi.Domain.Models;

@Service
public class ModelServ {
	
	@Autowired
	ModelsDao modelsDao;
	@Autowired
	BranchesDAO branchesDAO;
	
	@Transactional(readOnly = true)
	public List<Models> list(){
		return modelsDao.findAll();
	}
	
	public Models save(Models model) {
		
		boolean existBrand=false;
		boolean existModel=true;
		
		for (Branches branchF : branchesDAO.findAll()) {
			
			if (branchF.getId()==model.getBranch().getId()) {
				existBrand=true;
				System.out.println("La marca existe "+model.getBranch().getId()+" "+branchF.getId());
				break;
			}
			
		}
		
		if(existBrand) {
			for (Models modelF : modelsDao.findAll()) {
				if(modelF.getName().equals(model.getName())||modelF.getId()==model.getId()) {
					System.out.println("el modelo existe "+model.getName()+" "+modelF.getName());
					existModel=false;
					break;
				}
			}
		}
		if(!existModel) {
			return null;
		}
		
		modelsDao.save(model);
		return model;
		
	}
	
public String save2(Models model) {
		
		boolean existBrand=false;
		
		for (Branches branchF : branchesDAO.findAll()) {
			
			if (branchF.getId()==model.getBranch().getId()) {
				existBrand=true;
				//System.out.println("La marca existe "+model.getBranch().getId()+" "+branchF.getId());
				
			}
			
		}
		
		if(existBrand) {
			for (Models modelF : modelsDao.findAll()) {
				if(modelF.getId()==model.getId()) {
					System.out.println("el modelo existe "+model.getName()+" "+modelF.getName());
					return "el id del modelo existe";
					
				}else if (modelF.getName().equals(model.getName())) {
					return "el modelo existe";
				}
			}
		}else
			return "la marca no existe";
		
		modelsDao.save(model);
		return "ok";
		
	}
	
	public String edit(Models model) {
		
		for (Models modelF : list()) {
			if (modelF.getId()==model.getId()) {
				for (Branches branchF : branchesDAO.findAll()) {
					if(branchF.getId()==model.getBranch().getId()) {
						modelsDao.save(model);
						return "ok";
					}
				}
				
			}
		}
		
		return "notEdited";
	}
	
	public boolean delete(Models model) {
		
		for (Models modelF : list()) {
			if (modelF.getId()==model.getId()) {
				modelsDao.deleteById(model.getId());
				return true;
			}
		}
		
		return false;
	}

}
