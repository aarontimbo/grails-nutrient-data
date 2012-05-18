package gov.usda.sr23

class NutrientDataService {

    def serviceMethod() {

    }

	def Float getFoodNutrientData(Weight foodWeight, NutrientDefinition nutrientDefinitionInstance, Float servings) {
		/**
		* Generic nutrient value calculator for a food weight object taking a nutrient definition object
		* (i.e. protein, fat, carb, etc). Returns a float value
		*/
		def val = 0.0
		def nutrientDataInstance = NutrientData.findByFoodAndNutrientDefinition(foodWeight?.food, nutrientDefinitionInstance)
		if (nutrientDataInstance) {
			val = servings * nutrientDataInstance?.nutrientValue * foodWeight?.gramWeight / 100
		}
		return val
		
	}

}
