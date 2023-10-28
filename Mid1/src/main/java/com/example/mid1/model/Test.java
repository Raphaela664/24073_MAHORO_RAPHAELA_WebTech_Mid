package com.example.mid1.model;

import com.example.mid1.dao.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();

    }
}
