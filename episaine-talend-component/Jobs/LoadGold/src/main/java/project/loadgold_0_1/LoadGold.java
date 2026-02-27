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


package project.loadgold_0_1;

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
 




	//the import part of tJavaRow_3
	//import java.util.List;

	//the import part of tJavaRow_4
	//import java.util.List;

	//the import part of tJavaRow_1
	//import java.util.List;

	//the import part of tJavaRow_2
	//import java.util.List;

	//the import part of tJavaRow_5
	//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: LoadGold Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class LoadGold implements TalendJob {

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
			
			if(postgresql_table_meals_temp != null){
				
					this.setProperty("postgresql_table_meals_temp", postgresql_table_meals_temp.toString());
				
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
public String postgresql_table_meals_temp;
public String getPostgresql_table_meals_temp(){
	return this.postgresql_table_meals_temp;
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
	private final String jobName = "LoadGold";
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
				LoadGold.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(LoadGold.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tDBConnection_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBCommit_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBCommit_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tBufferOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJavaRow_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tUniqRow_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBCommit_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJavaRow_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLoop_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBCommit_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBClose_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBClose_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tWarn_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tWarn_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tExtractJSONFields_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJavaRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJavaRow_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJavaRow_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBCommit_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tBufferInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
				
					tLoop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tWarn_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBRow_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_5_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tLoop_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBClose_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tWarn_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

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
	
	resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_1", "", Thread.currentThread().getId() + "", "ERROR","","LoadGold begin","", "");
	globalMap.put("tWarn_1_WARN_MESSAGES", "LoadGold begin"); 
	globalMap.put("tWarn_1_WARN_PRIORITY", 5);
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
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tDBConnection_1Process(globalMap);



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
	

public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

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
	 * [tDBConnection_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBConnection_1", false);
		start_Hash.put("tDBConnection_1", System.currentTimeMillis());
		
	
	currentComponent="tDBConnection_1";

	
		int tos_count_tDBConnection_1 = 0;
		


	
            String dbProperties_tDBConnection_1 = "client_encoding=UTF8";
            String url_tDBConnection_1 = "jdbc:postgresql://"+context.postgresql_server+":"+context.postgresql_port+"/"+context.postgresql_database;
            
            if(dbProperties_tDBConnection_1 != null && !"".equals(dbProperties_tDBConnection_1.trim())) {
                url_tDBConnection_1 = url_tDBConnection_1 + "?" + dbProperties_tDBConnection_1;
            }
	String dbUser_tDBConnection_1 = context.postgresql_user;
	
	
		
	final String decryptedPassword_tDBConnection_1 = context.postgresql_password; 
		String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;
	
	
	java.sql.Connection conn_tDBConnection_1 = null;
	
        java.util.Enumeration<java.sql.Driver> drivers_tDBConnection_1 =  java.sql.DriverManager.getDrivers();
        java.util.Set<String> redShiftDriverNames_tDBConnection_1 = new java.util.HashSet<String>(java.util.Arrays
                .asList("com.amazon.redshift.jdbc.Driver","com.amazon.redshift.jdbc41.Driver","com.amazon.redshift.jdbc42.Driver"));
    while (drivers_tDBConnection_1.hasMoreElements()) {
        java.sql.Driver d_tDBConnection_1 = drivers_tDBConnection_1.nextElement();
        if (redShiftDriverNames_tDBConnection_1.contains(d_tDBConnection_1.getClass().getName())) {
            try {
                java.sql.DriverManager.deregisterDriver(d_tDBConnection_1);
                java.sql.DriverManager.registerDriver(d_tDBConnection_1);
            } catch (java.lang.Exception e_tDBConnection_1) {
globalMap.put("tDBConnection_1_ERROR_MESSAGE",e_tDBConnection_1.getMessage());
                    //do nothing
            }
        }
    }
					String driverClass_tDBConnection_1 = "org.postgresql.Driver";
			java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
			globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);
		
			conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1,dbUser_tDBConnection_1,dbPwd_tDBConnection_1);

		globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
	if (null != conn_tDBConnection_1) {
		
			conn_tDBConnection_1.setAutoCommit(false);
	}

	globalMap.put("schema_" + "tDBConnection_1",context.postgresql_schema);

 



/**
 * [tDBConnection_1 begin ] stop
 */
	
	/**
	 * [tDBConnection_1 main ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 


	tos_count_tDBConnection_1++;

/**
 * [tDBConnection_1 main ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_end ] stop
 */
	
	/**
	 * [tDBConnection_1 end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 

ok_Hash.put("tDBConnection_1", true);
end_Hash.put("tDBConnection_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
				}
				tDBRow_1Process(globalMap);



/**
 * [tDBConnection_1 end ] stop
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
	 * [tDBConnection_1 finally ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBRow_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBRow_1_SUBPROCESS_STATE", 0);

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
	 * [tDBRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRow_1", false);
		start_Hash.put("tDBRow_1", System.currentTimeMillis());
		
	
	currentComponent="tDBRow_1";

	
		int tos_count_tDBRow_1 = 0;
		

	java.sql.Connection conn_tDBRow_1 = null;
	String query_tDBRow_1 = "";
	boolean whetherReject_tDBRow_1 = false;
				conn_tDBRow_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
			
        resourceMap.put("conn_tDBRow_1", conn_tDBRow_1);
        java.sql.Statement stmt_tDBRow_1 = conn_tDBRow_1.createStatement();
        resourceMap.put("stmt_tDBRow_1", stmt_tDBRow_1);


 



/**
 * [tDBRow_1 begin ] stop
 */
	
	/**
	 * [tDBRow_1 main ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

query_tDBRow_1 = "TRUNCATE TABLE " + context.postgresql_schema + "." + context.postgresql_table_meals + " RESTART IDENTITY CASCADE";;
whetherReject_tDBRow_1 = false;
globalMap.put("tDBRow_1_QUERY",query_tDBRow_1);
try {
		stmt_tDBRow_1.execute(query_tDBRow_1);
		
	} catch (java.lang.Exception e) {
		whetherReject_tDBRow_1 = true;
		
				System.err.print(e.getMessage());
				globalMap.put("tDBRow_1_ERROR_MESSAGE", e.getMessage());
				
	}
	
	if(!whetherReject_tDBRow_1) {
		
	}
	

 


	tos_count_tDBRow_1++;

/**
 * [tDBRow_1 main ] stop
 */
	
	/**
	 * [tDBRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

 



/**
 * [tDBRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

 



/**
 * [tDBRow_1 process_data_end ] stop
 */
	
	/**
	 * [tDBRow_1 end ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

	
        stmt_tDBRow_1.close();
        resourceMap.remove("stmt_tDBRow_1");
    resourceMap.put("statementClosed_tDBRow_1", true);
    resourceMap.put("finish_tDBRow_1", true);
 

ok_Hash.put("tDBRow_1", true);
end_Hash.put("tDBRow_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk19", 0, "ok");
				}
				tDBCommit_5Process(globalMap);



/**
 * [tDBRow_1 end ] stop
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
	 * [tDBRow_1 finally ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

    if (resourceMap.get("statementClosed_tDBRow_1") == null) {
            java.sql.Statement stmtToClose_tDBRow_1 = null;
            if ((stmtToClose_tDBRow_1 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_1")) != null) {
                stmtToClose_tDBRow_1.close();
            }
    }
 



/**
 * [tDBRow_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBCommit_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_5_SUBPROCESS_STATE", 0);

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
	 * [tDBCommit_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_5", false);
		start_Hash.put("tDBCommit_5", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_5";

	
		int tos_count_tDBCommit_5 = 0;
		

 



/**
 * [tDBCommit_5 begin ] stop
 */
	
	/**
	 * [tDBCommit_5 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_5";

	

	java.sql.Connection conn_tDBCommit_5 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBCommit_5 != null && !conn_tDBCommit_5.isClosed())
	{
	
			
			conn_tDBCommit_5.commit();
			
	
	}

 


	tos_count_tDBCommit_5++;

/**
 * [tDBCommit_5 main ] stop
 */
	
	/**
	 * [tDBCommit_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_5";

	

 



/**
 * [tDBCommit_5 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_5";

	

 



/**
 * [tDBCommit_5 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_5 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_5";

	

 

ok_Hash.put("tDBCommit_5", true);
end_Hash.put("tDBCommit_5", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk20", 0, "ok");
				}
				tMongoDBInput_1Process(globalMap);



/**
 * [tDBCommit_5 end ] stop
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
	 * [tDBCommit_5 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_5";

	

 



/**
 * [tDBCommit_5 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_5_SUBPROCESS_STATE", 1);
	}
	


public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

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




	
	/**
	 * [tDBOutput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_3", false);
		start_Hash.put("tDBOutput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tDBOutput_3 = 0;
		





String dbschema_tDBOutput_3 = null;
	dbschema_tDBOutput_3 = (String)globalMap.get("schema_" + "tDBConnection_1");
	

String tableName_tDBOutput_3 = null;
if(dbschema_tDBOutput_3 == null || dbschema_tDBOutput_3.trim().length() == 0) {
	tableName_tDBOutput_3 = (context.postgresql_table_meals_temp);
} else {
	tableName_tDBOutput_3 = dbschema_tDBOutput_3 + "\".\"" + (context.postgresql_table_meals_temp);
}


int nb_line_tDBOutput_3 = 0;
int nb_line_update_tDBOutput_3 = 0;
int nb_line_inserted_tDBOutput_3 = 0;
int nb_line_deleted_tDBOutput_3 = 0;
int nb_line_rejected_tDBOutput_3 = 0;

int deletedCount_tDBOutput_3=0;
int updatedCount_tDBOutput_3=0;
int insertedCount_tDBOutput_3=0;
int rowsToCommitCount_tDBOutput_3=0;
int rejectedCount_tDBOutput_3=0;

boolean whetherReject_tDBOutput_3 = false;

java.sql.Connection conn_tDBOutput_3 = null;
String dbUser_tDBOutput_3 = null;

	conn_tDBOutput_3 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	
	


   int batchSize_tDBOutput_3 = 10000;
   int batchSizeCounter_tDBOutput_3=0;

int count_tDBOutput_3=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_3 = conn_tDBOutput_3.getMetaData();
                                boolean whetherExist_tDBOutput_3 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_3 = dbMetaData_tDBOutput_3.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_3 = "public";
                                    if(dbschema_tDBOutput_3 == null || dbschema_tDBOutput_3.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_3 = conn_tDBOutput_3.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_3 = stmtSchema_tDBOutput_3.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_3.next()){
                                                defaultSchema_tDBOutput_3 = rsSchema_tDBOutput_3.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_3.next()) {
                                        String table_tDBOutput_3 = rsTable_tDBOutput_3.getString("TABLE_NAME");
                                        String schema_tDBOutput_3 = rsTable_tDBOutput_3.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_3.equals((context.postgresql_table_meals_temp))
                                            && (schema_tDBOutput_3.equals(dbschema_tDBOutput_3) || ((dbschema_tDBOutput_3 ==null || dbschema_tDBOutput_3.trim().length() ==0) && defaultSchema_tDBOutput_3.equals(schema_tDBOutput_3)))) {
                                            whetherExist_tDBOutput_3 = true;
                                            break;
                                        }
                                    }
                                }
                                if(whetherExist_tDBOutput_3) {
                                    try (java.sql.Statement stmtDrop_tDBOutput_3 = conn_tDBOutput_3.createStatement()) {
                                        stmtDrop_tDBOutput_3.execute("DROP TABLE \"" + tableName_tDBOutput_3 + "\"" );
                                    }
                                }
                                try(java.sql.Statement stmtCreate_tDBOutput_3 = conn_tDBOutput_3.createStatement()) {
                                    stmtCreate_tDBOutput_3.execute("CREATE TABLE \"" + tableName_tDBOutput_3 + "\"(\"_id\" INT4 ,\"strMeal\" VARCHAR ,\"strCategory\" VARCHAR ,\"strArea\" VARCHAR ,\"strInstructions\" VARCHAR ,\"ingredients\" VARCHAR )");
                                }
	    String insert_tDBOutput_3 = "INSERT INTO \"" + tableName_tDBOutput_3 + "\" (\"_id\",\"strMeal\",\"strCategory\",\"strArea\",\"strInstructions\",\"ingredients\") VALUES (?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(insert_tDBOutput_3);
	    resourceMap.put("pstmt_tDBOutput_3", pstmt_tDBOutput_3);
	    

 



/**
 * [tDBOutput_3 begin ] stop
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


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_1 = db_tMongoDBInput_1.getCollection(context.mongodb_collection_silver);
				
				
				
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
				pathMap_tMongoDBInput_1.put("_id","");
				pathMap_tMongoDBInput_1.put("strMeal","");
				pathMap_tMongoDBInput_1.put("strCategory","");
				pathMap_tMongoDBInput_1.put("strArea","");
				pathMap_tMongoDBInput_1.put("strInstructions","");
				pathMap_tMongoDBInput_1.put("ingredients","");

						
				while (cursor_tMongoDBInput_1.hasNext()){
				org.bson.Document o_tMongoDBInput_1 = cursor_tMongoDBInput_1.next();
				nb_line_tMongoDBInput_1++;
				Object valueObj_tMongoDBInput_1=null;
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("_id"),"_id",o_tMongoDBInput_1);
				if(valueObj_tMongoDBInput_1!=null && valueObj_tMongoDBInput_1.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_1.getClass().equals(Double.class)) {
                                row1._id = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_1.toString()).intValue();
                            } else {
                                row1._id = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_1.toString());
                            }
				}else{
					row1._id = null;
				}
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strMeal"),"strMeal",o_tMongoDBInput_1);
					
				row1.strMeal = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strCategory"),"strCategory",o_tMongoDBInput_1);
					
				row1.strCategory = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strArea"),"strArea",o_tMongoDBInput_1);
					
				row1.strArea = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strInstructions"),"strInstructions",o_tMongoDBInput_1);
					
				row1.strInstructions = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("ingredients"),"ingredients",o_tMongoDBInput_1);
					
				row1.ingredients = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				


 



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
	 * [tDBOutput_3 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					



        whetherReject_tDBOutput_3 = false;
                    if(row1._id == null) {
pstmt_tDBOutput_3.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_3.setInt(1, row1._id);
}

                    if(row1.strMeal == null) {
pstmt_tDBOutput_3.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(2, row1.strMeal);
}

                    if(row1.strCategory == null) {
pstmt_tDBOutput_3.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(3, row1.strCategory);
}

                    if(row1.strArea == null) {
pstmt_tDBOutput_3.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(4, row1.strArea);
}

                    if(row1.strInstructions == null) {
pstmt_tDBOutput_3.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(5, row1.strInstructions);
}

                    if(row1.ingredients == null) {
pstmt_tDBOutput_3.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_3.setString(6, row1.ingredients);
}

			
    		pstmt_tDBOutput_3.addBatch();
    		nb_line_tDBOutput_3++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_3++;
    		  
            if(!whetherReject_tDBOutput_3) {
            }
    			if ((batchSize_tDBOutput_3 > 0) && (batchSize_tDBOutput_3 <= batchSizeCounter_tDBOutput_3)) {
                try {
						int countSum_tDBOutput_3 = 0;
						    
						for(int countEach_tDBOutput_3: pstmt_tDBOutput_3.executeBatch()) {
							countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
						}
				    	rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
				    	
				    		insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
				    	
            	    	batchSizeCounter_tDBOutput_3 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_3){
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e_tDBOutput_3.getMessage());
				    	java.sql.SQLException ne_tDBOutput_3 = e_tDBOutput_3.getNextException(),sqle_tDBOutput_3=null;
				    	String errormessage_tDBOutput_3;
						if (ne_tDBOutput_3 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_3 = new java.sql.SQLException(e_tDBOutput_3.getMessage() + "\ncaused by: " + ne_tDBOutput_3.getMessage(), ne_tDBOutput_3.getSQLState(), ne_tDBOutput_3.getErrorCode(), ne_tDBOutput_3);
							errormessage_tDBOutput_3 = sqle_tDBOutput_3.getMessage();
						}else{
							errormessage_tDBOutput_3 = e_tDBOutput_3.getMessage();
						}
				    	
				    	int countSum_tDBOutput_3 = 0;
						for(int countEach_tDBOutput_3: e_tDBOutput_3.getUpdateCounts()) {
							countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
						}
						rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
						
				    		insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
				    	
				    	System.err.println(errormessage_tDBOutput_3);
				    	
					}
    			}
    		

 


	tos_count_tDBOutput_3++;

/**
 * [tDBOutput_3 main ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	

 



/**
 * [tDBOutput_3 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	

 



/**
 * [tDBOutput_3 process_data_end ] stop
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
	 * [tDBOutput_3 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	



	    try {
				int countSum_tDBOutput_3 = 0;
				if (pstmt_tDBOutput_3 != null && batchSizeCounter_tDBOutput_3 > 0) {
						
					for(int countEach_tDBOutput_3: pstmt_tDBOutput_3.executeBatch()) {
						countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
					}
					rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
						
				}
		    	
		    		insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_3){
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e_tDBOutput_3.getMessage());
	    	java.sql.SQLException ne_tDBOutput_3 = e_tDBOutput_3.getNextException(),sqle_tDBOutput_3=null;
	    	String errormessage_tDBOutput_3;
			if (ne_tDBOutput_3 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_3 = new java.sql.SQLException(e_tDBOutput_3.getMessage() + "\ncaused by: " + ne_tDBOutput_3.getMessage(), ne_tDBOutput_3.getSQLState(), ne_tDBOutput_3.getErrorCode(), ne_tDBOutput_3);
				errormessage_tDBOutput_3 = sqle_tDBOutput_3.getMessage();
			}else{
				errormessage_tDBOutput_3 = e_tDBOutput_3.getMessage();
			}
	    	
	    	int countSum_tDBOutput_3 = 0;
			for(int countEach_tDBOutput_3: e_tDBOutput_3.getUpdateCounts()) {
				countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
			}
			rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
			
	    		insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
	    	
	    	System.err.println(errormessage_tDBOutput_3);
	    	
		}
	    
        if(pstmt_tDBOutput_3 != null) {
        		
            pstmt_tDBOutput_3.close();
            resourceMap.remove("pstmt_tDBOutput_3");
        }
    resourceMap.put("statementClosed_tDBOutput_3", true);

	nb_line_deleted_tDBOutput_3=nb_line_deleted_tDBOutput_3+ deletedCount_tDBOutput_3;
	nb_line_update_tDBOutput_3=nb_line_update_tDBOutput_3 + updatedCount_tDBOutput_3;
	nb_line_inserted_tDBOutput_3=nb_line_inserted_tDBOutput_3 + insertedCount_tDBOutput_3;
	nb_line_rejected_tDBOutput_3=nb_line_rejected_tDBOutput_3 + rejectedCount_tDBOutput_3;
	
        globalMap.put("tDBOutput_3_NB_LINE",nb_line_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_UPDATED",nb_line_update_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_DELETED",nb_line_deleted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_3);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tDBOutput_3", true);
end_Hash.put("tDBOutput_3", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk6", 0, "ok");
				}
				tDBCommit_3Process(globalMap);



/**
 * [tDBOutput_3 end ] stop
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
	 * [tDBOutput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	



    if (resourceMap.get("statementClosed_tDBOutput_3") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_3 = null;
                if ((pstmtToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_3")) != null) {
                    pstmtToClose_tDBOutput_3.close();
                }
    }
 



/**
 * [tDBOutput_3 finally ] stop
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
	

public void tDBCommit_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_3_SUBPROCESS_STATE", 0);

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
	 * [tDBCommit_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_3", false);
		start_Hash.put("tDBCommit_3", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_3";

	
		int tos_count_tDBCommit_3 = 0;
		

 



/**
 * [tDBCommit_3 begin ] stop
 */
	
	/**
	 * [tDBCommit_3 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_3";

	

	java.sql.Connection conn_tDBCommit_3 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBCommit_3 != null && !conn_tDBCommit_3.isClosed())
	{
	
			
			conn_tDBCommit_3.commit();
			
	
	}

 


	tos_count_tDBCommit_3++;

/**
 * [tDBCommit_3 main ] stop
 */
	
	/**
	 * [tDBCommit_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_3";

	

 



/**
 * [tDBCommit_3 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_3";

	

 



/**
 * [tDBCommit_3 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_3 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_3";

	

 

ok_Hash.put("tDBCommit_3", true);
end_Hash.put("tDBCommit_3", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk8", 0, "ok");
				}
				tMongoDBInput_3Process(globalMap);



/**
 * [tDBCommit_3 end ] stop
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
	 * [tDBCommit_3 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_3";

	

 



/**
 * [tDBCommit_3 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_3_SUBPROCESS_STATE", 1);
	}
	


public static class row8Struct implements routines.system.IPersistableRow<row8Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				
			    public String calories;

				public String getCalories () {
					return this.calories;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
					this.calories = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
					this.calories = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
					// String
				
						writeString(this.calories,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
					// String
				
						writeString(this.calories,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("nom="+nom);
		sb.append(",calories="+calories);
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
public void tMongoDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_3_SUBPROCESS_STATE", 0);

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



		row8Struct row8 = new row8Struct();




	
	/**
	 * [tBufferOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tBufferOutput_1", false);
		start_Hash.put("tBufferOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tBufferOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row8");
					}
				
		int tos_count_tBufferOutput_1 = 0;
		

 



/**
 * [tBufferOutput_1 begin ] stop
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


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_3 = db_tMongoDBInput_3.getCollection(context.mongodb_collection_silver_nutrition);
				
				
				
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

						org.bson.Document myQuery_tMongoDBInput_3 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_3 = coll_tMongoDBInput_3.find(myQuery_tMongoDBInput_3).noCursorTimeout(false);
							


				
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
				pathMap_tMongoDBInput_3.put("nom","");
				pathMap_tMongoDBInput_3.put("calories","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_3 = findIterable_tMongoDBInput_3.iterator();
						
				while (cursor_tMongoDBInput_3.hasNext()){
				org.bson.Document o_tMongoDBInput_3 = cursor_tMongoDBInput_3.next();
				nb_line_tMongoDBInput_3++;
				Object valueObj_tMongoDBInput_3=null;
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("nom"),"nom",o_tMongoDBInput_3);
					
				row8.nom = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("calories"),"calories",o_tMongoDBInput_3);
					
				row8.calories = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				


 



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
	 * [tBufferOutput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row8"
						
						);
					}
					



String[] row_tBufferOutput_1=new String[]{"","",};		
	    if(row8.nom != null){
	        
	            row_tBufferOutput_1[0] = row8.nom;
	                        			    
	    }else{
	    	row_tBufferOutput_1[0] = null;
	    }
	    if(row8.calories != null){
	        
	            row_tBufferOutput_1[1] = row8.calories;
	                        			    
	    }else{
	    	row_tBufferOutput_1[1] = null;
	    }
	globalBuffer.add(row_tBufferOutput_1);	
	
 


	tos_count_tBufferOutput_1++;

/**
 * [tBufferOutput_1 main ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tBufferOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 process_data_end ] stop
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
	 * [tBufferOutput_1 end ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row8");
			  	}
			  	
 

ok_Hash.put("tBufferOutput_1", true);
end_Hash.put("tBufferOutput_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk16", 0, "ok");
				}
				tDBInput_2Process(globalMap);



/**
 * [tBufferOutput_1 end ] stop
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
	 * [tMongoDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

 



/**
 * [tMongoDBInput_3 finally ] stop
 */

	
	/**
	 * [tBufferOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tBufferOutput_1";

	

 



/**
 * [tBufferOutput_1 finally ] stop
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
	


public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String area_name;

				public String getArea_name () {
					return this.area_name;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.area_name == null) ? 0 : this.area_name.hashCode());
					
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
		final row7Struct other = (row7Struct) obj;
		
						if (this.area_name == null) {
							if (other.area_name != null)
								return false;
						
						} else if (!this.area_name.equals(other.area_name))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row7Struct other) {

		other.area_name = this.area_name;
	            other.area_id = this.area_id;
	            
	}

	public void copyKeysDataTo(row7Struct other) {

		other.area_name = this.area_name;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.area_name = readString(dis);
					
					this.area_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.area_name = readString(dis);
					
					this.area_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.area_name,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.area_name,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("area_name="+area_name);
		sb.append(",area_id="+area_id);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row7Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.area_name, other.area_name);
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

public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String area_name;

				public String getArea_name () {
					return this.area_name;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.area_name == null) ? 0 : this.area_name.hashCode());
					
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
		final row5Struct other = (row5Struct) obj;
		
						if (this.area_name == null) {
							if (other.area_name != null)
								return false;
						
						} else if (!this.area_name.equals(other.area_name))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row5Struct other) {

		other.area_name = this.area_name;
	            other.area_id = this.area_id;
	            
	}

	public void copyKeysDataTo(row5Struct other) {

		other.area_name = this.area_name;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.area_name = readString(dis);
					
					this.area_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.area_name = readString(dis);
					
					this.area_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.area_name,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.area_name,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("area_name="+area_name);
		sb.append(",area_id="+area_id);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row5Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.area_name, other.area_name);
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

public static class copyOfout1Struct implements routines.system.IPersistableRow<copyOfout1Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String area_name;

				public String getArea_name () {
					return this.area_name;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.area_name == null) ? 0 : this.area_name.hashCode());
					
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
		final copyOfout1Struct other = (copyOfout1Struct) obj;
		
						if (this.area_name == null) {
							if (other.area_name != null)
								return false;
						
						} else if (!this.area_name.equals(other.area_name))
						
							return false;
					

		return true;
    }

	public void copyDataTo(copyOfout1Struct other) {

		other.area_name = this.area_name;
	            other.area_id = this.area_id;
	            
	}

	public void copyKeysDataTo(copyOfout1Struct other) {

		other.area_name = this.area_name;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.area_name = readString(dis);
					
					this.area_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.area_name = readString(dis);
					
					this.area_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.area_name,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.area_name,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("area_name="+area_name);
		sb.append(",area_id="+area_id);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(copyOfout1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.area_name, other.area_name);
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

public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
			    public String strArea;

				public String getStrArea () {
					return this.strArea;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.strArea = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.strArea = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.strArea,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.strArea,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("strArea="+strArea);
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
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

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



		row6Struct row6 = new row6Struct();
copyOfout1Struct copyOfout1 = new copyOfout1Struct();
row5Struct row5 = new row5Struct();
row7Struct row7 = new row7Struct();







	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row7");
					}
				
		int tos_count_tDBOutput_1 = 0;
		





String dbschema_tDBOutput_1 = null;
	dbschema_tDBOutput_1 = (String)globalMap.get("schema_" + "tDBConnection_1");
	

String tableName_tDBOutput_1 = null;
if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
	tableName_tDBOutput_1 = (context.postgresql_table_area);
} else {
	tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + (context.postgresql_table_area);
}


int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

boolean whetherReject_tDBOutput_1 = false;

java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;

	conn_tDBOutput_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	
	


   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

int count_tDBOutput_1=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
                                boolean whetherExist_tDBOutput_1 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_1 = "public";
                                    if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_1 = conn_tDBOutput_1.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_1 = stmtSchema_tDBOutput_1.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_1.next()){
                                                defaultSchema_tDBOutput_1 = rsSchema_tDBOutput_1.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_1.next()) {
                                        String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
                                        String schema_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_1.equals((context.postgresql_table_area))
                                            && (schema_tDBOutput_1.equals(dbschema_tDBOutput_1) || ((dbschema_tDBOutput_1 ==null || dbschema_tDBOutput_1.trim().length() ==0) && defaultSchema_tDBOutput_1.equals(schema_tDBOutput_1)))) {
                                            whetherExist_tDBOutput_1 = true;
                                            break;
                                        }
                                    }
                                }
                                if(whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtDrop_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                                        stmtDrop_tDBOutput_1.execute("DROP TABLE \"" + tableName_tDBOutput_1 + "\"" );
                                    }
                                }
                                try(java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                                    stmtCreate_tDBOutput_1.execute("CREATE TABLE \"" + tableName_tDBOutput_1 + "\"(\"area_name\" VARCHAR  not null ,\"area_id\" VARCHAR  not null ,primary key(\"area_name\"))");
                                }
	    String insert_tDBOutput_1 = "INSERT INTO \"" + tableName_tDBOutput_1 + "\" (\"area_name\",\"area_id\") VALUES (?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tUniqRow_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tUniqRow_2", false);
		start_Hash.put("tUniqRow_2", System.currentTimeMillis());
		
	
	currentComponent="tUniqRow_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row5");
					}
				
		int tos_count_tUniqRow_2 = 0;
		

	
		class KeyStruct_tUniqRow_2 {
	
			private static final int DEFAULT_HASHCODE = 1;
		    private static final int PRIME = 31;
		    private int hashCode = DEFAULT_HASHCODE;
		    public boolean hashCodeDirty = true;
	
	        
					String area_name;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
								result = prime * result + ((this.area_name == null) ? 0 : this.area_name.hashCode());
								
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
				final KeyStruct_tUniqRow_2 other = (KeyStruct_tUniqRow_2) obj;
				
									if (this.area_name == null) {
										if (other.area_name != null) 
											return false;
								
									} else if (!this.area_name.equals(other.area_name))
								 
										return false;
								
				
				return true;
			}
	  
	        
		}

	
int nb_uniques_tUniqRow_2 = 0;
int nb_duplicates_tUniqRow_2 = 0;
KeyStruct_tUniqRow_2 finder_tUniqRow_2 = new KeyStruct_tUniqRow_2();
java.util.Set<KeyStruct_tUniqRow_2> keystUniqRow_2 = new java.util.HashSet<KeyStruct_tUniqRow_2>();
java.util.Set<KeyStruct_tUniqRow_2> keysForDuplicatedtUniqRow_2 = new java.util.HashSet<KeyStruct_tUniqRow_2>(); 

 



/**
 * [tUniqRow_2 begin ] stop
 */



	
	/**
	 * [tJavaRow_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaRow_3", false);
		start_Hash.put("tJavaRow_3", System.currentTimeMillis());
		
	
	currentComponent="tJavaRow_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"copyOfout1");
					}
				
		int tos_count_tJavaRow_3 = 0;
		

int nb_line_tJavaRow_3 = 0;

 



/**
 * [tJavaRow_3 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row6");
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
copyOfout1Struct copyOfout1_tmp = new copyOfout1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
	
    
	
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				conn_tDBInput_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT \n  \""+context.postgresql_schema+"\".\""+context.postgresql_table_meals_temp+"\".\"strArea\"\nFROM \""+context.postgresql_schema+"\".\""+context.postgresql_table_meals_temp+"\"";
		    

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row6.strArea = null;
							} else {
	                         		
        	row6.strArea = routines.system.JDBCUtil.getString(rs_tDBInput_2, 1, false);
		                    }
					


 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row6"
						
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

copyOfout1 = null;


// # Output table : 'copyOfout1'
copyOfout1_tmp.area_name = row6.strArea ;
copyOfout1_tmp.area_id = "A" + String.valueOf(Numeric.sequence("s2", 1, 1));
copyOfout1 = copyOfout1_tmp;
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
// Start of branch "copyOfout1"
if(copyOfout1 != null) { 



	
	/**
	 * [tJavaRow_3 main ] start
	 */

	

	
	
	currentComponent="tJavaRow_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"copyOfout1"
						
						);
					}
					

    if (copyOfout1.area_name != null && !copyOfout1.area_name.equals("")) {
	row5.area_name = copyOfout1.area_name;
	row5.area_id = copyOfout1.area_id;
}
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
	 * [tUniqRow_2 main ] start
	 */

	

	
	
	currentComponent="tUniqRow_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					
