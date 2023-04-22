package multithreading;

import java.util.*;

/**
 * @author donald
 * @date 2023/4/22
 */
public class MapToList {

    /**
     * 1 2
     * 3 4 5
     * 6
     * -->
     * 1 3 6 2 4 5
     */
    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<List<Integer>>() {
            {
                add(buildList(1, 2));
                add(buildList(3, 4, 5));
                add(buildList(6));
            }
        };
        System.out.println(list);

        System.out.println(mapToList(list));
    }

    private static List<Integer> buildList(int...ints) {
        if (null == ints || ints.length == 0) {

            return Collections.emptyList();
        }
        List<Integer> list = new LinkedList<>();
        for (int i : ints) {
            list.add(i);
        }

        return list;
    }

    /**
     * map输出list
     * Tips：按每个node顺序输出
     *
     * @param list 原数据
     * @return 列表
     */
    private static List<Integer> mapToList(List<List<Integer>> list) {
        if (null == list || list.isEmpty()) {

            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; !list.isEmpty(); ) {

            int idx = i % list.size();
            List<Integer> targetList = list.get(idx);
            Integer num = targetList.get(0);
            result.add(num);
            targetList.remove(0);
            if (targetList.isEmpty()) {
                list.remove(idx);
                continue;
            }
            ++i;
        }

        return result;
    }
}
