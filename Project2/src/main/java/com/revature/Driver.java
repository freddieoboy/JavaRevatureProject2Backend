package com.revature;

import java.util.List;

import org.hibernate.Session;

import com.revature.dao.UserDao;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		Session s = HibernateUtil.getSession();
		
		UserDao ud = new UserDaoImpl();
		
		List<User> users = ud.getUsers();
		
		for (User u: users) {
			System.out.println(u);
		}
		
		User u1 = ud.getUserById(1);
		
		u1 = ud.getUserByEmailAndPassword("larno0@discuz.net", "pswd");
		
		//u1 = ud.getUserByUsernameAndPassword("osurgey6@wikispaces.com", "pswd");
		
		u1 = ud.getUserByUsernameAndPassword("osurgey6", "pswd");
		System.out.println(u1);
		
		User u2 = new User();
		int i = 2;
		u2.setEmail("test" + i + "@test.com");
		u2.setFirstname("test" + i );
		u2.setLastname("test" + i );
		u2.setPassword("pswd");
		u2.setUsername("test" + i );
		
		System.out.println("PK: " + ud.createUser(u2));

		//CaveDao cd = new CaveDaoImpl();
		
//		Cave c1 = new Cave("Indian Echo Caverns");
//		Cave c2 = new Cave("Mammoth Cave");
//		Cave c3 = new Cave("Luray Caverns");
		
//		cd.createCave(c1);
//		cd.createCave(c2);
//		cd.createCave(c3);
//		
		
//		List<Cave> caves = cd.getCaves();
//		for(Cave c: caves) {
//			System.out.println(c);
//		}
		
//		System.out.println(cd.getCaveById(2));
//		System.out.println(cd.getCaveById(5));
		
//		cd.updateCave(new Cave(3, "Skyline Caverns"));
		
//		cd.deleteCave(2);
		
		//Cave c1 = new Cave(1);
		//Cave c3 = new Cave(3);
		//Cave c4 = new Cave(4);
//		Bear b = new Bear("Smokey",c1);
		
		//BearDao bd = new BearDaoImpl();
//		System.out.println(bd.createBear(b));
//		System.out.println(bd.getBearById(1));
		
		
//		Bear b2 = new Bear("Ted", c3);
//		Bear b3 = new Bear("Yogi", c1);
//		Bear b4 = new Bear("Fernando", c4);
//		Bear b5 = new Bear("Yoda",c1);
//		bd.createBear(b2);
//		bd.createBear(b3);
//		bd.createBear(b4);
//		bd.createBear(b5);
		
		
//		List<Bear> bears = bd.getBearsByName("Ted");
//		for(Bear b: bears) {
//			System.out.println(b);
//		}
		
//		List<Bear> bears = bd.getYBears();
//		for(Bear b: bears) {
//			System.out.println(b);
//		}
		
		//System.out.println(bd.getBearCount());
		
		
		
		
		
		
		HibernateUtil.closeSessionFactory();
	}

}
