class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // Helper: convert to lowercase
        java.util.function.Function<String, String> toLower = (s) -> s.toLowerCase();

        // Helper: mask vowels
        java.util.function.Function<String, String> maskVowels = (s) -> {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                char lc = Character.toLowerCase(c);
                if ("aeiou".indexOf(lc) >= 0) {
                    sb.append('*');
                } else {
                    sb.append(lc);
                }
            }
            return sb.toString();
        };

        // Exact words
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));

        // First lowercase match
        Map<String, String> caseMap = new HashMap<>();
        for (String w : wordlist) {
            String lw = toLower.apply(w);
            caseMap.putIfAbsent(lw, w);
        }

        // First vowel-masked match
        Map<String, String> vowelMap = new HashMap<>();
        for (String w : wordlist) {
            String mw = maskVowels.apply(w);
            vowelMap.putIfAbsent(mw, w);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
            } else if (caseMap.containsKey(toLower.apply(q))) {
                ans[i] = caseMap.get(toLower.apply(q));
            } else if (vowelMap.containsKey(maskVowels.apply(q))) {
                ans[i] = vowelMap.get(maskVowels.apply(q));
            } else {
                ans[i] = "";
            }
        }
        return ans;
    }
}
