package gov.usda.sr23

/**
 * Based on USDA Food Group Description File (file name = FD_GROUP). This file (Table 5)
 * is a support file to the Food Description file and contains a list of food groups used
 * in SR23 and their descriptions.
 */
class FoodGroupDescription {
	String id
	String description
	
    static constraints = {
		id maxSize: 4
		description maxSize: 60
    }

	String toString() { description }
	
	static hasMany = [ foods: Food ]
	
	static mapping = {
		table 'FD_GROUP'
		version false
		cache usage:'read-only'
		id generator: 'assigned', column: 'id', type: 'string', sqlType: 'VARCHAR(4)'
		
		id column: "FdGrp_Cd"
		description column: "FdGrp_Desc"
	}
}
