package gov.usda.sr23

/**
 * 
 * @author ast
 *
 * Based on USDA Footnote File (file name = FOOTNOTE). This file (Table 13)
 * contains additional information about the food item, household weight, and nutrient value.
 */
class Footnote {
	Food food
	String sequenceNumber
	String footnoteType		// D = adding info to food description, M = adding info to measure description, N = adding info on nutrient value
	NutrientDefinition nutrientDefinition
	String footnoteText
	
	String toString() { footnoteText }
	
    static constraints = {
    	food(maxSize:5)
    	sequenceNumber(maxSize:4)
		footnoteType(maxSize:1)
		footnoteText(maxSize:200)
    }
	
	static mapping = {
		table 'FOOTNOTE'
		version false
		cache usage:'read-only'

		food column: "NDB_No", sqlType: "VARCHAR(5)"
		sequenceNumber column: "Footnt_No", sqlType: "VARCHAR(4)"
		footnoteType column: "Footnt_Typ", sqlType: "VARCHAR(1)"
		nutrientDefinition column: "Nutr_No", sqlType: "VARCHAR(3)"
		footnoteText column: "Footnt_Txt", sqlType: "VARCHAR(200)"
	}
}
