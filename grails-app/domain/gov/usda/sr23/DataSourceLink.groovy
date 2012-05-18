package gov.usda.sr23

/**
 * 
 * @author ast
 *
 * Based on USDA Sources of Data Link File (file name = DATSRCLN). This file (Table 14)
 * is used to link the Nutrient Data file with the Sources of Data table. It is needed
 * to resolve the many-to-many relationship between the two tables.
 */
class DataSourceLink implements Serializable {
	String foodId
	String nutrientDefinitionId
	String dataSourceId
	
    static constraints = {
    }
	
	static mapping = {
		table 'DATSRCLN'
		version false
		cache usage:'read-only'
		id composite: [ 'foodId', 'nutrientDefinitionId', 'dataSourceId' ]
		
		foodId column: 'NDB_No', sqlType: 'VARCHAR(5)'
		nutrientDefinitionId column: 'Nutr_No', sqlType: 'VARCHAR(3)'
		dataSourceId column: 'DataSrc_ID', sqlType: 'VARCHAR(6)'
				
	}
}
