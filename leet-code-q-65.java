class Solution {
    public int smallestNumber(int n) {
        // Find the position of the most significant bit
        // Integer.numberOfLeadingZeros counts leading zeros in 32-bit representation
        int msb = 31 - Integer.numberOfLeadingZeros(n);
        
        // Create a number with (msb+1) bits all set to 1
        int result = (1 << (msb + 1)) - 1;
        
        return result;
    }
}
