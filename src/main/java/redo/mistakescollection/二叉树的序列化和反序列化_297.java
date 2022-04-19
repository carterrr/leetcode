package redo.mistakescollection;

import redo.base.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的序列化和反序列化_297 {
    class Codec {
        private static final String NULL = "NULL";
        private static final String SPLITTER = ",";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return NULL;
            return root.val
                    + SPLITTER
                    + serialize(root.left)
                    + SPLITTER
                    + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(SPLITTER)));
            return dfs(queue);
        }

        private TreeNode dfs(Queue<String> queue) {
            String val = queue.poll();
            // Integer 每次赋值或 ++ 引用会被改变 因此不能够 ++ 原因 内部是 final int value;
            if(NULL.equals(val)) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = dfs(queue);
            node.right = dfs(queue);
            return node;
        }
    }
}
