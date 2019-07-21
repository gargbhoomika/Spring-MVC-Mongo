package mongoFactoryPackage;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.sun.istack.internal.logging.Logger;

@SuppressWarnings("deprecation")
public class MongoFactory 
{
	
	private static Logger log = Logger.getLogger(MongoFactory.class);
	private static Mongo mongo;
	private MongoFactory() {}
	
	//Return Mongo Instance.
	public static Mongo getMongo()
	{
		int port_no = 27017;
		String hostname = "localhost";
		if(mongo==null)
		{
			try
			{
				mongo = new Mongo(hostname, port_no);
			}
			catch(MongoException ex)
			{
				String x = ex.getMessage();
				log.warning(x);
			}
		}
		return mongo;
	}
	//Fetches the database
	public static DB getDB(String db_name)
	{
		return getMongo().getDB(db_name);
	}
	//Fetches the collection
	public static DBCollection getCollection(String db_name, String db_collection)
	{
		return getDB(db_name).getCollection(db_collection);
	}
}
