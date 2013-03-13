package gov.usda.sr23

/**
 * 
 * @author ast
 *
 * Based on USDA Sources of Data File (file name = DATA_SRC). This file (Table 15)
 * provides a citation to the DataSrc_ID in the Sources of Data Link file.
 *
 * NOTE: THE ID FIELD DataSrc_ID DOES NOT WORK WITH GRAILS DO TO A MIX OF ALPHA AND NUMERIC CHARS
 */
class NutrientDataSource {
	String authors
	String title
	String yearPublished
	String journal
	String sponsorOrgCity
	String sponsorOrgState
	String startPage
	String endPage
	
    static constraints = {
		authors(nullable:true)
		yearPublished(nullable:true,maxSize:4)
		journal(nullable:true,maxSize:135)
		sponsorOrgCity(nullable:true,maxSize:16)
		sponsorOrgState(nullable:true,maxSize:5)
		startPage(nullable:true,maxSize:5)
		endPage(nullable:true,maxSize:5)
    }

	static mapping = {
		table 'DATA_SRC'
		version false
		cache usage:'read-only'
		id generator: 'assigned', column: "DataSrc_ID", sqlType: "VARCHAR(6)"
		
		authors column: "Authors"
		title column: "Title"
		yearPublished column: "Year"
		journal column: "Journal"
		sponsorOrgCity column: "Vol_City"
		sponsorOrgState column: "Issue_State"
		startPage column: "Start_Page"
		endPage column: "End_Page"		
	}

}
