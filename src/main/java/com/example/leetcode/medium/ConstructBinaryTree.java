package com.example.leetcode.medium;

import java.util.Arrays;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    [-77,24,-74,84,93,28,83,6,95,58,59,66,22,-3,-66,-68,-22,3,-80,-79,-85,17,32,9,-88,-99,14,-60,13,-93,-63,91,82,21,26,-11,-32,-16,-100,-94,-31,-62,-89,49,-9,-8,87,-33,-81,80,0,69,-7,52,67,-5,-65,31,-30,37,-57,27,23,38,-28,7,-82,-42,11,-55,-36,-58,-24,89,56,73,41,18,-87,-70,4,-64,20,-52,-39,79,19,30,65,25,-71,-76,-1,62,-69,98,39,-25,-73,70,88,-17,-20,-75,55,34,57,81,-10,94,48,-35,5,-23,-44,40,-51,-61,-13,-86,63,71,-97,45,43,51,75,33,-34,92,47,-78,85,-26,97,-29,-92,-83,-59,74,96,68,77,16,-4,10,60,64,-21,-2,1,-91,86,46,76,-37,-19,-96,36,-98,29,-72,61,50,15,-95,-40,-43,-53,90,-15,-48,-27,-90,-54,72,-50,-49,-18,78,54,35,-38,99,44,-67,53,-12,-41,2,8,-14,-84,-56,-6,12,-45,42,-47,-46]
 * [93,28,84,83,-74,59,58,66,-66,-3,-79,-80,3,-22,-68,22,-85,-99,14,-88,9,32,17,-60,95,-93,82,21,91,-63,26,13,-16,-32,-11,-100,6,-62,49,-89,-31,87,-8,69,0,80,-7,-81,-65,-5,67,-30,31,52,-33,37,-57,-9,7,-28,-42,-82,38,-55,11,23,-36,27,56,89,73,-24,41,-58,-70,-87,20,-64,-52,4,18,-94,19,30,-76,-1,-71,62,-69,25,-73,-25,70,39,88,98,-20,-17,65,55,-75,79,34,-39,48,94,-23,5,-44,-35,40,-10,-61,-51,-13,81,63,-97,71,-86,57,45,24,-34,85,97,-26,-78,-83,-92,74,-59,96,-29,68,47,77,92,10,-4,16,60,33,-21,1,86,76,46,-37,-91,-2,64,75,51,-19,-96,43,-98,29,61,-72,50,36,-95,-40,-43,15,90,-15,-53,-77,-54,-90,-49,-50,72,-27,35,54,-38,78,-67,44,53,99,-41,-12,-18,8,2,-48,-56,-84,-14,-45,12,42,-6,-46,-47]
 * Output:
 * [-77,24,-48,-74,43,-27,null,84,6,51,36,-90,-18,93,83,95,-94,75,-19,-98,15,-54,72,78,2,null,28,null,null,58,13,-31,-39,33,null,null,-96,null,29,-95,-53,null,null,-50,null,54,99,8,null,null,null,59,66,-93,-11,-62,-9,79,57,-34,null,null,null,null,-72,null,-40,90,null,-49,null,35,-38,44,-12,null,null,null,null,null,22,null,-63,-32,-100,null,-89,-8,27,19,34,81,45,null,92,61,50,null,-43,null,-15,null,null,null,null,null,null,-67,53,-41,null,-3,-85,91,26,-16,null,null,null,49,null,87,-33,null,-58,null,30,null,null,-10,-86,null,null,47,16,null,null,null,null,null,null,null,null,null,null,null,null,null,null,-66,-68,null,17,82,null,null,null,null,null,null,null,null,null,-81,37,-24,18,null,65,94,-51,63,null,-78,77,-4,60,null,null,-22,null,32,-60,null,21,80,52,null,-57,89,41,-87,null,25,-75,48,-35,-61,-13,null,71,85,-29,null,null,10,null,null,null,3,null,9,null,null,null,null,null,0,-7,67,null,null,null,56,73,null,null,-70,4,-71,98,55,null,null,null,5,40,null,null,null,null,-97,null,null,-26,-92,68,null,null,-80,null,-88,null,69,null,null,null,-5,31,null,null,null,null,null,null,-64,null,-76,62,39,-17,null,null,-23,-44,null,null,null,null,97,null,-83,-59,null,null,-79,null,-99,null,null,null,-65,null,-30,null,20,-52,null,-1,null,-69,-25,88,-20,null,null,null,null,null,null,null,null,null,74,96,null,null,null,14,null,null,null,null,null,null,null,null,null,null,null,null,-73,70]
 * Expected:
 * [-77,24,-48,-74,43,-27,-14,84,6,51,36,-90,-18,-84,-6,93,83,95,-94,75,-19,-98,15,-54,72,78,2,-56,null,12,-47,null,28,null,null,58,13,-31,-39,33,null,null,-96,null,29,-95,-53,null,null,-50,null,54,99,8,null,null,null,-45,42,-46,null,null,null,59,66,-93,-11,-62,-9,79,57,-34,64,null,null,null,-72,null,-40,90,null,-49,null,35,-38,44,-12,null,null,null,null,null,null,null,null,null,null,null,22,null,-63,-32,-100,null,-89,-8,27,19,34,81,45,null,92,-21,null,61,50,null,-43,null,-15,null,null,null,null,null,null,-67,53,-41,null,-3,-85,91,26,-16,null,null,null,49,null,87,-33,23,-58,null,30,null,null,-10,-86,null,null,47,16,null,-2,null,null,null,null,null,null,null,null,null,null,null,null,null,null,-66,-68,null,17,82,null,null,null,null,null,null,null,null,null,-81,37,38,-36,-24,18,null,65,94,-51,63,null,-78,77,-4,60,1,null,null,null,-22,null,32,-60,null,21,80,52,null,-57,-28,11,null,null,89,41,-87,null,25,-75,48,-35,-61,-13,null,71,85,-29,null,null,10,null,null,null,null,-91,3,null,9,null,null,null,null,null,0,-7,67,null,null,null,7,-82,-55,null,56,73,null,null,-70,4,-71,98,55,null,null,null,5,40,null,null,null,null,-97,null,null,-26,-92,68,null,null,86,null,-80,null,-88,null,69,null,null,null,-5,31,null,null,-42,null,null,null,null,null,null,null,null,null,-64,null,-76,62,39,-17,null,null,-23,-44,null,null,null,null,97,null,-83,-59,null,null,null,46,-79,null,-99,null,null,null,-65,null,-30,null,null,null,20,-52,null,-1,null,-69,-25,88,-20,null,null,null,null,null,null,null,null,null,74,96,76,-37,null,null,null,14,null,null,null,null,null,null,null,null,null,null,null,null,-73,70]
 *
 **/
