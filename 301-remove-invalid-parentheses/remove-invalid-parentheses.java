import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        // Find minimum number of removals needed
        int leftRemove = 0;
        int rightRemove = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                leftRemove++;
            }
            else if (c == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                }
                else {
                    rightRemove++;
                }
            }
        }

        Set<String> set = new HashSet<>();

        dfs(
            s,
            0,
            0,
            0,
            leftRemove,
            rightRemove,
            new StringBuilder(),
            set
        );

        ans.addAll(set);

        return ans;
    }

    private void dfs(
        String s,
        int index,
        int left,
        int right,
        int leftRemove,
        int rightRemove,
        StringBuilder current,
        Set<String> set
    ) {

        // If we have processed the complete string
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                left == right) {

                set.add(current.toString());
            }

            return;
        }

        char c = s.charAt(index);

        // -------------------------
        // OPTION 1: REMOVE
        // -------------------------

        if (c == '(' && leftRemove > 0) {

            dfs(
                s,
                index + 1,
                left,
                right,
                leftRemove - 1,
                rightRemove,
                current,
                set
            );
        }

        if (c == ')' && rightRemove > 0) {

            dfs(
                s,
                index + 1,
                left,
                right,
                leftRemove,
                rightRemove - 1,
                current,
                set
            );
        }

        // -------------------------
        // OPTION 2: KEEP
        // -------------------------

        current.append(c);

        if (c == '(') {

            dfs(
                s,
                index + 1,
                left + 1,
                right,
                leftRemove,
                rightRemove,
                current,
                set
            );

        }
        else if (c == ')') {

            // We can keep ')' only if
            // there is an unmatched '('
            if (left > right) {

                dfs(
                    s,
                    index + 1,
                    left,
                    right + 1,
                    leftRemove,
                    rightRemove,
                    current,
                    set
                );
            }

        }
        else {

            // Letter
            dfs(
                s,
                index + 1,
                left,
                right,
                leftRemove,
                rightRemove,
                current,
                set
            );
        }

        // Backtrack
        current.deleteCharAt(current.length() - 1);
    }
}