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


package project.loadsilver_0_1;

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
 




	//the import part of tJavaRow_1
	import java.util.List;
import java.util.ArrayList;


	//the import part of tJavaRow_4
	//import java.util.List;

	//the import part of tJava_2
	//import java.util.List;

	//the import part of tJavaRow_3
	//import java.util.List;

	//the import part of tJavaRow_2
	import java.util.List;
import java.util.ArrayList;



@SuppressWarnings("unused")

/**
 * Job: LoadSilver Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class LoadSilver implements TalendJob {

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
			
			if(mongodb_collection_silver_nutrition != null){
				
					this.setProperty("mongodb_collection_silver_nutrition", mongodb_collection_silver_nutrition.toString());
				
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
public String mongodb_collection_silver_nutrition;
public String getMongodb_collection_silver_nutrition(){
	return this.mongodb_collection_silver_nutrition;
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
	private final String jobName = "LoadSilver";
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
				LoadSilver.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(LoadSilver.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tMongoDBOutput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFixedFlowInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJavaRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJavaRow_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJavaRow_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLoop_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
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
			
			public void tMongoDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJavaRow_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAggregateRow_1_AGGOUT_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tAggregateRow_1_AGGIN_error(exception, errorComponent, globalMap);
						
						}
					
			public void tAggregateRow_1_AGGIN_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_3_onSubJobError(exception, errorComponent, globalMap);
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
			public void tFixedFlowInput_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tLoop_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

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
	
	resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_1", "", Thread.currentThread().getId() + "", "INFO","","LoadSilver begin","", "");
	globalMap.put("tWarn_1_WARN_MESSAGES", "LoadSilver begin"); 
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
   	 				runStat.updateStatOnConnection("OnComponentOk6", 0, "ok");
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
	


public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];

	
			    public Byte dummy;

				public Byte getDummy () {
					return this.dummy;
				}
				



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

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
    public int compareTo(row5Struct other) {

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



		row5Struct row5 = new row5Struct();




	
	/**
	 * [tMongoDBOutput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_3", false);
		start_Hash.put("tMongoDBOutput_3", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row5");
					}
				
		int tos_count_tMongoDBOutput_3 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_3 = "Talend";

    int nb_line_tMongoDBOutput_3 = 0;

			class DBObjectUtil_tMongoDBOutput_3 {
				
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
            DBObjectUtil_tMongoDBOutput_3 updateObjectUtil_tMongoDBOutput_3=new DBObjectUtil_tMongoDBOutput_3();
            DBObjectUtil_tMongoDBOutput_3 queryObjectUtil_tMongoDBOutput_3=new DBObjectUtil_tMongoDBOutput_3();
            java.util.Map<String, String> pathMap_tMongoDBOutput_3=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_3.put("dummy","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_3=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_3=null;

        mongo_tMongoDBOutput_3=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_3 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

        db_tMongoDBOutput_3.getCollection(context.mongodb_collection_silver).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_3 = db_tMongoDBOutput_3.getCollection(context.mongodb_collection_silver);


 



/**
 * [tMongoDBOutput_3 begin ] stop
 */



	
	/**
	 * [tFixedFlowInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFixedFlowInput_1", false);
		start_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());
		
	
	currentComponent="tFixedFlowInput_1";

	
		int tos_count_tFixedFlowInput_1 = 0;
		

	    for (int i_tFixedFlowInput_1 = 0 ; i_tFixedFlowInput_1 < 1 ; i_tFixedFlowInput_1++) {
	                	            	
    	            		row5.dummy = 1;
    	            	

 



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
	 * [tMongoDBOutput_3 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_3.setObject(new org.bson.Document());
				
				

				
					queryObjectUtil_tMongoDBOutput_3.setObject(new org.bson.Document());
					int countKey_tMongoDBOutput_3=0;
				
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("dummy"),"dummy", row5.dummy);
				org.bson.Document updateObj_tMongoDBOutput_3 = updateObjectUtil_tMongoDBOutput_3.getObject();
				
					if(countKey_tMongoDBOutput_3 <=0){
						
							System.err.println("Must have at least one key in schema");
						
					}else{
						org.bson.Document queryObj_tMongoDBOutput_3 = queryObjectUtil_tMongoDBOutput_3.getObject();
						
									coll_tMongoDBOutput_3.deleteMany(queryObj_tMongoDBOutput_3);
									
					}
				
				} catch (Exception e_tMongoDBOutput_3) {
				
    					
    						System.err.println(e_tMongoDBOutput_3.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_3 ++;
				
 


	tos_count_tMongoDBOutput_3++;

/**
 * [tMongoDBOutput_3 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	

 



/**
 * [tMongoDBOutput_3 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	

 



/**
 * [tMongoDBOutput_3 process_data_end ] stop
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
	 * [tMongoDBOutput_3 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	

	globalMap.put("tMongoDBOutput_3_NB_LINE", nb_line_tMongoDBOutput_3);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row5");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_3", true);
end_Hash.put("tMongoDBOutput_3", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tFixedFlowInput_2Process(globalMap);



/**
 * [tMongoDBOutput_3 end ] stop
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
	 * [tMongoDBOutput_3 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	


 



/**
 * [tMongoDBOutput_3 finally ] stop
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
	


public static class row9Struct implements routines.system.IPersistableRow<row9Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];

	
			    public Byte dummy;

				public Byte getDummy () {
					return this.dummy;
				}
				



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

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
    public int compareTo(row9Struct other) {

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
public void tFixedFlowInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFixedFlowInput_2_SUBPROCESS_STATE", 0);

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



		row9Struct row9 = new row9Struct();




	
	/**
	 * [tMongoDBOutput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_5", false);
		start_Hash.put("tMongoDBOutput_5", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row9");
					}
				
		int tos_count_tMongoDBOutput_5 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_5 = "Talend";

    int nb_line_tMongoDBOutput_5 = 0;

			class DBObjectUtil_tMongoDBOutput_5 {
				
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
            DBObjectUtil_tMongoDBOutput_5 updateObjectUtil_tMongoDBOutput_5=new DBObjectUtil_tMongoDBOutput_5();
            DBObjectUtil_tMongoDBOutput_5 queryObjectUtil_tMongoDBOutput_5=new DBObjectUtil_tMongoDBOutput_5();
            java.util.Map<String, String> pathMap_tMongoDBOutput_5=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_5.put("dummy","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_5=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_5=null;

        mongo_tMongoDBOutput_5=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_5 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

        db_tMongoDBOutput_5.getCollection(context.mongodb_collection_silver_nutrition).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_5 = db_tMongoDBOutput_5.getCollection(context.mongodb_collection_silver_nutrition);


 



/**
 * [tMongoDBOutput_5 begin ] stop
 */



	
	/**
	 * [tFixedFlowInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFixedFlowInput_2", false);
		start_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());
		
	
	currentComponent="tFixedFlowInput_2";

	
		int tos_count_tFixedFlowInput_2 = 0;
		

	    for (int i_tFixedFlowInput_2 = 0 ; i_tFixedFlowInput_2 < 1 ; i_tFixedFlowInput_2++) {
	                	            	
    	            		row9.dummy = 1;
    	            	

 



/**
 * [tFixedFlowInput_2 begin ] stop
 */
	
	/**
	 * [tFixedFlowInput_2 main ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_2";

	

 


	tos_count_tFixedFlowInput_2++;

/**
 * [tFixedFlowInput_2 main ] stop
 */
	
	/**
	 * [tFixedFlowInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_2";

	

 



/**
 * [tFixedFlowInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tMongoDBOutput_5 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row9"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_5.setObject(new org.bson.Document());
				
				

				
					queryObjectUtil_tMongoDBOutput_5.setObject(new org.bson.Document());
					int countKey_tMongoDBOutput_5=0;
				
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("dummy"),"dummy", row9.dummy);
				org.bson.Document updateObj_tMongoDBOutput_5 = updateObjectUtil_tMongoDBOutput_5.getObject();
				
					if(countKey_tMongoDBOutput_5 <=0){
						
							System.err.println("Must have at least one key in schema");
						
					}else{
						org.bson.Document queryObj_tMongoDBOutput_5 = queryObjectUtil_tMongoDBOutput_5.getObject();
						
									coll_tMongoDBOutput_5.deleteMany(queryObj_tMongoDBOutput_5);
									
					}
				
				} catch (Exception e_tMongoDBOutput_5) {
				
    					
    						System.err.println(e_tMongoDBOutput_5.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_5 ++;
				
 


	tos_count_tMongoDBOutput_5++;

/**
 * [tMongoDBOutput_5 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	

 



/**
 * [tMongoDBOutput_5 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	

 



/**
 * [tMongoDBOutput_5 process_data_end ] stop
 */



	
	/**
	 * [tFixedFlowInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_2";

	

 



/**
 * [tFixedFlowInput_2 process_data_end ] stop
 */
	
	/**
	 * [tFixedFlowInput_2 end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_2";

	

        }
        globalMap.put("tFixedFlowInput_2_NB_LINE", 1);        

 

ok_Hash.put("tFixedFlowInput_2", true);
end_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());




/**
 * [tFixedFlowInput_2 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_5 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	

	globalMap.put("tMongoDBOutput_5_NB_LINE", nb_line_tMongoDBOutput_5);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row9");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_5", true);
end_Hash.put("tMongoDBOutput_5", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk10", 0, "ok");
				}
				tMongoDBInput_1Process(globalMap);



/**
 * [tMongoDBOutput_5 end ] stop
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
	 * [tFixedFlowInput_2 finally ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_2";

	

 



/**
 * [tFixedFlowInput_2 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_5 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	


 



/**
 * [tMongoDBOutput_5 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFixedFlowInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class out2Struct implements routines.system.IPersistableRow<out2Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer _id;

				public Integer get_id () {
					return this._id;
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
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
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
		final out2Struct other = (out2Struct) obj;
		
						if (this._id == null) {
							if (other._id != null)
								return false;
						
						} else if (!this._id.equals(other._id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(out2Struct other) {

		other._id = this._id;
	            other.strMeal = this.strMeal;
	            other.strCategory = this.strCategory;
	            other.strArea = this.strArea;
	            other.strInstructions = this.strInstructions;
	            other.ingredients = this.ingredients;
	            
	}

	public void copyKeysDataTo(out2Struct other) {

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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strArea = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strArea = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.ingredients = readString(dis);
					
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
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strArea,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this._id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strArea,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("_id="+String.valueOf(_id));
		sb.append(",strMeal="+strMeal);
		sb.append(",strCategory="+strCategory);
		sb.append(",strArea="+strArea);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",ingredients="+ingredients);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out2Struct other) {

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
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];

	
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
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strArea = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strArea = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strArea,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strArea,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("strMeal="+strMeal);
		sb.append(",strCategory="+strCategory);
		sb.append(",strArea="+strArea);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",ingredients="+ingredients);
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
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
	
						result = prime * result + ((this.idMeal == null) ? 0 : this.idMeal.hashCode());
					
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
		final row1Struct other = (row1Struct) obj;
		
						if (this.idMeal == null) {
							if (other.idMeal != null)
								return false;
						
						} else if (!this.idMeal.equals(other.idMeal))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row1Struct other) {

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

	public void copyKeysDataTo(row1Struct other) {

		other.idMeal = this.idMeal;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

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
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.idMeal, other.idMeal);
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
public void tMongoDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_1_SUBPROCESS_STATE", 0);

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
out2Struct out2 = new out2Struct();






	
	/**
	 * [tMongoDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_1", false);
		start_Hash.put("tMongoDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out2");
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
                pathMap_tMongoDBOutput_1.put("strMeal","");
                pathMap_tMongoDBOutput_1.put("strCategory","");
                pathMap_tMongoDBOutput_1.put("strArea","");
                pathMap_tMongoDBOutput_1.put("strInstructions","");
                pathMap_tMongoDBOutput_1.put("ingredients","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_1=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_1=null;

        mongo_tMongoDBOutput_1=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_1 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_1 = db_tMongoDBOutput_1.getCollection(context.mongodb_collection_silver);


 



/**
 * [tMongoDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
out2Struct out2_tmp = new out2Struct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tJavaRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaRow_1", false);
		start_Hash.put("tJavaRow_1", System.currentTimeMillis());
		
	
	currentComponent="tJavaRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tJavaRow_1 = 0;
		

int nb_line_tJavaRow_1 = 0;

 



/**
 * [tJavaRow_1 begin ] stop
 */



	
	/**
	 * [tMongoDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_1", false);
		start_Hash.put("tMongoDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_1";

	
		int tos_count_tMongoDBInput_1 = 0;
		


	

final String applicationName_tMongoDBInput_1 = "Talend";

	int nb_line_tMongoDBInput_1 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_1=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_1=null;

        mongo_tMongoDBInput_1=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBInput_1 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_1 = db_tMongoDBInput_1.getCollection(context.mongodb_collection_bronze_tmdb);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_1 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_1.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_1.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_1.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_1 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

	                	
							java.util.List<org.bson.conversions.Bson> aggregationStages_tMongoDBInput_1 = new java.util.ArrayList<>();
						
	                	
	                
						com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_1 = coll_tMongoDBInput_1.aggregate(aggregationStages_tMongoDBInput_1).allowDiskUse(false).iterator();
						


				
				class DBObjectInputUtil_tMongoDBInput_1{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_1 dbObjectInputUtil_tMongoDBInput_1=new DBObjectInputUtil_tMongoDBInput_1();
				java.util.Map<String, String> pathMap_tMongoDBInput_1=new java.util.HashMap<>();
				pathMap_tMongoDBInput_1.put("idMeal","");
				pathMap_tMongoDBInput_1.put("strMeal","");
				pathMap_tMongoDBInput_1.put("strCategory","");
				pathMap_tMongoDBInput_1.put("strArea","");
				pathMap_tMongoDBInput_1.put("strInstructions","");
				pathMap_tMongoDBInput_1.put("strIngredient1","");
				pathMap_tMongoDBInput_1.put("strIngredient2","");
				pathMap_tMongoDBInput_1.put("strIngredient3","");
				pathMap_tMongoDBInput_1.put("strIngredient4","");
				pathMap_tMongoDBInput_1.put("strIngredient5","");
				pathMap_tMongoDBInput_1.put("strIngredient6","");
				pathMap_tMongoDBInput_1.put("strIngredient7","");
				pathMap_tMongoDBInput_1.put("strIngredient8","");
				pathMap_tMongoDBInput_1.put("strIngredient9","");
				pathMap_tMongoDBInput_1.put("strIngredient10","");
				pathMap_tMongoDBInput_1.put("strIngredient11","");
				pathMap_tMongoDBInput_1.put("strIngredient12","");
				pathMap_tMongoDBInput_1.put("strIngredient13","");
				pathMap_tMongoDBInput_1.put("strIngredient14","");
				pathMap_tMongoDBInput_1.put("strIngredient15","");
				pathMap_tMongoDBInput_1.put("strIngredient16","");
				pathMap_tMongoDBInput_1.put("strIngredient17","");
				pathMap_tMongoDBInput_1.put("strIngredient18","");
				pathMap_tMongoDBInput_1.put("strIngredient19","");
				pathMap_tMongoDBInput_1.put("strIngredient20","");
				pathMap_tMongoDBInput_1.put("strMeasure1","");
				pathMap_tMongoDBInput_1.put("strMeasure2","");
				pathMap_tMongoDBInput_1.put("strMeasure3","");
				pathMap_tMongoDBInput_1.put("strMeasure4","");
				pathMap_tMongoDBInput_1.put("strMeasure5","");
				pathMap_tMongoDBInput_1.put("strMeasure6","");
				pathMap_tMongoDBInput_1.put("strMeasure7","");
				pathMap_tMongoDBInput_1.put("strMeasure8","");
				pathMap_tMongoDBInput_1.put("strMeasure9","");
				pathMap_tMongoDBInput_1.put("strMeasure10","");
				pathMap_tMongoDBInput_1.put("strMeasure11","");
				pathMap_tMongoDBInput_1.put("strMeasure12","");
				pathMap_tMongoDBInput_1.put("strMeasure13","");
				pathMap_tMongoDBInput_1.put("strMeasure14","");
				pathMap_tMongoDBInput_1.put("strMeasure15","");
				pathMap_tMongoDBInput_1.put("strMeasure16","");
				pathMap_tMongoDBInput_1.put("strMeasure17","");
				pathMap_tMongoDBInput_1.put("strMeasure18","");
				pathMap_tMongoDBInput_1.put("strMeasure19","");
				pathMap_tMongoDBInput_1.put("strMeasure20","");
				pathMap_tMongoDBInput_1.put("strMealAlternate","");
				pathMap_tMongoDBInput_1.put("strMealThumb","");
				pathMap_tMongoDBInput_1.put("strTags","");
				pathMap_tMongoDBInput_1.put("strYoutube","");
				pathMap_tMongoDBInput_1.put("strSource","");
				pathMap_tMongoDBInput_1.put("strImageSource","");
				pathMap_tMongoDBInput_1.put("strCreativeCommonsConfirmed","");
				pathMap_tMongoDBInput_1.put("dateModified","");

						
				while (cursor_tMongoDBInput_1.hasNext()){
				org.bson.Document o_tMongoDBInput_1 = cursor_tMongoDBInput_1.next();
				nb_line_tMongoDBInput_1++;
				Object valueObj_tMongoDBInput_1=null;
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("idMeal"),"idMeal",o_tMongoDBInput_1);
					
				row1.idMeal = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeal"),"strMeal",o_tMongoDBInput_1);
					
				row1.strMeal = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strCategory"),"strCategory",o_tMongoDBInput_1);
					
				row1.strCategory = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strArea"),"strArea",o_tMongoDBInput_1);
					
				row1.strArea = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strInstructions"),"strInstructions",o_tMongoDBInput_1);
					
				row1.strInstructions = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient1"),"strIngredient1",o_tMongoDBInput_1);
					
				row1.strIngredient1 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient2"),"strIngredient2",o_tMongoDBInput_1);
					
				row1.strIngredient2 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient3"),"strIngredient3",o_tMongoDBInput_1);
					
				row1.strIngredient3 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient4"),"strIngredient4",o_tMongoDBInput_1);
					
				row1.strIngredient4 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient5"),"strIngredient5",o_tMongoDBInput_1);
					
				row1.strIngredient5 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient6"),"strIngredient6",o_tMongoDBInput_1);
					
				row1.strIngredient6 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient7"),"strIngredient7",o_tMongoDBInput_1);
					
				row1.strIngredient7 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient8"),"strIngredient8",o_tMongoDBInput_1);
					
				row1.strIngredient8 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient9"),"strIngredient9",o_tMongoDBInput_1);
					
				row1.strIngredient9 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient10"),"strIngredient10",o_tMongoDBInput_1);
					
				row1.strIngredient10 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient11"),"strIngredient11",o_tMongoDBInput_1);
					
				row1.strIngredient11 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient12"),"strIngredient12",o_tMongoDBInput_1);
					
				row1.strIngredient12 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient13"),"strIngredient13",o_tMongoDBInput_1);
					
				row1.strIngredient13 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient14"),"strIngredient14",o_tMongoDBInput_1);
					
				row1.strIngredient14 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient15"),"strIngredient15",o_tMongoDBInput_1);
					
				row1.strIngredient15 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient16"),"strIngredient16",o_tMongoDBInput_1);
					
				row1.strIngredient16 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient17"),"strIngredient17",o_tMongoDBInput_1);
					
				row1.strIngredient17 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient18"),"strIngredient18",o_tMongoDBInput_1);
					
				row1.strIngredient18 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient19"),"strIngredient19",o_tMongoDBInput_1);
					
				row1.strIngredient19 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strIngredient20"),"strIngredient20",o_tMongoDBInput_1);
					
				row1.strIngredient20 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure1"),"strMeasure1",o_tMongoDBInput_1);
					
				row1.strMeasure1 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure2"),"strMeasure2",o_tMongoDBInput_1);
					
				row1.strMeasure2 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure3"),"strMeasure3",o_tMongoDBInput_1);
					
				row1.strMeasure3 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure4"),"strMeasure4",o_tMongoDBInput_1);
					
				row1.strMeasure4 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure5"),"strMeasure5",o_tMongoDBInput_1);
					
				row1.strMeasure5 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure6"),"strMeasure6",o_tMongoDBInput_1);
					
				row1.strMeasure6 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure7"),"strMeasure7",o_tMongoDBInput_1);
					
				row1.strMeasure7 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure8"),"strMeasure8",o_tMongoDBInput_1);
					
				row1.strMeasure8 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure9"),"strMeasure9",o_tMongoDBInput_1);
					
				row1.strMeasure9 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure10"),"strMeasure10",o_tMongoDBInput_1);
					
				row1.strMeasure10 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure11"),"strMeasure11",o_tMongoDBInput_1);
					
				row1.strMeasure11 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure12"),"strMeasure12",o_tMongoDBInput_1);
					
				row1.strMeasure12 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure13"),"strMeasure13",o_tMongoDBInput_1);
					
				row1.strMeasure13 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure14"),"strMeasure14",o_tMongoDBInput_1);
					
				row1.strMeasure14 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure15"),"strMeasure15",o_tMongoDBInput_1);
					
				row1.strMeasure15 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure16"),"strMeasure16",o_tMongoDBInput_1);
					
				row1.strMeasure16 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure17"),"strMeasure17",o_tMongoDBInput_1);
					
				row1.strMeasure17 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure18"),"strMeasure18",o_tMongoDBInput_1);
					
				row1.strMeasure18 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure19"),"strMeasure19",o_tMongoDBInput_1);
					
				row1.strMeasure19 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeasure20"),"strMeasure20",o_tMongoDBInput_1);
					
				row1.strMeasure20 = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMealAlternate"),"strMealAlternate",o_tMongoDBInput_1);
					
				row1.strMealAlternate = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMealThumb"),"strMealThumb",o_tMongoDBInput_1);
					
				row1.strMealThumb = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strTags"),"strTags",o_tMongoDBInput_1);
					
				row1.strTags = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strYoutube"),"strYoutube",o_tMongoDBInput_1);
					
				row1.strYoutube = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strSource"),"strSource",o_tMongoDBInput_1);
					
				row1.strSource = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strImageSource"),"strImageSource",o_tMongoDBInput_1);
					
				row1.strImageSource = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strCreativeCommonsConfirmed"),"strCreativeCommonsConfirmed",o_tMongoDBInput_1);
					
				row1.strCreativeCommonsConfirmed = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("dateModified"),"dateModified",o_tMongoDBInput_1);
					
				row1.dateModified = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				


 



/**
 * [tMongoDBInput_1 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

 


	tos_count_tMongoDBInput_1++;

/**
 * [tMongoDBInput_1 main ] stop
 */
	
	/**
	 * [tMongoDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

 



/**
 * [tMongoDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tJavaRow_1 main ] start
	 */

	

	
	
	currentComponent="tJavaRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

    List<String> pairs = new ArrayList<>();

