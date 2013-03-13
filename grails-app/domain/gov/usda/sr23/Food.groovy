package gov.usda.sr23

/**
 * 
 * @author ast
 * 
 * Based on USDA Food Description File (file name = FOOD_DES).
 * This file (Table 4) contains long and short descriptions and food group designators for 7,636 food items,
 * along with common names, manufacturer name, scientific name, percentage and description of refuse, and
 * factors used for calculating protein and kilocalories, if applicable. Items used in the FNDDS are also
 * identified by value of ÒYÓ in the Survey field.
 *
 */
class Food {
	String id
	String longDescription
	String shortDescription
	String commonName
	String manufacturer
	String survey
	String refuseDescription
	Integer pctRefuse
	String scientificName
	Float nitrogenFactor
	Float proteinFactor
	Float fatFactor
	Float carbohydrateFactor
	
	String toString() { longDescription }

	static belongsTo = [ foodGroup: FoodGroupDescription ]
	
	static hasMany = [ weights: Weight, nutrients: NutrientData ]
	
    static constraints = {
		id(maxSize:5)
		longDescription(maxSize:200)
		shortDescription(maxSize:60)
		commonName(nullable:true,maxSize:100)
		manufacturer(nullable:true,maxSize:65)
		survey(nullable:true,maxSize:1)
		refuseDescription(nullable:true,maxSize:135)
		pctRefuse(nullable:true)
		scientificName(nullable:true,maxSize:65)
		nitrogenFactor(nullable:true)
		proteinFactor(nullable:true)
		fatFactor(nullable:true)
		carbohydrateFactor(nullable:true)
    }
	
	static mapping = {
		table 'FOOD_DES'
		version false
		cache usage:'read-only'
		id generator: 'assigned', name:"id", column: "NDB_No", type: "string",sqlType: "VARCHAR(5)"

		foodGroup column: "FdGrp_Cd", sqlType: "VARCHAR(4)"
		longDescription column: "Long_Desc"
		shortDescription column: "Short_Desc"
		commonName column: "ComName"
		manufacturer column: "ManufacName"
		survey column: "Survey"
		refuseDescription column: "Ref_desc"
		pctRefuse column: "Refuse"
		scientificName column: "SciName"
		nitrogenFactor column: "N_Factor"
		proteinFactor column: "Pro_Factor"
		fatFactor column: "Fat_Factor"
		carbohydrateFactor column: "CHO_Factor"		
	}
	
	static transients = [ 'footnotes', 'langualFactors' ]
	
	def getFootnotes() {
		return Footnote.findAllByFood(this)
	}
	
	def getLangualFactors() {
		return LangualFactor.findAllByFood(this)
	}
	
}
