package gov.usda.sr23

/**
 * 
 * @author ast
 * 
 * Based on USDA Data Derivation Code Description File (file name = DERIV_CD). This file (Table 11)
 * provides information on how the nutrient values were determined. The file contains the derivation
 * codes and their descriptions.
 *
 */
class DataDerivationDescription {
	String description
	
	String toString() { description }
	
    static constraints = {
		description(maxSize:120)
    }
	
	static mapping = {
		table 'DERIV_CD'
		version false
		cache usage:'read-only'
		id generator: "assigned", column: "Deriv_Cd", sqlType: "VARCHAR(4)"

		description column: "Deriv_Desc"
	}

}
