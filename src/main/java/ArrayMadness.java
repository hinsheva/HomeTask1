public class ArrayMadness {
  
    public static void main(String[] args) {
        oddArray();
        swapMaxMinArrayValues();
        calcArrayAverageValue();
        randomArray();
        findScannerLongestString();
        findScannerUniqueValues();
    }

    private static Integer[] oddArray() {
        Integer[] oddArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.println(Arrays.asList(oddArray));
        return oddArray;
    }

    private static Integer[] swapMaxMinArrayValues() {
        Integer[] intArray = {3, -7, 0, 6, 9};
        int max = Collections.max(Arrays.asList(intArray));
        int min = Collections.min(Arrays.asList(intArray));
        System.out.println("origin array: " + Arrays.asList(intArray)); //for debug only
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == max) {
                intArray[i] = min;
            } else if (intArray[i] == min) {
                intArray[i] = max;
            }
        }
        System.out.println("swapped array: " + Arrays.asList(intArray));  //for debug only
        return intArray;
    }

    private static double calcArrayAverageValue() {
        Integer[] intArray = {3, -7, 0, 6, 9};
        double sum = 0;
        for (int value : intArray) {
            sum += value;
        }

        double average = sum / intArray.length;
        System.out.println("array average value: " + average); //for debug only
        return average;
    }

    private static Integer[] randomArray() {
        int start = -1;
        int middle = 0;
        int end = 1;
        int countStartValue = 0;
        int countMiddleValue = 0;
        int countEndValue = 0;
        Integer[] random = new Integer[13];
        for (int i = 0; i < random.length; i++) {
            random[i] = ThreadLocalRandom.current().nextInt(start, end);
            if (random[i] == start)
                countStartValue++;
            if (random[i] == middle)
                countMiddleValue++;
            if (random[i] == start)
                countEndValue++;
        }

        List<Integer> countValues = new ArrayList<>();
        countValues.add(countStartValue);
        countValues.add(countMiddleValue);
        countValues.add(countEndValue);

        int countOfMostCommonArrayValue = Collections.max(countValues);
        int commonArrayValue = Arrays.asList(random).indexOf(countOfMostCommonArrayValue);

        System.out.println("random array: " + Arrays.asList(random)); //for debug only
        System.out.println("most common array value: " + commonArrayValue + " that occurs " + countOfMostCommonArrayValue
                + " times within this random array"); //for debug only
        return random;
    }

    private static String findScannerLongestString() {
        Map<Integer, String> stringsLength = new HashMap<>();
        System.out.println("Enter any 5 strings...");
        Scanner scanner = new Scanner(System.in);
        int countLine = 0;
        while (countLine <= 5) {
            String input = scanner.nextLine();
            stringsLength.put(input.length(), input);
            countLine++;
        }

        List<Integer> length = new ArrayList<>();
        length.addAll(stringsLength.keySet());

        int longestStringSize = Collections.max(length);
        String longestString = stringsLength.get(longestStringSize);
        System.out.println('\n' + "the longest string among user input: " + longestString); //for debug only

        return longestString;
    }

    private static String findScannerUniqueValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter more then 3 integers, separated by a comma...");

        String input = scanner.nextLine();
        List<String> inputValuesList = Stream.of(input.split(",")).collect(Collectors.toList());

        while (inputValuesList.size() <= 3) {
            System.out.println("Not enough integers entered. Please provide more to have totally more than 3 integers per input....");
            input = scanner.nextLine();
            inputValuesList = Stream.of(input.split(",")).collect(Collectors.toList());
        }
        Set<String> inputValuesSet = new HashSet<>(inputValuesList);
        String uniqueValues = inputValuesSet.toString();
        System.out.println("unique values from the input: " + uniqueValues); //for debug only

        return uniqueValues;
    }
}
