package com.liu.linkedlist.medium;

import com.liu.linkedlist.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 17-6-25.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode headNew = new RandomListNode(0);
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode p1 = head, p2 = headNew;
        while (p1!=null){
            p2.next = new RandomListNode(p1.label);
            p2 = p2.next;
            map.put(p1,p2);
            p1=p1.next;
        }
        p1 = head; p2 = headNew.next;
        while(p1!=null){
            p2.random = map.get(p1.random);
            p1=p1.next;
            p2=p2.next;
        }
        return headNew.next;
    }

    /**
     * 将copy的节点放在相应节点后面构成 1-（1）-2-（2）-3-（3）.。。
     * 然后构造random collection，，
     * 最后删除原节点
     * @param head
     * @return
     */
    public RandomListNode copyRandomList02(RandomListNode head) {
        RandomListNode ptr, next;
        RandomListNode dummy = new RandomListNode(0);

        ptr=head;
        while (ptr != null)
        {
            next = ptr.next;

            RandomListNode copy = new RandomListNode(ptr.label);
            ptr.next = copy;
            copy.next = next;
            ptr = next;
        }

        ptr=head;
        while (ptr != null)
        {
            next = ptr.next.next;
            if (ptr.random != null)
            {
                ptr.next.random = ptr.random.next;
            }
            ptr = next;
        }

        ptr=head;
        RandomListNode copy, copyPtr = dummy;
        while (ptr != null)
        {
            next = ptr.next.next;

            copy = ptr.next;
            copyPtr.next = copy;
            copyPtr = copyPtr.next;

            ptr.next = next; // extract the "copied" node out

            ptr = next;
        }

        return dummy.next;
    }
}
