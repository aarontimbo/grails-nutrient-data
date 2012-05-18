package gov.usda.sr23

/**
 * Based on USDA Nutrient Definition File (file name = NUTR_DEF). This file (Table 9)
 * is a support file to the Nutrient Data file. It provides the 3-digit nutrient code,
 * unit of measure, INFOODS tagname, and description.
 */
class NutrientDefinition {
	String units
	String tagName
	String description
	String decimalPlaces
	Integer sortOrder

	String toString() { description }
	
    static constraints = {
		units(maxSize:7)
		tagName(nullable:true,maxSize:20)
		description(maxSize:60)
		decimalPlaces(maxSize:1)
    }
	
	static mapping = {
		table 'NUTR_DEF'
		version false
		cache usage:'read-only'
		id generator: 'assigned', column: 'Nutr_No', sqlType: 'VARCHAR(3)'

		units column: "Units"
		tagName column: "Tagname"
		description column: "NutrDesc"
		decimalPlaces column: "Num_Dec"
		sortOrder column: "SR_Order"
	}
}
