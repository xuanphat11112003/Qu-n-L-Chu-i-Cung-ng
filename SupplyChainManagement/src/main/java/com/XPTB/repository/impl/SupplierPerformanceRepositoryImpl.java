/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.repository.impl;

import com.XPTB.pojo.Supplier;
import com.XPTB.pojo.Supplierperformance;
import com.XPTB.repository.SupplierPerformaceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class SupplierPerformanceRepositoryImpl implements SupplierPerformaceRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    private static final int PAGE_SIZE = 4;

    @Override
    public void save(Supplierperformance s) {
        Session a = this.factory.getObject().getCurrentSession();
        a.save(s);
    }

    @Override
    public List<Supplierperformance> getAllRate(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Supplierperformance> cq = b.createQuery(Supplierperformance.class);
        Root r = cq.from(Supplierperformance.class);
        cq.select(r);
        if(params != null && !params.isEmpty()){
            String id =params.get("name");
            if(id != null){
                int y = Integer.parseInt(id);
                Predicate p1 = b.equal(r.get("supplier").get("id"),y );
                cq.where(p1);
            }
            
        }
        Query query = s.createQuery(cq);
        if(params != null && !params.isEmpty()){
            String page = params.get("page");
            if(page != null && !page.isEmpty()){
                int p = Integer.parseInt(page);
                int start = (p-1) * PAGE_SIZE;
                query.setFirstResult(start);
                query.setMaxResults(PAGE_SIZE);
            }
        }
        return query.getResultList();
    }

    @Override
    public List<Object[]> Stats(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = b.createQuery(Object[].class);
        Root<Supplierperformance> root = cq.from(Supplierperformance.class);
        Join<Supplierperformance,Supplier> superFor = root.join("supplier");
        cq.multiselect(
                superFor.get("name"),
                b.avg(root.get("deliveryRating").as(Integer.class)),
                b.avg(root.get("qualityRating").as(Integer.class)),
               b.avg(root.get("priceRating").as(Integer.class)),
               superFor.get("address"),
               superFor.get("phone"),
               superFor.get("id")
        );
        cq.groupBy(superFor.get("id"),superFor.get("name"),superFor.get("address"),superFor.get("phone"));
        if(params!=null){
            List<Predicate> predicates = new ArrayList<>();
            String name = params.get("name");
            if(name!=null)
               predicates.add(b.like(superFor.get("name").as(String.class), String.format("%%%s%%", name)));   
            
            cq.where(predicates.toArray(new Predicate[0] ));
        }
        Query<Object[]> query = s.createQuery(cq);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> StatsByM(Map<String, String> map) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = b.createQuery(Object[].class);
        Root<Supplierperformance> root = cq.from(Supplierperformance.class);
        Join<Supplierperformance,Supplier> superFor = root.join("supplier");
        Expression<Integer> monthExpr = b.function("MONTH", Integer.class, root.get("evaluationDate"));
        Expression<Integer> yearExpr = b.function("YEAR", Integer.class, root.get("evaluationDate"));
        cq.multiselect(
                superFor.get("name"),
                monthExpr,
                yearExpr,
                b.avg(root.get("deliveryRating").as(Integer.class)),
                b.avg(root.get("qualityRating").as(Integer.class)),
               b.avg(root.get("priceRating").as(Integer.class))           
        );
        cq.groupBy(superFor.get("name"),monthExpr,yearExpr);
        if(map!=null){
            List<Predicate> predicates = new ArrayList<>();
            String name = map.get("name");
            if(name!=null)
               predicates.add(b.like(superFor.get("name").as(String.class), String.format("%%%s%%", name)));   
            
            cq.where(predicates.toArray(new Predicate[0] ));
        }
        Query<Object[]> query = s.createQuery(cq);
        return query.getResultList();
        
    }

    
    
}