row7 = null;			
if(row5.area_name == null){
	finder_tUniqRow_2.area_name = null;
}else{
	finder_tUniqRow_2.area_name = row5.area_name.toLowerCase();
}	
finder_tUniqRow_2.hashCodeDirty = true;
if (!keystUniqRow_2.contains(finder_tUniqRow_2)) {
		KeyStruct_tUniqRow_2 new_tUniqRow_2 = new KeyStruct_tUniqRow_2();

		
if(row5.area_name == null){
	new_tUniqRow_2.area_name = null;
}else{
	new_tUniqRow_2.area_name = row5.area_name.toLowerCase();
}
		
		keystUniqRow_2.add(new_tUniqRow_2);if(row7 == null){ 
	
	row7 = new row7Struct();
}row7.area_name = row5.area_name;			row7.area_id = row5.area_id;					
		nb_uniques_tUniqRow_2++;
	} else {
	  nb_duplicates_tUniqRow_2++;
	}

 


	tos_count_tUniqRow_2++;

/**
 * [tUniqRow_2 main ] stop
 */
	
	/**
	 * [tUniqRow_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUniqRow_2";

	

 



/**
 * [tUniqRow_2 process_data_begin ] stop
 */
// Start of branch "row7"
if(row7 != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row7"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(row7.area_name == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, row7.area_name);
}

                    if(row7.area_id == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(2, row7.area_id);
}

			
    		pstmt_tDBOutput_1.addBatch();
    		nb_line_tDBOutput_1++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_1++;
    		  
            if(!whetherReject_tDBOutput_1) {
            }
    			if ((batchSize_tDBOutput_1 > 0) && (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
                try {
						int countSum_tDBOutput_1 = 0;
						    
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
				    	rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
				    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
            	    	batchSizeCounter_tDBOutput_1 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
				    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
				    	String errormessage_tDBOutput_1;
						if (ne_tDBOutput_1 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
							errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
						}else{
							errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
						}
				    	
				    	int countSum_tDBOutput_1 = 0;
						for(int countEach_tDBOutput_1: e_tDBOutput_1.getUpdateCounts()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
						
				    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
				    	System.err.println(errormessage_tDBOutput_1);
				    	
					}
    			}
    		

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "row7"




	
	/**
	 * [tUniqRow_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tUniqRow_2";

	

 



/**
 * [tUniqRow_2 process_data_end ] stop
 */



	
	/**
	 * [tJavaRow_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaRow_3";

	

 



/**
 * [tJavaRow_3 process_data_end ] stop
 */

} // End of branch "copyOfout1"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
 

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row6");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tJavaRow_3 end ] start
	 */

	

	
	
	currentComponent="tJavaRow_3";

	

globalMap.put("tJavaRow_3_NB_LINE",nb_line_tJavaRow_3);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"copyOfout1");
			  	}
			  	
 

