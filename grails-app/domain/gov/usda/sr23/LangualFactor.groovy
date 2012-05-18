package gov.usda.sr23

/**
 *  Based on USDA LanguaL Factor File (File name = LANGUAL). This file (Table 6)
 *  is a support file to the Food Description file and contains the factors from
 *  the LanguaL Thesaurus used to code a particular food.
 */
class LangualFactor implements Serializable {
	
	static belongsTo = [ food: Food, langualFactorDescription: LangualFactorDescription ]
	
	String toString() { langualFactorDescription.description }
	
    static constraints = {
    }
	
	static mapping = {
		table 'LANGUAL'
		version false
		cache usage:'read-only'
		id composite: [ 'food', 'langualFactorDescription' ]

		food column: "NDB_No", sqlType: "VARCHAR(5)"
		langualFactorDescription column: "Factor_Code", sqlType: "VARCHAR(5)"
	}
}