for (int i = 1; i <= 20; i++) {
    String ingredient = null;
    String measure = null;

    switch(i) {
        case 1: ingredient = row1.strIngredient1; measure = row1.strMeasure1; break;
        case 2: ingredient = row1.strIngredient2; measure = row1.strMeasure2; break;
        case 3: ingredient = row1.strIngredient3; measure = row1.strMeasure3; break;
        case 4: ingredient = row1.strIngredient4; measure = row1.strMeasure4; break;
        case 5: ingredient = row1.strIngredient5; measure = row1.strMeasure5; break;
        case 6: ingredient = row1.strIngredient6; measure = row1.strMeasure6; break;
        case 7: ingredient = row1.strIngredient7; measure = row1.strMeasure7; break;
        case 8: ingredient = row1.strIngredient8; measure = row1.strMeasure8; break;
        case 9: ingredient = row1.strIngredient9; measure = row1.strMeasure9; break;
        case 10: ingredient = row1.strIngredient10; measure = row1.strMeasure10; break;
        case 11: ingredient = row1.strIngredient11; measure = row1.strMeasure11; break;
        case 12: ingredient = row1.strIngredient12; measure = row1.strMeasure12; break;
        case 13: ingredient = row1.strIngredient13; measure = row1.strMeasure13; break;
        case 14: ingredient = row1.strIngredient14; measure = row1.strMeasure14; break;
        case 15: ingredient = row1.strIngredient15; measure = row1.strMeasure15; break;
        case 16: ingredient = row1.strIngredient16; measure = row1.strMeasure16; break;
        case 17: ingredient = row1.strIngredient17; measure = row1.strMeasure17; break;
        case 18: ingredient = row1.strIngredient18; measure = row1.strMeasure18; break;
        case 19: ingredient = row1.strIngredient19; measure = row1.strMeasure19; break;
        case 20: ingredient = row1.strIngredient20; measure = row1.strMeasure20; break;
    }

    if (ingredient != null) ingredient = ingredient.trim();
    if (measure != null) measure = measure.trim();

    if (ingredient != null && !ingredient.isEmpty()
        && measure != null && !measure.isEmpty()) {

        String value = (measure + " " + ingredient)
                        .replace("\"", "\\\"");

        pairs.add("\"" + value + "\"");
    }
}

