class FoodRatings {

    HashMap<String, Integer> foodRating = new HashMap<>();
    HashMap<String, String> foodCuisine = new HashMap<>();
    HashMap<String, TreeMap<Integer, TreeSet<String>>> cuisineRatingMap = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int size = foods.length;
        for(int i = 0; i < size; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            Integer rating = ratings[i];
            foodCuisine.put(food, cuisine);
            foodRating.put(food, rating);
            TreeMap<Integer, TreeSet<String>> cuisineRating;
            if(cuisineRatingMap.containsKey(cuisine)) {
                cuisineRating = cuisineRatingMap.get(cuisine);
            } else {
                cuisineRating = new TreeMap<>();
            }
            TreeSet<String> foodSet;
            if(cuisineRating.containsKey(rating)) {
                foodSet = cuisineRating.get(rating);
            } else {
                foodSet = new TreeSet<>();
            }
            foodSet.add(food);
            cuisineRating.put(rating, foodSet);
            cuisineRatingMap.put(cuisine, cuisineRating);
        }
    }

    public void changeRating(String food, int newRating) {
        int prevFoodRating = foodRating.get(food);
        String cuisine = foodCuisine.get(food);
        TreeMap<Integer, TreeSet<String>> cuisineRating = cuisineRatingMap.get(cuisine);
        TreeSet<String> prevFoodSet = cuisineRating.get(prevFoodRating);
        prevFoodSet.remove(food);
        foodRating.put(food, newRating);
        if(prevFoodSet.isEmpty()) {
            cuisineRating.remove(prevFoodRating);
        }
        TreeSet<String> newFoodSet;
        if(cuisineRating.containsKey(newRating)){
            newFoodSet = cuisineRating.get(newRating);
        } else {
            newFoodSet = new TreeSet<>();
        }
        newFoodSet.add(food);
        cuisineRating.put(newRating, newFoodSet);
    }

    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> cuisineRating = cuisineRatingMap.get(cuisine);
        Integer rating = cuisineRating.lastKey();
        TreeSet<String> foods = cuisineRating.get(rating);
        String food = foods.getFirst();
        System.out.println(food);
        return food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
