package gov.usda.sr23

/**
 * Based on USDA LanguaL Factor File (File name = LANGDESC). This file (Table 7)
* is a support file to the LanguaL Factor file and contains the descriptions for
* only those factors used in coding the selected food items codes in this release of SR.
*/
class LangualFactorDescription {
	String description
	
    static constraints = {
		description(maxSize:140)
    }
	
	static mapping = {
		table 'LANGDESC'
		version false
		cache usage:'read-only'
		id generator: 'assigned', column: 'Factor_Code', sqlType: 'VARCHAR(5)'

		description column: "Description"
	}
}
