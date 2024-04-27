
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;


public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        res.add(list1);

        if (numRows == 1)
            return res;

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        res.add(list2);

        if (numRows == 2)
            return res;

        for (int i = 0; i < numRows - 2; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);

            for (int j = 1; j <= res.get(res.size() - 1).size() - 1; j++) {
                newList.add(list2.get(j - 1) + list2.get(j));
            }

            newList.add(1);
            res.add(newList);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.generate(5);
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}

class C {
    C() {
        System.out.print("C");
    }
}

class A {
    C c = new C();

    A() {
        this("A");
        System.out.print("A");
    }

    A(String s) {
        System.out.print(s);
    }
}

class Test extends A {
    Test() {
        super("B");
        System.out.print("B");
    }

    public static void main(String[] args) {
        System.out.println("is"+ 100 + 5);
        System.out.println(100 + 5 +"is");
        System.out.println("is"+ (100 + 5));
    }
}