ok_Hash.put("tJavaRow_3", true);
end_Hash.put("tJavaRow_3", System.currentTimeMillis());




/**
 * [tJavaRow_3 end ] stop
 */

	
	/**
	 * [tUniqRow_2 end ] start
	 */

	

	
	
	currentComponent="tUniqRow_2";

	

globalMap.put("tUniqRow_2_NB_UNIQUES",nb_uniques_tUniqRow_2);
globalMap.put("tUniqRow_2_NB_DUPLICATES",nb_duplicates_tUniqRow_2);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row5");
			  	}
			  	
 

ok_Hash.put("tUniqRow_2", true);
end_Hash.put("tUniqRow_2", System.currentTimeMillis());




/**
 * [tUniqRow_2 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



	    try {
				int countSum_tDBOutput_1 = 0;
				if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {
						
					for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
						
				}
		    	
		    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
	    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
	    	String errormessage_tDBOutput_1;
			if (ne_tDBOutput_1 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
				errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
			}else{
				errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
			}
	    	
	    	int countSum_tDBOutput_1 = 0;
			for(int countEach_tDBOutput_1: e_tDBOutput_1.getUpdateCounts()) {
				countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
			}
			rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
			
	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
	    	
	    	System.err.println(errormessage_tDBOutput_1);
	    	
		}
	    
        if(pstmt_tDBOutput_1 != null) {
        		
            pstmt_tDBOutput_1.close();
            resourceMap.remove("pstmt_tDBOutput_1");
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row7");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk5", 0, "ok");
				}
				tDBCommit_1Process(globalMap);



/**
 * [tDBOutput_1 end ] stop
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
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tJavaRow_3 finally ] start
	 */

	

	
	
	currentComponent="tJavaRow_3";

	

 



