package lettersequences;

public class KeyBoard {

    public static void main(String[] args) {
        System.out.println(minimumDistance("HAPPY"));
    }

    public static int minimumDistance(String word) {
        int total = 0;
        int save = 0;
        int[] saveDis = new int[26];
        for(int i=0; i<word.length()-1; i++) {
            int[] prev = getPosition(word.charAt(i));
            int[] pos = getPosition(word.charAt(i+1));
            int charID = Math.abs(word.charAt(i) - 'A');
            for(int j=0; j<26; j++) {
                
                //saveDis[i]  previously saved by using left hand
                int[]  jPos = getPosition(j);
                int dis1 = getDistance(prev, pos);
                int dis2 = getDistance(jPos, pos);
                int diffDis =  dis1 - dis2;

                int couldSave = saveDis[j] + diffDis; //can save if used left hand

                saveDis[charID] = couldSave>saveDis[charID]? couldSave:saveDis[charID];
            }

            save  = saveDis[charID]>save ? saveDis[charID] : save;
            total += getDistance(prev, pos);
        }
        return total-save;
    }

    

    public static int[] getPosition(char c){
        int[] pos = new int[2];
        pos[0] = (Math.abs(c-'A') / 6);
        pos[1] = (Math.abs(c-'A') % 6);
        return pos;
    }

    public static int[] getPosition(int i){
        int[] pos = new int[2];
        pos[0] = (i / 6);
        pos[1] = (i % 6);
        return pos;
    }
    
    public static int getDistance(int[] pos1, int[] pos2){
        return (Math.abs(pos1[0]-pos2[0])) + (Math.abs(pos1[1]-pos2[1]));
    }
}

