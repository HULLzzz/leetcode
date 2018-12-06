package leetcode150;

import java.util.HashMap;

/**
 * @Auther: Think
 * @Date: 2018/12/6 12:36
 * @Description:
 * get(key)：获取key的对应value，不存在返回-1
 *
 * set(key, value)（lintcode版本）/put(key, value)（leetcode版本）：设置<key, value>
 *
 * 缓存已满，删除最近最久未被使用的节点，添加新节点进缓存
 *
 * 缓存未满，
 *
 * 节点存在，修改value；
 *
 * 节点不存在，添加新节点进缓存；
 *
 * 由于插入和删除的操作频繁，考虑使用双向链表维护节点，思路见https://segmentfault.com/a/1190000009084949
 * “新节点”：凡是被访问（新建/修改命中/访问命中）过的节点，一律在访问完成后移动到双向链表尾部，保证链表尾部始终为最“新”节点；
 *
 * “旧节点”：保证链表头部始终为最“旧”节点，LRU策略删除时表现为删除双向链表头部；
 *
 * 从链表头部到尾部，节点访问热度逐渐递增
 *
 * 由于链表不支持随机访问，使用HashMap+双向链表实现LRU缓存；
 */
public class leetcode146_Lru {
    public class solution{
        private class cacheNode{
            int key,value;
            cacheNode pre,next;
            cacheNode(int key,int value){
                this.key = key;
                this.value = value;
                this.next = null;
                this.next = null;
            }
        }
        private HashMap<Integer,cacheNode> map ;
        private int capacity;
        //head.next 和 tail.next指向链表的头尾
        private cacheNode head = new cacheNode(-1,-1);
        private cacheNode tail = new cacheNode(-1,-1);

        public solution(int capacity){

            this.map = new HashMap<>();
            this.capacity = capacity;
        }

        //将已有节点或者新建节点移动到链表的尾部
        private void move2tail(cacheNode target,boolean isNew){
            if (target != tail.next) {
                if (!isNew) {
                    //修改旧节点的双向链表指针
                    target.pre.next = target.next;
                    target.next.pre = target.pre;
                }
                //添加节点到尾部
                tail.next.next = target;
                target.pre = tail.next;
                tail.next = target;

            }
        }
    }



}
