package java;

public class VersionControlII {

    public boolean isBadVersion(int n) {
        return n >= 30;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
                if (end > 1 && !isBadVersion(end-1)) {
                    return end;
                }
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        VersionControlII versionControlII = new VersionControlII();
        System.out.println(versionControlII.firstBadVersion(100));
    }
}
