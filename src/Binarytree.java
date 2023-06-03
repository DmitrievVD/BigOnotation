public class Binarytree {
    private TreeNode head;
    private class TreeNode{
        int value;
        private Color color;
        private TreeNode left;
        private TreeNode right;
    }
    private enum Color{
        RED, BLACK
    }
    public boolean add(int value){
        if (head != null){
            boolean result = addNode(head, value);
            head = rebalance(head);
            head.color = Color.BLACK;
            return result;
        }else{
            head = new TreeNode();
            head.color = Color.BLACK;
            head.value = value;
            return true;
        }
    }
    private boolean addNode(TreeNode node, int value){
        if (node.value == value) return false;
        else{
            if (node.value > value){
                if (node.left != null){
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                }else{
                    node.left = new TreeNode();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            }else{
                if (node.right != null){
                    boolean result = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                }else{
                    node.right = new TreeNode();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    } // Добавление узла
    private TreeNode rebalance(TreeNode node){
        TreeNode result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED
                    && result.left.left != null && result.left.left.color == Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED){
                needRebalance = true;
                colorSwap(result);
            }
        }while (needRebalance);
        return result;
    } // Ребалансировка
    private TreeNode rightSwap(TreeNode node) {
        TreeNode right = node.right;
        TreeNode between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    } // Правосторонний перевод
    private TreeNode leftSwap(TreeNode node){
        TreeNode left = node.left;
        TreeNode between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;

    } // Левосторонний перевод
    private void colorSwap(TreeNode node){
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    } // Смена цвета
    public boolean find(int value){
        TreeNode currentNode = head;
        while (currentNode != null){
            if (currentNode.value == value) return true;
            else if (currentNode.value > value){
                currentNode = currentNode.left;
            }else{
                currentNode = currentNode.right;
            }
        }
        return false;
    }
}