row2.ingredients = "[" + String.join(",", pairs) + "]";
row2.strMeal = row1.strMeal;
row2.strCategory = row1.strCategory;
row2.strArea = row1.strArea;
row2.strInstructions = row1.strInstructions;
    nb_line_tJavaRow_1++;   

 


	tos_count_tJavaRow_1++;

/**
 * [tJavaRow_1 main ] stop
 */
	
	/**
	 * [tJavaRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJavaRow_1";

	

 



/**
 * [tJavaRow_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

out2 = null;


// # Output table : 'out2'
out2_tmp._id = Numeric.sequence("s3", 1, 1);
out2_tmp.strMeal = row2.strMeal ;
out2_tmp.strCategory = row2.strCategory ;
out2_tmp.strArea = row2.strArea ;
out2_tmp.strInstructions = row2.strInstructions ;
out2_tmp.ingredients = row2.ingredients ;
out2 = out2_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "out2"
if(out2 != null) { 



	
	/**
	 * [tMongoDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out2"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_1.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("_id"),"_id", out2._id);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strMeal"),"strMeal", out2.strMeal);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strCategory"),"strCategory", out2.strCategory);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strArea"),"strArea", out2.strArea);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strInstructions"),"strInstructions", out2.strInstructions);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("ingredients"),"ingredients", out2.ingredients);
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

} // End of branch "out2"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */



	
	/**
	 * [tJavaRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaRow_1";

	

 



/**
 * [tJavaRow_1 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

 



/**
 * [tMongoDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

            }
    globalMap.put("tMongoDBInput_1_NB_LINE", nb_line_tMongoDBInput_1);
 

ok_Hash.put("tMongoDBInput_1", true);
end_Hash.put("tMongoDBInput_1", System.currentTimeMillis());




/**
 * [tMongoDBInput_1 end ] stop
 */

	
	/**
	 * [tJavaRow_1 end ] start
	 */

	

	
	
	currentComponent="tJavaRow_1";

	