/**
 * [tJavaRow_3 finally ] stop
 */

	
	/**
	 * [tUniqRow_2 finally ] start
	 */

	

	
	
	currentComponent="tUniqRow_2";

	

 



/**
 * [tUniqRow_2 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */












				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	

public void tDBCommit_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 0);

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
	 * [tDBCommit_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_1", false);
		start_Hash.put("tDBCommit_1", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_1";

	
		int tos_count_tDBCommit_1 = 0;
		

 



/**
 * [tDBCommit_1 begin ] stop
 */
	
	/**
	 * [tDBCommit_1 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

	java.sql.Connection conn_tDBCommit_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBCommit_1 != null && !conn_tDBCommit_1.isClosed())
	{
	
			
			conn_tDBCommit_1.commit();
			
	
	}

 


	tos_count_tDBCommit_1++;

/**
 * [tDBCommit_1 main ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_1 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 

ok_Hash.put("tDBCommit_1", true);
end_Hash.put("tDBCommit_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk12", 0, "ok");
				}
				tDBInput_4Process(globalMap);



/**
 * [tDBCommit_1 end ] stop
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
	 * [tDBCommit_1 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 1);
	}
	


public static class row10Struct implements routines.system.IPersistableRow<row10Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
			    public Integer table_size;

				public Integer getTable_size () {
					return this.table_size;
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.table_size = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.table_size = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.table_size,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.table_size,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("table_size="+String.valueOf(table_size));
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
public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

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
	 * [tJavaRow_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaRow_4", false);
		start_Hash.put("tJavaRow_4", System.currentTimeMillis());
		
	
	currentComponent="tJavaRow_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row10");
					}
				
		int tos_count_tJavaRow_4 = 0;
		

int nb_line_tJavaRow_4 = 0;

 



/**
 * [tJavaRow_4 begin ] stop
 */



	
	/**
	 * [tDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_4", false);
		start_Hash.put("tDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_4";

	
		int tos_count_tDBInput_4 = 0;
		
	
    
	
		    int nb_line_tDBInput_4 = 0;
		    java.sql.Connection conn_tDBInput_4 = null;
				conn_tDBInput_4 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "SELECT COUNT(*) AS table_size FROM \""+context.postgresql_schema+"\".\""+context.postgresql_table_meals_temp+"\"";
		    

            	globalMap.put("tDBInput_4_QUERY",dbquery_tDBInput_4);
		    java.sql.ResultSet rs_tDBInput_4 = null;

		    try {
		    	rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
		    	int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

		    String tmpContent_tDBInput_4 = null;
		    
		    
		    while (rs_tDBInput_4.next()) {
		        nb_line_tDBInput_4++;
		        
							if(colQtyInRs_tDBInput_4 < 1) {
								row10.table_size = null;
							} else {
		                          
            row10.table_size = rs_tDBInput_4.getInt(1);
            if(rs_tDBInput_4.wasNull()){
                    row10.table_size = null;
            }
		                    }
					


 



/**
 * [tDBInput_4 begin ] stop
 */
	
	/**
	 * [tDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 


	tos_count_tDBInput_4++;

/**
 * [tDBInput_4 main ] stop
 */
	
	/**
	 * [tDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tJavaRow_4 main ] start
	 */

	

	
	
	currentComponent="tJavaRow_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row10"
						
						);
					}
					

    globalMap.put("TABLE_SIZE", row10.table_size);
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
	 * [tJavaRow_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaRow_4";

	

 



/**
 * [tJavaRow_4 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

	}
}finally{
	if (rs_tDBInput_4 != null) {
		rs_tDBInput_4.close();
	}
	if (stmt_tDBInput_4 != null) {
		stmt_tDBInput_4.close();
	}
}
globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);
 

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tJavaRow_4 end ] start
	 */

	

	
	
	currentComponent="tJavaRow_4";

	

globalMap.put("tJavaRow_4_NB_LINE",nb_line_tJavaRow_4);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row10");
			  	}
			  	
 

ok_Hash.put("tJavaRow_4", true);
end_Hash.put("tJavaRow_4", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk17", 0, "ok");
				}
				tLoop_1Process(globalMap);



/**
 * [tJavaRow_4 end ] stop
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
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
 */

	
	/**
	 * [tJavaRow_4 finally ] start
	 */

	

	
	
	currentComponent="tJavaRow_4";

	

 



/**
 * [tJavaRow_4 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class row13Struct implements routines.system.IPersistableRow<row13Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
			    public Integer id;

				public Integer getId () {
					return this.id;
				}
				
			    public String strMeal;

				public String getStrMeal () {
					return this.strMeal;
				}
				
			    public String strCategory;

				public String getStrCategory () {
					return this.strCategory;
				}
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
				}
				
			    public Integer calories;

				public Integer getCalories () {
					return this.calories;
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
						this.calories = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
						this.calories = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
					// Integer
				
						writeInteger(this.calories,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
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
		sb.append("id="+String.valueOf(id));
		sb.append(",strMeal="+strMeal);
		sb.append(",strCategory="+strCategory);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",area_id="+area_id);
		sb.append(",ingredients="+ingredients);
		sb.append(",calories="+String.valueOf(calories));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row13Struct other) {

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

public static class row12Struct implements routines.system.IPersistableRow<row12Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
			    public Integer id;

				public Integer getId () {
					return this.id;
				}
				
			    public String strMeal;

				public String getStrMeal () {
					return this.strMeal;
				}
				
			    public String strCategory;

				public String getStrCategory () {
					return this.strCategory;
				}
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
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
		sb.append("id="+String.valueOf(id));
		sb.append(",strMeal="+strMeal);
		sb.append(",strCategory="+strCategory);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",area_id="+area_id);
		sb.append(",ingredients="+ingredients);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row12Struct other) {

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
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
			    public Integer id;

				public Integer getId () {
					return this.id;
				}
				
			    public String strMeal;

				public String getStrMeal () {
					return this.strMeal;
				}
				
			    public String strCategory;

				public String getStrCategory () {
					return this.strCategory;
				}
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
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
		sb.append("id="+String.valueOf(id));
		sb.append(",strMeal="+strMeal);
		sb.append(",strCategory="+strCategory);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",area_id="+area_id);
		sb.append(",ingredients="+ingredients);
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

public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
			    public Integer id;

				public Integer getId () {
					return this.id;
				}
				
			    public String strMeal;

				public String getStrMeal () {
					return this.strMeal;
				}
				
			    public String strCategory;

				public String getStrCategory () {
					return this.strCategory;
				}
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
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
		sb.append("id="+String.valueOf(id));
		sb.append(",strMeal="+strMeal);
		sb.append(",strCategory="+strCategory);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",area_id="+area_id);
		sb.append(",ingredients="+ingredients);
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

public static class out6Struct implements routines.system.IPersistableRow<out6Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
			    public Integer id;

				public Integer getId () {
					return this.id;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
				}
				
			    public String calories;

				public String getCalories () {
					return this.calories;
				}
				
			    public String strMeal;

				public String getStrMeal () {
					return this.strMeal;
				}
				
			    public String strCategory;

				public String getStrCategory () {
					return this.strCategory;
				}
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
					this.ingredients = readString(dis);
					
					this.calories = readString(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
					this.ingredients = readString(dis);
					
					this.calories = readString(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
					// String
				
						writeString(this.calories,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
					// String
				
						writeString(this.ingredients,dos);
					
					// String
				
						writeString(this.calories,dos);
					
					// String
				
						writeString(this.strMeal,dos);
					
					// String
				
						writeString(this.strCategory,dos);
					
					// String
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",ingredients="+ingredients);
		sb.append(",calories="+calories);
		sb.append(",strMeal="+strMeal);
		sb.append(",strCategory="+strCategory);
		sb.append(",strInstructions="+strInstructions);
		sb.append(",area_id="+area_id);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out6Struct other) {

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

public static class row14Struct implements routines.system.IPersistableRow<row14Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
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
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
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
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
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
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
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
		sb.append(",strInstructions="+strInstructions);
		sb.append(",area_id="+area_id);
		sb.append(",ingredients="+ingredients);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row14Struct other) {

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

public static class row11Struct implements routines.system.IPersistableRow<row11Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
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
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
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
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
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
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
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
		sb.append(",strInstructions="+strInstructions);
		sb.append(",area_id="+area_id);
		sb.append(",ingredients="+ingredients);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row11Struct other) {

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

public static class out2Struct implements routines.system.IPersistableRow<out2Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
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
				
			    public String strInstructions;

				public String getStrInstructions () {
					return this.strInstructions;
				}
				
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				
			    public String ingredients;

				public String getIngredients () {
					return this.ingredients;
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
					this.ingredients = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
						this._id = readInteger(dis);
					
					this.strMeal = readString(dis);
					
					this.strCategory = readString(dis);
					
					this.strInstructions = readString(dis);
					
					this.area_id = readString(dis);
					
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
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
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
				
						writeString(this.strInstructions,dos);
					
					// String
				
						writeString(this.area_id,dos);
					
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
		sb.append(",strInstructions="+strInstructions);
		sb.append(",area_id="+area_id);
		sb.append(",ingredients="+ingredients);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out2Struct other) {

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

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

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

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

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

public static class after_tLoop_1Struct implements routines.system.IPersistableRow<after_tLoop_1Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];

	



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		

		

        }

		
			finally {}
		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		

		

        }

		
			finally {}
		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
        }

			finally {}
		

    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
        }

			finally {}
		

    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tLoop_1Struct other) {

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


		tDBInput_1Process(globalMap);
		tBufferInput_1Process(globalMap);

		row2Struct row2 = new row2Struct();
out2Struct out2 = new out2Struct();
row11Struct row11 = new row11Struct();
row14Struct row14 = new row14Struct();
out6Struct out6 = new out6Struct();
row3Struct row3 = new row3Struct();
row12Struct row12 = new row12Struct();
row13Struct row13 = new row13Struct();



	
	/**
	 * [tLoop_1 begin ] start
	 */

				
			int NB_ITERATE_tDBInput_3 = 0; //for statistics
			

	
		
		ok_Hash.put("tLoop_1", false);
		start_Hash.put("tLoop_1", System.currentTimeMillis());
		
	
	currentComponent="tLoop_1";

	
		int tos_count_tLoop_1 = 0;
		

