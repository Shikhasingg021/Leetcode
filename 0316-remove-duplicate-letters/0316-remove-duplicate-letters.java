
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        boolean[] visited = new boolean[26];

        // Store the last occurrence of every character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Skip if character is already present
            if (visited[ch - 'a']) {
                continue;
            }

            // Remove larger characters if they appear again later
            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch &&
                   last[stack.charAt(stack.length() - 1) - 'a'] > i) {

                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);

                visited[removed - 'a'] = false;
            }

            stack.append(ch);
            visited[ch - 'a'] = true;
        }

        return stack.toString();
    }
}