public class ConstructBinaryTree {
    public static void main(String[] args) {
        int[] preorder = new int[]{-77,24,-74,84,93,28,83,6,95,58,59,66,22,-3,-66,-68,-22,3,-80,-79,-85,17,32,9,-88,-99,14,-60,13,-93,-63,91,82,21,26,-11,-32,-16,-100,-94,-31,-62,-89,49,-9,-8,87,-33,-81,80,0,69,-7,52,67,-5,-65,31,-30,37,-57,27,23,38,-28,7,-82,-42,11,-55,-36,-58,-24,89,56,73,41,18,-87,-70,4,-64,20,-52,-39,79,19,30,65,25,-71,-76,-1,62,-69,98,39,-25,-73,70,88,-17,-20,-75,55,34,57,81,-10,94,48,-35,5,-23,-44,40,-51,-61,-13,-86,63,71,-97,45,43,51,75,33,-34,92,47,-78,85,-26,97,-29,-92,-83,-59,74,96,68,77,16,-4,10,60,64,-21,-2,1,-91,86,46,76,-37,-19,-96,36,-98,29,-72,61,50,15,-95,-40,-43,-53,90,-15,-48,-27,-90,-54,72,-50,-49,-18,78,54,35,-38,99,44,-67,53,-12,-41,2,8,-14,-84,-56,-6,12,-45,42,-47,-46};
        int[] inorder = new int[]{93,28,84,83,-74,59,58,66,-66,-3,-79,-80,3,-22,-68,22,-85,-99,14,-88,9,32,17,-60,95,-93,82,21,91,-63,26,13,-16,-32,-11,-100,6,-62,49,-89,-31,87,-8,69,0,80,-7,-81,-65,-5,67,-30,31,52,-33,37,-57,-9,7,-28,-42,-82,38,-55,11,23,-36,27,56,89,73,-24,41,-58,-70,-87,20,-64,-52,4,18,-94,19,30,-76,-1,-71,62,-69,25,-73,-25,70,39,88,98,-20,-17,65,55,-75,79,34,-39,48,94,-23,5,-44,-35,40,-10,-61,-51,-13,81,63,-97,71,-86,57,45,24,-34,85,97,-26,-78,-83,-92,74,-59,96,-29,68,47,77,92,10,-4,16,60,33,-21,1,86,76,46,-37,-91,-2,64,75,51,-19,-96,43,-98,29,61,-72,50,36,-95,-40,-43,15,90,-15,-53,-77,-54,-90,-49,-50,72,-27,35,54,-38,78,-67,44,53,99,-41,-12,-18,8,2,-48,-56,-84,-14,-45,12,42,-6,-46,-47};
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        TreeNode treeNode = constructBinaryTree.buildTree(preorder,inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        int value = preorder[0];
        TreeNode treeNode = new TreeNode(value);
        int index = 0;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] != value)
                index++;
            else
                break;

        }

        if(index>0)
            treeNode.left = buildTree(Arrays.copyOfRange(preorder,1,index + 1),Arrays.copyOfRange(inorder,0,index));
        if(preorder.length > 1)
            treeNode.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index + 1,inorder.length));
        return treeNode;
    }


    /**
     * faster solution
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeV2(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, new int[]{0, 0}, Integer.MAX_VALUE);
    }

    TreeNode helper(int[] preorder, int[] inorder, int[] indices, int limit) {
        if (indices[0] == preorder.length || indices[1] == inorder.length) return null;
        if (inorder[indices[1]] == limit) {
            indices[1]++;
            return null;
        }
        TreeNode r = new TreeNode(preorder[indices[0]++]);
        r.left = helper(preorder, inorder, indices, r.val);
        r.right = helper(preorder, inorder, indices, limit);
        return r;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public TreeNode createTree (char[] treeArr) {
        TreeNode[] tree = new TreeNode[treeArr.length];
        for (int i = 0; i < treeArr.length; i++) {
            if (treeArr[i] == '#') {
                tree[i] = null;
                continue;
            }
            tree[i] = new TreeNode(treeArr[i]-'0');
        }
        int pos = 0;
        for (int i = 0; i < treeArr.length && pos < treeArr.length-1; i++) {
            if (tree[i] != null) {
                tree[i].left = tree[++pos];
                if (pos < treeArr.length-1) {
                    tree[i].right = tree[++pos];
                }
            }
        }
        return tree[0];
    }
}
