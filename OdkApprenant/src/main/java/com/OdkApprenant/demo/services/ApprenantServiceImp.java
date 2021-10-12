/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OdkApprenant.demo.services;

import com.OdkApprenant.demo.model.Apprenant;
import com.OdkApprenant.demo.repositories.ApprenantRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fadiala.sidibe
 */
@Service
public class ApprenantServiceImp implements ApprenantService{
    /*@Autowired
    private ApprenantRepository apprenantRepository;*/
    
    ApprenantRepository apprenantRepository;
    EntityManager entityManager;

    public ApprenantServiceImp(ApprenantRepository apprenantRepository) {
        this.apprenantRepository = apprenantRepository;
    }

    @Override
    public List<Apprenant> listApprenant() {
       return this.apprenantRepository.findAll();
    }

    @Override
    public String addApprenant(Apprenant apprenant) {
        this.apprenantRepository.save(apprenant);
        return "Ajout effectuer avec succes:"+apprenant.getNom()+" "+apprenant.getPrenom();
    }

    @Override
    public String deleteApprenant(Long id) {
    this.apprenantRepository.deleteById(id);
    return "L'apprenant vient d'être supprimer avec succes";
    }
    
    @Transactional
    public void updateApprenant(Long id, Apprenant apprenant )
    {
    Apprenant apprenants = this.apprenantRepository.findById(id).orElseThrow();
    
    apprenants.setNom(apprenant.getNom());
    apprenants.setPrenom(apprenant.getPrenom());
    apprenants.setAge(apprenant.getAge());
    apprenants.setTelephone(apprenant.getTelephone());
    apprenants.setEmail(apprenant.getEmail());
    apprenants.setLogin(apprenant.getLogin());
    apprenants.setPassword(apprenant.getPassword());
    apprenants.setGenre(apprenant.getGenre());
    apprenants.setApprenantStatus(apprenant.getApprenantStatus());
    apprenants.setDateCreation(apprenant.getDateCreation());
    apprenants.setDateModification(apprenant.getDateModification());
    
    }

    @Override
    public Apprenant getInfoApprenantById(Long id) {
      return this.apprenantRepository.findById(id).get();
    }

    @Override
    public Apprenant login(String username, String password) {
   Apprenant app = apprenantRepository.findByLoginAndPassword(username, password);
        return app;
    }
    
}
