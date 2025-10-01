class Solution {
    /**
     * Calculates the maximum number of water bottles that can be consumed.
     *
     * @param numBottles   The initial number of full water bottles.
     * @param numExchange  The number of empty bottles needed for one full bottle.
     * @return The total number of bottles drunk.
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        
        // Start by drinking all the initial bottles.
        int totalDrunk = numBottles;
        
        // These initial bottles are now empty.
        int emptyBottles = numBottles;
        
        // Loop as long as we can exchange empty bottles for full ones.
        while (emptyBottles >= numExchange) {
            
            // Determine how many new full bottles we can get.
            int newBottles = emptyBottles / numExchange;
            
            // Find the leftover empty bottles after the exchange.
            int leftoverBottles = emptyBottles % numExchange;
            
            // Add the newly acquired bottles to our total count.
            totalDrunk += newBottles;
            
            // Update our count of empty bottles. It consists of the leftovers
            // plus the new bottles we just drank.
            emptyBottles = leftoverBottles + newBottles;
        }
        
        return totalDrunk;
    }
}
