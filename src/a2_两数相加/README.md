## 题目描述

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

## 解决方案

方法：初等数学
思路

我们使用变量来跟踪进位，并从包含最低有效位的表头开始模拟逐位相加的过程。

![](https://ws2.sinaimg.cn/large/006tNbRwly1fynyt4phc7j30e9056dgc.jpg)

伪代码如下：

- 将当前结点初始化为返回列表的哑结点。
- 将进位 carry 初始化为 00。
- 将 p 和 q 分别初始化为列表 l1 和 l2 的头部。
- 遍历列表 l1 和 l2 直至到达它们的尾端。
  - 将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
  - 将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
  - 设定 sum = x + y + carry。
  - 更新进位的值，carry = sum / 10。
  - 创建一个数值为 (sum mod10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
  - 同时，将 p 和 qq前进到下一个结点。
- 检查 carry = 1 是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
- 返回哑结点的下一个结点。

请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。

请特别注意以下情况：

<!--more-->

| 测试用例             | 说明                                               |
| -------------------- | -------------------------------------------------- |
| l1=[0,1]  l2=[0,1,2] | 当一个列表比另一个列表长时。                       |
| l1=[]  l2=[0,1]      | 当一个列表为空时，即出现空列表。                   |
| l1=[9,9]  l2=[1]     | 求和运算最后可能出现额外的进位，这一点很容易被遗忘 |

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
```

**我的解法**

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    int sum = 0;
    ListNode cur = dummy;
    ListNode p1 = l1; ListNode p2 = l2;
    while (p1 != null || p2!=null) {
        if (p1 != null) {
            sum += p1.val;
            p1 = p1.next;
        }
        if (p2 != null) {
            sum += p2.val;
            p2 = p2.next;
        }
        cur.next = new ListNode(sum % 10);
        sum /= 10;
        cur =  cur.next;
    }
    if (sum == 1) {
        cur.next = new ListNode(1);
    }
    return dummy.next;
}
```

**复杂度分析**

- 时间复杂度：O(max(m, n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m, n)次。
- 空间复杂度：O(max(m, n))， 新列表的长度最多为 max(m,n) + 1。

**拓展**

如果链表中的数字不是按逆序存储的呢？例如：

(3→4→2)+(4→6→5)=8→0→7