int current_iteration_tLoop_1 = 0;

for(int looptLoop_1 =1; looptLoop_1<=(int) globalMap.get("TABLE_SIZE") / 10000; looptLoop_1=looptLoop_1+1){
	
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
	NB_ITERATE_tDBInput_3++;
	
	
					if(execStat){				
	       				runStat.updateStatOnConnection("row12", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("OnComponentOk18", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row14", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row11", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("out6", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row13", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row2", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row3", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("OnRowsEnd", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("out2", 3, 0);
					}           			
				
				if(execStat){
					runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tDBInput_3);
					//Thread.sleep(1000);
				}				
			







	
	/**
	 * [tAggregateRow_1_AGGOUT begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_1_AGGOUT", false);
		start_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
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

    				Integer id;
    				String strMeal;
    				String strCategory;
    				String strInstructions;
    				String area_id;StringBuilder ingredients_list = new StringBuilder();
           			boolean ingredients_list_firstEmpty = false;
           			
        
	    @Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;
		
							result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
							
							result = prime * result + ((this.strMeal == null) ? 0 : this.strMeal.hashCode());
							
							result = prime * result + ((this.strCategory == null) ? 0 : this.strCategory.hashCode());
							
							result = prime * result + ((this.strInstructions == null) ? 0 : this.strInstructions.hashCode());
							
							result = prime * result + ((this.area_id == null) ? 0 : this.area_id.hashCode());
							
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
			
							if (this.id == null) {
								if (other.id != null) 
									return false;
							} else if (!this.id.equals(other.id)) 
								return false;
						
							if (this.strMeal == null) {
								if (other.strMeal != null) 
									return false;
							} else if (!this.strMeal.equals(other.strMeal)) 
								return false;
						
							if (this.strCategory == null) {
								if (other.strCategory != null) 
									return false;
							} else if (!this.strCategory.equals(other.strCategory)) 
								return false;
						
							if (this.strInstructions == null) {
								if (other.strInstructions != null) 
									return false;
							} else if (!this.strInstructions.equals(other.strInstructions)) 
								return false;
						
							if (this.area_id == null) {
								if (other.area_id != null) 
									return false;
							} else if (!this.area_id.equals(other.area_id)) 
								return false;
						
			
			return true;
		}
  
        
	} // G_OutBegin_AggR_100

	AggOperationStruct_tAggregateRow_1 operation_result_tAggregateRow_1 = null;
	AggOperationStruct_tAggregateRow_1 operation_finder_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();
	java.util.Map<AggOperationStruct_tAggregateRow_1,AggOperationStruct_tAggregateRow_1> hash_tAggregateRow_1 = new java.util.HashMap<AggOperationStruct_tAggregateRow_1,AggOperationStruct_tAggregateRow_1>();
	
	String delimiter_tAggregateRow_1 = ",";
	

 



/**
 * [tAggregateRow_1_AGGOUT begin ] stop
 */



	
	/**
	 * [tJavaRow_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaRow_2", false);
		start_Hash.put("tJavaRow_2", System.currentTimeMillis());
		
	
	currentComponent="tJavaRow_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out6");
					}
				
		int tos_count_tJavaRow_2 = 0;
		

int nb_line_tJavaRow_2 = 0;

 



/**
 * [tJavaRow_2 begin ] stop
 */



	
	/**
	 * [tMap_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_4", false);
		start_Hash.put("tMap_4", System.currentTimeMillis());
		
	
	currentComponent="tMap_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row14");
					}
				
		int tos_count_tMap_4 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct> tHash_Lookup_row9 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct>) 
					globalMap.get( "tHash_Lookup_row9" ))
					;					
					
	

row9Struct row9HashKey = new row9Struct();
row9Struct row9Default = new row9Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_4__Struct  {
}
Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
out6Struct out6_tmp = new out6Struct();
// ###############################

        
        



        









 



/**
 * [tMap_4 begin ] stop
 */



	
	/**
	 * [tJavaRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaRow_1", false);
		start_Hash.put("tJavaRow_1", System.currentTimeMillis());
		
	
	currentComponent="tJavaRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row11");
					}
				
		int tos_count_tJavaRow_1 = 0;
		

int nb_line_tJavaRow_1 = 0;

 



/**
 * [tJavaRow_1 begin ] stop
 */



	
	/**
	 * [tExtractJSONFields_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tExtractJSONFields_1", false);
		start_Hash.put("tExtractJSONFields_1", System.currentTimeMillis());
		
	
	currentComponent="tExtractJSONFields_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out2");
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
	 * [tMap_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_3", false);
		start_Hash.put("tMap_3", System.currentTimeMillis());
		
	
	currentComponent="tMap_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tMap_3 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
					globalMap.get( "tHash_Lookup_row4" ))
					;					
					
	

row4Struct row4HashKey = new row4Struct();
row4Struct row4Default = new row4Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_3__Struct  {
}
Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
out2Struct out2_tmp = new out2Struct();
// ###############################

        
        



        









 



/**
 * [tMap_3 begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";

	
		int tos_count_tDBInput_3 = 0;
		
	
    
	
		    int nb_line_tDBInput_3 = 0;
		    java.sql.Connection conn_tDBInput_3 = null;
				conn_tDBInput_3 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "SELECT " +
"\"" + context.postgresql_schema + "\".\"" + context.postgresql_table_meals_temp + "\".\"_id\", " +
"\"" + context.postgresql_schema + "\".\"" + context.postgresql_table_meals_temp + "\".\"strMeal\", " +
"\"" + context.postgresql_schema + "\".\"" + context.postgresql_table_meals_temp + "\".\"strCategory\", " +
"\"" + context.postgresql_schema + "\".\"" + context.postgresql_table_meals_temp + "\".\"strArea\", " +
"\"" + context.postgresql_schema + "\".\"" + context.postgresql_table_meals_temp + "\".\"strInstructions\", " +
"\"" + context.postgresql_schema + "\".\"" + context.postgresql_table_meals_temp + "\".\"ingredients\" " +
"FROM \"" + context.postgresql_schema + "\".\"" + context.postgresql_table_meals_temp + "\" " +
"LIMIT 10000 OFFSET " +
Math.max(
    0,
    (((Integer)globalMap.getOrDefault("tLoop_1_CURRENT_VALUE", 1)) - 1) * 10000
)
;
		    

            	globalMap.put("tDBInput_3_QUERY",dbquery_tDBInput_3);
		    java.sql.ResultSet rs_tDBInput_3 = null;

		    try {
		    	rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
		    	int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

		    String tmpContent_tDBInput_3 = null;
		    
		    
		    while (rs_tDBInput_3.next()) {
		        nb_line_tDBInput_3++;
		        
							if(colQtyInRs_tDBInput_3 < 1) {
								row2._id = null;
							} else {
		                          
            row2._id = rs_tDBInput_3.getInt(1);
            if(rs_tDBInput_3.wasNull()){
                    row2._id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row2.strMeal = null;
							} else {
	                         		
        	row2.strMeal = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row2.strCategory = null;
							} else {
	                         		
        	row2.strCategory = routines.system.JDBCUtil.getString(rs_tDBInput_3, 3, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row2.strArea = null;
							} else {
	                         		
        	row2.strArea = routines.system.JDBCUtil.getString(rs_tDBInput_3, 4, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								row2.strInstructions = null;
							} else {
	                         		
        	row2.strInstructions = routines.system.JDBCUtil.getString(rs_tDBInput_3, 5, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								row2.ingredients = null;
							} else {
	                         		
        	row2.ingredients = routines.system.JDBCUtil.getString(rs_tDBInput_3, 6, false);
		                    }
					


 



/**
 * [tDBInput_3 begin ] stop
 */
	
	/**
	 * [tDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tMap_3 main ] start
	 */

	

	
	
	currentComponent="tMap_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_3 = false;
		  boolean mainRowRejected_tMap_3 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row4" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow4 = false;
       		  	    	
       		  	    	
 							row4Struct row4ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_3) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_3 = false;
								
                        		    		    row4HashKey.area_name = row2.strArea ;
                        		    		

								
		                        	row4HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row4.lookup( row4HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4' and it contains more one result from keys :  row4.area_name = '" + row4HashKey.area_name + "'");
								} // G 071
							

							row4Struct row4 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row4Struct fromLookup_row4 = null;
							row4 = row4Default;
										 
							
								 
							
							
								if (tHash_Lookup_row4 !=null && tHash_Lookup_row4.hasNext()) { // G 099
								
							
								
								fromLookup_row4 = tHash_Lookup_row4.next();

							
							
								} // G 099
							
							

							if(fromLookup_row4 != null) {
								row4 = fromLookup_row4;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_3__Struct Var = Var__tMap_3;// ###############################
        // ###############################
        // # Output tables

out2 = null;


// # Output table : 'out2'
out2_tmp._id = row2._id ;
out2_tmp.strMeal = row2.strMeal ;
out2_tmp.strCategory = row2.strCategory ;
out2_tmp.strInstructions = row2.strInstructions ;
out2_tmp.area_id = row4.area_id ;
out2_tmp.ingredients = row2.ingredients ;
out2 = out2_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_3 = false;










 


	tos_count_tMap_3++;

/**
 * [tMap_3 main ] stop
 */
	
	/**
	 * [tMap_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_begin ] stop
 */
// Start of branch "out2"
if(out2 != null) { 



	
	/**
	 * [tExtractJSONFields_1 main ] start
	 */

	

	
	
	currentComponent="tExtractJSONFields_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out2"
						
						);
					}
					

            if(out2.ingredients!=null){// C_01
                jsonStr_tExtractJSONFields_1 = out2.ingredients.toString();
   
row11 = null;

	

String loopPath_tExtractJSONFields_1 = "$[*]";
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
            row11 = null;
	row11 = new row11Struct();
	nb_line_tExtractJSONFields_1++;
	try {
        		row11._id = out2._id;
        		row11.strMeal = out2.strMeal;
        		row11.strCategory = out2.strCategory;
        		row11.strInstructions = out2.strInstructions;
        		row11.area_id = out2.area_id;
		jsonPath_tExtractJSONFields_1 = "$";
		compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);
		
		try {
		    
		        value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1.read(row_tExtractJSONFields_1);
		    
				row11.ingredients = value_tExtractJSONFields_1 == null ? 

		null

 : value_tExtractJSONFields_1.toString();
		} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",e_tExtractJSONFields_1.getMessage());
			row11.ingredients = 

		null

;
		}	
	} catch (java.lang.Exception ex_tExtractJSONFields_1) {
globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",ex_tExtractJSONFields_1.getMessage());
		    System.err.println(ex_tExtractJSONFields_1.getMessage());
		    row11 = null;	
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
// Start of branch "row11"
if(row11 != null) { 



	
	/**
	 * [tJavaRow_1 main ] start
	 */

	

	
	
	currentComponent="tJavaRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row11"
						
						);
					}
					

    String ingredient_name = row11.ingredients.replaceAll("^[0-9]+\\s*", "");

row14._id = row11._id;
row14.ingredients = ingredient_name.replaceAll("\"","").toLowerCase();
row14.strMeal = row11.strMeal;
row14.strCategory = row11.strCategory;
row14.strInstructions = row11.strInstructions;
row14.area_id = row11.area_id;






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
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row14"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_4 = false;
		  boolean mainRowRejected_tMap_4 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row9" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow9 = false;
       		  	    	
       		  	    	
 							row9Struct row9ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_4) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_4 = false;
								
                        		    		    row9HashKey.nom = row14.ingredients ;
                        		    		

								
		                        	row9HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row9.lookup( row9HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row9 != null && tHash_Lookup_row9.getCount(row9HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row9' and it contains more one result from keys :  row9.nom = '" + row9HashKey.nom + "'");
								} // G 071
							

							row9Struct row9 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row9Struct fromLookup_row9 = null;
							row9 = row9Default;
										 
							
								 
							
							
								if (tHash_Lookup_row9 !=null && tHash_Lookup_row9.hasNext()) { // G 099
								
							
								
								fromLookup_row9 = tHash_Lookup_row9.next();

							
							
								} // G 099
							
							

							if(fromLookup_row9 != null) {
								row9 = fromLookup_row9;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
        // ###############################
        // # Output tables

out6 = null;


// # Output table : 'out6'
out6_tmp.id = row14._id ;
out6_tmp.ingredients = row14.ingredients ;
out6_tmp.calories = row9.calories ;
out6_tmp.strMeal = row14.strMeal ;
out6_tmp.strCategory = row14.strCategory ;
out6_tmp.strInstructions = row14.strInstructions ;
out6_tmp.area_id = row14.area_id ;
out6 = out6_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_4 = false;










 


	tos_count_tMap_4++;

/**
 * [tMap_4 main ] stop
 */
	
	/**
	 * [tMap_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_begin ] stop
 */
// Start of branch "out6"
if(out6 != null) { 



	
	/**
	 * [tJavaRow_2 main ] start
	 */

	

	
	
	currentComponent="tJavaRow_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out6"
						
						);
					}
					

    row3.id = out6.id;
row3.strMeal = out6.strMeal;
row3.strCategory = out6.strCategory;
row3.strInstructions = out6.strInstructions;
row3.area_id = out6.area_id;

if (out6.ingredients != null && !out6.ingredients.isEmpty()) {
    String ingredientsCapitalized = out6.ingredients.substring(0, 1).toUpperCase() + out6.ingredients.substring(1);
    
    String calories = (out6.calories != null) ? out6.calories : "100";
    
    row3.ingredients = "\"(" + ingredientsCapitalized + "," + calories + ")\"";
}

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
	 * [tAggregateRow_1_AGGOUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					
	
operation_finder_tAggregateRow_1.id = row3.id;
			operation_finder_tAggregateRow_1.strMeal = row3.strMeal;
			operation_finder_tAggregateRow_1.strCategory = row3.strCategory;
			operation_finder_tAggregateRow_1.strInstructions = row3.strInstructions;
			operation_finder_tAggregateRow_1.area_id = row3.area_id;
			

	operation_finder_tAggregateRow_1.hashCodeDirty = true;
	
	operation_result_tAggregateRow_1 = hash_tAggregateRow_1.get(operation_finder_tAggregateRow_1);

	

	if(operation_result_tAggregateRow_1 == null) { // G_OutMain_AggR_001

		operation_result_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();

		operation_result_tAggregateRow_1.id = operation_finder_tAggregateRow_1.id;
				operation_result_tAggregateRow_1.strMeal = operation_finder_tAggregateRow_1.strMeal;
				operation_result_tAggregateRow_1.strCategory = operation_finder_tAggregateRow_1.strCategory;
				operation_result_tAggregateRow_1.strInstructions = operation_finder_tAggregateRow_1.strInstructions;
				operation_result_tAggregateRow_1.area_id = operation_finder_tAggregateRow_1.area_id;
				
		
		

		hash_tAggregateRow_1.put(operation_result_tAggregateRow_1, operation_result_tAggregateRow_1);
	
	} // G_OutMain_AggR_001


	
				if(operation_result_tAggregateRow_1.ingredients_list.length() > 0) {
					operation_result_tAggregateRow_1.ingredients_list.append(",");
				} 
				else if(operation_result_tAggregateRow_1.ingredients_list_firstEmpty){
					operation_result_tAggregateRow_1.ingredients_list.append(",");
				}
					if(operation_result_tAggregateRow_1.ingredients_list != null) {
						if(operation_result_tAggregateRow_1.ingredients_list_firstEmpty==false && ("").equals(String.valueOf(row3.ingredients))){
							operation_result_tAggregateRow_1.ingredients_list_firstEmpty = true;
						}
						operation_result_tAggregateRow_1.ingredients_list = operation_result_tAggregateRow_1.ingredients_list.append(String.valueOf(row3.ingredients));
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
	 * [tJavaRow_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaRow_2";

	

 



/**
 * [tJavaRow_2 process_data_end ] stop
 */

} // End of branch "out6"




	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_end ] stop
 */



	
	/**
	 * [tJavaRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaRow_1";

	

 



/**
 * [tJavaRow_1 process_data_end ] stop
 */

} // End of branch "row11"

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

} // End of branch "out2"




	
	/**
	 * [tMap_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

	}
}finally{
	if (rs_tDBInput_3 != null) {
		rs_tDBInput_3.close();
	}
	if (stmt_tDBInput_3 != null) {
		stmt_tDBInput_3.close();
	}
}
globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);
 

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tMap_3 end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tMap_3", true);
end_Hash.put("tMap_3", System.currentTimeMillis());




/**
 * [tMap_3 end ] stop
 */

	
	/**
	 * [tExtractJSONFields_1 end ] start
	 */

	

	
	
	currentComponent="tExtractJSONFields_1";

	
   globalMap.put("tExtractJSONFields_1_NB_LINE", nb_line_tExtractJSONFields_1);


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out2");
			  	}
			  	
 

