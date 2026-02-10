// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Big Data
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package project.loadbronzetmdb_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 




	//the import part of tJava_1
	//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: LoadBronzeTMDB Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class LoadBronzeTMDB implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(kaggle_dataset != null){
				
					this.setProperty("kaggle_dataset", kaggle_dataset.toString());
				
			}
			
			if(letter != null){
				
					this.setProperty("letter", letter.toString());
				
			}
			
			if(mongodb_authentificationDatabase != null){
				
					this.setProperty("mongodb_authentificationDatabase", mongodb_authentificationDatabase.toString());
				
			}
			
			if(mongodb_collection_bronze_k != null){
				
					this.setProperty("mongodb_collection_bronze_k", mongodb_collection_bronze_k.toString());
				
			}
			
			if(mongodb_collection_bronze_nutritional != null){
				
					this.setProperty("mongodb_collection_bronze_nutritional", mongodb_collection_bronze_nutritional.toString());
				
			}
			
			if(mongodb_collection_bronze_tmdb != null){
				
					this.setProperty("mongodb_collection_bronze_tmdb", mongodb_collection_bronze_tmdb.toString());
				
			}
			
			if(mongodb_collection_silver != null){
				
					this.setProperty("mongodb_collection_silver", mongodb_collection_silver.toString());
				
			}
			
			if(mongodb_database != null){
				
					this.setProperty("mongodb_database", mongodb_database.toString());
				
			}
			
			if(mongodb_password != null){
				
					this.setProperty("mongodb_password", mongodb_password.toString());
				
			}
			
			if(mongodb_port != null){
				
					this.setProperty("mongodb_port", mongodb_port.toString());
				
			}
			
			if(mongodb_server != null){
				
					this.setProperty("mongodb_server", mongodb_server.toString());
				
			}
			
			if(mongodb_user != null){
				
					this.setProperty("mongodb_user", mongodb_user.toString());
				
			}
			
			if(nutrition_dataset != null){
				
					this.setProperty("nutrition_dataset", nutrition_dataset.toString());
				
			}
			
			if(postgresql_database != null){
				
					this.setProperty("postgresql_database", postgresql_database.toString());
				
			}
			
			if(postgresql_password != null){
				
					this.setProperty("postgresql_password", postgresql_password.toString());
				
			}
			
			if(postgresql_port != null){
				
					this.setProperty("postgresql_port", postgresql_port.toString());
				
			}
			
			if(postgresql_schema != null){
				
					this.setProperty("postgresql_schema", postgresql_schema.toString());
				
			}
			
			if(postgresql_server != null){
				
					this.setProperty("postgresql_server", postgresql_server.toString());
				
			}
			
			if(postgresql_table_area != null){
				
					this.setProperty("postgresql_table_area", postgresql_table_area.toString());
				
			}
			
			if(postgresql_table_category != null){
				
					this.setProperty("postgresql_table_category", postgresql_table_category.toString());
				
			}
			
			if(postgresql_table_meals != null){
				
					this.setProperty("postgresql_table_meals", postgresql_table_meals.toString());
				
			}
			
			if(postgresql_user != null){
				
					this.setProperty("postgresql_user", postgresql_user.toString());
				
			}
			
			if(source != null){
				
					this.setProperty("source", source.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public String kaggle_dataset;
public String getKaggle_dataset(){
	return this.kaggle_dataset;
}
public String letter;
public String getLetter(){
	return this.letter;
}
public String mongodb_authentificationDatabase;
public String getMongodb_authentificationDatabase(){
	return this.mongodb_authentificationDatabase;
}
public String mongodb_collection_bronze_k;
public String getMongodb_collection_bronze_k(){
	return this.mongodb_collection_bronze_k;
}
public String mongodb_collection_bronze_nutritional;
public String getMongodb_collection_bronze_nutritional(){
	return this.mongodb_collection_bronze_nutritional;
}
public String mongodb_collection_bronze_tmdb;
public String getMongodb_collection_bronze_tmdb(){
	return this.mongodb_collection_bronze_tmdb;
}
public String mongodb_collection_silver;
public String getMongodb_collection_silver(){
	return this.mongodb_collection_silver;
}
public String mongodb_database;
public String getMongodb_database(){
	return this.mongodb_database;
}
public String mongodb_password;
public String getMongodb_password(){
	return this.mongodb_password;
}
public String mongodb_port;
public String getMongodb_port(){
	return this.mongodb_port;
}
public String mongodb_server;
public String getMongodb_server(){
	return this.mongodb_server;
}
public String mongodb_user;
public String getMongodb_user(){
	return this.mongodb_user;
}
public String nutrition_dataset;
public String getNutrition_dataset(){
	return this.nutrition_dataset;
}
public String postgresql_database;
public String getPostgresql_database(){
	return this.postgresql_database;
}
public String postgresql_password;
public String getPostgresql_password(){
	return this.postgresql_password;
}
public String postgresql_port;
public String getPostgresql_port(){
	return this.postgresql_port;
}
public String postgresql_schema;
public String getPostgresql_schema(){
	return this.postgresql_schema;
}
public String postgresql_server;
public String getPostgresql_server(){
	return this.postgresql_server;
}
public String postgresql_table_area;
public String getPostgresql_table_area(){
	return this.postgresql_table_area;
}
public String postgresql_table_category;
public String getPostgresql_table_category(){
	return this.postgresql_table_category;
}
public String postgresql_table_meals;
public String getPostgresql_table_meals(){
	return this.postgresql_table_meals;
}
public String postgresql_user;
public String getPostgresql_user(){
	return this.postgresql_user;
}
public String source;
public String getSource(){
	return this.source;
}
	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "LoadBronzeTMDB";
	private final String projectName = "PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				LoadBronzeTMDB.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(LoadBronzeTMDB.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tWarn_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tWarn_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBConnection_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFixedFlowInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLoop_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tREST_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tREST_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tExtractJSONFields_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tREST_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tREST_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tREST_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBClose_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBClose_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tWarn_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tWarn_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tWarn_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFixedFlowInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tLoop_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tREST_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBClose_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tWarn_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	





public void tWarn_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tWarn_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tWarn_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tWarn_1", false);
		start_Hash.put("tWarn_1", System.currentTimeMillis());
		
	
	currentComponent="tWarn_1";

	
		int tos_count_tWarn_1 = 0;
		

 



/**
 * [tWarn_1 begin ] stop
 */
	
	/**
	 * [tWarn_1 main ] start
	 */

	

	
	
	currentComponent="tWarn_1";

	

		
try {
	
	resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_1", "", Thread.currentThread().getId() + "", "INFO","","LoadBronzeTMDB begin","", "");
	globalMap.put("tWarn_1_WARN_MESSAGES", "LoadBronzeTMDB begin"); 
	globalMap.put("tWarn_1_WARN_PRIORITY", 3);
	globalMap.put("tWarn_1_WARN_CODE", 42);
	
} catch (Exception e_tWarn_1) {
globalMap.put("tWarn_1_ERROR_MESSAGE",e_tWarn_1.getMessage());
	logIgnoredError(String.format("tWarn_1 - tWarn failed to log message due to internal error: %s", e_tWarn_1), e_tWarn_1);
}


 


	tos_count_tWarn_1++;

/**
 * [tWarn_1 main ] stop
 */
	
	/**
	 * [tWarn_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tWarn_1";

	

 



/**
 * [tWarn_1 process_data_begin ] stop
 */
	
	/**
	 * [tWarn_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tWarn_1";

	

 



/**
 * [tWarn_1 process_data_end ] stop
 */
	
	/**
	 * [tWarn_1 end ] start
	 */

	

	
	
	currentComponent="tWarn_1";

	

 

ok_Hash.put("tWarn_1", true);
end_Hash.put("tWarn_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tMongoDBConnection_1Process(globalMap);



/**
 * [tWarn_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tWarn_1 finally ] start
	 */

	

	
	
	currentComponent="tWarn_1";

	

 



/**
 * [tWarn_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tWarn_1_SUBPROCESS_STATE", 1);
	}
	

public void tMongoDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBConnection_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tMongoDBConnection_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBConnection_1", false);
		start_Hash.put("tMongoDBConnection_1", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBConnection_1";

	
		int tos_count_tMongoDBConnection_1 = 0;
		

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);
        
    

final String applicationName_tMongoDBConnection_1 = "Talend";

    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBConnection_1=null;
    com.mongodb.client.MongoDatabase db_tMongoDBConnection_1=null;
    List<com.mongodb.ServerAddress> addrs_tMongoDBConnection_1 = new java.util.ArrayList<>();
    com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBConnection_1 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBConnection_1);
    com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBConnection_1 = com.mongodb.connection.ClusterSettings.builder();
    com.mongodb.connection.ConnectionPoolSettings.Builder connPoolSettingsBuilder_tMongoDBConnection_1 = com.mongodb.connection.ConnectionPoolSettings.builder();
    com.mongodb.connection.ServerSettings.Builder serverSettingsBuilder_tMongoDBConnection_1 = com.mongodb.connection.ServerSettings.builder();
    com.mongodb.connection.SocketSettings.Builder socketSettingsBuilder_tMongoDBConnection_1 = com.mongodb.connection.SocketSettings.builder();
    com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBConnection_1 = com.mongodb.connection.SslSettings.builder();



                // SSL

                // Client Credentials
                    // Authentication
                    com.mongodb.MongoCredential mongoCredential_tMongoDBConnection_1;
	final String decryptedPassword_tMongoDBConnection_1 = context.mongodb_password; 
                        
                            mongoCredential_tMongoDBConnection_1 = com.mongodb.MongoCredential.createCredential(context.mongodb_user, context.mongodb_authentificationDatabase, new String(decryptedPassword_tMongoDBConnection_1).toCharArray());
                    clientSettingsBuilder_tMongoDBConnection_1.credential(mongoCredential_tMongoDBConnection_1);
                    addrs_tMongoDBConnection_1.add(new com.mongodb.ServerAddress(context.mongodb_server, Integer.valueOf(context.mongodb_port).intValue()));
                clusterSettingsBuilder_tMongoDBConnection_1.hosts(addrs_tMongoDBConnection_1);

                clientSettingsBuilder_tMongoDBConnection_1.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBConnection_1.build()));




    mongo_tMongoDBConnection_1 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBConnection_1.build());
    resourceMap.put("mongo_tMongoDBConnection_1", mongo_tMongoDBConnection_1);
    db_tMongoDBConnection_1 = mongo_tMongoDBConnection_1.getDatabase(context.mongodb_database);


    globalMap.put("mongo_tMongoDBConnection_1", mongo_tMongoDBConnection_1);
    globalMap.put("db_tMongoDBConnection_1", db_tMongoDBConnection_1);


 



/**
 * [tMongoDBConnection_1 begin ] stop
 */
	
	/**
	 * [tMongoDBConnection_1 main ] start
	 */

	

	
	
	currentComponent="tMongoDBConnection_1";

	

 


	tos_count_tMongoDBConnection_1++;

/**
 * [tMongoDBConnection_1 main ] stop
 */
	
	/**
	 * [tMongoDBConnection_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBConnection_1";

	

 



/**
 * [tMongoDBConnection_1 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBConnection_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBConnection_1";

	

 



/**
 * [tMongoDBConnection_1 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBConnection_1 end ] start
	 */

	

	
	
	currentComponent="tMongoDBConnection_1";

	

 

ok_Hash.put("tMongoDBConnection_1", true);
end_Hash.put("tMongoDBConnection_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tFixedFlowInput_1Process(globalMap);



/**
 * [tMongoDBConnection_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tMongoDBConnection_1 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBConnection_1";

	

 



/**
 * [tMongoDBConnection_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tMongoDBConnection_1_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadBronzeTMDB = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadBronzeTMDB = new byte[0];

	
			    public Byte dummy;

				public Byte getDummy () {
					return this.dummy;
				}
				



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadBronzeTMDB) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.dummy = null;
           				} else {
           			    	this.dummy = dis.readByte();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadBronzeTMDB) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.dummy = null;
           				} else {
           			    	this.dummy = dis.readByte();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Byte
				
						if(this.dummy == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.dummy);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Byte
				
						if(this.dummy == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.dummy);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("dummy="+String.valueOf(dummy));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFixedFlowInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row3Struct row3 = new row3Struct();




	
	/**
	 * [tMongoDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_2", false);
		start_Hash.put("tMongoDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tMongoDBOutput_2 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_2 = "Talend";

    int nb_line_tMongoDBOutput_2 = 0;

			class DBObjectUtil_tMongoDBOutput_2 {
				
				private org.bson.Document object = null;
				//Put value to embedded document
				//If have no embedded document, put the value to root document
				public void put(String parentNode, String curentName, Object value) {
					if (parentNode == null || "".equals(parentNode)) {
						object.put(curentName, value);
					} else {
						String objNames[]= parentNode.split("\\.");
						org.bson.Document lastNode = getParentNode(parentNode, objNames.length-1);
						lastNode.put(curentName, value);
						org.bson.Document parenttNode = null;
						for (int i = objNames.length - 1; i >=0; i--) {
							parenttNode=getParentNode(parentNode, i-1);
							parenttNode.put(objNames[i], lastNode);
							lastNode=clone(parenttNode);
						}
						object=lastNode;
					}
				}
				
				private org.bson.Document clone(org.bson.Document source){
					org.bson.Document to = new org.bson.Document();
					for(java.util.Map.Entry<String,Object> cur:source.entrySet()) {
						to.append(cur.getKey(), cur.getValue());
					}
					return to;
				}
				
				//Get node(embedded document) by path configuration
				public org.bson.Document getParentNode(String parentNode, int index) {
					org.bson.Document document = object;
					if (parentNode == null || "".equals(parentNode)) {
						return object;
					} else {
						String objNames[] = parentNode.split("\\.");
						for (int i = 0; i <= index; i++) {
							document = (org.bson.Document) document
									.get(objNames[i]);
							if (document == null) {
								document = new org.bson.Document();
								return document;
							}
							if (i == index) {
								break;
							}
						}
						return document;
					}
				}
				
				public void putkeyNode(String parentNode, String curentName, Object value){
					if (parentNode == null || "".equals(parentNode) || ".".equals(parentNode)) {
						put(parentNode, curentName, value);
					}else{
						put("", parentNode+"."+curentName, value);
					}
				}
			
				public org.bson.Document getObject() {
					return this.object;
				}
				
				public void setObject(org.bson.Document object){
					this.object=object;
				}
			
			}
            DBObjectUtil_tMongoDBOutput_2 updateObjectUtil_tMongoDBOutput_2=new DBObjectUtil_tMongoDBOutput_2();
            DBObjectUtil_tMongoDBOutput_2 queryObjectUtil_tMongoDBOutput_2=new DBObjectUtil_tMongoDBOutput_2();
            java.util.Map<String, String> pathMap_tMongoDBOutput_2=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_2.put("dummy","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_2=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_2=null;

        mongo_tMongoDBOutput_2=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_2 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

        db_tMongoDBOutput_2.getCollection(context.mongodb_collection_bronze_tmdb).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_2 = db_tMongoDBOutput_2.getCollection(context.mongodb_collection_bronze_tmdb);


 



/**
 * [tMongoDBOutput_2 begin ] stop
 */



	
	/**
	 * [tFixedFlowInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFixedFlowInput_1", false);
		start_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());
		
	
	currentComponent="tFixedFlowInput_1";

	
		int tos_count_tFixedFlowInput_1 = 0;
		

	    for (int i_tFixedFlowInput_1 = 0 ; i_tFixedFlowInput_1 < 1 ; i_tFixedFlowInput_1++) {
	                	            	
    	            		row3.dummy = 1;
    	            	

 



/**
 * [tFixedFlowInput_1 begin ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 main ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 


	tos_count_tFixedFlowInput_1++;

/**
 * [tFixedFlowInput_1 main ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMongoDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_2.setObject(new org.bson.Document());
				
				

				
					queryObjectUtil_tMongoDBOutput_2.setObject(new org.bson.Document());
					int countKey_tMongoDBOutput_2=0;
				
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("dummy"),"dummy", row3.dummy);
				org.bson.Document updateObj_tMongoDBOutput_2 = updateObjectUtil_tMongoDBOutput_2.getObject();
				
					if(countKey_tMongoDBOutput_2 <=0){
						
							System.err.println("Must have at least one key in schema");
						
					}else{
						org.bson.Document queryObj_tMongoDBOutput_2 = queryObjectUtil_tMongoDBOutput_2.getObject();
						
									coll_tMongoDBOutput_2.deleteMany(queryObj_tMongoDBOutput_2);
									
					}
				
				} catch (Exception e_tMongoDBOutput_2) {
				
    					
    						System.err.println(e_tMongoDBOutput_2.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_2 ++;
				
 


	tos_count_tMongoDBOutput_2++;

/**
 * [tMongoDBOutput_2 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	

 



/**
 * [tMongoDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	

 



/**
 * [tMongoDBOutput_2 process_data_end ] stop
 */



	
	/**
	 * [tFixedFlowInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 process_data_end ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

        }
        globalMap.put("tFixedFlowInput_1_NB_LINE", 1);        

 

ok_Hash.put("tFixedFlowInput_1", true);
end_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());




/**
 * [tFixedFlowInput_1 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	

	globalMap.put("tMongoDBOutput_2_NB_LINE", nb_line_tMongoDBOutput_2);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_2", true);
end_Hash.put("tMongoDBOutput_2", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk6", 0, "ok");
				}
				tLoop_1Process(globalMap);



/**
 * [tMongoDBOutput_2 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFixedFlowInput_1 finally ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	


 



/**
 * [tMongoDBOutput_2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 1);
	}
	

public void tLoop_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tLoop_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tLoop_1 begin ] start
	 */

				
			int NB_ITERATE_tJava_1 = 0; //for statistics
			

	
		
		ok_Hash.put("tLoop_1", false);
		start_Hash.put("tLoop_1", System.currentTimeMillis());
		
	
	currentComponent="tLoop_1";

	
		int tos_count_tLoop_1 = 0;
		

int current_iteration_tLoop_1 = 0;

for(int looptLoop_1 =97; looptLoop_1<=122; looptLoop_1=looptLoop_1+1){
	
current_iteration_tLoop_1++;
globalMap.put("tLoop_1_CURRENT_VALUE",looptLoop_1);
globalMap.put("tLoop_1_CURRENT_ITERATION",current_iteration_tLoop_1);


 



/**
 * [tLoop_1 begin ] stop
 */
	
	/**
	 * [tLoop_1 main ] start
	 */

	

	
	
	currentComponent="tLoop_1";

	

 


	tos_count_tLoop_1++;

/**
 * [tLoop_1 main ] stop
 */
	
	/**
	 * [tLoop_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLoop_1";

	

 



/**
 * [tLoop_1 process_data_begin ] stop
 */
	NB_ITERATE_tJava_1++;
	
	
					if(execStat){				
	       				runStat.updateStatOnConnection("row2", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("OnComponentOk3", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("out1", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row1", 3, 0);
					}           			
				
				if(execStat){
					runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tJava_1);
					//Thread.sleep(1000);
				}				
			

	
	/**
	 * [tJava_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_1", false);
		start_Hash.put("tJava_1", System.currentTimeMillis());
		
	
	currentComponent="tJava_1";

	
		int tos_count_tJava_1 = 0;
		


context.letter = String.valueOf((char) ((Integer)globalMap.get("tLoop_1_CURRENT_VALUE")).intValue());
 



/**
 * [tJava_1 begin ] stop
 */
	
	/**
	 * [tJava_1 main ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 


	tos_count_tJava_1++;

/**
 * [tJava_1 main ] stop
 */
	
	/**
	 * [tJava_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_begin ] stop
 */
	
	/**
	 * [tJava_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_end ] stop
 */
	
	/**
	 * [tJava_1 end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 

ok_Hash.put("tJava_1", true);
end_Hash.put("tJava_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tREST_1Process(globalMap);



/**
 * [tJava_1 end ] stop
 */
						if(execStat){
							runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tJava_1);
						}				
					




	
	/**
	 * [tLoop_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLoop_1";

	

 



/**
 * [tLoop_1 process_data_end ] stop
 */
	
	/**
	 * [tLoop_1 end ] start
	 */

	

	
	
	currentComponent="tLoop_1";

	


	}


 

ok_Hash.put("tLoop_1", true);
end_Hash.put("tLoop_1", System.currentTimeMillis());




/**
 * [tLoop_1 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tLoop_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tMongoDBClose_1Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tLoop_1 finally ] start
	 */

	

	
	
	currentComponent="tLoop_1";

	

 



/**
 * [tLoop_1 finally ] stop
 */

	
	/**
	 * [tJava_1 finally ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tLoop_1_SUBPROCESS_STATE", 1);
	}
	


public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadBronzeTMDB = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadBronzeTMDB = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer _id;

				public Integer get_id () {
					return this._id;
				}
				
			    public String idMeal;

				public String getIdMeal () {
					return this.idMeal;
				}
				
			    public String strMeal;

				public String getStrMeal () {
					return this.strMeal;
				}
				
			    public String strCategory;

				public String getStrCategory () {
					return this.strCategory;
				}
				
			    public String strArea;

				public String getStrArea () {
					return this.strArea;
				}
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String strIngredient1;

				public String getStrIngredient1 () {
					return this.strIngredient1;
				}
				
			    public String strIngredient2;

				public String getStrIngredient2 () {
					return this.strIngredient2;
				}
				
			    public String strIngredient3;

				public String getStrIngredient3 () {
					return this.strIngredient3;
				}
				
			    public String strIngredient4;

				public String getStrIngredient4 () {
					return this.strIngredient4;
				}
				
			    public String strIngredient5;

				public String getStrIngredient5 () {
					return this.strIngredient5;
				}
				
			    public String strIngredient6;

				public String getStrIngredient6 () {
					return this.strIngredient6;
				}
				
			    public String strIngredient7;

				public String getStrIngredient7 () {
					return this.strIngredient7;
				}
				
			    public String strIngredient8;

				public String getStrIngredient8 () {
					return this.strIngredient8;
				}
				
			    public String strIngredient9;

				public String getStrIngredient9 () {
					return this.strIngredient9;
				}
				
			    public String strIngredient10;

				public String getStrIngredient10 () {
					return this.strIngredient10;
				}
				
			    public String strIngredient11;

				public String getStrIngredient11 () {
					return this.strIngredient11;
				}
				
			    public String strIngredient12;

				public String getStrIngredient12 () {
					return this.strIngredient12;
				}
				
			    public String strIngredient13;

				public String getStrIngredient13 () {
					return this.strIngredient13;
				}
				
			    public String strIngredient14;

				public String getStrIngredient14 () {
					return this.strIngredient14;
				}
				
			    public String strIngredient15;

				public String getStrIngredient15 () {
					return this.strIngredient15;
				}
				
			    public String strIngredient16;

				public String getStrIngredient16 () {
					return this.strIngredient16;
				}
				
			    public String strIngredient17;

				public String getStrIngredient17 () {
					return this.strIngredient17;
				}
				
			    public String strIngredient18;

				public String getStrIngredient18 () {
					return this.strIngredient18;
				}
				
			    public String strIngredient19;

				public String getStrIngredient19 () {
					return this.strIngredient19;
				}
				
			    public String strIngredient20;

				public String getStrIngredient20 () {
					return this.strIngredient20;
				}
				
			    public String strMeasure1;

				public String getStrMeasure1 () {
					return this.strMeasure1;
				}
				
			    public String strMeasure2;

				public String getStrMeasure2 () {
					return this.strMeasure2;
				}
				
			    public String strMeasure3;

				public String getStrMeasure3 () {
					return this.strMeasure3;
				}
				
			    public String strMeasure4;

				public String getStrMeasure4 () {
					return this.strMeasure4;
				}
				
			    public String strMeasure5;

				public String getStrMeasure5 () {
					return this.strMeasure5;
				}
				
			    public String strMeasure6;

				public String getStrMeasure6 () {
					return this.strMeasure6;
				}
				
			    public String strMeasure7;

				public String getStrMeasure7 () {
					return this.strMeasure7;
				}
				
			    public String strMeasure8;

				public String getStrMeasure8 () {
					return this.strMeasure8;
				}
				
			    public String strMeasure9;

				public String getStrMeasure9 () {
					return this.strMeasure9;
				}
				
			    public String strMeasure10;

				public String getStrMeasure10 () {
					return this.strMeasure10;
				}
				
			    public String strMeasure11;

				public String getStrMeasure11 () {
					return this.strMeasure11;
				}
				
			    public String strMeasure12;

				public String getStrMeasure12 () {
					return this.strMeasure12;
				}
				
			    public String strMeasure13;

				public String getStrMeasure13 () {
					return this.strMeasure13;
				}
				
			    public String strMeasure14;

				public String getStrMeasure14 () {
					return this.strMeasure14;
				}
				
			    public String strMeasure15;

				public String getStrMeasure15 () {
					return this.strMeasure15;
				}
				
			    public String strMeasure16;

				public String getStrMeasure16 () {
					return this.strMeasure16;
				}
				
			    public String strMeasure17;

				public String getStrMeasure17 () {
					return this.strMeasure17;
				}
				
			    public String strMeasure18;

				public String getStrMeasure18 () {
					return this.strMeasure18;
				}
				
			    public String strMeasure19;

				public String getStrMeasure19 () {
					return this.strMeasure19;
				}
				
			    public String strMeasure20;

				public String getStrMeasure20 () {
					return this.strMeasure20;
				}
				
			    public String strMealAlternate;

				public String getStrMealAlternate () {
					return this.strMealAlternate;
				}
				
			    public String strMealThumb;

				public String getStrMealThumb () {
					return this.strMealThumb;
				}
				
			    public String strTags;

				public String getStrTags () {
					return this.strTags;
				}
				
			    public String strYoutube;

				public String getStrYoutube () {
					return this.strYoutube;
				}
				
			    public String strSource;

				public String getStrSource () {
					return this.strSource;
				}
				
			    public String strImageSource;

				public String getStrImageSource () {
					return this.strImageSource;
				}
				
			    public String strCreativeCommonsConfirmed;

				public String getStrCreativeCommonsConfirmed () {
					return this.strCreativeCommonsConfirmed;
				}
				
			    public String dateModified;

				public String getDateModified () {
					return this.dateModified;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this._id == null) ? 0 : this._id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final out1Struct other = (out1Struct) obj;
		
						if (this._id == null) {
							if (other._id != null)
								return false;
						
						} else if (!this._id.equals(other._id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other._id = this._id;
	            other.idMeal = this.idMeal;
	            other.strMeal = this.strMeal;
	            other.strCategory = this.strCategory;
	            other.strArea = this.strArea;
	            other.strInstructions = this.strInstructions;
	            other.strIngredient1 = this.strIngredient1;
	            other.strIngredient2 = this.strIngredient2;
	            other.strIngredient3 = this.strIngredient3;
	            other.strIngredient4 = this.strIngredient4;
	            other.strIngredient5 = this.strIngredient5;
	            other.strIngredient6 = this.strIngredient6;
	            other.strIngredient7 = this.strIngredient7;
	            other.strIngredient8 = this.strIngredient8;
	            other.strIngredient9 = this.strIngredient9;
	            other.strIngredient10 = this.strIngredient10;
	            other.strIngredient11 = this.strIngredient11;
	            other.strIngredient12 = this.strIngredient12;
	            other.strIngredient13 = this.strIngredient13;
	            other.strIngredient14 = this.strIngredient14;
	            other.strIngredient15 = this.strIngredient15;
	            other.strIngredient16 = this.strIngredient16;
	            other.strIngredient17 = this.strIngredient17;
	            other.strIngredient18 = this.strIngredient18;
	            other.strIngredient19 = this.strIngredient19;
	            other.strIngredient20 = this.strIngredient20;
	            other.strMeasure1 = this.strMeasure1;
	            other.strMeasure2 = this.strMeasure2;
	            other.strMeasure3 = this.strMeasure3;
	            other.strMeasure4 = this.strMeasure4;
	            other.strMeasure5 = this.strMeasure5;
	            other.strMeasure6 = this.strMeasure6;
	            other.strMeasure7 = this.strMeasure7;
	            other.strMeasure8 = this.strMeasure8;
	            other.strMeasure9 = this.strMeasure9;
	            other.strMeasure10 = this.strMeasure10;
	            other.strMeasure11 = this.strMeasure11;
	            other.strMeasure12 = this.strMeasure12;
	            other.strMeasure13 = this.strMeasure13;
	            other.strMeasure14 = this.strMeasure14;
	            other.strMeasure15 = this.strMeasure15;
	            other.strMeasure16 = this.strMeasure16;
	            other.strMeasure17 = this.strMeasure17;
	            other.strMeasure18 = this.strMeasure18;
	            other.strMeasure19 = this.strMeasure19;
	            other.strMeasure20 = this.strMeasure20;
	            other.strMealAlternate = this.strMealAlternate;
	            other.strMealThumb = this.strMealThumb;
	            other.strTags = this.strTags;
	            other.strYoutube = this.strYoutube;
	            other.strSource = this.strSource;
	            other.strImageSource = this.strImageSource;
	            other.strCreativeCommonsConfirmed = this.strCreativeCommonsConfirmed;
	            other.dateModified = this.dateModified;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other._id = this._id;
	            	
	}



	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadBronzeTMDB.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadBronzeTMDB.length == 0) {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadBronzeTMDB.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadBronzeTMDB.length == 0) {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadBronzeTMDB) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.idMeal = readString(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strArea = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.strIngredient1 = readString(dis);
					
					this.strIngredient2 = readString(dis);
					
					this.strIngredient3 = readString(dis);
					
					this.strIngredient4 = readString(dis);
					
					this.strIngredient5 = readString(dis);
					
					this.strIngredient6 = readString(dis);
					
					this.strIngredient7 = readString(dis);
					
					this.strIngredient8 = readString(dis);
					
					this.strIngredient9 = readString(dis);
					
					this.strIngredient10 = readString(dis);
					
					this.strIngredient11 = readString(dis);
					
					this.strIngredient12 = readString(dis);
					
					this.strIngredient13 = readString(dis);
					
					this.strIngredient14 = readString(dis);
					
					this.strIngredient15 = readString(dis);
					
					this.strIngredient16 = readString(dis);
					
					this.strIngredient17 = readString(dis);
					
					this.strIngredient18 = readString(dis);
					
					this.strIngredient19 = readString(dis);
					
					this.strIngredient20 = readString(dis);
					
					this.strMeasure1 = readString(dis);
					
					this.strMeasure2 = readString(dis);
					
					this.strMeasure3 = readString(dis);
					
					this.strMeasure4 = readString(dis);
					
					this.strMeasure5 = readString(dis);
					
					this.strMeasure6 = readString(dis);
					
					this.strMeasure7 = readString(dis);
					
					this.strMeasure8 = readString(dis);
					
					this.strMeasure9 = readString(dis);
					
					this.strMeasure10 = readString(dis);
					
					this.strMeasure11 = readString(dis);
					
					this.strMeasure12 = readString(dis);
					
					this.strMeasure13 = readString(dis);
					
					this.strMeasure14 = readString(dis);
					
					this.strMeasure15 = readString(dis);
					
					this.strMeasure16 = readString(dis);
					
					this.strMeasure17 = readString(dis);
					
					this.strMeasure18 = readString(dis);
					
					this.strMeasure19 = readString(dis);
					
					this.strMeasure20 = readString(dis);
					
					this.strMealAlternate = readString(dis);
					
					this.strMealThumb = readString(dis);
					
					this.strTags = readString(dis);
					
					this.strYoutube = readString(dis);
					
					this.strSource = readString(dis);
					
					this.strImageSource = readString(dis);
					
					this.strCreativeCommonsConfirmed = readString(dis);
					
					this.dateModified = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadBronzeTMDB) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.idMeal = readString(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strArea = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.strIngredient1 = readString(dis);
					
					this.strIngredient2 = readString(dis);
					
					this.strIngredient3 = readString(dis);
					
					this.strIngredient4 = readString(dis);
					
					this.strIngredient5 = readString(dis);
					
					this.strIngredient6 = readString(dis);
					
					this.strIngredient7 = readString(dis);
					
					this.strIngredient8 = readString(dis);
					
					this.strIngredient9 = readString(dis);
					
					this.strIngredient10 = readString(dis);
					
					this.strIngredient11 = readString(dis);
					
					this.strIngredient12 = readString(dis);
					
					this.strIngredient13 = readString(dis);
					
					this.strIngredient14 = readString(dis);
					
					this.strIngredient15 = readString(dis);
					
					this.strIngredient16 = readString(dis);
					
					this.strIngredient17 = readString(dis);
					
					this.strIngredient18 = readString(dis);
					
					this.strIngredient19 = readString(dis);
					
					this.strIngredient20 = readString(dis);
					
					this.strMeasure1 = readString(dis);
					
					this.strMeasure2 = readString(dis);
					
					this.strMeasure3 = readString(dis);
					
					this.strMeasure4 = readString(dis);
					
					this.strMeasure5 = readString(dis);
					
					this.strMeasure6 = readString(dis);
					
					this.strMeasure7 = readString(dis);
					
					this.strMeasure8 = readString(dis);
					
					this.strMeasure9 = readString(dis);
					
					this.strMeasure10 = readString(dis);
					
					this.strMeasure11 = readString(dis);
					
					this.strMeasure12 = readString(dis);
					
					this.strMeasure13 = readString(dis);
					
					this.strMeasure14 = readString(dis);
					
					this.strMeasure15 = readString(dis);
					
					this.strMeasure16 = readString(dis);
					
					this.strMeasure17 = readString(dis);
					
					this.strMeasure18 = readString(dis);
					
					this.strMeasure19 = readString(dis);
					
					this.strMeasure20 = readString(dis);
					
					this.strMealAlternate = readString(dis);
					
					this.strMealThumb = readString(dis);
					
					this.strTags = readString(dis);
					
					this.strYoutube = readString(dis);
					
					this.strSource = readString(dis);
					
					this.strImageSource = readString(dis);
					
					this.strCreativeCommonsConfirmed = readString(dis);
					
					this.dateModified = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this._id,dos);
					
					// String
				
						writeString(this.idMeal,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strArea,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.strIngredient1,dos);
					
					// String
				
						writeString(this.strIngredient2,dos);
					
					// String
				
						writeString(this.strIngredient3,dos);
					
					// String
				
						writeString(this.strIngredient4,dos);
					
					// String
				
						writeString(this.strIngredient5,dos);
					
					// String
				
						writeString(this.strIngredient6,dos);
					
					// String
				
						writeString(this.strIngredient7,dos);
					
					// String
				
						writeString(this.strIngredient8,dos);
					
					// String
				
						writeString(this.strIngredient9,dos);
					
					// String
				
						writeString(this.strIngredient10,dos);
					
					// String
				
						writeString(this.strIngredient11,dos);
					
					// String
				
						writeString(this.strIngredient12,dos);
					
					// String
				
						writeString(this.strIngredient13,dos);
					
					// String
				
						writeString(this.strIngredient14,dos);
					
					// String
				
						writeString(this.strIngredient15,dos);
					
					// String
				
						writeString(this.strIngredient16,dos);
					
					// String
				
						writeString(this.strIngredient17,dos);
					
					// String
				
						writeString(this.strIngredient18,dos);
					
					// String
				
						writeString(this.strIngredient19,dos);
					
					// String
				
						writeString(this.strIngredient20,dos);
					
					// String
				
						writeString(this.strMeasure1,dos);
					
					// String
				
						writeString(this.strMeasure2,dos);
					
					// String
				
						writeString(this.strMeasure3,dos);
					
					// String
				
						writeString(this.strMeasure4,dos);
					
					// String
				
						writeString(this.strMeasure5,dos);
					
					// String
				
						writeString(this.strMeasure6,dos);
					
					// String
				
						writeString(this.strMeasure7,dos);
					
					// String
				
						writeString(this.strMeasure8,dos);
					
					// String
				
						writeString(this.strMeasure9,dos);
					
					// String
				
						writeString(this.strMeasure10,dos);
					
					// String
				
						writeString(this.strMeasure11,dos);
					
					// String
				
						writeString(this.strMeasure12,dos);
					
					// String
				
						writeString(this.strMeasure13,dos);
					
					// String
				
						writeString(this.strMeasure14,dos);
					
					// String
				
						writeString(this.strMeasure15,dos);
					
					// String
				
						writeString(this.strMeasure16,dos);
					
					// String
				
						writeString(this.strMeasure17,dos);
					
					// String
				
						writeString(this.strMeasure18,dos);
					
					// String
				
						writeString(this.strMeasure19,dos);
					
					// String
				
						writeString(this.strMeasure20,dos);
					
					// String
				
						writeString(this.strMealAlternate,dos);
					
					// String
				
						writeString(this.strMealThumb,dos);
					
					// String
				
						writeString(this.strTags,dos);
					
					// String
				
						writeString(this.strYoutube,dos);
					
					// String
				
						writeString(this.strSource,dos);
					
					// String
				
						writeString(this.strImageSource,dos);
					
					// String
				
						writeString(this.strCreativeCommonsConfirmed,dos);
					
					// String
				
						writeString(this.dateModified,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this._id,dos);
					
					// String
				
						writeString(this.idMeal,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strArea,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.strIngredient1,dos);
					
					// String
				
						writeString(this.strIngredient2,dos);
					
					// String
				
						writeString(this.strIngredient3,dos);
					
					// String
				
						writeString(this.strIngredient4,dos);
					
					// String
				
						writeString(this.strIngredient5,dos);
					
					// String
				
						writeString(this.strIngredient6,dos);
					
					// String
				
						writeString(this.strIngredient7,dos);
					
					// String
				
						writeString(this.strIngredient8,dos);
					
					// String
				
						writeString(this.strIngredient9,dos);
					
					// String
				
						writeString(this.strIngredient10,dos);
					
					// String
				
						writeString(this.strIngredient11,dos);
					
					// String
				
						writeString(this.strIngredient12,dos);
					
					// String
				
						writeString(this.strIngredient13,dos);
					
					// String
				
						writeString(this.strIngredient14,dos);
					
					// String
				
						writeString(this.strIngredient15,dos);
					
					// String
				
						writeString(this.strIngredient16,dos);
					
					// String
				
						writeString(this.strIngredient17,dos);
					
					// String
				
						writeString(this.strIngredient18,dos);
					
					// String
				
						writeString(this.strIngredient19,dos);
					
					// String
				
						writeString(this.strIngredient20,dos);
					
					// String
				
						writeString(this.strMeasure1,dos);
					
					// String
				
						writeString(this.strMeasure2,dos);
					
					// String
				
						writeString(this.strMeasure3,dos);
					
					// String
				
						writeString(this.strMeasure4,dos);
					
					// String
				
						writeString(this.strMeasure5,dos);
					
					// String
				
						writeString(this.strMeasure6,dos);
					
					// String
				
						writeString(this.strMeasure7,dos);
					
					// String
				
						writeString(this.strMeasure8,dos);
					
					// String
				
						writeString(this.strMeasure9,dos);
					
					// String
				
						writeString(this.strMeasure10,dos);
					
					// String
				
						writeString(this.strMeasure11,dos);
					
					// String
				
						writeString(this.strMeasure12,dos);
					
					// String
				
						writeString(this.strMeasure13,dos);
					
					// String
				
						writeString(this.strMeasure14,dos);
					
					// String
				
						writeString(this.strMeasure15,dos);
					
					// String
				
						writeString(this.strMeasure16,dos);
					
					// String
				
						writeString(this.strMeasure17,dos);
					
					// String
				
						writeString(this.strMeasure18,dos);
					
					// String
				
						writeString(this.strMeasure19,dos);
					
					// String
				
						writeString(this.strMeasure20,dos);
					
					// String
				
						writeString(this.strMealAlternate,dos);
					
					// String
				
						writeString(this.strMealThumb,dos);
					
					// String
				
						writeString(this.strTags,dos);
					
					// String
				
						writeString(this.strYoutube,dos);
					
					// String
				
						writeString(this.strSource,dos);
					
					// String
				
						writeString(this.strImageSource,dos);
					
					// String
				
						writeString(this.strCreativeCommonsConfirmed,dos);
					
					// String
				
						writeString(this.dateModified,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("_id="+String.valueOf(_id));
		sb.append(",idMeal="+idMeal);
		sb.append(",strMeal="+strMeal);
		sb.append(",strCategory="+strCategory);
		sb.append(",strArea="+strArea);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",strIngredient1="+strIngredient1);
		sb.append(",strIngredient2="+strIngredient2);
		sb.append(",strIngredient3="+strIngredient3);
		sb.append(",strIngredient4="+strIngredient4);
		sb.append(",strIngredient5="+strIngredient5);
		sb.append(",strIngredient6="+strIngredient6);
		sb.append(",strIngredient7="+strIngredient7);
		sb.append(",strIngredient8="+strIngredient8);
		sb.append(",strIngredient9="+strIngredient9);
		sb.append(",strIngredient10="+strIngredient10);
		sb.append(",strIngredient11="+strIngredient11);
		sb.append(",strIngredient12="+strIngredient12);
		sb.append(",strIngredient13="+strIngredient13);
		sb.append(",strIngredient14="+strIngredient14);
		sb.append(",strIngredient15="+strIngredient15);
		sb.append(",strIngredient16="+strIngredient16);
		sb.append(",strIngredient17="+strIngredient17);
		sb.append(",strIngredient18="+strIngredient18);
		sb.append(",strIngredient19="+strIngredient19);
		sb.append(",strIngredient20="+strIngredient20);
		sb.append(",strMeasure1="+strMeasure1);
		sb.append(",strMeasure2="+strMeasure2);
		sb.append(",strMeasure3="+strMeasure3);
		sb.append(",strMeasure4="+strMeasure4);
		sb.append(",strMeasure5="+strMeasure5);
		sb.append(",strMeasure6="+strMeasure6);
		sb.append(",strMeasure7="+strMeasure7);
		sb.append(",strMeasure8="+strMeasure8);
		sb.append(",strMeasure9="+strMeasure9);
		sb.append(",strMeasure10="+strMeasure10);
		sb.append(",strMeasure11="+strMeasure11);
		sb.append(",strMeasure12="+strMeasure12);
		sb.append(",strMeasure13="+strMeasure13);
		sb.append(",strMeasure14="+strMeasure14);
		sb.append(",strMeasure15="+strMeasure15);
		sb.append(",strMeasure16="+strMeasure16);
		sb.append(",strMeasure17="+strMeasure17);
		sb.append(",strMeasure18="+strMeasure18);
		sb.append(",strMeasure19="+strMeasure19);
		sb.append(",strMeasure20="+strMeasure20);
		sb.append(",strMealAlternate="+strMealAlternate);
		sb.append(",strMealThumb="+strMealThumb);
		sb.append(",strTags="+strTags);
		sb.append(",strYoutube="+strYoutube);
		sb.append(",strSource="+strSource);
		sb.append(",strImageSource="+strImageSource);
		sb.append(",strCreativeCommonsConfirmed="+strCreativeCommonsConfirmed);
		sb.append(",dateModified="+dateModified);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this._id, other._id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadBronzeTMDB = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadBronzeTMDB = new byte[0];

	
			    public String idMeal;

				public String getIdMeal () {
					return this.idMeal;
				}
				
			    public String strMeal;

				public String getStrMeal () {
					return this.strMeal;
				}
				
			    public String strCategory;

				public String getStrCategory () {
					return this.strCategory;
				}
				
			    public String strArea;

				public String getStrArea () {
					return this.strArea;
				}
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String strIngredient1;

				public String getStrIngredient1 () {
					return this.strIngredient1;
				}
				
			    public String strIngredient2;

				public String getStrIngredient2 () {
					return this.strIngredient2;
				}
				
			    public String strIngredient3;

				public String getStrIngredient3 () {
					return this.strIngredient3;
				}
				
			    public String strIngredient4;

				public String getStrIngredient4 () {
					return this.strIngredient4;
				}
				
			    public String strIngredient5;

				public String getStrIngredient5 () {
					return this.strIngredient5;
				}
				
			    public String strIngredient6;

				public String getStrIngredient6 () {
					return this.strIngredient6;
				}
				
			    public String strIngredient7;

				public String getStrIngredient7 () {
					return this.strIngredient7;
				}
				
			    public String strIngredient8;

				public String getStrIngredient8 () {
					return this.strIngredient8;
				}
				
			    public String strIngredient9;

				public String getStrIngredient9 () {
					return this.strIngredient9;
				}
				
			    public String strIngredient10;

				public String getStrIngredient10 () {
					return this.strIngredient10;
				}
				
			    public String strIngredient11;

				public String getStrIngredient11 () {
					return this.strIngredient11;
				}
				
			    public String strIngredient12;

				public String getStrIngredient12 () {
					return this.strIngredient12;
				}
				
			    public String strIngredient13;

				public String getStrIngredient13 () {
					return this.strIngredient13;
				}
				
			    public String strIngredient14;

				public String getStrIngredient14 () {
					return this.strIngredient14;
				}
				
			    public String strIngredient15;

				public String getStrIngredient15 () {
					return this.strIngredient15;
				}
				
			    public String strIngredient16;

				public String getStrIngredient16 () {
					return this.strIngredient16;
				}
				
			    public String strIngredient17;

				public String getStrIngredient17 () {
					return this.strIngredient17;
				}
				
			    public String strIngredient18;

				public String getStrIngredient18 () {
					return this.strIngredient18;
				}
				
			    public String strIngredient19;

				public String getStrIngredient19 () {
					return this.strIngredient19;
				}
				
			    public String strIngredient20;

				public String getStrIngredient20 () {
					return this.strIngredient20;
				}
				
			    public String strMeasure1;

				public String getStrMeasure1 () {
					return this.strMeasure1;
				}
				
			    public String strMeasure2;

				public String getStrMeasure2 () {
					return this.strMeasure2;
				}
				
			    public String strMeasure3;

				public String getStrMeasure3 () {
					return this.strMeasure3;
				}
				
			    public String strMeasure4;

				public String getStrMeasure4 () {
					return this.strMeasure4;
				}
				
			    public String strMeasure5;

				public String getStrMeasure5 () {
					return this.strMeasure5;
				}
				
			    public String strMeasure6;

				public String getStrMeasure6 () {
					return this.strMeasure6;
				}
				
			    public String strMeasure7;

				public String getStrMeasure7 () {
					return this.strMeasure7;
				}
				
			    public String strMeasure8;

				public String getStrMeasure8 () {
					return this.strMeasure8;
				}
				
			    public String strMeasure9;

				public String getStrMeasure9 () {
					return this.strMeasure9;
				}
				
			    public String strMeasure10;

				public String getStrMeasure10 () {
					return this.strMeasure10;
				}
				
			    public String strMeasure11;

				public String getStrMeasure11 () {
					return this.strMeasure11;
				}
				
			    public String strMeasure12;

				public String getStrMeasure12 () {
					return this.strMeasure12;
				}
				
			    public String strMeasure13;

				public String getStrMeasure13 () {
					return this.strMeasure13;
				}
				
			    public String strMeasure14;

				public String getStrMeasure14 () {
					return this.strMeasure14;
				}
				
			    public String strMeasure15;

				public String getStrMeasure15 () {
					return this.strMeasure15;
				}
				
			    public String strMeasure16;

				public String getStrMeasure16 () {
					return this.strMeasure16;
				}
				
			    public String strMeasure17;

				public String getStrMeasure17 () {
					return this.strMeasure17;
				}
				
			    public String strMeasure18;

				public String getStrMeasure18 () {
					return this.strMeasure18;
				}
				
			    public String strMeasure19;

				public String getStrMeasure19 () {
					return this.strMeasure19;
				}
				
			    public String strMeasure20;

				public String getStrMeasure20 () {
					return this.strMeasure20;
				}
				
			    public String strMealAlternate;

				public String getStrMealAlternate () {
					return this.strMealAlternate;
				}
				
			    public String strMealThumb;

				public String getStrMealThumb () {
					return this.strMealThumb;
				}
				
			    public String strTags;

				public String getStrTags () {
					return this.strTags;
				}
				
			    public String strYoutube;

				public String getStrYoutube () {
					return this.strYoutube;
				}
				
			    public String strSource;

				public String getStrSource () {
					return this.strSource;
				}
				
			    public String strImageSource;

				public String getStrImageSource () {
					return this.strImageSource;
				}
				
			    public String strCreativeCommonsConfirmed;

				public String getStrCreativeCommonsConfirmed () {
					return this.strCreativeCommonsConfirmed;
				}
				
			    public String dateModified;

				public String getDateModified () {
					return this.dateModified;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadBronzeTMDB.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadBronzeTMDB.length == 0) {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadBronzeTMDB.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadBronzeTMDB.length == 0) {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadBronzeTMDB) {

        	try {

        		int length = 0;
		
					this.idMeal = readString(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strArea = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.strIngredient1 = readString(dis);
					
					this.strIngredient2 = readString(dis);
					
					this.strIngredient3 = readString(dis);
					
					this.strIngredient4 = readString(dis);
					
					this.strIngredient5 = readString(dis);
					
					this.strIngredient6 = readString(dis);
					
					this.strIngredient7 = readString(dis);
					
					this.strIngredient8 = readString(dis);
					
					this.strIngredient9 = readString(dis);
					
					this.strIngredient10 = readString(dis);
					
					this.strIngredient11 = readString(dis);
					
					this.strIngredient12 = readString(dis);
					
					this.strIngredient13 = readString(dis);
					
					this.strIngredient14 = readString(dis);
					
					this.strIngredient15 = readString(dis);
					
					this.strIngredient16 = readString(dis);
					
					this.strIngredient17 = readString(dis);
					
					this.strIngredient18 = readString(dis);
					
					this.strIngredient19 = readString(dis);
					
					this.strIngredient20 = readString(dis);
					
					this.strMeasure1 = readString(dis);
					
					this.strMeasure2 = readString(dis);
					
					this.strMeasure3 = readString(dis);
					
					this.strMeasure4 = readString(dis);
					
					this.strMeasure5 = readString(dis);
					
					this.strMeasure6 = readString(dis);
					
					this.strMeasure7 = readString(dis);
					
					this.strMeasure8 = readString(dis);
					
					this.strMeasure9 = readString(dis);
					
					this.strMeasure10 = readString(dis);
					
					this.strMeasure11 = readString(dis);
					
					this.strMeasure12 = readString(dis);
					
					this.strMeasure13 = readString(dis);
					
					this.strMeasure14 = readString(dis);
					
					this.strMeasure15 = readString(dis);
					
					this.strMeasure16 = readString(dis);
					
					this.strMeasure17 = readString(dis);
					
					this.strMeasure18 = readString(dis);
					
					this.strMeasure19 = readString(dis);
					
					this.strMeasure20 = readString(dis);
					
					this.strMealAlternate = readString(dis);
					
					this.strMealThumb = readString(dis);
					
					this.strTags = readString(dis);
					
					this.strYoutube = readString(dis);
					
					this.strSource = readString(dis);
					
					this.strImageSource = readString(dis);
					
					this.strCreativeCommonsConfirmed = readString(dis);
					
					this.dateModified = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadBronzeTMDB) {

        	try {

        		int length = 0;
		
					this.idMeal = readString(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strArea = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.strIngredient1 = readString(dis);
					
					this.strIngredient2 = readString(dis);
					
					this.strIngredient3 = readString(dis);
					
					this.strIngredient4 = readString(dis);
					
					this.strIngredient5 = readString(dis);
					
					this.strIngredient6 = readString(dis);
					
					this.strIngredient7 = readString(dis);
					
					this.strIngredient8 = readString(dis);
					
					this.strIngredient9 = readString(dis);
					
					this.strIngredient10 = readString(dis);
					
					this.strIngredient11 = readString(dis);
					
					this.strIngredient12 = readString(dis);
					
					this.strIngredient13 = readString(dis);
					
					this.strIngredient14 = readString(dis);
					
					this.strIngredient15 = readString(dis);
					
					this.strIngredient16 = readString(dis);
					
					this.strIngredient17 = readString(dis);
					
					this.strIngredient18 = readString(dis);
					
					this.strIngredient19 = readString(dis);
					
					this.strIngredient20 = readString(dis);
					
					this.strMeasure1 = readString(dis);
					
					this.strMeasure2 = readString(dis);
					
					this.strMeasure3 = readString(dis);
					
					this.strMeasure4 = readString(dis);
					
					this.strMeasure5 = readString(dis);
					
					this.strMeasure6 = readString(dis);
					
					this.strMeasure7 = readString(dis);
					
					this.strMeasure8 = readString(dis);
					
					this.strMeasure9 = readString(dis);
					
					this.strMeasure10 = readString(dis);
					
					this.strMeasure11 = readString(dis);
					
					this.strMeasure12 = readString(dis);
					
					this.strMeasure13 = readString(dis);
					
					this.strMeasure14 = readString(dis);
					
					this.strMeasure15 = readString(dis);
					
					this.strMeasure16 = readString(dis);
					
					this.strMeasure17 = readString(dis);
					
					this.strMeasure18 = readString(dis);
					
					this.strMeasure19 = readString(dis);
					
					this.strMeasure20 = readString(dis);
					
					this.strMealAlternate = readString(dis);
					
					this.strMealThumb = readString(dis);
					
					this.strTags = readString(dis);
					
					this.strYoutube = readString(dis);
					
					this.strSource = readString(dis);
					
					this.strImageSource = readString(dis);
					
					this.strCreativeCommonsConfirmed = readString(dis);
					
					this.dateModified = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.idMeal,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strArea,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.strIngredient1,dos);
					
					// String
				
						writeString(this.strIngredient2,dos);
					
					// String
				
						writeString(this.strIngredient3,dos);
					
					// String
				
						writeString(this.strIngredient4,dos);
					
					// String
				
						writeString(this.strIngredient5,dos);
					
					// String
				
						writeString(this.strIngredient6,dos);
					
					// String
				
						writeString(this.strIngredient7,dos);
					
					// String
				
						writeString(this.strIngredient8,dos);
					
					// String
				
						writeString(this.strIngredient9,dos);
					
					// String
				
						writeString(this.strIngredient10,dos);
					
					// String
				
						writeString(this.strIngredient11,dos);
					
					// String
				
						writeString(this.strIngredient12,dos);
					
					// String
				
						writeString(this.strIngredient13,dos);
					
					// String
				
						writeString(this.strIngredient14,dos);
					
					// String
				
						writeString(this.strIngredient15,dos);
					
					// String
				
						writeString(this.strIngredient16,dos);
					
					// String
				
						writeString(this.strIngredient17,dos);
					
					// String
				
						writeString(this.strIngredient18,dos);
					
					// String
				
						writeString(this.strIngredient19,dos);
					
					// String
				
						writeString(this.strIngredient20,dos);
					
					// String
				
						writeString(this.strMeasure1,dos);
					
					// String
				
						writeString(this.strMeasure2,dos);
					
					// String
				
						writeString(this.strMeasure3,dos);
					
					// String
				
						writeString(this.strMeasure4,dos);
					
					// String
				
						writeString(this.strMeasure5,dos);
					
					// String
				
						writeString(this.strMeasure6,dos);
					
					// String
				
						writeString(this.strMeasure7,dos);
					
					// String
				
						writeString(this.strMeasure8,dos);
					
					// String
				
						writeString(this.strMeasure9,dos);
					
					// String
				
						writeString(this.strMeasure10,dos);
					
					// String
				
						writeString(this.strMeasure11,dos);
					
					// String
				
						writeString(this.strMeasure12,dos);
					
					// String
				
						writeString(this.strMeasure13,dos);
					
					// String
				
						writeString(this.strMeasure14,dos);
					
					// String
				
						writeString(this.strMeasure15,dos);
					
					// String
				
						writeString(this.strMeasure16,dos);
					
					// String
				
						writeString(this.strMeasure17,dos);
					
					// String
				
						writeString(this.strMeasure18,dos);
					
					// String
				
						writeString(this.strMeasure19,dos);
					
					// String
				
						writeString(this.strMeasure20,dos);
					
					// String
				
						writeString(this.strMealAlternate,dos);
					
					// String
				
						writeString(this.strMealThumb,dos);
					
					// String
				
						writeString(this.strTags,dos);
					
					// String
				
						writeString(this.strYoutube,dos);
					
					// String
				
						writeString(this.strSource,dos);
					
					// String
				
						writeString(this.strImageSource,dos);
					
					// String
				
						writeString(this.strCreativeCommonsConfirmed,dos);
					
					// String
				
						writeString(this.dateModified,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.idMeal,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strArea,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.strIngredient1,dos);
					
					// String
				
						writeString(this.strIngredient2,dos);
					
					// String
				
						writeString(this.strIngredient3,dos);
					
					// String
				
						writeString(this.strIngredient4,dos);
					
					// String
				
						writeString(this.strIngredient5,dos);
					
					// String
				
						writeString(this.strIngredient6,dos);
					
					// String
				
						writeString(this.strIngredient7,dos);
					
					// String
				
						writeString(this.strIngredient8,dos);
					
					// String
				
						writeString(this.strIngredient9,dos);
					
					// String
				
						writeString(this.strIngredient10,dos);
					
					// String
				
						writeString(this.strIngredient11,dos);
					
					// String
				
						writeString(this.strIngredient12,dos);
					
					// String
				
						writeString(this.strIngredient13,dos);
					
					// String
				
						writeString(this.strIngredient14,dos);
					
					// String
				
						writeString(this.strIngredient15,dos);
					
					// String
				
						writeString(this.strIngredient16,dos);
					
					// String
				
						writeString(this.strIngredient17,dos);
					
					// String
				
						writeString(this.strIngredient18,dos);
					
					// String
				
						writeString(this.strIngredient19,dos);
					
					// String
				
						writeString(this.strIngredient20,dos);
					
					// String
				
						writeString(this.strMeasure1,dos);
					
					// String
				
						writeString(this.strMeasure2,dos);
					
					// String
				
						writeString(this.strMeasure3,dos);
					
					// String
				
						writeString(this.strMeasure4,dos);
					
					// String
				
						writeString(this.strMeasure5,dos);
					
					// String
				
						writeString(this.strMeasure6,dos);
					
					// String
				
						writeString(this.strMeasure7,dos);
					
					// String
				
						writeString(this.strMeasure8,dos);
					
					// String
				
						writeString(this.strMeasure9,dos);
					
					// String
				
						writeString(this.strMeasure10,dos);
					
					// String
				
						writeString(this.strMeasure11,dos);
					
					// String
				
						writeString(this.strMeasure12,dos);
					
					// String
				
						writeString(this.strMeasure13,dos);
					
					// String
				
						writeString(this.strMeasure14,dos);
					
					// String
				
						writeString(this.strMeasure15,dos);
					
					// String
				
						writeString(this.strMeasure16,dos);
					
					// String
				
						writeString(this.strMeasure17,dos);
					
					// String
				
						writeString(this.strMeasure18,dos);
					
					// String
				
						writeString(this.strMeasure19,dos);
					
					// String
				
						writeString(this.strMeasure20,dos);
					
					// String
				
						writeString(this.strMealAlternate,dos);
					
					// String
				
						writeString(this.strMealThumb,dos);
					
					// String
				
						writeString(this.strTags,dos);
					
					// String
				
						writeString(this.strYoutube,dos);
					
					// String
				
						writeString(this.strSource,dos);
					
					// String
				
						writeString(this.strImageSource,dos);
					
					// String
				
						writeString(this.strCreativeCommonsConfirmed,dos);
					
					// String
				
						writeString(this.dateModified,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("idMeal="+idMeal);
		sb.append(",strMeal="+strMeal);
		sb.append(",strCategory="+strCategory);
		sb.append(",strArea="+strArea);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",strIngredient1="+strIngredient1);
		sb.append(",strIngredient2="+strIngredient2);
		sb.append(",strIngredient3="+strIngredient3);
		sb.append(",strIngredient4="+strIngredient4);
		sb.append(",strIngredient5="+strIngredient5);
		sb.append(",strIngredient6="+strIngredient6);
		sb.append(",strIngredient7="+strIngredient7);
		sb.append(",strIngredient8="+strIngredient8);
		sb.append(",strIngredient9="+strIngredient9);
		sb.append(",strIngredient10="+strIngredient10);
		sb.append(",strIngredient11="+strIngredient11);
		sb.append(",strIngredient12="+strIngredient12);
		sb.append(",strIngredient13="+strIngredient13);
		sb.append(",strIngredient14="+strIngredient14);
		sb.append(",strIngredient15="+strIngredient15);
		sb.append(",strIngredient16="+strIngredient16);
		sb.append(",strIngredient17="+strIngredient17);
		sb.append(",strIngredient18="+strIngredient18);
		sb.append(",strIngredient19="+strIngredient19);
		sb.append(",strIngredient20="+strIngredient20);
		sb.append(",strMeasure1="+strMeasure1);
		sb.append(",strMeasure2="+strMeasure2);
		sb.append(",strMeasure3="+strMeasure3);
		sb.append(",strMeasure4="+strMeasure4);
		sb.append(",strMeasure5="+strMeasure5);
		sb.append(",strMeasure6="+strMeasure6);
		sb.append(",strMeasure7="+strMeasure7);
		sb.append(",strMeasure8="+strMeasure8);
		sb.append(",strMeasure9="+strMeasure9);
		sb.append(",strMeasure10="+strMeasure10);
		sb.append(",strMeasure11="+strMeasure11);
		sb.append(",strMeasure12="+strMeasure12);
		sb.append(",strMeasure13="+strMeasure13);
		sb.append(",strMeasure14="+strMeasure14);
		sb.append(",strMeasure15="+strMeasure15);
		sb.append(",strMeasure16="+strMeasure16);
		sb.append(",strMeasure17="+strMeasure17);
		sb.append(",strMeasure18="+strMeasure18);
		sb.append(",strMeasure19="+strMeasure19);
		sb.append(",strMeasure20="+strMeasure20);
		sb.append(",strMealAlternate="+strMealAlternate);
		sb.append(",strMealThumb="+strMealThumb);
		sb.append(",strTags="+strTags);
		sb.append(",strYoutube="+strYoutube);
		sb.append(",strSource="+strSource);
		sb.append(",strImageSource="+strImageSource);
		sb.append(",strCreativeCommonsConfirmed="+strCreativeCommonsConfirmed);
		sb.append(",dateModified="+dateModified);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadBronzeTMDB = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadBronzeTMDB = new byte[0];

	
			    public String Body;

				public String getBody () {
					return this.Body;
				}
				
			    public Integer ERROR_CODE;

				public Integer getERROR_CODE () {
					return this.ERROR_CODE;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadBronzeTMDB.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadBronzeTMDB.length == 0) {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadBronzeTMDB.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadBronzeTMDB.length == 0) {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadBronzeTMDB = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadBronzeTMDB, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadBronzeTMDB) {

        	try {

        		int length = 0;
		
					this.Body = readString(dis);
					
						this.ERROR_CODE = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadBronzeTMDB) {

        	try {

        		int length = 0;
		
					this.Body = readString(dis);
					
						this.ERROR_CODE = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Body,dos);
					
					// Integer
				
						writeInteger(this.ERROR_CODE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Body,dos);
					
					// Integer
				
						writeInteger(this.ERROR_CODE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Body="+Body);
		sb.append(",ERROR_CODE="+String.valueOf(ERROR_CODE));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tREST_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tREST_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();
row2Struct row2 = new row2Struct();
out1Struct out1 = new out1Struct();






	
	/**
	 * [tMongoDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_1", false);
		start_Hash.put("tMongoDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out1");
					}
				
		int tos_count_tMongoDBOutput_1 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_1 = "Talend";

    int nb_line_tMongoDBOutput_1 = 0;

			class DBObjectUtil_tMongoDBOutput_1 {
				
				private org.bson.Document object = null;
				//Put value to embedded document
				//If have no embedded document, put the value to root document
				public void put(String parentNode, String curentName, Object value) {
					if (parentNode == null || "".equals(parentNode)) {
						object.put(curentName, value);
					} else {
						String objNames[]= parentNode.split("\\.");
						org.bson.Document lastNode = getParentNode(parentNode, objNames.length-1);
						lastNode.put(curentName, value);
						org.bson.Document parenttNode = null;
						for (int i = objNames.length - 1; i >=0; i--) {
							parenttNode=getParentNode(parentNode, i-1);
							parenttNode.put(objNames[i], lastNode);
							lastNode=clone(parenttNode);
						}
						object=lastNode;
					}
				}
				
				private org.bson.Document clone(org.bson.Document source){
					org.bson.Document to = new org.bson.Document();
					for(java.util.Map.Entry<String,Object> cur:source.entrySet()) {
						to.append(cur.getKey(), cur.getValue());
					}
					return to;
				}
				
				//Get node(embedded document) by path configuration
				public org.bson.Document getParentNode(String parentNode, int index) {
					org.bson.Document document = object;
					if (parentNode == null || "".equals(parentNode)) {
						return object;
					} else {
						String objNames[] = parentNode.split("\\.");
						for (int i = 0; i <= index; i++) {
							document = (org.bson.Document) document
									.get(objNames[i]);
							if (document == null) {
								document = new org.bson.Document();
								return document;
							}
							if (i == index) {
								break;
							}
						}
						return document;
					}
				}
				
				public void putkeyNode(String parentNode, String curentName, Object value){
					if (parentNode == null || "".equals(parentNode) || ".".equals(parentNode)) {
						put(parentNode, curentName, value);
					}else{
						put("", parentNode+"."+curentName, value);
					}
				}
			
				public org.bson.Document getObject() {
					return this.object;
				}
				
				public void setObject(org.bson.Document object){
					this.object=object;
				}
			
			}
            DBObjectUtil_tMongoDBOutput_1 updateObjectUtil_tMongoDBOutput_1=new DBObjectUtil_tMongoDBOutput_1();
            DBObjectUtil_tMongoDBOutput_1 queryObjectUtil_tMongoDBOutput_1=new DBObjectUtil_tMongoDBOutput_1();
            java.util.Map<String, String> pathMap_tMongoDBOutput_1=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_1.put("_id","");
                pathMap_tMongoDBOutput_1.put("idMeal","");
                pathMap_tMongoDBOutput_1.put("strMeal","");
                pathMap_tMongoDBOutput_1.put("strCategory","");
                pathMap_tMongoDBOutput_1.put("strArea","");
                pathMap_tMongoDBOutput_1.put("strInstructions","");
                pathMap_tMongoDBOutput_1.put("strIngredient1","");
                pathMap_tMongoDBOutput_1.put("strIngredient2","");
                pathMap_tMongoDBOutput_1.put("strIngredient3","");
                pathMap_tMongoDBOutput_1.put("strIngredient4","");
                pathMap_tMongoDBOutput_1.put("strIngredient5","");
                pathMap_tMongoDBOutput_1.put("strIngredient6","");
                pathMap_tMongoDBOutput_1.put("strIngredient7","");
                pathMap_tMongoDBOutput_1.put("strIngredient8","");
                pathMap_tMongoDBOutput_1.put("strIngredient9","");
                pathMap_tMongoDBOutput_1.put("strIngredient10","");
                pathMap_tMongoDBOutput_1.put("strIngredient11","");
                pathMap_tMongoDBOutput_1.put("strIngredient12","");
                pathMap_tMongoDBOutput_1.put("strIngredient13","");
                pathMap_tMongoDBOutput_1.put("strIngredient14","");
                pathMap_tMongoDBOutput_1.put("strIngredient15","");
                pathMap_tMongoDBOutput_1.put("strIngredient16","");
                pathMap_tMongoDBOutput_1.put("strIngredient17","");
                pathMap_tMongoDBOutput_1.put("strIngredient18","");
                pathMap_tMongoDBOutput_1.put("strIngredient19","");
                pathMap_tMongoDBOutput_1.put("strIngredient20","");
                pathMap_tMongoDBOutput_1.put("strMeasure1","");
                pathMap_tMongoDBOutput_1.put("strMeasure2","");
                pathMap_tMongoDBOutput_1.put("strMeasure3","");
                pathMap_tMongoDBOutput_1.put("strMeasure4","");
                pathMap_tMongoDBOutput_1.put("strMeasure5","");
                pathMap_tMongoDBOutput_1.put("strMeasure6","");
                pathMap_tMongoDBOutput_1.put("strMeasure7","");
                pathMap_tMongoDBOutput_1.put("strMeasure8","");
                pathMap_tMongoDBOutput_1.put("strMeasure9","");
                pathMap_tMongoDBOutput_1.put("strMeasure10","");
                pathMap_tMongoDBOutput_1.put("strMeasure11","");
                pathMap_tMongoDBOutput_1.put("strMeasure12","");
                pathMap_tMongoDBOutput_1.put("strMeasure13","");
                pathMap_tMongoDBOutput_1.put("strMeasure14","");
                pathMap_tMongoDBOutput_1.put("strMeasure15","");
                pathMap_tMongoDBOutput_1.put("strMeasure16","");
                pathMap_tMongoDBOutput_1.put("strMeasure17","");
                pathMap_tMongoDBOutput_1.put("strMeasure18","");
                pathMap_tMongoDBOutput_1.put("strMeasure19","");
                pathMap_tMongoDBOutput_1.put("strMeasure20","");
                pathMap_tMongoDBOutput_1.put("strMealAlternate","");
                pathMap_tMongoDBOutput_1.put("strMealThumb","");
                pathMap_tMongoDBOutput_1.put("strTags","");
                pathMap_tMongoDBOutput_1.put("strYoutube","");
                pathMap_tMongoDBOutput_1.put("strSource","");
                pathMap_tMongoDBOutput_1.put("strImageSource","");
                pathMap_tMongoDBOutput_1.put("strCreativeCommonsConfirmed","");
                pathMap_tMongoDBOutput_1.put("dateModified","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_1=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_1=null;

        mongo_tMongoDBOutput_1=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_1 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_1 = db_tMongoDBOutput_1.getCollection(context.mongodb_collection_bronze_tmdb);


 



/**
 * [tMongoDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
out1Struct out1_tmp = new out1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tExtractJSONFields_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tExtractJSONFields_1", false);
		start_Hash.put("tExtractJSONFields_1", System.currentTimeMillis());
		
	
	currentComponent="tExtractJSONFields_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tExtractJSONFields_1 = 0;
		

int nb_line_tExtractJSONFields_1 = 0;
String jsonStr_tExtractJSONFields_1 = "";

	

class JsonPathCache_tExtractJSONFields_1 {
	final java.util.Map<String,com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String,com.jayway.jsonpath.JsonPath>();
	
	public com.jayway.jsonpath.JsonPath getCompiledJsonPath(String jsonPath) {
		if(jsonPathString2compiledJsonPath.containsKey(jsonPath)) {
			return jsonPathString2compiledJsonPath.get(jsonPath);
		} else {
			com.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath.compile(jsonPath);
			jsonPathString2compiledJsonPath.put(jsonPath,compiledLoopPath);
			return compiledLoopPath;
		}
	}
}

JsonPathCache_tExtractJSONFields_1 jsonPathCache_tExtractJSONFields_1 = new JsonPathCache_tExtractJSONFields_1();

 



/**
 * [tExtractJSONFields_1 begin ] stop
 */



	
	/**
	 * [tREST_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tREST_1", false);
		start_Hash.put("tREST_1", System.currentTimeMillis());
		
	
	currentComponent="tREST_1";

	
		int tos_count_tREST_1 = 0;
		
	

	
	String endpoint_tREST_1 = context.source + context.letter;
	
	String trustStoreFile_tREST_1 = System.getProperty("javax.net.ssl.trustStore");
	String trustStoreType_tREST_1 = System.getProperty("javax.net.ssl.trustStoreType");
	String trustStorePWD_tREST_1 = System.getProperty("javax.net.ssl.trustStorePassword");
	
	String keyStoreFile_tREST_1 = System.getProperty("javax.net.ssl.keyStore");
	String keyStoreType_tREST_1 = System.getProperty("javax.net.ssl.keyStoreType");
	String keyStorePWD_tREST_1 = System.getProperty("javax.net.ssl.keyStorePassword");
	
	com.sun.jersey.api.client.config.ClientConfig config_tREST_1 = new com.sun.jersey.api.client.config.DefaultClientConfig();
	javax.net.ssl.SSLContext ctx_tREST_1 = javax.net.ssl.SSLContext.getInstance("SSL");
	
	javax.net.ssl.TrustManager[] tms_tREST_1 = null;
	if(trustStoreFile_tREST_1!=null && trustStoreType_tREST_1!=null){
		char[] password_tREST_1 = null;
		if(trustStorePWD_tREST_1!=null)
			password_tREST_1 = trustStorePWD_tREST_1.toCharArray();
		java.security.KeyStore trustStore_tREST_1 = java.security.KeyStore.getInstance(trustStoreType_tREST_1);
		trustStore_tREST_1.load(new java.io.FileInputStream(trustStoreFile_tREST_1), password_tREST_1);
		
		javax.net.ssl.TrustManagerFactory tmf_tREST_1 = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());
        tmf_tREST_1.init(trustStore_tREST_1);
        tms_tREST_1 = tmf_tREST_1.getTrustManagers();
	}
	
	javax.net.ssl.KeyManager[] kms_tREST_1 = null;
	if(keyStoreFile_tREST_1!=null && keyStoreType_tREST_1!=null){
		char[] password_tREST_1 = null;
		if(keyStorePWD_tREST_1!=null)
			password_tREST_1 = keyStorePWD_tREST_1.toCharArray();
		java.security.KeyStore keyStore_tREST_1 = java.security.KeyStore.getInstance(keyStoreType_tREST_1);
		keyStore_tREST_1.load(new java.io.FileInputStream(keyStoreFile_tREST_1), password_tREST_1);
		
		javax.net.ssl.KeyManagerFactory kmf_tREST_1 = javax.net.ssl.KeyManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());
        kmf_tREST_1.init(keyStore_tREST_1,password_tREST_1);
        kms_tREST_1 = kmf_tREST_1.getKeyManagers();
	}
	
    ctx_tREST_1.init(kms_tREST_1, tms_tREST_1 , null);
    config_tREST_1.getProperties().put(com.sun.jersey.client.urlconnection.HTTPSProperties.PROPERTY_HTTPS_PROPERTIES,
                new com.sun.jersey.client.urlconnection.HTTPSProperties(new javax.net.ssl.HostnameVerifier() {

                    public boolean verify(String hostName, javax.net.ssl.SSLSession session) {
                        return true;
                    }
                }, ctx_tREST_1));

	com.sun.jersey.api.client.Client restClient_tREST_1 = com.sun.jersey.api.client.Client.create(config_tREST_1);
	
	java.util.Map<String, Object> headers_tREST_1 = new java.util.HashMap<String, Object>();
	
	
	Object transfer_encoding_tREST_1 = headers_tREST_1.get("Transfer-Encoding");
	if(transfer_encoding_tREST_1!=null && "chunked".equals(transfer_encoding_tREST_1)) {
		restClient_tREST_1.setChunkedEncodingSize(4096);
	}
	
	com.sun.jersey.api.client.WebResource restResource_tREST_1;
	if(endpoint_tREST_1!=null && !("").equals(endpoint_tREST_1)){
		restResource_tREST_1 = restClient_tREST_1.resource(endpoint_tREST_1);
	}else{
		throw new IllegalArgumentException("url can't be empty!");
	}
	
	com.sun.jersey.api.client.ClientResponse errorResponse_tREST_1 = null;
	String restResponse_tREST_1 = "";
	try{
		
		com.sun.jersey.api.client.WebResource.Builder builder_tREST_1 = null;
		for(java.util.Map.Entry<String, Object> header_tREST_1 : headers_tREST_1.entrySet()) {
			if(builder_tREST_1 == null) {
				builder_tREST_1 = restResource_tREST_1.header(header_tREST_1.getKey(), header_tREST_1.getValue());
			} else {
				builder_tREST_1.header(header_tREST_1.getKey(), header_tREST_1.getValue());
			}
		}
		
		
			if(builder_tREST_1!=null) {
				restResponse_tREST_1 = builder_tREST_1.get(String.class);
			} else {
				restResponse_tREST_1 = restResource_tREST_1.get(String.class);
			} 
			
		
	}catch (com.sun.jersey.api.client.UniformInterfaceException ue) {
globalMap.put("tREST_1_ERROR_MESSAGE",ue.getMessage());
        errorResponse_tREST_1 = ue.getResponse();
    }
	
	// for output
			
				row1 = new row1Struct();
				if(errorResponse_tREST_1!=null){
					row1.ERROR_CODE = errorResponse_tREST_1.getStatus();
					if(row1.ERROR_CODE!=204){
					    row1.Body = errorResponse_tREST_1.getEntity(String.class);
					}
				}else{
					row1.Body = restResponse_tREST_1;
				}
			

 



/**
 * [tREST_1 begin ] stop
 */
	
	/**
	 * [tREST_1 main ] start
	 */

	

	
	
	currentComponent="tREST_1";

	

 


	tos_count_tREST_1++;

/**
 * [tREST_1 main ] stop
 */
	
	/**
	 * [tREST_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tREST_1";

	

 



/**
 * [tREST_1 process_data_begin ] stop
 */

	
	/**
	 * [tExtractJSONFields_1 main ] start
	 */

	

	
	
	currentComponent="tExtractJSONFields_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

            if(row1.Body!=null){// C_01
                jsonStr_tExtractJSONFields_1 = row1.Body.toString();
   
row2 = null;

	

String loopPath_tExtractJSONFields_1 = "$.meals[*]";
java.util.List<Object> resultset_tExtractJSONFields_1 = new java.util.ArrayList<Object>();

boolean isStructError_tExtractJSONFields_1 = true;
com.jayway.jsonpath.ReadContext document_tExtractJSONFields_1 = null;
try {
	document_tExtractJSONFields_1 = com.jayway.jsonpath.JsonPath.parse(jsonStr_tExtractJSONFields_1);
	com.jayway.jsonpath.JsonPath compiledLoopPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(loopPath_tExtractJSONFields_1);
	Object result_tExtractJSONFields_1 = document_tExtractJSONFields_1.read(compiledLoopPath_tExtractJSONFields_1,net.minidev.json.JSONObject.class);
	if (result_tExtractJSONFields_1 instanceof net.minidev.json.JSONArray) {
		resultset_tExtractJSONFields_1 = (net.minidev.json.JSONArray) result_tExtractJSONFields_1;
	} else {
		resultset_tExtractJSONFields_1.add(result_tExtractJSONFields_1);
	}
	
	isStructError_tExtractJSONFields_1 = false;
} catch (java.lang.Exception ex_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",ex_tExtractJSONFields_1.getMessage());
		System.err.println(ex_tExtractJSONFields_1.getMessage());
}

String jsonPath_tExtractJSONFields_1 = null;
com.jayway.jsonpath.JsonPath compiledJsonPath_tExtractJSONFields_1 = null;

Object value_tExtractJSONFields_1 = null;

Object root_tExtractJSONFields_1 = null;
for(int i_tExtractJSONFields_1=0; isStructError_tExtractJSONFields_1 || (i_tExtractJSONFields_1 < resultset_tExtractJSONFields_1.size());i_tExtractJSONFields_1++){
	if(!isStructError_tExtractJSONFields_1){
		Object row_tExtractJSONFields_1 = resultset_tExtractJSONFields_1.get(i_tExtractJSONFields_1);
            row2 = null;
	row2 = new row2Struct();
	nb_line_tExtractJSONFields_1++;
	try {
		jsonPath_tExtractJSONFields_1 = "$.idMeal";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.idMeal = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.idMeal = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeal";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeal = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeal = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strCategory";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strCategory = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strCategory = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strArea";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strArea = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strArea = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strInstructions";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strInstructions = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strInstructions = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient1";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient1 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient1 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient2";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient2 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient2 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient3";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient3 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient3 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient4";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient4 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient4 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient5";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient5 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient5 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient6";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient6 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient6 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient7";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient7 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient7 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient8";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient8 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient8 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient9";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient9 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient9 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient10";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient10 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient10 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient11";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient11 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient11 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient12";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient12 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient12 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient13";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient13 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient13 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient14";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient14 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient14 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient15";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient15 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient15 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient16";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient16 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient16 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient17";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient17 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient17 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient18";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient18 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient18 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient19";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient19 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient19 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strIngredient20";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strIngredient20 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strIngredient20 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure1";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure1 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure1 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure2";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure2 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure2 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure3";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure3 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure3 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure4";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure4 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure4 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure5";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure5 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure5 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure6";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure6 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure6 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure7";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure7 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure7 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure8";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure8 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure8 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure9";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure9 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure9 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure10";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure10 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure10 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure11";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure11 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure11 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure12";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure12 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure12 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure13";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure13 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure13 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure14";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure14 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure14 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure15";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure15 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure15 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure16";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure16 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure16 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure17";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure17 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure17 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure18";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure18 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure18 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure19";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure19 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure19 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMeasure20";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMeasure20 = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMeasure20 = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.str.MealAlternate";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMealAlternate = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMealAlternate = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strMealThumb";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strMealThumb = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strMealThumb = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strTags";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strTags = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strTags = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strYoutube";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strYoutube = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strYoutube = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strSource";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strSource = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strSource = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strImageSource";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strImageSource = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strImageSource = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.strCreativeCommonsConfirmed";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.strCreativeCommonsConfirmed = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.strCreativeCommonsConfirmed = 

		null

;
		}
		jsonPath_tExtractJSONFields_1 = "$.dateModified";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row2.dateModified = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row2.dateModified = 

		null

;
		}	
	} catch (java.lang.Exception ex_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",ex_tExtractJSONFields_1.getMessage());
		    System.err.println(ex_tExtractJSONFields_1.getMessage());
		    row2 = null;	
	}
	
	}
    
	isStructError_tExtractJSONFields_1 = false;
	
//}


 


	tos_count_tExtractJSONFields_1++;

/**
 * [tExtractJSONFields_1 main ] stop
 */
	
	/**
	 * [tExtractJSONFields_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tExtractJSONFields_1";

	

 



/**
 * [tExtractJSONFields_1 process_data_begin ] stop
 */
// Start of branch "row2"
if(row2 != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;


// # Output table : 'out1'
out1_tmp._id = Numeric.sequence("s1", 1, 1);
out1_tmp.idMeal = row2.idMeal ;
out1_tmp.strMeal = row2.strMeal ;
out1_tmp.strCategory = row2.strCategory ;
out1_tmp.strArea = row2.strArea ;
out1_tmp.strInstructions = row2.strInstructions ;
out1_tmp.strIngredient1 = row2.strIngredient1 ;
out1_tmp.strIngredient2 = row2.strIngredient2 ;
out1_tmp.strIngredient3 = row2.strIngredient3 ;
out1_tmp.strIngredient4 = row2.strIngredient4 ;
out1_tmp.strIngredient5 = row2.strIngredient5 ;
out1_tmp.strIngredient6 = row2.strIngredient6 ;
out1_tmp.strIngredient7 = row2.strIngredient7 ;
out1_tmp.strIngredient8 = row2.strIngredient8 ;
out1_tmp.strIngredient9 = row2.strIngredient9 ;
out1_tmp.strIngredient10 = row2.strIngredient10 ;
out1_tmp.strIngredient11 = row2.strIngredient11 ;
out1_tmp.strIngredient12 = row2.strIngredient12 ;
out1_tmp.strIngredient13 = row2.strIngredient13 ;
out1_tmp.strIngredient14 = row2.strIngredient14 ;
out1_tmp.strIngredient15 = row2.strIngredient15 ;
out1_tmp.strIngredient16 = row2.strIngredient16 ;
out1_tmp.strIngredient17 = row2.strIngredient17 ;
out1_tmp.strIngredient18 = row2.strIngredient18 ;
out1_tmp.strIngredient19 = row2.strIngredient19 ;
out1_tmp.strIngredient20 = row2.strIngredient20 ;
out1_tmp.strMeasure1 = row2.strMeasure1 ;
out1_tmp.strMeasure2 = row2.strMeasure2 ;
out1_tmp.strMeasure3 = row2.strMeasure3 ;
out1_tmp.strMeasure4 = row2.strMeasure4 ;
out1_tmp.strMeasure5 = row2.strMeasure5 ;
out1_tmp.strMeasure6 = row2.strMeasure6 ;
out1_tmp.strMeasure7 = row2.strMeasure7 ;
out1_tmp.strMeasure8 = row2.strMeasure8 ;
out1_tmp.strMeasure9 = row2.strMeasure9 ;
out1_tmp.strMeasure10 = row2.strMeasure10 ;
out1_tmp.strMeasure11 = row2.strMeasure11 ;
out1_tmp.strMeasure12 = row2.strMeasure12 ;
out1_tmp.strMeasure13 = row2.strMeasure13 ;
out1_tmp.strMeasure14 = row2.strMeasure14 ;
out1_tmp.strMeasure15 = row2.strMeasure15 ;
out1_tmp.strMeasure16 = row2.strMeasure16 ;
out1_tmp.strMeasure17 = row2.strMeasure17 ;
out1_tmp.strMeasure18 = row2.strMeasure18 ;
out1_tmp.strMeasure19 = row2.strMeasure19 ;
out1_tmp.strMeasure20 = row2.strMeasure20 ;
out1_tmp.strMealAlternate = row2.strMealAlternate ;
out1_tmp.strMealThumb = row2.strMealThumb ;
out1_tmp.strTags = row2.strTags ;
out1_tmp.strYoutube = row2.strYoutube ;
out1_tmp.strSource = row2.strSource ;
out1_tmp.strImageSource = row2.strImageSource ;
out1_tmp.strCreativeCommonsConfirmed = row2.strCreativeCommonsConfirmed ;
out1_tmp.dateModified = row2.dateModified ;
out1 = out1_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "out1"
if(out1 != null) { 



	
	/**
	 * [tMongoDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out1"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_1.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("_id"),"_id", out1._id);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("idMeal"),"idMeal", out1.idMeal);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeal"),"strMeal", out1.strMeal);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strCategory"),"strCategory", out1.strCategory);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strArea"),"strArea", out1.strArea);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strInstructions"),"strInstructions", out1.strInstructions);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient1"),"strIngredient1", out1.strIngredient1);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient2"),"strIngredient2", out1.strIngredient2);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient3"),"strIngredient3", out1.strIngredient3);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient4"),"strIngredient4", out1.strIngredient4);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient5"),"strIngredient5", out1.strIngredient5);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient6"),"strIngredient6", out1.strIngredient6);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient7"),"strIngredient7", out1.strIngredient7);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient8"),"strIngredient8", out1.strIngredient8);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient9"),"strIngredient9", out1.strIngredient9);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient10"),"strIngredient10", out1.strIngredient10);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient11"),"strIngredient11", out1.strIngredient11);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient12"),"strIngredient12", out1.strIngredient12);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient13"),"strIngredient13", out1.strIngredient13);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient14"),"strIngredient14", out1.strIngredient14);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient15"),"strIngredient15", out1.strIngredient15);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient16"),"strIngredient16", out1.strIngredient16);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient17"),"strIngredient17", out1.strIngredient17);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient18"),"strIngredient18", out1.strIngredient18);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient19"),"strIngredient19", out1.strIngredient19);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strIngredient20"),"strIngredient20", out1.strIngredient20);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure1"),"strMeasure1", out1.strMeasure1);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure2"),"strMeasure2", out1.strMeasure2);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure3"),"strMeasure3", out1.strMeasure3);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure4"),"strMeasure4", out1.strMeasure4);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure5"),"strMeasure5", out1.strMeasure5);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure6"),"strMeasure6", out1.strMeasure6);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure7"),"strMeasure7", out1.strMeasure7);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure8"),"strMeasure8", out1.strMeasure8);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure9"),"strMeasure9", out1.strMeasure9);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure10"),"strMeasure10", out1.strMeasure10);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure11"),"strMeasure11", out1.strMeasure11);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure12"),"strMeasure12", out1.strMeasure12);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure13"),"strMeasure13", out1.strMeasure13);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure14"),"strMeasure14", out1.strMeasure14);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure15"),"strMeasure15", out1.strMeasure15);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure16"),"strMeasure16", out1.strMeasure16);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure17"),"strMeasure17", out1.strMeasure17);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure18"),"strMeasure18", out1.strMeasure18);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure19"),"strMeasure19", out1.strMeasure19);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeasure20"),"strMeasure20", out1.strMeasure20);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMealAlternate"),"strMealAlternate", out1.strMealAlternate);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMealThumb"),"strMealThumb", out1.strMealThumb);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strTags"),"strTags", out1.strTags);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strYoutube"),"strYoutube", out1.strYoutube);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strSource"),"strSource", out1.strSource);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strImageSource"),"strImageSource", out1.strImageSource);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strCreativeCommonsConfirmed"),"strCreativeCommonsConfirmed", out1.strCreativeCommonsConfirmed);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("dateModified"),"dateModified", out1.dateModified);
				org.bson.Document updateObj_tMongoDBOutput_1 = updateObjectUtil_tMongoDBOutput_1.getObject();
				
						coll_tMongoDBOutput_1.insertOne(updateObj_tMongoDBOutput_1);
					
				} catch (Exception e_tMongoDBOutput_1) {
				
    					
    						System.err.println(e_tMongoDBOutput_1.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_1 ++;
				
 


	tos_count_tMongoDBOutput_1++;

/**
 * [tMongoDBOutput_1 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	

 



/**
 * [tMongoDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	

 



/**
 * [tMongoDBOutput_1 process_data_end ] stop
 */

} // End of branch "out1"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */

} // End of branch "row2"

		// end for
	}


	
		} // C_01
	
	
	/**
	 * [tExtractJSONFields_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tExtractJSONFields_1";

	

 



/**
 * [tExtractJSONFields_1 process_data_end ] stop
 */



	
	/**
	 * [tREST_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tREST_1";

	

 



/**
 * [tREST_1 process_data_end ] stop
 */
	
	/**
	 * [tREST_1 end ] start
	 */

	

	
	
	currentComponent="tREST_1";

	

 

ok_Hash.put("tREST_1", true);
end_Hash.put("tREST_1", System.currentTimeMillis());




/**
 * [tREST_1 end ] stop
 */

	
	/**
	 * [tExtractJSONFields_1 end ] start
	 */

	

	
	
	currentComponent="tExtractJSONFields_1";

	
   globalMap.put("tExtractJSONFields_1_NB_LINE", nb_line_tExtractJSONFields_1);


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tExtractJSONFields_1", true);
end_Hash.put("tExtractJSONFields_1", System.currentTimeMillis());




/**
 * [tExtractJSONFields_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	

	globalMap.put("tMongoDBOutput_1_NB_LINE", nb_line_tMongoDBOutput_1);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out1");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_1", true);
end_Hash.put("tMongoDBOutput_1", System.currentTimeMillis());




/**
 * [tMongoDBOutput_1 end ] stop
 */









				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tREST_1 finally ] start
	 */

	

	
	
	currentComponent="tREST_1";

	

 



/**
 * [tREST_1 finally ] stop
 */

	
	/**
	 * [tExtractJSONFields_1 finally ] start
	 */

	

	
	
	currentComponent="tExtractJSONFields_1";

	

 



/**
 * [tExtractJSONFields_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	


 



/**
 * [tMongoDBOutput_1 finally ] stop
 */









				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tREST_1_SUBPROCESS_STATE", 1);
	}
	

public void tMongoDBClose_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBClose_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tMongoDBClose_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBClose_1", false);
		start_Hash.put("tMongoDBClose_1", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBClose_1";

	
		int tos_count_tMongoDBClose_1 = 0;
		

 



/**
 * [tMongoDBClose_1 begin ] stop
 */
	
	/**
	 * [tMongoDBClose_1 main ] start
	 */

	

	
	
	currentComponent="tMongoDBClose_1";

	
        com.mongodb.client.MongoClient mongo_tMongoDBClose_1=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        if(mongo_tMongoDBClose_1 != null ) {
            mongo_tMongoDBClose_1.close();
        }



 


	tos_count_tMongoDBClose_1++;

/**
 * [tMongoDBClose_1 main ] stop
 */
	
	/**
	 * [tMongoDBClose_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBClose_1";

	

 



/**
 * [tMongoDBClose_1 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBClose_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBClose_1";

	

 



/**
 * [tMongoDBClose_1 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBClose_1 end ] start
	 */

	

	
	
	currentComponent="tMongoDBClose_1";

	

 

ok_Hash.put("tMongoDBClose_1", true);
end_Hash.put("tMongoDBClose_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
				}
				tWarn_2Process(globalMap);



/**
 * [tMongoDBClose_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tMongoDBClose_1 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBClose_1";

	

 



/**
 * [tMongoDBClose_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tMongoDBClose_1_SUBPROCESS_STATE", 1);
	}
	

public void tWarn_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tWarn_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tWarn_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tWarn_2", false);
		start_Hash.put("tWarn_2", System.currentTimeMillis());
		
	
	currentComponent="tWarn_2";

	
		int tos_count_tWarn_2 = 0;
		

 



/**
 * [tWarn_2 begin ] stop
 */
	
	/**
	 * [tWarn_2 main ] start
	 */

	

	
	
	currentComponent="tWarn_2";

	

		
try {
	
	resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_2", "", Thread.currentThread().getId() + "", "INFO","","LoadBronzeTMDB end","", "");
	globalMap.put("tWarn_2_WARN_MESSAGES", "LoadBronzeTMDB end"); 
	globalMap.put("tWarn_2_WARN_PRIORITY", 3);
	globalMap.put("tWarn_2_WARN_CODE", 42);
	
} catch (Exception e_tWarn_2) {
globalMap.put("tWarn_2_ERROR_MESSAGE",e_tWarn_2.getMessage());
	logIgnoredError(String.format("tWarn_2 - tWarn failed to log message due to internal error: %s", e_tWarn_2), e_tWarn_2);
}


 


	tos_count_tWarn_2++;

/**
 * [tWarn_2 main ] stop
 */
	
	/**
	 * [tWarn_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tWarn_2";

	

 



/**
 * [tWarn_2 process_data_begin ] stop
 */
	
	/**
	 * [tWarn_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tWarn_2";

	

 



/**
 * [tWarn_2 process_data_end ] stop
 */
	
	/**
	 * [tWarn_2 end ] start
	 */

	

	
	
	currentComponent="tWarn_2";

	

 

ok_Hash.put("tWarn_2", true);
end_Hash.put("tWarn_2", System.currentTimeMillis());




/**
 * [tWarn_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tWarn_2 finally ] start
	 */

	

	
	
	currentComponent="tWarn_2";

	

 



/**
 * [tWarn_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tWarn_2_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final LoadBronzeTMDB LoadBronzeTMDBClass = new LoadBronzeTMDB();

        int exitCode = LoadBronzeTMDBClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = LoadBronzeTMDB.class.getClassLoader().getResourceAsStream("project/loadbronzetmdb_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = LoadBronzeTMDB.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("kaggle_dataset", "id_String");
                        if(context.getStringValue("kaggle_dataset") == null) {
                            context.kaggle_dataset = null;
                        } else {
                            context.kaggle_dataset=(String) context.getProperty("kaggle_dataset");
                        }
                        context.setContextType("letter", "id_String");
                        if(context.getStringValue("letter") == null) {
                            context.letter = null;
                        } else {
                            context.letter=(String) context.getProperty("letter");
                        }
                        context.setContextType("mongodb_authentificationDatabase", "id_String");
                        if(context.getStringValue("mongodb_authentificationDatabase") == null) {
                            context.mongodb_authentificationDatabase = null;
                        } else {
                            context.mongodb_authentificationDatabase=(String) context.getProperty("mongodb_authentificationDatabase");
                        }
                        context.setContextType("mongodb_collection_bronze_k", "id_String");
                        if(context.getStringValue("mongodb_collection_bronze_k") == null) {
                            context.mongodb_collection_bronze_k = null;
                        } else {
                            context.mongodb_collection_bronze_k=(String) context.getProperty("mongodb_collection_bronze_k");
                        }
                        context.setContextType("mongodb_collection_bronze_nutritional", "id_String");
                        if(context.getStringValue("mongodb_collection_bronze_nutritional") == null) {
                            context.mongodb_collection_bronze_nutritional = null;
                        } else {
                            context.mongodb_collection_bronze_nutritional=(String) context.getProperty("mongodb_collection_bronze_nutritional");
                        }
                        context.setContextType("mongodb_collection_bronze_tmdb", "id_String");
                        if(context.getStringValue("mongodb_collection_bronze_tmdb") == null) {
                            context.mongodb_collection_bronze_tmdb = null;
                        } else {
                            context.mongodb_collection_bronze_tmdb=(String) context.getProperty("mongodb_collection_bronze_tmdb");
                        }
                        context.setContextType("mongodb_collection_silver", "id_String");
                        if(context.getStringValue("mongodb_collection_silver") == null) {
                            context.mongodb_collection_silver = null;
                        } else {
                            context.mongodb_collection_silver=(String) context.getProperty("mongodb_collection_silver");
                        }
                        context.setContextType("mongodb_database", "id_String");
                        if(context.getStringValue("mongodb_database") == null) {
                            context.mongodb_database = null;
                        } else {
                            context.mongodb_database=(String) context.getProperty("mongodb_database");
                        }
                        context.setContextType("mongodb_password", "id_String");
                        if(context.getStringValue("mongodb_password") == null) {
                            context.mongodb_password = null;
                        } else {
                            context.mongodb_password=(String) context.getProperty("mongodb_password");
                        }
                        context.setContextType("mongodb_port", "id_String");
                        if(context.getStringValue("mongodb_port") == null) {
                            context.mongodb_port = null;
                        } else {
                            context.mongodb_port=(String) context.getProperty("mongodb_port");
                        }
                        context.setContextType("mongodb_server", "id_String");
                        if(context.getStringValue("mongodb_server") == null) {
                            context.mongodb_server = null;
                        } else {
                            context.mongodb_server=(String) context.getProperty("mongodb_server");
                        }
                        context.setContextType("mongodb_user", "id_String");
                        if(context.getStringValue("mongodb_user") == null) {
                            context.mongodb_user = null;
                        } else {
                            context.mongodb_user=(String) context.getProperty("mongodb_user");
                        }
                        context.setContextType("nutrition_dataset", "id_String");
                        if(context.getStringValue("nutrition_dataset") == null) {
                            context.nutrition_dataset = null;
                        } else {
                            context.nutrition_dataset=(String) context.getProperty("nutrition_dataset");
                        }
                        context.setContextType("postgresql_database", "id_String");
                        if(context.getStringValue("postgresql_database") == null) {
                            context.postgresql_database = null;
                        } else {
                            context.postgresql_database=(String) context.getProperty("postgresql_database");
                        }
                        context.setContextType("postgresql_password", "id_String");
                        if(context.getStringValue("postgresql_password") == null) {
                            context.postgresql_password = null;
                        } else {
                            context.postgresql_password=(String) context.getProperty("postgresql_password");
                        }
                        context.setContextType("postgresql_port", "id_String");
                        if(context.getStringValue("postgresql_port") == null) {
                            context.postgresql_port = null;
                        } else {
                            context.postgresql_port=(String) context.getProperty("postgresql_port");
                        }
                        context.setContextType("postgresql_schema", "id_String");
                        if(context.getStringValue("postgresql_schema") == null) {
                            context.postgresql_schema = null;
                        } else {
                            context.postgresql_schema=(String) context.getProperty("postgresql_schema");
                        }
                        context.setContextType("postgresql_server", "id_String");
                        if(context.getStringValue("postgresql_server") == null) {
                            context.postgresql_server = null;
                        } else {
                            context.postgresql_server=(String) context.getProperty("postgresql_server");
                        }
                        context.setContextType("postgresql_table_area", "id_String");
                        if(context.getStringValue("postgresql_table_area") == null) {
                            context.postgresql_table_area = null;
                        } else {
                            context.postgresql_table_area=(String) context.getProperty("postgresql_table_area");
                        }
                        context.setContextType("postgresql_table_category", "id_String");
                        if(context.getStringValue("postgresql_table_category") == null) {
                            context.postgresql_table_category = null;
                        } else {
                            context.postgresql_table_category=(String) context.getProperty("postgresql_table_category");
                        }
                        context.setContextType("postgresql_table_meals", "id_String");
                        if(context.getStringValue("postgresql_table_meals") == null) {
                            context.postgresql_table_meals = null;
                        } else {
                            context.postgresql_table_meals=(String) context.getProperty("postgresql_table_meals");
                        }
                        context.setContextType("postgresql_user", "id_String");
                        if(context.getStringValue("postgresql_user") == null) {
                            context.postgresql_user = null;
                        } else {
                            context.postgresql_user=(String) context.getProperty("postgresql_user");
                        }
                        context.setContextType("source", "id_String");
                        if(context.getStringValue("source") == null) {
                            context.source = null;
                        } else {
                            context.source=(String) context.getProperty("source");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("kaggle_dataset")) {
                context.kaggle_dataset = (String) parentContextMap.get("kaggle_dataset");
            }if (parentContextMap.containsKey("letter")) {
                context.letter = (String) parentContextMap.get("letter");
            }if (parentContextMap.containsKey("mongodb_authentificationDatabase")) {
                context.mongodb_authentificationDatabase = (String) parentContextMap.get("mongodb_authentificationDatabase");
            }if (parentContextMap.containsKey("mongodb_collection_bronze_k")) {
                context.mongodb_collection_bronze_k = (String) parentContextMap.get("mongodb_collection_bronze_k");
            }if (parentContextMap.containsKey("mongodb_collection_bronze_nutritional")) {
                context.mongodb_collection_bronze_nutritional = (String) parentContextMap.get("mongodb_collection_bronze_nutritional");
            }if (parentContextMap.containsKey("mongodb_collection_bronze_tmdb")) {
                context.mongodb_collection_bronze_tmdb = (String) parentContextMap.get("mongodb_collection_bronze_tmdb");
            }if (parentContextMap.containsKey("mongodb_collection_silver")) {
                context.mongodb_collection_silver = (String) parentContextMap.get("mongodb_collection_silver");
            }if (parentContextMap.containsKey("mongodb_database")) {
                context.mongodb_database = (String) parentContextMap.get("mongodb_database");
            }if (parentContextMap.containsKey("mongodb_password")) {
                context.mongodb_password = (String) parentContextMap.get("mongodb_password");
            }if (parentContextMap.containsKey("mongodb_port")) {
                context.mongodb_port = (String) parentContextMap.get("mongodb_port");
            }if (parentContextMap.containsKey("mongodb_server")) {
                context.mongodb_server = (String) parentContextMap.get("mongodb_server");
            }if (parentContextMap.containsKey("mongodb_user")) {
                context.mongodb_user = (String) parentContextMap.get("mongodb_user");
            }if (parentContextMap.containsKey("nutrition_dataset")) {
                context.nutrition_dataset = (String) parentContextMap.get("nutrition_dataset");
            }if (parentContextMap.containsKey("postgresql_database")) {
                context.postgresql_database = (String) parentContextMap.get("postgresql_database");
            }if (parentContextMap.containsKey("postgresql_password")) {
                context.postgresql_password = (String) parentContextMap.get("postgresql_password");
            }if (parentContextMap.containsKey("postgresql_port")) {
                context.postgresql_port = (String) parentContextMap.get("postgresql_port");
            }if (parentContextMap.containsKey("postgresql_schema")) {
                context.postgresql_schema = (String) parentContextMap.get("postgresql_schema");
            }if (parentContextMap.containsKey("postgresql_server")) {
                context.postgresql_server = (String) parentContextMap.get("postgresql_server");
            }if (parentContextMap.containsKey("postgresql_table_area")) {
                context.postgresql_table_area = (String) parentContextMap.get("postgresql_table_area");
            }if (parentContextMap.containsKey("postgresql_table_category")) {
                context.postgresql_table_category = (String) parentContextMap.get("postgresql_table_category");
            }if (parentContextMap.containsKey("postgresql_table_meals")) {
                context.postgresql_table_meals = (String) parentContextMap.get("postgresql_table_meals");
            }if (parentContextMap.containsKey("postgresql_user")) {
                context.postgresql_user = (String) parentContextMap.get("postgresql_user");
            }if (parentContextMap.containsKey("source")) {
                context.source = (String) parentContextMap.get("source");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob





this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tWarn_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tWarn_1) {
globalMap.put("tWarn_1_SUBPROCESS_STATE", -1);

e_tWarn_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : LoadBronzeTMDB");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     217490 characters generated by Talend Open Studio for Big Data 
 *     on the 10 février 2026, 10:02:10 CET
 ************************************************************************************************/