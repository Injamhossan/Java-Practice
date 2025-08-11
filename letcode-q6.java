enum MatchResult {
    TRUE, FALSE
}

class Solution {
    private MatchResult[][] cache;

    public boolean isMatch(String s, String p) {
        cache = new MatchResult[s.length() + 1][p.length() + 1];
        return matchHelper(0, 0, s, p);
    }

    private boolean matchHelper(int si, int pi, String s, String p) {
        if (cache[si][pi] != null) {
            return cache[si][pi] == MatchResult.TRUE;
        }

        boolean matched;

        // If we've reached end of pattern, check if string is also fully matched
        if (pi == p.length()) {
            matched = (si == s.length());
        } else {
            // Check if current position matches
            boolean currentMatch = (si < s.length() &&
                    (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '.'));

            // Handle '*' wildcard
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                matched = matchHelper(si, pi + 2, s, p) || (currentMatch && matchHelper(si + 1, pi, s, p));
            } else {
                matched = currentMatch && matchHelper(si + 1, pi + 1, s, p);
            }
        }

        cache[si][pi] = matched ? MatchResult.TRUE : MatchResult.FALSE;
        return matched;
    }
}
