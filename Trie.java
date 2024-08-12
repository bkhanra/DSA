package DSA;


class TrieNode{

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}

public class Trie {

	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
	    // Base case: If the word is fully traversed
	    if (word.length() == 0) {
	        return root.isTerminating;
	    }
	    
	    // Calculate the index of the first character in the word
	    int childIndex = word.charAt(0) - 'a';
	    
	    // Get the corresponding child node
	    TrieNode child = root.children[childIndex];
	    
	    // If the child does not exist, the word is not in the Trie
	    if (child == null) {
	        return false;
	    }
	    
	    // Recursively search in the child node for the rest of the word
	    return search(child, word.substring(1));
	}


	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));

	}

	public void add(String word){
		add(root, word);
	}
}
