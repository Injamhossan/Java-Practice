class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from Pacific (top & left) and Atlantic (bottom & right) borders
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);      
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]); 
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);      
            dfs(heights, atlantic, m - 1, j, heights[m - 1][j]); 
        }

        // Collect cells reachable by both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Base cases
        if (r < 0 || r >= m || c < 0 || c >= n) return;
        if (visited[r][c]) return;
        if (heights[r][c] < prevHeight) return;

        visited[r][c] = true;

        // Explore in 4 directions
        dfs(heights, visited, r + 1, c, heights[r][c]);
        dfs(heights, visited, r - 1, c, heights[r][c]);
        dfs(heights, visited, r, c + 1, heights[r][c]);
        dfs(heights, visited, r, c - 1, heights[r][c]);
    }
}
