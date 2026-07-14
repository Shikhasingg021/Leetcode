class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        int mn = nums[0], mx = nums[0];

        unordered_set<int> s;

        // Find minimum, maximum and store elements
        for (int x : nums) {
            mn = min(mn, x);
            mx = max(mx, x);
            s.insert(x);
        }

        vector<int> ans;

        // Check every number between min and max
        for (int i = mn + 1; i < mx; i++) {
            if (s.find(i) == s.end()) {
                ans.push_back(i);
            }
        }

        return ans;
    }
};