/**
 * 
 */
let deptUrl = "http://localhost:8080/FrontController/api/departments";
	
function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			callback(this);
		}
		
	}
	xhr.send();
	
}

function displayOptions(xhr){
	let departments = JSON.parse(xhr.response);
	
	let deptSelect = document.getElementById("dptSelect");
	
	for(let dept of departments){
		let newOption = document.createElement("option");
		newOption.value = dept.id;
		newOption.innerHTML = dept.name;
		deptSelect.appendChild(newOption);
	}
}

sendAjaxGet(deptUrl, displayOptions);