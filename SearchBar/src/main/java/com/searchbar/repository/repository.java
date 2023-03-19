package com.searchbar.repository;

import java.util.List;

import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.query.*;

import com.searchbar.helper.*;
import com.searchbar.model.*;

public class repository {

	public static boolean saveuser(User user) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			session.close();
			System.out.println("inserted....");
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static boolean check(User user) {

		try {
			Session session = factoryProvider.getfactory().openSession();
			Query<User> query = session.createQuery("from User");
//			query.setParameter("email", user.getEmail());
			List<User> user2 = (List<User>) query.getResultList();
			session.close();
			for (User obj : user2) {
				if (((obj.getEmail().toLowerCase()).equals(user.getEmail().toLowerCase()))
						&& (obj.getPassword().equals(user.getPassword()))) {
					System.out.println("match...");
					return true;

				}
			}
			System.out.println("not match...");
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}

	}

	public static User getuser(User user) {
		Session session = factoryProvider.getfactory().openSession();
		Query<User> query = session.createQuery("from User where email=:email");
		query.setParameter("email", user.getEmail());
		User user2 = query.getSingleResult();
		session.close();
		return user2;
	}

	public static Boolean checkpassword(User user) {

		try {
			Session session = factoryProvider.getfactory().openSession();
			Query<User> query = session.createQuery("from User");
//			query.setParameter("email", user.getEmail());
			List<User> user2 = (List<User>) query.getResultList();
			session.close();
			for (User obj : user2) {
				if (((obj.getEmail().toLowerCase()).equals(user.getEmail().toLowerCase()))
						&& (obj.getPassword().equals(user.getPassword()))) {
					System.out.println(" password and email notmatch...");
					return true;
				} else if (((obj.getEmail().toLowerCase()).equals(user.getEmail().toLowerCase()))
						&& !(obj.getPassword().equals(user.getPassword()))) {
					System.out.println(" password not match...");
					return false;
				}
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}
	}

	public static int getcount(User user) {
		int maxContentId = 0;
		try {
			Session session = factoryProvider.getfactory().openSession();
			Query<Content> query = session.createQuery("from Content c where c.user.id = :userId");
			query.setParameter("userId", user.getId());
			List<Content> contentList = query.getResultList();
			session.close();

			if (!contentList.isEmpty()) {
				for (Content content : contentList) {
					if (content.getContentid().getContentid() > maxContentId) {
						maxContentId = content.getContentid().getContentid();
					}
				}
			}
			return maxContentId + 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	public static Content savecontent(Content content) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(content);
			tx.commit();
			session.close();
			return content;
		} catch (Exception ex) {
			return new Content();
		}
	}

	public static boolean updateuser(User user) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			session.close();
			System.out.println("ok");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int deletecontent(Contentid contentid) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Transaction tx = session.beginTransaction();
			Content content = session.get(Content.class, contentid);
			session.delete(content);
			tx.commit();
			session.close();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}

	}

	public static boolean updatecontent(String information, Contentid contentid) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Transaction tx = session.beginTransaction();
			Content content = session.get(Content.class, contentid);
			content.setInfomation(information);
			session.update(content);
			tx.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static List<Content> getContents(User user) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Query<Content> query = session.createQuery("from Content c where c.user.id = :userId");
			query.setParameter("userId", user.getId());
			List<Content> contentList = query.getResultList();
			session.close();
			return contentList;
		} catch (Exception ex) {
			ex.printStackTrace();
			return (List<Content>) new Content();
		}

	}

	public static Content getContent(Contentid contentid) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Content content = session.get(Content.class, contentid);
			session.close();
			return content;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
