package com.realdomen.shopr.repository;

import com.realdomen.shopr.domain.Cart;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@NoArgsConstructor
@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveOrder(Cart cart){
        entityManager.persist(cart);
    }

    @Transactional
    public void updateOrder(Cart cart){
        entityManager.merge(cart);
    }

    public Cart findOrderById(Integer id){
        return entityManager.find(Cart.class, id);
    }

    public Cart getNewestOrder() {
        List<Cart> results = entityManager
                .createQuery("select c from Cart c ORDER BY c.id DESC", Cart.class).getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public List<Cart> getOrderHistory(){
        List<Cart> results = entityManager
                .createQuery("select c from Cart c ORDER BY c.id DESC", Cart.class).getResultList();
        results.remove(0);
        return results.isEmpty() ? null : results;
    }



}
