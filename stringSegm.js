var input = 'thistextisshorter';
var dict = ['this', 'text', 'is', 'short', 'shorter'];

function stringSeg(input, dict){
	if(dict.indexOf(input) !== -1) return input;
	var l = input.length;
	for(var i = 0; i < l; i++){
		var prefix = input.substr(0, i);
		if(dict.indexOf(prefix) !== -1){
			console.log('prefix found: ' + prefix);
			var sub_input = input.substr(i, l);
			console.log('looking for suffix in "' +sub_input+'"...');
			var suffix = stringSeg(sub_input, dict);
			
			if(suffix) return prefix + ' ' + suffix;
		}
	}
	return null;
}

console.log(stringSeg(input, dict));