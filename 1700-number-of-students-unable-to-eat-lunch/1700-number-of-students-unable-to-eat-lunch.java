import java.util.LinkedList;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
        test1();
    }

    private void test0() {
        final int[] students = {1, 1, 0, 0};
        final int[] sandwiches = {0, 1, 0, 1};
        final var result = countStudents(students, sandwiches);
        System.out.println("ожидаемый   ответ - " + "0");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final int[] students = {1,1,1,0,0,1};
        final int[] sandwiches = {1,0,0,0,1,1};
        final var result = countStudents(students, sandwiches);
        System.out.println("ожидаемый   ответ - " + "3");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    /*
    Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
Output: 3
     */
    public int countStudents(int[] students, int[] sandwiches) {
        var result = 0;
        final var listStudents = getLinkedList(students);
        final var listSandwiches = getLinkedList(sandwiches);
        var  oldSizeQueue=listStudents.size();

        while (oldSizeQueue != 0) {
            for (int i = 0; i < listSandwiches.size(); i++) {
                if (listSandwiches.get(0)==listStudents.get(0)){
                    listStudents.remove(0);
                    listSandwiches.remove(0);
                }else{
                    int student = listStudents.remove(0);
                    listStudents.add(student);                }
            }
            if (oldSizeQueue==listStudents.size()){
                break;
            }
            oldSizeQueue=listStudents.size();
        }

        return listStudents.size();
    }

    private LinkedList<Integer> getLinkedList(int[] arr) {
        final var result = new LinkedList<Integer>();
        for (var student : arr) {
            result.add(student);
        }
        return result;
    }
}