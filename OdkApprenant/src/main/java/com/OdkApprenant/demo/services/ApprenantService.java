/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OdkApprenant.demo.services;

import com.OdkApprenant.demo.model.Apprenant;
import java.util.List;

/**
 *
 * @author fadiala.sidibe
 */
public interface ApprenantService {
    public List listApprenant();
    public String addApprenant(Apprenant apprenant);
    public String deleteApprenant(Long id);
    public void updateApprenant(Long id, Apprenant apprenant);
    public Apprenant getInfoApprenantById(Long id);
    public Apprenant login(String username, String password);
    
}
