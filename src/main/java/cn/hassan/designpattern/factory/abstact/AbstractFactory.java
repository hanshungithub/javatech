package cn.hassan.designpattern.factory.abstact;

/**
 * Created with idea
 * Author: hss
 * Date: 7/27/2018 8:38 AM
 * Description:
 */
public class AbstractFactory {

	// abstract factory
	abstract class Kitchen {
		public abstract KitchenMeal getMeal(String preferency);
		public abstract KitchenMeal getDessert(String preferency);
	}
	// concrete factory
	class KitchenFactory extends Kitchen {
		@Override
		public KitchenMeal getMeal(String preferency) {
			if (preferency.equals("F.1")) {
				return new FastFoodMeal();
			} else if (preferency.equals("P.1")) {
				return new ProteinMeal();
			}
			return new VegetarianMeal();
		}

		@Override
		public KitchenMeal getDessert(String preferency) {
			if (preferency.equals("I.1")) {
				return new IceCreamMeal();
			}
			return null;
		}
	}

	// abstract product
	abstract class KitchenMeal {
		public abstract String getName();
	}

	// concrete products
	class ProteinMeal extends KitchenMeal {
		@Override
		public String getName() {
			return "protein meal";
		}
	}

	class VegetarianMeal extends KitchenMeal {
		@Override
		public String getName() {
			return "vegetarian meal";
		}
	}

	class FastFoodMeal extends KitchenMeal {
		@Override
		public String getName() {
			return "fast-food meal";
		}
	}

	class IceCreamMeal extends KitchenMeal {
		@Override
		public String getName() {
			return "ice-cream";
		}
	}
}
