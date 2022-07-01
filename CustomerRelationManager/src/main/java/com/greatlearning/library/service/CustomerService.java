package com.greatlearning.library.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.library.model.Customer;

@Repository
public class CustomerService {

	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public CustomerService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
	}
	
	
	@Transactional
	public List<Customer> findCustomer()
	{
		System.out.println();
		System.out.println();
		return session.createQuery("from Customer").list();
	}
	
	@Transactional
	public void saveCustomer(Customer customer)
	{
		try {
			Transaction tx = session.beginTransaction();
			
			System.out.println("\n");
			session.saveOrUpdate(customer);
			System.out.println(customer);
			System.out.println();
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void deleteById(int id)
	{
		try {
			Transaction tx = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, id);
			
			System.out.println();
			System.out.println(customer);
			session.delete(customer);
			
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Transactional
	public List<Customer> findBy(String name)
	{
		try {
			Transaction tx = session.beginTransaction();
			
			System.out.println();
			System.out.println();
			
			String query = "from Customer where firstName like '%"
					+ name + "%' or lastName like '%" + name +
					"%' or email like '%" + name + "%'";
			List<Customer> customers = session.createQuery(query).list();
			System.out.println(customers);
			tx.commit();
			
			System.out.println();
			System.out.println();
			
			return customers;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public Customer findById(int id)
	{
		try {
			Transaction tx = session.beginTransaction();
			Customer customer = session.get(Customer.class, id);
			
			System.out.println();
			System.out.println();
			System.out.println(customer);
			System.out.println();
			System.out.println();
			
			tx.commit();
			
			return customer;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public Customer updateCustomer(int id, String firstName, String lastName, String email)
	{
		try {
			Transaction tx = session.beginTransaction();
			
			System.out.println();
			System.out.println();
			
			Customer customer = session.get(Customer.class, id);
			customer.setId(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
			
			System.out.println(customer);
			
			System.out.println();
			
			tx.commit();
			
			return null;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
