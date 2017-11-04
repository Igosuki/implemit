var fs = require('fs');
//Quickest naive algorithm, not implementing Fermat
var array = [2];
var init = 3;
var N = 10000;
while(array.length < 100) {
	for(var i = init; i < Math.ceil(Math.sqrt(process.argv[2] ? process.argv[2] : N)) && array.length < 100; i += 2) {
		var isPrime = true;
		for(var j = 0; j < array.length; j ++) {
			if(i % array[j] == 0) {
				isPrime = false;
				break;
			}
		}
		if(isPrime) 
			array.push(i);
	}
	i = N;
	N += N;
}
fs.writeFile('primes.txt', array.join(","), function(err) {
	console.log(err ? err : "Wrote content to : primes.txt");
});
