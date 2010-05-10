package com.alibaba.intl.goldroom.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.goldroom.dataobject.Member;

@Service
@RemotingDestination
public class Foo {

    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;
    Member                member;

    @Transactional
    @RemotingInclude
    public void save() {
        System.out.println("*** em: " + this.em); // em is null
        this.member = new Member();
        this.member.setName("jpa");
        this.member.setLoginId("jpa");
        em.persist(member);
    }

}
