import java.util.*;
public class Substring {

// Section 1 Find the longest substring

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The String :");
        String s = sc.nextLine(); 
        int n = s.length();
        int maxLength = 0;

        for (int i=0 ; i<n ; i++) {
            for (int j = i; j < n; j++) {
                   boolean isUnique = true;
                 for (int k = i; k <= j; k++) {
                     for (int l = k +1; l<=j; l++) {
                         if (s.charAt(k) == s.charAt(l)) {
                            isUnique = false;
                             break;
                        }
                    }
                    if (!isUnique) break;
                }

                if (isUnique) {
                    int len = j - i + 1;
                    if (len > maxLength) {
                        maxLength=len;
                    }
                }
            }
        }

        System.out.println("The length of the substring is : " + maxLength);
    }
}
