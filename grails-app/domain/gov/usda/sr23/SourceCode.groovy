package gov.usda.sr23

/**
 * Based on USDA Source Code File (file name = SRC_CD). This file (Table 10) contains codes
 * indicating the type of data (analytical, calculated, assumed zero, and so on) in the Nutrient
 * Data file. To improve the usability of the database and to provide values for the FNDDS, NDL
 * staff imputed nutrient values for a number of proximate components, total dietary fiber,
 * total sugar, and vitamin and mineral values.
 * 
 */
class SourceCode {
	String description
	
	String toString() { description }
	
    static constraints = {
		description(maxSize:60)
    }
	
	static mapping = {
		table 'SRC_CD'
		version false
		cache usage:'read-only'
		id generator:'assigned', column: 'Src_Cd', sqlType: 'VARCHAR(2)'

		description column: "SrcCd_Desc"
	}
}
