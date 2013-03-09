
def getMaxSubsequence(arr) {
    def maxFrom = [];
    def getMax = { Integer start, end ->
        def len = end-start+1, x1, maxSkip1, maxSkip2;

        if (!maxFrom[start]) {
            if (len<1) {
                return 0;
            } else if (len==1) {
                return arr[start];
            } else if (len==2) {
                return Math.max(arr[start],arr[end]);
            } else {
                x1 = arr[start]
                maxSkip1 = getMax(start+1,end)
                maxSkip2 = getMax(start+2,end)
                maxFrom[start] = Math.max(x1+maxSkip2,maxSkip1)
            }
        }
        return maxFrom[start]
    }

    return getMax(0, arr.size() - 1);
}

getMaxSubsequence([1,2,3,4,5,6])