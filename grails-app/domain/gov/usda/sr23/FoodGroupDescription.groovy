package gov.usda.sr23

/**
 * Based on USDA Food Group Description File (file name = FD_GROUP). This file (Table 5)
 * is a support file to the Food Description file and contains a list of food groups used
 * in SR23 and their descriptions.
 */
class FoodGroupDescription {
	String description
	
    static constraints = {
		description(maxSize:60)
    }

	String toString() { description }
	
	static hasMany = [ foods: Food ]
	
	static mapping = {
		table 'FD_GROUP'
		version false
		cache usage:'read-only'
		id generator: 'assigned', column: 'FdGrp_Cd', sqlType: 'VARCHAR(4)'
		
		description column: "FdGrp_Desc"
	}
}
