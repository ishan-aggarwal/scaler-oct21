package first;
public class BusDilemmaOld {
    public int solve(int[] A, int B) {
        
        int ans = 0;
        int n = A.length;
        
        // base case 1
        if (n == 1) {
            if (A[0] > B) {
                return ans;
            } else if (A[0] >= 0) {
                return (B - A[0] + 1);
            } else if ((-1 * A[0]) > B) {
                return ans;
            } else {
                return (B + A[0] + 1);
            }
        }
        
        long totalPeople[] = new long[n];
        
        totalPeople[0] = A[0];
        int maxPeopleAtAnyTime = A[0];
        for (int i = 1; i < n; i++) {
            totalPeople[i] = totalPeople[i - 1] + A[i];
            
            if (Math.abs(totalPeople[i]) < 0 || Math.abs(totalPeople[i]) > B) {
                return 0;
            }
            
            if (A[i] > maxPeopleAtAnyTime) {
                maxPeopleAtAnyTime = A[i];
            }
        }
        
        long minPeople = Integer.MAX_VALUE;
        long maxPeople = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (totalPeople[i] < minPeople) {
                minPeople = totalPeople[i];
            }
            
            if (totalPeople[i] > maxPeople) {
                maxPeople = totalPeople[i];
            }
        }
        
        if (minPeople < 0) {
            // return B + (int) minPeople + 1;
            ans =  Math.min ( B - maxPeopleAtAnyTime + 1 , B + (int) minPeople + 1);
            if (ans < 0) {
                return 0;
            } else {
                return ans;
            }
        }
        
        int poss2 =  B - (int) maxPeople + 1;
        ans =  Math.min ( B - maxPeopleAtAnyTime + 1 , poss2);
        if (ans < 0) {
            return 0;
        } else {
            return ans;
        }

    }
}
