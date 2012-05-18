package gov.usda.sr23

import spock.lang.*
import grails.plugin.spock.*

class NutrientDataServiceSpec extends IntegrationSpec {
	def nutrientDataService

    def "test get food nutrient value"() {
	setup:
	// Create food group
	def foodGroup = new FoodGroupDescription(description: description)
	foodGroup.id = 1100
	foodGroup.save(flush:true)
	// Create food
	def food = new Food(foodGroup: foodGroup, longDescription:longDesc, shortDescription:longDesc) 
	food.id = 11298
	food.save(flush:true)
	// Create a food weight
	def weight = new Weight(food: food, sequenceNumber:seq, amount:amount, description:measDesc, gramWeight:gramWt).save(flush:true)
	// Create nutrient definition
	def definition = new NutrientDefinition(units:'g', tagName:'PROCNT', description:nutDesc, decimalPlaces:2, sortOrder:600)
	definition.id = 203
	definition.save(flush:true)
	// Create source code
	def sourceCode = new SourceCode(description:'analytical')
	sourceCode.id = 1
	sourceCode.save(flush:true)
	// Create nutrient data
	def ndata = new NutrientData(food: food, nutrientDefinition:definition, sourceCode:sourceCode, nutrientValue:1.2, dataPoints:1).save(flush:true)


	when:
	// Test service
	def nutrientValue = nutrientDataService.getFoodNutrientData(weight, definition, servings)

	then:
	FoodGroupDescription.findByDescription(description) != null
	println "Food Group: ${description}"
	Food.findByLongDescription(longDesc) != null
	println "Food: ${longDesc}"
	Weight.findByDescription(measDesc) != null
	println "Weight: ${measDesc}"
	NutrientDefinition.findByDescription(nutDesc) != null
	println "Nutrient Definition: ${nutDesc}"
	NutrientData.findByFood(food) != null
	println "Nutrient Data: ${NutrientData.findByFood(food)}"
	println "\n"
	nutrientValue > 0
	println "* NUTRIENT VALUE: ${nutrientValue}${definition.units} of ${definition.description} in $servings $measDesc"


	where:
	description = "vegetable"
	longDesc = "Parsnips,raw"
	measDesc = "cup slices"
	seq = 1
	amount = 1.0
	gramWt = 133.0
	nutDesc = "Protein"
	servings = 3.0
    }

}