globalMap.put("tJavaRow_1_NB_LINE",nb_line_tJavaRow_1);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tJavaRow_1", true);
end_Hash.put("tJavaRow_1", System.currentTimeMillis());




/**
 * [tJavaRow_1 end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	

	globalMap.put("tMongoDBOutput_1_NB_LINE", nb_line_tMongoDBOutput_1);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out2");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_1", true);
end_Hash.put("tMongoDBOutput_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tMongoDBInput_3Process(globalMap);



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
	 * [tMongoDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

 



/**
 * [tMongoDBInput_1 finally ] stop
 */

	
	/**
	 * [tJavaRow_1 finally ] start
	 */

	

	
	
	currentComponent="tJavaRow_1";

	

 



/**
 * [tJavaRow_1 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
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
		

		globalMap.put("tMongoDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];

	
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				
			    public Integer calories;

				public Integer getCalories () {
					return this.calories;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
						this.calories = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
						this.calories = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
					// Integer
				
						writeInteger(this.calories,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
					// Integer
				
						writeInteger(this.calories,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("nom="+nom);
		sb.append(",calories="+String.valueOf(calories));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row7Struct other) {

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

public static class OnRowsEndStructtAggregateRow_1 implements routines.system.IPersistableRow<OnRowsEndStructtAggregateRow_1> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];

	
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				
			    public Integer calories;

				public Integer getCalories () {
					return this.calories;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
						this.calories = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
						this.calories = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
					// Integer
				
						writeInteger(this.calories,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
					// Integer
				
						writeInteger(this.calories,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("nom="+nom);
		sb.append(",calories="+String.valueOf(calories));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(OnRowsEndStructtAggregateRow_1 other) {

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

public static class row8Struct implements routines.system.IPersistableRow<row8Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];

	
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				
			    public Integer calories;

				public Integer getCalories () {
					return this.calories;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
						this.calories = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
						this.calories = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
					// Integer
				
						writeInteger(this.calories,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
					// Integer
				
						writeInteger(this.calories,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("nom="+nom);
		sb.append(",calories="+String.valueOf(calories));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row8Struct other) {

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

public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];

	
			    public String ID;

				public String getID () {
					return this.ID;
				}
				
			    public String Description;

				public String getDescription () {
					return this.Description;
				}
				
			    public String Calories;

				public String getCalories () {
					return this.Calories;
				}
				
			    public String Protein;

				public String getProtein () {
					return this.Protein;
				}
				
			    public String TotalFat;

				public String getTotalFat () {
					return this.TotalFat;
				}
				
			    public String Carbohydrate;

				public String getCarbohydrate () {
					return this.Carbohydrate;
				}
				
			    public String Sodium;

				public String getSodium () {
					return this.Sodium;
				}
				
			    public String SaturatedFat;

				public String getSaturatedFat () {
					return this.SaturatedFat;
				}
				
			    public String Cholesterol;

				public String getCholesterol () {
					return this.Cholesterol;
				}
				
			    public String Sugar;

				public String getSugar () {
					return this.Sugar;
				}
				
			    public String Calcium;

				public String getCalcium () {
					return this.Calcium;
				}
				
			    public String Iron;

				public String getIron () {
					return this.Iron;
				}
				
			    public String Potassium;

				public String getPotassium () {
					return this.Potassium;
				}
				
			    public String VitaminC;

				public String getVitaminC () {
					return this.VitaminC;
				}
				
			    public String VitaminE;

				public String getVitaminE () {
					return this.VitaminE;
				}
				
			    public String VitaminD;

				public String getVitaminD () {
					return this.VitaminD;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
					this.ID = readString(dis);
					
					this.Description = readString(dis);
					
					this.Calories = readString(dis);
					
					this.Protein = readString(dis);
					
					this.TotalFat = readString(dis);
					
					this.Carbohydrate = readString(dis);
					
					this.Sodium = readString(dis);
					
					this.SaturatedFat = readString(dis);
					
					this.Cholesterol = readString(dis);
					
					this.Sugar = readString(dis);
					
					this.Calcium = readString(dis);
					
					this.Iron = readString(dis);
					
					this.Potassium = readString(dis);
					
					this.VitaminC = readString(dis);
					
					this.VitaminE = readString(dis);
					
					this.VitaminD = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
					this.ID = readString(dis);
					
					this.Description = readString(dis);
					
					this.Calories = readString(dis);
					
					this.Protein = readString(dis);
					
					this.TotalFat = readString(dis);
					
					this.Carbohydrate = readString(dis);
					
					this.Sodium = readString(dis);
					
					this.SaturatedFat = readString(dis);
					
					this.Cholesterol = readString(dis);
					
					this.Sugar = readString(dis);
					
					this.Calcium = readString(dis);
					
					this.Iron = readString(dis);
					
					this.Potassium = readString(dis);
					
					this.VitaminC = readString(dis);
					
					this.VitaminE = readString(dis);
					
					this.VitaminD = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.ID,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// String
				
						writeString(this.Calories,dos);
					
					// String
				
						writeString(this.Protein,dos);
					
					// String
				
						writeString(this.TotalFat,dos);
					
					// String
				
						writeString(this.Carbohydrate,dos);
					
					// String
				
						writeString(this.Sodium,dos);
					
					// String
				
						writeString(this.SaturatedFat,dos);
					
					// String
				
						writeString(this.Cholesterol,dos);
					
					// String
				
						writeString(this.Sugar,dos);
					
					// String
				
						writeString(this.Calcium,dos);
					
					// String
				
						writeString(this.Iron,dos);
					
					// String
				
						writeString(this.Potassium,dos);
					
					// String
				
						writeString(this.VitaminC,dos);
					
					// String
				
						writeString(this.VitaminE,dos);
					
					// String
				
						writeString(this.VitaminD,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.ID,dos);
					
					// String
				
						writeString(this.Description,dos);
					
					// String
				
						writeString(this.Calories,dos);
					
					// String
				
						writeString(this.Protein,dos);
					
					// String
				
						writeString(this.TotalFat,dos);
					
					// String
				
						writeString(this.Carbohydrate,dos);
					
					// String
				
						writeString(this.Sodium,dos);
					
					// String
				
						writeString(this.SaturatedFat,dos);
					
					// String
				
						writeString(this.Cholesterol,dos);
					
					// String
				
						writeString(this.Sugar,dos);
					
					// String
				
						writeString(this.Calcium,dos);
					
					// String
				
						writeString(this.Iron,dos);
					
					// String
				
						writeString(this.Potassium,dos);
					
					// String
				
						writeString(this.VitaminC,dos);
					
					// String
				
						writeString(this.VitaminE,dos);
					
					// String
				
						writeString(this.VitaminD,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ID="+ID);
		sb.append(",Description="+Description);
		sb.append(",Calories="+Calories);
		sb.append(",Protein="+Protein);
		sb.append(",TotalFat="+TotalFat);
		sb.append(",Carbohydrate="+Carbohydrate);
		sb.append(",Sodium="+Sodium);
		sb.append(",SaturatedFat="+SaturatedFat);
		sb.append(",Cholesterol="+Cholesterol);
		sb.append(",Sugar="+Sugar);
		sb.append(",Calcium="+Calcium);
		sb.append(",Iron="+Iron);
		sb.append(",Potassium="+Potassium);
		sb.append(",VitaminC="+VitaminC);
		sb.append(",VitaminE="+VitaminE);
		sb.append(",VitaminD="+VitaminD);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row6Struct other) {

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
public void tMongoDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
		String currentVirtualComponent = null;
	
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



		row6Struct row6 = new row6Struct();
row8Struct row8 = new row8Struct();
row7Struct row7 = new row7Struct();





	
	/**
	 * [tAggregateRow_1_AGGOUT begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_1_AGGOUT", false);
		start_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row8");
					}
				
		int tos_count_tAggregateRow_1_AGGOUT = 0;
		

// ------------ Seems it is not used

java.util.Map hashAggreg_tAggregateRow_1 = new java.util.HashMap(); 

// ------------

	class UtilClass_tAggregateRow_1 { // G_OutBegin_AggR_144

		public double sd(Double[] data) {
	        final int n = data.length;
        	if (n < 2) {
	            return Double.NaN;
        	}
        	double d1 = 0d;
        	double d2 =0d;
	        
	        for (int i = 0; i < data.length; i++) {
            	d1 += (data[i]*data[i]);
            	d2 += data[i];
        	}
        
	        return Math.sqrt((n*d1 - d2*d2)/n/(n-1));
	    }
	    
		public void checkedIADD(byte a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
		    byte r = (byte) (a + b);
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'short/Short'", "'byte/Byte'"));
		    }
		}
		
		public void checkedIADD(short a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
		    short r = (short) (a + b);
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'int/Integer'", "'short/Short'"));
		    }
		}
		
		public void checkedIADD(int a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
		    int r = a + b;
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'long/Long'", "'int/Integer'"));
		    }
		}
		
		public void checkedIADD(long a, long b, boolean checkTypeOverFlow, boolean checkUlp) {
		    long r = a + b;
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'long/Long'"));
		    }
		}
		
		public void checkedIADD(float a, float b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    float minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(b), "'double' or 'BigDecimal'", "'float/Float'"));
			    }
			}
			
		    if (checkTypeOverFlow && ((double) a + (double) b > (double) Float.MAX_VALUE) || ((double) a + (double) b < (double) -Float.MAX_VALUE)) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'double' or 'BigDecimal'", "'float/Float'"));
		    }
		}
		
		public void checkedIADD(double a, double b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    double minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), "'BigDecimal'", "'double/Double'"));
			    }
			}
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, float b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    double minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), "'BigDecimal'", "'double/Double'"));
			    }
			}
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		private String buildOverflowMessage(String a, String b, String advicedTypes, String originalType) {
		    return "Type overflow when adding " + b + " to " + a
		    + ", to resolve this problem, increase the precision by using "+ advicedTypes +" type in place of "+ originalType +".";
		}
		
		private String buildPrecisionMessage(String a, String b, String advicedTypes, String originalType) {
		    return "The double precision is unsufficient to add the value " + b + " to " + a
		    + ", to resolve this problem, increase the precision by using "+ advicedTypes +" type in place of "+ originalType +".";
		}

	} // G_OutBegin_AggR_144

	UtilClass_tAggregateRow_1 utilClass_tAggregateRow_1 = new UtilClass_tAggregateRow_1();

	

	class AggOperationStruct_tAggregateRow_1 { // G_OutBegin_AggR_100

		private static final int DEFAULT_HASHCODE = 1;
	    private static final int PRIME = 31;
	    private int hashCode = DEFAULT_HASHCODE;
	    public boolean hashCodeDirty = true;

    				String nom;
         			Integer calories_max;
        
	    @Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;
		
							result = prime * result + ((this.nom == null) ? 0 : this.nom.hashCode());
							
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
			final AggOperationStruct_tAggregateRow_1 other = (AggOperationStruct_tAggregateRow_1) obj;
			
							if (this.nom == null) {
								if (other.nom != null) 
									return false;
							} else if (!this.nom.equals(other.nom)) 
								return false;
						
			
			return true;
		}
  
        
	} // G_OutBegin_AggR_100

	AggOperationStruct_tAggregateRow_1 operation_result_tAggregateRow_1 = null;
	AggOperationStruct_tAggregateRow_1 operation_finder_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();
	java.util.Map<AggOperationStruct_tAggregateRow_1,AggOperationStruct_tAggregateRow_1> hash_tAggregateRow_1 = new java.util.HashMap<AggOperationStruct_tAggregateRow_1,AggOperationStruct_tAggregateRow_1>();
	

 



/**
 * [tAggregateRow_1_AGGOUT begin ] stop
 */



	
	/**
	 * [tJavaRow_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaRow_4", false);
		start_Hash.put("tJavaRow_4", System.currentTimeMillis());
		
	
	currentComponent="tJavaRow_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row6");
					}
				
		int tos_count_tJavaRow_4 = 0;
		

int nb_line_tJavaRow_4 = 0;

 



/**
 * [tJavaRow_4 begin ] stop
 */



	
	/**
	 * [tMongoDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_3", false);
		start_Hash.put("tMongoDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_3";

	
		int tos_count_tMongoDBInput_3 = 0;
		


	

final String applicationName_tMongoDBInput_3 = "Talend";

	int nb_line_tMongoDBInput_3 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_3=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_3=null;

        mongo_tMongoDBInput_3=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBInput_3 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_3 = db_tMongoDBInput_3.getCollection(context.mongodb_collection_bronze_nutritional);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_3 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_3.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_3.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_3.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_3 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

	                	
							java.util.List<org.bson.conversions.Bson> aggregationStages_tMongoDBInput_3 = new java.util.ArrayList<>();
						
	                	
	                
						com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_3 = coll_tMongoDBInput_3.aggregate(aggregationStages_tMongoDBInput_3).allowDiskUse(false).iterator();
						


				
				class DBObjectInputUtil_tMongoDBInput_3{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_3 dbObjectInputUtil_tMongoDBInput_3=new DBObjectInputUtil_tMongoDBInput_3();
				java.util.Map<String, String> pathMap_tMongoDBInput_3=new java.util.HashMap<>();
				pathMap_tMongoDBInput_3.put("ID","");
				pathMap_tMongoDBInput_3.put("Description","");
				pathMap_tMongoDBInput_3.put("Calories","");
				pathMap_tMongoDBInput_3.put("Protein","");
				pathMap_tMongoDBInput_3.put("TotalFat","");
				pathMap_tMongoDBInput_3.put("Carbohydrate","");
				pathMap_tMongoDBInput_3.put("Sodium","");
				pathMap_tMongoDBInput_3.put("SaturatedFat","");
				pathMap_tMongoDBInput_3.put("Cholesterol","");
				pathMap_tMongoDBInput_3.put("Sugar","");
				pathMap_tMongoDBInput_3.put("Calcium","");
				pathMap_tMongoDBInput_3.put("Iron","");
				pathMap_tMongoDBInput_3.put("Potassium","");
				pathMap_tMongoDBInput_3.put("VitaminC","");
				pathMap_tMongoDBInput_3.put("VitaminE","");
				pathMap_tMongoDBInput_3.put("VitaminD","");

						
				while (cursor_tMongoDBInput_3.hasNext()){
				org.bson.Document o_tMongoDBInput_3 = cursor_tMongoDBInput_3.next();
				nb_line_tMongoDBInput_3++;
				Object valueObj_tMongoDBInput_3=null;
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("ID"),"ID",o_tMongoDBInput_3);
					
				row6.ID = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("Description"),"Description",o_tMongoDBInput_3);
					
				row6.Description = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("Calories"),"Calories",o_tMongoDBInput_3);
					
				row6.Calories = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("Protein"),"Protein",o_tMongoDBInput_3);
					
				row6.Protein = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("TotalFat"),"TotalFat",o_tMongoDBInput_3);
					
				row6.TotalFat = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("Carbohydrate"),"Carbohydrate",o_tMongoDBInput_3);
					
				row6.Carbohydrate = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("Sodium"),"Sodium",o_tMongoDBInput_3);
					
				row6.Sodium = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("SaturatedFat"),"SaturatedFat",o_tMongoDBInput_3);
					
				row6.SaturatedFat = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("Cholesterol"),"Cholesterol",o_tMongoDBInput_3);
					
				row6.Cholesterol = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("Sugar"),"Sugar",o_tMongoDBInput_3);
					
				row6.Sugar = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("Calcium"),"Calcium",o_tMongoDBInput_3);
					
				row6.Calcium = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("Iron"),"Iron",o_tMongoDBInput_3);
					
				row6.Iron = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("Potassium"),"Potassium",o_tMongoDBInput_3);
					
				row6.Potassium = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("VitaminC"),"VitaminC",o_tMongoDBInput_3);
					
				row6.VitaminC = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("VitaminE"),"VitaminE",o_tMongoDBInput_3);
					
				row6.VitaminE = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("VitaminD"),"VitaminD",o_tMongoDBInput_3);
					
				row6.VitaminD = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				


 



/**
 * [tMongoDBInput_3 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

 


	tos_count_tMongoDBInput_3++;

/**
 * [tMongoDBInput_3 main ] stop
 */
	
	/**
	 * [tMongoDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

 



/**
 * [tMongoDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tJavaRow_4 main ] start
	 */

	

	
	
	currentComponent="tJavaRow_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row6"
						
						);
					}
					

    if (!row6.Calories.equals("")) {
	row8.nom = row6.Description.toLowerCase().split(",")[0].replace("(","").replace(")","").replace(":","");
	row8.calories = Integer.parseInt(row6.Calories);
}
    nb_line_tJavaRow_4++;   

 


	tos_count_tJavaRow_4++;

