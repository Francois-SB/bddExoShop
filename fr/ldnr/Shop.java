package fr.ldnr;

import java.util.ArrayList;

import fr.ldnr.bdd.UserDaoImpl;
import fr.ldnr.entities.User;
import fr.ldnr.job.IJobImpl;

public class Shop {

	public static void main(String[] args) {
		IJobImpl job = new IJobImpl();
		User un = new User(1,"Arthur","kodz,e");
		UserDaoImpl udao = new UserDaoImpl();
		User deux = udao.read(1);
		System.out.println("for un");
		job.displayAllArticlesForRegistredUser(un);
		System.out.println("for deux");
		job.displayAllArticlesForRegistredUser(deux);
	}

}