ok_Hash.put("tExtractJSONFields_1", true);
end_Hash.put("tExtractJSONFields_1", System.currentTimeMillis());




/**
 * [tExtractJSONFields_1 end ] stop
 */

	
	/**
	 * [tJavaRow_1 end ] start
	 */

	

	
	
	currentComponent="tJavaRow_1";

	

globalMap.put("tJavaRow_1_NB_LINE",nb_line_tJavaRow_1);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row11");
			  	}
			  	
 

ok_Hash.put("tJavaRow_1", true);
end_Hash.put("tJavaRow_1", System.currentTimeMillis());




/**
 * [tJavaRow_1 end ] stop
 */

	
	/**
	 * [tMap_4 end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row14");
			  	}
			  	
 

ok_Hash.put("tMap_4", true);
end_Hash.put("tMap_4", System.currentTimeMillis());




/**
 * [tMap_4 end ] stop
 */

	
	/**
	 * [tJavaRow_2 end ] start
	 */

	

	
	
	currentComponent="tJavaRow_2";

	

globalMap.put("tJavaRow_2_NB_LINE",nb_line_tJavaRow_2);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out6");
			  	}
			  	
 

ok_Hash.put("tJavaRow_2", true);
end_Hash.put("tJavaRow_2", System.currentTimeMillis());




/**
 * [tJavaRow_2 end ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGOUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tAggregateRow_1_AGGOUT", true);
end_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());




/**
 * [tAggregateRow_1_AGGOUT end ] stop
 */



	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row13");
					}
				
		int tos_count_tDBOutput_2 = 0;
		





String dbschema_tDBOutput_2 = null;
	dbschema_tDBOutput_2 = (String)globalMap.get("schema_" + "tDBConnection_1");
	

String tableName_tDBOutput_2 = null;
if(dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
	tableName_tDBOutput_2 = (context.postgresql_table_meals);
} else {
	tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "\".\"" + (context.postgresql_table_meals);
}


int nb_line_tDBOutput_2 = 0;
int nb_line_update_tDBOutput_2 = 0;
int nb_line_inserted_tDBOutput_2 = 0;
int nb_line_deleted_tDBOutput_2 = 0;
int nb_line_rejected_tDBOutput_2 = 0;

int deletedCount_tDBOutput_2=0;
int updatedCount_tDBOutput_2=0;
int insertedCount_tDBOutput_2=0;
int rowsToCommitCount_tDBOutput_2=0;
int rejectedCount_tDBOutput_2=0;

boolean whetherReject_tDBOutput_2 = false;

java.sql.Connection conn_tDBOutput_2 = null;
String dbUser_tDBOutput_2 = null;

	conn_tDBOutput_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	
	


   int batchSize_tDBOutput_2 = 10000;
   int batchSizeCounter_tDBOutput_2=0;

