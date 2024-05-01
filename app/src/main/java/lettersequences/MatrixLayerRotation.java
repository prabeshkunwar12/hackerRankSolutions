package lettersequences;

import java.util.ArrayList;
import java.util.List;

public class MatrixLayerRotation {
    public static void main(String[] args) {
        matrixRotation(new ArrayList<>(
                List.of(
                        new ArrayList<>(
                                List.of(9718805, 60013003, 5103628, 85388216, 21884498, 38021292, 73470430, 31785927)),
                        new ArrayList<>(
                                List.of(69999937, 71783860, 10329789, 96382322, 71055337, 30247265, 96087879,
                                        93754371)),
                        new ArrayList<>(
                                List.of(79943507, 75398396, 38446081, 34699742, 1408833, 51189, 17741775, 53195748)),
                        new ArrayList<>(
                                List.of(79354991, 26629304, 86523163, 67042516, 54688734, 54630910, 6967117, 90198864)),
                        new ArrayList<>(
                                List.of(84146680, 27762534, 6331115, 5932542, 29446517, 15654690, 92837327, 91644840)),
                        new ArrayList<>(
                                List.of(58623600, 69622764, 2218936, 58592832, 49558405, 17112485, 38615864, 32720798)),
                        new ArrayList<>(
                                List.of(49469904, 5270000, 32589026, 56425665, 23544383, 90502426, 63729346, 35319547)),
                        new ArrayList<>(
                                List.of(20888810, 97945481, 85669747, 88915819, 96642353, 42430633, 47265349,
                                        89653362)),
                        new ArrayList<>(
                                List.of(55349226, 10844931, 25289229, 90786953, 22590518, 54702481, 71197978,
                                        50410021)),
                        new ArrayList<>(
                                List.of(9392211, 31297360, 27353496, 56239301, 7071172, 61983443, 86544343,
                                        43779176)))),
                40);

    }

    /**
     * @param matrix
     * @param r
     * # -> current position
     * $ -> target element
     * r -> 8
     *        level   nLevelMin    jPos  
     *           |       |           | 
     *           V       V           V
     *       *   *   *   *   *   *   *   *
     *       *   -   -   #   -   -   -   * <-- mLevelMin, level
     *       *   -   *   *   *   *   -   *
     *       *   -   *   *   *   *   -   *
     *       *   -   *   *   *   *   -   *
     *       *   -   *   *   *   *   -   *
     *       *   -   *   *   *   *   $   * <-- iPos
     *       *   -   *   *   *   *   -   *
     *       *   -   -   -   -   -   -   * <-- mLevelMax
     *       *   *   *   *   *   *   *   *
     *                               ^
     *                               |    
     *                            nLevelMax
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        // Write your code here
        int m = matrix.size() - 1;
        int n = matrix.get(0).size() - 1;
        List<List<Integer>> returnArr = new ArrayList<>();

        for (int i = 0; i <= m; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                int mLevelMin = Math.min(i, Math.abs(i - m)); //lowest level in y axis
                int nLevelMin = Math.min(j, Math.abs(j - n)); //lowest level in x axis
                int level = Math.min(mLevelMin, nLevelMin); 
                int mLevelMax = m - level; 
                int nLevelMax = n - level; // starting of level (level, level) and end of level (mLevelMax, nLevelMax)
                int ringSize = 2 * (mLevelMax + nLevelMax - 2 * level); //ringsize = 2(length + breadth - 2)
                int actRot = r % ringSize; //finding min rotation to achive the goal

                int iPos = i;  // (iPos, jPos) is the position of target element
                int jPos = j;

                while (actRot > 0) {
                    if (iPos == level && jPos < nLevelMax) { //to right
                        if (jPos + actRot > nLevelMax) {
                            actRot -= nLevelMax - jPos;
                            jPos = nLevelMax;
                        } else {
                            jPos += actRot;
                            actRot = 0;
                        }
                    } else if (jPos == nLevelMax && iPos < mLevelMax) {//going down
                        if (iPos + actRot > mLevelMax) {
                            actRot -= mLevelMax - iPos;
                            iPos = mLevelMax;
                        } else {
                            iPos += actRot;
                            actRot = 0;
                        }
                    } else if (iPos == mLevelMax && jPos > level) {//to left
                        if (jPos - actRot < level) {
                            actRot -= jPos - level;
                            jPos = level;
                        } else {
                            jPos -= actRot;
                            actRot = 0;
                        }
                    } else {//going up
                        if (iPos - actRot < level) {
                            actRot -= iPos - level;
                            iPos = level;
                        } else {
                            iPos -= actRot;
                            actRot = 0;
                        }
                    }
                }

                arr.add(matrix.get(iPos).get(jPos));
            }
            returnArr.add(arr);
        }
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                System.out.printf("%d ", returnArr.get(i).get(j));
            }
            System.out.printf("%n");
        }
    }
}
