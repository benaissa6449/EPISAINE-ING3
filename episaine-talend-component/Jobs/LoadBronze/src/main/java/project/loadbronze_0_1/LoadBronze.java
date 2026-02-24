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


package project.loadbronze_0_1;

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
 





@SuppressWarnings("unused")

/**
 * Job: LoadBronze Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class LoadBronze implements TalendJob {

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
	private final String jobName = "LoadBronze";
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
				LoadBronze.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(LoadBronze.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tRunJob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRunJob_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tWarn_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tWarn_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tWarn_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRunJob_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

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
	
	resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_1", "", Thread.currentThread().getId() + "", "INFO","","LoadBronze begin","", "");
	globalMap.put("tWarn_1_WARN_MESSAGES", "LoadBronze begin"); 
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
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tRunJob_1Process(globalMap);



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
	

public void tRunJob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_1_SUBPROCESS_STATE", 0);

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
	 * [tRunJob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_1", false);
		start_Hash.put("tRunJob_1", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_1";

	
		int tos_count_tRunJob_1 = 0;
		


 



/**
 * [tRunJob_1 begin ] stop
 */
	
	/**
	 * [tRunJob_1 main ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	
	java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_1.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_1.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_1.add("--father_node=tRunJob_1");
	      			
	        				paraList_tRunJob_1.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_1.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_1.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null){
		paraList_tRunJob_1.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_1 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_1.put("kaggle_dataset", context.kaggle_dataset);
                    paraList_tRunJob_1.add("--context_type " + "kaggle_dataset" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("letter", context.letter);
                    paraList_tRunJob_1.add("--context_type " + "letter" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("mongodb_authentificationDatabase", context.mongodb_authentificationDatabase);
                    paraList_tRunJob_1.add("--context_type " + "mongodb_authentificationDatabase" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("mongodb_collection_bronze_k", context.mongodb_collection_bronze_k);
                    paraList_tRunJob_1.add("--context_type " + "mongodb_collection_bronze_k" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("mongodb_collection_bronze_nutritional", context.mongodb_collection_bronze_nutritional);
                    paraList_tRunJob_1.add("--context_type " + "mongodb_collection_bronze_nutritional" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("mongodb_collection_bronze_tmdb", context.mongodb_collection_bronze_tmdb);
                    paraList_tRunJob_1.add("--context_type " + "mongodb_collection_bronze_tmdb" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("mongodb_collection_silver", context.mongodb_collection_silver);
                    paraList_tRunJob_1.add("--context_type " + "mongodb_collection_silver" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("mongodb_database", context.mongodb_database);
                    paraList_tRunJob_1.add("--context_type " + "mongodb_database" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("mongodb_password", context.mongodb_password);
                    paraList_tRunJob_1.add("--context_type " + "mongodb_password" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("mongodb_port", context.mongodb_port);
                    paraList_tRunJob_1.add("--context_type " + "mongodb_port" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("mongodb_server", context.mongodb_server);
                    paraList_tRunJob_1.add("--context_type " + "mongodb_server" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("mongodb_user", context.mongodb_user);
                    paraList_tRunJob_1.add("--context_type " + "mongodb_user" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("nutrition_dataset", context.nutrition_dataset);
                    paraList_tRunJob_1.add("--context_type " + "nutrition_dataset" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("postgresql_database", context.postgresql_database);
                    paraList_tRunJob_1.add("--context_type " + "postgresql_database" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("postgresql_password", context.postgresql_password);
                    paraList_tRunJob_1.add("--context_type " + "postgresql_password" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("postgresql_port", context.postgresql_port);
                    paraList_tRunJob_1.add("--context_type " + "postgresql_port" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("postgresql_schema", context.postgresql_schema);
                    paraList_tRunJob_1.add("--context_type " + "postgresql_schema" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("postgresql_server", context.postgresql_server);
                    paraList_tRunJob_1.add("--context_type " + "postgresql_server" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("postgresql_table_area", context.postgresql_table_area);
                    paraList_tRunJob_1.add("--context_type " + "postgresql_table_area" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("postgresql_table_category", context.postgresql_table_category);
                    paraList_tRunJob_1.add("--context_type " + "postgresql_table_category" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("postgresql_table_meals", context.postgresql_table_meals);
                    paraList_tRunJob_1.add("--context_type " + "postgresql_table_meals" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("postgresql_user", context.postgresql_user);
                    paraList_tRunJob_1.add("--context_type " + "postgresql_user" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("source", context.source);
                    paraList_tRunJob_1.add("--context_type " + "source" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_1().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_1 = context.propertyNames();
		while (propertyNames_tRunJob_1.hasMoreElements()) {
			String key_tRunJob_1 = (String) propertyNames_tRunJob_1.nextElement();
			Object value_tRunJob_1 = (Object) context.get(key_tRunJob_1);
			if(value_tRunJob_1!=null) {  
				paraList_tRunJob_1.add("--context_param " + key_tRunJob_1 + "=" + value_tRunJob_1);
			} else {
				paraList_tRunJob_1.add("--context_param " + key_tRunJob_1 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_1 = null;

	
	
		project.loadbronzetmdb_0_1.LoadBronzeTMDB childJob_tRunJob_1 = new project.loadbronzetmdb_0_1.LoadBronzeTMDB();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_1 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_1) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_1 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_1 : talendDataSources_tRunJob_1
			        .entrySet()) {
	            dataSources_tRunJob_1.put(talendDataSourceEntry_tRunJob_1.getKey(),
	                    talendDataSourceEntry_tRunJob_1.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_1.setDataSources(dataSources_tRunJob_1);
	    }
		  
			childJob_tRunJob_1.parentContextMap = parentContextMap_tRunJob_1;
		  
		
		String[][] childReturn_tRunJob_1 = childJob_tRunJob_1.runJob((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));
		
            if(childJob_tRunJob_1.getErrorCode() == null){
                globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getStatus() != null && ("failure").equals(childJob_tRunJob_1.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getErrorCode());
            }
            if (childJob_tRunJob_1.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_1.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_1.getErrorCode();
                if (childJob_tRunJob_1.getErrorCode() != null || ("failure").equals(childJob_tRunJob_1.getStatus())) {
                    java.lang.Exception ce_tRunJob_1 = childJob_tRunJob_1.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_1!=null) ? (ce_tRunJob_1.getClass().getName() + ": " + ce_tRunJob_1.getMessage()) : ""));
                }

 


	tos_count_tRunJob_1++;

/**
 * [tRunJob_1 main ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_1 end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 

ok_Hash.put("tRunJob_1", true);
end_Hash.put("tRunJob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tRunJob_2Process(globalMap);



/**
 * [tRunJob_1 end ] stop
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
	 * [tRunJob_1 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_2_SUBPROCESS_STATE", 0);

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
	 * [tRunJob_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_2", false);
		start_Hash.put("tRunJob_2", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_2";

	
		int tos_count_tRunJob_2 = 0;
		


 



/**
 * [tRunJob_2 begin ] stop
 */
	
	/**
	 * [tRunJob_2 main ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	
	java.util.List<String> paraList_tRunJob_2 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_2.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_2.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_2.add("--father_node=tRunJob_2");
	      			
	        				paraList_tRunJob_2.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_2.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_2.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_2.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_2 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_2 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_2".equals(tRunJobName_tRunJob_2) && childResumePath_tRunJob_2 != null){
		paraList_tRunJob_2.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_2.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_2");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_2 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_2 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_2.put("kaggle_dataset", context.kaggle_dataset);
                    paraList_tRunJob_2.add("--context_type " + "kaggle_dataset" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("letter", context.letter);
                    paraList_tRunJob_2.add("--context_type " + "letter" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("mongodb_authentificationDatabase", context.mongodb_authentificationDatabase);
                    paraList_tRunJob_2.add("--context_type " + "mongodb_authentificationDatabase" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("mongodb_collection_bronze_k", context.mongodb_collection_bronze_k);
                    paraList_tRunJob_2.add("--context_type " + "mongodb_collection_bronze_k" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("mongodb_collection_bronze_nutritional", context.mongodb_collection_bronze_nutritional);
                    paraList_tRunJob_2.add("--context_type " + "mongodb_collection_bronze_nutritional" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("mongodb_collection_bronze_tmdb", context.mongodb_collection_bronze_tmdb);
                    paraList_tRunJob_2.add("--context_type " + "mongodb_collection_bronze_tmdb" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("mongodb_collection_silver", context.mongodb_collection_silver);
                    paraList_tRunJob_2.add("--context_type " + "mongodb_collection_silver" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("mongodb_database", context.mongodb_database);
                    paraList_tRunJob_2.add("--context_type " + "mongodb_database" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("mongodb_password", context.mongodb_password);
                    paraList_tRunJob_2.add("--context_type " + "mongodb_password" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("mongodb_port", context.mongodb_port);
                    paraList_tRunJob_2.add("--context_type " + "mongodb_port" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("mongodb_server", context.mongodb_server);
                    paraList_tRunJob_2.add("--context_type " + "mongodb_server" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("mongodb_user", context.mongodb_user);
                    paraList_tRunJob_2.add("--context_type " + "mongodb_user" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("nutrition_dataset", context.nutrition_dataset);
                    paraList_tRunJob_2.add("--context_type " + "nutrition_dataset" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("postgresql_database", context.postgresql_database);
                    paraList_tRunJob_2.add("--context_type " + "postgresql_database" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("postgresql_password", context.postgresql_password);
                    paraList_tRunJob_2.add("--context_type " + "postgresql_password" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("postgresql_port", context.postgresql_port);
                    paraList_tRunJob_2.add("--context_type " + "postgresql_port" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("postgresql_schema", context.postgresql_schema);
                    paraList_tRunJob_2.add("--context_type " + "postgresql_schema" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("postgresql_server", context.postgresql_server);
                    paraList_tRunJob_2.add("--context_type " + "postgresql_server" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("postgresql_table_area", context.postgresql_table_area);
                    paraList_tRunJob_2.add("--context_type " + "postgresql_table_area" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("postgresql_table_category", context.postgresql_table_category);
                    paraList_tRunJob_2.add("--context_type " + "postgresql_table_category" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("postgresql_table_meals", context.postgresql_table_meals);
                    paraList_tRunJob_2.add("--context_type " + "postgresql_table_meals" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("postgresql_user", context.postgresql_user);
                    paraList_tRunJob_2.add("--context_type " + "postgresql_user" + "=" + "id_String");
                    parentContextMap_tRunJob_2.put("source", context.source);
                    paraList_tRunJob_2.add("--context_type " + "source" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_2().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_2 = context.propertyNames();
		while (propertyNames_tRunJob_2.hasMoreElements()) {
			String key_tRunJob_2 = (String) propertyNames_tRunJob_2.nextElement();
			Object value_tRunJob_2 = (Object) context.get(key_tRunJob_2);
			if(value_tRunJob_2!=null) {  
				paraList_tRunJob_2.add("--context_param " + key_tRunJob_2 + "=" + value_tRunJob_2);
			} else {
				paraList_tRunJob_2.add("--context_param " + key_tRunJob_2 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_2 = null;

	
	
		project.loadbronzek_0_1.LoadBronzeK childJob_tRunJob_2 = new project.loadbronzek_0_1.LoadBronzeK();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_2 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_2) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_2 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_2 : talendDataSources_tRunJob_2
			        .entrySet()) {
	            dataSources_tRunJob_2.put(talendDataSourceEntry_tRunJob_2.getKey(),
	                    talendDataSourceEntry_tRunJob_2.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_2.setDataSources(dataSources_tRunJob_2);
	    }
		  
			childJob_tRunJob_2.parentContextMap = parentContextMap_tRunJob_2;
		  
		
		String[][] childReturn_tRunJob_2 = childJob_tRunJob_2.runJob((String[]) paraList_tRunJob_2.toArray(new String[paraList_tRunJob_2.size()]));
		
            if(childJob_tRunJob_2.getErrorCode() == null){
                globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getStatus() != null && ("failure").equals(childJob_tRunJob_2.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getErrorCode());
            }
            if (childJob_tRunJob_2.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_2_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_2.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_2.getErrorCode();
                if (childJob_tRunJob_2.getErrorCode() != null || ("failure").equals(childJob_tRunJob_2.getStatus())) {
                    java.lang.Exception ce_tRunJob_2 = childJob_tRunJob_2.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_2!=null) ? (ce_tRunJob_2.getClass().getName() + ": " + ce_tRunJob_2.getMessage()) : ""));
                }

 


	tos_count_tRunJob_2++;

/**
 * [tRunJob_2 main ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_2 end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 

ok_Hash.put("tRunJob_2", true);
end_Hash.put("tRunJob_2", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tRunJob_3Process(globalMap);



/**
 * [tRunJob_2 end ] stop
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
	 * [tRunJob_2 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_2_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_3_SUBPROCESS_STATE", 0);

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
	 * [tRunJob_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_3", false);
		start_Hash.put("tRunJob_3", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_3";

	
		int tos_count_tRunJob_3 = 0;
		


 



/**
 * [tRunJob_3 begin ] stop
 */
	
	/**
	 * [tRunJob_3 main ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	
	java.util.List<String> paraList_tRunJob_3 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_3.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_3.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_3.add("--father_node=tRunJob_3");
	      			
	        				paraList_tRunJob_3.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_3.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_3.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_3.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_3 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_3 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_3".equals(tRunJobName_tRunJob_3) && childResumePath_tRunJob_3 != null){
		paraList_tRunJob_3.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_3.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_3");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_3 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_3 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_3.put("kaggle_dataset", context.kaggle_dataset);
                    paraList_tRunJob_3.add("--context_type " + "kaggle_dataset" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("letter", context.letter);
                    paraList_tRunJob_3.add("--context_type " + "letter" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("mongodb_authentificationDatabase", context.mongodb_authentificationDatabase);
                    paraList_tRunJob_3.add("--context_type " + "mongodb_authentificationDatabase" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("mongodb_collection_bronze_k", context.mongodb_collection_bronze_k);
                    paraList_tRunJob_3.add("--context_type " + "mongodb_collection_bronze_k" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("mongodb_collection_bronze_nutritional", context.mongodb_collection_bronze_nutritional);
                    paraList_tRunJob_3.add("--context_type " + "mongodb_collection_bronze_nutritional" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("mongodb_collection_bronze_tmdb", context.mongodb_collection_bronze_tmdb);
                    paraList_tRunJob_3.add("--context_type " + "mongodb_collection_bronze_tmdb" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("mongodb_collection_silver", context.mongodb_collection_silver);
                    paraList_tRunJob_3.add("--context_type " + "mongodb_collection_silver" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("mongodb_database", context.mongodb_database);
                    paraList_tRunJob_3.add("--context_type " + "mongodb_database" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("mongodb_password", context.mongodb_password);
                    paraList_tRunJob_3.add("--context_type " + "mongodb_password" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("mongodb_port", context.mongodb_port);
                    paraList_tRunJob_3.add("--context_type " + "mongodb_port" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("mongodb_server", context.mongodb_server);
                    paraList_tRunJob_3.add("--context_type " + "mongodb_server" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("mongodb_user", context.mongodb_user);
                    paraList_tRunJob_3.add("--context_type " + "mongodb_user" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("nutrition_dataset", context.nutrition_dataset);
                    paraList_tRunJob_3.add("--context_type " + "nutrition_dataset" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("postgresql_database", context.postgresql_database);
                    paraList_tRunJob_3.add("--context_type " + "postgresql_database" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("postgresql_password", context.postgresql_password);
                    paraList_tRunJob_3.add("--context_type " + "postgresql_password" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("postgresql_port", context.postgresql_port);
                    paraList_tRunJob_3.add("--context_type " + "postgresql_port" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("postgresql_schema", context.postgresql_schema);
                    paraList_tRunJob_3.add("--context_type " + "postgresql_schema" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("postgresql_server", context.postgresql_server);
                    paraList_tRunJob_3.add("--context_type " + "postgresql_server" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("postgresql_table_area", context.postgresql_table_area);
                    paraList_tRunJob_3.add("--context_type " + "postgresql_table_area" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("postgresql_table_category", context.postgresql_table_category);
                    paraList_tRunJob_3.add("--context_type " + "postgresql_table_category" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("postgresql_table_meals", context.postgresql_table_meals);
                    paraList_tRunJob_3.add("--context_type " + "postgresql_table_meals" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("postgresql_user", context.postgresql_user);
                    paraList_tRunJob_3.add("--context_type " + "postgresql_user" + "=" + "id_String");
                    parentContextMap_tRunJob_3.put("source", context.source);
                    paraList_tRunJob_3.add("--context_type " + "source" + "=" + "id_String");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_3().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_3 = context.propertyNames();
		while (propertyNames_tRunJob_3.hasMoreElements()) {
			String key_tRunJob_3 = (String) propertyNames_tRunJob_3.nextElement();
			Object value_tRunJob_3 = (Object) context.get(key_tRunJob_3);
			if(value_tRunJob_3!=null) {  
				paraList_tRunJob_3.add("--context_param " + key_tRunJob_3 + "=" + value_tRunJob_3);
			} else {
				paraList_tRunJob_3.add("--context_param " + key_tRunJob_3 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_3 = null;

	
	
		project.loadbronzenutritional_0_1.LoadBronzeNutritional childJob_tRunJob_3 = new project.loadbronzenutritional_0_1.LoadBronzeNutritional();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_3 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_3) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_3 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_3 : talendDataSources_tRunJob_3
			        .entrySet()) {
	            dataSources_tRunJob_3.put(talendDataSourceEntry_tRunJob_3.getKey(),
	                    talendDataSourceEntry_tRunJob_3.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_3.setDataSources(dataSources_tRunJob_3);
	    }
		  
			childJob_tRunJob_3.parentContextMap = parentContextMap_tRunJob_3;
		  
		
		String[][] childReturn_tRunJob_3 = childJob_tRunJob_3.runJob((String[]) paraList_tRunJob_3.toArray(new String[paraList_tRunJob_3.size()]));
		
            if(childJob_tRunJob_3.getErrorCode() == null){
                globalMap.put("tRunJob_3_CHILD_RETURN_CODE", childJob_tRunJob_3.getStatus() != null && ("failure").equals(childJob_tRunJob_3.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_3_CHILD_RETURN_CODE", childJob_tRunJob_3.getErrorCode());
            }
            if (childJob_tRunJob_3.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_3_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_3.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_3.getErrorCode();
                if (childJob_tRunJob_3.getErrorCode() != null || ("failure").equals(childJob_tRunJob_3.getStatus())) {
                    java.lang.Exception ce_tRunJob_3 = childJob_tRunJob_3.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_3!=null) ? (ce_tRunJob_3.getClass().getName() + ": " + ce_tRunJob_3.getMessage()) : ""));
                }

 


	tos_count_tRunJob_3++;

/**
 * [tRunJob_3 main ] stop
 */
	
	/**
	 * [tRunJob_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_3 end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 

ok_Hash.put("tRunJob_3", true);
end_Hash.put("tRunJob_3", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk5", 0, "ok");
				}
				tWarn_2Process(globalMap);



/**
 * [tRunJob_3 end ] stop
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
	 * [tRunJob_3 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_3_SUBPROCESS_STATE", 1);
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
	
	resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_2", "", Thread.currentThread().getId() + "", "INFO","","LoadBronze end","", "");
	globalMap.put("tWarn_2_WARN_MESSAGES", "LoadBronze end"); 
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
        final LoadBronze LoadBronzeClass = new LoadBronze();

        int exitCode = LoadBronzeClass.runJobInTOS(args);

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
            java.io.InputStream inContext = LoadBronze.class.getClassLoader().getResourceAsStream("project/loadbronze_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = LoadBronze.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : LoadBronze");
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
 *     87564 characters generated by Talend Open Studio for Big Data 
 *     on the 24 février 2026, 17:35:08 CET
 ************************************************************************************************/