int count_tDBOutput_2=0;
	    String insert_tDBOutput_2 = "INSERT INTO \"" + tableName_tDBOutput_2 + "\" (\"id\",\"strMeal\",\"strCategory\",\"strInstructions\",\"area_id\",\"ingredients\",\"calories\") VALUES (?,?,?,?,?,?,?)";
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
	    resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);
	    

 



/**
 * [tDBOutput_2 begin ] stop
 */



	
	/**
	 * [tJavaRow_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tJavaRow_5", false);
		start_Hash.put("tJavaRow_5", System.currentTimeMillis());
		
	
	currentComponent="tJavaRow_5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row12");
					}
				
		int tos_count_tJavaRow_5 = 0;
		

int nb_line_tJavaRow_5 = 0;

 



/**
 * [tJavaRow_5 begin ] stop
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

	

            				    row12.id = aggregated_row_tAggregateRow_1.id;
            				    
            				    row12.strMeal = aggregated_row_tAggregateRow_1.strMeal;
            				    
            				    row12.strCategory = aggregated_row_tAggregateRow_1.strCategory;
            				    
            				    row12.strInstructions = aggregated_row_tAggregateRow_1.strInstructions;
            				    
            				    row12.area_id = aggregated_row_tAggregateRow_1.area_id;
            				    
    								row12.ingredients = aggregated_row_tAggregateRow_1.ingredients_list.toString();
	    						

 


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
	 * [tJavaRow_5 main ] start
	 */

	

	
	
	currentComponent="tJavaRow_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row12"
						
						);
					}
					

    String input = row12.ingredients;

String[] elements = input.split("\",\"");

int totalCalories = 0;

for (String s : elements) {
    s = s.replace("\"", "")
         .replace("(", "")
         .replace(")", "");

    int lastComma = s.lastIndexOf(",");

    if (lastComma != -1) {
        String caloriesStr = s.substring(lastComma + 1).trim();
        totalCalories += Integer.parseInt(caloriesStr);
    }
}

row13.calories = totalCalories;
row13.id = row12.id;
row13.strMeal = row12.strMeal;
row13.strCategory = row12.strCategory;
row13.strInstructions = row12.strInstructions;
row13.area_id = row12.area_id;
row13.ingredients = row12.ingredients;
    nb_line_tJavaRow_5++;   

 


	tos_count_tJavaRow_5++;

/**
 * [tJavaRow_5 main ] stop
 */
	
	/**
	 * [tJavaRow_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJavaRow_5";

	

 



/**
 * [tJavaRow_5 process_data_begin ] stop
 */

	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row13"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    if(row13.id == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_2.setInt(1, row13.id);
}

                    if(row13.strMeal == null) {
pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(2, row13.strMeal);
}

                    if(row13.strCategory == null) {
pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(3, row13.strCategory);
}

                    if(row13.strInstructions == null) {
pstmt_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(4, row13.strInstructions);
}

                    if(row13.area_id == null) {
pstmt_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(5, row13.area_id);
}

                    if(row13.ingredients == null) {
pstmt_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(6, row13.ingredients);
}

                    if(row13.calories == null) {
pstmt_tDBOutput_2.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_2.setInt(7, row13.calories);
}

			
    		pstmt_tDBOutput_2.addBatch();
    		nb_line_tDBOutput_2++;
    		  
    		  
    		  batchSizeCounter_tDBOutput_2++;
    		  
            if(!whetherReject_tDBOutput_2) {
            }
    			if ((batchSize_tDBOutput_2 > 0) && (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2)) {
                try {
						int countSum_tDBOutput_2 = 0;
						    
						for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
						}
				    	rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
				    	
				    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
				    	
            	    	batchSizeCounter_tDBOutput_2 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_2){
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e_tDBOutput_2.getMessage());
				    	java.sql.SQLException ne_tDBOutput_2 = e_tDBOutput_2.getNextException(),sqle_tDBOutput_2=null;
				    	String errormessage_tDBOutput_2;
						if (ne_tDBOutput_2 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_2 = new java.sql.SQLException(e_tDBOutput_2.getMessage() + "\ncaused by: " + ne_tDBOutput_2.getMessage(), ne_tDBOutput_2.getSQLState(), ne_tDBOutput_2.getErrorCode(), ne_tDBOutput_2);
							errormessage_tDBOutput_2 = sqle_tDBOutput_2.getMessage();
						}else{
							errormessage_tDBOutput_2 = e_tDBOutput_2.getMessage();
						}
				    	
				    	int countSum_tDBOutput_2 = 0;
						for(int countEach_tDBOutput_2: e_tDBOutput_2.getUpdateCounts()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
						}
						rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
						
				    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
				    	
				    	System.err.println(errormessage_tDBOutput_2);
				    	
					}
    			}
    		

 


	tos_count_tDBOutput_2++;

/**
 * [tDBOutput_2 main ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */



	
	/**
	 * [tJavaRow_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tJavaRow_5";

	

 



/**
 * [tJavaRow_5 process_data_end ] stop
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
	 * [tJavaRow_5 end ] start
	 */

	

	
	
	currentComponent="tJavaRow_5";

	

globalMap.put("tJavaRow_5_NB_LINE",nb_line_tJavaRow_5);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row12");
			  	}
			  	
 

ok_Hash.put("tJavaRow_5", true);
end_Hash.put("tJavaRow_5", System.currentTimeMillis());




/**
 * [tJavaRow_5 end ] stop
 */

	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



	    try {
				int countSum_tDBOutput_2 = 0;
				if (pstmt_tDBOutput_2 != null && batchSizeCounter_tDBOutput_2 > 0) {
						
					for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
						
				}
		    	
		    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_2){
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e_tDBOutput_2.getMessage());
	    	java.sql.SQLException ne_tDBOutput_2 = e_tDBOutput_2.getNextException(),sqle_tDBOutput_2=null;
	    	String errormessage_tDBOutput_2;
			if (ne_tDBOutput_2 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_2 = new java.sql.SQLException(e_tDBOutput_2.getMessage() + "\ncaused by: " + ne_tDBOutput_2.getMessage(), ne_tDBOutput_2.getSQLState(), ne_tDBOutput_2.getErrorCode(), ne_tDBOutput_2);
				errormessage_tDBOutput_2 = sqle_tDBOutput_2.getMessage();
			}else{
				errormessage_tDBOutput_2 = e_tDBOutput_2.getMessage();
			}
	    	
	    	int countSum_tDBOutput_2 = 0;
			for(int countEach_tDBOutput_2: e_tDBOutput_2.getUpdateCounts()) {
				countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
			}
			rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
			
	    		insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
	    	
	    	System.err.println(errormessage_tDBOutput_2);
	    	
		}
	    
        if(pstmt_tDBOutput_2 != null) {
        		
            pstmt_tDBOutput_2.close();
            resourceMap.remove("pstmt_tDBOutput_2");
        }
    resourceMap.put("statementClosed_tDBOutput_2", true);

	nb_line_deleted_tDBOutput_2=nb_line_deleted_tDBOutput_2+ deletedCount_tDBOutput_2;
	nb_line_update_tDBOutput_2=nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
	nb_line_inserted_tDBOutput_2=nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
	nb_line_rejected_tDBOutput_2=nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;
	
        globalMap.put("tDBOutput_2_NB_LINE",nb_line_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_UPDATED",nb_line_update_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_DELETED",nb_line_deleted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row13");
			  	}
			  	
 

ok_Hash.put("tDBOutput_2", true);
end_Hash.put("tDBOutput_2", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk18", 0, "ok");
				}
				tDBCommit_4Process(globalMap);



/**
 * [tDBOutput_2 end ] stop
 */



























						if(execStat){
							runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tDBInput_3);
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
							
							tDBCommit_2Process(globalMap); 
						



	
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
						
					     			//free memory for "tMap_4"
					     			globalMap.remove("tHash_Lookup_row9"); 
				     			
					     			//free memory for "tMap_3"
					     			globalMap.remove("tHash_Lookup_row4"); 
				     			
				try{
					
	
	/**
	 * [tLoop_1 finally ] start
	 */

	

	
	
	currentComponent="tLoop_1";

	

 



/**
 * [tLoop_1 finally ] stop
 */

	
	/**
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tMap_3 finally ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 finally ] stop
 */

	
	/**
	 * [tExtractJSONFields_1 finally ] start
	 */

	

	
	
	currentComponent="tExtractJSONFields_1";

	

 



/**
 * [tExtractJSONFields_1 finally ] stop
 */

	
	/**
	 * [tJavaRow_1 finally ] start
	 */

	

	
	
	currentComponent="tJavaRow_1";

	

 



/**
 * [tJavaRow_1 finally ] stop
 */

	
	/**
	 * [tMap_4 finally ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 finally ] stop
 */

	
	/**
	 * [tJavaRow_2 finally ] start
	 */

	

	
	
	currentComponent="tJavaRow_2";

	

 



/**
 * [tJavaRow_2 finally ] stop
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
	 * [tJavaRow_5 finally ] start
	 */

	

	
	
	currentComponent="tJavaRow_5";

	

 



/**
 * [tJavaRow_5 finally ] stop
 */

	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



    if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
                if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_2")) != null) {
                    pstmtToClose_tDBOutput_2.close();
                }
    }
 



/**
 * [tDBOutput_2 finally ] stop
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
	

public void tDBCommit_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_2_SUBPROCESS_STATE", 0);

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
	 * [tDBCommit_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_2", false);
		start_Hash.put("tDBCommit_2", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_2";

	
		int tos_count_tDBCommit_2 = 0;
		

 



/**
 * [tDBCommit_2 begin ] stop
 */
	
	/**
	 * [tDBCommit_2 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_2";

	

	java.sql.Connection conn_tDBCommit_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBCommit_2 != null && !conn_tDBCommit_2.isClosed())
	{
	
			
			conn_tDBCommit_2.commit();
			
	
	}

 


	tos_count_tDBCommit_2++;

/**
 * [tDBCommit_2 main ] stop
 */
	
	/**
	 * [tDBCommit_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_2";

	

 



/**
 * [tDBCommit_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_2";

	

 



/**
 * [tDBCommit_2 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_2 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_2";

	

 

ok_Hash.put("tDBCommit_2", true);
end_Hash.put("tDBCommit_2", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk10", 0, "ok");
				}
				tMongoDBClose_2Process(globalMap);



/**
 * [tDBCommit_2 end ] stop
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
	 * [tDBCommit_2 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_2";

	

 



/**
 * [tDBCommit_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_2_SUBPROCESS_STATE", 1);
	}
	

public void tMongoDBClose_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBClose_2_SUBPROCESS_STATE", 0);

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
	 * [tMongoDBClose_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBClose_2", false);
		start_Hash.put("tMongoDBClose_2", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBClose_2";

	
		int tos_count_tMongoDBClose_2 = 0;
		

 



/**
 * [tMongoDBClose_2 begin ] stop
 */
	
	/**
	 * [tMongoDBClose_2 main ] start
	 */

	

	
	
	currentComponent="tMongoDBClose_2";

	
        com.mongodb.client.MongoClient mongo_tMongoDBClose_2=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        if(mongo_tMongoDBClose_2 != null ) {
            mongo_tMongoDBClose_2.close();
        }



 


	tos_count_tMongoDBClose_2++;

