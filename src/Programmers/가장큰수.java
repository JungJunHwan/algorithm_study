package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    public static String main(String[] args) {
        int[] numbers = {6,10,2};
//        int[] numbers = {3, 30, 34, 5, 9};

//        숫자를 문자열로 변환
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

//        정렬
////        방법 1
//        Arrays.sort(result, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return ((o2 + o1).compareTo(o1 + o2));
//            }
//        });

////        방법 2 : 오버라이딩을 간략화 하기 위한 람다식
//        Comparator<String> comp = (o1, o2) -> (o2 + o1).compareTo(o1 + o2);
//        Arrays.sort(result, comp);

//        방법 3 : 더 간략화
        Arrays.sort(result, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

//        0만 여러개 있을 경우 0 리턴, 정렬 후 0이 제일 배열의 가장 앞에 있다면 전부가 0인것으로 생각할 수 있음
        if(result[0].equals("0")){
            return "0";
        }

        String answer = "";
//        정렬된 문자 합치기
        StringBuilder sb = new StringBuilder();
        for(String n : result){
            sb.append(n);
        }
        answer = sb.toString();
        return answer;
    }
}
