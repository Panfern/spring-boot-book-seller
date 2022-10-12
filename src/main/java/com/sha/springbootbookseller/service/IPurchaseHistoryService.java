package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchase(PurchaseHistory purchaseHistory);

    void deletePurchase(Long id);

    List<IPurchaseItem> findPurchaseOfUser(Long userId);
}