/**
 * [tJavaRow_4 main ] stop
 */
	
	/**
	 * [tJavaRow_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJavaRow_4";

	

 



/**
 * [tJavaRow_4 process_data_begin ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGOUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row8"
						
						);
					}
					
	
operation_finder_tAggregateRow_1.nom = row8.nom;
			

	operation_finder_tAggregateRow_1.hashCodeDirty = true;
	
	operation_result_tAggregateRow_1 = hash_tAggregateRow_1.get(operation_finder_tAggregateRow_1);

	
		boolean isFirstAdd_tAggregateRow_1 = false;
	

	if(operation_result_tAggregateRow_1 == null) { // G_OutMain_AggR_001

		operation_result_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();

		operation_result_tAggregateRow_1.nom = operation_finder_tAggregateRow_1.nom;
				
		
		
			isFirstAdd_tAggregateRow_1 = true;
		

		hash_tAggregateRow_1.put(operation_result_tAggregateRow_1, operation_result_tAggregateRow_1);
	
	} // G_OutMain_AggR_001


	
					if(
						operation_result_tAggregateRow_1.calories_max == null || 
						row8.calories > operation_result_tAggregateRow_1.calories_max
						
					) {
						operation_result_tAggregateRow_1.calories_max = row8.calories;
					}
					


 


	tos_count_tAggregateRow_1_AGGOUT++;

/**
 * [tAggregateRow_1_AGGOUT main ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGOUT process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

 



/**
 * [tAggregateRow_1_AGGOUT process_data_begin ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGOUT process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

 



/**
 * [tAggregateRow_1_AGGOUT process_data_end ] stop
 */



	
	/**
	 * [tJavaRow_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaRow_4";

	

 



/**
 * [tJavaRow_4 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

 



/**
 * [tMongoDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

            }
    globalMap.put("tMongoDBInput_3_NB_LINE", nb_line_tMongoDBInput_3);
 

ok_Hash.put("tMongoDBInput_3", true);
end_Hash.put("tMongoDBInput_3", System.currentTimeMillis());




/**
 * [tMongoDBInput_3 end ] stop
 */

	
	/**
	 * [tJavaRow_4 end ] start
	 */

	

	
	
	currentComponent="tJavaRow_4";

	

