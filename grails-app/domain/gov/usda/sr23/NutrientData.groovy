package gov.usda.sr23

/**
 * Based on USDA Nutrient Data File (file name = NUT_DATA). This file (Table 8)
 * contains the nutrient values and information about the values, including
 * expanded statistical information.
 */

class NutrientData implements Serializable {
	Float nutrientValue
	Float dataPoints
	Float standardError
	SourceCode sourceCode
	String derivCd
	Food referenceFood
	String additionalNutrientMark
	Integer numberOfStudies
	Float minimumValue
	Float maximumValue
	Integer degreesOfFreedom
	Float lowerErrorBound
	Float upperErrorBound
	String comment
	String confidenceCode

	static belongsTo = [ food: Food, nutrientDefinition: NutrientDefinition ]
	
	String toString() { "${nutrientDefinition.description}..............${nutrientValue} ${nutrientDefinition.units}" }
	
	static constraints = {
		standardError(nullable:true)
		derivCd(nullable:true,maxSize:4)
		referenceFood(nullable:true,maxSize:5)
		additionalNutrientMark(nullable:true,maxSize:1)
		numberOfStudies(nullable:true)
		minimumValue(nullable:true)
		maximumValue(nullable:true)
		degreesOfFreedom(nullable:true)
		lowerErrorBound(nullable:true)
		upperErrorBound(nullable:true)
		comment(nullable:true,maxSize:10)
		confidenceCode(nullable:true,maxSize:1)	
    }
	
	static mapping = {
		table 'NUT_DATA'
		version false
		cache usage:'read-only'
		id composite: [ 'food', 'nutrientDefinition' ]

		food column: "NDB_No", sqlType: "VARCHAR(5)"	
		nutrientDefinition column: "Nutr_No", sqlType: "VARCHAR(3)"		
		nutrientValue column: "Nutr_Val"
		dataPoints column: "Num_Data_Pts"
		standardError column: "Std_Error"
		sourceCode column: "Src_Cd", sqlType: "VARCHAR(2)"
		derivCd column: "Deriv_Cd", sqlType: "VARCHAR(4)"
		referenceFood column: "Ref_NDB_No", sqlType: "VARCHAR(5)"
		additionalNutrientMark column: "Add_Nutr_Mark"
		numberOfStudies column: "Num_Studies"
		minimumValue column: "Min"
		maximumValue column: "Max"
		degreesOfFreedom column: "DF"
		lowerErrorBound column: "Low_EB"
		upperErrorBound column: "Up_EB"
		comment column: "Stat_cmt"
		confidenceCode column: "CC"
	}
	
	DataDerivationDescription getDataDerivationDescription() {
		return DataDerivationDescription.get(derivCd)
	}
	
	static transients = [ 'dataDerivationDescription' ]
}
