class Solution {
     class TrieNode{
        Map <Character,TrieNode> map = new HashMap<>();
        boolean isWord =false;

    }
    TrieNode trie =new TrieNode();
    List<String> result =new LinkedList<>();
    int m,n;
    char [][] board;
    boolean [][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words)
            insertWord(word); //insert a word into the trie O(W * L)

        //apply DFS to each character in the trie    O(m * n * 4^L)
        m = board.length; // rows
        n = board[0].length; //columns
        this.board = board;
        visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++){
                char c = board[row][col];
                dfs (row ,col, new StringBuilder(), trie);
            }
        }
        return result;

    }
    private void insertWord(String word){
        char []arr = word.toCharArray();
        TrieNode curr = trie;
        for (char c : arr)
        {
            if (!curr.map.containsKey(c))
                curr.map.put(c,new TrieNode());
            curr = curr.map.get(c);
        }
        curr.isWord = true;
    }
    private void dfs (int row, int col, StringBuilder sb, TrieNode curr){
        if (row < 0 || row == m || col < 0 || col == n) return;

        if (visited[row][col]) return;
        char c = board[row][col];
        if (!curr.map.containsKey(c)) return;
        sb.append(c);
        curr = curr.map.get(c);
        visited[row][col] = true;
        if (curr.isWord){
            result.add(sb.toString());
            curr.isWord = false;// avoid duplicates
        }
        dfs (row , col+1, sb, curr); //right
        dfs (row+1, col, sb, curr); //down
        dfs (row-1, col, sb, curr); //up
        dfs (row, col-1, sb, curr); //left

        //backtrack
        sb.setLength(sb.length()-1);
        visited [row][col] = false;
    }
    }
