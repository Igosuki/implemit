long long int toint(string s, int i, int j){
	long long int n=0;
	for(int start=i; start <= j; start++){
		n=n*10+(s[start]-'0');
	}
	return n;
}
lim=s.length();
dp[lim][lim][sum+1];

initialize:
for(int i=0; i < lim; i++){
	for(int j=0; j < lim; j++){
		for(int k=0; k <= sum; k++){
			dp[i][j][k]=11;
		}}}
for(int size=0; size < lim; size++){
	for(int start=0; start+size < lim; start++){
		long long int num=toint(s,start,start+size);
		if(num <= sum){
			dp[start][start+size][num]=0;
		}
	}
}

for(int size=1; size < lim; size++){
	for(int start=0; start+size < lim; start++){
		for(int s=0; s <= sum; s++){
			for(int k=start; k < start+size; k++){
				for(int ss=0; s-ss > 0; ss++)

				dp[start][start+size][s]=min((dp[start][k][s-ss]+dp[k+1][start+size][ss])+1,dp[start][start+size][s]);
			}}}}

int ans=dp[0][lim-1][sum];
if ans is 11 return -1;
otherwise return ans;