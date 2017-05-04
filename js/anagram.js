// Assuming word are not null!

var word1 = 'azer';
var word2 = 'azed';

var res = false;
if(word1.length === word2.length){
	res = word1.split('').every((c) => {
		return word2.indexOf(c) !== -1;
	});
}

console.log(res);