globalMap.put("tJavaRow_4_NB_LINE",nb_line_tJavaRow_4);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row6");
			  	}
			  	
 

ok_Hash.put("tJavaRow_4", true);
end_Hash.put("tJavaRow_4", System.currentTimeMillis());




/**
 * [tJavaRow_4 end ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGOUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row8");
			  	}
			  	
 

ok_Hash.put("tAggregateRow_1_AGGOUT", true);
end_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());




/**
 * [tAggregateRow_1_AGGOUT end ] stop
 */


	
	/**
	 * [tMongoDBOutput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_4", false);
		start_Hash.put("tMongoDBOutput_4", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row7");
					}
				
		int tos_count_tMongoDBOutput_4 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_4 = "Talend";

    int nb_line_tMongoDBOutput_4 = 0;

			class DBObjectUtil_tMongoDBOutput_4 {
				
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
            DBObjectUtil_tMongoDBOutput_4 updateObjectUtil_tMongoDBOutput_4=new DBObjectUtil_tMongoDBOutput_4();
            DBObjectUtil_tMongoDBOutput_4 queryObjectUtil_tMongoDBOutput_4=new DBObjectUtil_tMongoDBOutput_4();
            java.util.Map<String, String> pathMap_tMongoDBOutput_4=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_4.put("nom","");
                pathMap_tMongoDBOutput_4.put("calories","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_4=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_4=null;

        mongo_tMongoDBOutput_4=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_4 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

        db_tMongoDBOutput_4.getCollection(context.mongodb_collection_silver_nutrition).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_4 = db_tMongoDBOutput_4.getCollection(context.mongodb_collection_silver_nutrition);


 



/**
 * [tMongoDBOutput_4 begin ] stop
 */



	
	/**
	 * [tAggregateRow_1_AGGIN begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_1_AGGIN", false);
		start_Hash.put("tAggregateRow_1_AGGIN", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	
		int tos_count_tAggregateRow_1_AGGIN = 0;
		

java.util.Collection<AggOperationStruct_tAggregateRow_1> values_tAggregateRow_1 = hash_tAggregateRow_1.values();

globalMap.put("tAggregateRow_1_NB_LINE", values_tAggregateRow_1.size());

for(AggOperationStruct_tAggregateRow_1 aggregated_row_tAggregateRow_1 : values_tAggregateRow_1) { // G_AggR_600



 



/**
 * [tAggregateRow_1_AGGIN begin ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGIN main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

            				    row7.nom = aggregated_row_tAggregateRow_1.nom;
            				    
                                row7.calories = aggregated_row_tAggregateRow_1.calories_max;

 


	tos_count_tAggregateRow_1_AGGIN++;

/**
 * [tAggregateRow_1_AGGIN main ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGIN process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

 



/**
 * [tAggregateRow_1_AGGIN process_data_begin ] stop
 */

	
	/**
	 * [tMongoDBOutput_4 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row7"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_4.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("nom"),"nom", row7.nom);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("calories"),"calories", row7.calories);
				org.bson.Document updateObj_tMongoDBOutput_4 = updateObjectUtil_tMongoDBOutput_4.getObject();
				
						coll_tMongoDBOutput_4.insertOne(updateObj_tMongoDBOutput_4);
					
				} catch (Exception e_tMongoDBOutput_4) {
				
    					
    						System.err.println(e_tMongoDBOutput_4.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_4 ++;
				
 


	tos_count_tMongoDBOutput_4++;

/**
 * [tMongoDBOutput_4 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	

 



/**
 * [tMongoDBOutput_4 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	

 



/**
 * [tMongoDBOutput_4 process_data_end ] stop
 */



	
	/**
	 * [tAggregateRow_1_AGGIN process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

 



/**
 * [tAggregateRow_1_AGGIN process_data_end ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGIN end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

} // G_AggR_600

 

ok_Hash.put("tAggregateRow_1_AGGIN", true);
end_Hash.put("tAggregateRow_1_AGGIN", System.currentTimeMillis());




/**
 * [tAggregateRow_1_AGGIN end ] stop
 */

	
	/**
	 * [tMongoDBOutput_4 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	

	globalMap.put("tMongoDBOutput_4_NB_LINE", nb_line_tMongoDBOutput_4);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row7");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_4", true);
end_Hash.put("tMongoDBOutput_4", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
				}
				tJava_2Process(globalMap);



/**
 * [tMongoDBOutput_4 end ] stop
 */












				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
							//free memory for "tAggregateRow_1_AGGIN"
							globalMap.remove("tAggregateRow_1");
						
				try{
					
	
	/**
	 * [tMongoDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

 



/**
 * [tMongoDBInput_3 finally ] stop
 */

	
	/**
	 * [tJavaRow_4 finally ] start
	 */

	

	
	
	currentComponent="tJavaRow_4";

	

 



/**
 * [tJavaRow_4 finally ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGOUT finally ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

 



/**
 * [tAggregateRow_1_AGGOUT finally ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGIN finally ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

 



/**
 * [tAggregateRow_1_AGGIN finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_4 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	


 



/**
 * [tMongoDBOutput_4 finally ] stop
 */












				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tMongoDBInput_3_SUBPROCESS_STATE", 1);
	}
	

