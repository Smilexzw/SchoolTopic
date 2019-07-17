package tree;

/**
 * 红黑树是对二叉-搜索数的改进，所以其结点的与二叉搜素数差不多，只是在它的基础上增加了
 * 一个boolean类型的变量来表示节点的颜色
 * @author xuzhangwang
 */
public class RBTree<T extends Comparable<T>> {

    private RBNode<T> root;   // 根节点
    private static final boolean RED = false;  // 定义红黑树的标志
    private static final boolean BLACK = true;

    public class RBNode<T extends Comparable<T>> {
        boolean color;    // 用于表示颜色
        T key;            // 关键字
        RBNode<T> left;   // 左节点
        RBNode<T> right;  // 右节点
        RBNode<T> parent; // 父节点

        // 内部类
        RBNode(T key, boolean color, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
            this.key = key;
            this.color =color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "" + key + (this.color == RED ? "R" : "B");
        }
    }


    public RBTree() {}

    /**
     * 获取父节点
     * @return
     */
    public RBNode<T> parentOf(RBNode<T> node) {
        return node != null ? node.parent : null;
    }

    /**
     * 设置父节点
     * @param node
     * @param parent
     */
    public void serParent(RBNode<T> node, RBNode<T> parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    /**
     * 获取节点的颜色
     * @param node
     * @return
     */
    public boolean colorOf(RBNode<T> node) {
        return node != null ? node.color : BLACK;
    }

    /**
     * 判断节点的颜色
     * @param node
     * @return
     */
    private boolean isRed(RBNode<T> node) {
        return node != null && (node.color == RED);
    }

    private boolean isBlack(RBNode<T> node) {
        return !isRed(node);
    }

    private void setRed(RBNode<T> node) {
        if (node != null) {
            node.color = RED;
        }
    }

    private void setBlack(RBNode<T> node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    private void setColor(RBNode<T> node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }



    /**
     * 对节点x进行左旋
     * 左旋示意图： 对节点x进行左旋
     *             p                              p
     *            /                              /
     *           x                              y
     *          / \                            / \
     *         lx  y    ----------->          x  ry
     *            / \                        / \
     *           ly  ry                     lx  ly
     * @param x
     */
    public void leftRotate(RBNode<T> x) {
        RBNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        // 将x的父节点赋给y的父节点，同时更新p的子节点为y
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent = y;
    }

    /**
     * 如下图所示
     * @param y
     */
    public void rightRomate(RBNode<T> y) {
        // 1、将y的左子树赋给x的右子节点，并将x赋值给y左子节点的父节点（y左子节点非空时）
        RBNode<T> x = y.left;
        y.left =  x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        // 将x的父亲节p（非空）赋给y的父节点，同时更新p的子节点为y（左或右）
        x.parent = y.parent;
        if (y.parent == null) {
            this.root = x;   // 如果x的父亲节点为空，则将y设置为父亲节点
        } else {
            if (y == y.parent.right) {
                y.parent.right = x;
            } else {
                y.parent.left = x;
            }
        }

        // 3、将y的左节点设置为x，将x的父亲节点设置为y
        x.right = y;
        y.parent = x;
    }

    /*************************向红黑数中插入节点***************************/
    public void insert(T key) {
        RBNode<T> node = new RBNode<>(key, RED, null, null, null);
        if (node != null)
            insert(node);
    }


    /* 将节点插入到红黑树中，这个过程与二叉搜索树是一样的 */
    public void insert(RBNode<T> node) {
        RBNode<T> current = null; // 表示最后node的父节点
        RBNode<T> x = this.root;  // 用来向下搜索用的

        while (x != null) {
            current = x;
            int cmp = node.getKey().compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = current; // 找到了位置，将当前的current作为node的父节点

        // 2、接下来恶判断node是插左节点还是右子节点
        if (current != null) {
            int cmp = node.getKey().compareTo(current.key);
            if (cmp < 0) {
                current.left = node;
            } else {
                current.right = node;
            }
        } else {
            this.root = node;
        }

        // 3、将它重新修改为一颗红黑树
        insertFixUp(node);
    }

    /**
     * 遇到以下三种情况，就要开始变色和旋转
     * 1、插入节点的父节点和何其叔叔节点（祖父节点的另一个子节点）均为红色的。
     * 2、插入节点的父节点是红色，叔叔节点是黑色的，且插入的节点是其父节点的右子节点
     * 3、插入节点的父节点是红色，叔叔节点是黑色的，且插入节点是其父节点的左子节点
     * @param node
     */
    private void insertFixUp(RBNode<T> node) {
        RBNode parent, gparent; // 定义父亲节点和祖父节点

        // 父亲节点存在，且父亲节点的颜色是红色
        while ((parent = parentOf(node)) != null && isRed(parent)) {
            gparent = parentOf(parent);  // 获取父亲节点

            // 如果父节点是祖父节点的左子节点
            if (parent == gparent.left) {
                RBNode uncle = gparent.right;
                // case1 如果父节点和叔叔节点都是红色，就变色
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                // case2: 叔叔节点是黑色，并且当前节点是右节点
                if (node == parent.right) {
                    leftRotate(parent);
                    RBNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // 叔叔节点是黑色，并且当前节点是左子节点, 用其祖父节点进行右旋
                setBlack(parent);
                setRed(gparent);
                rightRomate(gparent);
            } else {
                RBNode<T> uncle = gparent.left;
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                // case2如果叔叔节点是黑色的，并且当前节点是左子节点
                if (node == parent.left) {
                    rightRomate(parent);
                    RBNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // 叔叔节点是黑色的，并且当前节点是右子节点
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }

        // 将根节点设置成为黑色
        setBlack(this.root);
    }


}
