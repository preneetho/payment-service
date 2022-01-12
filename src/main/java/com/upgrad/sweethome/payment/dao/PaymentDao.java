package com.upgrad.sweethome.payment.dao;

import com.upgrad.sweethome.payment.entities.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository <TransactionDetailsEntity, String>{

    public TransactionDetailsEntity findById (int transcationId);

}