public void tJava_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_2_SUBPROCESS_STATE", 0);

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
	 * [tJava_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_2", false);
		start_Hash.put("tJava_2", System.currentTimeMillis());
		
	
	currentComponent="tJava_2";

	
		int tos_count_tJava_2 = 0;
		


// Pipeline MongoDB pour maxId
String stage1 = "{ \\\"$addFields\\\": { \\\"idNum\\\": { \\\"$toInt\\\": \\\"$_id\\\" } } }";
String stage2 = "{ \\\"$group\\\": { \\\"_id\\\": null, \\\"maxId\\\": { \\\"$max\\\": \\\"$idNum\\\" } } }";

// Stocker dans globalMap
globalMap.put("STAGE1", stage1);
globalMap.put("STAGE2", stage2);

 



/**
 * [tJava_2 begin ] stop
 */
	
	/**
	 * [tJava_2 main ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 


	tos_count_tJava_2++;

/**
 * [tJava_2 main ] stop
 */
	
	/**
	 * [tJava_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_begin ] stop
 */
	
	/**
	 * [tJava_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_end ] stop
 */
	
	/**
	 * [tJava_2 end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 

ok_Hash.put("tJava_2", true);
end_Hash.put("tJava_2", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk13", 0, "ok");
				}
				tMongoDBInput_4Process(globalMap);



/**
 * [tJava_2 end ] stop
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
	 * [tJava_2 finally ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_2_SUBPROCESS_STATE", 1);
	}
	


public static class row10Struct implements routines.system.IPersistableRow<row10Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];

	
			    public Integer _id;

				public Integer get_id () {
					return this._id;
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this._id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this._id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("_id="+String.valueOf(_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row10Struct other) {

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
public void tMongoDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_4_SUBPROCESS_STATE", 0);

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



		row10Struct row10 = new row10Struct();




	
	/**
	 * [tJavaRow_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaRow_3", false);
		start_Hash.put("tJavaRow_3", System.currentTimeMillis());
		
	
	currentComponent="tJavaRow_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row10");
					}
				
		int tos_count_tJavaRow_3 = 0;
		

int nb_line_tJavaRow_3 = 0;

 



/**
 * [tJavaRow_3 begin ] stop
 */



	
	/**
	 * [tMongoDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_4", false);
		start_Hash.put("tMongoDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_4";

	
		int tos_count_tMongoDBInput_4 = 0;
		


	

final String applicationName_tMongoDBInput_4 = "Talend";

	int nb_line_tMongoDBInput_4 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_4=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_4=null;

        mongo_tMongoDBInput_4=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBInput_4 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_4 = db_tMongoDBInput_4.getCollection(context.mongodb_collection_bronze_k);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_4 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_4.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_4.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_4.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_4 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_4 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_4 = coll_tMongoDBInput_4.find(myQuery_tMongoDBInput_4).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_4{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_4 dbObjectInputUtil_tMongoDBInput_4=new DBObjectInputUtil_tMongoDBInput_4();
				java.util.Map<String, String> pathMap_tMongoDBInput_4=new java.util.HashMap<>();
				pathMap_tMongoDBInput_4.put("_id","");
						
					findIterable_tMongoDBInput_4 = findIterable_tMongoDBInput_4.limit(1);
						
	  			
						
					com.mongodb.BasicDBObject orderBy_tMongoDBInput_4 = new com.mongodb.BasicDBObject();
						
		  		
		  		orderBy_tMongoDBInput_4.put("_id",-1);
						
					findIterable_tMongoDBInput_4.sort(orderBy_tMongoDBInput_4);
						
				

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_4 = findIterable_tMongoDBInput_4.iterator();
						
				while (cursor_tMongoDBInput_4.hasNext()){
				org.bson.Document o_tMongoDBInput_4 = cursor_tMongoDBInput_4.next();
				nb_line_tMongoDBInput_4++;
				Object valueObj_tMongoDBInput_4=null;
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("_id"),"_id",o_tMongoDBInput_4);
				if(valueObj_tMongoDBInput_4!=null && valueObj_tMongoDBInput_4.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_4.getClass().equals(Double.class)) {
                                row10._id = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_4.toString()).intValue();
                            } else {
                                row10._id = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_4.toString());
                            }
				}else{
					row10._id = null;
				}


 



/**
 * [tMongoDBInput_4 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_4";

	

 


	tos_count_tMongoDBInput_4++;

/**
 * [tMongoDBInput_4 main ] stop
 */
	
	/**
	 * [tMongoDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_4";

	

 



/**
 * [tMongoDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tJavaRow_3 main ] start
	 */

	

	
	
	currentComponent="tJavaRow_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row10"
						
						);
					}
					

    globalMap.put("MAX_ID", row10._id);
    nb_line_tJavaRow_3++;   

 


	tos_count_tJavaRow_3++;

/**
 * [tJavaRow_3 main ] stop
 */
	
	/**
	 * [tJavaRow_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJavaRow_3";

	

 



/**
 * [tJavaRow_3 process_data_begin ] stop
 */
	
	/**
	 * [tJavaRow_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaRow_3";

	

 



/**
 * [tJavaRow_3 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_4";

	

 



/**
 * [tMongoDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_4";

	

            }
    globalMap.put("tMongoDBInput_4_NB_LINE", nb_line_tMongoDBInput_4);
 

ok_Hash.put("tMongoDBInput_4", true);
end_Hash.put("tMongoDBInput_4", System.currentTimeMillis());




/**
 * [tMongoDBInput_4 end ] stop
 */

	
	/**
	 * [tJavaRow_3 end ] start
	 */

	

	
	
	currentComponent="tJavaRow_3";

	

globalMap.put("tJavaRow_3_NB_LINE",nb_line_tJavaRow_3);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row10");
			  	}
			  	
 

ok_Hash.put("tJavaRow_3", true);
end_Hash.put("tJavaRow_3", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk11", 0, "ok");
				}
				tLoop_1Process(globalMap);



/**
 * [tJavaRow_3 end ] stop
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
	 * [tMongoDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_4";

	

 



/**
 * [tMongoDBInput_4 finally ] stop
 */

	
	/**
	 * [tJavaRow_3 finally ] start
	 */

	

	
	
	currentComponent="tJavaRow_3";

	

 



/**
 * [tJavaRow_3 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tMongoDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer _id;

				public Integer get_id () {
					return this._id;
				}
				
			    public String strMeal;

				public String getStrMeal () {
					return this.strMeal;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
				}
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String strCategory;

				public String getStrCategory () {
					return this.strCategory;
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
		final row4Struct other = (row4Struct) obj;
		
						if (this._id == null) {
							if (other._id != null)
								return false;
						
						} else if (!this._id.equals(other._id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other._id = this._id;
	            other.strMeal = this.strMeal;
	            other.ingredients = this.ingredients;
	            other.strInstructions = this.strInstructions;
	            other.strCategory = this.strCategory;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.ingredients = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.strCategory = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.ingredients = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.strCategory = readString(dis);
					
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
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this._id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("_id="+String.valueOf(_id));
		sb.append(",strMeal="+strMeal);
		sb.append(",ingredients="+ingredients);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",strCategory="+strCategory);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

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

public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer _id;

				public Integer get_id () {
					return this._id;
				}
				
			    public String strMeal;

				public String getStrMeal () {
					return this.strMeal;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
				}
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String strCategory;

				public String getStrCategory () {
					return this.strCategory;
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
	            other.strMeal = this.strMeal;
	            other.ingredients = this.ingredients;
	            other.strInstructions = this.strInstructions;
	            other.strCategory = this.strCategory;
	            
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.ingredients = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.strCategory = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.ingredients = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.strCategory = readString(dis);
					
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
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this._id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("_id="+String.valueOf(_id));
		sb.append(",strMeal="+strMeal);
		sb.append(",ingredients="+ingredients);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",strCategory="+strCategory);
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

public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadSilver = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadSilver = new byte[0];

	
			    public Integer _id;

				public Integer get_id () {
					return this._id;
				}
				
			    public String title;

				public String getTitle () {
					return this.title;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
				}
				
			    public String directions;

				public String getDirections () {
					return this.directions;
				}
				
			    public String link;

				public String getLink () {
					return this.link;
				}
				
			    public String source;

				public String getSource () {
					return this.source;
				}
				
			    public String NER;

				public String getNER () {
					return this.NER;
				}
				
			    public String site;

				public String getSite () {
					return this.site;
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadSilver.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadSilver.length == 0) {
   					commonByteArray_PROJECT_LoadSilver = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadSilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadSilver, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadSilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.title = readString(dis);
					
					this.ingredients = readString(dis);
					
					this.directions = readString(dis);
					
					this.link = readString(dis);
					
					this.source = readString(dis);
					
					this.NER = readString(dis);
					
					this.site = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadSilver) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.title = readString(dis);
					
					this.ingredients = readString(dis);
					
					this.directions = readString(dis);
					
					this.link = readString(dis);
					
					this.source = readString(dis);
					
					this.NER = readString(dis);
					
					this.site = readString(dis);
					
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
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
					// String
				
						writeString(this.directions,dos);
					
					// String
				
						writeString(this.link,dos);
					
					// String
				
						writeString(this.source,dos);
					
					// String
				
						writeString(this.NER,dos);
					
					// String
				
						writeString(this.site,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this._id,dos);
					
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
					// String
				
						writeString(this.directions,dos);
					
					// String
				
						writeString(this.link,dos);
					
					// String
				
						writeString(this.source,dos);
					
					// String
				
						writeString(this.NER,dos);
					
					// String
				
						writeString(this.site,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("_id="+String.valueOf(_id));
		sb.append(",title="+title);
		sb.append(",ingredients="+ingredients);
		sb.append(",directions="+directions);
		sb.append(",link="+link);
		sb.append(",source="+source);
		sb.append(",NER="+NER);
		sb.append(",site="+site);
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



		row3Struct row3 = new row3Struct();
out1Struct out1 = new out1Struct();
row4Struct row4 = new row4Struct();



	
	/**
	 * [tLoop_1 begin ] start
	 */

				
			int NB_ITERATE_tMongoDBInput_2 = 0; //for statistics
			

	
		
		ok_Hash.put("tLoop_1", false);
		start_Hash.put("tLoop_1", System.currentTimeMillis());
		
	
	currentComponent="tLoop_1";

	
		int tos_count_tLoop_1 = 0;
		

int current_iteration_tLoop_1 = 0;

