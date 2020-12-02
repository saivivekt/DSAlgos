package com.craneware.testing;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.io.Resources;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class Snippets {
    private static final Character LEADING_ZERO = '0';
    private static final int UNDETERMINED = 3;
    private static final int INPATIENT = 1;
    private static final int OUTPATIENT = 2;
    private static final int ZERO_PADDED_REVENUECODE_LENGTH = 4;

    private static final String HYPHEN = "-";
    private static final int FIRST_NDC_PART_LENGTH = 5;
    private static final int SECOND_NDC_PART_LENGTH = 4;
    private static final int THIRD_NDC_PART_LENGTH = 2;
    private static final int NDCCODELENGTH = 11;
    private static final int NDCCODEWITHCHARSUFFIXLENGTH = 12;

    private static final String NDC_THIRD_PART_REGULAREXPRESSION = "^[0-9]*";

    public static void main(String[] args) {
        //int[] nums = {0,0,1,1,1,2,2,3,3,4};
        //System.out.println(removeDuplicates(nums));
        String[] thisIs = new String[1];

        //getPairsCount(5,6);

        int[] num = {17,18,5,4 ,6,1};
        int[] nums = {5,4,3,0,1};
        int[] nums1 = {-7,-3,2,3,11};

        System.out.println(containsLetter(new String("767Ab-f989-22f"), true));
        System.out.println(containsLetter(new String("767-989-22f"), true));
        System.out.println(containsLetter(new String("767-989-22"), false));

        num = replaceElements(num);
       // System.out.println(replaceElements(num));
        for (int i:
             num) {
            System.out.println(i);

        }
        moveZeroes(nums);

        sortedSquares(nums1);

        int[] A = {1,0,3};
        sortArrayByParity(A);
    }

    private static boolean containsLetter( String ndcCode, final boolean isNdcCodeEndsWithCharacter) {
        if (isNdcCodeEndsWithCharacter) {
            ndcCode = ndcCode.substring(0,ndcCode.length()-1);
        }
        return ndcCode.chars().anyMatch(Character::isAlphabetic);
    }

    public static int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = 0, j= A.length-1;

        for(int k=A.length-1 ; k>=0; k--){
            if(Math.abs(A[i]) > Math.abs(A[j])){
                res[k] = A[i] * A[i];
                i++;
            }
            else if(Math.abs(A[i]) < Math.abs(A[j])){
                res[k] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }


    public static int[] replaceElements(int[] arr) {
        int max = -1, temp, len = arr.length;
        for (int i=len-1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = max;
            if( max < temp)
                max = temp;
        }
        return arr;
    }

    public static int[] sortArrayByParity(int[] A) {
        int current = 0;
        int j = A.length-1;
        while(current < j){

            if(A[current]%2!=0 && A[j]%2==0){
                int temp= A[current];
                A[current] = A[j];
                A[j] = temp;


            }

            if(A[current]%2 == 0)current ++;
            if(A[j]%2 != 0)j --;
        }

        return A;
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for(int j=0; j<nums.length; j++){
            if(nums[j]!=0){
                int temp = nums[i];
                nums[i]= nums[j];
                nums[j] = temp;

                i++;
            }
        }
    }

    private static boolean validMountainArray(int[] A) {
        int peak = 0;

        for (int i=0; i+1<A.length; i++){
            if(A[i] < A[i+1]){
                peak = i+1;
            }
            else if(A[i] > A[i+1]){
                break;
            }
            else return false;
        }

        if(peak == 0 || peak == A.length-1)
            return false;

        for(int i= peak; i+1<A.length; i++){
            if(A[i] <= A[i+1])
                return false;
        }

        if(peak == A.length-1)
            return false;

        return true;
    }

    private static boolean checkHalves(int[] arr){
        Set<Integer> hs= new HashSet<>();

        for(int i=0; i<arr.length; i++){
            hs.add(arr[i]);
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i]%2 == 0 && hs.contains(arr[i]*2)){
                return true;
            }
        }

        return false;

    }

    private static String getNdcCodeWithoutCharacters(String ndccode) {
        Pattern pattern = Pattern.compile(NDC_THIRD_PART_REGULAREXPRESSION);
        Matcher matcher = pattern.matcher(ndccode);
        String result = null;
        while (matcher.find()) {
            result = matcher.group(0);
        }
        return result;
    }

    public static String ndccode (String ndcCode){
        List<String> ndcPartsList = new ArrayList<>();
        boolean isNdcCodeEndsWithCharacter = false;
        char ndcLastCharacter;

        ndcLastCharacter = ndcCode.charAt(ndcCode.length()-1);
        if(Character.isAlphabetic(ndcLastCharacter)){
            isNdcCodeEndsWithCharacter = true;
        }

        if((ndcCode.contains(HYPHEN) && ndcCode.length() > 14) || (!ndcCode.contains(HYPHEN) && ndcCode.length() > 12)){
            return null;
        }
        else if(ndcCode.contains(HYPHEN)){
            ndcPartsList = Stream.of(ndcCode.split(HYPHEN))
                           .collect(Collectors.toList());
            if(isNdcCodeEndsWithCharacter){
                ndcPartsList.set(2, getNdcCodeWithoutCharacters(ndcPartsList.get(ndcPartsList.size()-1)));
            }
        }
        else if(!ndcCode.contains(HYPHEN) && isNdcCodeEndsWithCharacter){
            ndcCode = getZeroPaddedString(NDCCODEWITHCHARSUFFIXLENGTH, ndcCode);
            ndcPartsList.add(ndcCode.substring(0,5));
            ndcPartsList.add(ndcCode.substring(5,9));
            ndcPartsList.add(getNdcCodeWithoutCharacters(ndcCode.substring(9,12)));
        }
        else if(!ndcCode.contains(HYPHEN) && !isNdcCodeEndsWithCharacter){
            ndcCode = getZeroPaddedString(NDCCODELENGTH, ndcCode);
            ndcPartsList.add( ndcCode.substring(0,5));
            ndcPartsList.add( ndcCode.substring(5,9));
            ndcPartsList.add( ndcCode.substring(9,11));
        }

        String finalNdcCode = generateNdcCodeFromNdcParts(ndcPartsList, isNdcCodeEndsWithCharacter, ndcLastCharacter);

        return finalNdcCode;
    }

    private static String generateNdcCodeFromNdcParts(List<String> ndcPartsList, boolean isNdcCodeEndsWithCharacter, char ndcLastCharacter) {
        StringBuilder finalNdcCode = new StringBuilder();
        if(ndcPartsList.get(0).length() < FIRST_NDC_PART_LENGTH){
            finalNdcCode.append(getZeroPaddedString(FIRST_NDC_PART_LENGTH, ndcPartsList.get(0)));
        }
        else{
            finalNdcCode.append(ndcPartsList.get(0));
        }
        finalNdcCode.append(HYPHEN);
        if(ndcPartsList.get(1).length() < SECOND_NDC_PART_LENGTH){
            finalNdcCode.append(getZeroPaddedString(SECOND_NDC_PART_LENGTH, ndcPartsList.get(1)));
        }
        else{
            finalNdcCode.append(ndcPartsList.get(1));
        }
        finalNdcCode.append(HYPHEN);
        if(ndcPartsList.get(2).length() < THIRD_NDC_PART_LENGTH){
            finalNdcCode.append(getZeroPaddedString(THIRD_NDC_PART_LENGTH, ndcPartsList.get(2)));
        }
        else{
            finalNdcCode.append(ndcPartsList.get(2));
        }
        if(isNdcCodeEndsWithCharacter){
            finalNdcCode.append(ndcLastCharacter);
        }
        return finalNdcCode.toString();
    }

    private static String getZeroPaddedString(int firstNdcPartLength, String s) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < firstNdcPartLength - s.length()) {
            sb.append('0');
        }
        sb.append(s);
        return sb.toString();
    }


    public static int removeDuplicates(int[] nums) {
        System.out.println(nums);
        nums = Arrays.stream(nums).distinct().toArray();
        System.out.println(nums);
        System.out.println();
        return nums.length;
    }

    private static String leftZeroPaddedRevenueCode(String revenueCode) {
        if (revenueCode.length()< ZERO_PADDED_REVENUECODE_LENGTH)
        {
            return getZeroPaddedString(ZERO_PADDED_REVENUECODE_LENGTH, revenueCode);
        }
        return revenueCode;
    }
    private static void patientTypeLogic() {
        System.out.println(LocalDateTime.now(ZoneOffset.UTC).minusYears(3));
        System.out.println(LocalDateTime.now(ZoneOffset.UTC));
        System.out.println(mapPatientTypeBySecondaryLogic("013"));
        System.out.println( mapPatientTypeBySecondaryLogic("01000"));
        System.out.println(mapPatientTypeBySecondaryLogic("01asdf"));
        System.out.println(mapPatientTypeBySecondaryLogic("...."));
        System.out.println(mapPatientTypeBySecondaryLogic("...."));
        System.out.println(mapPatientTypeBySecondaryLogic("00000"));
        System.out.println(mapPatientTypeBySecondaryLogic("1"));
        System.out.println(mapPatientTypeBySecondaryLogic("1122"));
        System.out.println(mapPatientTypeBySecondaryLogic("aaaaaa1122"));

        System.out.println("01---------" + mapPatientTypeBySecondaryLogic("01"));
        System.out.println("001---------" + mapPatientTypeBySecondaryLogic("001"));
        System.out.println("010---------" + mapPatientTypeBySecondaryLogic("010"));
        System.out.println("0av---------" + mapPatientTypeBySecondaryLogic("0av"));
        System.out.println("0123---------" + mapPatientTypeBySecondaryLogic("0123"));
        System.out.println("01---------" + mapPatientTypeBySecondaryLogic("01"));
        System.out.println("10---------" + mapPatientTypeBySecondaryLogic("10"));
        System.out.println("av---------" + mapPatientTypeBySecondaryLogic("av"));
        System.out.println("0---------" + mapPatientTypeBySecondaryLogic("01"));
        System.out.println("1---------" + mapPatientTypeBySecondaryLogic("10"));
        System.out.println("a---------" + mapPatientTypeBySecondaryLogic("av"));
    }

    private static void dateConverter() {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(1589897516643l), ZoneOffset.UTC);
        Date date = java.sql.Timestamp.valueOf(localDateTime);

        LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);

        LocalDateTime.parse("2015-02-20T06:30:00");

        LocalDateTime todayDatesystem = LocalDateTime.now(ZoneId.systemDefault());
        LocalDateTime todayDatesystem1 = LocalDateTime.now(ZoneId.of("Asia/Singapore"));

        System.out.println("system date" + " " + todayDatesystem);
        System.out.println("Asia date" + " " + todayDatesystem1);
        System.out.println("date" + " " + date);

        LocalDateTime yesterdayDateUTC = LocalDateTime.now(ZoneOffset.UTC).minusDays(1);
        long yesterdayMilliSeconds = yesterdayDateUTC.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();

        LocalDateTime threeYearsDateUTC = LocalDateTime.now(ZoneOffset.UTC).minusYears(3);
        long threeYearsMilliSeconds = threeYearsDateUTC.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();

        System.out.println();
        System.out.println("UTC date" + " " + yesterdayDateUTC);
        System.out.println("yesterdat sec" + " " + yesterdayMilliSeconds);
        System.out.println();
        System.out.println("3 years UTC date" + " " + threeYearsDateUTC);
        System.out.println("3 years sec" + " " + threeYearsMilliSeconds);
        String str = "blalba";
        String s1 = "hello";
        String s2 = "how";
        System.out.println(Long.valueOf("A0123.9832L"));
        System.out.println(String.format("%s: Failed to save %s. Exception: ",
                str,
                s1,
                s2));
    }

    public static String getDate(long milliSeconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    private static Integer mapPatientTypeBySecondaryLogic(String facilityTypeCode) {
        Character firstCharacter, secondCharacter;

        facilityTypeCode = getFacilityTypeCodeWithOutLeadingZero(facilityTypeCode);

        if (facilityTypeCode == null) {
            return null;
        } else if (facilityTypeCode.length() == 1) {
            firstCharacter = facilityTypeCode.charAt(0);
            secondCharacter = null;
        } else {
            firstCharacter = facilityTypeCode.charAt(0);
            secondCharacter = facilityTypeCode.charAt(1);
        }
        return evaluateFacilityTypeCodeTwoChacracters(firstCharacter, secondCharacter, facilityTypeCode.length());

    }

    private static String getFacilityTypeCodeWithOutLeadingZero(String facilityTypeCode) {
        Pattern pattern = Pattern.compile("^(0?)(\\w*)$");
        Matcher matcher = pattern.matcher(facilityTypeCode);
        String result = null;
        while (matcher.find()) {
            result = matcher.group(2);
        }
        if (result == null) {
            return null;
        }
        return result;
    }

    private static Integer evaluateFacilityTypeCodeTwoChacracters(Character firstCharacter, Character secondCharacter, int facilityTypeCodeLength) {
        if (Character.isLetter(firstCharacter) || (secondCharacter != null && Character.isLetter(secondCharacter))) {
            return UNDETERMINED;
        }
        switch (firstCharacter) {
            case ('1'):
            case ('2'):
                return facilityTypeCodeLength == 1 ? null : evaluateFacilityTypeCodeSecondCharacter(secondCharacter);
            case ('3'):
            case ('4'):
            case ('5'):
            case ('9'):
                return UNDETERMINED;
            case ('6'):
            case ('7'):
            case ('8'):
                return OUTPATIENT;
            default:
                return null;
        }

    }

    private static Integer evaluateFacilityTypeCodeSecondCharacter(Character secondCharacter) {
        switch (secondCharacter) {
            case ('1'):
            case ('2'):
                return INPATIENT;
            case ('3'):
            case ('4'):
            case ('5'):
            case ('6'):
                return OUTPATIENT;
            case ('7'):
            case ('8'):
            case ('9'):
                return UNDETERMINED;
            default:
                return null;
        }
    }

    public static String getInnoRemits() {
        URL url = Resources.getResource("RemitQuery.json");
        String jsonText = null;
        try {
            jsonText = Resources.toString(url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        JsonElement queryJson = gson.fromJson(jsonText, JsonElement.class);
        JsonElement sourceElement = queryJson.getAsJsonObject().get("_source");
        System.out.println(queryJson);
        System.out.println();
        sourceElement.getAsJsonArray().add("producedDate");

        // System.out.println(sourceElement);
        // System.out.println(jsonText);
        JsonArray jsonArray = queryJson.getAsJsonObject().get("query").getAsJsonObject().get("bool").getAsJsonObject().get("must").getAsJsonArray();

        for (JsonElement jsonElement : jsonArray) {
            JsonElement rangeJElement = jsonElement.getAsJsonObject().get("range");
            if (rangeJElement != null) {
                JsonElement dateFromElement = rangeJElement.getAsJsonObject().get("servicePaymentInformations.dateOfService.dateOfServiceFrom");
                JsonElement dateToElement = rangeJElement.getAsJsonObject().get("servicePaymentInformations.dateOfService.dateOfServiceTo");
                if (dateFromElement != null) {
                    dateFromElement.getAsJsonObject().addProperty("gte", 1232432l);
                }
                if (dateToElement != null) {
                    dateToElement.getAsJsonObject().addProperty("lte", 123131);
                }
            }
        }

        JsonObject rangeJsonObject = new JsonObject();
        JsonObject producedDate = new JsonObject();
        JsonObject condition = new JsonObject();

        condition.addProperty("gte", 1232);
        condition.addProperty("lte", 12321313);
        producedDate.add("producedDate", condition);
        rangeJsonObject.add("range", producedDate);
        jsonArray.add(rangeJsonObject);

        System.out.println(jsonArray);
        System.out.println(queryJson);
        String resultText = queryJson.toString();
        System.out.println(resultText);
        System.out.println(jsonText);
        return jsonText;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for(int i=0; i< nums.length; i++) {
            if(nums[i] == 1){
                count++;
            }
            else if( nums[i] == 0){

                System.out.println("else if count " + count);
                System.out.println("else if max " + max);
                if(count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        if(count > max) {
            System.out.println("final if count" + count);
            return count;
        }

        return max;
    }

    static int getPairsCount(int n, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int arr[] = new int[]{1, 3, 7, -1, 3} ;
        // Store counts of all elements in map hm
        for (int i = 0; i < n; i++) {

            // initializing value to 0, if key not found
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);

            hm.put(arr[i], hm.get(arr[i]) + 1);
        }

        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i=0; i<n; i++)
        {
            if(hm.get(sum-arr[i]) != null)
                twice_count += hm.get(sum-arr[i]);

            // if (arr[i], arr[i]) pair satisfies the condition,
            // then we need to ensure that the count is
            // decreased by one such that the (arr[i], arr[i])
            // pair is not considered
            if (sum-arr[i] == arr[i])
                twice_count--;
        }
        return twice_count/2;

    }
    }