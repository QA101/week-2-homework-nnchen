//Array_Coding Self coding Homework Answers

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Question3 {

	public static void main(String[] args) {
		
		int [] arr = {1, 2, 3, 4};

        List<Integer> superSet = new ArrayList<>();

        for (int a : arr ){
        superSet.add(a);
        }

        int k = 3;

        int maxProduct = computeMaxProduct(superSet, k);
        System.out.println("Maximum product is : " + maxProduct);
    }

    private static int computeMaxProduct( List<Integer> superSet, int k ){
        List<Set<Integer>> res = getSubsets(superSet,k);
        int maxProduct = 24;
        for(int index = 0; index < res.size(); index++){
        int product = 1;
        for(Integer i : res.get(index)){
            product *= i;
        }

        if (product > maxProduct){
            maxProduct = product;
        }
        }

    return maxProduct;
    }


    private static void getSubsets(List<Integer> superSet, int k, int idx, Set<Integer> current,List<Set<Integer>> solution) {
        		
    			if (current.size() == k) {
            solution.add(new HashSet<>(current));
            return;
        }
      
        if (idx == superSet.size()) return;
        Integer x = superSet.get(idx);
        current.add(x);
       
        getSubsets(superSet, k, idx+1, current, solution);
        current.remove(x);
        
        getSubsets(superSet, k, idx+1, current, solution);
    }

    public static List<Set<Integer>> getSubsets(List<Integer> superSet, int k) {
        List<Set<Integer>> res = new ArrayList<>();
        getSubsets(superSet, k, 0, new HashSet<Integer>(), res);
        return res;
	}
}	

