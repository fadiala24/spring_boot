/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OdkApprenant.demo.controllers;

import com.OdkApprenant.demo.model.Apprenant;
import com.OdkApprenant.demo.services.ApprenantServiceImp;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fadiala.sidibe
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/APIODK")
public class ApprenantController {
    
    ApprenantServiceImp apprenantServiceImp;

    public ApprenantController(ApprenantServiceImp apprenantServiceImp) {
        this.apprenantServiceImp = apprenantServiceImp;
    }
    
    /* Affichage de la liste avec la methode Get dans Postman */
    @GetMapping("/ListApprenant")
   public List<Apprenant> listApprenant(){
   return this.apprenantServiceImp.listApprenant();
   
   
   }
   // Ceci permet d'enregistrer les apprenants
   
   @PostMapping("/addApprenant")
   public String addApprenant(@RequestBody Apprenant apprenant)
   {
   return this.apprenantServiceImp.addApprenant(apprenant);
   
   }
   @DeleteMapping("/deleteApprenant/{id}")
   public String deleteApprenant(@PathVariable Long id)
   {
   return this.apprenantServiceImp.deleteApprenant(id);
   
   }
    @PutMapping("/updateApprenant/{id}")
    
    public void updateApprenant (@PathVariable Long id, @RequestBody Apprenant apprenant)
    {
    this.apprenantServiceImp.updateApprenant(id, apprenant);
    }
   @GetMapping("/InfoApprenant/{id}")
   
   public Apprenant getInfoApprenantById(@PathVariable Long id){
   
   return this.apprenantServiceImp.getInfoApprenantById(id);
  
   }
   @CrossOrigin("*")
   @GetMapping("/logine/{login}/{password}")
   public Apprenant appp(@PathVariable("login") String login,
           @PathVariable("password") String password){
       return this.apprenantServiceImp.login(login, password);
}
    
    
}
