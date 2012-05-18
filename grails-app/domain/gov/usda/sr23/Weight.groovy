package gov.usda.sr23

/**
 * 
 * @author ast
 *
 * Based on USDA Weight File (file name = WEIGHT). This file (Table 12)
 * contains the weight in grams of a number of common measures for each food item.
 */
class Weight implements Serializable {
	String sequenceNumber
	Float amount
	String description
	Float gramWeight
	Integer dataPoints
	Float standardDeviation
	
	static belongsTo = [ food: Food ]
	
	String toString() { "${amount} ${description} = ${gramWeight} grams" }
	
    static constraints = {
    	sequenceNumber(maxSize:2)
		description(maxSize:80)
		dataPoints(nullable:true)
		standardDeviation(nullable:true)
    }
	
	static mapping = {
		table 'WEIGHT'
		version false
		cache usage:'read-only'
		id composite:['food','sequenceNumber']

		food column: "NDB_No", sqlType: "VARCHAR(5)"
		sequenceNumber column: "Seq", sqlType: "VARCHAR(2)"
		amount column: "Amount"
		description column: "Msre_Desc"
		gramWeight column: "Gm_Wgt"
		dataPoints column: "Num_Data_Pts"
		standardDeviation column: "Std_Dev"
	}
}
