package leetcode.majorityElement;

class MajorityElementInJava {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 7, 3, 3, 2, 2, 2};

        int majorityElement = majorityElement(arr);

        System.out.println(majorityElement);
    }

    static int majorityElement(int[] nums) {
        int majorityElement = 0;
        int count = 0;

        for (int element : nums) {
            if (count == 0) {
                majorityElement = element;
                count = 1;
            }
            else if (element == majorityElement) count++;
            else count--;
        }
        return majorityElement;
    }

}
