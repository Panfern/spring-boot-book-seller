package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.Security.UserPrincipal;
import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.service.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase-history")
public class PurchaseHistoryController {

    @Autowired
    private IPurchaseHistoryService purchaseHistoryService;

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody PurchaseHistory purchaseHistory)
    {
        return new ResponseEntity<>(purchaseHistoryService.savePurchase(purchaseHistory), HttpStatus.CREATED);
    }

//    @DeleteMapping("{id}")
//    public  ResponseEntity<?> deletePurchase(@PathVariable Long id)
//    {
//        purchaseHistoryService.deletePurchase(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<?> findPurchaseOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal)
    {
        return ResponseEntity.ok(purchaseHistoryService.findPurchaseOfUser(userPrincipal.getId()));
    }
}
