package com.jcg.springmvc.mongo;
import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import mongoFactoryPackage.MongoFactory;

@Service("userService")
@Transactional
public class UserService 
{
	static String db_name = "mydb", db_collection = "mycollection";
	private static Logger log = Logger.getLogger(UserService.class);
	
	private List getAll()
	{
		List user_list = new ArrayList();
		DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
		DBCursor cursor = coll.find();
		while(cursor.hasNext())
		{
			DBObject dbobj = cursor.next();
			User user = new User();
			user.setId(dbobj.get("id").toString());
			user.setName(dbobj.get("name").toString());
			user_list.add(user);
		}
		log.debug("Total records fetched: "+user_list.size());
		return user_list;
	}
	public Boolean add(User user)
	{
		boolean output = false;
		Random ran = new Random();
		log.debug("Adding new user: "+ user.getName());
		try
		{
			DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
			BasicDBObject doc = new BasicDBObject();
			doc.put("id", String.valueOf(ran.nextInt(100)));
			doc.put("name", user.getName());
			coll.insert(doc);
			output = true;
		}
		catch(Exception e){
			output = false;
			log.warn("Error Occured");
		}
		return output;
	}
	
	public Boolean edit(User user)
	{
		return true;
	}
}