/**
 * [tMongoDBClose_2 main ] stop
 */
	
	/**
	 * [tMongoDBClose_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBClose_2";

	

 



/**
 * [tMongoDBClose_2 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBClose_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBClose_2";

	

 



/**
 * [tMongoDBClose_2 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBClose_2 end ] start
	 */

	

	
	
	currentComponent="tMongoDBClose_2";

	

 

ok_Hash.put("tMongoDBClose_2", true);
end_Hash.put("tMongoDBClose_2", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk11", 0, "ok");
				}
				tWarn_2Process(globalMap);



/**
 * [tMongoDBClose_2 end ] stop
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
	 * [tMongoDBClose_2 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBClose_2";

	

 



/**
 * [tMongoDBClose_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tMongoDBClose_2_SUBPROCESS_STATE", 1);
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
	
	resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_2", "", Thread.currentThread().getId() + "", "INFO","","LoadGold end","", "");
	globalMap.put("tWarn_2_WARN_MESSAGES", "LoadGold end"); 
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
	

public void tDBCommit_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_4_SUBPROCESS_STATE", 0);

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
	 * [tDBCommit_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_4", false);
		start_Hash.put("tDBCommit_4", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_4";

	
		int tos_count_tDBCommit_4 = 0;
		

 



/**
 * [tDBCommit_4 begin ] stop
 */
	
	/**
	 * [tDBCommit_4 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_4";

	

	java.sql.Connection conn_tDBCommit_4 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBCommit_4 != null && !conn_tDBCommit_4.isClosed())
	{
	
			
			conn_tDBCommit_4.commit();
			
	
	}

 


	tos_count_tDBCommit_4++;

/**
 * [tDBCommit_4 main ] stop
 */
	
	/**
	 * [tDBCommit_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_4";

	

 



/**
 * [tDBCommit_4 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_4";

	

 



/**
 * [tDBCommit_4 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_4 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_4";

	

 

ok_Hash.put("tDBCommit_4", true);
end_Hash.put("tDBCommit_4", System.currentTimeMillis());




/**
 * [tDBCommit_4 end ] stop
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
	 * [tDBCommit_4 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_4";

	

 



/**
 * [tDBCommit_4 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_4_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String area_id;

				public String getArea_id () {
					return this.area_id;
				}
				
			    public String area_name;

				public String getArea_name () {
					return this.area_name;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.area_name == null) ? 0 : this.area_name.hashCode());
					
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
		
						if (this.area_name == null) {
							if (other.area_name != null)
								return false;
						
						} else if (!this.area_name.equals(other.area_name))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.area_id = this.area_id;
	            other.area_name = this.area_name;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.area_name = this.area_name;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.area_name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.area_name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.area_name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.area_name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.area_id = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.area_id = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.area_id, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.area_id, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("area_id="+area_id);
		sb.append(",area_name="+area_name);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.area_name, other.area_name);
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
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

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



		row4Struct row4 = new row4Struct();




	
	/**
	 * [tAdvancedHash_row4 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row4", false);
		start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tAdvancedHash_row4 = 0;
		

			   		// connection name:row4
			   		// source node:tDBInput_1 - inputs:(after_tLoop_1) outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
			   		// linked node: tMap_3 - inputs:(row2,row4) outputs:(out2)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row4Struct>getLookup(matchingModeEnum_row4);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row4 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
	
    
	
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				conn_tDBInput_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT \n  \""+context.postgresql_schema+"\".\""+context.postgresql_table_area+"\".\"area_id\", \n  \""+context.postgresql_schema+"\".\""+context.postgresql_table_area+"\".\"area_name\"\nFROM \""+context.postgresql_schema+"\".\""+context.postgresql_table_area+"\"";
		    

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row4.area_id = null;
							} else {
	                         		
        	row4.area_id = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row4.area_name = null;
							} else {
	                         		
        	row4.area_name = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
					


 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					


			   
			   

					row4Struct row4_HashRow = new row4Struct();
		   	   	   
				
				row4_HashRow.area_id = row4.area_id;
				
				row4_HashRow.area_name = row4.area_name;
				
			tHash_Lookup_row4.put(row4_HashRow);
			
            




 


	tos_count_tAdvancedHash_row4++;

/**
 * [tAdvancedHash_row4 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
 

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

tHash_Lookup_row4.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row4", true);
end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());




/**
 * [tAdvancedHash_row4 end ] stop
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
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class row9Struct implements routines.system.IPersistableComparableLookupRow<row9Struct> {
    final static byte[] commonByteArrayLock_PROJECT_LoadGold = new byte[0];
    static byte[] commonByteArray_PROJECT_LoadGold = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String nom;

				public String getNom () {
					return this.nom;
				}
				
			    public String calories;

				public String getCalories () {
					return this.calories;
				}
				


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
		final row9Struct other = (row9Struct) obj;
		
						if (this.nom == null) {
							if (other.nom != null)
								return false;
						
						} else if (!this.nom.equals(other.nom))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row9Struct other) {

		other.nom = this.nom;
	            other.calories = this.calories;
	            
	}

	public void copyKeysDataTo(row9Struct other) {

		other.nom = this.nom;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJECT_LoadGold.length) {
				if(length < 1024 && commonByteArray_PROJECT_LoadGold.length == 0) {
   					commonByteArray_PROJECT_LoadGold = new byte[1024];
				} else {
   					commonByteArray_PROJECT_LoadGold = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJECT_LoadGold, 0, length);
			strReturn = new String(commonByteArray_PROJECT_LoadGold, 0, length, utf8Charset);
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
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJECT_LoadGold) {

        	try {

        		int length = 0;
		
					this.nom = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.nom,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.calories = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.calories = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.calories, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.calories, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("nom="+nom);
		sb.append(",calories="+calories);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row9Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.nom, other.nom);
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
public void tBufferInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tBufferInput_1_SUBPROCESS_STATE", 0);

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
	 * [tAdvancedHash_row9 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row9", false);
		start_Hash.put("tAdvancedHash_row9", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row9";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row9");
					}
				
		int tos_count_tAdvancedHash_row9 = 0;
		

			   		// connection name:row9
			   		// source node:tBufferInput_1 - inputs:(after_tLoop_1) outputs:(row9,row9) | target node:tAdvancedHash_row9 - inputs:(row9) outputs:()
			   		// linked node: tMap_4 - inputs:(row14,row9) outputs:(out6)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row9 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct> tHash_Lookup_row9 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row9Struct>getLookup(matchingModeEnum_row9);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row9", tHash_Lookup_row9);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row9 begin ] stop
 */



	
	/**
	 * [tBufferInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tBufferInput_1", false);
		start_Hash.put("tBufferInput_1", System.currentTimeMillis());
		
	
	currentComponent="tBufferInput_1";

	
		int tos_count_tBufferInput_1 = 0;
		

int nb_line_tBufferInput_1 = 0;

String[] row_tBufferInput_1 = new String[2];
for (int n = 0; n < globalBuffer.size(); n++)
{
	row_tBufferInput_1 = (String[])globalBuffer.get(n);	
	if(0 < row_tBufferInput_1.length){
	
		row9.nom = row_tBufferInput_1[0];	
	
	}
	
	else{
		row9.nom = null;
	}	
	if(1 < row_tBufferInput_1.length){
	
		row9.calories = row_tBufferInput_1[1];	
	
	}
	
	else{
		row9.calories = null;
	}
 



/**
 * [tBufferInput_1 begin ] stop
 */
	
	/**
	 * [tBufferInput_1 main ] start
	 */

	

	
	
	currentComponent="tBufferInput_1";

	

 


	tos_count_tBufferInput_1++;

/**
 * [tBufferInput_1 main ] stop
 */
	
	/**
	 * [tBufferInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tBufferInput_1";

	

 



/**
 * [tBufferInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row9 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row9"
						
						);
					}
					


			   
			   

					row9Struct row9_HashRow = new row9Struct();
		   	   	   
				
				row9_HashRow.nom = row9.nom;
				
				row9_HashRow.calories = row9.calories;
				
			tHash_Lookup_row9.put(row9_HashRow);
			
            




 


	tos_count_tAdvancedHash_row9++;

/**
 * [tAdvancedHash_row9 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

 



/**
 * [tAdvancedHash_row9 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row9 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

 



/**
 * [tAdvancedHash_row9 process_data_end ] stop
 */



	
	/**
	 * [tBufferInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tBufferInput_1";

	

 



/**
 * [tBufferInput_1 process_data_end ] stop
 */
	
	/**
	 * [tBufferInput_1 end ] start
	 */

	

	
	
	currentComponent="tBufferInput_1";

	
	nb_line_tBufferInput_1++;
}
globalMap.put("tBufferInput_1_NB_LINE",nb_line_tBufferInput_1); 

 

ok_Hash.put("tBufferInput_1", true);
end_Hash.put("tBufferInput_1", System.currentTimeMillis());




/**
 * [tBufferInput_1 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row9 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

tHash_Lookup_row9.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row9");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row9", true);
end_Hash.put("tAdvancedHash_row9", System.currentTimeMillis());




/**
 * [tAdvancedHash_row9 end ] stop
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
	 * [tBufferInput_1 finally ] start
	 */

	

	
	
	currentComponent="tBufferInput_1";

	

 



/**
 * [tBufferInput_1 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row9 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

 



/**
 * [tAdvancedHash_row9 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tBufferInput_1_SUBPROCESS_STATE", 1);
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
        final LoadGold LoadGoldClass = new LoadGold();

        int exitCode = LoadGoldClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = (String[][])globalBuffer.toArray(new String[globalBuffer.size()][]);

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        		hastBufferOutput = true;
    	
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
            java.io.InputStream inContext = LoadGold.class.getClassLoader().getResourceAsStream("project/loadgold_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = LoadGold.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
                        context.setContextType("postgresql_table_meals_temp", "id_String");
                        if(context.getStringValue("postgresql_table_meals_temp") == null) {
                            context.postgresql_table_meals_temp = null;
                        } else {
                            context.postgresql_table_meals_temp=(String) context.getProperty("postgresql_table_meals_temp");
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
            }if (parentContextMap.containsKey("postgresql_table_meals_temp")) {
                context.postgresql_table_meals_temp = (String) parentContextMap.get("postgresql_table_meals_temp");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : LoadGold");
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
    closeSqlDbConnections();


    }



    private void closeSqlDbConnections() {
        try {
            Object obj_conn;
            obj_conn = globalMap.remove("conn_tDBConnection_1");
            if (null != obj_conn) {
                ((java.sql.Connection) obj_conn).close();
            }
        } catch (java.lang.Exception e) {
        }
    }











    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
            connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));






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
 *     368458 characters generated by Talend Open Studio for Big Data 
 *     on the 27 février 2026, 02:11:16 CET
 ************************************************************************************************/