for(int looptLoop_1 =1; looptLoop_1<=(int) globalMap.get("MAX_ID"); looptLoop_1=looptLoop_1+10000){
	
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
	NB_ITERATE_tMongoDBInput_2++;
	
	
					if(execStat){				
	       				runStat.updateStatOnConnection("out1", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row3", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row4", 3, 0);
					}           			
				
				if(execStat){
					runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tMongoDBInput_2);
					//Thread.sleep(1000);
				}				
			




	
	/**
	 * [tMongoDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_2", false);
		start_Hash.put("tMongoDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
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

                pathMap_tMongoDBOutput_2.put("_id","");
                pathMap_tMongoDBOutput_2.put("strMeal","");
                pathMap_tMongoDBOutput_2.put("ingredients","");
                pathMap_tMongoDBOutput_2.put("strInstructions","");
                pathMap_tMongoDBOutput_2.put("strCategory","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_2=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_2=null;

        mongo_tMongoDBOutput_2=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_2 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_2 = db_tMongoDBOutput_2.getCollection(context.mongodb_collection_silver);


 



/**
 * [tMongoDBOutput_2 begin ] stop
 */



	
	/**
	 * [tJavaRow_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaRow_2", false);
		start_Hash.put("tJavaRow_2", System.currentTimeMillis());
		
	
	currentComponent="tJavaRow_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out1");
					}
				
		int tos_count_tJavaRow_2 = 0;
		

int nb_line_tJavaRow_2 = 0;

 



/**
 * [tJavaRow_2 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
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
	 * [tMongoDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_2", false);
		start_Hash.put("tMongoDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_2";

	
		int tos_count_tMongoDBInput_2 = 0;
		


	

final String applicationName_tMongoDBInput_2 = "Talend";

	int nb_line_tMongoDBInput_2 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_2=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_2=null;

        mongo_tMongoDBInput_2=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBInput_2 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_2 = db_tMongoDBInput_2.getCollection(context.mongodb_collection_bronze_k);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_2 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_2.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{ \"_id\": { \"$gte\": " + ((Integer)globalMap.get("tLoop_1_CURRENT_VALUE")) + ", \"$lt\": " + (((Integer)globalMap.get("tLoop_1_CURRENT_VALUE")) + 10000) + " } }").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_2.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_2.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_2 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_2 = org.bson.Document.parse("{ \"_id\": { \"$gte\": " + ((Integer)globalMap.get("tLoop_1_CURRENT_VALUE")) + ", \"$lt\": " + (((Integer)globalMap.get("tLoop_1_CURRENT_VALUE")) + 10000) + " } }");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_2 = coll_tMongoDBInput_2.find(myQuery_tMongoDBInput_2).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_2{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_2 dbObjectInputUtil_tMongoDBInput_2=new DBObjectInputUtil_tMongoDBInput_2();
				java.util.Map<String, String> pathMap_tMongoDBInput_2=new java.util.HashMap<>();
				pathMap_tMongoDBInput_2.put("_id","");
				pathMap_tMongoDBInput_2.put("title","");
				pathMap_tMongoDBInput_2.put("ingredients","");
				pathMap_tMongoDBInput_2.put("directions","");
				pathMap_tMongoDBInput_2.put("link","");
				pathMap_tMongoDBInput_2.put("source","");
				pathMap_tMongoDBInput_2.put("NER","");
				pathMap_tMongoDBInput_2.put("site","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_2 = findIterable_tMongoDBInput_2.iterator();
						
				while (cursor_tMongoDBInput_2.hasNext()){
				org.bson.Document o_tMongoDBInput_2 = cursor_tMongoDBInput_2.next();
				nb_line_tMongoDBInput_2++;
				Object valueObj_tMongoDBInput_2=null;
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("_id"),"_id",o_tMongoDBInput_2);
				if(valueObj_tMongoDBInput_2!=null && valueObj_tMongoDBInput_2.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_2.getClass().equals(Double.class)) {
                                row3._id = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_2.toString()).intValue();
                            } else {
                                row3._id = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_2.toString());
                            }
				}else{
					row3._id = null;
				}
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("title"),"title",o_tMongoDBInput_2);
					
				row3.title = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("ingredients"),"ingredients",o_tMongoDBInput_2);
					
				row3.ingredients = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("directions"),"directions",o_tMongoDBInput_2);
					
				row3.directions = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("link"),"link",o_tMongoDBInput_2);
					
				row3.link = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("source"),"source",o_tMongoDBInput_2);
					
				row3.source = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("NER"),"NER",o_tMongoDBInput_2);
					
				row3.NER = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("site"),"site",o_tMongoDBInput_2);
					
				row3.site = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				


 



/**
 * [tMongoDBInput_2 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

 


	tos_count_tMongoDBInput_2++;

/**
 * [tMongoDBInput_2 main ] stop
 */
	
	/**
	 * [tMongoDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

 



/**
 * [tMongoDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
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
out1_tmp._id = Numeric.sequence("s3", 1, 1);
out1_tmp.strMeal = row3.title ;
out1_tmp.ingredients = row3.ingredients ;
out1_tmp.strInstructions = row3.directions ;
out1_tmp.strCategory = row3.NER ;
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
	 * [tJavaRow_2 main ] start
	 */

	

	
	
	currentComponent="tJavaRow_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out1"
						
						);
					}
					

    String[] tab = out1.strCategory.split(",");
List<String> ingredients = new ArrayList<>();

for (String t : tab) {

    String ner = t.trim()
        .replace("\"","")
        .replace("[","")
        .replace("]","")
        .trim();

    if (ner.isEmpty()) {
        continue;
    }

    String formatted =
        ner.substring(0, 1).toUpperCase() +
        ner.substring(1).toLowerCase();

    formatted = formatted.replace("\"", "\\\"");

    ingredients.add("\"" + formatted + "\"");
}

row4._id = out1._id;
row4.ingredients = "[" + String.join(",", ingredients) + "]";
row4.strMeal = out1.strMeal;
row4.strInstructions = out1.strInstructions;
row4.strCategory = out1.strCategory;

    nb_line_tJavaRow_2++;   

 


	tos_count_tJavaRow_2++;

/**
 * [tJavaRow_2 main ] stop
 */
	
	/**
	 * [tJavaRow_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJavaRow_2";

	

 



/**
 * [tJavaRow_2 process_data_begin ] stop
 */

	
	/**
	 * [tMongoDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_2.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("_id"),"_id", row4._id);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("strMeal"),"strMeal", row4.strMeal);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("ingredients"),"ingredients", row4.ingredients);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("strInstructions"),"strInstructions", row4.strInstructions);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("strCategory"),"strCategory", row4.strCategory);
				org.bson.Document updateObj_tMongoDBOutput_2 = updateObjectUtil_tMongoDBOutput_2.getObject();
				
						coll_tMongoDBOutput_2.insertOne(updateObj_tMongoDBOutput_2);
					
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
	 * [tJavaRow_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaRow_2";

	

 



/**
 * [tJavaRow_2 process_data_end ] stop
 */

} // End of branch "out1"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

 



/**
 * [tMongoDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

            }
    globalMap.put("tMongoDBInput_2_NB_LINE", nb_line_tMongoDBInput_2);
 

ok_Hash.put("tMongoDBInput_2", true);
end_Hash.put("tMongoDBInput_2", System.currentTimeMillis());




/**
 * [tMongoDBInput_2 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tJavaRow_2 end ] start
	 */

	

	
	
	currentComponent="tJavaRow_2";

	

globalMap.put("tJavaRow_2_NB_LINE",nb_line_tJavaRow_2);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out1");
			  	}
			  	
 

ok_Hash.put("tJavaRow_2", true);
end_Hash.put("tJavaRow_2", System.currentTimeMillis());




/**
 * [tJavaRow_2 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	

	globalMap.put("tMongoDBOutput_2_NB_LINE", nb_line_tMongoDBOutput_2);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_2", true);
end_Hash.put("tMongoDBOutput_2", System.currentTimeMillis());




/**
 * [tMongoDBOutput_2 end ] stop
 */









						if(execStat){
							runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tMongoDBInput_2);
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
	 * [tMongoDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

 



/**
 * [tMongoDBInput_2 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tJavaRow_2 finally ] start
	 */

	

	
	
	currentComponent="tJavaRow_2";

	

 



/**
 * [tJavaRow_2 finally ] stop
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
		

		globalMap.put("tLoop_1_SUBPROCESS_STATE", 1);
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
   	 				runStat.updateStatOnConnection("OnComponentOk8", 0, "ok");
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
	
	resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_2", "", Thread.currentThread().getId() + "", "INFO","","LoadSilver end","", "");
	globalMap.put("tWarn_2_WARN_MESSAGES", "LoadSilver end"); 
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
        final LoadSilver LoadSilverClass = new LoadSilver();

        int exitCode = LoadSilverClass.runJobInTOS(args);

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
            java.io.InputStream inContext = LoadSilver.class.getClassLoader().getResourceAsStream("project/loadsilver_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = LoadSilver.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
                        context.setContextType("mongodb_collection_silver_nutrition", "id_String");
                        if(context.getStringValue("mongodb_collection_silver_nutrition") == null) {
                            context.mongodb_collection_silver_nutrition = null;
                        } else {
                            context.mongodb_collection_silver_nutrition=(String) context.getProperty("mongodb_collection_silver_nutrition");
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
            }if (parentContextMap.containsKey("mongodb_collection_silver_nutrition")) {
                context.mongodb_collection_silver_nutrition = (String) parentContextMap.get("mongodb_collection_silver_nutrition");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : LoadSilver");
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
 *     315420 characters generated by Talend Open Studio for Big Data 
 *     on the 10 février 2026, 10:02:33 CET
 ************************************************************************************************/