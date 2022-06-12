class Trie {
    Trie[] root;
    boolean isLeaf = false;
    public Trie() {
        root = new Trie[26]; 
    }
    
    public void insert(String word) {
        Trie cur = this;
        for(int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            Trie t = cur.root[c];
            if(t == null) {
                t = new Trie();
                cur.root[c] = t;
            }
            cur = t;
        }
        cur.isLeaf = true;
    }
    
    public boolean search(String word) {
        Trie cur = this;
        for(int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            Trie t = cur.root[c];
            if(t == null) return false;
            cur = t;
        }
        return cur.isLeaf;
    }
    
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for(int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            Trie t = cur.root[c];
            if(t == null) return false;
            cur = t;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */