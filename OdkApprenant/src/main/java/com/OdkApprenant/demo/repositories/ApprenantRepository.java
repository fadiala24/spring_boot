/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OdkApprenant.demo.repositories;

import com.OdkApprenant.demo.model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fadiala.sidibe
 */
public interface ApprenantRepository extends JpaRepository<Apprenant, Long>{
    Apprenant findByLoginAndPassword(String login, String password);
}
