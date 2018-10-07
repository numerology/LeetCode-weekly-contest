/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    // use a queue
    
    private LinkedList<TreeNode> queue;
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        queue = new LinkedList<TreeNode>();
        this.root = root;
        
        LinkedList<TreeNode> bfsQ = new LinkedList<>();
        // dfs
        if (root!=null) {
            bfsQ.offer(root);
        }
        
        while (!bfsQ.isEmpty()) {
            TreeNode cur = bfsQ.poll();
            if (cur.left == null || cur.right == null) {
                queue.offer(cur);
            } 
            
            if (cur.left != null) bfsQ.offer(cur.left);
            
            if (cur.right != null) bfsQ.offer(cur.right);
            
        }
    }
    
    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        assert(!queue.isEmpty());
        
        TreeNode parent = queue.peek();
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            queue.poll();
        }
        
        queue.offer(node);
        return parent.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */