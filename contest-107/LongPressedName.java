class Solution {
    public boolean isLongPressedName(String name, String typed) {
        // just keep track of each letter's repetition in name
        List<Character> letters = new ArrayList<>();
        List<Integer> repetitions = new ArrayList<>();
        
        if (name.length() == 0) {
            return typed.length() == 0;
        }
        
        char cur = name.charAt(0);
        int nRep = 1;
        for (int i = 1; i < name.length(); i++) {
            if(name.charAt(i) != cur) {
                if (nRep > 0) {
                    letters.add(cur);
                    repetitions.add(nRep);
                }
                cur = name.charAt(i);
                nRep = 1;
            } else {
                nRep++;
            }
        }
        letters.add(cur);
        repetitions.add(nRep);
        
        System.out.println(letters.toString());
        System.out.println(repetitions.toString());
        if(letters.size() == 0) {
            return typed.length() == 0;
        }
        
        cur = typed.charAt(0);
        nRep = 1;
        int idx = 0;
        for (int i = 1; i < typed.length(); i++) {
            if (typed.charAt(i) != cur) {
                System.out.println("current i " + i);
                System.out.println("idx " + idx + " letter: " + cur + " nRep: " + nRep);
                // compare
                if (letters.get(idx) != cur || repetitions.get(idx) > nRep) {
                    
                    return false;
                }
                cur = typed.charAt(i);
                nRep = 1;
                idx++;
            } else {
                nRep ++;
            }
        }
        if (letters.get(idx) != cur || repetitions.get(idx) > nRep) {
            return false;
        }
        return idx == letters.size() - 1;
    }
}